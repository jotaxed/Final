package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class no implements Creator<nn> {
    static void a(nn nnVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, nnVar.getRequestId(), false);
        b.c(parcel, 1000, nnVar.getVersionCode());
        b.a(parcel, 2, nnVar.getExpirationTime());
        b.a(parcel, 3, nnVar.nn());
        b.a(parcel, 4, nnVar.getLatitude());
        b.a(parcel, 5, nnVar.getLongitude());
        b.a(parcel, 6, nnVar.no());
        b.c(parcel, 7, nnVar.np());
        b.c(parcel, 8, nnVar.getNotificationResponsiveness());
        b.c(parcel, 9, nnVar.nq());
        b.H(parcel, H);
    }

    public nn cN(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        String str = null;
        int i2 = 0;
        short s = (short) 0;
        double d = 0.0d;
        double d2 = 0.0d;
        float f = 0.0f;
        long j = 0;
        int i3 = 0;
        int i4 = -1;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    str = a.o(parcel, F);
                    break;
                case 2:
                    j = a.i(parcel, F);
                    break;
                case 3:
                    s = a.f(parcel, F);
                    break;
                case 4:
                    d = a.m(parcel, F);
                    break;
                case 5:
                    d2 = a.m(parcel, F);
                    break;
                case 6:
                    f = a.l(parcel, F);
                    break;
                case 7:
                    i2 = a.g(parcel, F);
                    break;
                case 8:
                    i3 = a.g(parcel, F);
                    break;
                case 9:
                    i4 = a.g(parcel, F);
                    break;
                case 1000:
                    i = a.g(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new nn(i, str, i2, s, d, d2, f, j, i3, i4);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cN(x0);
    }

    public nn[] eJ(int i) {
        return new nn[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eJ(x0);
    }
}
