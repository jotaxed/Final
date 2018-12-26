package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;
import java.util.List;

public class i implements Creator<LogicalFilter> {
    static void a(LogicalFilter logicalFilter, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1000, logicalFilter.CK);
        b.a(parcel, 1, logicalFilter.Sh, i, false);
        b.c(parcel, 2, logicalFilter.Su, false);
        b.H(parcel, H);
    }

    public LogicalFilter aY(Parcel parcel) {
        List list = null;
        int G = a.G(parcel);
        int i = 0;
        Operator operator = null;
        while (parcel.dataPosition() < G) {
            int i2;
            Operator operator2;
            ArrayList c;
            int F = a.F(parcel);
            List list2;
            switch (a.aH(F)) {
                case 1:
                    i2 = i;
                    Operator operator3 = (Operator) a.a(parcel, F, Operator.CREATOR);
                    list2 = list;
                    operator2 = operator3;
                    break;
                case 2:
                    c = a.c(parcel, F, FilterHolder.CREATOR);
                    operator2 = operator;
                    i2 = i;
                    break;
                case 1000:
                    List list3 = list;
                    operator2 = operator;
                    i2 = a.g(parcel, F);
                    list2 = list3;
                    break;
                default:
                    a.b(parcel, F);
                    c = list;
                    operator2 = operator;
                    i2 = i;
                    break;
            }
            i = i2;
            operator = operator2;
            Object obj = c;
        }
        if (parcel.dataPosition() == G) {
            return new LogicalFilter(i, operator, list);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public LogicalFilter[] cn(int i) {
        return new LogicalFilter[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aY(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cn(x0);
    }
}
