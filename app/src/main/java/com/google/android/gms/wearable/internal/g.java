package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;

public class g implements DataEvent {
    private int Gt;
    private DataItem axE;

    public g(DataEvent dataEvent) {
        this.Gt = dataEvent.getType();
        this.axE = (DataItem) dataEvent.getDataItem().freeze();
    }

    public /* synthetic */ Object freeze() {
        return rn();
    }

    public DataItem getDataItem() {
        return this.axE;
    }

    public int getType() {
        return this.Gt;
    }

    public boolean isDataValid() {
        return true;
    }

    public DataEvent rn() {
        return this;
    }
}
