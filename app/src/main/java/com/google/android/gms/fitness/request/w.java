package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import java.util.concurrent.TimeUnit;

public class w implements SafeParcelable {
    public static final Creator<w> CREATOR = new x();
    private final int CK;
    private final Session TQ;

    public static class a {
        private Session TQ;

        public a b(Session session) {
            jx.b(session.getEndTime(TimeUnit.MILLISECONDS) == 0, (Object) "Cannot start a session which has already ended");
            this.TQ = session;
            return this;
        }

        public w kk() {
            return new w();
        }
    }

    w(int i, Session session) {
        this.CK = i;
        this.TQ = session;
    }

    private w(a aVar) {
        this.CK = 1;
        this.TQ = aVar.TQ;
    }

    private boolean a(w wVar) {
        return jv.equal(this.TQ, wVar.TQ);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof w) && a((w) o));
    }

    public Session getSession() {
        return this.TQ;
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(this.TQ);
    }

    public String toString() {
        return jv.h(this).a("session", this.TQ).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        x.a(this, dest, flags);
    }
}
