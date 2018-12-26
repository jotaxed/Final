package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Contents implements SafeParcelable {
    public static final Creator<Contents> CREATOR = new a();
    final int CK;
    final ParcelFileDescriptor LG;
    final int Oi;
    final DriveId Oj;
    final boolean Ok;
    final int ve;

    Contents(int versionCode, ParcelFileDescriptor parcelFileDescriptor, int requestId, int mode, DriveId driveId, boolean validForConflictDetection) {
        this.CK = versionCode;
        this.LG = parcelFileDescriptor;
        this.ve = requestId;
        this.Oi = mode;
        this.Oj = driveId;
        this.Ok = validForConflictDetection;
    }

    public int describeContents() {
        return 0;
    }

    public DriveId getDriveId() {
        return this.Oj;
    }

    public InputStream getInputStream() {
        return new FileInputStream(this.LG.getFileDescriptor());
    }

    public int getMode() {
        return this.Oi;
    }

    public OutputStream getOutputStream() {
        return new FileOutputStream(this.LG.getFileDescriptor());
    }

    public ParcelFileDescriptor getParcelFileDescriptor() {
        return this.LG;
    }

    public int getRequestId() {
        return this.ve;
    }

    public boolean ip() {
        return this.Ok;
    }

    public void writeToParcel(Parcel dest, int flags) {
        a.a(this, dest, flags);
    }
}
