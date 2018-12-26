package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.internal.hl.b;
import java.util.ArrayList;
import java.util.List;

public class hn implements Creator<b> {
    static void a(b bVar, Parcel parcel, int i) {
        int H = com.google.android.gms.common.internal.safeparcel.b.H(parcel);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 1000, bVar.CK);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 1, bVar.Dd, i, false);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 2, bVar.De, false);
        com.google.android.gms.common.internal.safeparcel.b.H(parcel, H);
    }

    public b[] O(int i) {
        return new b[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return q(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return O(x0);
    }

    public b q(Parcel parcel) {
        List list = null;
        int G = a.G(parcel);
        int i = 0;
        Status status = null;
        while (parcel.dataPosition() < G) {
            int i2;
            Status status2;
            ArrayList c;
            int F = a.F(parcel);
            List list2;
            switch (a.aH(F)) {
                case 1:
                    i2 = i;
                    Status status3 = (Status) a.a(parcel, F, Status.CREATOR);
                    list2 = list;
                    status2 = status3;
                    break;
                case 2:
                    c = a.c(parcel, F, hr.CREATOR);
                    status2 = status;
                    i2 = i;
                    break;
                case 1000:
                    List list3 = list;
                    status2 = status;
                    i2 = a.g(parcel, F);
                    list2 = list3;
                    break;
                default:
                    a.b(parcel, F);
                    c = list;
                    status2 = status;
                    i2 = i;
                    break;
            }
            i = i2;
            status = status2;
            Object obj = c;
        }
        if (parcel.dataPosition() == G) {
            return new b(i, status, list);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }
}
