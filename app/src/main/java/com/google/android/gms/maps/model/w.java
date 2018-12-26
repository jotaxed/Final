package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class w implements Creator<TileOverlayOptions> {
    static void a(TileOverlayOptions tileOverlayOptions, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, tileOverlayOptions.getVersionCode());
        b.a(parcel, 2, tileOverlayOptions.og(), false);
        b.a(parcel, 3, tileOverlayOptions.isVisible());
        b.a(parcel, 4, tileOverlayOptions.getZIndex());
        b.a(parcel, 5, tileOverlayOptions.getFadeIn());
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dn(x0);
    }

    public TileOverlayOptions dn(Parcel parcel) {
        boolean z = false;
        int G = a.G(parcel);
        IBinder iBinder = null;
        float f = 0.0f;
        boolean z2 = true;
        int i = 0;
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
                    z = a.c(parcel, F);
                    break;
                case 4:
                    f = a.l(parcel, F);
                    break;
                case 5:
                    z2 = a.c(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new TileOverlayOptions(i, iBinder, z, f, z2);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public TileOverlayOptions[] fj(int i) {
        return new TileOverlayOptions[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fj(x0);
    }
}
