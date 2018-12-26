package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.StorageStats;

public class OnStorageStatsResponse implements SafeParcelable {
    public static final Creator<OnStorageStatsResponse> CREATOR = new aw();
    final int CK;
    StorageStats QS;

    OnStorageStatsResponse(int versionCode, StorageStats storageStats) {
        this.CK = versionCode;
        this.QS = storageStats;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        aw.a(this, dest, flags);
    }
}
