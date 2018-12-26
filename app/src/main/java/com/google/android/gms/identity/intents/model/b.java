package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;

public class b implements Creator<UserAddress> {
    static void a(UserAddress userAddress, Parcel parcel, int i) {
        int H = com.google.android.gms.common.internal.safeparcel.b.H(parcel);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 1, userAddress.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, userAddress.name, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, userAddress.afK, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 4, userAddress.afL, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 5, userAddress.afM, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 6, userAddress.afN, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 7, userAddress.afO, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 8, userAddress.afP, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 9, userAddress.afQ, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 10, userAddress.vk, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 11, userAddress.afR, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 12, userAddress.afS, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 13, userAddress.afT, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 14, userAddress.afU);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 15, userAddress.afV, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 16, userAddress.afW, false);
        com.google.android.gms.common.internal.safeparcel.b.H(parcel, H);
    }

    public UserAddress cH(Parcel parcel) {
        int G = a.G(parcel);
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
        String str10 = null;
        String str11 = null;
        String str12 = null;
        boolean z = false;
        String str13 = null;
        String str14 = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    str = a.o(parcel, F);
                    break;
                case 3:
                    str2 = a.o(parcel, F);
                    break;
                case 4:
                    str3 = a.o(parcel, F);
                    break;
                case 5:
                    str4 = a.o(parcel, F);
                    break;
                case 6:
                    str5 = a.o(parcel, F);
                    break;
                case 7:
                    str6 = a.o(parcel, F);
                    break;
                case 8:
                    str7 = a.o(parcel, F);
                    break;
                case 9:
                    str8 = a.o(parcel, F);
                    break;
                case 10:
                    str9 = a.o(parcel, F);
                    break;
                case 11:
                    str10 = a.o(parcel, F);
                    break;
                case 12:
                    str11 = a.o(parcel, F);
                    break;
                case 13:
                    str12 = a.o(parcel, F);
                    break;
                case 14:
                    z = a.c(parcel, F);
                    break;
                case 15:
                    str13 = a.o(parcel, F);
                    break;
                case 16:
                    str14 = a.o(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new UserAddress(i, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, z, str13, str14);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cH(x0);
    }

    public UserAddress[] eu(int i) {
        return new UserAddress[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eu(x0);
    }
}
