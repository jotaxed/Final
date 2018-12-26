package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;
import com.google.ads.mediation.admob.AdMobAdapter;

@ey
public class fd extends gf implements com.google.android.gms.internal.gv.a {
    private final cy lA;
    private final Context mContext;
    private final Object mH = new Object();
    private final gu mo;
    private cr qi;
    private final com.google.android.gms.internal.fc.a tA;
    private final com.google.android.gms.internal.fy.a tB;
    private boolean tC = false;
    private cp tD;
    private cv tE;
    private final Object tj = new Object();
    private fj tn;

    private static final class a extends Exception {
        private final int tq;

        public a(String str, int i) {
            super(str);
            this.tq = i;
        }

        public int getErrorCode() {
            return this.tq;
        }
    }

    public fd(Context context, com.google.android.gms.internal.fy.a aVar, gu guVar, cy cyVar, com.google.android.gms.internal.fc.a aVar2) {
        this.mContext = context;
        this.tB = aVar;
        this.tn = aVar.vK;
        this.mo = guVar;
        this.lA = cyVar;
        this.tA = aVar2;
        this.qi = aVar.vE;
    }

    private void a(fh fhVar, long j) throws a {
        synchronized (this.tj) {
            this.tD = new cp(this.mContext, fhVar, this.lA, this.qi);
        }
        this.tE = this.tD.a(j, 60000);
        switch (this.tE.qO) {
            case 0:
                return;
            case 1:
                throw new a("No fill from any mediation ad networks.", 3);
            default:
                throw new a("Unexpected mediation result: " + this.tE.qO, 0);
        }
    }

    private boolean c(long j) throws a {
        long elapsedRealtime = 60000 - (SystemClock.elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.mH.wait(elapsedRealtime);
            return true;
        } catch (InterruptedException e) {
            throw new a("Ad request cancelled.", -1);
        }
    }

