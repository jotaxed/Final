package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.DataType;

public class n implements Creator<m> {
    static void a(m mVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, mVar.getDataType(), i, false);
        b.c(parcel, 1000, mVar.getVersionCode());
        b.H(parcel, H);
    }

    public m bP(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        DataType dataType = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    dataType = (DataType) a.a(parcel, F, DataType.CREATOR);
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
            return new m(i, dataType);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bP(x0);
    }

    public m[] dj(int i) {
        return new m[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dj(x0);
    }
}
