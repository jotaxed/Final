package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class y implements Creator<x> {
    static void a(x xVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, xVar.versionCode);
        b.c(parcel, 2, xVar.statusCode);
        b.a(parcel, 3, xVar.axM, i, false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ev(x0);
    }

    public x ev(Parcel parcel) {
        int i = 0;
        int G = a.G(parcel);
        m mVar = null;
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
                    mVar = (m) a.a(parcel, F, m.CREATOR);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new x(i2, i, mVar);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public x[] gE(int i) {
        return new x[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gE(x0);
    }
}
