package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.metadata.CustomPropertyKey;

public class c implements Creator<CustomProperty> {
    static void a(CustomProperty customProperty, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, customProperty.CK);
        b.a(parcel, 2, customProperty.Rg, i, false);
        b.a(parcel, 3, customProperty.mValue, false);
        b.H(parcel, H);
    }

    public CustomProperty aO(Parcel parcel) {
        String str = null;
        int G = a.G(parcel);
        int i = 0;
        CustomPropertyKey customPropertyKey = null;
        while (parcel.dataPosition() < G) {
            CustomPropertyKey customPropertyKey2;
            int g;
            String str2;
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    String str3 = str;
                    customPropertyKey2 = customPropertyKey;
                    g = a.g(parcel, F);
                    str2 = str3;
                    break;
                case 2:
                    g = i;
                    CustomPropertyKey customPropertyKey3 = (CustomPropertyKey) a.a(parcel, F, CustomPropertyKey.CREATOR);
                    str2 = str;
                    customPropertyKey2 = customPropertyKey3;
                    break;
                case 3:
                    str2 = a.o(parcel, F);
                    customPropertyKey2 = customPropertyKey;
                    g = i;
                    break;
                default:
                    a.b(parcel, F);
                    str2 = str;
                    customPropertyKey2 = customPropertyKey;
                    g = i;
                    break;
            }
            i = g;
            customPropertyKey = customPropertyKey2;
            str = str2;
        }
        if (parcel.dataPosition() == G) {
            return new CustomProperty(i, customPropertyKey, str);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public CustomProperty[] cd(int i) {
        return new CustomProperty[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aO(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cd(x0);
    }
}
