package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.internal.pi.b.b;
import java.util.HashSet;
import java.util.Set;

public class pn implements Creator<b> {
    static void a(b bVar, Parcel parcel, int i) {
        int H = com.google.android.gms.common.internal.safeparcel.b.H(parcel);
        Set set = bVar.aon;
        if (set.contains(Integer.valueOf(1))) {
            com.google.android.gms.common.internal.safeparcel.b.c(parcel, 1, bVar.CK);
        }
        if (set.contains(Integer.valueOf(2))) {
            com.google.android.gms.common.internal.safeparcel.b.c(parcel, 2, bVar.lj);
        }
        if (set.contains(Integer.valueOf(3))) {
            com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, bVar.vf, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            com.google.android.gms.common.internal.safeparcel.b.c(parcel, 4, bVar.li);
        }
        com.google.android.gms.common.internal.safeparcel.b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dD(x0);
    }

    public b dD(Parcel parcel) {
        int i = 0;
        int G = a.G(parcel);
        Set hashSet = new HashSet();
        String str = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i3 = a.g(parcel, F);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    i2 = a.g(parcel, F);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    str = a.o(parcel, F);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    i = a.g(parcel, F);
                    hashSet.add(Integer.valueOf(4));
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new b(hashSet, i3, i2, str, i);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public b[] fB(int i) {
        return new b[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fB(x0);
    }
}
