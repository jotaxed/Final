package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DrivePreferences;

public class OnDrivePreferencesResponse implements SafeParcelable {
    public static final Creator<OnDrivePreferencesResponse> CREATOR = new ap();
    final int CK;
    DrivePreferences QN;

    OnDrivePreferencesResponse(int versionCode, DrivePreferences prefs) {
        this.CK = versionCode;
        this.QN = prefs;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        ap.a(this, dest, flags);
    }
}
