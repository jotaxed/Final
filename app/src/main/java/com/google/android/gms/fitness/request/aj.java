package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.jv;

public class aj implements SafeParcelable {
    public static final Creator<aj> CREATOR = new ak();
    private final int CK;
    private final DataType TM;
    private final DataSource TN;

    public static class a {
        private DataType TM;
        private DataSource TN;

        public a d(DataSource dataSource) {
            this.TN = dataSource;
            return this;
        }

        public a d(DataType dataType) {
            this.TM = dataType;
            return this;
        }

        public aj kq() {
            if (this.TM == null || this.TN == null) {
                return new aj();
            }
            throw new IllegalArgumentException("Cannot specify both dataType and dataSource");
        }
    }

    aj(int i, DataType dataType, DataSource dataSource) {
        this.CK = i;
        this.TM = dataType;
        this.TN = dataSource;
    }

    private aj(a aVar) {
        this.CK = 1;
        this.TM = aVar.TM;
        this.TN = aVar.TN;
    }

    private boolean a(aj ajVar) {
        return jv.equal(this.TN, ajVar.TN) && jv.equal(this.TM, ajVar.TM);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof aj) && a((aj) o));
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
        return jv.hashCode(this.TN, this.TM);
    }

    public void writeToParcel(Parcel parcel, int flags) {
        ak.a(this, parcel, flags);
    }
}
