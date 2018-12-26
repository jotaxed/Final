package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class b implements Creator<FieldOnlyFilter> {
    static void a(FieldOnlyFilter fieldOnlyFilter, Parcel parcel, int i) {
        int H = com.google.android.gms.common.internal.safeparcel.b.H(parcel);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 1000, fieldOnlyFilter.CK);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 1, fieldOnlyFilter.Si, i, false);
        com.google.android.gms.common.internal.safeparcel.b.H(parcel, H);
    }

    public FieldOnlyFilter aT(Parcel parcel) {
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
            return new FieldOnlyFilter(i, metadataBundle);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public FieldOnlyFilter[] ci(int i) {
        return new FieldOnlyFilter[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aT(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ci(x0);
    }
}
