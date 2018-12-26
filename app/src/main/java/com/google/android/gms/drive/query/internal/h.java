package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class h implements Creator<InFilter> {
    static void a(InFilter inFilter, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1000, inFilter.CK);
        b.a(parcel, 1, inFilter.Si, i, false);
        b.H(parcel, H);
    }

    public InFilter aX(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        MetadataBundle metadataBundle = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    metadataBundle = (MetadataBundle) a.a(parcel, F, MetadataBundle.CREATOR);
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
            return new InFilter(i, metadataBundle);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public InFilter[] cm(int i) {
        return new InFilter[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aX(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cm(x0);
    }
}
