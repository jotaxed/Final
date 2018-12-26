package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;

public class q implements SafeParcelable {
    public static final Creator<q> CREATOR = new r();
    final int CK;
    private final Session TQ;
    private final DataSet UP;

    q(int i, Session session, DataSet dataSet) {
        this.CK = i;
        this.TQ = session;
        this.UP = dataSet;
    }

    private boolean a(q qVar) {
        return jv.equal(this.TQ, qVar.TQ) && jv.equal(this.UP, qVar.UP);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof q) && a((q) o));
    }

    public Session getSession() {
        return this.TQ;
    }

    public int hashCode() {
        return jv.hashCode(this.TQ, this.UP);
    }

    public DataSet jH() {
        return this.UP;
    }

    public String toString() {
        return jv.h(this).a("session", this.TQ).a("dataSet", this.UP).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        r.a(this, dest, flags);
    }
}
