package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;

public final class h extends d implements DataEvent {
    private final int Ya;

    public h(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.Ya = i2;
    }

    public /* synthetic */ Object freeze() {
        return rn();
    }

    public DataItem getDataItem() {
        return new o(this.JG, this.KZ, this.Ya);
    }

    public int getType() {
        return getInteger("event_type");
    }

    public DataEvent rn() {
        return new g(this);
    }
}
