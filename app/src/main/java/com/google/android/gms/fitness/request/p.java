package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

public class p implements Creator<o> {
    static void a(o oVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, oVar.getDataSource(), i, false);
        b.c(parcel, 1000, oVar.getVersionCode());
        b.a(parcel, 2, oVar.getDataType(), i, false);
        b.a(parcel, 3, oVar.kg(), false);
        b.c(parcel, 4, oVar.VX);
        b.c(parcel, 5, oVar.VY);
        b.a(parcel, 6, oVar.jI());
        b.a(parcel, 7, oVar.kd());
        b.a(parcel, 8, oVar.kb(), i, false);
        b.a(parcel, 9, oVar.kc());
        b.c(parcel, 10, oVar.getAccuracyMode());
        b.c(parcel, 11, oVar.ke(), false);
        b.a(parcel, 12, oVar.kf());
        b.H(parcel, H);
    }

    public o bQ(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        DataSource dataSource = null;
        DataType dataType = null;
        IBinder iBinder = null;
        int i2 = 0;
        int i3 = 0;
        long j = 0;
        long j2 = 0;
        PendingIntent pendingIntent = null;
        long j3 = 0;
        int i4 = 0;
        List list = null;
        long j4 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    dataSource = (DataSource) a.a(parcel, F, DataSource.CREATOR);
                    break;
                case 2:
                    dataType = (DataType) a.a(parcel, F, DataType.CREATOR);
                    break;
                case 3:
                    iBinder = a.p(parcel, F);
                    break;
                case 4:
                    i2 = a.g(parcel, F);
                    break;
                case 5:
                    i3 = a.g(parcel, F);
                    break;
                case 6:
                    j = a.i(parcel, F);
                    break;
                case 7:
                    j2 = a.i(parcel, F);
                    break;
                case 8:
                    pendingIntent = (PendingIntent) a.a(parcel, F, PendingIntent.CREATOR);
                    break;
                case 9:
                    j3 = a.i(parcel, F);
                    break;
                case 10:
                    i4 = a.g(parcel, F);
                    break;
                case 11:
                    list = a.c(parcel, F, LocationRequest.CREATOR);
                    break;
                case 12:
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
            return new o(i, dataSource, dataType, iBinder, i2, i3, j, j2, pendingIntent, j3, i4, list, j4);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bQ(x0);
    }

    public o[] dk(int i) {
        return new o[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dk(x0);
    }
}
