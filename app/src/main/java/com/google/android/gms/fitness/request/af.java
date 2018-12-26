package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;

public class af implements SafeParcelable {
    public static final Creator<af> CREATOR = new ag();
    private final int CK;
    private final Subscription Wo;
    private final boolean Wp;

    public static class a {
        private Subscription Wo;
        private boolean Wp = false;

        public a b(Subscription subscription) {
            this.Wo = subscription;
            return this;
        }

        public af kp() {
            jx.a(this.Wo != null, "Must call setSubscription()");
            return new af();
        }
    }

    af(int i, Subscription subscription, boolean z) {
        this.CK = i;
        this.Wo = subscription;
        this.Wp = z;
    }

    private af(a aVar) {
        this.CK = 1;
        this.Wo = aVar.Wo;
        this.Wp = aVar.Wp;
    }

    public int describeContents() {
        return 0;
    }

    int getVersionCode() {
        return this.CK;
    }

    public Subscription kn() {
        return this.Wo;
    }

    public boolean ko() {
        return this.Wp;
    }

    public String toString() {
        return jv.h(this).a("subscription", this.Wo).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        ag.a(this, dest, flags);
    }
}
