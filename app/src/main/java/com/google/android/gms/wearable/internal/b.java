package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.ae.a;

public class b implements SafeParcelable {
    public static final Creator<b> CREATOR = new c();
    final int CK;
    public final ae axv;
    public final IntentFilter[] axw;

    b(int i, IBinder iBinder, IntentFilter[] intentFilterArr) {
        this.CK = i;
        if (iBinder != null) {
            this.axv = a.bY(iBinder);
        } else {
            this.axv = null;
        }
        this.axw = intentFilterArr;
    }

    public b(bb bbVar) {
        this.CK = 1;
        this.axv = bbVar;
        this.axw = bbVar.rs();
    }

    public int describeContents() {
        return 0;
    }

    IBinder rm() {
        return this.axv == null ? null : this.axv.asBinder();
    }

    public void writeToParcel(Parcel dest, int flags) {
        c.a(this, dest, flags);
    }
}
