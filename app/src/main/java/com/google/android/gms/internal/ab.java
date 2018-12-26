package com.google.android.gms.internal;

import android.os.Handler;
import java.lang.ref.WeakReference;

@ey
public class ab {
    private final a mu;
    private final Runnable mv;
    private av mw;
    private boolean mx;
    private boolean my;
    private long mz;

    public static class a {
        private final Handler mHandler;

        public a(Handler handler) {
            this.mHandler = handler;
        }

        public boolean postDelayed(Runnable runnable, long timeFromNowInMillis) {
            return this.mHandler.postDelayed(runnable, timeFromNowInMillis);
        }

        public void removeCallbacks(Runnable runnable) {
            this.mHandler.removeCallbacks(runnable);
        }
    }

    public ab(u uVar) {
        this(uVar, new a(gq.wR));
    }

    ab(final u uVar, a aVar) {
        this.mx = false;
        this.my = false;
        this.mz = 0;
        this.mu = aVar;
        this.mv = new Runnable(this) {
            private final WeakReference<u> mA = new WeakReference(uVar);
            final /* synthetic */ ab mC;

            public void run() {
                this.mC.mx = false;
                u uVar = (u) this.mA.get();
                if (uVar != null) {
                    uVar.b(this.mC.mw);
                }
            }
        };
    }

    public void a(av avVar, long j) {
        if (this.mx) {
            gr.W("An ad refresh is already scheduled.");
            return;
        }
        this.mw = avVar;
        this.mx = true;
        this.mz = j;
        if (!this.my) {
            gr.U("Scheduling ad refresh " + j + " milliseconds from now.");
            this.mu.postDelayed(this.mv, j);
        }
    }

    public boolean aD() {
        return this.mx;
    }

    public void c(av avVar) {
        a(avVar, 60000);
    }

    public void cancel() {
        this.mx = false;
        this.mu.removeCallbacks(this.mv);
    }

    public void pause() {
        this.my = true;
        if (this.mx) {
            this.mu.removeCallbacks(this.mv);
        }
    }

    public void resume() {
        this.my = false;
        if (this.mx) {
            this.mx = false;
            a(this.mw, this.mz);
        }
    }
}
