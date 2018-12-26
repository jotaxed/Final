package com.google.android.gms.wearable;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import com.google.android.gms.wearable.internal.ai;
import com.google.android.gms.wearable.internal.al;

public abstract class WearableListenerService extends Service implements DataListener, MessageListener, NodeListener {
    public static final String BIND_LISTENER_INTENT_ACTION = "com.google.android.gms.wearable.BIND_LISTENER";
    private String CS;
    private IBinder Nk;
    private volatile int Pj = -1;
    private Handler axn;
    private Object axo = new Object();
    private boolean axp;

    private class a extends com.google.android.gms.wearable.internal.ae.a {
        final /* synthetic */ WearableListenerService axq;

        private a(WearableListenerService wearableListenerService) {
            this.axq = wearableListenerService;
        }

        public void a(final ai aiVar) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onMessageReceived: " + aiVar);
            }
            this.axq.rl();
            synchronized (this.axq.axo) {
                if (this.axq.axp) {
                    return;
                }
                this.axq.axn.post(new Runnable(this) {
                    final /* synthetic */ a axs;

                    public void run() {
                        this.axs.axq.onMessageReceived(aiVar);
                    }
                });
            }
        }

        public void a(final al alVar) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onPeerConnected: " + this.axq.CS + ": " + alVar);
            }
            this.axq.rl();
            synchronized (this.axq.axo) {
                if (this.axq.axp) {
                    return;
                }
                this.axq.axn.post(new Runnable(this) {
                    final /* synthetic */ a axs;

                    public void run() {
                        this.axs.axq.onPeerConnected(alVar);
                    }
                });
            }
        }

        public void aa(final DataHolder dataHolder) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onDataItemChanged: " + this.axq.CS + ": " + dataHolder);
            }
            this.axq.rl();
            synchronized (this.axq.axo) {
                if (this.axq.axp) {
                    dataHolder.close();
                    return;
                }
                this.axq.axn.post(new Runnable(this) {
                    final /* synthetic */ a axs;

                    public void run() {
                        DataEventBuffer dataEventBuffer = new DataEventBuffer(dataHolder);
                        try {
                            this.axs.axq.onDataChanged(dataEventBuffer);
                        } finally {
                            dataEventBuffer.release();
                        }
                    }
                });
            }
        }

        public void b(final al alVar) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onPeerDisconnected: " + this.axq.CS + ": " + alVar);
            }
            this.axq.rl();
            synchronized (this.axq.axo) {
                if (this.axq.axp) {
                    return;
                }
                this.axq.axn.post(new Runnable(this) {
                    final /* synthetic */ a axs;

                    public void run() {
                        this.axs.axq.onPeerDisconnected(alVar);
                    }
                });
            }
        }
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

    private void rl() throws SecurityException {
        int callingUid = Binder.getCallingUid();
        if (callingUid != this.Pj) {
            if (GooglePlayServicesUtil.b(getPackageManager(), GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE) && bh(callingUid)) {
                this.Pj = callingUid;
                return;
            }
            throw new SecurityException("Caller is not GooglePlayServices");
        }
    }

    public final IBinder onBind(Intent intent) {
        return BIND_LISTENER_INTENT_ACTION.equals(intent.getAction()) ? this.Nk : null;
    }

    public void onCreate() {
        super.onCreate();
        if (Log.isLoggable("WearableLS", 3)) {
            Log.d("WearableLS", "onCreate: " + getPackageName());
        }
        this.CS = getPackageName();
        HandlerThread handlerThread = new HandlerThread("WearableListenerService");
        handlerThread.start();
        this.axn = new Handler(handlerThread.getLooper());
        this.Nk = new a();
    }

    public void onDataChanged(DataEventBuffer dataEvents) {
    }

    public void onDestroy() {
        synchronized (this.axo) {
            this.axp = true;
            this.axn.getLooper().quit();
        }
        super.onDestroy();
    }

    public void onMessageReceived(MessageEvent messageEvent) {
    }

    public void onPeerConnected(Node peer) {
    }

    public void onPeerDisconnected(Node peer) {
    }
}
