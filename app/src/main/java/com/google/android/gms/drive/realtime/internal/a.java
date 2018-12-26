package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;

public class a implements Creator<BeginCompoundOperationRequest> {
    static void a(BeginCompoundOperationRequest beginCompoundOperationRequest, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, beginCompoundOperationRequest.CK);
        b.a(parcel, 2, beginCompoundOperationRequest.SF);
        b.a(parcel, 3, beginCompoundOperationRequest.mName, false);
        b.a(parcel, 4, beginCompoundOperationRequest.SG);
        b.H(parcel, H);
    }

    public BeginCompoundOperationRequest bc(Parcel parcel) {
        boolean z = false;
        int G = com.google.android.gms.common.internal.safeparcel.a.G(parcel);
        String str = null;
        boolean z2 = true;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = com.google.android.gms.common.internal.safeparcel.a.F(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.aH(F)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, F);
                    break;
                case 2:
                    z = com.google.android.gms.common.internal.safeparcel.a.c(parcel, F);
                    break;
                case 3:
                    str = com.google.android.gms.common.internal.safeparcel.a.o(parcel, F);
                    break;
                case 4:
                    z2 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, F);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new BeginCompoundOperationRequest(i, z, str, z2);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + G, parcel);
    }

    public BeginCompoundOperationRequest[] cr(int i) {
        return new BeginCompoundOperationRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bc(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cr(x0);
    }
}
