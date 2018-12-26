package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.query.internal.FieldWithSortOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SortOrder implements SafeParcelable {
    public static final Creator<SortOrder> CREATOR = new b();
    final int CK;
    final List<FieldWithSortOrder> Sf;
    final boolean Sg;

    public static class Builder {
        private final List<FieldWithSortOrder> Sf = new ArrayList();
        private boolean Sg = false;

        public Builder addSortAscending(SortableMetadataField sortField) {
            this.Sf.add(new FieldWithSortOrder(sortField.getName(), true));
            return this;
        }

        public Builder addSortDescending(SortableMetadataField sortField) {
            this.Sf.add(new FieldWithSortOrder(sortField.getName(), false));
            return this;
        }

        public SortOrder build() {
            return new SortOrder(this.Sf, this.Sg);
        }
    }

    SortOrder(int versionCode, List<FieldWithSortOrder> sortingFields, boolean sortFolderFirst) {
        this.CK = versionCode;
        this.Sf = sortingFields;
        this.Sg = sortFolderFirst;
    }

    private SortOrder(List<FieldWithSortOrder> sortingFields, boolean sortFolderFirst) {
        this(1, (List) sortingFields, sortFolderFirst);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format(Locale.US, "SortOrder[%s, %s]", new Object[]{TextUtils.join(",", this.Sf), Boolean.valueOf(this.Sg)});
    }

    public void writeToParcel(Parcel out, int flags) {
        b.a(this, out, flags);
    }
}
