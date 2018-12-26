package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.Field;
import java.util.List;

public class i implements Creator<DataTypeCreateRequest> {
    static void a(DataTypeCreateRequest dataTypeCreateRequest, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, dataTypeCreateRequest.getName(), false);
        b.c(parcel, 1000, dataTypeCreateRequest.getVersionCode());
        b.c(parcel, 2, dataTypeCreateRequest.getFields(), false);
        b.H(parcel, H);
    }

    public DataTypeCreateRequest bN(Parcel parcel) {
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
            return new DataTypeCreateRequest(i, str, list);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bN(x0);
    }

    public DataTypeCreateRequest[] dh(int i) {
        return new DataTypeCreateRequest[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dh(x0);
    }
}
