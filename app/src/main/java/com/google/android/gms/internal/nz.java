package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class nz implements Creator<ny> {
    static void a(ny nyVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1000, nyVar.CK);
        b.a(parcel, 2, nyVar.nt(), i, false);
        b.a(parcel, 3, nyVar.getInterval());
        b.c(parcel, 4, nyVar.getPriority());
        b.H(parcel, H);
    }

    public ny cS(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        nu nuVar = null;
        long j = ny.ahz;
        int i2 = 102;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 2:
                    nuVar = (nu) a.a(parcel, F, nu.CREATOR);
                    break;
                case 3:
                    j = a.i(parcel, F);
                    break;
                case 4:
                    i2 = a.g(parcel, F);
                    break;
                case 1000:
                    i = a.g(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ny(i, nuVar, j, i2);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cS(x0);
    }

    public ny[] eO(int i) {
        return new ny[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eO(x0);
    }
}
