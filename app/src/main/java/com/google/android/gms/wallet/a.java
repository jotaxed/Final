package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;

public class a implements Creator<Address> {
    static void a(Address address, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, address.getVersionCode());
        b.a(parcel, 2, address.name, false);
        b.a(parcel, 3, address.afK, false);
        b.a(parcel, 4, address.afL, false);
        b.a(parcel, 5, address.afM, false);
        b.a(parcel, 6, address.vk, false);
        b.a(parcel, 7, address.auD, false);
        b.a(parcel, 8, address.auE, false);
        b.a(parcel, 9, address.afR, false);
        b.a(parcel, 10, address.afT, false);
        b.a(parcel, 11, address.afU);
        b.a(parcel, 12, address.afV, false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dJ(x0);
    }

    public Address dJ(Parcel parcel) {
        int G = com.google.android.gms.common.internal.safeparcel.a.G(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        boolean z = false;
        String str10 = null;
        while (parcel.dataPosition() < G) {
            int F = com.google.android.gms.common.internal.safeparcel.a.F(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.aH(F)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, F);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.a.o(parcel, F);
                    break;
                case 3:
                    str2 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, F);
                    break;
                case 4:
                    str3 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, F);
                    break;
                case 5:
                    str4 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, F);
                    break;
                case 6:
                    str5 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, F);
                    break;
                case 7:
                    str6 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, F);
                    break;
                case 8:
                    str7 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, F);
                    break;
                case 9:
                    str8 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, F);
                    break;
                case 10:
                    str9 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, F);
                    break;
                case 11:
                    z = com.google.android.gms.common.internal.safeparcel.a.c(parcel, F);
                    break;
                case 12:
                    str10 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, F);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new Address(i, str, str2, str3, str4, str5, str6, str7, str8, str9, z, str10);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + G, parcel);
    }

    public Address[] fQ(int i) {
        return new Address[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fQ(x0);
    }
}
