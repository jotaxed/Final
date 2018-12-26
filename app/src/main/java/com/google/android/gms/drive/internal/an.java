package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class an implements Creator<OnDownloadProgressResponse> {
    static void a(OnDownloadProgressResponse onDownloadProgressResponse, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, onDownloadProgressResponse.CK);
        b.a(parcel, 2, onDownloadProgressResponse.QL);
        b.a(parcel, 3, onDownloadProgressResponse.QM);
        b.H(parcel, H);
    }

    public OnDownloadProgressResponse as(Parcel parcel) {
        long j = 0;
        int G = a.G(parcel);
        int i = 0;
        long j2 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    j2 = a.i(parcel, F);
                    break;
                case 3:
                    j = a.i(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new OnDownloadProgressResponse(i, j2, j);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public OnDownloadProgressResponse[] bH(int i) {
        return new OnDownloadProgressResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return as(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bH(x0);
    }
}
