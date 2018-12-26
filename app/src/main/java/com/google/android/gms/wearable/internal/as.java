package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class as implements Creator<ar> {
    static void a(ar arVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, arVar.CK);
        b.a(parcel, 2, arVar.rm(), false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return eC(x0);
    }

    public ar eC(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    iBinder = a.p(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ar(i, iBinder);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public ar[] gL(int i) {
        return new ar[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gL(x0);
    }
}
