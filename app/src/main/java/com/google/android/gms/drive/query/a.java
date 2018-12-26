package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import java.util.List;

public class a implements Creator<Query> {
    static void a(Query query, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1000, query.CK);
        b.a(parcel, 1, query.RY, i, false);
        b.a(parcel, 3, query.RZ, false);
        b.a(parcel, 4, query.Sa, i, false);
        b.b(parcel, 5, query.Sb, false);
        b.H(parcel, H);
    }

    public Query aQ(Parcel parcel) {
        List list = null;
        int G = com.google.android.gms.common.internal.safeparcel.a.G(parcel);
        int i = 0;
        SortOrder sortOrder = null;
        String str = null;
        LogicalFilter logicalFilter = null;
        while (parcel.dataPosition() < G) {
            int F = com.google.android.gms.common.internal.safeparcel.a.F(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.aH(F)) {
                case 1:
                    logicalFilter = (LogicalFilter) com.google.android.gms.common.internal.safeparcel.a.a(parcel, F, LogicalFilter.CREATOR);
                    break;
                case 3:
                    str = com.google.android.gms.common.internal.safeparcel.a.o(parcel, F);
                    break;
                case 4:
                    sortOrder = (SortOrder) com.google.android.gms.common.internal.safeparcel.a.a(parcel, F, SortOrder.CREATOR);
                    break;
                case 5:
                    list = com.google.android.gms.common.internal.safeparcel.a.C(parcel, F);
                    break;
                case 1000:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, F);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new Query(i, logicalFilter, str, sortOrder, list);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + G, parcel);
    }

    public Query[] cf(int i) {
        return new Query[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aQ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cf(x0);
    }
}
