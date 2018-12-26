package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Query;

public class QueryRequest implements SafeParcelable {
    public static final Creator<QueryRequest> CREATOR = new bb();
    final int CK;
    final Query QV;

    QueryRequest(int versionCode, Query query) {
        this.CK = versionCode;
        this.QV = query;
    }

    public QueryRequest(Query query) {
        this(1, query);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        bb.a(this, dest, flags);
    }
}
