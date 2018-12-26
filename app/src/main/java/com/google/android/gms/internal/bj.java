package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@ey
public final class bj implements SafeParcelable {
    public static final bk CREATOR = new bk();
    public final int backgroundColor;
    public final int oQ;
    public final int oR;
    public final int oS;
    public final int oT;
    public final int oU;
    public final int oV;
    public final int oW;
    public final String oX;
    public final int oY;
    public final String oZ;
    public final int pa;
    public final int pb;
    public final String pc;
    public final int versionCode;

    bj(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, String str, int i10, String str2, int i11, int i12, String str3) {
        this.versionCode = i;
        this.oQ = i2;
        this.backgroundColor = i3;
        this.oR = i4;
        this.oS = i5;
        this.oT = i6;
        this.oU = i7;
        this.oV = i8;
        this.oW = i9;
        this.oX = str;
        this.oY = i10;
        this.oZ = str2;
        this.pa = i11;
        this.pb = i12;
        this.pc = str3;
    }

    public bj(SearchAdRequest searchAdRequest) {
        this.versionCode = 1;
        this.oQ = searchAdRequest.getAnchorTextColor();
        this.backgroundColor = searchAdRequest.getBackgroundColor();
        this.oR = searchAdRequest.getBackgroundGradientBottom();
        this.oS = searchAdRequest.getBackgroundGradientTop();
        this.oT = searchAdRequest.getBorderColor();
        this.oU = searchAdRequest.getBorderThickness();
        this.oV = searchAdRequest.getBorderType();
        this.oW = searchAdRequest.getCallButtonColor();
        this.oX = searchAdRequest.getCustomChannels();
        this.oY = searchAdRequest.getDescriptionTextColor();
        this.oZ = searchAdRequest.getFontFace();
        this.pa = searchAdRequest.getHeaderTextColor();
        this.pb = searchAdRequest.getHeaderTextSize();
        this.pc = searchAdRequest.getQuery();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        bk.a(this, out, flags);
    }
}
