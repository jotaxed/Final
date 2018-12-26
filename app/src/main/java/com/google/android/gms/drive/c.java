package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class c implements Creator<DriveId> {
    static void a(DriveId driveId, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, driveId.CK);
        b.a(parcel, 2, driveId.Ot, false);
        b.a(parcel, 3, driveId.Ou);
        b.a(parcel, 4, driveId.Ov);
        b.H(parcel, H);
    }

    public DriveId S(Parcel parcel) {
        long j = 0;
        int G = a.G(parcel);
        int i = 0;
        String str = null;
        long j2 = 0;
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
                    j2 = a.i(parcel, F);
                    break;
                case 4:
                    j = a.i(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new DriveId(i, str, j2, j);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public DriveId[] aY(int i) {
        return new DriveId[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return S(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aY(x0);
    }
}
