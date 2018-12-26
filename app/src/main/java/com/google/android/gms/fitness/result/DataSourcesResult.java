package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.jv;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataSourcesResult implements Result, SafeParcelable {
    public static final Creator<DataSourcesResult> CREATOR = new c();
    private final int CK;
    private final Status Eb;
    private final List<DataSource> VH;

    DataSourcesResult(int versionCode, List<DataSource> dataSources, Status status) {
        this.CK = versionCode;
        this.VH = Collections.unmodifiableList(dataSources);
        this.Eb = status;
    }

    public DataSourcesResult(List<DataSource> dataSources, Status status) {
        this.CK = 3;
        this.VH = Collections.unmodifiableList(dataSources);
        this.Eb = status;
    }

    public static DataSourcesResult D(Status status) {
        return new DataSourcesResult(Collections.emptyList(), status);
    }

    private boolean b(DataSourcesResult dataSourcesResult) {
        return this.Eb.equals(dataSourcesResult.Eb) && jv.equal(this.VH, dataSourcesResult.VH);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof DataSourcesResult) && b((DataSourcesResult) that));
    }

    public List<DataSource> getDataSources() {
        return this.VH;
    }

    public List<DataSource> getDataSources(DataType dataType) {
        List arrayList = new ArrayList();
        for (DataSource dataSource : this.VH) {
            if (dataSource.getDataType().equals(dataType)) {
                arrayList.add(dataSource);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Status getStatus() {
        return this.Eb;
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(this.Eb, this.VH);
    }

    public String toString() {
        return jv.h(this).a("status", this.Eb).a("dataSets", this.VH).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        c.a(this, dest, flags);
    }
}
