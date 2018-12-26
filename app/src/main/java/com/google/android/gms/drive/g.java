package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class g implements Creator<StorageStats> {
    static void a(StorageStats storageStats, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, storageStats.CK);
        b.a(parcel, 2, storageStats.OM);
        b.a(parcel, 3, storageStats.ON);
        b.a(parcel, 4, storageStats.OO);
        b.a(parcel, 5, storageStats.OP);
        b.c(parcel, 6, storageStats.OQ);
        b.H(parcel, H);
    }

    public StorageStats V(Parcel parcel) {
        int i = 0;
        long j = 0;
        int G = a.G(parcel);
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i2 = a.g(parcel, F);
                    break;
                case 2:
                    j4 = a.i(parcel, F);
                    break;
                case 3:
                    j3 = a.i(parcel, F);
                    break;
                case 4:
                    j2 = a.i(parcel, F);
                    break;
                case 5:
                    j = a.i(parcel, F);
                    break;
                case 6:
                    i = a.g(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new StorageStats(i2, j4, j3, j2, j, i);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public StorageStats[] bd(int i) {
        return new StorageStats[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return V(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bd(x0);
    }
}
