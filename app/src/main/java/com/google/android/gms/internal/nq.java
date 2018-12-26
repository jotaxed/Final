package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class nq implements SafeParcelable {
    public static final nr CREATOR = new nr();
    final int CK;
    final boolean ahm;
    final List<oa> ahn;
    private final Set<oa> aho;

    nq(int i, boolean z, List<oa> list) {
        this.CK = i;
        this.ahm = z;
        this.ahn = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        if (this.ahn.isEmpty()) {
            this.aho = Collections.emptySet();
        } else {
            this.aho = Collections.unmodifiableSet(new HashSet(this.ahn));
        }
    }

    public int describeContents() {
        nr nrVar = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof nq)) {
            return false;
        }
        nq nqVar = (nq) object;
        return this.aho.equals(nqVar.aho) && this.ahm == nqVar.ahm;
    }

    public int hashCode() {
        return jv.hashCode(this.aho, Boolean.valueOf(this.ahm));
    }

    public boolean nr() {
        return this.ahm;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        nr nrVar = CREATOR;
        nr.a(this, parcel, flags);
    }
}
