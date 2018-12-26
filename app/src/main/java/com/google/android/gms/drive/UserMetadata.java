package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class UserMetadata implements SafeParcelable {
    public static final Creator<UserMetadata> CREATOR = new h();
    final int CK;
    final String OR;
    final String OS;
    final String OT;
    final boolean OU;
    final String OV;

    UserMetadata(int versionCode, String permissionId, String displayName, String pictureUrl, boolean isAuthenticatedUser, String emailAddress) {
        this.CK = versionCode;
        this.OR = permissionId;
        this.OS = displayName;
        this.OT = pictureUrl;
        this.OU = isAuthenticatedUser;
        this.OV = emailAddress;
    }

    public UserMetadata(String permissionId, String displayName, String pictureUrl, boolean isAuthenticatedUser, String emailAddress) {
        this(1, permissionId, displayName, pictureUrl, isAuthenticatedUser, emailAddress);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format("Permission ID: '%s', Display Name: '%s', Picture URL: '%s', Authenticated User: %b, Email: '%s'", new Object[]{this.OR, this.OS, this.OT, Boolean.valueOf(this.OU), this.OV});
    }

    public void writeToParcel(Parcel dest, int flags) {
        h.a(this, dest, flags);
    }
}
