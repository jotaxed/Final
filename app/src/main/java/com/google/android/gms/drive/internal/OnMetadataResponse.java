package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class OnMetadataResponse implements SafeParcelable {
    public static final Creator<OnMetadataResponse> CREATOR = new at();
    final int CK;
    final MetadataBundle Px;

    OnMetadataResponse(int versionCode, MetadataBundle metadata) {
        this.CK = versionCode;
        this.Px = metadata;
    }

    public int describeContents() {
        return 0;
    }

    public MetadataBundle iU() {
        return this.Px;
    }

    public void writeToParcel(Parcel dest, int flags) {
        at.a(this, dest, flags);
    }
}
