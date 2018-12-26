package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jx;
import com.google.android.gms.wearable.DataItemAsset;

public class DataItemAssetParcelable implements SafeParcelable, DataItemAsset {
    public static final Creator<DataItemAssetParcelable> CREATOR = new j();
    private final String CE;
    final int CK;
    private final String KP;

    DataItemAssetParcelable(int versionCode, String id, String key) {
        this.CK = versionCode;
        this.CE = id;
        this.KP = key;
    }

    public DataItemAssetParcelable(DataItemAsset value) {
        this.CK = 1;
        this.CE = (String) jx.i(value.getId());
        this.KP = (String) jx.i(value.getDataItemKey());
    }

    public int describeContents() {
        return 0;
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
        stringBuilder.append("DataItemAssetParcelable[");
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

    public void writeToParcel(Parcel dest, int flags) {
        j.a(this, dest, flags);
    }
}
