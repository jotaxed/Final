package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class j implements Creator<MatchAllFilter> {
    static void a(MatchAllFilter matchAllFilter, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1000, matchAllFilter.CK);
        b.H(parcel, H);
    }

    public MatchAllFilter aZ(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1000:
                    i = a.g(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new MatchAllFilter(i);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public MatchAllFilter[] co(int i) {
        return new MatchAllFilter[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aZ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return co(x0);
    }
}
