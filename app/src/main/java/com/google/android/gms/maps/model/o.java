package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public class o implements Creator<PolylineOptions> {
    static void a(PolylineOptions polylineOptions, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, polylineOptions.getVersionCode());
        b.c(parcel, 2, polylineOptions.getPoints(), false);
        b.a(parcel, 3, polylineOptions.getWidth());
        b.c(parcel, 4, polylineOptions.getColor());
        b.a(parcel, 5, polylineOptions.getZIndex());
        b.a(parcel, 6, polylineOptions.isVisible());
        b.a(parcel, 7, polylineOptions.isGeodesic());
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dh(x0);
    }

    public PolylineOptions dh(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int G = a.G(parcel);
        List list = null;
        boolean z2 = false;
        int i = 0;
        float f2 = 0.0f;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i2 = a.g(parcel, F);
                    break;
                case 2:
                    list = a.c(parcel, F, LatLng.CREATOR);
                    break;
                case 3:
                    f2 = a.l(parcel, F);
                    break;
                case 4:
                    i = a.g(parcel, F);
                    break;
                case 5:
                    f = a.l(parcel, F);
                    break;
                case 6:
                    z2 = a.c(parcel, F);
                    break;
                case 7:
                    z = a.c(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new PolylineOptions(i2, list, f2, i, f, z2, z);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public PolylineOptions[] fd(int i) {
        return new PolylineOptions[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fd(x0);
    }
}
