package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class DetectedActivityCreator implements Creator<DetectedActivity> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void a(DetectedActivity detectedActivity, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, detectedActivity.agb);
        b.c(parcel, 1000, detectedActivity.getVersionCode());
        b.c(parcel, 2, detectedActivity.agc);
        b.H(parcel, H);
    }

    public DetectedActivity createFromParcel(Parcel parcel) {
        int i = 0;
        int G = a.G(parcel);
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i2 = a.g(parcel, F);
                    break;
                case 2:
                    i = a.g(parcel, F);
                    break;
                case 1000:
                    i3 = a.g(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new DetectedActivity(i3, i2, i);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public DetectedActivity[] newArray(int size) {
        return new DetectedActivity[size];
    }
}
