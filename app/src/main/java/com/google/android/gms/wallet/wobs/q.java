package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class q implements Creator<p> {
    static void a(p pVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, pVar.getVersionCode());
        b.a(parcel, 2, pVar.awT, false);
        b.a(parcel, 3, pVar.tU, false);
        b.a(parcel, 4, pVar.awX, i, false);
        b.a(parcel, 5, pVar.awY, i, false);
        b.a(parcel, 6, pVar.awZ, i, false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ek(x0);
    }

    public p ek(Parcel parcel) {
        n nVar = null;
        int G = a.G(parcel);
        int i = 0;
        n nVar2 = null;
        l lVar = null;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    str2 = a.o(parcel, F);
                    break;
                case 3:
                    str = a.o(parcel, F);
                    break;
                case 4:
                    lVar = (l) a.a(parcel, F, l.CREATOR);
                    break;
                case 5:
                    nVar2 = (n) a.a(parcel, F, n.CREATOR);
                    break;
                case 6:
                    nVar = (n) a.a(parcel, F, n.CREATOR);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new p(i, str2, str, lVar, nVar2, nVar);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public p[] gt(int i) {
        return new p[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gt(x0);
    }
}
