package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.i;

public class OnListEntriesResponse extends i implements SafeParcelable {
    public static final Creator<OnListEntriesResponse> CREATOR = new ar();
    final int CK;
    final boolean PJ;
    final DataHolder QQ;

    OnListEntriesResponse(int versionCode, DataHolder entries, boolean moreEntriesMayExist) {
        this.CK = versionCode;
        this.QQ = entries;
        this.PJ = moreEntriesMayExist;
    }

    protected void I(Parcel parcel, int i) {
        ar.a(this, parcel, i);
    }

    public int describeContents() {
        return 0;
    }

    public DataHolder iR() {
        return this.QQ;
    }

    public boolean iS() {
        return this.PJ;
    }
}
