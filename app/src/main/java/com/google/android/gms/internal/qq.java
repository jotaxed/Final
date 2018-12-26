package com.google.android.gms.internal;

import java.io.IOException;

public abstract class qq<M extends qq<M>> extends qw {
    protected qs ayW;

    public final <T> T a(qr<M, T> qrVar) {
        if (this.ayW == null) {
            return null;
        }
        qt hh = this.ayW.hh(qz.hl(qrVar.tag));
        return hh != null ? hh.b(qrVar) : null;
    }

    public void a(qp qpVar) throws IOException {
        if (this.ayW != null) {
            for (int i = 0; i < this.ayW.size(); i++) {
                this.ayW.hi(i).a(qpVar);
            }
        }
    }

    protected final boolean a(qo qoVar, int i) throws IOException {
        int position = qoVar.getPosition();
        if (!qoVar.gQ(i)) {
            return false;
        }
        int hl = qz.hl(i);
        qy qyVar = new qy(i, qoVar.s(position, qoVar.getPosition() - position));
        qt qtVar = null;
        if (this.ayW == null) {
            this.ayW = new qs();
        } else {
            qtVar = this.ayW.hh(hl);
        }
        if (qtVar == null) {
            qtVar = new qt();
            this.ayW.a(hl, qtVar);
        }
        qtVar.a(qyVar);
        return true;
    }

    protected final boolean a(M m) {
        return (this.ayW == null || this.ayW.isEmpty()) ? m.ayW == null || m.ayW.isEmpty() : this.ayW.equals(m.ayW);
    }

    protected int c() {
        int i = 0;
        if (this.ayW == null) {
            return 0;
        }
        int i2 = 0;
        while (i < this.ayW.size()) {
            i2 += this.ayW.hi(i).c();
            i++;
        }
        return i2;
    }

    protected final int rQ() {
        return (this.ayW == null || this.ayW.isEmpty()) ? 0 : this.ayW.hashCode();
    }
}
