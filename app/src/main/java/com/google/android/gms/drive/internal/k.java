package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class k implements Creator<CreateFileRequest> {
    static void a(CreateFileRequest createFileRequest, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, createFileRequest.CK);
        b.a(parcel, 2, createFileRequest.Pz, i, false);
        b.a(parcel, 3, createFileRequest.Px, i, false);
        b.a(parcel, 4, createFileRequest.Pr, i, false);
        b.a(parcel, 5, createFileRequest.Py, false);
        b.a(parcel, 6, createFileRequest.PA);
        b.a(parcel, 7, createFileRequest.Oy, false);
        b.c(parcel, 8, createFileRequest.PB);
        b.c(parcel, 9, createFileRequest.PC);
        b.H(parcel, H);
    }

    public CreateFileRequest ah(Parcel parcel) {
        int i = 0;
        String str = null;
        int G = a.G(parcel);
        int i2 = 0;
        boolean z = false;
        Integer num = null;
        Contents contents = null;
        MetadataBundle metadataBundle = null;
        DriveId driveId = null;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i3 = a.g(parcel, F);
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
                    num = a.h(parcel, F);
                    break;
                case 6:
                    z = a.c(parcel, F);
                    break;
                case 7:
                    str = a.o(parcel, F);
                    break;
                case 8:
                    i2 = a.g(parcel, F);
                    break;
                case 9:
                    i = a.g(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new CreateFileRequest(i3, driveId, metadataBundle, contents, num, z, str, i2, i);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public CreateFileRequest[] bs(int i) {
        return new CreateFileRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ah(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bs(x0);
    }
}
