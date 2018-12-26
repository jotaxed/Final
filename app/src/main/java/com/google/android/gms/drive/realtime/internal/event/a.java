package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;

public class a implements Creator<ObjectChangedDetails> {
    static void a(ObjectChangedDetails objectChangedDetails, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, objectChangedDetails.CK);
        b.c(parcel, 2, objectChangedDetails.SO);
        b.c(parcel, 3, objectChangedDetails.SP);
        b.H(parcel, H);
    }

    public ObjectChangedDetails bg(Parcel parcel) {
        int i = 0;
        int G = com.google.android.gms.common.internal.safeparcel.a.G(parcel);
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = com.google.android.gms.common.internal.safeparcel.a.F(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.aH(F)) {
                case 1:
                    i3 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, F);
                    break;
                case 2:
                    i2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, F);
                    break;
                case 3:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, F);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ObjectChangedDetails(i3, i2, i);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bg(x0);
    }

    public ObjectChangedDetails[] cw(int i) {
        return new ObjectChangedDetails[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cw(x0);
    }
}
