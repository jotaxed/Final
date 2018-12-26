package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class kp implements Creator<ko> {
    static void a(ko koVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, koVar.getVersionCode());
        b.c(parcel, 2, koVar.hH(), false);
        b.H(parcel, H);
    }

    public ko K(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    arrayList = a.c(parcel, F, ko.a.CREATOR);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ko(i, arrayList);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public ko[] aL(int i) {
        return new ko[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return K(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aL(x0);
    }
}
