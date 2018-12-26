package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ip implements Creator<io> {
    static void a(io ioVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, ioVar.getVersionCode());
        b.a(parcel, 2, ioVar.fZ());
        b.a(parcel, 3, ioVar.gi());
        b.c(parcel, 4, ioVar.gj());
        b.a(parcel, 5, ioVar.getApplicationMetadata(), i, false);
        b.c(parcel, 6, ioVar.gk());
        b.H(parcel, H);
    }

    public io[] ai(int i) {
        return new io[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return y(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ai(x0);
    }

    public io y(Parcel parcel) {
        int i = 0;
        int G = a.G(parcel);
        double d = 0.0d;
        ApplicationMetadata applicationMetadata = null;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i3 = a.g(parcel, F);
                    break;
                case 2:
                    d = a.m(parcel, F);
                    break;
                case 3:
                    z = a.c(parcel, F);
                    break;
                case 4:
                    i2 = a.g(parcel, F);
                    break;
                case 5:
                    applicationMetadata = (ApplicationMetadata) a.a(parcel, F, ApplicationMetadata.CREATOR);
                    break;
                case 6:
                    i = a.g(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new io(i3, d, z, i2, applicationMetadata, i);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }
}
