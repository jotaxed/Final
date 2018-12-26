package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.pi.b.a;
import java.util.HashSet;
import java.util.Set;

public class pm implements Creator<a> {
    static void a(a aVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        Set set = aVar.aon;
        if (set.contains(Integer.valueOf(1))) {
            b.c(parcel, 1, aVar.CK);
        }
        if (set.contains(Integer.valueOf(2))) {
            b.c(parcel, 2, aVar.apJ);
        }
        if (set.contains(Integer.valueOf(3))) {
            b.c(parcel, 3, aVar.apK);
        }
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dC(x0);
    }

    public a dC(Parcel parcel) {
        int i = 0;
        int G = com.google.android.gms.common.internal.safeparcel.a.G(parcel);
        Set hashSet = new HashSet();
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = com.google.android.gms.common.internal.safeparcel.a.F(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.aH(F)) {
                case 1:
                    i3 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, F);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    i2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, F);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, F);
                    hashSet.add(Integer.valueOf(3));
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new a(hashSet, i3, i2, i);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + G, parcel);
    }

    public a[] fA(int i) {
        return new a[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fA(x0);
    }
}
