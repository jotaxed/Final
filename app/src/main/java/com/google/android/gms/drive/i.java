package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.jx;

public abstract class i implements Parcelable {
    private volatile transient boolean OW = false;

    protected abstract void I(Parcel parcel, int i);

    public final boolean iB() {
        return this.OW;
    }

    public void writeToParcel(Parcel dest, int flags) {
        jx.K(!iB());
        this.OW = true;
        I(dest, flags);
    }
}
