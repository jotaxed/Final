package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ac implements Creator<GetDriveIdFromUniqueIdentifierRequest> {
    static void a(GetDriveIdFromUniqueIdentifierRequest getDriveIdFromUniqueIdentifierRequest, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, getDriveIdFromUniqueIdentifierRequest.CK);
        b.a(parcel, 2, getDriveIdFromUniqueIdentifierRequest.QC, false);
        b.a(parcel, 3, getDriveIdFromUniqueIdentifierRequest.QD);
        b.H(parcel, H);
    }

    public GetDriveIdFromUniqueIdentifierRequest am(Parcel parcel) {
        boolean z = false;
        int G = a.G(parcel);
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    str = a.o(parcel, F);
                    break;
                case 3:
                    z = a.c(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new GetDriveIdFromUniqueIdentifierRequest(i, str, z);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public GetDriveIdFromUniqueIdentifierRequest[] bB(int i) {
        return new GetDriveIdFromUniqueIdentifierRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return am(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bB(x0);
    }
}
