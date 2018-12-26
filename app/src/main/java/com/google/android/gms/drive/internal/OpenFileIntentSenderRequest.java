package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class OpenFileIntentSenderRequest implements SafeParcelable {
    public static final Creator<OpenFileIntentSenderRequest> CREATOR = new ba();
    final int CK;
    final String OH;
    final String[] OI;
    final DriveId OJ;

    OpenFileIntentSenderRequest(int versionCode, String title, String[] mimeTypes, DriveId startFolder) {
        this.CK = versionCode;
        this.OH = title;
        this.OI = mimeTypes;
        this.OJ = startFolder;
    }

    public OpenFileIntentSenderRequest(String title, String[] mimeTypes, DriveId startFolder) {
        this(1, title, mimeTypes, startFolder);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        ba.a(this, dest, flags);
    }
}
