package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class au implements Creator<OnLoadRealtimeResponse> {
    static void a(OnLoadRealtimeResponse onLoadRealtimeResponse, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, onLoadRealtimeResponse.CK);
        b.a(parcel, 2, onLoadRealtimeResponse.wg);
        b.H(parcel, H);
    }

    public OnLoadRealtimeResponse az(Parcel parcel) {
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
            return new OnLoadRealtimeResponse(i, z);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public OnLoadRealtimeResponse[] bO(int i) {
        return new OnLoadRealtimeResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return az(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bO(x0);
    }
}
