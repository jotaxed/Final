package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;
import com.google.android.gms.wearable.internal.h;

public class DataEventBuffer extends g<DataEvent> implements Result {
    private final Status Eb;

    public DataEventBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.Eb = new Status(dataHolder.getStatusCode());
    }

    protected /* synthetic */ Object f(int i, int i2) {
        return q(i, i2);
    }

    public Status getStatus() {
        return this.Eb;
    }

    protected String ha() {
        return "path";
    }

    protected DataEvent q(int i, int i2) {
        return new h(this.JG, i, i2);
    }
}
