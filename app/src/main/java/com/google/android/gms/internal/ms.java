package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;

public class ms implements SafeParcelable {
    public static final Creator<ms> CREATOR = new mt();
    private final int CK;
    private final DataSource TN;

    ms(int i, DataSource dataSource) {
        this.CK = i;
        this.TN = dataSource;
    }

    public int describeContents() {
        return 0;
    }

    public DataSource getDataSource() {
        return this.TN;
    }

    int getVersionCode() {
        return this.CK;
    }

    public String toString() {
        return String.format("ApplicationUnregistrationRequest{%s}", new Object[]{this.TN});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        mt.a(this, parcel, flags);
    }
}
