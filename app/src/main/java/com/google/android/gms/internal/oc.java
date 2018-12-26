package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

public class oc implements SafeParcelable {
    public static final Creator<oc> CREATOR = new od();
    final int CK;
    private final String TW;
    private final LatLng ajX;
    private final List<oa> ajY;
    private final String ajZ;
    private final String aka;
    private final String mName;

    oc(int i, String str, LatLng latLng, String str2, List<oa> list, String str3, String str4) {
        this.CK = i;
        this.mName = str;
        this.ajX = latLng;
        this.TW = str2;
        this.ajY = new ArrayList(list);
        this.ajZ = str3;
        this.aka = str4;
    }

    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.TW;
    }

    public String getName() {
        return this.mName;
    }

    public String getPhoneNumber() {
        return this.ajZ;
    }

    public LatLng nx() {
        return this.ajX;
    }

    public List<oa> ny() {
        return this.ajY;
    }

    public String nz() {
        return this.aka;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        od.a(this, parcel, flags);
    }
}
