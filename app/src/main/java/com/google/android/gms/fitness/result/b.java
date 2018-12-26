package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;
import java.util.List;

public class b implements Creator<DataReadResult> {
    static void a(DataReadResult dataReadResult, Parcel parcel, int i) {
        int H = com.google.android.gms.common.internal.safeparcel.b.H(parcel);
        com.google.android.gms.common.internal.safeparcel.b.d(parcel, 1, dataReadResult.kt(), false);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 1000, dataReadResult.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, dataReadResult.getStatus(), i, false);
        com.google.android.gms.common.internal.safeparcel.b.d(parcel, 3, dataReadResult.ks(), false);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 5, dataReadResult.kr());
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 6, dataReadResult.jw(), false);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 7, dataReadResult.ku(), false);
        com.google.android.gms.common.internal.safeparcel.b.H(parcel, H);
    }

    public DataReadResult ce(Parcel parcel) {
        int i = 0;
        List list = null;
        int G = a.G(parcel);
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        List list2 = null;
        Status status = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    a.a(parcel, F, arrayList, getClass().getClassLoader());
                    break;
                case 2:
                    status = (Status) a.a(parcel, F, Status.CREATOR);
                    break;
                case 3:
                    a.a(parcel, F, arrayList2, getClass().getClassLoader());
                    break;
                case 5:
                    i = a.g(parcel, F);
                    break;
                case 6:
                    list2 = a.c(parcel, F, DataSource.CREATOR);
                    break;
                case 7:
                    list = a.c(parcel, F, DataType.CREATOR);
                    break;
                case 1000:
                    i2 = a.g(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new DataReadResult(i2, arrayList, status, arrayList2, i, list2, list);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ce(x0);
    }

    public DataReadResult[] dz(int i) {
        return new DataReadResult[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dz(x0);
    }
}
