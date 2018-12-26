package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class d implements Creator<FilterHolder> {
    static void a(FilterHolder filterHolder, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, filterHolder.Sl, i, false);
        b.c(parcel, 1000, filterHolder.CK);
        b.a(parcel, 2, filterHolder.Sm, i, false);
        b.a(parcel, 3, filterHolder.Sn, i, false);
        b.a(parcel, 4, filterHolder.So, i, false);
        b.a(parcel, 5, filterHolder.Sp, i, false);
        b.a(parcel, 6, filterHolder.Sq, i, false);
        b.a(parcel, 7, filterHolder.Sr, i, false);
        b.H(parcel, H);
    }

    public FilterHolder aV(Parcel parcel) {
        HasFilter hasFilter = null;
        int G = a.G(parcel);
        int i = 0;
        MatchAllFilter matchAllFilter = null;
        InFilter inFilter = null;
        NotFilter notFilter = null;
        LogicalFilter logicalFilter = null;
        FieldOnlyFilter fieldOnlyFilter = null;
        ComparisonFilter comparisonFilter = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    comparisonFilter = (ComparisonFilter) a.a(parcel, F, ComparisonFilter.CREATOR);
                    break;
                case 2:
                    fieldOnlyFilter = (FieldOnlyFilter) a.a(parcel, F, FieldOnlyFilter.CREATOR);
                    break;
                case 3:
                    logicalFilter = (LogicalFilter) a.a(parcel, F, LogicalFilter.CREATOR);
                    break;
                case 4:
                    notFilter = (NotFilter) a.a(parcel, F, NotFilter.CREATOR);
                    break;
                case 5:
                    inFilter = (InFilter) a.a(parcel, F, InFilter.CREATOR);
                    break;
                case 6:
                    matchAllFilter = (MatchAllFilter) a.a(parcel, F, MatchAllFilter.CREATOR);
                    break;
                case 7:
                    hasFilter = (HasFilter) a.a(parcel, F, HasFilter.CREATOR);
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
            return new FilterHolder(i, comparisonFilter, fieldOnlyFilter, logicalFilter, notFilter, inFilter, matchAllFilter, hasFilter);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public FilterHolder[] ck(int i) {
        return new FilterHolder[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aV(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ck(x0);
    }
}
