package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class nd implements SafeParcelable {
    public static final ne CREATOR = new ne();
    private final int CK;
    public final String packageName;
    public final int uid;

    nd(int i, int i2, String str) {
        this.CK = i;
        this.uid = i2;
        this.packageName = str;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (!(o instanceof nd)) {
            return false;
        }
        nd ndVar = (nd) o;
        return ndVar.uid == this.uid && jv.equal(ndVar.packageName, this.packageName);
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return this.uid;
    }

    public String toString() {
        return String.format("%d:%s", new Object[]{Integer.valueOf(this.uid), this.packageName});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        ne.a(this, parcel, flags);
    }
}
