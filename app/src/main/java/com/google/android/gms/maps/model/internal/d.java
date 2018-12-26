package com.google.android.gms.maps.model.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class d implements Creator<c> {
    static void a(c cVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, cVar.getVersionCode());
        b.c(parcel, 2, cVar.getType());
        b.a(parcel, 3, cVar.oi(), false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dq(x0);
    }

    public c dq(Parcel parcel) {
        int i = 0;
        int G = a.G(parcel);
        Bundle bundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i2 = a.g(parcel, F);
                    break;
                case 2:
                    i = a.g(parcel, F);
                    break;
                case 3:
                    bundle = a.q(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new c(i2, i, bundle);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public c[] fm(int i) {
        return new c[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fm(x0);
    }
}
