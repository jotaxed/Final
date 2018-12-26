package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetDriveIdFromUniqueIdentifierRequest implements SafeParcelable {
    public static final Creator<GetDriveIdFromUniqueIdentifierRequest> CREATOR = new ac();
    final int CK;
    final String QC;
    final boolean QD;

    GetDriveIdFromUniqueIdentifierRequest(int versionCode, String uniqueIdentifier, boolean isInAppFolder) {
        this.CK = versionCode;
        this.QC = uniqueIdentifier;
        this.QD = isInAppFolder;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        ac.a(this, dest, flags);
    }
}
