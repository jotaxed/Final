package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.pi.d;
import java.util.HashSet;
import java.util.Set;

public class pp implements Creator<d> {
    static void a(d dVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        Set set = dVar.aon;
        if (set.contains(Integer.valueOf(1))) {
            b.c(parcel, 1, dVar.CK);
        }
        if (set.contains(Integer.valueOf(2))) {
            b.a(parcel, 2, dVar.aoL, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            b.a(parcel, 3, dVar.apL, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            b.a(parcel, 4, dVar.aoO, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            b.a(parcel, 5, dVar.apM, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            b.a(parcel, 6, dVar.apN, true);
        }
        if (set.contains(Integer.valueOf(7))) {
            b.a(parcel, 7, dVar.apO, true);
        }
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dF(x0);
    }

    public d dF(Parcel parcel) {
        String str = null;
        int G = a.G(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str6 = a.o(parcel, F);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    str5 = a.o(parcel, F);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    str4 = a.o(parcel, F);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str3 = a.o(parcel, F);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    str2 = a.o(parcel, F);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case 7:
                    str = a.o(parcel, F);
                    hashSet.add(Integer.valueOf(7));
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new d(hashSet, i, str6, str5, str4, str3, str2, str);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public d[] fD(int i) {
        return new d[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fD(x0);
    }
}
