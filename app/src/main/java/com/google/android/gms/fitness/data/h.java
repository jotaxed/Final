package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public class h implements Creator<DataType> {
    static void a(DataType dataType, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, dataType.getName(), false);
        b.c(parcel, 1000, dataType.getVersionCode());
        b.c(parcel, 2, dataType.getFields(), false);
        b.H(parcel, H);
    }

    public DataType bw(Parcel parcel) {
        List list = null;
        int G = a.G(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    str = a.o(parcel, F);
                    break;
                case 2:
                    list = a.c(parcel, F, Field.CREATOR);
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
            return new DataType(i, str, list);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public DataType[] cP(int i) {
        return new DataType[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bw(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cP(x0);
    }
}
