package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.wearable.c;

public class u implements Creator<t> {
    static void a(t tVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, tVar.versionCode);
        b.c(parcel, 2, tVar.statusCode);
        b.a(parcel, 3, tVar.axK, i, false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return et(x0);
    }

    public t et(Parcel parcel) {
        int i = 0;
        int G = a.G(parcel);
        c[] cVarArr = null;
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
                    cVarArr = (c[]) a.b(parcel, F, c.CREATOR);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new t(i2, i, cVarArr);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public t[] gC(int i) {
        return new t[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gC(x0);
    }
}
