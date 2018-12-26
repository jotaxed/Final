package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.DataSet;

public class f implements Creator<e> {
    static void a(e eVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, eVar.jH(), i, false);
        b.c(parcel, 1000, eVar.getVersionCode());
        b.H(parcel, H);
    }

    public e bK(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        DataSet dataSet = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    dataSet = (DataSet) a.a(parcel, F, DataSet.CREATOR);
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
            return new e(i, dataSet);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bK(x0);
    }

    public e[] de(int i) {
        return new e[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return de(x0);
    }
}
