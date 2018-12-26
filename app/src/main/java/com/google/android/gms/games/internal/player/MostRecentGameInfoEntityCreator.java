package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class MostRecentGameInfoEntityCreator implements Creator<MostRecentGameInfoEntity> {
    static void a(MostRecentGameInfoEntity mostRecentGameInfoEntity, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, mostRecentGameInfoEntity.mw(), false);
        b.c(parcel, 1000, mostRecentGameInfoEntity.getVersionCode());
        b.a(parcel, 2, mostRecentGameInfoEntity.mx(), false);
        b.a(parcel, 3, mostRecentGameInfoEntity.my());
        b.a(parcel, 4, mostRecentGameInfoEntity.mz(), i, false);
        b.a(parcel, 5, mostRecentGameInfoEntity.mA(), i, false);
        b.a(parcel, 6, mostRecentGameInfoEntity.mB(), i, false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cx(x0);
    }

    public MostRecentGameInfoEntity cx(Parcel parcel) {
        Uri uri = null;
        int G = a.G(parcel);
        int i = 0;
        long j = 0;
        Uri uri2 = null;
        Uri uri3 = null;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    str2 = a.o(parcel, F);
                    break;
                case 2:
                    str = a.o(parcel, F);
                    break;
                case 3:
                    j = a.i(parcel, F);
                    break;
                case 4:
                    uri3 = (Uri) a.a(parcel, F, Uri.CREATOR);
                    break;
                case 5:
                    uri2 = (Uri) a.a(parcel, F, Uri.CREATOR);
                    break;
                case 6:
                    uri = (Uri) a.a(parcel, F, Uri.CREATOR);
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
            return new MostRecentGameInfoEntity(i, str2, str, j, uri3, uri2, uri);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public MostRecentGameInfoEntity[] ei(int i) {
        return new MostRecentGameInfoEntity[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ei(x0);
    }
}
