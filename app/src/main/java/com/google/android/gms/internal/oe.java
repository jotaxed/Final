package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class oe implements SafeParcelable {
    public static final of CREATOR = new of();
    public static final oe akb = A("test_type", 1);
    public static final oe akc = A("labeled_place", 6);
    public static final Set<oe> akd = Collections.unmodifiableSet(new HashSet(Arrays.asList(new oe[]{akb, akc})));
    final int CK;
    final int ake;
    final String vc;

    oe(int i, String str, int i2) {
        jx.bb(str);
        this.CK = i;
        this.vc = str;
        this.ake = i2;
    }

    private static oe A(String str, int i) {
        return new oe(0, str, i);
    }

    public int describeContents() {
        of ofVar = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof oe)) {
            return false;
        }
        oe oeVar = (oe) object;
        return this.vc.equals(oeVar.vc) && this.ake == oeVar.ake;
    }

    public int hashCode() {
        return this.vc.hashCode();
    }

    public String toString() {
        return this.vc;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        of ofVar = CREATOR;
        of.a(this, parcel, flags);
    }
}
