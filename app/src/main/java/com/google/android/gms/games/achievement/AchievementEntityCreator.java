package com.google.android.gms.games.achievement;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.PlayerEntity;

public class AchievementEntityCreator implements Creator<AchievementEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void a(AchievementEntity achievementEntity, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, achievementEntity.getAchievementId(), false);
        b.c(parcel, 2, achievementEntity.getType());
        b.a(parcel, 3, achievementEntity.getName(), false);
        b.a(parcel, 4, achievementEntity.getDescription(), false);
        b.a(parcel, 5, achievementEntity.getUnlockedImageUri(), i, false);
        b.a(parcel, 6, achievementEntity.getUnlockedImageUrl(), false);
        b.a(parcel, 7, achievementEntity.getRevealedImageUri(), i, false);
        b.a(parcel, 8, achievementEntity.getRevealedImageUrl(), false);
        b.c(parcel, 9, achievementEntity.getTotalSteps());
        b.a(parcel, 10, achievementEntity.getFormattedTotalSteps(), false);
        b.a(parcel, 11, achievementEntity.getPlayer(), i, false);
        b.c(parcel, 12, achievementEntity.getState());
        b.c(parcel, 13, achievementEntity.getCurrentSteps());
        b.a(parcel, 14, achievementEntity.getFormattedCurrentSteps(), false);
        b.a(parcel, 15, achievementEntity.getLastUpdatedTimestamp());
        b.a(parcel, 16, achievementEntity.getXpValue());
        b.c(parcel, 1000, achievementEntity.getVersionCode());
        b.H(parcel, H);
    }

    public AchievementEntity createFromParcel(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        String str = null;
        int i2 = 0;
        String str2 = null;
        String str3 = null;
        Uri uri = null;
        String str4 = null;
        Uri uri2 = null;
        String str5 = null;
        int i3 = 0;
        String str6 = null;
        PlayerEntity playerEntity = null;
        int i4 = 0;
        int i5 = 0;
        String str7 = null;
        long j = 0;
        long j2 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    str = a.o(parcel, F);
                    break;
                case 2:
                    i2 = a.g(parcel, F);
                    break;
                case 3:
                    str2 = a.o(parcel, F);
                    break;
                case 4:
                    str3 = a.o(parcel, F);
                    break;
                case 5:
                    uri = (Uri) a.a(parcel, F, Uri.CREATOR);
                    break;
                case 6:
                    str4 = a.o(parcel, F);
                    break;
                case 7:
                    uri2 = (Uri) a.a(parcel, F, Uri.CREATOR);
                    break;
                case 8:
                    str5 = a.o(parcel, F);
                    break;
                case 9:
                    i3 = a.g(parcel, F);
                    break;
                case 10:
                    str6 = a.o(parcel, F);
                    break;
                case 11:
                    playerEntity = (PlayerEntity) a.a(parcel, F, PlayerEntity.CREATOR);
                    break;
                case 12:
                    i4 = a.g(parcel, F);
                    break;
                case 13:
                    i5 = a.g(parcel, F);
                    break;
                case 14:
                    str7 = a.o(parcel, F);
                    break;
                case 15:
                    j = a.i(parcel, F);
                    break;
                case 16:
                    j2 = a.i(parcel, F);
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
            return new AchievementEntity(i, str, i2, str2, str3, uri, str4, uri2, str5, i3, str6, playerEntity, i4, i5, str7, j, j2);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public AchievementEntity[] newArray(int size) {
        return new AchievementEntity[size];
    }
}
