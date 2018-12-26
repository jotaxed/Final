package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class y implements Creator<VisibleRegion> {
    static void a(VisibleRegion visibleRegion, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, visibleRegion.getVersionCode());
        b.a(parcel, 2, visibleRegion.nearLeft, i, false);
        b.a(parcel, 3, visibleRegion.nearRight, i, false);
        b.a(parcel, 4, visibleRegion.farLeft, i, false);
        b.a(parcel, 5, visibleRegion.farRight, i, false);
        b.a(parcel, 6, visibleRegion.latLngBounds, i, false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return do(x0);
    }

    public VisibleRegion do(Parcel parcel) {
        LatLngBounds latLngBounds = null;
        int G = a.G(parcel);
        int i = 0;
        LatLng latLng = null;
        LatLng latLng2 = null;
        LatLng latLng3 = null;
        LatLng latLng4 = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    latLng4 = (LatLng) a.a(parcel, F, LatLng.CREATOR);
                    break;
                case 3:
                    latLng3 = (LatLng) a.a(parcel, F, LatLng.CREATOR);
                    break;
                case 4:
                    latLng2 = (LatLng) a.a(parcel, F, LatLng.CREATOR);
                    break;
                case 5:
                    latLng = (LatLng) a.a(parcel, F, LatLng.CREATOR);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) a.a(parcel, F, LatLngBounds.CREATOR);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new VisibleRegion(i, latLng4, latLng3, latLng2, latLng, latLngBounds);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public VisibleRegion[] fk(int i) {
        return new VisibleRegion[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fk(x0);
    }
}
