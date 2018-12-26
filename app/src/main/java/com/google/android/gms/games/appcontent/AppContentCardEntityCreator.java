package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class AppContentCardEntityCreator implements Creator<AppContentCardEntity> {
    static void a(AppContentCardEntity appContentCardEntity, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, appContentCardEntity.getActions(), false);
        b.c(parcel, 1000, appContentCardEntity.getVersionCode());
        b.c(parcel, 2, appContentCardEntity.kN(), false);
        b.c(parcel, 3, appContentCardEntity.kH(), false);
        b.a(parcel, 4, appContentCardEntity.kI(), false);
        b.c(parcel, 5, appContentCardEntity.kO());
        b.a(parcel, 6, appContentCardEntity.getDescription(), false);
        b.a(parcel, 7, appContentCardEntity.kP(), false);
        b.a(parcel, 8, appContentCardEntity.getIconImageUri(), i, false);
        b.a(parcel, 9, appContentCardEntity.kL(), i, false);
        b.a(parcel, 10, appContentCardEntity.kQ(), false);
        b.a(parcel, 11, appContentCardEntity.getTitle(), false);
        b.c(parcel, 12, appContentCardEntity.kR());
        b.a(parcel, 13, appContentCardEntity.getType(), false);
        b.H(parcel, H);
    }

    public AppContentCardEntity cp(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        String str = null;
        int i2 = 0;
        String str2 = null;
        Bundle bundle = null;
        Uri uri = null;
        Uri uri2 = null;
        String str3 = null;
        String str4 = null;
        int i3 = 0;
        String str5 = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    arrayList = a.c(parcel, F, AppContentActionEntity.CREATOR);
                    break;
                case 2:
                    arrayList2 = a.c(parcel, F, AppContentAnnotationEntity.CREATOR);
                    break;
                case 3:
                    arrayList3 = a.c(parcel, F, AppContentConditionEntity.CREATOR);
                    break;
                case 4:
                    str = a.o(parcel, F);
                    break;
                case 5:
                    i2 = a.g(parcel, F);
                    break;
                case 6:
                    str2 = a.o(parcel, F);
                    break;
                case 7:
                    bundle = a.q(parcel, F);
                    break;
                case 8:
                    uri = (Uri) a.a(parcel, F, Uri.CREATOR);
                    break;
                case 9:
                    uri2 = (Uri) a.a(parcel, F, Uri.CREATOR);
                    break;
                case 10:
                    str3 = a.o(parcel, F);
                    break;
                case 11:
                    str4 = a.o(parcel, F);
                    break;
                case 12:
                    i3 = a.g(parcel, F);
                    break;
                case 13:
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
            return new AppContentCardEntity(i, arrayList, arrayList2, arrayList3, str, i2, str2, bundle, uri, uri2, str3, str4, i3, str5);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cp(x0);
    }

    public AppContentCardEntity[] dK(int i) {
        return new AppContentCardEntity[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dK(x0);
    }
}
