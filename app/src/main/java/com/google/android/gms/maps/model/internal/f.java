package com.google.android.gms.maps.model.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class f implements Creator<e> {
    static void a(e eVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, eVar.getVersionCode());
        b.a(parcel, 2, eVar.oj(), i, false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dr(x0);
    }

    public e dr(Parcel parcel) {
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
            return new e(i, aVar);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public e[] fn(int i) {
        return new e[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fn(x0);
    }
}
