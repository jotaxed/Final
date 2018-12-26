package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;
import com.google.android.gms.wearable.internal.o;

public class DataItemBuffer extends g<DataItem> implements Result {
    private final Status Eb;

    public DataItemBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.Eb = new Status(dataHolder.getStatusCode());
    }

    protected /* synthetic */ Object f(int i, int i2) {
        return r(i, i2);
    }

    public Status getStatus() {
        return this.Eb;
    }

    protected String ha() {
        return "path";
    }

    protected DataItem r(int i, int i2) {
        return new o(this.JG, i, i2);
    }
}
