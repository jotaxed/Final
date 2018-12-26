package com.google.android.gms.common.api;

import com.google.android.gms.common.data.DataHolder;

public abstract class b implements Releasable, Result {
    protected final Status Eb;
    protected final DataHolder JG;

    protected b(DataHolder dataHolder) {
        this.Eb = new Status(dataHolder.getStatusCode());
        this.JG = dataHolder;
    }

    public Status getStatus() {
        return this.Eb;
    }

    public void release() {
        if (this.JG != null) {
            this.JG.close();
        }
    }
}
