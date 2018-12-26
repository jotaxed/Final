package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class g implements Creator<HasFilter> {
    static void a(HasFilter hasFilter, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1000, hasFilter.CK);
        b.a(parcel, 1, hasFilter.Si, i, false);
        b.H(parcel, H);
    }

    public HasFilter aW(Parcel parcel) {
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
            return new HasFilter(i, metadataBundle);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public HasFilter[] cl(int i) {
        return new HasFilter[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aW(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cl(x0);
    }
}
