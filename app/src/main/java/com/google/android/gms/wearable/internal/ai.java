package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.MessageEvent;

public class ai implements SafeParcelable, MessageEvent {
    public static final Creator<ai> CREATOR = new aj();
    final int CK;
    private final byte[] aeA;
    private final String ahy;
    private final String axW;
    private final int ve;

    ai(int i, int i2, String str, byte[] bArr, String str2) {
        this.CK = i;
        this.ve = i2;
        this.axW = str;
        this.aeA = bArr;
        this.ahy = str2;
    }

    public int describeContents() {
        return 0;
    }

    public byte[] getData() {
        return this.aeA;
    }

    public String getPath() {
        return this.axW;
    }

    public int getRequestId() {
        return this.ve;
    }

    public String getSourceNodeId() {
        return this.ahy;
    }

    public String toString() {
        return "MessageEventParcelable[" + this.ve + "," + this.axW + ", size=" + (this.aeA == null ? "null" : Integer.valueOf(this.aeA.length)) + "]";
    }

    public void writeToParcel(Parcel dest, int flags) {
        aj.a(this, dest, flags);
    }
}
