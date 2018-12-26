package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ai implements Creator<ah> {
    static void a(ah ahVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1000, ahVar.getVersionCode());
        b.a(parcel, 2, ahVar.getDeviceAddress(), false);
        b.H(parcel, H);
    }

    public ah cb(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 2:
                    str = a.o(parcel, F);
                    break;
                case 1000:
                    i = a.g(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ah(i, str);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cb(x0);
    }

    public ah[] dw(int i) {
        return new ah[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dw(x0);
    }
}
