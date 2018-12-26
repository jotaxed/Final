package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class au implements Creator<at> {
    static void a(at atVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, atVar.versionCode);
        b.c(parcel, 2, atVar.statusCode);
        b.c(parcel, 3, atVar.ayd);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return eD(x0);
    }

    public at eD(Parcel parcel) {
        int i = 0;
        int G = a.G(parcel);
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i3 = a.g(parcel, F);
                    break;
                case 2:
                    i2 = a.g(parcel, F);
                    break;
                case 3:
                    i = a.g(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new at(i3, i2, i);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public at[] gM(int i) {
        return new at[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gM(x0);
    }
}
