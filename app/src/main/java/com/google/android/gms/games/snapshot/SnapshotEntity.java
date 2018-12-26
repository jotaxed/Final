package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;

public final class SnapshotEntity implements SafeParcelable, Snapshot {
    public static final SnapshotEntityCreator CREATOR = new SnapshotEntityCreator();
    private final int CK;
    private final SnapshotMetadataEntity aeZ;
    private final SnapshotContentsEntity afa;

    SnapshotEntity(int versionCode, SnapshotMetadata metadata, SnapshotContentsEntity contents) {
        this.CK = versionCode;
        this.aeZ = new SnapshotMetadataEntity(metadata);
        this.afa = contents;
    }

    public SnapshotEntity(SnapshotMetadata metadata, SnapshotContentsEntity contents) {
        this(2, metadata, contents);
    }

    static boolean a(Snapshot snapshot, Object obj) {
        if (!(obj instanceof Snapshot)) {
            return false;
        }
        if (snapshot == obj) {
            return true;
        }
        Snapshot snapshot2 = (Snapshot) obj;
        return jv.equal(snapshot2.getMetadata(), snapshot.getMetadata()) && jv.equal(snapshot2.getSnapshotContents(), snapshot.getSnapshotContents());
    }

    static int b(Snapshot snapshot) {
        return jv.hashCode(snapshot.getMetadata(), snapshot.getSnapshotContents());
    }

    static String c(Snapshot snapshot) {
        return jv.h(snapshot).a("Metadata", snapshot.getMetadata()).a("HasContents", Boolean.valueOf(snapshot.getSnapshotContents() != null)).toString();
    }

    private boolean isClosed() {
        return this.afa.isClosed();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    public Snapshot freeze() {
        return this;
    }

    public SnapshotMetadata getMetadata() {
        return this.aeZ;
    }

    public SnapshotContents getSnapshotContents() {
        return isClosed() ? null : this.afa;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return b(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return c(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        SnapshotEntityCreator.a(this, out, flags);
    }
}
