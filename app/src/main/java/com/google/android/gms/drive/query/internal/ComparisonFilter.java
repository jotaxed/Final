package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class ComparisonFilter<T> extends AbstractFilter {
    public static final a CREATOR = new a();
    final int CK;
    final Operator Sh;
    final MetadataBundle Si;
    final MetadataField<T> Sj;

    ComparisonFilter(int versionCode, Operator operator, MetadataBundle value) {
        this.CK = versionCode;
        this.Sh = operator;
        this.Si = value;
        this.Sj = e.b(value);
    }

    public ComparisonFilter(Operator operator, SearchableMetadataField<T> field, T value) {
        this(1, operator, MetadataBundle.a(field, value));
    }

    public <F> F a(f<F> fVar) {
        return fVar.b(this.Sh, this.Sj, getValue());
    }

    public int describeContents() {
        return 0;
    }

    public T getValue() {
        return this.Si.a(this.Sj);
    }

    public void writeToParcel(Parcel out, int flags) {
        a.a(this, out, flags);
    }
}
