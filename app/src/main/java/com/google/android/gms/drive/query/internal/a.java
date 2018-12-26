package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class a implements Creator<ComparisonFilter> {
    static void a(ComparisonFilter comparisonFilter, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1000, comparisonFilter.CK);
        b.a(parcel, 1, comparisonFilter.Sh, i, false);
        b.a(parcel, 2, comparisonFilter.Si, i, false);
        b.H(parcel, H);
    }

    public ComparisonFilter aS(Parcel parcel) {
        MetadataBundle metadataBundle = null;
        int G = com.google.android.gms.common.internal.safeparcel.a.G(parcel);
        int i = 0;
        Operator operator = null;
        while (parcel.dataPosition() < G) {
            int i2;
            MetadataBundle metadataBundle2;
            Operator operator2;
            int F = com.google.android.gms.common.internal.safeparcel.a.F(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.aH(F)) {
                case 1:
                    i2 = i;
                    Operator operator3 = (Operator) com.google.android.gms.common.internal.safeparcel.a.a(parcel, F, Operator.CREATOR);
                    metadataBundle2 = metadataBundle;
                    operator2 = operator3;
                    break;
                case 2:
                    metadataBundle2 = (MetadataBundle) com.google.android.gms.common.internal.safeparcel.a.a(parcel, F, MetadataBundle.CREATOR);
                    operator2 = operator;
                    i2 = i;
                    break;
                case 1000:
                    MetadataBundle metadataBundle3 = metadataBundle;
                    operator2 = operator;
                    i2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, F);
                    metadataBundle2 = metadataBundle3;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, F);
                    metadataBundle2 = metadataBundle;
                    operator2 = operator;
                    i2 = i;
                    break;
            }
            i = i2;
            operator = operator2;
            metadataBundle = metadataBundle2;
        }
        if (parcel.dataPosition() == G) {
            return new ComparisonFilter(i, operator, metadataBundle);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + G, parcel);
    }

    public ComparisonFilter[] ch(int i) {
        return new ComparisonFilter[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aS(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ch(x0);
    }
}
