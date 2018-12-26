package com.google.android.gms.auth;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jx;
import java.util.List;

public class AccountChangeEventsResponse implements SafeParcelable {
    public static final AccountChangeEventsResponseCreator CREATOR = new AccountChangeEventsResponseCreator();
    final int Ef;
    final List<AccountChangeEvent> mp;

    AccountChangeEventsResponse(int version, List<AccountChangeEvent> events) {
        this.Ef = version;
        this.mp = (List) jx.i(events);
    }

    public AccountChangeEventsResponse(List<AccountChangeEvent> events) {
        this.Ef = 1;
        this.mp = (List) jx.i(events);
    }

    public int describeContents() {
        return 0;
    }

    public List<AccountChangeEvent> getEvents() {
        return this.mp;
    }

    public void writeToParcel(Parcel dest, int flags) {
        AccountChangeEventsResponseCreator.a(this, dest, flags);
    }
}
