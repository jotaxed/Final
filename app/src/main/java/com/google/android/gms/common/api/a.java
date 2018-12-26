package com.google.android.gms.common.api;

import com.google.android.gms.common.api.d.b;
import com.google.android.gms.common.data.DataHolder;

public abstract class a<L> implements b<L> {
    private final DataHolder JG;

    protected a(DataHolder dataHolder) {
        this.JG = dataHolder;
    }

    protected abstract void a(L l, DataHolder dataHolder);

    public final void c(L l) {
        a(l, this.JG);
    }

    public void gG() {
        if (this.JG != null) {
            this.JG.close();
        }
    }
}
