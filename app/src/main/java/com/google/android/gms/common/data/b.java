package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;

public class b implements Creator<a> {
    static void a(a aVar, Parcel parcel, int i) {
        int H = com.google.android.gms.common.internal.safeparcel.b.H(parcel);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 1, aVar.CK);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, aVar.KS, i, false);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 3, aVar.Gt);
        com.google.android.gms.common.internal.safeparcel.b.H(parcel, H);
    }

    public a A(Parcel parcel) {
        int i = 0;
        int G = a.G(parcel);
        ParcelFileDescriptor parcelFileDescriptor = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            ParcelFileDescriptor parcelFileDescriptor2;
            int g;
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    int i3 = i;
                    parcelFileDescriptor2 = parcelFileDescriptor;
                    g = a.g(parcel, F);
                    F = i3;
                    break;
                case 2:
                    g = i2;
                    ParcelFileDescriptor parcelFileDescriptor3 = (ParcelFileDescriptor) a.a(parcel, F, ParcelFileDescriptor.CREATOR);
                    F = i;
                    parcelFileDescriptor2 = parcelFileDescriptor3;
                    break;
                case 3:
                    F = a.g(parcel, F);
                    parcelFileDescriptor2 = parcelFileDescriptor;
                    g = i2;
                    break;
                default:
                    a.b(parcel, F);
                    F = i;
                    parcelFileDescriptor2 = parcelFileDescriptor;
                    g = i2;
                    break;
            }
            i2 = g;
            parcelFileDescriptor = parcelFileDescriptor2;
            i = F;
        }
        if (parcel.dataPosition() == G) {
            return new a(i2, parcelFileDescriptor, i);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public a[] ar(int i) {
        return new a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return A(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ar(x0);
    }
}
