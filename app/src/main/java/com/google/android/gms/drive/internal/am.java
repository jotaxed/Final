package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class am implements Creator<OnDeviceUsagePreferenceResponse> {
    static void a(OnDeviceUsagePreferenceResponse onDeviceUsagePreferenceResponse, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, onDeviceUsagePreferenceResponse.CK);
        b.a(parcel, 2, onDeviceUsagePreferenceResponse.QK, i, false);
        b.H(parcel, H);
    }

    public OnDeviceUsagePreferenceResponse ar(Parcel parcel) {
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
            return new OnDeviceUsagePreferenceResponse(i, fileUploadPreferencesImpl);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public OnDeviceUsagePreferenceResponse[] bG(int i) {
        return new OnDeviceUsagePreferenceResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ar(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bG(x0);
    }
}
