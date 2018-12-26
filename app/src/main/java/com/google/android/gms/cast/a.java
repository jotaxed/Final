package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public class a implements Creator<ApplicationMetadata> {
    static void a(ApplicationMetadata applicationMetadata, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, applicationMetadata.getVersionCode());
        b.a(parcel, 2, applicationMetadata.getApplicationId(), false);
        b.a(parcel, 3, applicationMetadata.getName(), false);
        b.c(parcel, 4, applicationMetadata.getImages(), false);
        b.b(parcel, 5, applicationMetadata.Fq, false);
        b.a(parcel, 6, applicationMetadata.getSenderAppIdentifier(), false);
        b.a(parcel, 7, applicationMetadata.fP(), i, false);
        b.H(parcel, H);
    }

    public ApplicationMetadata[] V(int i) {
        return new ApplicationMetadata[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return u(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return V(x0);
    }

    public ApplicationMetadata u(Parcel parcel) {
        Uri uri = null;
        int G = com.google.android.gms.common.internal.safeparcel.a.G(parcel);
        int i = 0;
        String str = null;
        List list = null;
        List list2 = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < G) {
            int F = com.google.android.gms.common.internal.safeparcel.a.F(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.aH(F)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, F);
                    break;
                case 2:
                    str3 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, F);
                    break;
                case 3:
                    str2 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, F);
                    break;
                case 4:
                    list2 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, F, WebImage.CREATOR);
                    break;
                case 5:
                    list = com.google.android.gms.common.internal.safeparcel.a.C(parcel, F);
                    break;
                case 6:
                    str = com.google.android.gms.common.internal.safeparcel.a.o(parcel, F);
                    break;
                case 7:
                    uri = (Uri) com.google.android.gms.common.internal.safeparcel.a.a(parcel, F, Uri.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ApplicationMetadata(i, str3, str2, list2, list, str, uri);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + G, parcel);
    }
}
