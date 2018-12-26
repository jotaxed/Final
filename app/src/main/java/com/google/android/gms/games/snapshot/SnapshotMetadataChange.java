package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import com.google.android.gms.common.data.a;

public abstract class SnapshotMetadataChange {
    public static final SnapshotMetadataChange EMPTY_CHANGE = new SnapshotMetadataChangeEntity();

    public static final class Builder {
        private String UO;
        private Long afb;
        private a afc;
        private Uri afd;

        public SnapshotMetadataChange build() {
            return new SnapshotMetadataChangeEntity(this.UO, this.afb, this.afc, this.afd);
        }

        public Builder fromMetadata(SnapshotMetadata metadata) {
            this.UO = metadata.getDescription();
            this.afb = Long.valueOf(metadata.getPlayedTime());
            if (this.afb.longValue() == -1) {
                this.afb = null;
            }
            this.afd = metadata.getCoverImageUri();
            if (this.afd != null) {
                this.afc = null;
            }
            return this;
        }

        public Builder setCoverImage(Bitmap coverImage) {
            this.afc = new a(coverImage);
            this.afd = null;
            return this;
        }

        public Builder setDescription(String description) {
            this.UO = description;
            return this;
        }

        public Builder setPlayedTimeMillis(long playedTimeMillis) {
            this.afb = Long.valueOf(playedTimeMillis);
            return this;
        }
    }

    protected SnapshotMetadataChange() {
    }

    public abstract Bitmap getCoverImage();

    public abstract String getDescription();

    public abstract Long getPlayedTimeMillis();

    public abstract a mT();
}
