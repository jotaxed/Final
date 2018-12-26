package com.google.android.gms.fitness.request;

import android.os.SystemClock;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import com.google.android.gms.location.LocationRequest;
import java.util.concurrent.TimeUnit;

public class SensorRequest {
    public static final int ACCURACY_MODE_DEFAULT = 2;
    public static final int ACCURACY_MODE_HIGH = 3;
    public static final int ACCURACY_MODE_LOW = 1;
    private final DataType TM;
    private final DataSource TN;
    private final long UQ;
    private final int UR;
    private final long VZ;
    private final long Wa;
    private final LocationRequest We;
    private final long Wf;

    public static class Builder {
        private DataType TM;
        private DataSource TN;
        private long UQ = -1;
        private int UR = 2;
        private long VZ = 0;
        private long Wa = 0;
        private long Wf = Long.MAX_VALUE;
        private boolean Wg = false;

        public SensorRequest build() {
            boolean z = false;
            boolean z2 = (this.TN == null && this.TM == null) ? false : true;
            jx.a(z2, "Must call setDataSource() or setDataType()");
            if (this.TM == null || this.TN == null || this.TM.equals(this.TN.getDataType())) {
                z = true;
            }
            jx.a(z, "Specified data type is incompatible with specified data source");
            return new SensorRequest();
        }

        public Builder setAccuracyMode(int accuracyMode) {
            this.UR = SensorRequest.dl(accuracyMode);
            return this;
        }

        public Builder setDataSource(DataSource dataSource) {
            this.TN = dataSource;
            return this;
        }

        public Builder setDataType(DataType dataType) {
            this.TM = dataType;
            return this;
        }

        public Builder setFastestRate(int fastestInterval, TimeUnit unit) {
            jx.b(fastestInterval >= 0, (Object) "Cannot use a negative interval");
            this.Wg = true;
            this.Wa = unit.toMicros((long) fastestInterval);
            return this;
        }

        public Builder setMaxDeliveryLatency(int interval, TimeUnit unit) {
            jx.b(interval >= 0, (Object) "Cannot use a negative delivery interval");
            this.VZ = unit.toMicros((long) interval);
            return this;
        }

        public Builder setSamplingRate(long interval, TimeUnit unit) {
            jx.b(interval >= 0, (Object) "Cannot use a negative sampling interval");
            this.UQ = unit.toMicros(interval);
            if (!this.Wg) {
                this.Wa = this.UQ / 2;
            }
            return this;
        }

        public Builder setTimeout(long timeout, TimeUnit timeUnit) {
            boolean z = true;
            jx.b(timeout > 0, "Invalid time out value specified: %d", Long.valueOf(timeout));
            if (timeUnit == null) {
                z = false;
            }
            jx.b(z, (Object) "Invalid time unit specified");
            this.Wf = timeUnit.toMicros(timeout);
            return this;
        }
    }

    private SensorRequest(DataSource dataSource, LocationRequest locationRequest) {
        this.We = locationRequest;
        this.UQ = TimeUnit.MILLISECONDS.toMicros(locationRequest.getInterval());
        this.Wa = TimeUnit.MILLISECONDS.toMicros(locationRequest.getFastestInterval());
        this.VZ = this.UQ;
        this.TM = dataSource.getDataType();
        this.UR = a(locationRequest);
        this.TN = dataSource;
        long expirationTime = locationRequest.getExpirationTime();
        if (expirationTime == Long.MAX_VALUE) {
            this.Wf = Long.MAX_VALUE;
        } else {
            this.Wf = TimeUnit.MILLISECONDS.toMicros(expirationTime - SystemClock.elapsedRealtime());
        }
    }

    private SensorRequest(Builder builder) {
        this.TN = builder.TN;
        this.TM = builder.TM;
        this.UQ = builder.UQ;
        this.Wa = builder.Wa;
        this.VZ = builder.VZ;
        this.UR = builder.UR;
        this.We = null;
        this.Wf = builder.Wf;
    }

    private static int a(LocationRequest locationRequest) {
        switch (locationRequest.getPriority()) {
            case 100:
                return 3;
            case LocationRequest.PRIORITY_LOW_POWER /*104*/:
                return 1;
            default:
                return 2;
        }
    }

    private boolean a(SensorRequest sensorRequest) {
        return jv.equal(this.TN, sensorRequest.TN) && jv.equal(this.TM, sensorRequest.TM) && this.UQ == sensorRequest.UQ && this.Wa == sensorRequest.Wa && this.VZ == sensorRequest.VZ && this.UR == sensorRequest.UR && jv.equal(this.We, sensorRequest.We) && this.Wf == sensorRequest.Wf;
    }

    public static int dl(int i) {
        switch (i) {
            case 1:
            case 3:
                return i;
            default:
                return 2;
        }
    }

    public static SensorRequest fromLocationRequest(DataSource dataSource, LocationRequest locationRequest) {
        return new SensorRequest(dataSource, locationRequest);
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof SensorRequest) && a((SensorRequest) that));
    }

    public int getAccuracyMode() {
        return this.UR;
    }

    public DataSource getDataSource() {
        return this.TN;
    }

    public DataType getDataType() {
        return this.TM;
    }

    public long getFastestRate(TimeUnit timeUnit) {
        return timeUnit.convert(this.Wa, TimeUnit.MICROSECONDS);
    }

    public long getMaxDeliveryLatency(TimeUnit timeUnit) {
        return timeUnit.convert(this.VZ, TimeUnit.MICROSECONDS);
    }

    public long getSamplingRate(TimeUnit timeUnit) {
        return timeUnit.convert(this.UQ, TimeUnit.MICROSECONDS);
    }

    public int hashCode() {
        return jv.hashCode(this.TN, this.TM, Long.valueOf(this.UQ), Long.valueOf(this.Wa), Long.valueOf(this.VZ), Integer.valueOf(this.UR), this.We, Long.valueOf(this.Wf));
    }

    public long kh() {
        return this.Wf;
    }

    public String toString() {
        return jv.h(this).a("dataSource", this.TN).a("dataType", this.TM).a("samplingRateMicros", Long.valueOf(this.UQ)).a("deliveryLatencyMicros", Long.valueOf(this.VZ)).a("timeOutMicros", Long.valueOf(this.Wf)).toString();
    }
}
