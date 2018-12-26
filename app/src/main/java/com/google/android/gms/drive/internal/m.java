package com.google.android.gms.drive.internal;

import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public final class m extends Metadata {
    private final MetadataBundle PD;

    public m(MetadataBundle metadataBundle) {
        this.PD = metadataBundle;
    }

    protected <T> T a(MetadataField<T> metadataField) {
        return this.PD.a((MetadataField) metadataField);
    }

    public /* synthetic */ Object freeze() {
        return iy();
    }

    public boolean isDataValid() {
        return this.PD != null;
    }

    public Metadata iy() {
        return new m(MetadataBundle.a(this.PD));
    }

    public String toString() {
        return "Metadata [mImpl=" + this.PD + "]";
    }
}
