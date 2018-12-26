package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class kl implements Creator<kk> {
    static void a(kk kkVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, kkVar.CK);
        b.a(parcel, 2, kkVar.ND, false);
        b.c(parcel, 3, kkVar.NE);
        b.H(parcel, H);
    }

    public kk I(Parcel parcel) {
        int i = 0;
        int G = a.G(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i2 = a.g(parcel, F);
                    break;
                case 2:
                    str = a.o(parcel, F);
                    break;
                case 3:
                    i = a.g(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new kk(i2, str, i);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public kk[] aJ(int i) {
        return new kk[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return I(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aJ(x0);
    }
}
