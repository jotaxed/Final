package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class px implements Creator<pw> {
    static void a(pw pwVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, pwVar.getVersionCode());
        b.a(parcel, 2, pwVar.avX, false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dX(x0);
    }

    public pw dX(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        int[] iArr = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    iArr = a.u(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new pw(i, iArr);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public pw[] ge(int i) {
        return new pw[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ge(x0);
    }
}
