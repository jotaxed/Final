package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.ko.a;

public class kq implements Creator<a> {
    static void a(a aVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, aVar.versionCode);
        b.a(parcel, 2, aVar.NJ, false);
        b.c(parcel, 3, aVar.NK);
        b.H(parcel, H);
    }

    public a L(Parcel parcel) {
        int i = 0;
        int G = com.google.android.gms.common.internal.safeparcel.a.G(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = com.google.android.gms.common.internal.safeparcel.a.F(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.aH(F)) {
                case 1:
                    i2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, F);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.a.o(parcel, F);
                    break;
                case 3:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, F);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new a(i2, str, i);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + G, parcel);
    }

    public a[] aM(int i) {
        return new a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return L(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aM(x0);
    }
}
