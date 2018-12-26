package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.b;

public class n {
    static void a(PolygonOptions polygonOptions, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, polygonOptions.getVersionCode());
        b.c(parcel, 2, polygonOptions.getPoints(), false);
        b.d(parcel, 3, polygonOptions.of(), false);
        b.a(parcel, 4, polygonOptions.getStrokeWidth());
        b.c(parcel, 5, polygonOptions.getStrokeColor());
        b.c(parcel, 6, polygonOptions.getFillColor());
        b.a(parcel, 7, polygonOptions.getZIndex());
        b.a(parcel, 8, polygonOptions.isVisible());
        b.a(parcel, 9, polygonOptions.isGeodesic());
        b.H(parcel, H);
    }
}
