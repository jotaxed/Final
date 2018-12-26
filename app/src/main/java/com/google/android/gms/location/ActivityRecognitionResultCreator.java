package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public class ActivityRecognitionResultCreator implements Creator<ActivityRecognitionResult> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void a(ActivityRecognitionResult activityRecognitionResult, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, activityRecognitionResult.afX, false);
        b.c(parcel, 1000, activityRecognitionResult.getVersionCode());
        b.a(parcel, 2, activityRecognitionResult.afY);
        b.a(parcel, 3, activityRecognitionResult.afZ);
        b.H(parcel, H);
    }

    public ActivityRecognitionResult createFromParcel(Parcel parcel) {
        long j = 0;
        int G = a.G(parcel);
        int i = 0;
        List list = null;
        long j2 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    list = a.c(parcel, F, DetectedActivity.CREATOR);
                    break;
                case 2:
                    j2 = a.i(parcel, F);
                    break;
                case 3:
                    j = a.i(parcel, F);
                    break;
                case 1000:
                    i = a.g(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ActivityRecognitionResult(i, list, j2, j);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public ActivityRecognitionResult[] newArray(int size) {
        return new ActivityRecognitionResult[size];
    }
}
