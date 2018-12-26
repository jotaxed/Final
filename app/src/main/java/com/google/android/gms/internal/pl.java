package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.internal.pi.b;
import java.util.HashSet;
import java.util.Set;

public class pl implements Creator<b> {
    static void a(b bVar, Parcel parcel, int i) {
        int H = com.google.android.gms.common.internal.safeparcel.b.H(parcel);
        Set set = bVar.aon;
        if (set.contains(Integer.valueOf(1))) {
            com.google.android.gms.common.internal.safeparcel.b.c(parcel, 1, bVar.CK);
        }
        if (set.contains(Integer.valueOf(2))) {
            com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, bVar.apG, i, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, bVar.apH, i, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            com.google.android.gms.common.internal.safeparcel.b.c(parcel, 4, bVar.apI);
        }
        com.google.android.gms.common.internal.safeparcel.b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dB(x0);
    }

    public b dB(Parcel parcel) {
        b.b bVar = null;
        int i = 0;
        int G = a.G(parcel);
        Set hashSet = new HashSet();
        b.a aVar = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i2 = a.g(parcel, F);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    b.a aVar2 = (b.a) a.a(parcel, F, b.a.CREATOR);
                    hashSet.add(Integer.valueOf(2));
                    aVar = aVar2;
                    break;
                case 3:
                    b.b bVar2 = (b.b) a.a(parcel, F, b.b.CREATOR);
                    hashSet.add(Integer.valueOf(3));
                    bVar = bVar2;
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
            return new b(hashSet, i2, aVar, bVar, i);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public b[] fz(int i) {
        return new b[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fz(x0);
    }
}
