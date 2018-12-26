package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.k;
import com.google.android.gms.fitness.data.k.a;

public class q implements SafeParcelable {
    public static final Creator<q> CREATOR = new r();
    private final int CK;
    private final k VW;
    private final PendingIntent mPendingIntent;

    q(int i, IBinder iBinder, PendingIntent pendingIntent) {
        this.CK = i;
        this.VW = iBinder == null ? null : a.aq(iBinder);
        this.mPendingIntent = pendingIntent;
    }

    public q(k kVar, PendingIntent pendingIntent) {
        this.CK = 2;
        this.VW = kVar;
        this.mPendingIntent = pendingIntent;
    }

    public int describeContents() {
        return 0;
    }

    int getVersionCode() {
        return this.CK;
    }

    public PendingIntent kb() {
        return this.mPendingIntent;
    }

    IBinder kg() {
        return this.VW == null ? null : this.VW.asBinder();
    }

    public String toString() {
        return String.format("SensorUnregistrationRequest{%s}", new Object[]{this.VW});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        r.a(this, parcel, flags);
    }
}
