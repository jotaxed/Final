package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class j implements Creator<ValuesSetDetails> {
    static void a(ValuesSetDetails valuesSetDetails, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, valuesSetDetails.CK);
        b.c(parcel, 2, valuesSetDetails.mIndex);
        b.c(parcel, 3, valuesSetDetails.SO);
        b.c(parcel, 4, valuesSetDetails.SP);
        b.H(parcel, H);
    }

    public ValuesSetDetails bp(Parcel parcel) {
        int i = 0;
        int G = a.G(parcel);
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i4 = a.g(parcel, F);
                    break;
                case 2:
                    i3 = a.g(parcel, F);
                    break;
                case 3:
                    i2 = a.g(parcel, F);
                    break;
                case 4:
                    i = a.g(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ValuesSetDetails(i4, i3, i2, i);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public ValuesSetDetails[] cF(int i) {
        return new ValuesSetDetails[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bp(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cF(x0);
    }
}
