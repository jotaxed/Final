package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class e implements Creator<GroundOverlayOptions> {
    static void a(GroundOverlayOptions groundOverlayOptions, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, groundOverlayOptions.getVersionCode());
        b.a(parcel, 2, groundOverlayOptions.od(), false);
        b.a(parcel, 3, groundOverlayOptions.getLocation(), i, false);
        b.a(parcel, 4, groundOverlayOptions.getWidth());
        b.a(parcel, 5, groundOverlayOptions.getHeight());
        b.a(parcel, 6, groundOverlayOptions.getBounds(), i, false);
        b.a(parcel, 7, groundOverlayOptions.getBearing());
        b.a(parcel, 8, groundOverlayOptions.getZIndex());
        b.a(parcel, 9, groundOverlayOptions.isVisible());
        b.a(parcel, 10, groundOverlayOptions.getTransparency());
        b.a(parcel, 11, groundOverlayOptions.getAnchorU());
        b.a(parcel, 12, groundOverlayOptions.getAnchorV());
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dc(x0);
    }

    public GroundOverlayOptions dc(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        IBinder iBinder = null;
        LatLng latLng = null;
        float f = 0.0f;
        float f2 = 0.0f;
        LatLngBounds latLngBounds = null;
        float f3 = 0.0f;
        float f4 = 0.0f;
        boolean z = false;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    iBinder = a.p(parcel, F);
                    break;
                case 3:
                    latLng = (LatLng) a.a(parcel, F, LatLng.CREATOR);
                    break;
                case 4:
                    f = a.l(parcel, F);
                    break;
                case 5:
                    f2 = a.l(parcel, F);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) a.a(parcel, F, LatLngBounds.CREATOR);
                    break;
                case 7:
                    f3 = a.l(parcel, F);
                    break;
                case 8:
                    f4 = a.l(parcel, F);
                    break;
                case 9:
                    z = a.c(parcel, F);
                    break;
                case 10:
                    f5 = a.l(parcel, F);
                    break;
                case 11:
                    f6 = a.l(parcel, F);
                    break;
                case 12:
                    f7 = a.l(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new GroundOverlayOptions(i, iBinder, latLng, f, f2, latLngBounds, f3, f4, z, f5, f6, f7);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public GroundOverlayOptions[] eY(int i) {
        return new GroundOverlayOptions[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eY(x0);
    }
}
