package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class l implements Creator<CreateFolderRequest> {
    static void a(CreateFolderRequest createFolderRequest, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, createFolderRequest.CK);
        b.a(parcel, 2, createFolderRequest.Pz, i, false);
        b.a(parcel, 3, createFolderRequest.Px, i, false);
        b.H(parcel, H);
    }

    public CreateFolderRequest ai(Parcel parcel) {
        MetadataBundle metadataBundle = null;
        int G = a.G(parcel);
        int i = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < G) {
            DriveId driveId2;
            int g;
            MetadataBundle metadataBundle2;
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    MetadataBundle metadataBundle3 = metadataBundle;
                    driveId2 = driveId;
                    g = a.g(parcel, F);
                    metadataBundle2 = metadataBundle3;
                    break;
                case 2:
                    g = i;
                    DriveId driveId3 = (DriveId) a.a(parcel, F, DriveId.CREATOR);
                    metadataBundle2 = metadataBundle;
                    driveId2 = driveId3;
                    break;
                case 3:
                    metadataBundle2 = (MetadataBundle) a.a(parcel, F, MetadataBundle.CREATOR);
                    driveId2 = driveId;
                    g = i;
                    break;
                default:
                    a.b(parcel, F);
                    metadataBundle2 = metadataBundle;
                    driveId2 = driveId;
                    g = i;
                    break;
            }
            i = g;
            driveId = driveId2;
            metadataBundle = metadataBundle2;
        }
        if (parcel.dataPosition() == G) {
            return new CreateFolderRequest(i, driveId, metadataBundle);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public CreateFolderRequest[] bt(int i) {
        return new CreateFolderRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ai(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bt(x0);
    }
}
