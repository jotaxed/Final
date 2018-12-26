package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnSyncMoreResponse implements SafeParcelable {
    public static final Creator<OnSyncMoreResponse> CREATOR = new ax();
    final int CK;
    final boolean PJ;

    OnSyncMoreResponse(int versionCode, boolean moreEntriesMayExist) {
        this.CK = versionCode;
        this.PJ = moreEntriesMayExist;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        ax.a(this, dest, flags);
    }
}
