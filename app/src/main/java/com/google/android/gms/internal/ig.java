package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ig implements Creator<if> {
    static void a(if ifVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, ifVar.responseCode);
        b.c(parcel, 1000, ifVar.versionCode);
        b.a(parcel, 2, ifVar.Ep, false);
        b.a(parcel, 3, ifVar.Eq, false);
        b.H(parcel, H);
    }

    public if[] U(int i) {
        return new if[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return t(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return U(x0);
    }

    public if t(Parcel parcel) {
        byte[] bArr = null;
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
                case 3:
                    bArr = a.r(parcel, F);
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
            return new if(i2, i, bundle, bArr);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }
}
