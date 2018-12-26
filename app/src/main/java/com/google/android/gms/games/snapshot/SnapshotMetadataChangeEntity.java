package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jx;

public final class SnapshotMetadataChangeEntity extends SnapshotMetadataChange implements SafeParcelable {
    public static final SnapshotMetadataChangeCreator CREATOR = new SnapshotMetadataChangeCreator();
    private final int CK;
    private final String UO;
    private final Uri afd;
    private final Long afe;
    private a aff;

    SnapshotMetadataChangeEntity() {
        this(4, null, null, null, null);
    }

    SnapshotMetadataChangeEntity(int versionCode, String description, Long playedTimeMillis, a coverImage, Uri coverImageUri) {
        boolean z = true;
        this.CK = versionCode;
        this.UO = description;
        this.afe = playedTimeMillis;
        this.aff = coverImage;
        this.afd = coverImageUri;
        if (this.aff != null) {
            if (this.afd != null) {
                z = false;
            }
            jx.a(z, "Cannot set both a URI and an image");
        } else if (this.afd != null) {
            if (this.aff != null) {
                z = false;
            }
            jx.a(z, "Cannot set both a URI and an image");
        }
    }

    SnapshotMetadataChangeEntity(String description, Long playedTimeMillis, a coverImage, Uri coverImageUri) {
        this(4, description, playedTimeMillis, coverImage, coverImageUri);
    }

    public int describeContents() {
        return 0;
    }

    public Bitmap getCoverImage() {
        return this.aff == null ? null : this.aff.gT();
    }

    public Uri getCoverImageUri() {
        return this.afd;
    }

    public String getDescription() {
        return this.UO;
    }

    public Long getPlayedTimeMillis() {
        return this.afe;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public a mT() {
        return this.aff;
    }

    public void writeToParcel(Parcel out, int flags) {
        SnapshotMetadataChangeCreator.a(this, out, flags);
    }
}
