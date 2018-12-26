package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class h implements Creator<MetadataBundle> {
    static void a(MetadataBundle metadataBundle, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, metadataBundle.CK);
        b.a(parcel, 2, metadataBundle.Ri, false);
        b.H(parcel, H);
    }

    public MetadataBundle aP(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        Bundle bundle = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    bundle = a.q(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new MetadataBundle(i, bundle);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public MetadataBundle[] ce(int i) {
        return new MetadataBundle[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aP(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ce(x0);
    }
}
