package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class hg implements Creator<hf> {
    static void a(hf hfVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, hfVar.CS, false);
        b.c(parcel, 1000, hfVar.CK);
        b.a(parcel, 2, hfVar.CT, false);
        b.a(parcel, 3, hfVar.CU, false);
        b.H(parcel, H);
    }

    public hf[] K(int i) {
        return new hf[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m(x0);
    }

    public hf m(Parcel parcel) {
        String str = null;
        int G = a.G(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    str3 = a.o(parcel, F);
                    break;
                case 2:
                    str2 = a.o(parcel, F);
                    break;
                case 3:
                    str = a.o(parcel, F);
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
            return new hf(i, str3, str2, str);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return K(x0);
    }
}
