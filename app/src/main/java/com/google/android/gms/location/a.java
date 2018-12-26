package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.nn;
import java.util.List;

public class a implements Creator<GeofencingRequest> {
    static void a(GeofencingRequest geofencingRequest, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, geofencingRequest.ng(), false);
        b.c(parcel, 1000, geofencingRequest.getVersionCode());
        b.c(parcel, 2, geofencingRequest.getInitialTrigger());
        b.H(parcel, H);
    }

    public GeofencingRequest cI(Parcel parcel) {
        int i = 0;
        int G = com.google.android.gms.common.internal.safeparcel.a.G(parcel);
        List list = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = com.google.android.gms.common.internal.safeparcel.a.F(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.aH(F)) {
                case 1:
                    list = com.google.android.gms.common.internal.safeparcel.a.c(parcel, F, nn.CREATOR);
                    break;
                case 2:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, F);
                    break;
                case 1000:
                    i2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, F);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new GeofencingRequest(i2, list, i);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cI(x0);
    }

    public GeofencingRequest[] ex(int i) {
        return new GeofencingRequest[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ex(x0);
    }
}
