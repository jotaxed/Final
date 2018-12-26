package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.jx;

public class CreateFileRequest implements SafeParcelable {
    public static final Creator<CreateFileRequest> CREATOR = new k();
    final int CK;
    final String Oy;
    final boolean PA;
    final int PB;
    final int PC;
    final Contents Pr;
    final MetadataBundle Px;
    final Integer Py;
    final DriveId Pz;

    CreateFileRequest(int versionCode, DriveId parentDriveId, MetadataBundle metadata, Contents contentsReference, Integer fileType, boolean sendEventOnCompletion, String trackingTag, int createStrategy, int openContentsRequestId) {
        if (!(contentsReference == null || openContentsRequestId == 0)) {
            jx.b(contentsReference.getRequestId() == openContentsRequestId, (Object) "inconsistent contents reference");
        }
        if ((fileType == null || fileType.intValue() == 0) && contentsReference == null && openContentsRequestId == 0) {
            throw new IllegalArgumentException("Need a valid contents");
        }
        this.CK = versionCode;
        this.Pz = (DriveId) jx.i(parentDriveId);
        this.Px = (MetadataBundle) jx.i(metadata);
        this.Pr = contentsReference;
        this.Py = fileType;
        this.Oy = trackingTag;
        this.PB = createStrategy;
        this.PA = sendEventOnCompletion;
        this.PC = openContentsRequestId;
    }

    public CreateFileRequest(DriveId parentDriveId, MetadataBundle metadata, int openContentsRequestId, int fileType, ExecutionOptions executionOptions) {
        this(2, parentDriveId, metadata, null, Integer.valueOf(fileType), executionOptions.iw(), executionOptions.iv(), executionOptions.ix(), openContentsRequestId);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        k.a(this, dest, flags);
    }
}
