package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SessionReadRequest implements SafeParcelable {
    public static final Creator<SessionReadRequest> CREATOR = new t();
    private final int CK;
    private final long LW;
    private final long TO;
    private final List<DataType> TY;
    private final List<DataSource> VH;
    private final boolean VR;
    private final String Wj;
    private boolean Wk;
    private final List<String> Wl;
    private final String vZ;

    public static class Builder {
        private long LW = 0;
        private long TO = 0;
        private List<DataType> TY = new ArrayList();
        private List<DataSource> VH = new ArrayList();
        private boolean VR = false;
        private String Wj;
        private boolean Wk = false;
        private List<String> Wl = new ArrayList();
        private String vZ;

        public SessionReadRequest build() {
            jx.b(this.LW > 0, "Invalid start time: %s", Long.valueOf(this.LW));
            boolean z = this.TO > 0 && this.TO > this.LW;
            jx.b(z, "Invalid end time: %s", Long.valueOf(this.TO));
            return new SessionReadRequest();
        }

        public Builder enableServerQueries() {
            this.VR = true;
            return this;
        }

        public Builder excludePackage(String appPackageName) {
            jx.b((Object) appPackageName, (Object) "Attempting to use a null package name");
            if (!this.Wl.contains(appPackageName)) {
                this.Wl.add(appPackageName);
            }
            return this;
        }

        public Builder read(DataSource dataSource) {
            jx.b((Object) dataSource, (Object) "Attempting to add a null data source");
            if (!this.VH.contains(dataSource)) {
                this.VH.add(dataSource);
            }
            return this;
        }

        public Builder read(DataType dataType) {
            jx.b((Object) dataType, (Object) "Attempting to use a null data type");
            if (!this.TY.contains(dataType)) {
                this.TY.add(dataType);
            }
            return this;
        }

        public Builder readSessionsFromAllApps() {
            this.Wk = true;
            return this;
        }

        public Builder setSessionId(String sessionId) {
            this.vZ = sessionId;
            return this;
        }

        public Builder setSessionName(String sessionName) {
            this.Wj = sessionName;
            return this;
        }

        public Builder setTimeInterval(long startTime, long endTime, TimeUnit timeUnit) {
            this.LW = timeUnit.toMillis(startTime);
            this.TO = timeUnit.toMillis(endTime);
            return this;
        }
    }

    SessionReadRequest(int versionCode, String sessionName, String sessionId, long startTimeMillis, long endTimeMillis, List<DataType> dataTypes, List<DataSource> dataSources, boolean getSessionsFromAllApps, boolean serverQueriesEnabled, List<String> excludedPackages) {
        this.CK = versionCode;
        this.Wj = sessionName;
        this.vZ = sessionId;
        this.LW = startTimeMillis;
        this.TO = endTimeMillis;
        this.TY = Collections.unmodifiableList(dataTypes);
        this.VH = Collections.unmodifiableList(dataSources);
        this.Wk = getSessionsFromAllApps;
        this.VR = serverQueriesEnabled;
        this.Wl = excludedPackages;
    }

    private SessionReadRequest(Builder builder) {
        this.CK = 3;
        this.Wj = builder.Wj;
        this.vZ = builder.vZ;
        this.LW = builder.LW;
        this.TO = builder.TO;
        this.TY = Collections.unmodifiableList(builder.TY);
        this.VH = Collections.unmodifiableList(builder.VH);
        this.Wk = builder.Wk;
        this.VR = builder.VR;
        this.Wl = Collections.unmodifiableList(builder.Wl);
    }

    private boolean a(SessionReadRequest sessionReadRequest) {
        return jv.equal(this.Wj, sessionReadRequest.Wj) && this.vZ.equals(sessionReadRequest.vZ) && this.LW == sessionReadRequest.LW && this.TO == sessionReadRequest.TO && jv.equal(this.TY, sessionReadRequest.TY) && jv.equal(this.VH, sessionReadRequest.VH) && this.Wk == sessionReadRequest.Wk && this.Wl.equals(sessionReadRequest.Wl) && this.VR == sessionReadRequest.VR;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof SessionReadRequest) && a((SessionReadRequest) o));
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

    public List<String> getExcludedPackages() {
        return this.Wl;
    }

    public String getSessionId() {
        return this.vZ;
    }

    public String getSessionName() {
        return this.Wj;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.LW, TimeUnit.MILLISECONDS);
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(this.Wj, this.vZ, Long.valueOf(this.LW), Long.valueOf(this.TO));
    }

    public boolean includeSessionsFromAllApps() {
        return this.Wk;
    }

    public boolean jV() {
        return this.VR;
    }

    public long jo() {
        return this.LW;
    }

    public long jp() {
        return this.TO;
    }

    public boolean kj() {
        return this.Wk;
    }

    public String toString() {
        return jv.h(this).a("sessionName", this.Wj).a("sessionId", this.vZ).a("startTimeMillis", Long.valueOf(this.LW)).a("endTimeMillis", Long.valueOf(this.TO)).a("dataTypes", this.TY).a("dataSources", this.VH).a("sessionsFromAllApps", Boolean.valueOf(this.Wk)).a("excludedPackages", this.Wl).a("useServer", Boolean.valueOf(this.VR)).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        t.a(this, dest, flags);
    }
}
