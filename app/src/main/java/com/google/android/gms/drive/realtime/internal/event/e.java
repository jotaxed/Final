package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class e implements Creator<TextDeletedDetails> {
    static void a(TextDeletedDetails textDeletedDetails, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, textDeletedDetails.CK);
        b.c(parcel, 2, textDeletedDetails.mIndex);
        b.c(parcel, 3, textDeletedDetails.Ti);
        b.H(parcel, H);
    }

    public TextDeletedDetails bk(Parcel parcel) {
        int i = 0;
        int G = a.G(parcel);
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i3 = a.g(parcel, F);
                    break;
                case 2:
                    i2 = a.g(parcel, F);
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
            return new TextDeletedDetails(i3, i2, i);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public TextDeletedDetails[] cA(int i) {
        return new TextDeletedDetails[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bk(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cA(x0);
    }
}
