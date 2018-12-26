package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class GameBadgeEntityCreator implements Creator<GameBadgeEntity> {
    static void a(GameBadgeEntity gameBadgeEntity, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, gameBadgeEntity.getType());
        b.c(parcel, 1000, gameBadgeEntity.getVersionCode());
        b.a(parcel, 2, gameBadgeEntity.getTitle(), false);
        b.a(parcel, 3, gameBadgeEntity.getDescription(), false);
        b.a(parcel, 4, gameBadgeEntity.getIconImageUri(), i, false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cv(x0);
    }

    public GameBadgeEntity cv(Parcel parcel) {
        int i = 0;
        Uri uri = null;
        int G = a.G(parcel);
        String str = null;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    str2 = a.o(parcel, F);
                    break;
                case 3:
                    str = a.o(parcel, F);
                    break;
                case 4:
                    uri = (Uri) a.a(parcel, F, Uri.CREATOR);
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
            return new GameBadgeEntity(i2, i, str2, str, uri);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public GameBadgeEntity[] ed(int i) {
        return new GameBadgeEntity[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ed(x0);
    }
}
