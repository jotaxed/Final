package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveFile;

public class h implements Creator<CreateContentsRequest> {
    static void a(CreateContentsRequest createContentsRequest, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, createContentsRequest.CK);
        b.c(parcel, 2, createContentsRequest.Oi);
        b.H(parcel, H);
    }

    public CreateContentsRequest af(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        int i2 = DriveFile.MODE_WRITE_ONLY;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    i2 = a.g(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new CreateContentsRequest(i, i2);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public CreateContentsRequest[] bp(int i) {
        return new CreateContentsRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return af(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bp(x0);
    }
}
