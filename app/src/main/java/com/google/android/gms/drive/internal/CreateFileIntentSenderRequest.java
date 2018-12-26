package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CreateFileIntentSenderRequest implements SafeParcelable {
    public static final Creator<CreateFileIntentSenderRequest> CREATOR = new j();
    final int CK;
    final String OH;
    final DriveId OJ;
    final MetadataBundle Px;
    final Integer Py;
    final int ve;

    CreateFileIntentSenderRequest(int versionCode, MetadataBundle metadata, int requestId, String title, DriveId startFolder, Integer fileType) {
        this.CK = versionCode;
        this.Px = metadata;
        this.ve = requestId;
        this.OH = title;
        this.OJ = startFolder;
        this.Py = fileType;
    }

    public CreateFileIntentSenderRequest(MetadataBundle metadata, int requestId, String title, DriveId startFolder, int fileType) {
        this(1, metadata, requestId, title, startFolder, Integer.valueOf(fileType));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        j.a(this, dest, flags);
    }
}
