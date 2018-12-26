package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class j implements Creator<CreateFileIntentSenderRequest> {
    static void a(CreateFileIntentSenderRequest createFileIntentSenderRequest, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, createFileIntentSenderRequest.CK);
        b.a(parcel, 2, createFileIntentSenderRequest.Px, i, false);
        b.c(parcel, 3, createFileIntentSenderRequest.ve);
        b.a(parcel, 4, createFileIntentSenderRequest.OH, false);
        b.a(parcel, 5, createFileIntentSenderRequest.OJ, i, false);
        b.a(parcel, 6, createFileIntentSenderRequest.Py, false);
        b.H(parcel, H);
    }

    public CreateFileIntentSenderRequest ag(Parcel parcel) {
        int i = 0;
        Integer num = null;
        int G = a.G(parcel);
        DriveId driveId = null;
        String str = null;
        MetadataBundle metadataBundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i2 = a.g(parcel, F);
                    break;
                case 2:
                    metadataBundle = (MetadataBundle) a.a(parcel, F, MetadataBundle.CREATOR);
                    break;
                case 3:
                    i = a.g(parcel, F);
                    break;
                case 4:
                    str = a.o(parcel, F);
                    break;
                case 5:
                    driveId = (DriveId) a.a(parcel, F, DriveId.CREATOR);
                    break;
                case 6:
                    num = a.h(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new CreateFileIntentSenderRequest(i2, metadataBundle, i, str, driveId, num);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public CreateFileIntentSenderRequest[] br(int i) {
        return new CreateFileIntentSenderRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ag(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return br(x0);
    }
}
