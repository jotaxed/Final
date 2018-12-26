package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Collection;

public class a implements Creator<AppVisibleCustomProperties> {
    static void a(AppVisibleCustomProperties appVisibleCustomProperties, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, appVisibleCustomProperties.CK);
        b.c(parcel, 2, appVisibleCustomProperties.Re, false);
        b.H(parcel, H);
    }

    public AppVisibleCustomProperties aN(Parcel parcel) {
        int G = com.google.android.gms.common.internal.safeparcel.a.G(parcel);
        int i = 0;
        Collection collection = null;
        while (parcel.dataPosition() < G) {
            int F = com.google.android.gms.common.internal.safeparcel.a.F(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.aH(F)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, F);
                    break;
                case 2:
                    collection = com.google.android.gms.common.internal.safeparcel.a.c(parcel, F, CustomProperty.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new AppVisibleCustomProperties(i, collection);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + G, parcel);
    }

    public AppVisibleCustomProperties[] cc(int i) {
        return new AppVisibleCustomProperties[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aN(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cc(x0);
    }
}
