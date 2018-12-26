package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.jv;
import java.util.Collections;
import java.util.List;

public class SessionStopResult implements Result, SafeParcelable {
    public static final Creator<SessionStopResult> CREATOR = new g();
    private final int CK;
    private final Status Eb;
    private final List<Session> VI;

    SessionStopResult(int versionCode, Status status, List<Session> sessions) {
        this.CK = versionCode;
        this.Eb = status;
        this.VI = Collections.unmodifiableList(sessions);
    }

    public SessionStopResult(Status status, List<Session> sessions) {
        this.CK = 3;
        this.Eb = status;
        this.VI = Collections.unmodifiableList(sessions);
    }

    public static SessionStopResult H(Status status) {
        return new SessionStopResult(status, Collections.emptyList());
    }

    private boolean b(SessionStopResult sessionStopResult) {
        return this.Eb.equals(sessionStopResult.Eb) && jv.equal(this.VI, sessionStopResult.VI);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof SessionStopResult) && b((SessionStopResult) o));
    }

    public List<Session> getSessions() {
        return this.VI;
    }

    public Status getStatus() {
        return this.Eb;
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(this.Eb, this.VI);
    }

    public String toString() {
        return jv.h(this).a("status", this.Eb).a("sessions", this.VI).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        g.a(this, dest, flags);
    }
}
