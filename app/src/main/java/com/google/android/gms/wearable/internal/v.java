package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class v implements SafeParcelable {
    public static final Creator<v> CREATOR = new w();
    public final List<al> axL;
    public final int statusCode;
    public final int versionCode;

    v(int i, int i2, List<al> list) {
        this.versionCode = i;
        this.statusCode = i2;
        this.axL = list;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        w.a(this, dest, flags);
    }
}
