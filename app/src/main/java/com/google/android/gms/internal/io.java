package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class io implements SafeParcelable {
    public static final Creator<io> CREATOR = new ip();
    private final int CK;
    private double Gp;
    private boolean Gq;
    private ApplicationMetadata HD;
    private int Hr;
    private int Hs;

    public io() {
        this(3, Double.NaN, false, -1, null, -1);
    }

    io(int i, double d, boolean z, int i2, ApplicationMetadata applicationMetadata, int i3) {
        this.CK = i;
        this.Gp = d;
        this.Gq = z;
        this.Hr = i2;
        this.HD = applicationMetadata;
        this.Hs = i3;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof io)) {
            return false;
        }
        io ioVar = (io) obj;
        return this.Gp == ioVar.Gp && this.Gq == ioVar.Gq && this.Hr == ioVar.Hr && in.a(this.HD, ioVar.HD) && this.Hs == ioVar.Hs;
    }

    public double fZ() {
        return this.Gp;
    }

    public ApplicationMetadata getApplicationMetadata() {
        return this.HD;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public boolean gi() {
        return this.Gq;
    }

    public int gj() {
        return this.Hr;
    }

    public int gk() {
        return this.Hs;
    }

    public int hashCode() {
        return jv.hashCode(Double.valueOf(this.Gp), Boolean.valueOf(this.Gq), Integer.valueOf(this.Hr), this.HD, Integer.valueOf(this.Hs));
    }

    public void writeToParcel(Parcel out, int flags) {
        ip.a(this, out, flags);
    }
}
