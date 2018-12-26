package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import java.util.Collections;
import java.util.List;

public class mq implements SafeParcelable {
    public static final Creator<mq> CREATOR = new mr();
    private final int CK;
    private final List<DataType> TY;

    mq(int i, List<DataType> list) {
        this.CK = i;
        this.TY = list;
    }

    public int describeContents() {
        return 0;
    }

    public List<DataType> getDataTypes() {
        return Collections.unmodifiableList(this.TY);
    }

    int getVersionCode() {
        return this.CK;
    }

    public String toString() {
        return jv.h(this).a("dataTypes", this.TY).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        mr.a(this, parcel, flags);
    }
}
