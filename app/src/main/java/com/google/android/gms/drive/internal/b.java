package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.drive.DriveId;

public class b implements Creator<AuthorizeAccessRequest> {
    static void a(AuthorizeAccessRequest authorizeAccessRequest, Parcel parcel, int i) {
        int H = com.google.android.gms.common.internal.safeparcel.b.H(parcel);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 1, authorizeAccessRequest.CK);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, authorizeAccessRequest.Pn);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, authorizeAccessRequest.Oj, i, false);
        com.google.android.gms.common.internal.safeparcel.b.H(parcel, H);
    }

    public AuthorizeAccessRequest aa(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        long j = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    j = a.i(parcel, F);
                    break;
                case 3:
                    driveId = (DriveId) a.a(parcel, F, DriveId.CREATOR);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new AuthorizeAccessRequest(i, j, driveId);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public AuthorizeAccessRequest[] bk(int i) {
        return new AuthorizeAccessRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aa(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bk(x0);
    }
}
