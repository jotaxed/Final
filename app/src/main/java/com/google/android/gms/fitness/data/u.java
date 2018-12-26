package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class u implements Creator<Value> {
    static void a(Value value, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, value.getFormat());
        b.c(parcel, 1000, value.getVersionCode());
        b.a(parcel, 2, value.isSet());
        b.a(parcel, 3, value.jL());
        b.H(parcel, H);
    }

    public Value bF(Parcel parcel) {
        boolean z = false;
        int G = a.G(parcel);
        float f = 0.0f;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    z = a.c(parcel, F);
                    break;
                case 3:
                    f = a.l(parcel, F);
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
            return new Value(i2, i, z, f);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public Value[] cZ(int i) {
        return new Value[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bF(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cZ(x0);
    }
}
