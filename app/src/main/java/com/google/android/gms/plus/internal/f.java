package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class f implements Creator<PlusCommonExtras> {
    static void a(PlusCommonExtras plusCommonExtras, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, plusCommonExtras.ox(), false);
        b.c(parcel, 1000, plusCommonExtras.getVersionCode());
        b.a(parcel, 2, plusCommonExtras.oy(), false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dv(x0);
    }

    public PlusCommonExtras dv(Parcel parcel) {
        String str = null;
        int G = a.G(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    str2 = a.o(parcel, F);
                    break;
                case 2:
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
            return new PlusCommonExtras(i, str2, str);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public PlusCommonExtras[] ft(int i) {
        return new PlusCommonExtras[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ft(x0);
    }
}
