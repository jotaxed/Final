package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class FieldOnlyFilter extends AbstractFilter {
    public static final Creator<FieldOnlyFilter> CREATOR = new b();
    final int CK;
    final MetadataBundle Si;
    private final MetadataField<?> Sj;

    FieldOnlyFilter(int versionCode, MetadataBundle value) {
        this.CK = versionCode;
        this.Si = value;
        this.Sj = e.b(value);
    }

    public FieldOnlyFilter(SearchableMetadataField<?> field) {
        this(1, MetadataBundle.a(field, null));
    }

    public <T> T a(f<T> fVar) {
        return fVar.d(this.Sj);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        b.a(this, out, flags);
    }
}
