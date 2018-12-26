package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class aq implements Creator<ap> {
    static void a(ap apVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, apVar.versionCode);
        b.c(parcel, 2, apVar.statusCode);
        b.a(parcel, 3, apVar.axM, i, false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return eB(x0);
    }

    public ap eB(Parcel parcel) {
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
            return new ap(i2, i, mVar);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public ap[] gK(int i) {
        return new ap[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gK(x0);
    }
}
