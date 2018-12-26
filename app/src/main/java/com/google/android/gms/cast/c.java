package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class c implements Creator<LaunchOptions> {
    static void a(LaunchOptions launchOptions, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, launchOptions.getVersionCode());
        b.a(parcel, 2, launchOptions.getRelaunchIfRunning());
        b.a(parcel, 3, launchOptions.getLanguage(), false);
        b.H(parcel, H);
    }

    public LaunchOptions[] aa(int i) {
        return new LaunchOptions[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return w(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aa(x0);
    }

    public LaunchOptions w(Parcel parcel) {
        boolean z = false;
        int G = a.G(parcel);
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    z = a.c(parcel, F);
                    break;
                case 3:
                    str = a.o(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new LaunchOptions(i, z, str);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }
}
