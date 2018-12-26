package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class PlayerLevelCreator implements Creator<PlayerLevel> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void a(PlayerLevel playerLevel, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, playerLevel.getLevelNumber());
        b.c(parcel, 1000, playerLevel.getVersionCode());
        b.a(parcel, 2, playerLevel.getMinXp());
        b.a(parcel, 3, playerLevel.getMaxXp());
        b.H(parcel, H);
    }

    public PlayerLevel createFromParcel(Parcel parcel) {
        long j = 0;
        int i = 0;
        int G = a.G(parcel);
        long j2 = 0;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    j2 = a.i(parcel, F);
                    break;
                case 3:
                    j = a.i(parcel, F);
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
            return new PlayerLevel(i2, i, j2, j);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public PlayerLevel[] newArray(int size) {
        return new PlayerLevel[size];
    }
}
