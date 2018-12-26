package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jx;

public final class Scope implements SafeParcelable {
    public static final Creator<Scope> CREATOR = new e();
    final int CK;
    private final String Kv;

    Scope(int versionCode, String scopeUri) {
        jx.b(scopeUri, (Object) "scopeUri must not be null or empty");
        this.CK = versionCode;
        this.Kv = scopeUri;
    }

    public Scope(String scopeUri) {
        this(1, scopeUri);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o ? true : !(o instanceof Scope) ? false : this.Kv.equals(((Scope) o).Kv);
    }

    public String gO() {
        return this.Kv;
    }

    public int hashCode() {
        return this.Kv.hashCode();
    }

    public String toString() {
        return this.Kv;
    }

    public void writeToParcel(Parcel dest, int flags) {
        e.a(this, dest, flags);
    }
}
