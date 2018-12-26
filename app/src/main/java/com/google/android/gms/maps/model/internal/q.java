package com.google.android.gms.maps.model.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class q implements Creator<p> {
    static void a(p pVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, pVar.getVersionCode());
        b.a(parcel, 2, pVar.ol(), i, false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ds(x0);
    }

    public p ds(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        a aVar = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    aVar = (a) a.a(parcel, F, a.CREATOR);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new p(i, aVar);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public p[] fp(int i) {
        return new p[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fp(x0);
    }
}
