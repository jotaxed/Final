package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;
import java.util.ArrayList;
import java.util.List;

public class bf implements Creator<SetResourceParentsRequest> {
    static void a(SetResourceParentsRequest setResourceParentsRequest, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, setResourceParentsRequest.CK);
        b.a(parcel, 2, setResourceParentsRequest.QW, i, false);
        b.c(parcel, 3, setResourceParentsRequest.QX, false);
        b.H(parcel, H);
    }

    public SetResourceParentsRequest aJ(Parcel parcel) {
        List list = null;
        int G = a.G(parcel);
        int i = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < G) {
            DriveId driveId2;
            int g;
            ArrayList c;
            int F = a.F(parcel);
            List list2;
            switch (a.aH(F)) {
                case 1:
                    List list3 = list;
                    driveId2 = driveId;
                    g = a.g(parcel, F);
                    list2 = list3;
                    break;
                case 2:
                    g = i;
                    DriveId driveId3 = (DriveId) a.a(parcel, F, DriveId.CREATOR);
                    list2 = list;
                    driveId2 = driveId3;
                    break;
                case 3:
                    c = a.c(parcel, F, DriveId.CREATOR);
                    driveId2 = driveId;
                    g = i;
                    break;
                default:
                    a.b(parcel, F);
                    c = list;
                    driveId2 = driveId;
                    g = i;
                    break;
            }
            i = g;
            driveId = driveId2;
            Object obj = c;
        }
        if (parcel.dataPosition() == G) {
            return new SetResourceParentsRequest(i, driveId, list);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public SetResourceParentsRequest[] bY(int i) {
        return new SetResourceParentsRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aJ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bY(x0);
    }
}
