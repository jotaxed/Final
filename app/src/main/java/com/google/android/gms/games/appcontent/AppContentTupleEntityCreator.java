package com.google.android.gms.games.appcontent;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class AppContentTupleEntityCreator implements Creator<AppContentTupleEntity> {
    static void a(AppContentTupleEntity appContentTupleEntity, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, appContentTupleEntity.getName(), false);
        b.c(parcel, 1000, appContentTupleEntity.getVersionCode());
        b.a(parcel, 2, appContentTupleEntity.getValue(), false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cs(x0);
    }

    public AppContentTupleEntity cs(Parcel parcel) {
        String str = null;
        int G = a.G(parcel);
        int i = 0;
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
                case 1000:
                    i = a.g(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new AppContentTupleEntity(i, str2, str);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public AppContentTupleEntity[] dN(int i) {
        return new AppContentTupleEntity[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dN(x0);
    }
}
