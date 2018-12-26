package com.google.android.gms.games.internal.game;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import java.util.ArrayList;

public class ExtendedGameEntityCreator implements Creator<ExtendedGameEntity> {
    static void a(ExtendedGameEntity extendedGameEntity, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, extendedGameEntity.mi(), i, false);
        b.c(parcel, 1000, extendedGameEntity.getVersionCode());
        b.c(parcel, 2, extendedGameEntity.lZ());
        b.a(parcel, 3, extendedGameEntity.ma());
        b.c(parcel, 4, extendedGameEntity.mb());
        b.a(parcel, 5, extendedGameEntity.mc());
        b.a(parcel, 6, extendedGameEntity.md());
        b.a(parcel, 7, extendedGameEntity.me(), false);
        b.a(parcel, 8, extendedGameEntity.mf());
        b.a(parcel, 9, extendedGameEntity.mg(), false);
        b.c(parcel, 10, extendedGameEntity.lY(), false);
        b.a(parcel, 11, extendedGameEntity.mh(), i, false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cu(x0);
    }

    public ExtendedGameEntity cu(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        long j = 0;
        long j2 = 0;
        String str = null;
        long j3 = 0;
        String str2 = null;
        ArrayList arrayList = null;
        SnapshotMetadataEntity snapshotMetadataEntity = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    gameEntity = (GameEntity) a.a(parcel, F, GameEntity.CREATOR);
                    break;
                case 2:
                    i2 = a.g(parcel, F);
                    break;
                case 3:
                    z = a.c(parcel, F);
                    break;
                case 4:
                    i3 = a.g(parcel, F);
                    break;
                case 5:
                    j = a.i(parcel, F);
                    break;
                case 6:
                    j2 = a.i(parcel, F);
                    break;
                case 7:
                    str = a.o(parcel, F);
                    break;
                case 8:
                    j3 = a.i(parcel, F);
                    break;
                case 9:
                    str2 = a.o(parcel, F);
                    break;
                case 10:
                    arrayList = a.c(parcel, F, GameBadgeEntity.CREATOR);
                    break;
                case 11:
                    snapshotMetadataEntity = (SnapshotMetadataEntity) a.a(parcel, F, (Creator) SnapshotMetadataEntity.CREATOR);
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
            return new ExtendedGameEntity(i, gameEntity, i2, z, i3, j, j2, str, j3, str2, arrayList, snapshotMetadataEntity);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public ExtendedGameEntity[] eb(int i) {
        return new ExtendedGameEntity[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eb(x0);
    }
}
