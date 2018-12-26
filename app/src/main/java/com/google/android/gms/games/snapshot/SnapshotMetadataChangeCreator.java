package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class SnapshotMetadataChangeCreator implements Creator<SnapshotMetadataChangeEntity> {
    static void a(SnapshotMetadataChangeEntity snapshotMetadataChangeEntity, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, snapshotMetadataChangeEntity.getDescription(), false);
        b.c(parcel, 1000, snapshotMetadataChangeEntity.getVersionCode());
        b.a(parcel, 2, snapshotMetadataChangeEntity.getPlayedTimeMillis(), false);
        b.a(parcel, 4, snapshotMetadataChangeEntity.getCoverImageUri(), i, false);
        b.a(parcel, 5, snapshotMetadataChangeEntity.mT(), i, false);
        b.H(parcel, H);
    }

    public SnapshotMetadataChangeEntity cE(Parcel parcel) {
        Uri uri = null;
        int G = a.G(parcel);
        int i = 0;
        com.google.android.gms.common.data.a aVar = null;
        Long l = null;
        String str = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    str = a.o(parcel, F);
                    break;
                case 2:
                    l = a.j(parcel, F);
                    break;
                case 4:
                    uri = (Uri) a.a(parcel, F, Uri.CREATOR);
                    break;
                case 5:
                    aVar = (com.google.android.gms.common.data.a) a.a(parcel, F, com.google.android.gms.common.data.a.CREATOR);
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
            return new SnapshotMetadataChangeEntity(i, str, l, aVar, uri);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cE(x0);
    }

    public SnapshotMetadataChangeEntity[] er(int i) {
        return new SnapshotMetadataChangeEntity[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return er(x0);
    }
}
