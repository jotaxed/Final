package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;

public class ad implements Creator<GetMetadataRequest> {
    static void a(GetMetadataRequest getMetadataRequest, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, getMetadataRequest.CK);
        b.a(parcel, 2, getMetadataRequest.Pp, i, false);
        b.H(parcel, H);
    }

    public GetMetadataRequest an(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    driveId = (DriveId) a.a(parcel, F, DriveId.CREATOR);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new GetMetadataRequest(i, driveId);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public GetMetadataRequest[] bC(int i) {
        return new GetMetadataRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return an(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bC(x0);
    }
}
