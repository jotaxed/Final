package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DrivePreferences implements SafeParcelable {
    public static final Creator<DrivePreferences> CREATOR = new d();
    final int CK;
    final boolean Ox;

    DrivePreferences(int versionCode, boolean syncOverWifiOnly) {
        this.CK = versionCode;
        this.Ox = syncOverWifiOnly;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        d.a(this, parcel, flags);
    }
}
