package com.google.android.gms.fitness.service;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.k;
import com.google.android.gms.fitness.data.k.a;
import com.google.android.gms.internal.jv;
import java.util.concurrent.TimeUnit;

public class FitnessSensorServiceRequest implements SafeParcelable {
    public static final Creator<FitnessSensorServiceRequest> CREATOR = new a();
    public static final int UNSPECIFIED = -1;
    private final int CK;
    private final DataSource TN;
    private final k VW;
    private final long Wy;
    private final long Wz;

    FitnessSensorServiceRequest(int versionCode, DataSource dataSource, IBinder listenerBinder, long samplingRateMicros, long batchIntervalMicros) {
        this.CK = versionCode;
        this.TN = dataSource;
        this.VW = a.aq(listenerBinder);
        this.Wy = samplingRateMicros;
        this.Wz = batchIntervalMicros;
    }

    private boolean a(FitnessSensorServiceRequest fitnessSensorServiceRequest) {
        return jv.equal(this.TN, fitnessSensorServiceRequest.TN) && this.Wy == fitnessSensorServiceRequest.Wy && this.Wz == fitnessSensorServiceRequest.Wz;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof FitnessSensorServiceRequest) && a((FitnessSensorServiceRequest) that));
    }

    public long getBatchInterval(TimeUnit timeUnit) {
        return timeUnit.convert(this.Wz, TimeUnit.MICROSECONDS);
    }

    public DataSource getDataSource() {
        return this.TN;
    }

    public SensorEventDispatcher getDispatcher() {
        return new b(this.VW);
    }

    public long getSamplingRate(TimeUnit timeUnit) {
        return this.Wy == -1 ? -1 : timeUnit.convert(this.Wy, TimeUnit.MICROSECONDS);
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(this.TN, Long.valueOf(this.Wy), Long.valueOf(this.Wz));
    }

    public long jI() {
        return this.Wy;
    }

    IBinder kg() {
        return this.VW.asBinder();
    }

    public long kx() {
        return this.Wz;
    }

    public String toString() {
        return String.format("FitnessSensorServiceRequest{%s}", new Object[]{this.TN});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        a.a(this, parcel, flags);
    }
}
