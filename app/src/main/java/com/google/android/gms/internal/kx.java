package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.kv.a;
import java.util.ArrayList;

public class kx implements Creator<a> {
    static void a(a aVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, aVar.versionCode);
        b.a(parcel, 2, aVar.className, false);
        b.c(parcel, 3, aVar.NY, false);
        b.H(parcel, H);
    }

    public a P(Parcel parcel) {
        ArrayList arrayList = null;
        int G = com.google.android.gms.common.internal.safeparcel.a.G(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < G) {
            int F = com.google.android.gms.common.internal.safeparcel.a.F(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.aH(F)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, F);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.a.o(parcel, F);
                    break;
                case 3:
                    arrayList = com.google.android.gms.common.internal.safeparcel.a.c(parcel, F, kv.b.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new a(i, str, arrayList);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + G, parcel);
    }

    public a[] aQ(int i) {
        return new a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return P(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aQ(x0);
    }
}
