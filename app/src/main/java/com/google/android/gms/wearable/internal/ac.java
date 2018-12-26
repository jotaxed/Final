package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ac implements Creator<ab> {
    static void a(ab abVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, abVar.versionCode);
        b.c(parcel, 2, abVar.statusCode);
        b.a(parcel, 3, abVar.axO, i, false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ex(x0);
    }

    public ab ex(Parcel parcel) {
        int i = 0;
        int G = a.G(parcel);
        al alVar = null;
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
                    alVar = (al) a.a(parcel, F, al.CREATOR);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ab(i2, i, alVar);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public ab[] gG(int i) {
        return new ab[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gG(x0);
    }
}
