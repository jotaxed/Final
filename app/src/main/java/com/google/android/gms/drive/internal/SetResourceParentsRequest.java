package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.List;

public class SetResourceParentsRequest implements SafeParcelable {
    public static final Creator<SetResourceParentsRequest> CREATOR = new bf();
    final int CK;
    final DriveId QW;
    final List<DriveId> QX;

    SetResourceParentsRequest(int versionCode, DriveId targetId, List<DriveId> parentIds) {
        this.CK = versionCode;
        this.QW = targetId;
        this.QX = parentIds;
    }

    public SetResourceParentsRequest(DriveId targetId, List<DriveId> parentIds) {
        this(1, targetId, parentIds);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        bf.a(this, dest, flags);
    }
}
