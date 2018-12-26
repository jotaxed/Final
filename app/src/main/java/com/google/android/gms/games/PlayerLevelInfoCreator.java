package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class PlayerLevelInfoCreator implements Creator<PlayerLevelInfo> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void a(PlayerLevelInfo playerLevelInfo, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, playerLevelInfo.getCurrentXpTotal());
        b.c(parcel, 1000, playerLevelInfo.getVersionCode());
        b.a(parcel, 2, playerLevelInfo.getLastLevelUpTimestamp());
        b.a(parcel, 3, playerLevelInfo.getCurrentLevel(), i, false);
        b.a(parcel, 4, playerLevelInfo.getNextLevel(), i, false);
        b.H(parcel, H);
    }

    public PlayerLevelInfo createFromParcel(Parcel parcel) {
        long j = 0;
        PlayerLevel playerLevel = null;
        int G = a.G(parcel);
        int i = 0;
        PlayerLevel playerLevel2 = null;
        long j2 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    j2 = a.i(parcel, F);
                    break;
                case 2:
                    j = a.i(parcel, F);
                    break;
                case 3:
                    playerLevel2 = (PlayerLevel) a.a(parcel, F, PlayerLevel.CREATOR);
                    break;
                case 4:
                    playerLevel = (PlayerLevel) a.a(parcel, F, PlayerLevel.CREATOR);
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
            return new PlayerLevelInfo(i, j2, j, playerLevel2, playerLevel);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public PlayerLevelInfo[] newArray(int size) {
        return new PlayerLevelInfo[size];
    }
}
