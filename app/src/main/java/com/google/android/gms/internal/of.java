package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class of implements Creator<oe> {
    static void a(oe oeVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, oeVar.vc, false);
        b.c(parcel, 1000, oeVar.CK);
        b.c(parcel, 2, oeVar.ake);
        b.H(parcel, H);
    }

    public oe cV(Parcel parcel) {
        int i = 0;
        int G = a.G(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    str = a.o(parcel, F);
                    break;
                case 2:
                    i = a.g(parcel, F);
                    break;
                case 1000:
                    i2 = a.g(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new oe(i2, str, i);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cV(x0);
    }

    public oe[] eR(int i) {
        return new oe[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eR(x0);
    }
}
