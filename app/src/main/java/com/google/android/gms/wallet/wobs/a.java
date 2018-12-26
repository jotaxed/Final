package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.util.TimeUtils;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.la;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

public class a implements Creator<CommonWalletObject> {
    static void a(CommonWalletObject commonWalletObject, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, commonWalletObject.getVersionCode());
        b.a(parcel, 2, commonWalletObject.fl, false);
        b.a(parcel, 3, commonWalletObject.avk, false);
        b.a(parcel, 4, commonWalletObject.name, false);
        b.a(parcel, 5, commonWalletObject.ave, false);
        b.a(parcel, 6, commonWalletObject.avg, false);
        b.a(parcel, 7, commonWalletObject.avh, false);
        b.a(parcel, 8, commonWalletObject.avi, false);
        b.a(parcel, 9, commonWalletObject.avj, false);
        b.c(parcel, 10, commonWalletObject.state);
        b.c(parcel, 11, commonWalletObject.avl, false);
        b.a(parcel, 12, commonWalletObject.avm, i, false);
        b.c(parcel, 13, commonWalletObject.avn, false);
        b.a(parcel, 14, commonWalletObject.avo, false);
        b.a(parcel, 15, commonWalletObject.avp, false);
        b.a(parcel, 17, commonWalletObject.avr);
        b.c(parcel, 16, commonWalletObject.avq, false);
        b.c(parcel, 19, commonWalletObject.avt, false);
        b.c(parcel, 18, commonWalletObject.avs, false);
        b.c(parcel, 20, commonWalletObject.avu, false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ec(x0);
    }

    public CommonWalletObject ec(Parcel parcel) {
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
        int i2 = 0;
        ArrayList ie = la.ie();
        l lVar = null;
        ArrayList ie2 = la.ie();
        String str9 = null;
        String str10 = null;
        ArrayList ie3 = la.ie();
        boolean z = false;
        ArrayList ie4 = la.ie();
        ArrayList ie5 = la.ie();
        ArrayList ie6 = la.ie();
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
                    i2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, F);
                    break;
                case 11:
                    ie = com.google.android.gms.common.internal.safeparcel.a.c(parcel, F, p.CREATOR);
                    break;
                case 12:
                    lVar = (l) com.google.android.gms.common.internal.safeparcel.a.a(parcel, F, l.CREATOR);
                    break;
                case 13:
                    ie2 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, F, LatLng.CREATOR);
                    break;
                case 14:
                    str9 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, F);
                    break;
                case 15:
                    str10 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, F);
                    break;
                case 16:
                    ie3 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, F, d.CREATOR);
                    break;
                case 17:
                    z = com.google.android.gms.common.internal.safeparcel.a.c(parcel, F);
                    break;
                case 18:
                    ie4 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, F, n.CREATOR);
                    break;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    ie5 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, F, j.CREATOR);
                    break;
                case 20:
                    ie6 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, F, n.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new CommonWalletObject(i, str, str2, str3, str4, str5, str6, str7, str8, i2, ie, lVar, ie2, str9, str10, ie3, z, ie4, ie5, ie6);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + G, parcel);
    }

    public CommonWalletObject[] gl(int i) {
        return new CommonWalletObject[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gl(x0);
    }
}
