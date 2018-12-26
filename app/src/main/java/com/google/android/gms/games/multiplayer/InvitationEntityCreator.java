package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.GameEntity;
import java.util.ArrayList;

public class InvitationEntityCreator implements Creator<InvitationEntity> {
    static void a(InvitationEntity invitationEntity, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, invitationEntity.getGame(), i, false);
        b.c(parcel, 1000, invitationEntity.getVersionCode());
        b.a(parcel, 2, invitationEntity.getInvitationId(), false);
        b.a(parcel, 3, invitationEntity.getCreationTimestamp());
        b.c(parcel, 4, invitationEntity.getInvitationType());
        b.a(parcel, 5, invitationEntity.getInviter(), i, false);
        b.c(parcel, 6, invitationEntity.getParticipants(), false);
        b.c(parcel, 7, invitationEntity.getVariant());
        b.c(parcel, 8, invitationEntity.getAvailableAutoMatchSlots());
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cz(x0);
    }

    public InvitationEntity cz(Parcel parcel) {
        ArrayList arrayList = null;
        int i = 0;
        int G = a.G(parcel);
        long j = 0;
        int i2 = 0;
        ParticipantEntity participantEntity = null;
        int i3 = 0;
        String str = null;
        GameEntity gameEntity = null;
        int i4 = 0;
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
                    j = a.i(parcel, F);
                    break;
                case 4:
                    i3 = a.g(parcel, F);
                    break;
                case 5:
                    participantEntity = (ParticipantEntity) a.a(parcel, F, ParticipantEntity.CREATOR);
                    break;
                case 6:
                    arrayList = a.c(parcel, F, ParticipantEntity.CREATOR);
                    break;
                case 7:
                    i2 = a.g(parcel, F);
                    break;
                case 8:
                    i = a.g(parcel, F);
                    break;
                case 1000:
                    i4 = a.g(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new InvitationEntity(i4, gameEntity, str, j, i3, participantEntity, arrayList, i2, i);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public InvitationEntity[] el(int i) {
        return new InvitationEntity[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return el(x0);
    }
}
