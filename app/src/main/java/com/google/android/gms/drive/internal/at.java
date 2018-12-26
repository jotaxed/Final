package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class at implements Creator<OnMetadataResponse> {
    static void a(OnMetadataResponse onMetadataResponse, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, onMetadataResponse.CK);
        b.a(parcel, 2, onMetadataResponse.Px, i, false);
        b.H(parcel, H);
    }

    public OnMetadataResponse ay(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        MetadataBundle metadataBundle = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    metadataBundle = (MetadataBundle) a.a(parcel, F, MetadataBundle.CREATOR);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new OnMetadataResponse(i, metadataBundle);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public OnMetadataResponse[] bN(int i) {
        return new OnMetadataResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ay(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bN(x0);
    }
}
