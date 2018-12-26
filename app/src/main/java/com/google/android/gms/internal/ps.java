package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.pi.h;
import java.util.HashSet;
import java.util.Set;

public class ps implements Creator<h> {
    static void a(h hVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        Set set = hVar.aon;
        if (set.contains(Integer.valueOf(1))) {
            b.c(parcel, 1, hVar.CK);
        }
        if (set.contains(Integer.valueOf(3))) {
            b.c(parcel, 3, hVar.oU());
        }
        if (set.contains(Integer.valueOf(4))) {
            b.a(parcel, 4, hVar.mValue, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            b.a(parcel, 5, hVar.XL, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            b.c(parcel, 6, hVar.Gt);
        }
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dI(x0);
    }

    public h dI(Parcel parcel) {
        String str = null;
        int i = 0;
        int G = a.G(parcel);
        Set hashSet = new HashSet();
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i3 = a.g(parcel, F);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 3:
                    i = a.g(parcel, F);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    str = a.o(parcel, F);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str2 = a.o(parcel, F);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    i2 = a.g(parcel, F);
                    hashSet.add(Integer.valueOf(6));
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new h(hashSet, i3, str2, i2, str, i);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public h[] fG(int i) {
        return new h[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fG(x0);
    }
}
