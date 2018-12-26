package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.StorageStats;

public class aw implements Creator<OnStorageStatsResponse> {
    static void a(OnStorageStatsResponse onStorageStatsResponse, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, onStorageStatsResponse.CK);
        b.a(parcel, 2, onStorageStatsResponse.QS, i, false);
        b.H(parcel, H);
    }

    public OnStorageStatsResponse aB(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        StorageStats storageStats = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    storageStats = (StorageStats) a.a(parcel, F, StorageStats.CREATOR);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new OnStorageStatsResponse(i, storageStats);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public OnStorageStatsResponse[] bQ(int i) {
        return new OnStorageStatsResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aB(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bQ(x0);
    }
}
