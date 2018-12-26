package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;
import java.util.List;

public class m implements Creator<PolygonOptions> {
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

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dg(x0);
    }

    public PolygonOptions dg(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int G = a.G(parcel);
        List list = null;
        List arrayList = new ArrayList();
        boolean z2 = false;
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
                    list = a.c(parcel, F, LatLng.CREATOR);
                    break;
                case 3:
                    a.a(parcel, F, arrayList, getClass().getClassLoader());
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
                    z2 = a.c(parcel, F);
                    break;
                case 9:
                    z = a.c(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new PolygonOptions(i3, list, arrayList, f2, i2, i, f, z2, z);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public PolygonOptions[] fc(int i) {
        return new PolygonOptions[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fc(x0);
    }
}
