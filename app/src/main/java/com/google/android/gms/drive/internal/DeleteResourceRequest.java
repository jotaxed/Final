package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class DeleteResourceRequest implements SafeParcelable {
    public static final Creator<DeleteResourceRequest> CREATOR = new n();
    final int CK;
    final DriveId Pp;

    DeleteResourceRequest(int versionCode, DriveId id) {
        this.CK = versionCode;
        this.Pp = id;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        n.a(this, dest, flags);
    }
}
