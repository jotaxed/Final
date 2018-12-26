package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.PlayerEntity;

public class ParticipantEntityCreator implements Creator<ParticipantEntity> {
    static void a(ParticipantEntity participantEntity, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, participantEntity.getParticipantId(), false);
        b.c(parcel, 1000, participantEntity.getVersionCode());
        b.a(parcel, 2, participantEntity.getDisplayName(), false);
        b.a(parcel, 3, participantEntity.getIconImageUri(), i, false);
        b.a(parcel, 4, participantEntity.getHiResImageUri(), i, false);
        b.c(parcel, 5, participantEntity.getStatus());
        b.a(parcel, 6, participantEntity.le(), false);
        b.a(parcel, 7, participantEntity.isConnectedToRoom());
        b.a(parcel, 8, participantEntity.getPlayer(), i, false);
        b.c(parcel, 9, participantEntity.getCapabilities());
        b.a(parcel, 10, participantEntity.getResult(), i, false);
        b.a(parcel, 11, participantEntity.getIconImageUrl(), false);
        b.a(parcel, 12, participantEntity.getHiResImageUrl(), false);
        b.H(parcel, H);
    }

    public ParticipantEntity cA(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        Uri uri = null;
        Uri uri2 = null;
        int i2 = 0;
        String str3 = null;
        boolean z = false;
        PlayerEntity playerEntity = null;
        int i3 = 0;
        ParticipantResult participantResult = null;
        String str4 = null;
        String str5 = null;
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
                    i2 = a.g(parcel, F);
                    break;
                case 6:
                    str3 = a.o(parcel, F);
                    break;
                case 7:
                    z = a.c(parcel, F);
                    break;
                case 8:
                    playerEntity = (PlayerEntity) a.a(parcel, F, PlayerEntity.CREATOR);
                    break;
                case 9:
                    i3 = a.g(parcel, F);
                    break;
                case 10:
                    participantResult = (ParticipantResult) a.a(parcel, F, ParticipantResult.CREATOR);
                    break;
                case 11:
                    str4 = a.o(parcel, F);
                    break;
                case 12:
                    str5 = a.o(parcel, F);
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
            return new ParticipantEntity(i, str, str2, uri, uri2, i2, str3, z, playerEntity, i3, participantResult, str4, str5);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cA(x0);
    }

    public ParticipantEntity[] em(int i) {
        return new ParticipantEntity[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return em(x0);
    }
}
