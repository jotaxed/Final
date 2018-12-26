package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.MatchAllFilter;
import com.google.android.gms.drive.query.internal.Operator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Query implements SafeParcelable {
    public static final Creator<Query> CREATOR = new a();
    final int CK;
    final LogicalFilter RY;
    final String RZ;
    final SortOrder Sa;
    final List<String> Sb;

    public static class Builder {
        private String RZ;
        private SortOrder Sa;
        private List<String> Sb;
        private final List<Filter> Sc = new ArrayList();

        public Builder(Query query) {
            this.Sc.add(query.getFilter());
            this.RZ = query.getPageToken();
            this.Sa = query.getSortOrder();
            this.Sb = query.jb();
        }

        public Builder addFilter(Filter filter) {
            if (!(filter instanceof MatchAllFilter)) {
                this.Sc.add(filter);
            }
            return this;
        }

        public Query build() {
            return new Query(new LogicalFilter(Operator.SB, this.Sc), this.RZ, this.Sa, this.Sb);
        }

        public Builder setPageToken(String token) {
            this.RZ = token;
            return this;
        }

        public Builder setSortOrder(SortOrder sortOrder) {
            this.Sa = sortOrder;
            return this;
        }
    }

    Query(int versionCode, LogicalFilter clause, String pageToken, SortOrder sortOrder, List<String> requestedMetadataFields) {
        this.CK = versionCode;
        this.RY = clause;
        this.RZ = pageToken;
        this.Sa = sortOrder;
        this.Sb = requestedMetadataFields;
    }

    Query(LogicalFilter clause, String pageToken, SortOrder sortOrder, List<String> requestedMetadataFields) {
        this(1, clause, pageToken, sortOrder, requestedMetadataFields);
    }

    public int describeContents() {
        return 0;
    }

    public Filter getFilter() {
        return this.RY;
    }

    public String getPageToken() {
        return this.RZ;
    }

    public SortOrder getSortOrder() {
        return this.Sa;
    }

    public List<String> jb() {
        return this.Sb;
    }

    public String toString() {
        return String.format(Locale.US, "Query[%s,%s,PageToken=%s]", new Object[]{this.RY, this.Sa, this.RZ});
    }

    public void writeToParcel(Parcel out, int flags) {
        a.a(this, out, flags);
    }
}
