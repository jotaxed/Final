package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.pi.g;
import java.util.HashSet;
import java.util.Set;

public class pr implements Creator<g> {
    static void a(g gVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        Set set = gVar.aon;
        if (set.contains(Integer.valueOf(1))) {
            b.c(parcel, 1, gVar.CK);
        }
        if (set.contains(Integer.valueOf(2))) {
            b.a(parcel, 2, gVar.apR);
        }
        if (set.contains(Integer.valueOf(3))) {
            b.a(parcel, 3, gVar.mValue, true);
        }
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dH(x0);
    }

    public g dH(Parcel parcel) {
        boolean z = false;
        int G = a.G(parcel);
        Set hashSet = new HashSet();
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    z = a.c(parcel, F);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    str = a.o(parcel, F);
                    hashSet.add(Integer.valueOf(3));
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new g(hashSet, i, z, str);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public g[] fF(int i) {
        return new g[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fF(x0);
    }
}
