package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.DataSource;

public class mt implements Creator<ms> {
    static void a(ms msVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, msVar.getDataSource(), i, false);
        b.c(parcel, 1000, msVar.getVersionCode());
        b.H(parcel, H);
    }

    public ms bH(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        DataSource dataSource = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    dataSource = (DataSource) a.a(parcel, F, DataSource.CREATOR);
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
            return new ms(i, dataSource);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bH(x0);
    }

    public ms[] db(int i) {
        return new ms[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return db(x0);
    }
}
