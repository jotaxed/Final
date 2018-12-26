package com.google.android.gms.auth;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AccountChangeEventsRequest implements SafeParcelable {
    public static final AccountChangeEventsRequestCreator CREATOR = new AccountChangeEventsRequestCreator();
    String DZ;
    final int Ef;
    int Ei;

    public AccountChangeEventsRequest() {
        this.Ef = 1;
    }

    AccountChangeEventsRequest(int version, int eventIndex, String accountName) {
        this.Ef = version;
        this.Ei = eventIndex;
        this.DZ = accountName;
    }

    public int describeContents() {
        return 0;
    }

    public String getAccountName() {
        return this.DZ;
    }

    public int getEventIndex() {
        return this.Ei;
    }

    public AccountChangeEventsRequest setAccountName(String accountName) {
        this.DZ = accountName;
        return this;
    }

    public AccountChangeEventsRequest setEventIndex(int eventIndex) {
        this.Ei = eventIndex;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        AccountChangeEventsRequestCreator.a(this, dest, flags);
    }
}