    private void f(long j) throws a {
        gq.wR.post(new Runnable(this) {
            final /* synthetic */ fd tF;

            {
                this.tF = r1;
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                r7 = this;
                r0 = r7.tF;
                r6 = r0.mH;
                monitor-enter(r6);
                r0 = r7.tF;	 Catch:{ all -> 0x005f }
                r0 = r0.tn;	 Catch:{ all -> 0x005f }
                r0 = r0.errorCode;	 Catch:{ all -> 0x005f }
                r1 = -2;
                if (r0 == r1) goto L_0x0014;
            L_0x0012:
                monitor-exit(r6);	 Catch:{ all -> 0x005f }
            L_0x0013:
                return;
            L_0x0014:
                r0 = r7.tF;	 Catch:{ all -> 0x005f }
                r0 = r0.mo;	 Catch:{ all -> 0x005f }
                r0 = r0.dD();	 Catch:{ all -> 0x005f }
                r1 = r7.tF;	 Catch:{ all -> 0x005f }
                r0.a(r1);	 Catch:{ all -> 0x005f }
                r0 = r7.tF;	 Catch:{ all -> 0x005f }
                r0 = r0.tn;	 Catch:{ all -> 0x005f }
                r0 = r0.errorCode;	 Catch:{ all -> 0x005f }
                r1 = -3;
                if (r0 != r1) goto L_0x0062;
            L_0x002e:
                r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x005f }
                r0.<init>();	 Catch:{ all -> 0x005f }
                r1 = "Loading URL in WebView: ";
                r0 = r0.append(r1);	 Catch:{ all -> 0x005f }
                r1 = r7.tF;	 Catch:{ all -> 0x005f }
                r1 = r1.tn;	 Catch:{ all -> 0x005f }
                r1 = r1.sg;	 Catch:{ all -> 0x005f }
                r0 = r0.append(r1);	 Catch:{ all -> 0x005f }
                r0 = r0.toString();	 Catch:{ all -> 0x005f }
                com.google.android.gms.internal.gr.V(r0);	 Catch:{ all -> 0x005f }
                r0 = r7.tF;	 Catch:{ all -> 0x005f }
                r0 = r0.mo;	 Catch:{ all -> 0x005f }
                r1 = r7.tF;	 Catch:{ all -> 0x005f }
                r1 = r1.tn;	 Catch:{ all -> 0x005f }
                r1 = r1.sg;	 Catch:{ all -> 0x005f }
                r0.loadUrl(r1);	 Catch:{ all -> 0x005f }
            L_0x005d:
                monitor-exit(r6);	 Catch:{ all -> 0x005f }
                goto L_0x0013;
            L_0x005f:
                r0 = move-exception;
                monitor-exit(r6);	 Catch:{ all -> 0x005f }
                throw r0;
            L_0x0062:
                r0 = "Loading HTML in WebView.";
                com.google.android.gms.internal.gr.V(r0);	 Catch:{ all -> 0x005f }
                r0 = r7.tF;	 Catch:{ all -> 0x005f }
                r0 = r0.mo;	 Catch:{ all -> 0x005f }
                r1 = r7.tF;	 Catch:{ all -> 0x005f }
                r1 = r1.tn;	 Catch:{ all -> 0x005f }
                r1 = r1.sg;	 Catch:{ all -> 0x005f }
                r1 = com.google.android.gms.internal.gi.L(r1);	 Catch:{ all -> 0x005f }
                r2 = r7.tF;	 Catch:{ all -> 0x005f }
                r2 = r2.tn;	 Catch:{ all -> 0x005f }
                r2 = r2.tU;	 Catch:{ all -> 0x005f }
                r3 = "text/html";
                r4 = "UTF-8";
                r5 = 0;
                r0.loadDataWithBaseURL(r1, r2, r3, r4, r5);	 Catch:{ all -> 0x005f }
                goto L_0x005d;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.fd.3.run():void");
            }
        });
        h(j);
    }

    private void h(long j) throws a {
        while (c(j)) {
            if (this.tC) {
                return;
            }
        }
        throw new a("Timed out waiting for WebView to finish loading.", 2);
    }

    public void a(gu guVar) {
        synchronized (this.mH) {
            gr.S("WebView finished loading.");
            this.tC = true;
            this.mH.notify();
        }
    }

    public void cx() {
        synchronized (this.mH) {
            gr.S("AdRendererBackgroundTask started.");
            fh fhVar = this.tB.vJ;
            int i = this.tB.errorCode;
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (this.tn.tW) {
                    a(fhVar, elapsedRealtime);
                } else if (this.tn.uc) {
                    g(elapsedRealtime);
                } else {
                    f(elapsedRealtime);
                }
            } catch (a e) {
                i = e.getErrorCode();
                if (i == 3 || i == -1) {
                    gr.U(e.getMessage());
                } else {
                    gr.W(e.getMessage());
                }
                if (this.tn == null) {
                    this.tn = new fj(i);
                } else {
                    this.tn = new fj(i, this.tn.qA);
                }
                gq.wR.post(new Runnable(this) {
                    final /* synthetic */ fd tF;

                    {
                        this.tF = r1;
                    }

                    public void run() {
                        this.tF.onStop();
                    }
                });
            }
            final fy fyVar = new fy(fhVar.tL, this.mo, this.tn.qw, i, this.tn.qx, this.tn.tY, this.tn.orientation, this.tn.qA, fhVar.tO, this.tn.tW, this.tE != null ? this.tE.qP : null, this.tE != null ? this.tE.qQ : null, this.tE != null ? this.tE.qR : AdMobAdapter.class.getName(), this.qi, this.tE != null ? this.tE.qS : null, this.tn.tX, this.tB.lS, this.tn.tV, this.tB.vG, this.tn.ua, this.tn.ub, this.tB.vD, null);
            gq.wR.post(new Runnable(this) {
                final /* synthetic */ fd tF;

                public void run() {
                    synchronized (this.tF.mH) {
                        this.tF.tA.a(fyVar);
                    }
                }
            });
        }
    }

    protected void g(long j) throws a {
        int i;
        int i2;
        ay ac = this.mo.ac();
        if (ac.oq) {
            i = this.mContext.getResources().getDisplayMetrics().widthPixels;
            i2 = this.mContext.getResources().getDisplayMetrics().heightPixels;
        } else {
            i = ac.widthPixels;
            i2 = ac.heightPixels;
        }
        final fb fbVar = new fb(this, this.mo, i, i2);
        gq.wR.post(new Runnable(this) {
            final /* synthetic */ fd tF;

            public void run() {
                synchronized (this.tF.mH) {
                    if (this.tF.tn.errorCode != -2) {
                        return;
                    }
                    this.tF.mo.dD().a(this.tF);
                    fbVar.b(this.tF.tn);
                }
            }
        });
        h(j);
        if (fbVar.cH()) {
            gr.S("Ad-Network indicated no fill with passback URL.");
            throw new a("AdNetwork sent passback url", 3);
        } else if (!fbVar.cI()) {
            throw new a("AdNetwork timed out", 2);
        }
    }

    public void onStop() {
        synchronized (this.tj) {
            this.mo.stopLoading();
            gi.a(this.mo);
            if (this.tD != null) {
                this.tD.cancel();
            }
        }
    }
}
