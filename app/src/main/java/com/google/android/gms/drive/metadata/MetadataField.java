package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public interface MetadataField<T> {
    T a(DataHolder dataHolder, int i, int i2);

    void a(DataHolder dataHolder, MetadataBundle metadataBundle, int i, int i2);

    void a(T t, Bundle bundle);

    String getName();

    T h(Bundle bundle);
}
