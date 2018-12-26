package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;

public abstract class d {
    protected final DataHolder JG;
    protected int KZ;
    private int La;

    public d(DataHolder dataHolder, int i) {
        this.JG = (DataHolder) jx.i(dataHolder);
        as(i);
    }

    protected void a(String str, CharArrayBuffer charArrayBuffer) {
        this.JG.a(str, this.KZ, this.La, charArrayBuffer);
    }

    public boolean aQ(String str) {
        return this.JG.aQ(str);
    }

    protected Uri aR(String str) {
        return this.JG.g(str, this.KZ, this.La);
    }

    protected boolean aS(String str) {
        return this.JG.h(str, this.KZ, this.La);
    }

    protected void as(int i) {
        boolean z = i >= 0 && i < this.JG.getCount();
        jx.K(z);
        this.KZ = i;
        this.La = this.JG.au(this.KZ);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return jv.equal(Integer.valueOf(dVar.KZ), Integer.valueOf(this.KZ)) && jv.equal(Integer.valueOf(dVar.La), Integer.valueOf(this.La)) && dVar.JG == this.JG;
    }

    protected int gW() {
        return this.KZ;
    }

    protected boolean getBoolean(String column) {
        return this.JG.d(column, this.KZ, this.La);
    }

    protected byte[] getByteArray(String column) {
        return this.JG.f(column, this.KZ, this.La);
    }

    protected float getFloat(String column) {
        return this.JG.e(column, this.KZ, this.La);
    }

    protected int getInteger(String column) {
        return this.JG.b(column, this.KZ, this.La);
    }

    protected long getLong(String column) {
        return this.JG.a(column, this.KZ, this.La);
    }

    protected String getString(String column) {
        return this.JG.c(column, this.KZ, this.La);
    }

    public int hashCode() {
        return jv.hashCode(Integer.valueOf(this.KZ), Integer.valueOf(this.La), this.JG);
    }

    public boolean isDataValid() {
        return !this.JG.isClosed();
    }
}
