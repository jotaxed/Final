package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;

public final class LocationRequest implements SafeParcelable {
    public static final d CREATOR = new d();
    public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;
    public static final int PRIORITY_HIGH_ACCURACY = 100;
    public static final int PRIORITY_LOW_POWER = 104;
    public static final int PRIORITY_NO_POWER = 105;
    private final int CK;
    boolean Wg;
    long age;
    long agr;
    long ags;
    int agt;
    float agu;
    long agv;
    int mPriority;

    public LocationRequest() {
        this.CK = 1;
        this.mPriority = 102;
        this.agr = 3600000;
        this.ags = 600000;
        this.Wg = false;
        this.age = Long.MAX_VALUE;
        this.agt = Integer.MAX_VALUE;
        this.agu = 0.0f;
        this.agv = 0;
    }

    LocationRequest(int versionCode, int priority, long interval, long fastestInterval, boolean explicitFastestInterval, long expireAt, int numUpdates, float smallestDisplacement, long maxWaitTime) {
        this.CK = versionCode;
        this.mPriority = priority;
        this.agr = interval;
        this.ags = fastestInterval;
        this.Wg = explicitFastestInterval;
        this.age = expireAt;
        this.agt = numUpdates;
        this.agu = smallestDisplacement;
        this.agv = maxWaitTime;
    }

    private static void a(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("invalid displacement: " + f);
        }
    }

    public static LocationRequest create() {
        return new LocationRequest();
    }

    private static void ey(int i) {
        switch (i) {
            case 100:
            case 102:
            case PRIORITY_LOW_POWER /*104*/:
            case PRIORITY_NO_POWER /*105*/:
                return;
            default:
                throw new IllegalArgumentException("invalid quality: " + i);
        }
    }

    public static String ez(int i) {
        switch (i) {
            case 100:
                return "PRIORITY_HIGH_ACCURACY";
            case 102:
                return "PRIORITY_BALANCED_POWER_ACCURACY";
            case PRIORITY_LOW_POWER /*104*/:
                return "PRIORITY_LOW_POWER";
            case PRIORITY_NO_POWER /*105*/:
                return "PRIORITY_NO_POWER";
            default:
                return "???";
        }
    }

    private static void v(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("invalid interval: " + j);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof LocationRequest)) {
            return false;
        }
        LocationRequest locationRequest = (LocationRequest) object;
        return this.mPriority == locationRequest.mPriority && this.agr == locationRequest.agr && this.ags == locationRequest.ags && this.Wg == locationRequest.Wg && this.age == locationRequest.age && this.agt == locationRequest.agt && this.agu == locationRequest.agu;
    }

    public long getExpirationTime() {
        return this.age;
    }

    public long getFastestInterval() {
        return this.ags;
    }

    public long getInterval() {
        return this.agr;
    }

    public int getNumUpdates() {
        return this.agt;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public float getSmallestDisplacement() {
        return this.agu;
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(Integer.valueOf(this.mPriority), Long.valueOf(this.agr), Long.valueOf(this.ags), Boolean.valueOf(this.Wg), Long.valueOf(this.age), Integer.valueOf(this.agt), Float.valueOf(this.agu));
    }

    public LocationRequest setExpirationDuration(long millis) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (millis > Long.MAX_VALUE - elapsedRealtime) {
            this.age = Long.MAX_VALUE;
        } else {
            this.age = elapsedRealtime + millis;
        }
        if (this.age < 0) {
            this.age = 0;
        }
        return this;
    }

    public LocationRequest setExpirationTime(long millis) {
        this.age = millis;
        if (this.age < 0) {
            this.age = 0;
        }
        return this;
    }

    public LocationRequest setFastestInterval(long millis) {
        v(millis);
        this.Wg = true;
        this.ags = millis;
        return this;
    }

    public LocationRequest setInterval(long millis) {
        v(millis);
        this.agr = millis;
        if (!this.Wg) {
            this.ags = (long) (((double) this.agr) / 6.0d);
        }
        return this;
    }

    public LocationRequest setNumUpdates(int numUpdates) {
        if (numUpdates <= 0) {
            throw new IllegalArgumentException("invalid numUpdates: " + numUpdates);
        }
        this.agt = numUpdates;
        return this;
    }

    public LocationRequest setPriority(int priority) {
        ey(priority);
        this.mPriority = priority;
        return this;
    }

    public LocationRequest setSmallestDisplacement(float smallestDisplacementMeters) {
        a(smallestDisplacementMeters);
        this.agu = smallestDisplacementMeters;
        return this;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Request[").append(ez(this.mPriority));
        if (this.mPriority != PRIORITY_NO_POWER) {
            stringBuilder.append(" requested=");
            stringBuilder.append(this.agr + "ms");
        }
        stringBuilder.append(" fastest=");
        stringBuilder.append(this.ags + "ms");
        if (this.age != Long.MAX_VALUE) {
            long elapsedRealtime = this.age - SystemClock.elapsedRealtime();
            stringBuilder.append(" expireIn=");
            stringBuilder.append(elapsedRealtime + "ms");
        }
        if (this.agt != Integer.MAX_VALUE) {
            stringBuilder.append(" num=").append(this.agt);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        d.a(this, parcel, flags);
    }
}
