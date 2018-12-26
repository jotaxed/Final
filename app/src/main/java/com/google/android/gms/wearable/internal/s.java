package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.wearable.c;

public class s implements Creator<r> {
    static void a(r rVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, rVar.versionCode);
        b.c(parcel, 2, rVar.statusCode);
        b.a(parcel, 3, rVar.axJ, i, false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return es(x0);
    }

    public r es(Parcel parcel) {
        int i = 0;
        int G = a.G(parcel);
        c cVar = null;
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
                    cVar = (c) a.a(parcel, F, c.CREATOR);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new r(i2, i, cVar);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public r[] gB(int i) {
        return new r[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gB(x0);
    }
}
