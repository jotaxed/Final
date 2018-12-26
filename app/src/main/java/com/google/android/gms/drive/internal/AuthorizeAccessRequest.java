package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class AuthorizeAccessRequest implements SafeParcelable {
    public static final Creator<AuthorizeAccessRequest> CREATOR = new b();
    final int CK;
    final DriveId Oj;
    final long Pn;

    AuthorizeAccessRequest(int versionCode, long appId, DriveId driveId) {
        this.CK = versionCode;
        this.Pn = appId;
        this.Oj = driveId;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        b.a(this, dest, flags);
    }
}
