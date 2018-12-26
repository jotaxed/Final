package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.query.Filter;
import java.util.ArrayList;
import java.util.List;

public class LogicalFilter extends AbstractFilter {
    public static final Creator<LogicalFilter> CREATOR = new i();
    final int CK;
    private List<Filter> Sc;
    final Operator Sh;
    final List<FilterHolder> Su;

    LogicalFilter(int versionCode, Operator operator, List<FilterHolder> filterHolders) {
        this.CK = versionCode;
        this.Sh = operator;
        this.Su = filterHolders;
    }

    public LogicalFilter(Operator operator, Filter filter, Filter... additionalFilters) {
        this.CK = 1;
        this.Sh = operator;
        this.Su = new ArrayList(additionalFilters.length + 1);
        this.Su.add(new FilterHolder(filter));
        this.Sc = new ArrayList(additionalFilters.length + 1);
        this.Sc.add(filter);
        for (Filter filter2 : additionalFilters) {
            this.Su.add(new FilterHolder(filter2));
            this.Sc.add(filter2);
        }
    }

    public LogicalFilter(Operator operator, Iterable<Filter> filters) {
        this.CK = 1;
        this.Sh = operator;
        this.Sc = new ArrayList();
        this.Su = new ArrayList();
        for (Filter filter : filters) {
            this.Sc.add(filter);
            this.Su.add(new FilterHolder(filter));
        }
    }

    public <T> T a(f<T> fVar) {
        List arrayList = new ArrayList();
        for (FilterHolder filter : this.Su) {
            arrayList.add(filter.getFilter().a(fVar));
        }
        return fVar.b(this.Sh, arrayList);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        i.a(this, out, flags);
    }
}
