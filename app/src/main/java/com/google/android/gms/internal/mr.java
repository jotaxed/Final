package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.DataType;
import java.util.List;

public class mr implements Creator<mq> {
    static void a(mq mqVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, mqVar.getDataTypes(), false);
        b.c(parcel, 1000, mqVar.getVersionCode());
        b.H(parcel, H);
    }

    public mq bG(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    list = a.c(parcel, F, DataType.CREATOR);
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
            return new mq(i, list);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bG(x0);
    }

    public mq[] da(int i) {
        return new mq[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return da(x0);
    }
}
