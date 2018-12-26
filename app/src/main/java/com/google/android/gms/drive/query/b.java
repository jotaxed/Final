package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.drive.query.internal.FieldWithSortOrder;
import java.util.List;

public class b implements Creator<SortOrder> {
    static void a(SortOrder sortOrder, Parcel parcel, int i) {
        int H = com.google.android.gms.common.internal.safeparcel.b.H(parcel);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 1000, sortOrder.CK);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 1, sortOrder.Sf, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, sortOrder.Sg);
        com.google.android.gms.common.internal.safeparcel.b.H(parcel, H);
    }

    public SortOrder aR(Parcel parcel) {
        boolean z = false;
        int G = a.G(parcel);
        List list = null;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    list = a.c(parcel, F, FieldWithSortOrder.CREATOR);
                    break;
                case 2:
                    z = a.c(parcel, F);
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
            return new SortOrder(i, list, z);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public SortOrder[] cg(int i) {
        return new SortOrder[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aR(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cg(x0);
    }
}
