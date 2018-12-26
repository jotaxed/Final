package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.query.Filter;

public class NotFilter extends AbstractFilter {
    public static final Creator<NotFilter> CREATOR = new k();
    final int CK;
    final FilterHolder Sv;

    NotFilter(int versionCode, FilterHolder toNegate) {
        this.CK = versionCode;
        this.Sv = toNegate;
    }

    public NotFilter(Filter toNegate) {
        this(1, new FilterHolder(toNegate));
    }

    public <T> T a(f<T> fVar) {
        return fVar.j(this.Sv.getFilter().a(fVar));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        k.a(this, out, flags);
    }
}
