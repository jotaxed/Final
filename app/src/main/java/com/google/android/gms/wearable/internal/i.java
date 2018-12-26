package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataItemAsset;

public class i implements DataItemAsset {
    private final String CE;
    private final String KP;

    public i(DataItemAsset dataItemAsset) {
        this.CE = dataItemAsset.getId();
        this.KP = dataItemAsset.getDataItemKey();
    }

    public /* synthetic */ Object freeze() {
        return ro();
    }

    public String getDataItemKey() {
        return this.KP;
    }

    public String getId() {
        return this.CE;
    }

    public boolean isDataValid() {
        return true;
    }

    public DataItemAsset ro() {
        return this;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DataItemAssetEntity[");
        stringBuilder.append("@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        if (this.CE == null) {
            stringBuilder.append(",noid");
        } else {
            stringBuilder.append(",");
            stringBuilder.append(this.CE);
        }
        stringBuilder.append(", key=");
        stringBuilder.append(this.KP);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
