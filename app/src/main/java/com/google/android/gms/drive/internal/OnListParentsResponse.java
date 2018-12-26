package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.i;

public class OnListParentsResponse extends i implements SafeParcelable {
    public static final Creator<OnListParentsResponse> CREATOR = new as();
    final int CK;
    final DataHolder QR;

    OnListParentsResponse(int versionCode, DataHolder parents) {
        this.CK = versionCode;
        this.QR = parents;
    }

    protected void I(Parcel parcel, int i) {
        as.a(this, parcel, i);
    }

    public int describeContents() {
        return 0;
    }

    public DataHolder iT() {
        return this.QR;
    }
}
