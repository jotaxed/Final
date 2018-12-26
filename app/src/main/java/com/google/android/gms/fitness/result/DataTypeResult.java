package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.jv;

public class DataTypeResult implements Result, SafeParcelable {
    public static final Creator<DataTypeResult> CREATOR = new d();
    private final int CK;
    private final Status Eb;
    private final DataType TM;

    DataTypeResult(int versionCode, Status status, DataType dataType) {
        this.CK = versionCode;
        this.Eb = status;
        this.TM = dataType;
    }

    public DataTypeResult(Status status, DataType dataType) {
        this.CK = 2;
        this.Eb = status;
        this.TM = dataType;
    }

    public static DataTypeResult E(Status status) {
        return new DataTypeResult(status, null);
    }

    private boolean b(DataTypeResult dataTypeResult) {
        return this.Eb.equals(dataTypeResult.Eb) && jv.equal(this.TM, dataTypeResult.TM);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof DataTypeResult) && b((DataTypeResult) that));
    }

    public DataType getDataType() {
        return this.TM;
    }

    public Status getStatus() {
        return this.Eb;
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(this.Eb, this.TM);
    }

    public String toString() {
        return jv.h(this).a("status", this.Eb).a("dataType", this.TM).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        d.a(this, dest, flags);
    }
}
