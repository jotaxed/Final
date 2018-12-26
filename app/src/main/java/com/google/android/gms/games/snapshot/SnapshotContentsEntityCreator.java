package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.Contents;

public class SnapshotContentsEntityCreator implements Creator<SnapshotContentsEntity> {
    static void a(SnapshotContentsEntity snapshotContentsEntity, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, snapshotContentsEntity.ir(), i, false);
        b.c(parcel, 1000, snapshotContentsEntity.getVersionCode());
        b.H(parcel, H);
    }

    public SnapshotContentsEntity cD(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        Contents contents = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    contents = (Contents) a.a(parcel, F, Contents.CREATOR);
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
            return new SnapshotContentsEntity(i, contents);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cD(x0);
    }

    public SnapshotContentsEntity[] eq(int i) {
        return new SnapshotContentsEntity[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eq(x0);
    }
}
