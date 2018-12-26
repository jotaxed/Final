package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ij implements SafeParcelable {
    public static final Creator<ij> CREATOR = new ik();
    private final int CK;
    private String Hd;

    public ij() {
        this(1, null);
    }

    ij(int i, String str) {
        this.CK = i;
        this.Hd = str;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ij)) {
            return false;
        }
        return in.a(this.Hd, ((ij) obj).Hd);
    }

    public String fT() {
        return this.Hd;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(this.Hd);
    }

    public void writeToParcel(Parcel out, int flags) {
        ik.a(this, out, flags);
    }
}
