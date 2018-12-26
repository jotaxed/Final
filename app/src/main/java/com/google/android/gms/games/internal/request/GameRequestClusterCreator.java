package com.google.android.gms.games.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.request.GameRequestEntity;
import java.util.ArrayList;

public class GameRequestClusterCreator implements Creator<GameRequestCluster> {
    static void a(GameRequestCluster gameRequestCluster, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, gameRequestCluster.mD(), false);
        b.c(parcel, 1000, gameRequestCluster.getVersionCode());
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cy(x0);
    }

    public GameRequestCluster cy(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    arrayList = a.c(parcel, F, GameRequestEntity.CREATOR);
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
            return new GameRequestCluster(i, arrayList);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public GameRequestCluster[] ej(int i) {
        return new GameRequestCluster[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ej(x0);
    }
}
