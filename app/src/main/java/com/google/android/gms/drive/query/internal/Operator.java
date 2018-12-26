package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class Operator implements SafeParcelable {
    public static final Creator<Operator> CREATOR = new l();
    public static final Operator SA = new Operator(">=");
    public static final Operator SB = new Operator("and");
    public static final Operator SC = new Operator("or");
    public static final Operator SD = new Operator("not");
    public static final Operator SE = new Operator("contains");
    public static final Operator Sw = new Operator("=");
    public static final Operator Sx = new Operator("<");
    public static final Operator Sy = new Operator("<=");
    public static final Operator Sz = new Operator(">");
    final int CK;
    final String mTag;

    Operator(int versionCode, String tag) {
        this.CK = versionCode;
        this.mTag = tag;
    }

    private Operator(String tag) {
        this(1, tag);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Operator operator = (Operator) obj;
        return this.mTag == null ? operator.mTag == null : this.mTag.equals(operator.mTag);
    }

    public String getTag() {
        return this.mTag;
    }

    public int hashCode() {
        return (this.mTag == null ? 0 : this.mTag.hashCode()) + 31;
    }

    public void writeToParcel(Parcel out, int flags) {
        l.a(this, out, flags);
    }
}
