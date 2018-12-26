package com.google.android.gms.common.data;

import android.os.Bundle;
import com.google.android.gms.common.api.Releasable;
import java.util.Iterator;

public abstract class DataBuffer<T> implements Releasable, Iterable<T> {
    protected final DataHolder JG;

    protected DataBuffer(DataHolder dataHolder) {
        this.JG = dataHolder;
        if (this.JG != null) {
            this.JG.e(this);
        }
    }

    @Deprecated
    public final void close() {
        release();
    }

    public int describeContents() {
        return 0;
    }

    public Bundle gV() {
        return this.JG.gV();
    }

    public abstract T get(int i);

    public int getCount() {
        return this.JG == null ? 0 : this.JG.getCount();
    }

    @Deprecated
    public boolean isClosed() {
        return this.JG == null ? true : this.JG.isClosed();
    }

    public Iterator<T> iterator() {
        return new c(this);
    }

    public void release() {
        if (this.JG != null) {
            this.JG.close();
        }
    }

    public Iterator<T> singleRefIterator() {
        return new h(this);
    }
}
