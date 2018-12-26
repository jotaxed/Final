package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class AppContentActionEntityCreator implements Creator<AppContentActionEntity> {
    static void a(AppContentActionEntity appContentActionEntity, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, appContentActionEntity.kH(), false);
        b.c(parcel, 1000, appContentActionEntity.getVersionCode());
        b.a(parcel, 2, appContentActionEntity.kI(), false);
        b.a(parcel, 3, appContentActionEntity.getExtras(), false);
        b.a(parcel, 4, appContentActionEntity.getLabel(), false);
        b.a(parcel, 5, appContentActionEntity.kJ(), false);
        b.a(parcel, 6, appContentActionEntity.getType(), false);
        b.H(parcel, H);
    }

    public AppContentActionEntity cn(Parcel parcel) {
        String str = null;
        int G = a.G(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        Bundle bundle = null;
        String str4 = null;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    arrayList = a.c(parcel, F, AppContentConditionEntity.CREATOR);
                    break;
                case 2:
                    str4 = a.o(parcel, F);
                    break;
                case 3:
                    bundle = a.q(parcel, F);
                    break;
                case 4:
                    str3 = a.o(parcel, F);
                    break;
                case 5:
                    str2 = a.o(parcel, F);
                    break;
                case 6:
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
            return new AppContentActionEntity(i, arrayList, str4, bundle, str3, str2, str);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cn(x0);
    }

    public AppContentActionEntity[] dI(int i) {
        return new AppContentActionEntity[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dI(x0);
    }
}
