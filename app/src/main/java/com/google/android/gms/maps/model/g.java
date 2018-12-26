package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class g implements Creator<LatLngBounds> {
    static void a(LatLngBounds latLngBounds, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, latLngBounds.getVersionCode());
        b.a(parcel, 2, latLngBounds.southwest, i, false);
        b.a(parcel, 3, latLngBounds.northeast, i, false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dd(x0);
    }

    public LatLngBounds dd(Parcel parcel) {
        LatLng latLng = null;
        int G = a.G(parcel);
        int i = 0;
        LatLng latLng2 = null;
        while (parcel.dataPosition() < G) {
            int g;
            LatLng latLng3;
            int F = a.F(parcel);
            LatLng latLng4;
            switch (a.aH(F)) {
                case 1:
                    latLng4 = latLng;
                    latLng = latLng2;
                    g = a.g(parcel, F);
                    latLng3 = latLng4;
                    break;
                case 2:
                    g = i;
                    latLng4 = (LatLng) a.a(parcel, F, LatLng.CREATOR);
                    latLng3 = latLng;
                    latLng = latLng4;
                    break;
                case 3:
                    latLng3 = (LatLng) a.a(parcel, F, LatLng.CREATOR);
                    latLng = latLng2;
                    g = i;
                    break;
                default:
                    a.b(parcel, F);
                    latLng3 = latLng;
                    latLng = latLng2;
                    g = i;
                    break;
            }
            i = g;
            latLng2 = latLng;
            latLng = latLng3;
        }
        if (parcel.dataPosition() == G) {
            return new LatLngBounds(i, latLng2, latLng);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public LatLngBounds[] eZ(int i) {
        return new LatLngBounds[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eZ(x0);
    }
}
