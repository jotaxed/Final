package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class nx implements Creator<nw> {
    static void a(nw nwVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, nwVar.CK);
        b.a(parcel, 2, nwVar.nw(), false);
        b.a(parcel, 3, nwVar.getTag(), false);
        b.a(parcel, 4, nwVar.getSource(), false);
        b.H(parcel, H);
    }

    public nw cR(Parcel parcel) {
        String str = null;
        int G = a.G(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    str3 = a.o(parcel, F);
                    break;
                case 3:
                    str2 = a.o(parcel, F);
                    break;
                case 4:
                    str = a.o(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new nw(i, str3, str2, str);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cR(x0);
    }

    public nw[] eN(int i) {
        return new nw[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eN(x0);
    }
}
