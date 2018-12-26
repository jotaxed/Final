package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;

public final class Value implements SafeParcelable {
    public static final Creator<Value> CREATOR = new u();
    private final int CK;
    private final int UE;
    private boolean US;
    private float UT;

    Value(int format) {
        this(1, format, false, 0.0f);
    }

    Value(int versionCode, int format, boolean isSet, float value) {
        this.CK = versionCode;
        this.UE = format;
        this.US = isSet;
        this.UT = value;
    }

    private boolean a(Value value) {
        if (this.UE != value.UE || this.US != value.US) {
            return false;
        }
        switch (this.UE) {
            case 1:
                return asInt() == value.asInt();
            case 2:
                return asFloat() == value.asFloat();
            default:
                return this.UT == value.UT;
        }
    }

    public String asActivity() {
        try {
            return FitnessActivities.getName(asInt());
        } catch (IllegalArgumentException e) {
            return FitnessActivities.UNKNOWN;
        }
    }

    public float asFloat() {
        jx.a(this.UE == 2, "Value is not in float format");
        return this.UT;
    }

    public int asInt() {
        boolean z = true;
        if (this.UE != 1) {
            z = false;
        }
        jx.a(z, "Value is not in int format");
        return Float.floatToRawIntBits(this.UT);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof Value) && a((Value) o));
    }

    public int getFormat() {
        return this.UE;
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(Float.valueOf(this.UT), Integer.valueOf(this.UE), Boolean.valueOf(this.US));
    }

    public boolean isSet() {
        return this.US;
    }

    float jL() {
        return this.UT;
    }

    public void setActivity(String activity) {
        setInt(FitnessActivities.bs(activity));
    }

    public void setFloat(float value) {
        jx.a(this.UE == 2, "Attempting to set an float value to a field that is not in FLOAT format.  Please check the data type definition and use the right format.");
        this.US = true;
        this.UT = value;
    }

    public void setInt(int value) {
        jx.a(this.UE == 1, "Attempting to set an int value to a field that is not in INT32 format.  Please check the data type definition and use the right format.");
        this.US = true;
        this.UT = Float.intBitsToFloat(value);
    }

    public String toString() {
        if (!this.US) {
            return "unset";
        }
        switch (this.UE) {
            case 1:
                return Integer.toString(asInt());
            case 2:
                return Float.toString(asFloat());
            default:
                return FitnessActivities.UNKNOWN;
        }
    }

    public void writeToParcel(Parcel dest, int flags) {
        u.a(this, dest, flags);
    }
}
