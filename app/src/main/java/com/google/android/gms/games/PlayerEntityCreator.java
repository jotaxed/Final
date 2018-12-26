package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;

public class PlayerEntityCreator implements Creator<PlayerEntity> {
    static void a(PlayerEntity playerEntity, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, playerEntity.getPlayerId(), false);
        b.a(parcel, 2, playerEntity.getDisplayName(), false);
        b.a(parcel, 3, playerEntity.getIconImageUri(), i, false);
        b.a(parcel, 4, playerEntity.getHiResImageUri(), i, false);
        b.a(parcel, 5, playerEntity.getRetrievedTimestamp());
        b.c(parcel, 6, playerEntity.kE());
        b.a(parcel, 7, playerEntity.getLastPlayedWithTimestamp());
        b.a(parcel, 8, playerEntity.getIconImageUrl(), false);
        b.a(parcel, 9, playerEntity.getHiResImageUrl(), false);
        b.a(parcel, 14, playerEntity.getTitle(), false);
        b.a(parcel, 15, playerEntity.kF(), i, false);
        b.a(parcel, 16, playerEntity.getLevelInfo(), i, false);
        b.c(parcel, 1000, playerEntity.getVersionCode());
        b.a(parcel, 18, playerEntity.isProfileVisible());
        b.H(parcel, H);
    }

    public PlayerEntity cm(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        Uri uri = null;
        Uri uri2 = null;
        long j = 0;
        int i2 = 0;
        long j2 = 0;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        MostRecentGameInfoEntity mostRecentGameInfoEntity = null;
        PlayerLevelInfo playerLevelInfo = null;
        boolean z = false;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    str = a.o(parcel, F);
                    break;
                case 2:
                    str2 = a.o(parcel, F);
                    break;
                case 3:
                    uri = (Uri) a.a(parcel, F, Uri.CREATOR);
                    break;
                case 4:
                    uri2 = (Uri) a.a(parcel, F, Uri.CREATOR);
                    break;
                case 5:
                    j = a.i(parcel, F);
                    break;
                case 6:
                    i2 = a.g(parcel, F);
                    break;
                case 7:
                    j2 = a.i(parcel, F);
                    break;
                case 8:
                    str3 = a.o(parcel, F);
                    break;
                case 9:
                    str4 = a.o(parcel, F);
                    break;
                case 14:
                    str5 = a.o(parcel, F);
                    break;
                case 15:
                    mostRecentGameInfoEntity = (MostRecentGameInfoEntity) a.a(parcel, F, (Creator) MostRecentGameInfoEntity.CREATOR);
                    break;
                case 16:
                    playerLevelInfo = (PlayerLevelInfo) a.a(parcel, F, (Creator) PlayerLevelInfo.CREATOR);
                    break;
                case 18:
                    z = a.c(parcel, F);
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
            return new PlayerEntity(i, str, str2, uri, uri2, j, i2, j2, str3, str4, str5, mostRecentGameInfoEntity, playerLevelInfo, z);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cm(x0);
    }

    public PlayerEntity[] dH(int i) {
        return new PlayerEntity[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dH(x0);
    }
}
