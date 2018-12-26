package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.b;

public class d {
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
}
