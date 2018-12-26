package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import java.util.ArrayList;

public class RoomEntityCreator implements Creator<RoomEntity> {
    static void a(RoomEntity roomEntity, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, roomEntity.getRoomId(), false);
        b.c(parcel, 1000, roomEntity.getVersionCode());
        b.a(parcel, 2, roomEntity.getCreatorId(), false);
        b.a(parcel, 3, roomEntity.getCreationTimestamp());
        b.c(parcel, 4, roomEntity.getStatus());
        b.a(parcel, 5, roomEntity.getDescription(), false);
        b.c(parcel, 6, roomEntity.getVariant());
        b.a(parcel, 7, roomEntity.getAutoMatchCriteria(), false);
        b.c(parcel, 8, roomEntity.getParticipants(), false);
        b.c(parcel, 9, roomEntity.getAutoMatchWaitEstimateSeconds());
        b.H(parcel, H);
    }

    public RoomEntity cC(Parcel parcel) {
        int i = 0;
        ArrayList arrayList = null;
        int G = a.G(parcel);
        long j = 0;
        Bundle bundle = null;
        int i2 = 0;
        String str = null;
        int i3 = 0;
        String str2 = null;
        String str3 = null;
        int i4 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    str3 = a.o(parcel, F);
                    break;
                case 2:
                    str2 = a.o(parcel, F);
                    break;
                case 3:
                    j = a.i(parcel, F);
                    break;
                case 4:
                    i3 = a.g(parcel, F);
                    break;
                case 5:
                    str = a.o(parcel, F);
                    break;
                case 6:
                    i2 = a.g(parcel, F);
                    break;
                case 7:
                    bundle = a.q(parcel, F);
                    break;
                case 8:
                    arrayList = a.c(parcel, F, ParticipantEntity.CREATOR);
                    break;
                case 9:
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
            return new RoomEntity(i4, str3, str2, j, i3, str, i2, bundle, arrayList, i);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cC(x0);
    }

    public RoomEntity[] eo(int i) {
        return new RoomEntity[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eo(x0);
    }
}
