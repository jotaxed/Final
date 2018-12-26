package com.google.android.gms.maps.internal;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class z implements Creator<y> {
    static void a(y yVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, yVar.getVersionCode());
        b.a(parcel, 2, yVar.oa(), i, false);
        b.H(parcel, H);
    }

    public y cZ(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        Point point = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    point = (Point) a.a(parcel, F, Point.CREATOR);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new y(i, point);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cZ(x0);
    }

    public y[] eV(int i) {
        return new y[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eV(x0);
    }
}
