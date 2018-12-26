package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class AppContentSectionEntityCreator implements Creator<AppContentSectionEntity> {
    static void a(AppContentSectionEntity appContentSectionEntity, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, appContentSectionEntity.getActions(), false);
        b.c(parcel, 1000, appContentSectionEntity.getVersionCode());
        b.a(parcel, 2, appContentSectionEntity.kY(), i, false);
        b.c(parcel, 3, appContentSectionEntity.kZ(), false);
        b.a(parcel, 4, appContentSectionEntity.kI(), false);
        b.a(parcel, 5, appContentSectionEntity.kP(), false);
        b.a(parcel, 6, appContentSectionEntity.kQ(), false);
        b.a(parcel, 7, appContentSectionEntity.getTitle(), false);
        b.a(parcel, 8, appContentSectionEntity.getType(), false);
        b.H(parcel, H);
    }

    public AppContentSectionEntity cr(Parcel parcel) {
        String str = null;
        int G = a.G(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        Bundle bundle = null;
        String str4 = null;
        ArrayList arrayList = null;
        Uri uri = null;
        ArrayList arrayList2 = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    arrayList2 = a.c(parcel, F, AppContentActionEntity.CREATOR);
                    break;
                case 2:
                    uri = (Uri) a.a(parcel, F, Uri.CREATOR);
                    break;
                case 3:
                    arrayList = a.c(parcel, F, AppContentCardEntity.CREATOR);
                    break;
                case 4:
                    str4 = a.o(parcel, F);
                    break;
                case 5:
                    bundle = a.q(parcel, F);
                    break;
                case 6:
                    str3 = a.o(parcel, F);
                    break;
                case 7:
                    str2 = a.o(parcel, F);
                    break;
                case 8:
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
            return new AppContentSectionEntity(i, arrayList2, uri, arrayList, str4, bundle, str3, str2, str);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cr(x0);
    }

    public AppContentSectionEntity[] dM(int i) {
        return new AppContentSectionEntity[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dM(x0);
    }
}
