package com.google.android.gms.internal;

class qs {
    private static final qt ayZ = new qt();
    private boolean aza;
    private int[] azb;
    private qt[] azc;
    private int mSize;

    public qs() {
        this(10);
    }

    public qs(int i) {
        this.aza = false;
        int idealIntArraySize = idealIntArraySize(i);
        this.azb = new int[idealIntArraySize];
        this.azc = new qt[idealIntArraySize];
        this.mSize = 0;
    }

    private boolean a(int[] iArr, int[] iArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private boolean a(qt[] qtVarArr, qt[] qtVarArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (!qtVarArr[i2].equals(qtVarArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    private void gc() {
        int i = this.mSize;
        int[] iArr = this.azb;
        qt[] qtVarArr = this.azc;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            qt qtVar = qtVarArr[i3];
            if (qtVar != ayZ) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    qtVarArr[i2] = qtVar;
                    qtVarArr[i3] = null;
                }
                i2++;
            }
        }
        this.aza = false;
        this.mSize = i2;
    }

    private int hj(int i) {
        int i2 = 0;
        int i3 = this.mSize - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) >>> 1;
            int i5 = this.azb[i4];
            if (i5 < i) {
                i2 = i4 + 1;
            } else if (i5 <= i) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return i2 ^ -1;
    }

    private int idealByteArraySize(int need) {
        for (int i = 4; i < 32; i++) {
            if (need <= (1 << i) - 12) {
                return (1 << i) - 12;
            }
        }
        return need;
    }

    private int idealIntArraySize(int need) {
        return idealByteArraySize(need * 4) / 4;
    }

    public void a(int i, qt qtVar) {
        int hj = hj(i);
        if (hj >= 0) {
            this.azc[hj] = qtVar;
            return;
        }
        hj ^= -1;
        if (hj >= this.mSize || this.azc[hj] != ayZ) {
            if (this.aza && this.mSize >= this.azb.length) {
                gc();
                hj = hj(i) ^ -1;
            }
            if (this.mSize >= this.azb.length) {
                int idealIntArraySize = idealIntArraySize(this.mSize + 1);
                Object obj = new int[idealIntArraySize];
                Object obj2 = new qt[idealIntArraySize];
                System.arraycopy(this.azb, 0, obj, 0, this.azb.length);
                System.arraycopy(this.azc, 0, obj2, 0, this.azc.length);
                this.azb = obj;
                this.azc = obj2;
            }
            if (this.mSize - hj != 0) {
                System.arraycopy(this.azb, hj, this.azb, hj + 1, this.mSize - hj);
                System.arraycopy(this.azc, hj, this.azc, hj + 1, this.mSize - hj);
            }
            this.azb[hj] = i;
            this.azc[hj] = qtVar;
            this.mSize++;
            return;
        }
        this.azb[hj] = i;
        this.azc[hj] = qtVar;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof qs)) {
            return false;
        }
        qs qsVar = (qs) o;
        return size() != qsVar.size() ? false : a(this.azb, qsVar.azb, this.mSize) && a(this.azc, qsVar.azc, this.mSize);
    }

    public int hashCode() {
        if (this.aza) {
            gc();
        }
        int i = 17;
        for (int i2 = 0; i2 < this.mSize; i2++) {
            i = (((i * 31) + this.azb[i2]) * 31) + this.azc[i2].hashCode();
        }
        return i;
    }

    public qt hh(int i) {
        int hj = hj(i);
        return (hj < 0 || this.azc[hj] == ayZ) ? null : this.azc[hj];
    }

    public qt hi(int i) {
        if (this.aza) {
            gc();
        }
        return this.azc[i];
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        if (this.aza) {
            gc();
        }
        return this.mSize;
    }
}
