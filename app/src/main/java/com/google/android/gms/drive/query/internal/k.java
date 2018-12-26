package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class k implements Creator<NotFilter> {
    static void a(NotFilter notFilter, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1000, notFilter.CK);
        b.a(parcel, 1, notFilter.Sv, i, false);
        b.H(parcel, H);
    }

    public NotFilter ba(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        FilterHolder filterHolder = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    filterHolder = (FilterHolder) a.a(parcel, F, FilterHolder.CREATOR);
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
            return new NotFilter(i, filterHolder);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public NotFilter[] cp(int i) {
        return new NotFilter[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ba(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cp(x0);
    }
}
