package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;

public class a implements Creator<CameraPosition> {
    static void a(CameraPosition cameraPosition, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, cameraPosition.getVersionCode());
        b.a(parcel, 2, cameraPosition.target, i, false);
        b.a(parcel, 3, cameraPosition.zoom);
        b.a(parcel, 4, cameraPosition.tilt);
        b.a(parcel, 5, cameraPosition.bearing);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return da(x0);
    }

    public CameraPosition da(Parcel parcel) {
        float f = 0.0f;
        int G = com.google.android.gms.common.internal.safeparcel.a.G(parcel);
        int i = 0;
        LatLng latLng = null;
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (parcel.dataPosition() < G) {
            int F = com.google.android.gms.common.internal.safeparcel.a.F(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.aH(F)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, F);
                    break;
                case 2:
                    latLng = (LatLng) com.google.android.gms.common.internal.safeparcel.a.a(parcel, F, LatLng.CREATOR);
                    break;
                case 3:
                    f3 = com.google.android.gms.common.internal.safeparcel.a.l(parcel, F);
                    break;
                case 4:
                    f2 = com.google.android.gms.common.internal.safeparcel.a.l(parcel, F);
                    break;
                case 5:
                    f = com.google.android.gms.common.internal.safeparcel.a.l(parcel, F);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new CameraPosition(i, latLng, f3, f2, f);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + G, parcel);
    }

    public CameraPosition[] eW(int i) {
        return new CameraPosition[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eW(x0);
    }
}
