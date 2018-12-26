package com.google.android.gms.internal;

@ey
public abstract class gf {
    private final Runnable mv = new Runnable(this) {
        final /* synthetic */ gf wv;

        {
            this.wv = r1;
        }

        public final void run() {
            this.wv.wu = Thread.currentThread();
            this.wv.cx();
        }
    };
    private volatile Thread wu;

    public final void cancel() {
        onStop();
        if (this.wu != null) {
            this.wu.interrupt();
        }
    }

    public abstract void cx();

    public abstract void onStop();

    public final void start() {
        gh.a(this.mv);
    }
}
