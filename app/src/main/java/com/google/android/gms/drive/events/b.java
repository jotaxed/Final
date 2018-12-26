package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.List;

public class b implements Creator<CompletionEvent> {
    static void a(CompletionEvent completionEvent, Parcel parcel, int i) {
        int H = com.google.android.gms.common.internal.safeparcel.b.H(parcel);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 1, completionEvent.CK);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, completionEvent.Oj, i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, completionEvent.DZ, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 4, completionEvent.OY, i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 5, completionEvent.OZ, i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 6, completionEvent.Pa, i, false);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, 7, completionEvent.Pb, false);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 8, completionEvent.FP);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 9, completionEvent.Pc, false);
        com.google.android.gms.common.internal.safeparcel.b.H(parcel, H);
    }

    public CompletionEvent Y(Parcel parcel) {
        int i = 0;
        IBinder iBinder = null;
        int G = a.G(parcel);
        List list = null;
        MetadataBundle metadataBundle = null;
        ParcelFileDescriptor parcelFileDescriptor = null;
        ParcelFileDescriptor parcelFileDescriptor2 = null;
        String str = null;
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i2 = a.g(parcel, F);
                    break;
                case 2:
                    driveId = (DriveId) a.a(parcel, F, DriveId.CREATOR);
                    break;
                case 3:
                    str = a.o(parcel, F);
                    break;
                case 4:
                    parcelFileDescriptor2 = (ParcelFileDescriptor) a.a(parcel, F, ParcelFileDescriptor.CREATOR);
                    break;
                case 5:
                    parcelFileDescriptor = (ParcelFileDescriptor) a.a(parcel, F, ParcelFileDescriptor.CREATOR);
                    break;
                case 6:
                    metadataBundle = (MetadataBundle) a.a(parcel, F, MetadataBundle.CREATOR);
                    break;
                case 7:
                    list = a.C(parcel, F);
                    break;
                case 8:
                    i = a.g(parcel, F);
                    break;
                case 9:
                    iBinder = a.p(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new CompletionEvent(i2, driveId, str, parcelFileDescriptor2, parcelFileDescriptor, metadataBundle, list, i, iBinder);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public CompletionEvent[] bg(int i) {
        return new CompletionEvent[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return Y(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bg(x0);
    }
}
