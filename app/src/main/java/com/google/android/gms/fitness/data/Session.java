package com.google.android.gms.fitness.data;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import com.google.android.gms.plus.PlusShare;
import java.util.concurrent.TimeUnit;

public class Session implements SafeParcelable {
    public static final Creator<Session> CREATOR = new p();
    public static final String EXTRA_SESSION = "vnd.google.fitness.session";
    public static final String MIME_TYPE_PREFIX = "vnd.google.fitness.session/";
    private final int CK;
    private final long LW;
    private final long TO;
    private final int TZ;
    private final String UN;
    private final String UO;
    private final a Um;
    private final String mName;

    public static class Builder {
        private long LW = 0;
        private long TO = 0;
        private int TZ = 4;
        private String UN;
        private String UO;
        private a Um;
        private String mName = null;

        public Session build() {
            boolean z = false;
            jx.a(this.LW > 0, "Start time should be specified.");
            if (this.TO == 0 || this.TO > this.LW) {
                z = true;
            }
            jx.a(z, "End time should be later than start time.");
            if (this.UN == null) {
                this.UN = (this.mName == null ? "" : this.mName) + this.LW;
            }
            return new Session();
        }

        public Builder cV(int i) {
            this.TZ = i;
            return this;
        }

        public Builder setActivity(String activity) {
            return cV(FitnessActivities.bs(activity));
        }

        public Builder setDescription(String description) {
            jx.b(description.length() <= 1000, "Session description cannot exceed %d characters", Integer.valueOf(1000));
            this.UO = description;
            return this;
        }

        public Builder setEndTime(long time, TimeUnit timeUnit) {
            jx.a(time >= 0, "End time should be positive.");
            this.TO = timeUnit.toMillis(time);
            return this;
        }

        public Builder setIdentifier(String identifier) {
            boolean z = identifier != null && TextUtils.getTrimmedLength(identifier) > 0;
            jx.L(z);
            this.UN = identifier;
            return this;
        }

        public Builder setName(String name) {
            jx.b(name.length() <= 100, "Session name cannot exceed %d characters", Integer.valueOf(100));
            this.mName = name;
            return this;
        }

        public Builder setStartTime(long time, TimeUnit timeUnit) {
            jx.a(time > 0, "Start time should be positive.");
            this.LW = timeUnit.toMillis(time);
            return this;
        }
    }

    Session(int versionCode, long startTimeMillis, long endTimeMillis, String name, String identifier, String description, int activityType, a application) {
        this.CK = versionCode;
        this.LW = startTimeMillis;
        this.TO = endTimeMillis;
        this.mName = name;
        this.UN = identifier;
        this.UO = description;
        this.TZ = activityType;
        this.Um = application;
    }

    private Session(Builder builder) {
        this.CK = 2;
        this.LW = builder.LW;
        this.TO = builder.TO;
        this.mName = builder.mName;
        this.UN = builder.UN;
        this.UO = builder.UO;
        this.TZ = builder.TZ;
        this.Um = builder.Um;
    }

    private boolean a(Session session) {
        return this.LW == session.LW && this.TO == session.TO && jv.equal(this.mName, session.mName) && jv.equal(this.UN, session.UN) && jv.equal(this.UO, session.UO) && jv.equal(this.Um, session.Um) && this.TZ == session.TZ;
    }

    public static Session extract(Intent intent) {
        return intent == null ? null : (Session) c.a(intent, EXTRA_SESSION, CREATOR);
    }

    public static String getMimeType(String activity) {
        return MIME_TYPE_PREFIX + activity;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof Session) && a((Session) o));
    }

    public String getActivity() {
        return FitnessActivities.getName(this.TZ);
    }

    public String getAppPackageName() {
        return this.Um == null ? null : this.Um.getPackageName();
    }

    public String getDescription() {
        return this.UO;
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.TO, TimeUnit.MILLISECONDS);
    }

    public String getIdentifier() {
        return this.UN;
    }

    public String getName() {
        return this.mName;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.LW, TimeUnit.MILLISECONDS);
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(Long.valueOf(this.LW), Long.valueOf(this.TO), this.UN);
    }

    public boolean isOngoing() {
        return this.TO == 0;
    }

    public int jm() {
        return this.TZ;
    }

    public long jo() {
        return this.LW;
    }

    public long jp() {
        return this.TO;
    }

    public a jx() {
        return this.Um;
    }

    public String toString() {
        return jv.h(this).a("startTime", Long.valueOf(this.LW)).a("endTime", Long.valueOf(this.TO)).a("name", this.mName).a("identifier", this.UN).a(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, this.UO).a("activity", Integer.valueOf(this.TZ)).a("application", this.Um).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        p.a(this, dest, flags);
    }
}
