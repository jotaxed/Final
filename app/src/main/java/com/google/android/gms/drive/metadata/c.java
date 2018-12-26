package com.google.android.gms.drive.metadata;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class c implements Creator<CustomPropertyKey> {
    static void a(CustomPropertyKey customPropertyKey, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, customPropertyKey.CK);
        b.a(parcel, 2, customPropertyKey.KP, false);
        b.c(parcel, 3, customPropertyKey.mVisibility);
        b.H(parcel, H);
    }

    public CustomPropertyKey aM(Parcel parcel) {
        int i = 0;
        int G = a.G(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i2 = a.g(parcel, F);
                    break;
                case 2:
                    str = a.o(parcel, F);
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
            return new CustomPropertyKey(i2, str, i);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public CustomPropertyKey[] cb(int i) {
        return new CustomPropertyKey[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aM(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cb(x0);
    }
}
