package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.Node;

public class al implements SafeParcelable, Node {
    public static final Creator<al> CREATOR = new am();
    private final String CE;
    final int CK;
    private final String OS;

    al(int i, String str, String str2) {
        this.CK = i;
        this.CE = str;
        this.OS = str2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (!(o instanceof al)) {
            return false;
        }
        al alVar = (al) o;
        return alVar.CE.equals(this.CE) && alVar.OS.equals(this.OS);
    }

    public String getDisplayName() {
        return this.OS;
    }

    public String getId() {
        return this.CE;
    }

    public int hashCode() {
        return ((this.CE.hashCode() + 629) * 37) + this.OS.hashCode();
    }

    public String toString() {
        return "NodeParcelable{" + this.CE + "," + this.OS + "}";
    }

    public void writeToParcel(Parcel dest, int flags) {
        am.a(this, dest, flags);
    }
}
