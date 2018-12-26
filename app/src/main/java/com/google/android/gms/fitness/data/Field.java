package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jx;

public final class Field implements SafeParcelable {
    public static final Creator<Field> CREATOR = new j();
    public static final Field FIELD_ACCURACY = bv("accuracy");
    public static final Field FIELD_ACTIVITY = bu("activity");
    public static final Field FIELD_ALTITUDE = bv("altitude");
    public static final Field FIELD_AVERAGE = bv("average");
    public static final Field FIELD_BPM = bv("bpm");
    public static final Field FIELD_CALORIES = bv("calories");
    public static final Field FIELD_CONFIDENCE = bv("confidence");
    public static final Field FIELD_DISTANCE = bv("distance");
    public static final Field FIELD_DURATION = bu("duration");
    public static final Field FIELD_HEIGHT = bv("height");
    public static final Field FIELD_HIGH_LATITUDE = bv("high_latitude");
    public static final Field FIELD_HIGH_LONGITUDE = bv("high_longitude");
    public static final Field FIELD_LATITUDE = bv("latitude");
    public static final Field FIELD_LONGITUDE = bv("longitude");
    public static final Field FIELD_LOW_LATITUDE = bv("low_latitude");
    public static final Field FIELD_LOW_LONGITUDE = bv("low_longitude");
    public static final Field FIELD_MAX = bv("max");
    public static final Field FIELD_MIN = bv("min");
    public static final Field FIELD_NUM_SEGMENTS = bu("num_segments");
    public static final Field FIELD_REVOLUTIONS = bu("revolutions");
    public static final Field FIELD_RPM = bv("rpm");
    public static final Field FIELD_SPEED = bv("speed");
    public static final Field FIELD_STEPS = bu("steps");
    public static final Field FIELD_WATTS = bv("watts");
    public static final Field FIELD_WEIGHT = bv("weight");
    public static final int FORMAT_FLOAT = 2;
    public static final int FORMAT_INT32 = 1;
    public static final Field UA = bu("edge_type");
    public static final Field UB = bv("x");
    public static final Field UC = bv("y");
    public static final Field UD = bv("z");
    private final int CK;
    private final int UE;
    private final String mName;

    Field(int versionCode, String name, int format) {
        this.CK = versionCode;
        this.mName = (String) jx.i(name);
        this.UE = format;
    }

    public Field(String name, int format) {
        this(1, name, format);
    }

    private boolean a(Field field) {
        return this.mName.equals(field.mName) && this.UE == field.UE;
    }

    private static Field bu(String str) {
        return new Field(str, 1);
    }

    private static Field bv(String str) {
        return new Field(str, 2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof Field) && a((Field) that));
    }

    public int getFormat() {
        return this.UE;
    }

    public String getName() {
        return this.mName;
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return this.mName.hashCode();
    }

    public String toString() {
        String str = "%s(%s)";
        Object[] objArr = new Object[2];
        objArr[0] = this.mName;
        objArr[1] = this.UE == 1 ? "i" : "f";
        return String.format(str, objArr);
    }

    public void writeToParcel(Parcel dest, int flags) {
        j.a(this, dest, flags);
    }
}
