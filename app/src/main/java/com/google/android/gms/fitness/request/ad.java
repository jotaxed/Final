package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.request.l.a;

public class ad implements SafeParcelable {
    public static final Creator<ad> CREATOR = new ae();
    private final int CK;
    private final l Wm;

    ad(int i, IBinder iBinder) {
        this.CK = i;
        this.Wm = a.aB(iBinder);
    }

    public ad(BleScanCallback bleScanCallback) {
        this.CK = 1;
        this.Wm = a.a.jP().b(bleScanCallback);
    }

    public int describeContents() {
        return 0;
    }

    int getVersionCode() {
        return this.CK;
    }

    public IBinder km() {
        return this.Wm.asBinder();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        ae.a(this, parcel, flags);
    }
}
