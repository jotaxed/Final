package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.q;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SessionReadResult implements Result, SafeParcelable {
    public static final Creator<SessionReadResult> CREATOR = new f();
    private final int CK;
    private final Status Eb;
    private final List<Session> VI;
    private final List<q> Wv;

    SessionReadResult(int versionCode, List<Session> sessions, List<q> sessionDataSets, Status status) {
        this.CK = versionCode;
        this.VI = sessions;
        this.Wv = Collections.unmodifiableList(sessionDataSets);
        this.Eb = status;
    }

    public SessionReadResult(List<Session> sessions, List<q> sessionDataSets, Status status) {
        this.CK = 3;
        this.VI = sessions;
        this.Wv = Collections.unmodifiableList(sessionDataSets);
        this.Eb = status;
    }

    public static SessionReadResult G(Status status) {
        return new SessionReadResult(new ArrayList(), new ArrayList(), status);
    }

    private boolean b(SessionReadResult sessionReadResult) {
        return this.Eb.equals(sessionReadResult.Eb) && jv.equal(this.VI, sessionReadResult.VI) && jv.equal(this.Wv, sessionReadResult.Wv);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof SessionReadResult) && b((SessionReadResult) that));
    }

    public List<DataSet> getDataSet(Session session) {
        jx.b(this.VI.contains(session), "Attempting to read data for session %s which was not returned", session);
        List<DataSet> arrayList = new ArrayList();
        for (q qVar : this.Wv) {
            if (jv.equal(session, qVar.getSession())) {
                arrayList.add(qVar.jH());
            }
        }
        return arrayList;
    }

    public List<DataSet> getDataSet(Session session, DataType dataType) {
        jx.b(this.VI.contains(session), "Attempting to read data for session %s which was not returned", session);
        List<DataSet> arrayList = new ArrayList();
        for (q qVar : this.Wv) {
            if (jv.equal(session, qVar.getSession()) && dataType.equals(qVar.jH().getDataType())) {
                arrayList.add(qVar.jH());
            }
        }
        return arrayList;
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
        return jv.hashCode(this.Eb, this.VI, this.Wv);
    }

    public List<q> kv() {
        return this.Wv;
    }

    public String toString() {
        return jv.h(this).a("status", this.Eb).a("sessions", this.VI).a("sessionDataSets", this.Wv).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        f.a(this, dest, flags);
    }
}
