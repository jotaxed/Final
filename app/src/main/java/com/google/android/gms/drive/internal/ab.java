package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ab implements Creator<FileUploadPreferencesImpl> {
    static void a(FileUploadPreferencesImpl fileUploadPreferencesImpl, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, fileUploadPreferencesImpl.CK);
        b.c(parcel, 2, fileUploadPreferencesImpl.Qz);
        b.c(parcel, 3, fileUploadPreferencesImpl.QA);
        b.a(parcel, 4, fileUploadPreferencesImpl.QB);
        b.H(parcel, H);
    }

    public FileUploadPreferencesImpl al(Parcel parcel) {
        boolean z = false;
        int G = a.G(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i3 = a.g(parcel, F);
                    break;
                case 2:
                    i2 = a.g(parcel, F);
                    break;
                case 3:
                    i = a.g(parcel, F);
                    break;
                case 4:
                    z = a.c(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new FileUploadPreferencesImpl(i3, i2, i, z);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public FileUploadPreferencesImpl[] bA(int i) {
        return new FileUploadPreferencesImpl[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return al(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bA(x0);
    }
}
