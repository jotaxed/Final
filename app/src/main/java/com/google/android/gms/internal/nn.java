package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.Geofence;
import java.util.Locale;

public class nn implements SafeParcelable, Geofence {
    public static final no CREATOR = new no();
    private final int CK;
    private final String Zt;
    private final int agd;
    private final short agf;
    private final double agg;
    private final double agh;
    private final float agi;
    private final int agj;
    private final int agk;
    private final long ahl;

    public nn(int i, String str, int i2, short s, double d, double d2, float f, long j, int i3, int i4) {
        cb(str);
        b(f);
        a(d, d2);
        int eH = eH(i2);
        this.CK = i;
        this.agf = s;
        this.Zt = str;
        this.agg = d;
        this.agh = d2;
        this.agi = f;
        this.ahl = j;
        this.agd = eH;
        this.agj = i3;
        this.agk = i4;
    }

    public nn(String str, int i, short s, double d, double d2, float f, long j, int i2, int i3) {
        this(1, str, i, s, d, d2, f, j, i2, i3);
    }

    private static void a(double d, double d2) {
        if (d > 90.0d || d < -90.0d) {
            throw new IllegalArgumentException("invalid latitude: " + d);
        } else if (d2 > 180.0d || d2 < -180.0d) {
            throw new IllegalArgumentException("invalid longitude: " + d2);
        }
    }

    private static void b(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("invalid radius: " + f);
        }
    }

    private static void cb(String str) {
        if (str == null || str.length() > 100) {
            throw new IllegalArgumentException("requestId is null or too long: " + str);
        }
    }

    private static int eH(int i) {
        int i2 = i & 7;
        if (i2 != 0) {
            return i2;
        }
        throw new IllegalArgumentException("No supported transition specified: " + i);
    }

    private static String eI(int i) {
        switch (i) {
            case 1:
                return "CIRCLE";
            default:
                return null;
        }
    }

    public static nn h(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        nn cN = CREATOR.cN(obtain);
        obtain.recycle();
        return cN;
    }

    public int describeContents() {
        no noVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof nn)) {
            return false;
        }
        nn nnVar = (nn) obj;
        return this.agi != nnVar.agi ? false : this.agg != nnVar.agg ? false : this.agh != nnVar.agh ? false : this.agf == nnVar.agf;
    }

    public long getExpirationTime() {
        return this.ahl;
    }

    public double getLatitude() {
        return this.agg;
    }

    public double getLongitude() {
        return this.agh;
    }

    public int getNotificationResponsiveness() {
        return this.agj;
    }

    public String getRequestId() {
        return this.Zt;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.agg);
        int i = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.agh);
        return (((((((i * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + Float.floatToIntBits(this.agi)) * 31) + this.agf) * 31) + this.agd;
    }

    public short nn() {
        return this.agf;
    }

    public float no() {
        return this.agi;
    }

    public int np() {
        return this.agd;
    }

    public int nq() {
        return this.agk;
    }

    public String toString() {
        return String.format(Locale.US, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", new Object[]{eI(this.agf), this.Zt, Integer.valueOf(this.agd), Double.valueOf(this.agg), Double.valueOf(this.agh), Float.valueOf(this.agi), Integer.valueOf(this.agj / 1000), Integer.valueOf(this.agk), Long.valueOf(this.ahl)});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        no noVar = CREATOR;
        no.a(this, parcel, flags);
    }
}
