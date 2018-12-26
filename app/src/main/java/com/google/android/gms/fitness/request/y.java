package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;

public class y implements SafeParcelable {
    public static final Creator<y> CREATOR = new z();
    private final int CK;
    private final String UN;
    private final String mName;

    public static class a {
        private String UN;
        private String mName;

        public a bx(String str) {
            this.mName = str;
            return this;
        }

        public a by(String str) {
            this.UN = str;
            return this;
        }

        public y kl() {
            return new y();
        }
    }

    y(int i, String str, String str2) {
        this.CK = i;
        this.mName = str;
        this.UN = str2;
    }

    private y(a aVar) {
        this.CK = 1;
        this.mName = aVar.mName;
        this.UN = aVar.UN;
    }

    private boolean a(y yVar) {
        return jv.equal(this.mName, yVar.mName) && jv.equal(this.UN, yVar.UN);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof y) && a((y) o));
    }

    public String getIdentifier() {
        return this.UN;
    }

    public String getName() {
        return this.mName;
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(this.mName, this.UN);
    }

    public String toString() {
        return jv.h(this).a("name", this.mName).a("identifier", this.UN).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        z.a(this, dest, flags);
    }
}
