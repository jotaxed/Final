package com.google.android.gms.drive.events;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.drive.internal.OnEventResponse;
import com.google.android.gms.drive.internal.w;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class DriveEventService extends Service implements ChangeListener, CompletionListener {
    public static final String ACTION_HANDLE_EVENT = "com.google.android.gms.drive.events.HANDLE_EVENT";
    private CountDownLatch Pg;
    a Ph;
    boolean Pi;
    int Pj;
    private final String mName;

    final class a extends Handler {
        final /* synthetic */ DriveEventService Pl;

        a(DriveEventService driveEventService) {
            this.Pl = driveEventService;
        }

        private Message b(OnEventResponse onEventResponse) {
            return obtainMessage(1, onEventResponse);
        }

        private Message iE() {
            return obtainMessage(2);
        }

        public void handleMessage(Message msg) {
            w.m("DriveEventService", "handleMessage message type:" + msg.what);
            switch (msg.what) {
                case 1:
                    this.Pl.a((OnEventResponse) msg.obj);
                    return;
                case 2:
                    getLooper().quit();
                    return;
                default:
                    w.o("DriveEventService", "Unexpected message type:" + msg.what);
                    return;
            }
        }
    }

    final class b extends com.google.android.gms.drive.internal.ag.a {
        final /* synthetic */ DriveEventService Pl;

        b(DriveEventService driveEventService) {
            this.Pl = driveEventService;
        }

        public void c(OnEventResponse onEventResponse) throws RemoteException {
            synchronized (this.Pl) {
                w.m("DriveEventService", "onEvent: " + onEventResponse);
                this.Pl.iD();
                if (this.Pl.Ph != null) {
                    this.Pl.Ph.sendMessage(this.Pl.Ph.b(onEventResponse));
                } else {
                    w.p("DriveEventService", "Receiving event before initialize is completed.");
                }
            }
        }
    }

    protected DriveEventService() {
        this("DriveEventService");
    }

    protected DriveEventService(String name) {
        this.Pi = false;
        this.Pj = -1;
        this.mName = name;
    }

    private void a(OnEventResponse onEventResponse) {
        DriveEvent iQ = onEventResponse.iQ();
        w.m("DriveEventService", "handleEventMessage: " + iQ);
        try {
            switch (iQ.getType()) {
                case 1:
                    onChange((ChangeEvent) iQ);
                    return;
                case 2:
                    onCompletion((CompletionEvent) iQ);
                    return;
                default:
                    w.o(this.mName, "Unhandled event: " + iQ);
                    return;
            }
        } catch (Throwable e) {
            w.a(this.mName, e, "Error handling event: " + iQ);
        }
        w.a(this.mName, e, "Error handling event: " + iQ);
    }

    private boolean bh(int i) {
        String str = GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE;
        String[] packagesForUid = getPackageManager().getPackagesForUid(i);
        if (packagesForUid == null) {
            return false;
        }
        for (Object equals : packagesForUid) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    private void iD() throws SecurityException {
        int callingUid = getCallingUid();
        if (callingUid != this.Pj) {
            if (GooglePlayServicesUtil.b(getPackageManager(), GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE) && bh(callingUid)) {
                this.Pj = callingUid;
                return;
            }
            throw new SecurityException("Caller is not GooglePlayServices");
        }
    }

    protected int getCallingUid() {
        return Binder.getCallingUid();
    }

    public final synchronized IBinder onBind(Intent intent) {
        IBinder asBinder;
        if (ACTION_HANDLE_EVENT.equals(intent.getAction())) {
            if (this.Ph == null && !this.Pi) {
                this.Pi = true;
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                this.Pg = new CountDownLatch(1);
                new Thread(this) {
                    final /* synthetic */ DriveEventService Pl;

                    public void run() {
                        try {
                            Looper.prepare();
                            this.Pl.Ph = new a(this.Pl);
                            this.Pl.Pi = false;
                            countDownLatch.countDown();
                            w.m("DriveEventService", "Bound and starting loop");
                            Looper.loop();
                            w.m("DriveEventService", "Finished loop");
                        } finally {
                            if (this.Pl.Pg != null) {
                                this.Pl.Pg.countDown();
                            }
                        }
                    }
                }.start();
                try {
                    if (!countDownLatch.await(5000, TimeUnit.MILLISECONDS)) {
                        w.p("DriveEventService", "Failed to synchronously initialize event handler.");
                    }
                } catch (Throwable e) {
                    throw new RuntimeException("Unable to start event handler", e);
                }
            }
            asBinder = new b(this).asBinder();
        } else {
            asBinder = null;
        }
        return asBinder;
    }

    public void onChange(ChangeEvent event) {
        w.o(this.mName, "Unhandled change event: " + event);
    }

    public void onCompletion(CompletionEvent event) {
        w.o(this.mName, "Unhandled completion event: " + event);
    }

    public synchronized void onDestroy() {
        w.m("DriveEventService", "onDestroy");
        if (this.Ph != null) {
            this.Ph.sendMessage(this.Ph.iE());
            this.Ph = null;
            try {
                if (!this.Pg.await(5000, TimeUnit.MILLISECONDS)) {
                    w.o("DriveEventService", "Failed to synchronously quit event handler. Will quit itself");
                }
            } catch (InterruptedException e) {
            }
            this.Pg = null;
        }
        super.onDestroy();
    }

    public boolean onUnbind(Intent intent) {
        return true;
    }
}
