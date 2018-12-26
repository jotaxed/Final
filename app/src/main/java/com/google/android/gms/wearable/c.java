package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;

public class c implements SafeParcelable {
    public static final Creator<c> CREATOR = new d();
    final int CK;
    private final int Gt;
    private final String TW;
    private final int axc;
    private final boolean axd;
    private boolean axe;
    private String axf;
    private final String mName;

    c(int i, String str, String str2, int i2, int i3, boolean z, boolean z2, String str3) {
        this.CK = i;
        this.mName = str;
        this.TW = str2;
        this.Gt = i2;
        this.axc = i3;
        this.axd = z;
        this.axe = z2;
        this.axf = str3;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (!(o instanceof c)) {
            return false;
        }
        c cVar = (c) o;
        return jv.equal(Integer.valueOf(this.CK), Integer.valueOf(cVar.CK)) && jv.equal(this.mName, cVar.mName) && jv.equal(this.TW, cVar.TW) && jv.equal(Integer.valueOf(this.Gt), Integer.valueOf(cVar.Gt)) && jv.equal(Integer.valueOf(this.axc), Integer.valueOf(cVar.axc)) && jv.equal(Boolean.valueOf(this.axd), Boolean.valueOf(cVar.axd));
    }

    public String getAddress() {
        return this.TW;
    }

    public String getName() {
        return this.mName;
    }

    public int getRole() {
        return this.axc;
    }

    public int getType() {
        return this.Gt;
    }

    public int hashCode() {
        return jv.hashCode(Integer.valueOf(this.CK), this.mName, this.TW, Integer.valueOf(this.Gt), Integer.valueOf(this.axc), Boolean.valueOf(this.axd));
    }

    public boolean isConnected() {
        return this.axe;
    }

    public boolean isEnabled() {
        return this.axd;
    }

    public String rj() {
        return this.axf;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ConnectionConfiguration[ ");
        stringBuilder.append("mName=" + this.mName);
        stringBuilder.append(", mAddress=" + this.TW);
        stringBuilder.append(", mType=" + this.Gt);
        stringBuilder.append(", mRole=" + this.axc);
        stringBuilder.append(", mEnabled=" + this.axd);
        stringBuilder.append(", mIsConnected=" + this.axe);
        stringBuilder.append(", mEnabled=" + this.axf);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        d.a(this, dest, flags);
    }
}
