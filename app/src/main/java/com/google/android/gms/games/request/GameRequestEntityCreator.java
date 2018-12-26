package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.PlayerEntity;
import java.util.ArrayList;

public class GameRequestEntityCreator implements Creator<GameRequestEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void a(GameRequestEntity gameRequestEntity, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, gameRequestEntity.getGame(), i, false);
        b.c(parcel, 1000, gameRequestEntity.getVersionCode());
        b.a(parcel, 2, gameRequestEntity.getSender(), i, false);
        b.a(parcel, 3, gameRequestEntity.getData(), false);
        b.a(parcel, 4, gameRequestEntity.getRequestId(), false);
        b.c(parcel, 5, gameRequestEntity.getRecipients(), false);
        b.c(parcel, 7, gameRequestEntity.getType());
        b.a(parcel, 9, gameRequestEntity.getCreationTimestamp());
        b.a(parcel, 10, gameRequestEntity.getExpirationTimestamp());
        b.a(parcel, 11, gameRequestEntity.mS(), false);
        b.c(parcel, 12, gameRequestEntity.getStatus());
        b.H(parcel, H);
    }

    public GameRequestEntity createFromParcel(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        PlayerEntity playerEntity = null;
        byte[] bArr = null;
        String str = null;
        ArrayList arrayList = null;
        int i2 = 0;
        long j = 0;
        long j2 = 0;
        Bundle bundle = null;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    gameEntity = (GameEntity) a.a(parcel, F, GameEntity.CREATOR);
                    break;
                case 2:
                    playerEntity = (PlayerEntity) a.a(parcel, F, PlayerEntity.CREATOR);
                    break;
                case 3:
                    bArr = a.r(parcel, F);
                    break;
                case 4:
                    str = a.o(parcel, F);
                    break;
                case 5:
                    arrayList = a.c(parcel, F, PlayerEntity.CREATOR);
                    break;
                case 7:
                    i2 = a.g(parcel, F);
                    break;
                case 9:
                    j = a.i(parcel, F);
                    break;
                case 10:
                    j2 = a.i(parcel, F);
                    break;
                case 11:
                    bundle = a.q(parcel, F);
                    break;
                case 12:
                    i3 = a.g(parcel, F);
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
            return new GameRequestEntity(i, gameEntity, playerEntity, bArr, str, arrayList, i2, j, j2, bundle, i3);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public GameRequestEntity[] newArray(int size) {
        return new GameRequestEntity[size];
    }
}
