package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.internal.jx;

public class CreateContentsRequest implements SafeParcelable {
    public static final Creator<CreateContentsRequest> CREATOR = new h();
    final int CK;
    final int Oi;

    public CreateContentsRequest(int mode) {
        this(1, mode);
    }

    CreateContentsRequest(int versionCode, int mode) {
        this.CK = versionCode;
        boolean z = mode == DriveFile.MODE_WRITE_ONLY || mode == DriveFile.MODE_READ_WRITE;
        jx.b(z, (Object) "Cannot create a new read-only contents!");
        this.Oi = mode;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        h.a(this, dest, flags);
    }
}
