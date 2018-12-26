package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class o implements Creator<DisconnectRequest> {
    static void a(DisconnectRequest disconnectRequest, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, disconnectRequest.CK);
        b.H(parcel, H);
    }

    public DisconnectRequest ak(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new DisconnectRequest(i);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public DisconnectRequest[] bv(int i) {
        return new DisconnectRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ak(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bv(x0);
    }
}
