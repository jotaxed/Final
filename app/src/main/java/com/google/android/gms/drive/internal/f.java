package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class f implements Creator<CloseContentsAndUpdateMetadataRequest> {
    static void a(CloseContentsAndUpdateMetadataRequest closeContentsAndUpdateMetadataRequest, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, closeContentsAndUpdateMetadataRequest.CK);
        b.a(parcel, 2, closeContentsAndUpdateMetadataRequest.Pp, i, false);
        b.a(parcel, 3, closeContentsAndUpdateMetadataRequest.Pq, i, false);
        b.a(parcel, 4, closeContentsAndUpdateMetadataRequest.Pr, i, false);
        b.a(parcel, 5, closeContentsAndUpdateMetadataRequest.Oz);
        b.a(parcel, 6, closeContentsAndUpdateMetadataRequest.Oy, false);
        b.c(parcel, 7, closeContentsAndUpdateMetadataRequest.Ps);
        b.H(parcel, H);
    }

    public CloseContentsAndUpdateMetadataRequest ad(Parcel parcel) {
        int i = 0;
        String str = null;
        int G = a.G(parcel);
        boolean z = false;
        Contents contents = null;
        MetadataBundle metadataBundle = null;
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i2 = a.g(parcel, F);
                    break;
                case 2:
                    driveId = (DriveId) a.a(parcel, F, DriveId.CREATOR);
                    break;
                case 3:
                    metadataBundle = (MetadataBundle) a.a(parcel, F, MetadataBundle.CREATOR);
                    break;
                case 4:
                    contents = (Contents) a.a(parcel, F, Contents.CREATOR);
                    break;
                case 5:
                    z = a.c(parcel, F);
                    break;
                case 6:
                    str = a.o(parcel, F);
                    break;
                case 7:
                    i = a.g(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new CloseContentsAndUpdateMetadataRequest(i2, driveId, metadataBundle, contents, z, str, i);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public CloseContentsAndUpdateMetadataRequest[] bn(int i) {
        return new CloseContentsAndUpdateMetadataRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ad(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bn(x0);
    }
}
