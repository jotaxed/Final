package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class RawDataPoint implements SafeParcelable {
    public static final Creator<RawDataPoint> CREATOR = new n();
    final int CK;
    final int UJ;
    final int UK;
    final long Ud;
    final long Ue;
    final Value[] Uf;
    final long Uh;
    final long Ui;

    RawDataPoint(int versionCode, long timestampNanos, long startTimeNanos, Value[] values, int dataSourceIndex, int originalDataSourceIndex, long rawTimestamp, long insertionTimeMillis) {
        this.CK = versionCode;
        this.Ud = timestampNanos;
        this.Ue = startTimeNanos;
        this.UJ = dataSourceIndex;
        this.UK = originalDataSourceIndex;
        this.Uh = rawTimestamp;
        this.Ui = insertionTimeMillis;
        this.Uf = values;
    }

    RawDataPoint(DataPoint dataPoint, List<DataSource> dataSources) {
        this.CK = 4;
        this.Ud = dataPoint.getTimestamp(TimeUnit.NANOSECONDS);
        this.Ue = dataPoint.getStartTime(TimeUnit.NANOSECONDS);
        this.Uf = dataPoint.jr();
        this.UJ = t.a(dataPoint.getDataSource(), dataSources);
        this.UK = t.a(dataPoint.getOriginalDataSource(), dataSources);
        this.Uh = dataPoint.js();
        this.Ui = dataPoint.jt();
    }

    private boolean a(RawDataPoint rawDataPoint) {
        return this.Ud == rawDataPoint.Ud && this.Ue == rawDataPoint.Ue && Arrays.equals(this.Uf, rawDataPoint.Uf) && this.UJ == rawDataPoint.UJ && this.UK == rawDataPoint.UK && this.Uh == rawDataPoint.Uh;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof RawDataPoint) && a((RawDataPoint) o));
    }

    public int hashCode() {
        return jv.hashCode(Long.valueOf(this.Ud), Long.valueOf(this.Ue));
    }

    public String toString() {
        return String.format("RawDataPoint{%s@[%s, %s](%d,%d)}", new Object[]{Arrays.toString(this.Uf), Long.valueOf(this.Ue), Long.valueOf(this.Ud), Integer.valueOf(this.UJ), Integer.valueOf(this.UK)});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        n.a(this, parcel, flags);
    }
}
