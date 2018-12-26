package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class HasFilter<T> extends AbstractFilter {
    public static final g CREATOR = new g();
    final int CK;
    final MetadataBundle Si;
    final MetadataField<T> Sj;

    HasFilter(int versionCode, MetadataBundle value) {
        this.CK = versionCode;
        this.Si = value;
        this.Sj = e.b(value);
    }

    public HasFilter(SearchableMetadataField<T> field, T value) {
        this(1, MetadataBundle.a(field, value));
    }

    public <F> F a(f<F> fVar) {
        return fVar.d(this.Sj, getValue());
    }

    public int describeContents() {
        return 0;
    }

    public T getValue() {
        return this.Si.a(this.Sj);
    }

    public void writeToParcel(Parcel out, int flags) {
        g.a(this, out, flags);
    }
}
