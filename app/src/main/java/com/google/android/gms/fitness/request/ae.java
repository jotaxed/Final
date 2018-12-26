package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ae implements Creator<ad> {
    static void a(ad adVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, adVar.km(), false);
        b.c(parcel, 1000, adVar.getVersionCode());
        b.H(parcel, H);
    }

    public ad bZ(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    iBinder = a.p(parcel, F);
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
            return new ad(i, iBinder);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bZ(x0);
    }

    public ad[] du(int i) {
        return new ad[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return du(x0);
    }
}
