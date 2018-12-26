package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class u implements Creator<Tile> {
    static void a(Tile tile, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, tile.getVersionCode());
        b.c(parcel, 2, tile.width);
        b.c(parcel, 3, tile.height);
        b.a(parcel, 4, tile.data, false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dm(x0);
    }

    public Tile dm(Parcel parcel) {
        int i = 0;
        int G = a.G(parcel);
        byte[] bArr = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i3 = a.g(parcel, F);
                    break;
                case 2:
                    i2 = a.g(parcel, F);
                    break;
                case 3:
                    i = a.g(parcel, F);
                    break;
                case 4:
                    bArr = a.r(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new Tile(i3, i2, i, bArr);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public Tile[] fi(int i) {
        return new Tile[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fi(x0);
    }
}
