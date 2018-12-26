package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class k implements Creator<j> {
    static void a(j jVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, jVar.getName(), false);
        b.c(parcel, 1000, jVar.getVersionCode());
        b.H(parcel, H);
    }

    public j bO(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
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
            return new j(i, str);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bO(x0);
    }

    public j[] di(int i) {
        return new j[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return di(x0);
    }
}
