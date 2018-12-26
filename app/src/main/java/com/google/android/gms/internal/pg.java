package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.HashSet;
import java.util.Set;

public class pg implements Creator<pf> {
    static void a(pf pfVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        Set set = pfVar.aon;
        if (set.contains(Integer.valueOf(1))) {
            b.c(parcel, 1, pfVar.CK);
        }
        if (set.contains(Integer.valueOf(2))) {
            b.a(parcel, 2, pfVar.CE, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            b.a(parcel, 4, pfVar.api, i, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            b.a(parcel, 5, pfVar.apa, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            b.a(parcel, 6, pfVar.apj, i, true);
        }
        if (set.contains(Integer.valueOf(7))) {
            b.a(parcel, 7, pfVar.vc, true);
        }
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dy(x0);
    }

    public pf dy(Parcel parcel) {
        String str = null;
        int G = a.G(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        pd pdVar = null;
        String str2 = null;
        pd pdVar2 = null;
        String str3 = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            pd pdVar3;
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str3 = a.o(parcel, F);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 4:
                    pdVar3 = (pd) a.a(parcel, F, pd.CREATOR);
                    hashSet.add(Integer.valueOf(4));
                    pdVar2 = pdVar3;
                    break;
                case 5:
                    str2 = a.o(parcel, F);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    pdVar3 = (pd) a.a(parcel, F, pd.CREATOR);
                    hashSet.add(Integer.valueOf(6));
                    pdVar = pdVar3;
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
            return new pf(hashSet, i, str3, pdVar2, str2, pdVar, str);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public pf[] fw(int i) {
        return new pf[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fw(x0);
    }
}
