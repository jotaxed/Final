package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class or implements SafeParcelable {
    public static final ot CREATOR = new ot();
    public final long amW;
    public final byte[] amX;
    public final Bundle amY;
    public final String tag;
    public final int versionCode;

    or(int i, long j, String str, byte[] bArr, Bundle bundle) {
        this.versionCode = i;
        this.amW = j;
        this.tag = str;
        this.amX = bArr;
        this.amY = bundle;
    }

    public or(long j, String str, byte[] bArr, String... strArr) {
        this.versionCode = 1;
        this.amW = j;
        this.tag = str;
        this.amX = bArr;
        this.amY = g(strArr);
    }

    private static Bundle g(String... strArr) {
        Bundle bundle = null;
        if (strArr != null) {
            if (strArr.length % 2 != 0) {
                throw new IllegalArgumentException("extras must have an even number of elements");
            }
            int length = strArr.length / 2;
            if (length != 0) {
                bundle = new Bundle(length);
                for (int i = 0; i < length; i++) {
                    bundle.putString(strArr[i * 2], strArr[(i * 2) + 1]);
                }
            }
        }
        return bundle;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("tag=").append(this.tag).append(",");
        stringBuilder.append("eventTime=").append(this.amW).append(",");
        if (!(this.amY == null || this.amY.isEmpty())) {
            stringBuilder.append("keyValues=");
            for (String str : this.amY.keySet()) {
                stringBuilder.append("(").append(str).append(",");
                stringBuilder.append(this.amY.getString(str)).append(")");
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        ot.a(this, out, flags);
    }
}
