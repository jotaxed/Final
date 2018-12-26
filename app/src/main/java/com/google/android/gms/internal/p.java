package com.google.android.gms.internal;

import java.io.IOException;

class p implements n {
    private qp lb;
    private byte[] lc;
    private final int ld;

    public p(int i) {
        this.ld = i;
        reset();
    }

    public byte[] D() throws IOException {
        int rO = this.lb.rO();
        if (rO < 0) {
            throw new IOException();
        } else if (rO == 0) {
            return this.lc;
        } else {
            Object obj = new byte[(this.lc.length - rO)];
            System.arraycopy(this.lc, 0, obj, 0, obj.length);
            return obj;
        }
    }

    public void b(int i, long j) throws IOException {
        this.lb.b(i, j);
    }

    public void b(int i, String str) throws IOException {
        this.lb.b(i, str);
    }

    public void reset() {
        this.lc = new byte[this.ld];
        this.lb = qp.q(this.lc);
    }
}
