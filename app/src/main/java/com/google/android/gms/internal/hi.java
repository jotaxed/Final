package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class hi implements Creator<hh> {
    static void a(hh hhVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, hhVar.CX, false);
        b.c(parcel, 1000, hhVar.CK);
        b.a(parcel, 3, hhVar.CY, i, false);
        b.c(parcel, 4, hhVar.CZ);
        b.a(parcel, 5, hhVar.Da, false);
        b.H(parcel, H);
    }

    public hh[] L(int i) {
        return new hh[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return n(x0);
    }

    public hh n(Parcel parcel) {
        byte[] bArr = null;
        int G = a.G(parcel);
        int i = 0;
        int i2 = -1;
        hp hpVar = null;
        String str = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    str = a.o(parcel, F);
                    break;
                case 3:
                    hpVar = (hp) a.a(parcel, F, hp.CREATOR);
                    break;
                case 4:
                    i2 = a.g(parcel, F);
                    break;
                case 5:
                    bArr = a.r(parcel, F);
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
            return new hh(i, str, hpVar, i2, bArr);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return L(x0);
    }
}
