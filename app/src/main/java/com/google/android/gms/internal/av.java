package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

@ey
public final class av implements SafeParcelable {
    public static final aw CREATOR = new aw();
    public final Bundle extras;
    public final long od;
    public final int oe;
    public final List<String> of;
    public final boolean og;
    public final int oh;
    public final boolean oi;
    public final String oj;
    public final bj ok;
    public final Location ol;
    public final String om;
    public final Bundle on;
    public final int versionCode;

    public av(int i, long j, Bundle bundle, int i2, List<String> list, boolean z, int i3, boolean z2, String str, bj bjVar, Location location, String str2, Bundle bundle2) {
        this.versionCode = i;
        this.od = j;
        this.extras = bundle;
        this.oe = i2;
        this.of = list;
        this.og = z;
        this.oh = i3;
        this.oi = z2;
        this.oj = str;
        this.ok = bjVar;
        this.ol = location;
        this.om = str2;
        this.on = bundle2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        aw.a(this, out, flags);
    }
}
