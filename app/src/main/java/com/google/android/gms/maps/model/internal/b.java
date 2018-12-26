package com.google.android.gms.maps.model.internal;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;

public class b implements Creator<a> {
    static void a(a aVar, Parcel parcel, int i) {
        int H = com.google.android.gms.common.internal.safeparcel.b.H(parcel);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 1, aVar.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, aVar.oh());
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, aVar.oi(), false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 4, aVar.getBitmap(), i, false);
        com.google.android.gms.common.internal.safeparcel.b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dp(x0);
    }

    public a dp(Parcel parcel) {
        Bitmap bitmap = null;
        byte b = (byte) 0;
        int G = a.G(parcel);
        Bundle bundle = null;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    b = a.e(parcel, F);
                    break;
                case 3:
                    bundle = a.q(parcel, F);
                    break;
                case 4:
                    bitmap = (Bitmap) a.a(parcel, F, Bitmap.CREATOR);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new a(i, b, bundle, bitmap);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public a[] fl(int i) {
        return new a[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fl(x0);
    }
}
