package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.jx;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class a<T> implements MetadataField<T> {
    private final String QY;
    private final Set<String> QZ;
    private final Set<String> Ra;
    private final int Rb;

    protected a(String str, int i) {
        this.QY = (String) jx.b((Object) str, (Object) "fieldName");
        this.QZ = Collections.singleton(str);
        this.Ra = Collections.emptySet();
        this.Rb = i;
    }

    protected a(String str, Collection<String> collection, Collection<String> collection2, int i) {
        this.QY = (String) jx.b((Object) str, (Object) "fieldName");
        this.QZ = Collections.unmodifiableSet(new HashSet(collection));
        this.Ra = Collections.unmodifiableSet(new HashSet(collection2));
        this.Rb = i;
    }

    public final T a(DataHolder dataHolder, int i, int i2) {
        return b(dataHolder, i, i2) ? c(dataHolder, i, i2) : null;
    }

    protected abstract void a(Bundle bundle, T t);

    public final void a(DataHolder dataHolder, MetadataBundle metadataBundle, int i, int i2) {
        jx.b((Object) dataHolder, (Object) "dataHolder");
        jx.b((Object) metadataBundle, (Object) "bundle");
        metadataBundle.b(this, a(dataHolder, i, i2));
    }

    public final void a(T t, Bundle bundle) {
        jx.b((Object) bundle, (Object) "bundle");
        if (t == null) {
            bundle.putString(getName(), null);
        } else {
            a(bundle, (Object) t);
        }
    }

    protected boolean b(DataHolder dataHolder, int i, int i2) {
        for (String h : this.QZ) {
            if (dataHolder.h(h, i, i2)) {
                return false;
            }
        }
        return true;
    }

    protected abstract T c(DataHolder dataHolder, int i, int i2);

    public final String getName() {
        return this.QY;
    }

    public final T h(Bundle bundle) {
        jx.b((Object) bundle, (Object) "bundle");
        return bundle.get(getName()) != null ? i(bundle) : null;
    }

    protected abstract T i(Bundle bundle);

    public String toString() {
        return this.QY;
    }
}
