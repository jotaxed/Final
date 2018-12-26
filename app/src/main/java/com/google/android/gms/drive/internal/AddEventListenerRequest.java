package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class AddEventListenerRequest implements SafeParcelable {
    public static final Creator<AddEventListenerRequest> CREATOR = new a();
    final int CK;
    final DriveId Oj;
    final int Pm;

    AddEventListenerRequest(int versionCode, DriveId driveId, int eventType) {
        this.CK = versionCode;
        this.Oj = driveId;
        this.Pm = eventType;
    }

    public AddEventListenerRequest(DriveId id, int eventType) {
        this(1, id, eventType);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        a.a(this, dest, flags);
    }
}
