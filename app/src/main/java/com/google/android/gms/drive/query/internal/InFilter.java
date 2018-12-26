package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Collection;
import java.util.Collections;

public class InFilter<T> extends AbstractFilter {
    public static final h CREATOR = new h();
    final int CK;
    final MetadataBundle Si;
    private final b<T> St;

    InFilter(int versionCode, MetadataBundle value) {
        this.CK = versionCode;
        this.Si = value;
        this.St = (b) e.b(value);
    }

    public InFilter(SearchableCollectionMetadataField<T> field, T value) {
        this(1, MetadataBundle.a(field, Collections.singleton(value)));
    }

    public <F> F a(f<F> fVar) {
        return fVar.b(this.St, getValue());
    }

    public int describeContents() {
        return 0;
    }

    public T getValue() {
        return ((Collection) this.Si.a(this.St)).iterator().next();
    }

    public void writeToParcel(Parcel out, int flags) {
        h.a(this, out, flags);
    }
}
