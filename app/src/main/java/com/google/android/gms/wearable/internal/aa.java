package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class aa implements Creator<z> {
    static void a(z zVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, zVar.versionCode);
        b.c(parcel, 2, zVar.statusCode);
        b.a(parcel, 3, zVar.axN, i, false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ew(x0);
    }

    public z ew(Parcel parcel) {
        int i = 0;
        int G = a.G(parcel);
        ParcelFileDescriptor parcelFileDescriptor = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i2 = a.g(parcel, F);
                    break;
                case 2:
                    i = a.g(parcel, F);
                    break;
                case 3:
                    parcelFileDescriptor = (ParcelFileDescriptor) a.a(parcel, F, ParcelFileDescriptor.CREATOR);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new z(i2, i, parcelFileDescriptor);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public z[] gF(int i) {
        return new z[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gF(x0);
    }
}
