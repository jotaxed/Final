package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class SnapshotEntityCreator implements Creator<SnapshotEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void a(SnapshotEntity snapshotEntity, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, snapshotEntity.getMetadata(), i, false);
        b.c(parcel, 1000, snapshotEntity.getVersionCode());
        b.a(parcel, 3, snapshotEntity.getSnapshotContents(), i, false);
        b.H(parcel, H);
    }

    public SnapshotEntity createFromParcel(Parcel parcel) {
        SnapshotContentsEntity snapshotContentsEntity = null;
        int G = a.G(parcel);
        int i = 0;
        SnapshotMetadata snapshotMetadata = null;
        while (parcel.dataPosition() < G) {
            int i2;
            SnapshotContentsEntity snapshotContentsEntity2;
            SnapshotMetadata snapshotMetadata2;
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i2 = i;
                    SnapshotMetadataEntity snapshotMetadataEntity = (SnapshotMetadataEntity) a.a(parcel, F, SnapshotMetadataEntity.CREATOR);
                    snapshotContentsEntity2 = snapshotContentsEntity;
                    Object obj = snapshotMetadataEntity;
                    break;
                case 3:
                    snapshotContentsEntity2 = (SnapshotContentsEntity) a.a(parcel, F, SnapshotContentsEntity.CREATOR);
                    snapshotMetadata2 = snapshotMetadata;
                    i2 = i;
                    break;
                case 1000:
                    SnapshotContentsEntity snapshotContentsEntity3 = snapshotContentsEntity;
                    snapshotMetadata2 = snapshotMetadata;
                    i2 = a.g(parcel, F);
                    snapshotContentsEntity2 = snapshotContentsEntity3;
                    break;
                default:
                    a.b(parcel, F);
                    snapshotContentsEntity2 = snapshotContentsEntity;
                    snapshotMetadata2 = snapshotMetadata;
                    i2 = i;
                    break;
            }
            i = i2;
            snapshotMetadata = snapshotMetadata2;
            snapshotContentsEntity = snapshotContentsEntity2;
        }
        if (parcel.dataPosition() == G) {
            return new SnapshotEntity(i, snapshotMetadata, snapshotContentsEntity);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public SnapshotEntity[] newArray(int size) {
        return new SnapshotEntity[size];
    }
}
