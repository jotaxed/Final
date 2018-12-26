package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;

public class ay implements Creator<OpenContentsRequest> {
    static void a(OpenContentsRequest openContentsRequest, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, openContentsRequest.CK);
        b.a(parcel, 2, openContentsRequest.Pp, i, false);
        b.c(parcel, 3, openContentsRequest.Oi);
        b.c(parcel, 4, openContentsRequest.QT);
        b.H(parcel, H);
    }

    public OpenContentsRequest aD(Parcel parcel) {
        int i = 0;
        int G = a.G(parcel);
        DriveId driveId = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            DriveId driveId2;
            int g;
            int F = a.F(parcel);
            int i4;
            switch (a.aH(F)) {
                case 1:
                    i4 = i;
                    i = i2;
                    driveId2 = driveId;
                    g = a.g(parcel, F);
                    F = i4;
                    break;
                case 2:
                    g = i3;
                    i4 = i2;
                    driveId2 = (DriveId) a.a(parcel, F, DriveId.CREATOR);
                    F = i;
                    i = i4;
                    break;
                case 3:
                    driveId2 = driveId;
                    g = i3;
                    i4 = i;
                    i = a.g(parcel, F);
                    F = i4;
                    break;
                case 4:
                    F = a.g(parcel, F);
                    i = i2;
                    driveId2 = driveId;
                    g = i3;
                    break;
                default:
                    a.b(parcel, F);
                    F = i;
                    i = i2;
                    driveId2 = driveId;
                    g = i3;
                    break;
            }
            i3 = g;
            driveId = driveId2;
            i2 = i;
            i = F;
        }
        if (parcel.dataPosition() == G) {
            return new OpenContentsRequest(i3, driveId, i2, i);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public OpenContentsRequest[] bS(int i) {
        return new OpenContentsRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aD(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bS(x0);
    }
}
