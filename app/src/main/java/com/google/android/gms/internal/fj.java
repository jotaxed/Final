package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

@ey
public final class fj implements SafeParcelable {
    public static final fk CREATOR = new fk();
    public final int errorCode;
    public final int orientation;
    public final long qA;
    public final List<String> qw;
    public final List<String> qx;
    public final String sg;
    public final boolean tT;
    public final String tU;
    public final long tV;
    public final boolean tW;
    public final long tX;
    public final List<String> tY;
    public final String tZ;
    public final long ua;
    public final String ub;
    public final boolean uc;
    public final String ud;
    public final String ue;
    public final boolean uf;
    public final boolean ug;
    public final boolean uh;
    public final int versionCode;

    public fj(int i) {
        this(10, null, null, null, i, null, -1, false, -1, null, -1, -1, null, -1, null, false, null, null, false, false, false, false);
    }

    public fj(int i, long j) {
        this(10, null, null, null, i, null, -1, false, -1, null, j, -1, null, -1, null, false, null, null, false, false, false, false);
    }

    fj(int i, String str, String str2, List<String> list, int i2, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i3, String str3, long j4, String str4, boolean z2, String str5, String str6, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.versionCode = i;
        this.sg = str;
        this.tU = str2;
        this.qw = list != null ? Collections.unmodifiableList(list) : null;
        this.errorCode = i2;
        this.qx = list2 != null ? Collections.unmodifiableList(list2) : null;
        this.tV = j;
        this.tW = z;
        this.tX = j2;
        this.tY = list3 != null ? Collections.unmodifiableList(list3) : null;
        this.qA = j3;
        this.orientation = i3;
        this.tZ = str3;
        this.ua = j4;
        this.ub = str4;
        this.uc = z2;
        this.ud = str5;
        this.ue = str6;
        this.uf = z3;
        this.ug = z4;
        this.tT = z5;
        this.uh = z6;
    }

    public fj(String str, String str2, List<String> list, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i, String str3, long j4, String str4, String str5, boolean z2, boolean z3, boolean z4, boolean z5) {
        this(10, str, str2, list, -2, list2, j, z, j2, list3, j3, i, str3, j4, str4, false, null, str5, z2, z3, z4, z5);
    }

    public fj(String str, String str2, List<String> list, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i, String str3, long j4, String str4, boolean z2, String str5, String str6, boolean z3, boolean z4, boolean z5, boolean z6) {
        this(10, str, str2, list, -2, list2, j, z, j2, list3, j3, i, str3, j4, str4, z2, str5, str6, z3, z4, z5, z6);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        fk.a(this, out, flags);
    }
}
