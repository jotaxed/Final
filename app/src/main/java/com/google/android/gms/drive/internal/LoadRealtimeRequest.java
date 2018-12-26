package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class LoadRealtimeRequest implements SafeParcelable {
    public static final Creator<LoadRealtimeRequest> CREATOR = new aj();
    final int CK;
    final DriveId Oj;
    final boolean QF;

    LoadRealtimeRequest(int versionCode, DriveId driveId, boolean useTestMode) {
        this.CK = versionCode;
        this.Oj = driveId;
        this.QF = useTestMode;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        aj.a(this, dest, flags);
    }
}
