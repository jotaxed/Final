package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class h implements Creator<g> {
    static void a(g gVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, gVar.getVersionCode());
        b.c(parcel, 2, gVar.awN);
        b.a(parcel, 3, gVar.awO, false);
        b.a(parcel, 4, gVar.awP);
        b.a(parcel, 5, gVar.awQ, false);
        b.a(parcel, 6, gVar.awR);
        b.c(parcel, 7, gVar.awS);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ef(x0);
    }

    public g ef(Parcel parcel) {
        String str = null;
        int i = 0;
        int G = a.G(parcel);
        double d = 0.0d;
        long j = 0;
        int i2 = -1;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i3 = a.g(parcel, F);
                    break;
                case 2:
                    i = a.g(parcel, F);
                    break;
                case 3:
                    str2 = a.o(parcel, F);
                    break;
                case 4:
                    d = a.m(parcel, F);
                    break;
                case 5:
                    str = a.o(parcel, F);
                    break;
                case 6:
                    j = a.i(parcel, F);
                    break;
                case 7:
                    i2 = a.g(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new g(i3, i, str2, d, str, j, i2);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public g[] go(int i) {
        return new g[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return go(x0);
    }
}
