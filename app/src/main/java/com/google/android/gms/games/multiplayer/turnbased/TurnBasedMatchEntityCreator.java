package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.util.TimeUtils;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import java.util.ArrayList;

public class TurnBasedMatchEntityCreator implements Creator<TurnBasedMatchEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void a(TurnBasedMatchEntity turnBasedMatchEntity, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, turnBasedMatchEntity.getGame(), i, false);
        b.a(parcel, 2, turnBasedMatchEntity.getMatchId(), false);
        b.a(parcel, 3, turnBasedMatchEntity.getCreatorId(), false);
        b.a(parcel, 4, turnBasedMatchEntity.getCreationTimestamp());
        b.a(parcel, 5, turnBasedMatchEntity.getLastUpdaterId(), false);
        b.a(parcel, 6, turnBasedMatchEntity.getLastUpdatedTimestamp());
        b.a(parcel, 7, turnBasedMatchEntity.getPendingParticipantId(), false);
        b.c(parcel, 8, turnBasedMatchEntity.getStatus());
        b.c(parcel, 10, turnBasedMatchEntity.getVariant());
        b.c(parcel, 11, turnBasedMatchEntity.getVersion());
        b.a(parcel, 12, turnBasedMatchEntity.getData(), false);
        b.c(parcel, 13, turnBasedMatchEntity.getParticipants(), false);
        b.a(parcel, 14, turnBasedMatchEntity.getRematchId(), false);
        b.a(parcel, 15, turnBasedMatchEntity.getPreviousMatchData(), false);
        b.a(parcel, 17, turnBasedMatchEntity.getAutoMatchCriteria(), false);
        b.c(parcel, 16, turnBasedMatchEntity.getMatchNumber());
        b.c(parcel, 1000, turnBasedMatchEntity.getVersionCode());
        b.a(parcel, 19, turnBasedMatchEntity.isLocallyModified());
        b.c(parcel, 18, turnBasedMatchEntity.getTurnStatus());
        b.a(parcel, 21, turnBasedMatchEntity.getDescriptionParticipantId(), false);
        b.a(parcel, 20, turnBasedMatchEntity.getDescription(), false);
        b.H(parcel, H);
    }

    public TurnBasedMatchEntity createFromParcel(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        String str = null;
        String str2 = null;
        long j = 0;
        String str3 = null;
        long j2 = 0;
        String str4 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        byte[] bArr = null;
        ArrayList arrayList = null;
        String str5 = null;
        byte[] bArr2 = null;
        int i5 = 0;
        Bundle bundle = null;
        int i6 = 0;
        boolean z = false;
        String str6 = null;
        String str7 = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    gameEntity = (GameEntity) a.a(parcel, F, GameEntity.CREATOR);
                    break;
                case 2:
                    str = a.o(parcel, F);
                    break;
                case 3:
                    str2 = a.o(parcel, F);
                    break;
                case 4:
                    j = a.i(parcel, F);
                    break;
                case 5:
                    str3 = a.o(parcel, F);
                    break;
                case 6:
                    j2 = a.i(parcel, F);
                    break;
                case 7:
                    str4 = a.o(parcel, F);
                    break;
                case 8:
                    i2 = a.g(parcel, F);
                    break;
                case 10:
                    i3 = a.g(parcel, F);
                    break;
                case 11:
                    i4 = a.g(parcel, F);
                    break;
                case 12:
                    bArr = a.r(parcel, F);
                    break;
                case 13:
                    arrayList = a.c(parcel, F, ParticipantEntity.CREATOR);
                    break;
                case 14:
                    str5 = a.o(parcel, F);
                    break;
                case 15:
                    bArr2 = a.r(parcel, F);
                    break;
                case 16:
                    i5 = a.g(parcel, F);
                    break;
                case 17:
                    bundle = a.q(parcel, F);
                    break;
                case 18:
                    i6 = a.g(parcel, F);
                    break;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    z = a.c(parcel, F);
                    break;
                case 20:
                    str6 = a.o(parcel, F);
                    break;
                case 21:
                    str7 = a.o(parcel, F);
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
            return new TurnBasedMatchEntity(i, gameEntity, str, str2, j, str3, j2, str4, i2, i3, i4, bArr, arrayList, str5, bArr2, i5, bundle, i6, z, str6, str7);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public TurnBasedMatchEntity[] newArray(int size) {
        return new TurnBasedMatchEntity[size];
    }
}
