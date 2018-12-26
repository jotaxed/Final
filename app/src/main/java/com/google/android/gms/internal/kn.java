package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class kn implements Creator<km> {
    static void a(km kmVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, kmVar.getVersionCode());
        b.a(parcel, 2, kmVar.hF(), i, false);
        b.H(parcel, H);
    }

    public km J(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        ko koVar = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    koVar = (ko) a.a(parcel, F, ko.CREATOR);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new km(i, koVar);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public km[] aK(int i) {
        return new km[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return J(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aK(x0);
    }
}
