package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class j implements Creator<Field> {
    static void a(Field field, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, field.getName(), false);
        b.c(parcel, 1000, field.getVersionCode());
        b.c(parcel, 2, field.getFormat());
        b.H(parcel, H);
    }

    public Field by(Parcel parcel) {
        int i = 0;
        int G = a.G(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    str = a.o(parcel, F);
                    break;
                case 2:
                    i = a.g(parcel, F);
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
            return new Field(i2, str, i);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public Field[] cR(int i) {
        return new Field[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return by(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cR(x0);
    }
}
