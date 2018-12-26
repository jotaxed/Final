package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class AppContentConditionEntityCreator implements Creator<AppContentConditionEntity> {
    static void a(AppContentConditionEntity appContentConditionEntity, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, appContentConditionEntity.kT(), false);
        b.c(parcel, 1000, appContentConditionEntity.getVersionCode());
        b.a(parcel, 2, appContentConditionEntity.kU(), false);
        b.a(parcel, 3, appContentConditionEntity.kV(), false);
        b.a(parcel, 4, appContentConditionEntity.kW(), false);
        b.H(parcel, H);
    }

    public AppContentConditionEntity cq(Parcel parcel) {
        Bundle bundle = null;
        int G = a.G(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
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
                    str = a.o(parcel, F);
                    break;
                case 4:
                    bundle = a.q(parcel, F);
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
            return new AppContentConditionEntity(i, str3, str2, str, bundle);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cq(x0);
    }

    public AppContentConditionEntity[] dL(int i) {
        return new AppContentConditionEntity[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dL(x0);
    }
}
