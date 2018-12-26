package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.s;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AdvertisingIdClient {
    com.google.android.gms.common.a ln;
    s lo;
    boolean lp;
    Object lq;
    a lr;
    final long ls;
    private final Context mContext;

    public static final class Info {
        private final String lx;
        private final boolean ly;

        public Info(String advertisingId, boolean limitAdTrackingEnabled) {
            this.lx = advertisingId;
            this.ly = limitAdTrackingEnabled;
        }

        public String getId() {
            return this.lx;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.ly;
        }

        public String toString() {
            return "{" + this.lx + "}" + this.ly;
        }
    }

    static class a extends Thread {
        private WeakReference<AdvertisingIdClient> lt;
        private long lu;
        CountDownLatch lv = new CountDownLatch(1);
        boolean lw = false;

        public a(AdvertisingIdClient advertisingIdClient, long j) {
            this.lt = new WeakReference(advertisingIdClient);
            this.lu = j;
            start();
        }

        private void disconnect() {
            AdvertisingIdClient advertisingIdClient = (AdvertisingIdClient) this.lt.get();
            if (advertisingIdClient != null) {
                advertisingIdClient.finish();
                this.lw = true;
            }
        }

        public boolean aa() {
            return this.lw;
        }

        public void cancel() {
            this.lv.countDown();
        }

        public void run() {
            try {
                if (!this.lv.await(this.lu, TimeUnit.MILLISECONDS)) {
                    disconnect();
                }
            } catch (InterruptedException e) {
                disconnect();
            }
        }
    }

    public AdvertisingIdClient(Context context) {
        this(context, 30000);
    }

    public AdvertisingIdClient(Context context, long timeoutInMillis) {
        this.lq = new Object();
        jx.i(context);
        this.mContext = context;
        this.lp = false;
        this.ls = timeoutInMillis;
    }

    private void Z() {
        synchronized (this.lq) {
            if (this.lr != null) {
                this.lr.cancel();
                try {
                    this.lr.join();
                } catch (InterruptedException e) {
                }
            }
            if (this.ls > 0) {
                this.lr = new a(this, this.ls);
            }
        }
    }

    static s a(Context context, com.google.android.gms.common.a aVar) throws IOException {
        try {
            return com.google.android.gms.internal.s.a.b(aVar.gs());
        } catch (InterruptedException e) {
            throw new IOException("Interrupted exception");
        }
    }

    public static Info getAdvertisingIdInfo(Context context) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1);
        try {
            advertisingIdClient.b(false);
            Info info = advertisingIdClient.getInfo();
            return info;
        } finally {
            advertisingIdClient.finish();
        }
    }

    static com.google.android.gms.common.a h(Context context) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        try {
            context.getPackageManager().getPackageInfo(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE, 0);
            try {
                GooglePlayServicesUtil.C(context);
                Object aVar = new com.google.android.gms.common.a();
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE);
                if (context.bindService(intent, aVar, 1)) {
                    return aVar;
                }
                throw new IOException("Connection failure");
            } catch (Throwable e) {
                throw new IOException(e);
            }
        } catch (NameNotFoundException e2) {
            throw new GooglePlayServicesNotAvailableException(9);
        }
    }

    protected void b(boolean z) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        jx.aV("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.lp) {
                finish();
            }
            this.ln = h(this.mContext);
            this.lo = a(this.mContext, this.ln);
            this.lp = true;
            if (z) {
                Z();
            }
        }
    }

    protected void finalize() throws Throwable {
        finish();
        super.finalize();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void finish() {
        /*
        r3 = this;
        r0 = "Calling this from your main thread can lead to deadlock";
        com.google.android.gms.internal.jx.aV(r0);
        monitor-enter(r3);
        r0 = r3.mContext;	 Catch:{ all -> 0x0026 }
        if (r0 == 0) goto L_0x000e;
    L_0x000a:
        r0 = r3.ln;	 Catch:{ all -> 0x0026 }
        if (r0 != 0) goto L_0x0010;
    L_0x000e:
        monitor-exit(r3);	 Catch:{ all -> 0x0026 }
    L_0x000f:
        return;
    L_0x0010:
        r0 = r3.lp;	 Catch:{ IllegalArgumentException -> 0x0029 }
        if (r0 == 0) goto L_0x001b;
    L_0x0014:
        r0 = r3.mContext;	 Catch:{ IllegalArgumentException -> 0x0029 }
        r1 = r3.ln;	 Catch:{ IllegalArgumentException -> 0x0029 }
        r0.unbindService(r1);	 Catch:{ IllegalArgumentException -> 0x0029 }
    L_0x001b:
        r0 = 0;
        r3.lp = r0;	 Catch:{ all -> 0x0026 }
        r0 = 0;
        r3.lo = r0;	 Catch:{ all -> 0x0026 }
        r0 = 0;
        r3.ln = r0;	 Catch:{ all -> 0x0026 }
        monitor-exit(r3);	 Catch:{ all -> 0x0026 }
        goto L_0x000f;
    L_0x0026:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0026 }
        throw r0;
    L_0x0029:
        r0 = move-exception;
        r1 = "AdvertisingIdClient";
        r2 = "AdvertisingIdClient unbindService failed.";
        android.util.Log.i(r1, r2, r0);	 Catch:{ all -> 0x0026 }
        goto L_0x001b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.identifier.AdvertisingIdClient.finish():void");
    }

    public Info getInfo() throws IOException {
        Info info;
        jx.aV("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.lp) {
                synchronized (this.lq) {
                    if (this.lr == null || !this.lr.aa()) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    b(false);
                    if (!this.lp) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (Throwable e) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e);
                    throw new IOException("Remote exception");
                } catch (Throwable e2) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                }
            }
            jx.i(this.ln);
            jx.i(this.lo);
            info = new Info(this.lo.getId(), this.lo.c(true));
        }
        Z();
        return info;
    }

    public void start() throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        b(true);
    }
}
