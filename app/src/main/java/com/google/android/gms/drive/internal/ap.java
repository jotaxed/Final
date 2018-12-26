package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DrivePreferences;

public class ap implements Creator<OnDrivePreferencesResponse> {
    static void a(OnDrivePreferencesResponse onDrivePreferencesResponse, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, onDrivePreferencesResponse.CK);
        b.a(parcel, 2, onDrivePreferencesResponse.QN, i, false);
        b.H(parcel, H);
    }

    public OnDrivePreferencesResponse au(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        DrivePreferences drivePreferences = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    drivePreferences = (DrivePreferences) a.a(parcel, F, DrivePreferences.CREATOR);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new OnDrivePreferencesResponse(i, drivePreferences);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public OnDrivePreferencesResponse[] bJ(int i) {
        return new OnDrivePreferencesResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return au(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bJ(x0);
    }
}
