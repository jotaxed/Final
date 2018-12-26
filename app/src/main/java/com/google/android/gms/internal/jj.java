package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class jj implements SafeParcelable {
    public static final Creator<jj> CREATOR = new jk();
    final int MD;
    int ME;
    String MF;
    IBinder MG;
    Scope[] MH;
    Bundle MI;
    final int version;

    public jj(int i) {
        this.version = 1;
        this.ME = GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        this.MD = i;
    }

    jj(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle) {
        this.version = i;
        this.MD = i2;
        this.ME = i3;
        this.MF = str;
        this.MG = iBinder;
        this.MH = scopeArr;
        this.MI = bundle;
    }

    public jj a(jq jqVar) {
        if (jqVar != null) {
            this.MG = jqVar.asBinder();
        }
        return this;
    }

    public jj a(Scope[] scopeArr) {
        this.MH = scopeArr;
        return this;
    }

    public jj aX(String str) {
        this.MF = str;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public jj e(Bundle bundle) {
        this.MI = bundle;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        jk.a(this, dest, flags);
    }
}
