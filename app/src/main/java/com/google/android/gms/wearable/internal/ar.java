package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.ae.a;

public class ar implements SafeParcelable {
    public static final Creator<ar> CREATOR = new as();
    final int CK;
    public final ae axv;

    ar(int i, IBinder iBinder) {
        this.CK = i;
        if (iBinder != null) {
            this.axv = a.bY(iBinder);
        } else {
            this.axv = null;
        }
    }

    public ar(ae aeVar) {
        this.CK = 1;
        this.axv = aeVar;
    }

    public int describeContents() {
        return 0;
    }

    IBinder rm() {
        return this.axv == null ? null : this.axv.asBinder();
    }

    public void writeToParcel(Parcel dest, int flags) {
        as.a(this, dest, flags);
    }
}
