package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.fc.a;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@ey
public class fm extends gf {
    private final Object mH;
    private final a tA;
    private final fy.a tB;
    private final fj tn;
    private final fn ui;
    private Future<fy> uj;

    public fm(Context context, u uVar, ai aiVar, fy.a aVar, a aVar2) {
        this(aVar, aVar2, new fn(context, uVar, aiVar, new gn(), aVar));
    }

    fm(fy.a aVar, a aVar2, fn fnVar) {
        this.mH = new Object();
        this.tB = aVar;
        this.tn = aVar.vK;
        this.tA = aVar2;
        this.ui = fnVar;
    }

    private fy s(int i) {
        return new fy(this.tB.vJ.tL, null, null, i, null, null, this.tn.orientation, this.tn.qA, this.tB.vJ.tO, false, null, null, null, null, null, this.tn.tX, this.tB.lS, this.tn.tV, this.tB.vG, this.tn.ua, this.tn.ub, this.tB.vD, null);
    }

    public void cx() {
        fy fyVar;
        int i;
        try {
            synchronized (this.mH) {
                this.uj = gh.submit(this.ui);
            }
            fyVar = (fy) this.uj.get(60000, TimeUnit.MILLISECONDS);
            i = -2;
        } catch (TimeoutException e) {
            gr.W("Timed out waiting for native ad.");
            i = 2;
            fyVar = null;
        } catch (ExecutionException e2) {
            i = 0;
            fyVar = null;
        } catch (InterruptedException e3) {
            fyVar = null;
            i = -1;
        } catch (CancellationException e4) {
            fyVar = null;
            i = -1;
        }
        if (fyVar == null) {
            fyVar = s(i);
        }
        gq.wR.post(new Runnable(this) {
            final /* synthetic */ fm uk;

            public void run() {
                this.uk.tA.a(fyVar);
            }
        });
    }

    public void onStop() {
        synchronized (this.mH) {
            if (this.uj != null) {
                this.uj.cancel(true);
            }
        }
    }
}
