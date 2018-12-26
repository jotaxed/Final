package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.Subscription;

public class ag implements Creator<af> {
    static void a(af afVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, afVar.kn(), i, false);
        b.c(parcel, 1000, afVar.getVersionCode());
        b.a(parcel, 2, afVar.ko());
        b.H(parcel, H);
    }

    public af ca(Parcel parcel) {
        boolean z = false;
        int G = a.G(parcel);
        Subscription subscription = null;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int i2;
            boolean z2;
            Subscription subscription2;
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i2 = i;
                    Subscription subscription3 = (Subscription) a.a(parcel, F, Subscription.CREATOR);
                    z2 = z;
                    subscription2 = subscription3;
                    break;
                case 2:
                    z2 = a.c(parcel, F);
                    subscription2 = subscription;
                    i2 = i;
                    break;
                case 1000:
                    boolean z3 = z;
                    subscription2 = subscription;
                    i2 = a.g(parcel, F);
                    z2 = z3;
                    break;
                default:
                    a.b(parcel, F);
                    z2 = z;
                    subscription2 = subscription;
                    i2 = i;
                    break;
            }
            i = i2;
            subscription = subscription2;
            z = z2;
        }
        if (parcel.dataPosition() == G) {
            return new af(i, subscription, z);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ca(x0);
    }

    public af[] dv(int i) {
        return new af[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dv(x0);
    }
}
