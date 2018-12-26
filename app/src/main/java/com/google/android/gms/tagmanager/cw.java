package com.google.android.gms.tagmanager;

class cw implements cg {
    private final long BF;
    private final int BG;
    private double BH;
    private final Object BJ;
    private long aty;

    public cw() {
        this(60, 2000);
    }

    public cw(int i, long j) {
        this.BJ = new Object();
        this.BG = i;
        this.BH = (double) this.BG;
        this.BF = j;
    }

    public boolean fe() {
        boolean z;
        synchronized (this.BJ) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.BH < ((double) this.BG)) {
                double d = ((double) (currentTimeMillis - this.aty)) / ((double) this.BF);
                if (d > 0.0d) {
                    this.BH = Math.min((double) this.BG, d + this.BH);
                }
            }
            this.aty = currentTimeMillis;
            if (this.BH >= 1.0d) {
                this.BH -= 1.0d;
                z = true;
            } else {
                bh.W("No more tokens available.");
                z = false;
            }
        }
        return z;
    }
}
