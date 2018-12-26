package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;

public class a implements Creator<Asset> {
    static void a(Asset asset, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, asset.CK);
        b.a(parcel, 2, asset.getData(), false);
        b.a(parcel, 3, asset.getDigest(), false);
        b.a(parcel, 4, asset.axb, i, false);
        b.a(parcel, 5, asset.uri, i, false);
        b.H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return el(x0);
    }

    public Asset el(Parcel parcel) {
        Uri uri = null;
        int G = com.google.android.gms.common.internal.safeparcel.a.G(parcel);
        int i = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        String str = null;
        byte[] bArr = null;
        while (parcel.dataPosition() < G) {
            int F = com.google.android.gms.common.internal.safeparcel.a.F(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.aH(F)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, F);
                    break;
                case 2:
                    bArr = com.google.android.gms.common.internal.safeparcel.a.r(parcel, F);
                    break;
                case 3:
                    str = com.google.android.gms.common.internal.safeparcel.a.o(parcel, F);
                    break;
                case 4:
                    parcelFileDescriptor = (ParcelFileDescriptor) com.google.android.gms.common.internal.safeparcel.a.a(parcel, F, ParcelFileDescriptor.CREATOR);
                    break;
                case 5:
                    uri = (Uri) com.google.android.gms.common.internal.safeparcel.a.a(parcel, F, Uri.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new Asset(i, bArr, str, parcelFileDescriptor, uri);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + G, parcel);
    }

    public Asset[] gu(int i) {
        return new Asset[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gu(x0);
    }
}
