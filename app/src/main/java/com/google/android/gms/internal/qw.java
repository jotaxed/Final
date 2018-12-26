package com.google.android.gms.internal;

import java.io.IOException;

public abstract class qw {
    protected volatile int azh = -1;

    public static final <T extends qw> T a(T t, byte[] bArr) throws qv {
        return b(t, bArr, 0, bArr.length);
    }

    public static final void a(qw qwVar, byte[] bArr, int i, int i2) {
        try {
            qp b = qp.b(bArr, i, i2);
            qwVar.a(b);
            b.rP();
        } catch (Throwable e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public static final <T extends qw> T b(T t, byte[] bArr, int i, int i2) throws qv {
        try {
            qo a = qo.a(bArr, i, i2);
            t.b(a);
            a.gP(0);
            return t;
        } catch (qv e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public static final byte[] f(qw qwVar) {
        byte[] bArr = new byte[qwVar.rZ()];
        a(qwVar, bArr, 0, bArr.length);
        return bArr;
    }

    public void a(qp qpVar) throws IOException {
    }

    public abstract qw b(qo qoVar) throws IOException;

    protected int c() {
        return 0;
    }

    public int rY() {
        if (this.azh < 0) {
            rZ();
        }
        return this.azh;
    }

    public int rZ() {
        int c = c();
        this.azh = c;
        return c;
    }

    public String toString() {
        return qx.g(this);
    }
}
