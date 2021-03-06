package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class n implements Creator<m> {
    static void a(m mVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, mVar.CK);
        b.a(parcel, 2, mVar.getUri(), i, false);
        b.a(parcel, 4, mVar.rk(), false);
        b.a(parcel, 5, mVar.getData(), false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return eq(x0);
    }

    public m eq(Parcel parcel) {
        byte[] bArr = null;
        int G = a.G(parcel);
        int i = 0;
        Bundle bundle = null;
        Uri uri = null;
        while (parcel.dataPosition() < G) {
            Bundle bundle2;
            Uri uri2;
            int g;
            byte[] bArr2;
            int F = a.F(parcel);
            byte[] bArr3;
            switch (a.aH(F)) {
                case 1:
                    bArr3 = bArr;
                    bundle2 = bundle;
                    uri2 = uri;
                    g = a.g(parcel, F);
                    bArr2 = bArr3;
                    break;
                case 2:
                    g = i;
                    Bundle bundle3 = bundle;
                    uri2 = (Uri) a.a(parcel, F, Uri.CREATOR);
                    bArr2 = bArr;
                    bundle2 = bundle3;
                    break;
                case 4:
                    uri2 = uri;
                    g = i;
                    bArr3 = bArr;
                    bundle2 = a.q(parcel, F);
                    bArr2 = bArr3;
                    break;
                case 5:
                    bArr2 = a.r(parcel, F);
                    bundle2 = bundle;
                    uri2 = uri;
                    g = i;
                    break;
                default:
                    a.b(parcel, F);
                    bArr2 = bArr;
                    bundle2 = bundle;
                    uri2 = uri;
                    g = i;
                    break;
            }
            i = g;
            uri = uri2;
            bundle = bundle2;
            bArr = bArr2;
        }
        if (parcel.dataPosition() == G) {
            return new m(i, uri, bundle, bArr);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public m[] gz(int i) {
        return new m[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gz(x0);
    }
}
