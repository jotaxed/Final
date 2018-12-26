package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class hk implements Creator<hj> {
    static void a(hj hjVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, hjVar.id);
        b.c(parcel, 1000, hjVar.CK);
        b.a(parcel, 2, hjVar.Db, false);
        b.H(parcel, H);
    }

    public hj[] M(int i) {
        return new hj[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return o(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return M(x0);
    }

    public hj o(Parcel parcel) {
        int i = 0;
        int G = a.G(parcel);
        Bundle bundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    bundle = a.q(parcel, F);
                    break;
                case 1000:
                    i2 = a.g(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new hj(i2, i, bundle);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }
}
