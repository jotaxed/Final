package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class q implements Creator<ParcelableIndexReference> {
    static void a(ParcelableIndexReference parcelableIndexReference, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, parcelableIndexReference.CK);
        b.a(parcel, 2, parcelableIndexReference.SM, false);
        b.c(parcel, 3, parcelableIndexReference.mIndex);
        b.a(parcel, 4, parcelableIndexReference.SN);
        b.H(parcel, H);
    }

    public ParcelableIndexReference bf(Parcel parcel) {
        boolean z = false;
        int G = a.G(parcel);
        String str = null;
        int i = 0;
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
                case 4:
                    z = a.c(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ParcelableIndexReference(i2, str, i, z);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bf(x0);
    }

    public ParcelableIndexReference[] cv(int i) {
        return new ParcelableIndexReference[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cv(x0);
    }
}
