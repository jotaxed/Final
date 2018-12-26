package com.google.android.gms.internal;

import com.google.android.gms.internal.da.a;

@ey
public final class ct extends a {
    private final Object mH = new Object();
    private cv.a qD;
    private cs qE;

    public void a(cs csVar) {
        synchronized (this.mH) {
            this.qE = csVar;
        }
    }

    public void a(cv.a aVar) {
        synchronized (this.mH) {
            this.qD = aVar;
        }
    }

    public void onAdClicked() {
        synchronized (this.mH) {
            if (this.qE != null) {
                this.qE.ai();
            }
        }
    }

    public void onAdClosed() {
        synchronized (this.mH) {
            if (this.qE != null) {
                this.qE.aj();
            }
        }
    }

    public void onAdFailedToLoad(int error) {
        synchronized (this.mH) {
            if (this.qD != null) {
                this.qD.k(error == 3 ? 1 : 2);
                this.qD = null;
            }
        }
    }

    public void onAdLeftApplication() {
        synchronized (this.mH) {
            if (this.qE != null) {
                this.qE.ak();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onAdLoaded() {
        /*
        r3 = this;
        r1 = r3.mH;
        monitor-enter(r1);
        r0 = r3.qD;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x0012;
    L_0x0007:
        r0 = r3.qD;	 Catch:{ all -> 0x001d }
        r2 = 0;
        r0.k(r2);	 Catch:{ all -> 0x001d }
        r0 = 0;
        r3.qD = r0;	 Catch:{ all -> 0x001d }
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
    L_0x0011:
        return;
    L_0x0012:
        r0 = r3.qE;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x001b;
    L_0x0016:
        r0 = r3.qE;	 Catch:{ all -> 0x001d }
        r0.am();	 Catch:{ all -> 0x001d }
    L_0x001b:
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
        goto L_0x0011;
    L_0x001d:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ct.onAdLoaded():void");
    }

    public void onAdOpened() {
        synchronized (this.mH) {
            if (this.qE != null) {
                this.qE.al();
            }
        }
    }
}
