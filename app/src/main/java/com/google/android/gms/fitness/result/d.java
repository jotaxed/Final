package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.DataType;

public class d implements Creator<DataTypeResult> {
    static void a(DataTypeResult dataTypeResult, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, dataTypeResult.getStatus(), i, false);
        b.c(parcel, 1000, dataTypeResult.getVersionCode());
        b.a(parcel, 3, dataTypeResult.getDataType(), i, false);
        b.H(parcel, H);
    }

    public DataTypeResult cg(Parcel parcel) {
        DataType dataType = null;
        int G = a.G(parcel);
        int i = 0;
        Status status = null;
        while (parcel.dataPosition() < G) {
            int i2;
            DataType dataType2;
            Status status2;
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i2 = i;
                    Status status3 = (Status) a.a(parcel, F, Status.CREATOR);
                    dataType2 = dataType;
                    status2 = status3;
                    break;
                case 3:
                    dataType2 = (DataType) a.a(parcel, F, DataType.CREATOR);
                    status2 = status;
                    i2 = i;
                    break;
                case 1000:
                    DataType dataType3 = dataType;
                    status2 = status;
                    i2 = a.g(parcel, F);
                    dataType2 = dataType3;
                    break;
                default:
                    a.b(parcel, F);
                    dataType2 = dataType;
                    status2 = status;
                    i2 = i;
                    break;
            }
            i = i2;
            status = status2;
            dataType = dataType2;
        }
        if (parcel.dataPosition() == G) {
            return new DataTypeResult(i, status, dataType);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cg(x0);
    }

    public DataTypeResult[] dB(int i) {
        return new DataTypeResult[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dB(x0);
    }
}
