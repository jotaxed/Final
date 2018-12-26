package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Filter;

public class FilterHolder implements SafeParcelable {
    public static final Creator<FilterHolder> CREATOR = new d();
    final int CK;
    final ComparisonFilter<?> Sl;
    final FieldOnlyFilter Sm;
    final LogicalFilter Sn;
    final NotFilter So;
    final InFilter<?> Sp;
    final MatchAllFilter Sq;
    final HasFilter Sr;
    private final Filter Ss;

    FilterHolder(int versionCode, ComparisonFilter<?> comparisonField, FieldOnlyFilter fieldOnlyFilter, LogicalFilter logicalFilter, NotFilter notFilter, InFilter<?> containsFilter, MatchAllFilter matchAllFilter, HasFilter<?> hasFilter) {
        this.CK = versionCode;
        this.Sl = comparisonField;
        this.Sm = fieldOnlyFilter;
        this.Sn = logicalFilter;
        this.So = notFilter;
        this.Sp = containsFilter;
        this.Sq = matchAllFilter;
        this.Sr = hasFilter;
        if (this.Sl != null) {
            this.Ss = this.Sl;
        } else if (this.Sm != null) {
            this.Ss = this.Sm;
        } else if (this.Sn != null) {
            this.Ss = this.Sn;
        } else if (this.So != null) {
            this.Ss = this.So;
        } else if (this.Sp != null) {
            this.Ss = this.Sp;
        } else if (this.Sq != null) {
            this.Ss = this.Sq;
        } else if (this.Sr != null) {
            this.Ss = this.Sr;
        } else {
            throw new IllegalArgumentException("At least one filter must be set.");
        }
    }

    public FilterHolder(Filter filter) {
        this.CK = 2;
        this.Sl = filter instanceof ComparisonFilter ? (ComparisonFilter) filter : null;
        this.Sm = filter instanceof FieldOnlyFilter ? (FieldOnlyFilter) filter : null;
        this.Sn = filter instanceof LogicalFilter ? (LogicalFilter) filter : null;
        this.So = filter instanceof NotFilter ? (NotFilter) filter : null;
        this.Sp = filter instanceof InFilter ? (InFilter) filter : null;
        this.Sq = filter instanceof MatchAllFilter ? (MatchAllFilter) filter : null;
        this.Sr = filter instanceof HasFilter ? (HasFilter) filter : null;
        if (this.Sl == null && this.Sm == null && this.Sn == null && this.So == null && this.Sp == null && this.Sq == null && this.Sr == null) {
            throw new IllegalArgumentException("Invalid filter type or null filter.");
        }
        this.Ss = filter;
    }

    public int describeContents() {
        return 0;
    }

    public Filter getFilter() {
        return this.Ss;
    }

    public String toString() {
        return String.format("FilterHolder[%s]", new Object[]{this.Ss});
    }

    public void writeToParcel(Parcel out, int flags) {
        d.a(this, out, flags);
    }
}
