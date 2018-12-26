package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class g implements Creator<ValueChangedDetails> {
    static void a(ValueChangedDetails valueChangedDetails, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, valueChangedDetails.CK);
        b.c(parcel, 2, valueChangedDetails.Tj);
        b.H(parcel, H);
    }

    public ValueChangedDetails bm(Parcel parcel) {
        int i = 0;
        int G = a.G(parcel);
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i2 = a.g(parcel, F);
                    break;
                case 2:
                    i = a.g(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ValueChangedDetails(i2, i);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public ValueChangedDetails[] cC(int i) {
        return new ValueChangedDetails[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bm(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cC(x0);
    }
}
