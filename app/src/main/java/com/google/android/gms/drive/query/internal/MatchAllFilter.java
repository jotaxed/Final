package com.google.android.gms.drive.query.internal;

import android.os.Parcel;

public class MatchAllFilter extends AbstractFilter {
    public static final j CREATOR = new j();
    final int CK;

    public MatchAllFilter() {
        this(1);
    }

    MatchAllFilter(int versionCode) {
        this.CK = versionCode;
    }

    public <F> F a(f<F> fVar) {
        return fVar.jd();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        j.a(this, out, flags);
    }
}
