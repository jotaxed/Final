package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class kz implements Creator<ky> {
    static void a(ky kyVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, kyVar.getVersionCode());
        b.a(parcel, 2, kyVar.ic(), false);
        b.a(parcel, 3, kyVar.id(), i, false);
        b.H(parcel, H);
    }

    public ky Q(Parcel parcel) {
        kv kvVar = null;
        int G = a.G(parcel);
        int i = 0;
        Parcel parcel2 = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    parcel2 = a.D(parcel, F);
                    break;
                case 3:
                    kvVar = (kv) a.a(parcel, F, kv.CREATOR);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ky(i, parcel2, kvVar);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public ky[] aR(int i) {
        return new ky[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return Q(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aR(x0);
    }
}
