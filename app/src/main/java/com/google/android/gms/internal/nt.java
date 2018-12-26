package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class nt implements Creator<ns> {
    static void a(ns nsVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, nsVar.np());
        b.c(parcel, 1000, nsVar.getVersionCode());
        b.c(parcel, 2, nsVar.ns());
        b.a(parcel, 3, nsVar.nt(), i, false);
        b.H(parcel, H);
    }

    public ns cP(Parcel parcel) {
        int i = 0;
        int G = a.G(parcel);
        int i2 = -1;
        nu nuVar = null;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    i2 = a.g(parcel, F);
                    break;
                case 3:
                    nuVar = (nu) a.a(parcel, F, nu.CREATOR);
                    break;
                case 1000:
                    i3 = a.g(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ns(i3, i, i2, nuVar);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cP(x0);
    }

    public ns[] eL(int i) {
        return new ns[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eL(x0);
    }
}
