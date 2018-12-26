package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.util.TimeUtils;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class GameEntityCreator implements Creator<GameEntity> {
    static void a(GameEntity gameEntity, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, gameEntity.getApplicationId(), false);
        b.a(parcel, 2, gameEntity.getDisplayName(), false);
        b.a(parcel, 3, gameEntity.getPrimaryCategory(), false);
        b.a(parcel, 4, gameEntity.getSecondaryCategory(), false);
        b.a(parcel, 5, gameEntity.getDescription(), false);
        b.a(parcel, 6, gameEntity.getDeveloperName(), false);
        b.a(parcel, 7, gameEntity.getIconImageUri(), i, false);
        b.a(parcel, 8, gameEntity.getHiResImageUri(), i, false);
        b.a(parcel, 9, gameEntity.getFeaturedImageUri(), i, false);
        b.a(parcel, 10, gameEntity.ky());
        b.a(parcel, 11, gameEntity.kA());
        b.a(parcel, 12, gameEntity.kB(), false);
        b.c(parcel, 13, gameEntity.kC());
        b.c(parcel, 14, gameEntity.getAchievementTotalCount());
        b.c(parcel, 15, gameEntity.getLeaderboardCount());
        b.a(parcel, 17, gameEntity.isTurnBasedMultiplayerEnabled());
        b.a(parcel, 16, gameEntity.isRealTimeMultiplayerEnabled());
        b.c(parcel, 1000, gameEntity.getVersionCode());
        b.a(parcel, 19, gameEntity.getHiResImageUrl(), false);
        b.a(parcel, 18, gameEntity.getIconImageUrl(), false);
        b.a(parcel, 21, gameEntity.isMuted());
        b.a(parcel, 20, gameEntity.getFeaturedImageUrl(), false);
        b.a(parcel, 23, gameEntity.areSnapshotsEnabled());
        b.a(parcel, 22, gameEntity.kz());
        b.a(parcel, 24, gameEntity.getThemeColor(), false);
        b.H(parcel, H);
    }

    public GameEntity cl(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        Uri uri = null;
        Uri uri2 = null;
        Uri uri3 = null;
        boolean z = false;
        boolean z2 = false;
        String str7 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z3 = false;
        boolean z4 = false;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        String str11 = null;
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
                    str3 = a.o(parcel, F);
                    break;
                case 4:
                    str4 = a.o(parcel, F);
                    break;
                case 5:
                    str5 = a.o(parcel, F);
                    break;
                case 6:
                    str6 = a.o(parcel, F);
                    break;
                case 7:
                    uri = (Uri) a.a(parcel, F, Uri.CREATOR);
                    break;
                case 8:
                    uri2 = (Uri) a.a(parcel, F, Uri.CREATOR);
                    break;
                case 9:
                    uri3 = (Uri) a.a(parcel, F, Uri.CREATOR);
                    break;
                case 10:
                    z = a.c(parcel, F);
                    break;
                case 11:
                    z2 = a.c(parcel, F);
                    break;
                case 12:
                    str7 = a.o(parcel, F);
                    break;
                case 13:
                    i2 = a.g(parcel, F);
                    break;
                case 14:
                    i3 = a.g(parcel, F);
                    break;
                case 15:
                    i4 = a.g(parcel, F);
                    break;
                case 16:
                    z3 = a.c(parcel, F);
                    break;
                case 17:
                    z4 = a.c(parcel, F);
                    break;
                case 18:
                    str8 = a.o(parcel, F);
                    break;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    str9 = a.o(parcel, F);
                    break;
                case 20:
                    str10 = a.o(parcel, F);
                    break;
                case 21:
                    z5 = a.c(parcel, F);
                    break;
                case 22:
                    z6 = a.c(parcel, F);
                    break;
                case 23:
                    z7 = a.c(parcel, F);
                    break;
                case 24:
                    str11 = a.o(parcel, F);
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
            return new GameEntity(i, str, str2, str3, str4, str5, str6, uri, uri2, uri3, z, z2, str7, i2, i3, i4, z3, z4, str8, str9, str10, z5, z6, z7, str11);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cl(x0);
    }

    public GameEntity[] dG(int i) {
        return new GameEntity[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dG(x0);
    }
}
