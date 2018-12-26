package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class TrashResourceRequest implements SafeParcelable {
    public static final Creator<TrashResourceRequest> CREATOR = new bh();
    final int CK;
    final DriveId Pp;

    TrashResourceRequest(int versionCode, DriveId id) {
        this.CK = versionCode;
        this.Pp = id;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        bh.a(this, dest, flags);
    }
}
