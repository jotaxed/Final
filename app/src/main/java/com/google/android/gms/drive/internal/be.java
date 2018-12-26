package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class be implements Creator<SetFileUploadPreferencesRequest> {
    static void a(SetFileUploadPreferencesRequest setFileUploadPreferencesRequest, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, setFileUploadPreferencesRequest.CK);
        b.a(parcel, 2, setFileUploadPreferencesRequest.QK, i, false);
        b.H(parcel, H);
    }

    public SetFileUploadPreferencesRequest aI(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        FileUploadPreferencesImpl fileUploadPreferencesImpl = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    fileUploadPreferencesImpl = (FileUploadPreferencesImpl) a.a(parcel, F, FileUploadPreferencesImpl.CREATOR);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new SetFileUploadPreferencesRequest(i, fileUploadPreferencesImpl);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public SetFileUploadPreferencesRequest[] bX(int i) {
        return new SetFileUploadPreferencesRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aI(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bX(x0);
    }
}
