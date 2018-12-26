package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class h implements Creator<ValuesAddedDetails> {
    static void a(ValuesAddedDetails valuesAddedDetails, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, valuesAddedDetails.CK);
        b.c(parcel, 2, valuesAddedDetails.mIndex);
        b.c(parcel, 3, valuesAddedDetails.SO);
        b.c(parcel, 4, valuesAddedDetails.SP);
        b.a(parcel, 5, valuesAddedDetails.Tk, false);
        b.c(parcel, 6, valuesAddedDetails.Tl);
        b.H(parcel, H);
    }

    public ValuesAddedDetails bn(Parcel parcel) {
        int i = 0;
        int G = a.G(parcel);
        String str = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i5 = a.g(parcel, F);
                    break;
                case 2:
                    i4 = a.g(parcel, F);
                    break;
                case 3:
                    i3 = a.g(parcel, F);
                    break;
                case 4:
                    i2 = a.g(parcel, F);
                    break;
                case 5:
                    str = a.o(parcel, F);
                    break;
                case 6:
                    i = a.g(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ValuesAddedDetails(i5, i4, i3, i2, str, i);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public ValuesAddedDetails[] cD(int i) {
        return new ValuesAddedDetails[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bn(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cD(x0);
    }
}
