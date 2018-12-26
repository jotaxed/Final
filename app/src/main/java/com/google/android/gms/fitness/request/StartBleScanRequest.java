package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.a.a;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.la;
import java.util.Collections;
import java.util.List;

public class StartBleScanRequest implements SafeParcelable {
    public static final Creator<StartBleScanRequest> CREATOR = new ac();
    private final int CK;
    private final List<DataType> TY;
    private final l Wm;
    private final int Wn;

    public static class Builder {
        private DataType[] VU = new DataType[0];
        private l Wm;
        private int Wn = 10;

        public Builder a(l lVar) {
            this.Wm = lVar;
            return this;
        }

        public StartBleScanRequest build() {
            jx.a(this.Wm != null, "Must set BleScanCallback");
            return new StartBleScanRequest();
        }

        public Builder setBleScanCallback(BleScanCallback bleScanCallback) {
            a(a.jP().a(bleScanCallback));
            return this;
        }

        public Builder setDataTypes(DataType... dataTypes) {
            this.VU = dataTypes;
            return this;
        }

        public Builder setTimeoutSecs(int stopTimeSecs) {
            boolean z = true;
            jx.b(stopTimeSecs > 0, (Object) "Stop time must be greater than zero");
            if (stopTimeSecs > 60) {
                z = false;
            }
            jx.b(z, (Object) "Stop time must be less than 1 minute");
            this.Wn = stopTimeSecs;
            return this;
        }
    }

    StartBleScanRequest(int versionCode, List<DataType> dataTypes, IBinder bleScanCallback, int timeoutSecs) {
        this.CK = versionCode;
        this.TY = dataTypes;
        this.Wm = l.a.aB(bleScanCallback);
        this.Wn = timeoutSecs;
    }

    private StartBleScanRequest(Builder builder) {
        this.CK = 2;
        this.TY = la.b(builder.VU);
        this.Wm = builder.Wm;
        this.Wn = builder.Wn;
    }

    public int describeContents() {
        return 0;
    }

    public List<DataType> getDataTypes() {
        return Collections.unmodifiableList(this.TY);
    }

    public int getTimeoutSecs() {
        return this.Wn;
    }

    int getVersionCode() {
        return this.CK;
    }

    public IBinder km() {
        return this.Wm.asBinder();
    }

    public String toString() {
        return jv.h(this).a("dataTypes", this.TY).a("timeoutSecs", Integer.valueOf(this.Wn)).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        ac.a(this, parcel, flags);
    }
}
