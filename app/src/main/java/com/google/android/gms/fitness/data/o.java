package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public class o implements Creator<RawDataSet> {
    static void a(RawDataSet rawDataSet, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, rawDataSet.UJ);
        b.c(parcel, 1000, rawDataSet.CK);
        b.c(parcel, 2, rawDataSet.UL);
        b.c(parcel, 3, rawDataSet.UM, false);
        b.a(parcel, 4, rawDataSet.Uc);
        b.H(parcel, H);
    }

    public RawDataSet bB(Parcel parcel) {
        boolean z = false;
        int G = a.G(parcel);
        List list = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i2 = a.g(parcel, F);
                    break;
                case 2:
                    i = a.g(parcel, F);
                    break;
                case 3:
                    list = a.c(parcel, F, RawDataPoint.CREATOR);
                    break;
                case 4:
                    z = a.c(parcel, F);
                    break;
                case 1000:
                    i3 = a.g(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new RawDataSet(i3, i2, i, list, z);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public RawDataSet[] cU(int i) {
        return new RawDataSet[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bB(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cU(x0);
    }
}
