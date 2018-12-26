package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class c implements Creator<CircleOptions> {
    static void a(CircleOptions circleOptions, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, circleOptions.getVersionCode());
        b.a(parcel, 2, circleOptions.getCenter(), i, false);
        b.a(parcel, 3, circleOptions.getRadius());
        b.a(parcel, 4, circleOptions.getStrokeWidth());
        b.c(parcel, 5, circleOptions.getStrokeColor());
        b.c(parcel, 6, circleOptions.getFillColor());
        b.a(parcel, 7, circleOptions.getZIndex());
        b.a(parcel, 8, circleOptions.isVisible());
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return db(x0);
    }

    public CircleOptions db(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int G = a.G(parcel);
        LatLng latLng = null;
        double d = 0.0d;
        int i = 0;
        int i2 = 0;
        float f2 = 0.0f;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i3 = a.g(parcel, F);
                    break;
                case 2:
                    latLng = (LatLng) a.a(parcel, F, LatLng.CREATOR);
                    break;
                case 3:
                    d = a.m(parcel, F);
                    break;
                case 4:
                    f2 = a.l(parcel, F);
                    break;
                case 5:
                    i2 = a.g(parcel, F);
                    break;
                case 6:
                    i = a.g(parcel, F);
                    break;
                case 7:
                    f = a.l(parcel, F);
                    break;
                case 8:
                    z = a.c(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new CircleOptions(i3, latLng, d, f2, i2, i, f, z);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public CircleOptions[] eX(int i) {
        return new CircleOptions[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eX(x0);
    }
}
