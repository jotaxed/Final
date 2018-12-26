package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.concurrent.TimeUnit;

public final class ny implements SafeParcelable {
    public static final nz CREATOR = new nz();
    public static final long ahz = TimeUnit.HOURS.toMillis(1);
    final int CK;
    private final long agr;
    private final nu ahA;
    private final int mPriority;

    public ny(int i, nu nuVar, long j, int i2) {
        this.CK = i;
        this.ahA = nuVar;
        this.agr = j;
        this.mPriority = i2;
    }

    public int describeContents() {
        nz nzVar = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof ny)) {
            return false;
        }
        ny nyVar = (ny) object;
        return jv.equal(this.ahA, nyVar.ahA) && this.agr == nyVar.agr && this.mPriority == nyVar.mPriority;
    }

    public long getInterval() {
        return this.agr;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public int hashCode() {
        return jv.hashCode(this.ahA, Long.valueOf(this.agr), Integer.valueOf(this.mPriority));
    }

    public nu nt() {
        return this.ahA;
    }

    public String toString() {
        return jv.h(this).a("filter", this.ahA).a("interval", Long.valueOf(this.agr)).a("priority", Integer.valueOf(this.mPriority)).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        nz nzVar = CREATOR;
        nz.a(this, parcel, flags);
    }
}
