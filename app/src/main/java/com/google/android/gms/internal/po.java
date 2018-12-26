package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.pi.c;
import java.util.HashSet;
import java.util.Set;

public class po implements Creator<c> {
    static void a(c cVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        Set set = cVar.aon;
        if (set.contains(Integer.valueOf(1))) {
            b.c(parcel, 1, cVar.CK);
        }
        if (set.contains(Integer.valueOf(2))) {
            b.a(parcel, 2, cVar.vf, true);
        }
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dE(x0);
    }

    public c dE(Parcel parcel) {
        int G = a.G(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str = a.o(parcel, F);
                    hashSet.add(Integer.valueOf(2));
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new c(hashSet, i, str);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public c[] fC(int i) {
        return new c[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fC(x0);
    }
}
