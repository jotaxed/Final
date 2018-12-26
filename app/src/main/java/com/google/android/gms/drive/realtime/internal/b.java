package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;

public class b implements Creator<EndCompoundOperationRequest> {
    static void a(EndCompoundOperationRequest endCompoundOperationRequest, Parcel parcel, int i) {
        int H = com.google.android.gms.common.internal.safeparcel.b.H(parcel);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 1, endCompoundOperationRequest.CK);
        com.google.android.gms.common.internal.safeparcel.b.H(parcel, H);
    }

    public EndCompoundOperationRequest bd(Parcel parcel) {
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
            return new EndCompoundOperationRequest(i);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bd(x0);
    }

    public EndCompoundOperationRequest[] cs(int i) {
        return new EndCompoundOperationRequest[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cs(x0);
    }
}
