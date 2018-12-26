package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class c implements Creator<FieldWithSortOrder> {
    static void a(FieldWithSortOrder fieldWithSortOrder, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1000, fieldWithSortOrder.CK);
        b.a(parcel, 1, fieldWithSortOrder.QY, false);
        b.a(parcel, 2, fieldWithSortOrder.Sk);
        b.H(parcel, H);
    }

    public FieldWithSortOrder aU(Parcel parcel) {
        boolean z = false;
        int G = a.G(parcel);
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    str = a.o(parcel, F);
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
            return new FieldWithSortOrder(i, str, z);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public FieldWithSortOrder[] cj(int i) {
        return new FieldWithSortOrder[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aU(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cj(x0);
    }
}
