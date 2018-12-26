package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class OpenContentsRequest implements SafeParcelable {
    public static final Creator<OpenContentsRequest> CREATOR = new ay();
    final int CK;
    final int Oi;
    final DriveId Pp;
    final int QT;

    OpenContentsRequest(int versionCode, DriveId id, int mode, int baseRequestId) {
        this.CK = versionCode;
        this.Pp = id;
        this.Oi = mode;
        this.QT = baseRequestId;
    }

    public OpenContentsRequest(DriveId id, int mode, int baseRequestId) {
        this(1, id, mode, baseRequestId);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        ay.a(this, dest, flags);
    }
}
