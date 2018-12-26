package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ne implements Creator<nd> {
    static void a(nd ndVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, ndVar.uid);
        b.c(parcel, 1000, ndVar.getVersionCode());
        b.a(parcel, 2, ndVar.packageName, false);
        b.H(parcel, H);
    }

    public nd cL(Parcel parcel) {
        int i = 0;
        int G = a.G(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    str = a.o(parcel, F);
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
            return new nd(i2, i, str);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cL(x0);
    }

    public nd[] eF(int i) {
        return new nd[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eF(x0);
    }
}
