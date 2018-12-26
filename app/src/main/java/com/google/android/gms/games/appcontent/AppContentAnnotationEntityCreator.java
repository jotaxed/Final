package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class AppContentAnnotationEntityCreator implements Creator<AppContentAnnotationEntity> {
    static void a(AppContentAnnotationEntity appContentAnnotationEntity, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, appContentAnnotationEntity.getDescription(), false);
        b.c(parcel, 1000, appContentAnnotationEntity.getVersionCode());
        b.a(parcel, 2, appContentAnnotationEntity.kL(), i, false);
        b.a(parcel, 3, appContentAnnotationEntity.getTitle(), false);
        b.a(parcel, 4, appContentAnnotationEntity.getType(), false);
        b.H(parcel, H);
    }

    public AppContentAnnotationEntity co(Parcel parcel) {
        String str = null;
        int G = a.G(parcel);
        int i = 0;
        String str2 = null;
        Uri uri = null;
        String str3 = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    str3 = a.o(parcel, F);
                    break;
                case 2:
                    uri = (Uri) a.a(parcel, F, Uri.CREATOR);
                    break;
                case 3:
                    str2 = a.o(parcel, F);
                    break;
                case 4:
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
            return new AppContentAnnotationEntity(i, str3, uri, str2, str);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return co(x0);
    }

    public AppContentAnnotationEntity[] dJ(int i) {
        return new AppContentAnnotationEntity[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dJ(x0);
    }
}
