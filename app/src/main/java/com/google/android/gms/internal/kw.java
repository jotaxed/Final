package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class kw implements Creator<kv> {
    static void a(kv kvVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, kvVar.getVersionCode());
        b.c(parcel, 2, kvVar.hZ(), false);
        b.a(parcel, 3, kvVar.ia(), false);
        b.H(parcel, H);
    }

    public kv O(Parcel parcel) {
        String str = null;
        int G = a.G(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    arrayList = a.c(parcel, F, kv.a.CREATOR);
                    break;
                case 3:
                    str = a.o(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new kv(i, arrayList, str);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public kv[] aP(int i) {
        return new kv[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return O(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aP(x0);
    }
}
