package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;

public class e implements SafeParcelable {
    public static final Creator<e> CREATOR = new f();
    private final int CK;
    private final DataSet UP;

    public static class a {
        private DataSet UP;

        public a b(DataSet dataSet) {
            this.UP = dataSet;
            return this;
        }

        public e jU() {
            boolean z = true;
            jx.a(this.UP != null, "Must set the data set");
            jx.a(!this.UP.getDataPoints().isEmpty(), "Cannot use an empty data set");
            if (this.UP.getDataSource().jx() == null) {
                z = false;
            }
            jx.a(z, "Must set the app package name for the data source");
            return new e();
        }
    }

    e(int i, DataSet dataSet) {
        this.CK = i;
        this.UP = dataSet;
    }

    private e(a aVar) {
        this.CK = 1;
        this.UP = aVar.UP;
    }

    private boolean a(e eVar) {
        return jv.equal(this.UP, eVar.UP);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof e) && a((e) o));
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(this.UP);
    }

    public DataSet jH() {
        return this.UP;
    }

    public String toString() {
        return jv.h(this).a("dataSet", this.UP).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        f.a(this, dest, flags);
    }
}
