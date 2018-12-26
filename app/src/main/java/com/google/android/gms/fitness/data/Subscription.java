package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;

public class Subscription implements SafeParcelable {
    public static final Creator<Subscription> CREATOR = new s();
    private final int CK;
    private final DataType TM;
    private final DataSource TN;
    private final long UQ;
    private final int UR;

    public static class a {
        private DataType TM;
        private DataSource TN;
        private long UQ = -1;
        private int UR = 2;

        public a b(DataSource dataSource) {
            this.TN = dataSource;
            return this;
        }

        public a b(DataType dataType) {
            this.TM = dataType;
            return this;
        }

        public Subscription jK() {
            boolean z = false;
            boolean z2 = (this.TN == null && this.TM == null) ? false : true;
            jx.a(z2, "Must call setDataSource() or setDataType()");
            if (this.TM == null || this.TN == null || this.TM.equals(this.TN.getDataType())) {
                z = true;
            }
            jx.a(z, "Specified data type is incompatible with specified data source");
            return new Subscription();
        }
    }

    Subscription(int versionCode, DataSource dataSource, DataType dataType, long samplingIntervalMicros, int accuracyMode) {
        this.CK = versionCode;
        this.TN = dataSource;
        this.TM = dataType;
        this.UQ = samplingIntervalMicros;
        this.UR = accuracyMode;
    }

    private Subscription(a builder) {
        this.CK = 1;
        this.TM = builder.TM;
        this.TN = builder.TN;
        this.UQ = builder.UQ;
        this.UR = builder.UR;
    }

    private boolean a(Subscription subscription) {
        return jv.equal(this.TN, subscription.TN) && jv.equal(this.TM, subscription.TM) && this.UQ == subscription.UQ && this.UR == subscription.UR;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof Subscription) && a((Subscription) that));
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

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(this.TN, this.TN, Long.valueOf(this.UQ), Integer.valueOf(this.UR));
    }

    public long jI() {
        return this.UQ;
    }

    public DataType jJ() {
        return this.TM == null ? this.TN.getDataType() : this.TM;
    }

    public String toDebugString() {
        String str = "Subscription{%s}";
        Object[] objArr = new Object[1];
        objArr[0] = this.TN == null ? this.TM.getName() : this.TN.toDebugString();
        return String.format(str, objArr);
    }

    public String toString() {
        return jv.h(this).a("dataSource", this.TN).a("dataType", this.TM).a("samplingIntervalMicros", Long.valueOf(this.UQ)).a("accuracyMode", Integer.valueOf(this.UR)).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        s.a(this, dest, flags);
    }
}
