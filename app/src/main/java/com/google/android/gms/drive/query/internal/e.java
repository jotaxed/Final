package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Set;

class e {
    static MetadataField<?> b(MetadataBundle metadataBundle) {
        Set ja = metadataBundle.ja();
        if (ja.size() == 1) {
            return (MetadataField) ja.iterator().next();
        }
        throw new IllegalArgumentException("bundle should have exactly 1 populated field");
    }
}
