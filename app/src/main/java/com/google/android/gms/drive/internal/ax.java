package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ax implements Creator<OnSyncMoreResponse> {
    static void a(OnSyncMoreResponse onSyncMoreResponse, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, onSyncMoreResponse.CK);
        b.a(parcel, 2, onSyncMoreResponse.PJ);
        b.H(parcel, H);
    }

    public OnSyncMoreResponse aC(Parcel parcel) {
        boolean z = false;
        int G = a.G(parcel);
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    z = a.c(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new OnSyncMoreResponse(i, z);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public OnSyncMoreResponse[] bR(int i) {
        return new OnSyncMoreResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aC(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bR(x0);
    }
}
