package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.internal.cv.a;

@ey
public final class cu implements a {
    private final cy lA;
    private final Context mContext;
    private final Object mH = new Object();
    private final av mw;
    private final String qF;
    private final long qG;
    private final cq qH;
    private final ay qI;
    private final gs qJ;
    private cz qK;
    private int qL = -2;

    public cu(Context context, String str, cy cyVar, cr crVar, cq cqVar, av avVar, ay ayVar, gs gsVar) {
        this.mContext = context;
        this.lA = cyVar;
        this.qH = cqVar;
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            this.qF = bO();
        } else {
            this.qF = str;
        }
        this.qG = crVar.qv != -1 ? crVar.qv : 10000;
        this.mw = avVar;
        this.qI = ayVar;
        this.qJ = gsVar;
    }

    private void a(long j, long j2, long j3, long j4) {
        while (this.qL == -2) {
            b(j, j2, j3, j4);
        }
    }

    private void a(ct ctVar) {
        try {
            if (this.qJ.wU < 4100000) {
                if (this.qI.oq) {
                    this.qK.a(e.k(this.mContext), this.mw, this.qH.qt, ctVar);
                } else {
                    this.qK.a(e.k(this.mContext), this.qI, this.mw, this.qH.qt, (da) ctVar);
                }
            } else if (this.qI.oq) {
                this.qK.a(e.k(this.mContext), this.mw, this.qH.qt, this.qH.qn, (da) ctVar);
            } else {
                this.qK.a(e.k(this.mContext), this.qI, this.mw, this.qH.qt, this.qH.qn, ctVar);
            }
        } catch (Throwable e) {
            gr.d("Could not request ad from mediation adapter.", e);
            k(5);
        }
    }

    private void b(long j, long j2, long j3, long j4) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j5 = j2 - (elapsedRealtime - j);
        elapsedRealtime = j4 - (elapsedRealtime - j3);
        if (j5 <= 0 || elapsedRealtime <= 0) {
            gr.U("Timed out waiting for adapter.");
            this.qL = 3;
            return;
        }
        try {
            this.mH.wait(Math.min(j5, elapsedRealtime));
        } catch (InterruptedException e) {
            this.qL = -1;
        }
    }

    private String bO() {
        try {
            if (!TextUtils.isEmpty(this.qH.qr)) {
                return this.lA.y(this.qH.qr) ? "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter" : "com.google.ads.mediation.customevent.CustomEventAdapter";
            }
        } catch (RemoteException e) {
            gr.W("Fail to determine the custom event's version, assuming the old one.");
        }
        return "com.google.ads.mediation.customevent.CustomEventAdapter";
    }

    private cz bP() {
        gr.U("Instantiating mediation adapter: " + this.qF);
        try {
            return this.lA.x(this.qF);
        } catch (Throwable e) {
            gr.a("Could not instantiate mediation adapter: " + this.qF, e);
            return null;
        }
    }

    public cv b(long j, long j2) {
        cv cvVar;
        synchronized (this.mH) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            final ct ctVar = new ct();
            gq.wR.post(new Runnable(this) {
                final /* synthetic */ cu qN;

                public void run() {
                    synchronized (this.qN.mH) {
                        if (this.qN.qL != -2) {
                            return;
                        }
                        this.qN.qK = this.qN.bP();
                        if (this.qN.qK == null) {
                            this.qN.k(4);
                            return;
                        }
                        ctVar.a(this.qN);
                        this.qN.a(ctVar);
                    }
                }
            });
            a(elapsedRealtime, this.qG, j, j2);
            cvVar = new cv(this.qH, this.qK, this.qF, ctVar, this.qL);
        }
        return cvVar;
    }

    public void cancel() {
        synchronized (this.mH) {
            try {
                if (this.qK != null) {
                    this.qK.destroy();
                }
            } catch (Throwable e) {
                gr.d("Could not destroy mediation adapter.", e);
            }
            this.qL = -1;
            this.mH.notify();
        }
    }

    public void k(int i) {
        synchronized (this.mH) {
            this.qL = i;
            this.mH.notify();
        }
    }
}
