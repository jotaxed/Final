package com.google.android.gms.games.internal.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import java.util.ArrayList;

public class InvitationClusterCreator implements Creator<ZInvitationCluster> {
    static void a(ZInvitationCluster zInvitationCluster, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, zInvitationCluster.mq(), false);
        b.c(parcel, 1000, zInvitationCluster.getVersionCode());
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cw(x0);
    }

    public ZInvitationCluster cw(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    arrayList = a.c(parcel, F, InvitationEntity.CREATOR);
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
            return new ZInvitationCluster(i, arrayList);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public ZInvitationCluster[] eg(int i) {
        return new ZInvitationCluster[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eg(x0);
    }
}
