package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;

public class ba implements Creator<OpenFileIntentSenderRequest> {
    static void a(OpenFileIntentSenderRequest openFileIntentSenderRequest, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, openFileIntentSenderRequest.CK);
        b.a(parcel, 2, openFileIntentSenderRequest.OH, false);
        b.a(parcel, 3, openFileIntentSenderRequest.OI, false);
        b.a(parcel, 4, openFileIntentSenderRequest.OJ, i, false);
        b.H(parcel, H);
    }

    public OpenFileIntentSenderRequest aE(Parcel parcel) {
        DriveId driveId = null;
        int G = a.G(parcel);
        int i = 0;
        String[] strArr = null;
        String str = null;
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
                    strArr = a.A(parcel, F);
                    break;
                case 4:
                    driveId = (DriveId) a.a(parcel, F, DriveId.CREATOR);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new OpenFileIntentSenderRequest(i, str, strArr, driveId);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public OpenFileIntentSenderRequest[] bT(int i) {
        return new OpenFileIntentSenderRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aE(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bT(x0);
    }
}
