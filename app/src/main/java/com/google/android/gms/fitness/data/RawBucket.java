package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class RawBucket implements SafeParcelable {
    public static final Creator<RawBucket> CREATOR = new m();
    final int CK;
    final long LW;
    final long TO;
    final Session TQ;
    final int UI;
    final List<RawDataSet> Ua;
    final int Ub;
    final boolean Uc;

    RawBucket(int versionCode, long startTimeMillis, long endTimeMillis, Session session, int activity, List<RawDataSet> dataSets, int bucketType, boolean serverHasMoreData) {
        this.CK = versionCode;
        this.LW = startTimeMillis;
        this.TO = endTimeMillis;
        this.TQ = session;
        this.UI = activity;
        this.Ua = dataSets;
        this.Ub = bucketType;
        this.Uc = serverHasMoreData;
    }

    public RawBucket(Bucket bucket, List<DataSource> uniqueDataSources, List<DataType> uniqueDataTypes) {
        this.CK = 2;
        this.LW = bucket.getStartTime(TimeUnit.MILLISECONDS);
        this.TO = bucket.getEndTime(TimeUnit.MILLISECONDS);
        this.TQ = bucket.getSession();
        this.UI = bucket.jm();
        this.Ub = bucket.getBucketType();
        this.Uc = bucket.jn();
        List<DataSet> dataSets = bucket.getDataSets();
        this.Ua = new ArrayList(dataSets.size());
        for (DataSet rawDataSet : dataSets) {
            this.Ua.add(new RawDataSet(rawDataSet, uniqueDataSources, uniqueDataTypes));
        }
    }

    private boolean a(RawBucket rawBucket) {
        return this.LW == rawBucket.LW && this.TO == rawBucket.TO && this.UI == rawBucket.UI && jv.equal(this.Ua, rawBucket.Ua) && this.Ub == rawBucket.Ub && this.Uc == rawBucket.Uc;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof RawBucket) && a((RawBucket) o));
    }

    public int hashCode() {
        return jv.hashCode(Long.valueOf(this.LW), Long.valueOf(this.TO), Integer.valueOf(this.Ub));
    }

    public String toString() {
        return jv.h(this).a("startTime", Long.valueOf(this.LW)).a("endTime", Long.valueOf(this.TO)).a("activity", Integer.valueOf(this.UI)).a("dataSets", this.Ua).a("bucketType", Integer.valueOf(this.Ub)).a("serverHasMoreData", Boolean.valueOf(this.Uc)).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        m.a(this, parcel, flags);
    }
}
