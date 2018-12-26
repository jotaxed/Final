package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataReadRequest implements SafeParcelable {
    public static final Creator<DataReadRequest> CREATOR = new g();
    public static final int NO_LIMIT = 0;
    private final int CK;
    private final long LW;
    private final long TO;
    private final List<DataType> TY;
    private final int Ub;
    private final List<DataSource> VH;
    private final List<DataType> VL;
    private final List<DataSource> VM;
    private final long VN;
    private final DataSource VO;
    private final int VP;
    private final boolean VQ;
    private final boolean VR;

    public static class Builder {
        private long LW;
        private long TO;
        private List<DataType> TY = new ArrayList();
        private int Ub = 0;
        private List<DataSource> VH = new ArrayList();
        private List<DataType> VL = new ArrayList();
        private List<DataSource> VM = new ArrayList();
        private long VN = 0;
        private DataSource VO;
        private int VP = 0;
        private boolean VQ = false;
        private boolean VR = false;

        public Builder aggregate(DataSource dataSource, DataType outputDataType) {
            jx.b((Object) dataSource, (Object) "Attempting to add a null data source");
            jx.a(!this.VH.contains(dataSource), "Cannot add the same data source for aggregated and detailed");
            DataType dataType = dataSource.getDataType();
            jx.b(DataType.AGGREGATE_INPUT_TYPES.contains(dataType), "Unsupported input data type specified for aggregation: %s", dataType);
            jx.b(DataType.getAggregatesForInput(dataType).contains(outputDataType), "Invalid output aggregate data type specified: %s -> %s", dataType, outputDataType);
            if (!this.VM.contains(dataSource)) {
                this.VM.add(dataSource);
            }
            return this;
        }

        public Builder aggregate(DataType inputDataType, DataType outputDataType) {
            jx.b((Object) inputDataType, (Object) "Attempting to use a null data type");
            jx.a(!this.TY.contains(inputDataType), "Cannot add the same data type as aggregated and detailed");
            jx.b(DataType.AGGREGATE_INPUT_TYPES.contains(inputDataType), "Unsupported input data type specified for aggregation: %s", inputDataType);
            jx.b(DataType.getAggregatesForInput(inputDataType).contains(outputDataType), "Invalid output aggregate data type specified: %s -> %s", inputDataType, outputDataType);
            if (!this.VL.contains(inputDataType)) {
                this.VL.add(inputDataType);
            }
            return this;
        }

        public Builder bucketByActivitySegment(int minDuration, TimeUnit timeUnit) {
            jx.b(this.Ub == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.Ub));
            jx.b(minDuration > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(minDuration));
            this.Ub = 4;
            this.VN = timeUnit.toMillis((long) minDuration);
            return this;
        }

        public Builder bucketByActivitySegment(int minDuration, TimeUnit timeUnit, DataSource activityDataSource) {
            jx.b(this.Ub == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.Ub));
            jx.b(minDuration > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(minDuration));
            jx.b(activityDataSource != null, (Object) "Invalid activity data source specified");
            jx.b(activityDataSource.getDataType().equals(DataType.TYPE_ACTIVITY_SEGMENT), "Invalid activity data source specified: %s", activityDataSource);
            this.VO = activityDataSource;
            this.Ub = 4;
            this.VN = timeUnit.toMillis((long) minDuration);
            return this;
        }

        public Builder bucketByActivityType(int minDuration, TimeUnit timeUnit) {
            jx.b(this.Ub == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.Ub));
            jx.b(minDuration > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(minDuration));
            this.Ub = 3;
            this.VN = timeUnit.toMillis((long) minDuration);
            return this;
        }

        public Builder bucketByActivityType(int minDuration, TimeUnit timeUnit, DataSource activityDataSource) {
            jx.b(this.Ub == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.Ub));
            jx.b(minDuration > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(minDuration));
            jx.b(activityDataSource != null, (Object) "Invalid activity data source specified");
            jx.b(activityDataSource.getDataType().equals(DataType.TYPE_ACTIVITY_SEGMENT), "Invalid activity data source specified: %s", activityDataSource);
            this.VO = activityDataSource;
            this.Ub = 3;
            this.VN = timeUnit.toMillis((long) minDuration);
            return this;
        }

        public Builder bucketBySession(int minDuration, TimeUnit timeUnit) {
            jx.b(this.Ub == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.Ub));
            jx.b(minDuration > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(minDuration));
            this.Ub = 2;
            this.VN = timeUnit.toMillis((long) minDuration);
            return this;
        }

        public Builder bucketByTime(int duration, TimeUnit timeUnit) {
            jx.b(this.Ub == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.Ub));
            jx.b(duration > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(duration));
            this.Ub = 1;
            this.VN = timeUnit.toMillis((long) duration);
            return this;
        }

        public DataReadRequest build() {
            boolean z = true;
            boolean z2 = (this.VH.isEmpty() && this.TY.isEmpty() && this.VM.isEmpty() && this.VL.isEmpty()) ? false : true;
            jx.a(z2, "Must add at least one data source (aggregated or detailed)");
            jx.a(this.LW > 0, "Invalid start time: %s", Long.valueOf(this.LW));
            z2 = this.TO > 0 && this.TO > this.LW;
            jx.a(z2, "Invalid end time: %s", Long.valueOf(this.TO));
            z2 = this.VM.isEmpty() && this.VL.isEmpty();
            if (!(z2 && this.Ub == 0) && (z2 || this.Ub == 0)) {
                z = false;
            }
            jx.a(z, "Must specify a valid bucketing strategy while requesting aggregation");
            return new DataReadRequest();
        }

        public Builder enableServerQueries() {
            this.VR = true;
            return this;
        }

        public Builder read(DataSource dataSource) {
            jx.b((Object) dataSource, (Object) "Attempting to add a null data source");
            jx.b(!this.VM.contains(dataSource), (Object) "Cannot add the same data source as aggregated and detailed");
            if (!this.VH.contains(dataSource)) {
                this.VH.add(dataSource);
            }
            return this;
        }

        public Builder read(DataType dataType) {
            jx.b((Object) dataType, (Object) "Attempting to use a null data type");
            jx.a(!this.VL.contains(dataType), "Cannot add the same data type as aggregated and detailed");
            if (!this.TY.contains(dataType)) {
                this.TY.add(dataType);
            }
            return this;
        }

        public Builder setLimit(int limit) {
            jx.b(limit > 0, "Invalid limit %d is specified", Integer.valueOf(limit));
            this.VP = limit;
            return this;
        }

        public Builder setTimeRange(long start, long end, TimeUnit timeUnit) {
            this.LW = timeUnit.toMillis(start);
            this.TO = timeUnit.toMillis(end);
            return this;
        }
    }

    DataReadRequest(int versionCode, List<DataType> dataTypes, List<DataSource> dataSources, long startTimeMillis, long endTimeMillis, List<DataType> aggregatedDataTypes, List<DataSource> aggregatedDataSources, int bucketType, long bucketDurationMillis, DataSource activityDataSource, int limit, boolean flushBeforeRead, boolean serverQueriesEnabled) {
        this.CK = versionCode;
        this.TY = Collections.unmodifiableList(dataTypes);
        this.VH = Collections.unmodifiableList(dataSources);
        this.LW = startTimeMillis;
        this.TO = endTimeMillis;
        this.VL = Collections.unmodifiableList(aggregatedDataTypes);
        this.VM = Collections.unmodifiableList(aggregatedDataSources);
        this.Ub = bucketType;
        this.VN = bucketDurationMillis;
        this.VO = activityDataSource;
        this.VP = limit;
        this.VQ = flushBeforeRead;
        this.VR = serverQueriesEnabled;
    }

    private DataReadRequest(Builder builder) {
        this.CK = 2;
        this.TY = Collections.unmodifiableList(builder.TY);
        this.VH = Collections.unmodifiableList(builder.VH);
        this.LW = builder.LW;
        this.TO = builder.TO;
        this.VL = Collections.unmodifiableList(builder.VL);
        this.VM = Collections.unmodifiableList(builder.VM);
        this.Ub = builder.Ub;
        this.VN = builder.VN;
        this.VO = builder.VO;
        this.VP = builder.VP;
        this.VQ = builder.VQ;
        this.VR = builder.VR;
    }

    private boolean a(DataReadRequest dataReadRequest) {
        return this.TY.equals(dataReadRequest.TY) && this.VH.equals(dataReadRequest.VH) && this.LW == dataReadRequest.LW && this.TO == dataReadRequest.TO && this.Ub == dataReadRequest.Ub && this.VM.equals(dataReadRequest.VM) && this.VL.equals(dataReadRequest.VL) && jv.equal(this.VO, dataReadRequest.VO) && this.VN == dataReadRequest.VN && this.VR == dataReadRequest.VR;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof DataReadRequest) && a((DataReadRequest) that));
    }

    public DataSource getActivityDataSource() {
        return this.VO;
    }

    public List<DataSource> getAggregatedDataSources() {
        return this.VM;
    }

    public List<DataType> getAggregatedDataTypes() {
        return this.VL;
    }

    public long getBucketDuration(TimeUnit timeUnit) {
        return timeUnit.convert(this.VN, TimeUnit.MILLISECONDS);
    }

    public int getBucketType() {
        return this.Ub;
    }

    public List<DataSource> getDataSources() {
        return this.VH;
    }

    public List<DataType> getDataTypes() {
        return this.TY;
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.TO, TimeUnit.MILLISECONDS);
    }

    public int getLimit() {
        return this.VP;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.LW, TimeUnit.MILLISECONDS);
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(Integer.valueOf(this.Ub), Long.valueOf(this.LW), Long.valueOf(this.TO));
    }

    public boolean jV() {
        return this.VR;
    }

    public boolean jW() {
        return this.VQ;
    }

    public long jX() {
        return this.VN;
    }

    public long jo() {
        return this.LW;
    }

    public long jp() {
        return this.TO;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DataReadRequest{");
        if (!this.TY.isEmpty()) {
            for (DataType jB : this.TY) {
                stringBuilder.append(jB.jB()).append(" ");
            }
        }
        if (!this.VH.isEmpty()) {
            for (DataSource toDebugString : this.VH) {
                stringBuilder.append(toDebugString.toDebugString()).append(" ");
            }
        }
        if (this.Ub != 0) {
            stringBuilder.append("bucket by ").append(Bucket.cJ(this.Ub));
            if (this.VN > 0) {
                stringBuilder.append(" >").append(this.VN).append("ms");
            }
            stringBuilder.append(": ");
        }
        if (!this.VL.isEmpty()) {
            for (DataType jB2 : this.VL) {
                stringBuilder.append(jB2.jB()).append(" ");
            }
        }
        if (!this.VM.isEmpty()) {
            for (DataSource toDebugString2 : this.VM) {
                stringBuilder.append(toDebugString2.toDebugString()).append(" ");
            }
        }
        stringBuilder.append(String.format("(%tF %tT - %tF %tT)", new Object[]{Long.valueOf(this.LW), Long.valueOf(this.LW), Long.valueOf(this.TO), Long.valueOf(this.TO)}));
        if (this.VO != null) {
            stringBuilder.append("activities: ").append(this.VO.toDebugString());
        }
        if (this.VR) {
            stringBuilder.append(" +server");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        g.a(this, dest, flags);
    }
}
