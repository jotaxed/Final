package com.google.android.gms.games.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ConnectionInfo implements SafeParcelable {
    public static final ConnectionInfoCreator CREATOR = new ConnectionInfoCreator();
    private final int CK;
    private final String Yi;
    private final int Yj;

    public ConnectionInfo(int versionCode, String clientAddress, int registrationLatency) {
        this.CK = versionCode;
        this.Yi = clientAddress;
        this.Yj = registrationLatency;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public String le() {
        return this.Yi;
    }

    public int lf() {
        return this.Yj;
    }

    public void writeToParcel(Parcel out, int flags) {
        ConnectionInfoCreator.a(this, out, flags);
    }
}
