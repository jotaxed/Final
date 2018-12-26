package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class qt {
    private qr<?, ?> azd;
    private Object aze;
    private List<qy> azf = new ArrayList();

    qt() {
    }

    private byte[] toByteArray() throws IOException {
        byte[] bArr = new byte[c()];
        a(qp.q(bArr));
        return bArr;
    }

    void a(qp qpVar) throws IOException {
        if (this.aze != null) {
            this.azd.a(this.aze, qpVar);
            return;
        }
        for (qy a : this.azf) {
            a.a(qpVar);
        }
    }

    void a(qy qyVar) {
        this.azf.add(qyVar);
    }

    <T> T b(qr<?, T> qrVar) {
        if (this.aze == null) {
            this.azd = qrVar;
            this.aze = qrVar.m(this.azf);
            this.azf = null;
        } else if (this.azd != qrVar) {
            throw new IllegalStateException("Tried to getExtension with a differernt Extension.");
        }
        return this.aze;
    }

    int c() {
        if (this.aze != null) {
            return this.azd.B(this.aze);
        }
        int i = 0;
        for (qy c : this.azf) {
            i = c.c() + i;
        }
        return i;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof qt)) {
            return false;
        }
        qt qtVar = (qt) o;
        if (this.aze != null && qtVar.aze != null) {
            return this.azd == qtVar.azd ? !this.azd.ayX.isArray() ? this.aze.equals(qtVar.aze) : this.aze instanceof byte[] ? Arrays.equals((byte[]) this.aze, (byte[]) qtVar.aze) : this.aze instanceof int[] ? Arrays.equals((int[]) this.aze, (int[]) qtVar.aze) : this.aze instanceof long[] ? Arrays.equals((long[]) this.aze, (long[]) qtVar.aze) : this.aze instanceof float[] ? Arrays.equals((float[]) this.aze, (float[]) qtVar.aze) : this.aze instanceof double[] ? Arrays.equals((double[]) this.aze, (double[]) qtVar.aze) : this.aze instanceof boolean[] ? Arrays.equals((boolean[]) this.aze, (boolean[]) qtVar.aze) : Arrays.deepEquals((Object[]) this.aze, (Object[]) qtVar.aze) : false;
        } else {
            if (this.azf != null && qtVar.azf != null) {
                return this.azf.equals(qtVar.azf);
            }
            try {
                return Arrays.equals(toByteArray(), qtVar.toByteArray());
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public int hashCode() {
        try {
            return Arrays.hashCode(toByteArray()) + 527;
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }
}
