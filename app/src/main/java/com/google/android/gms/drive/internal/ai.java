package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;

public class ai implements Creator<ListParentsRequest> {
    static void a(ListParentsRequest listParentsRequest, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, listParentsRequest.CK);
        b.a(parcel, 2, listParentsRequest.QE, i, false);
        b.H(parcel, H);
    }

    public ListParentsRequest ao(Parcel parcel) {
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
            return new ListParentsRequest(i, driveId);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public ListParentsRequest[] bD(int i) {
        return new ListParentsRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ao(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bD(x0);
    }
}
