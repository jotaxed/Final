package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class n implements Creator<RawDataPoint> {
    static void a(RawDataPoint rawDataPoint, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, rawDataPoint.Ud);
        b.c(parcel, 1000, rawDataPoint.CK);
        b.a(parcel, 2, rawDataPoint.Ue);
        b.a(parcel, 3, rawDataPoint.Uf, i, false);
        b.c(parcel, 4, rawDataPoint.UJ);
        b.c(parcel, 5, rawDataPoint.UK);
        b.a(parcel, 6, rawDataPoint.Uh);
        b.a(parcel, 7, rawDataPoint.Ui);
        b.H(parcel, H);
    }

    public RawDataPoint bA(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        long j = 0;
        long j2 = 0;
        Value[] valueArr = null;
        int i2 = 0;
        int i3 = 0;
        long j3 = 0;
        long j4 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    j = a.i(parcel, F);
                    break;
                case 2:
                    j2 = a.i(parcel, F);
                    break;
                case 3:
                    valueArr = (Value[]) a.b(parcel, F, Value.CREATOR);
                    break;
                case 4:
                    i2 = a.g(parcel, F);
                    break;
                case 5:
                    i3 = a.g(parcel, F);
                    break;
                case 6:
                    j3 = a.i(parcel, F);
                    break;
                case 7:
                    j4 = a.i(parcel, F);
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
            return new RawDataPoint(i, j, j2, valueArr, i2, i3, j3, j4);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public RawDataPoint[] cT(int i) {
        return new RawDataPoint[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bA(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cT(x0);
    }
}
