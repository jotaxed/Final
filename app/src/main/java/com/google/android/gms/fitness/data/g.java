package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class g implements Creator<DataSource> {
    static void a(DataSource dataSource, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, dataSource.getDataType(), i, false);
        b.c(parcel, 1000, dataSource.getVersionCode());
        b.a(parcel, 2, dataSource.getName(), false);
        b.c(parcel, 3, dataSource.getType());
        b.a(parcel, 4, dataSource.getDevice(), i, false);
        b.a(parcel, 5, dataSource.jx(), i, false);
        b.a(parcel, 6, dataSource.getStreamName(), false);
        b.a(parcel, 7, dataSource.jz());
        b.H(parcel, H);
    }

    public DataSource bv(Parcel parcel) {
        boolean z = false;
        String str = null;
        int G = a.G(parcel);
        a aVar = null;
        Device device = null;
        int i = 0;
        String str2 = null;
        DataType dataType = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    dataType = (DataType) a.a(parcel, F, DataType.CREATOR);
                    break;
                case 2:
                    str2 = a.o(parcel, F);
                    break;
                case 3:
                    i = a.g(parcel, F);
                    break;
                case 4:
                    device = (Device) a.a(parcel, F, Device.CREATOR);
                    break;
                case 5:
                    aVar = (a) a.a(parcel, F, a.CREATOR);
                    break;
                case 6:
                    str = a.o(parcel, F);
                    break;
                case 7:
                    z = a.c(parcel, F);
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
            return new DataSource(i2, dataType, str2, i, device, aVar, str, z);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public DataSource[] cO(int i) {
        return new DataSource[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bv(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cO(x0);
    }
}
