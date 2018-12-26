package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class OnDriveIdResponse implements SafeParcelable {
    public static final Creator<OnDriveIdResponse> CREATOR = new ao();
    final int CK;
    DriveId Pp;

    OnDriveIdResponse(int versionCode, DriveId driveId) {
        this.CK = versionCode;
        this.Pp = driveId;
    }

    public int describeContents() {
        return 0;
    }

    public DriveId getDriveId() {
        return this.Pp;
    }

    public void writeToParcel(Parcel dest, int flags) {
        ao.a(this, dest, flags);
    }
}
