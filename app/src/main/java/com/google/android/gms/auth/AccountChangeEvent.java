package com.google.android.gms.auth;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;

public class AccountChangeEvent implements SafeParcelable {
    public static final AccountChangeEventCreator CREATOR = new AccountChangeEventCreator();
    final String DZ;
    final int Ef;
    final long Eg;
    final int Eh;
    final int Ei;
    final String Ej;

    AccountChangeEvent(int version, long id, String accountName, int changeType, int eventIndex, String changeData) {
        this.Ef = version;
        this.Eg = id;
        this.DZ = (String) jx.i(accountName);
        this.Eh = changeType;
        this.Ei = eventIndex;
        this.Ej = changeData;
    }

    public AccountChangeEvent(long id, String accountName, int changeType, int eventIndex, String changeData) {
        this.Ef = 1;
        this.Eg = id;
        this.DZ = (String) jx.i(accountName);
        this.Eh = changeType;
        this.Ei = eventIndex;
        this.Ej = changeData;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        if (that == this) {
            return true;
        }
        if (!(that instanceof AccountChangeEvent)) {
            return false;
        }
        AccountChangeEvent accountChangeEvent = (AccountChangeEvent) that;
        return this.Ef == accountChangeEvent.Ef && this.Eg == accountChangeEvent.Eg && jv.equal(this.DZ, accountChangeEvent.DZ) && this.Eh == accountChangeEvent.Eh && this.Ei == accountChangeEvent.Ei && jv.equal(this.Ej, accountChangeEvent.Ej);
    }

    public String getAccountName() {
        return this.DZ;
    }

    public String getChangeData() {
        return this.Ej;
    }

    public int getChangeType() {
        return this.Eh;
    }

    public int getEventIndex() {
        return this.Ei;
    }

    public int hashCode() {
        return jv.hashCode(Integer.valueOf(this.Ef), Long.valueOf(this.Eg), this.DZ, Integer.valueOf(this.Eh), Integer.valueOf(this.Ei), this.Ej);
    }

    public String toString() {
        String str = "UNKNOWN";
        switch (this.Eh) {
            case 1:
                str = "ADDED";
                break;
            case 2:
                str = "REMOVED";
                break;
            case 3:
                str = "RENAMED_FROM";
                break;
            case 4:
                str = "RENAMED_TO";
                break;
        }
        return "AccountChangeEvent {accountName = " + this.DZ + ", changeType = " + str + ", changeData = " + this.Ej + ", eventIndex = " + this.Ei + "}";
    }

    public void writeToParcel(Parcel dest, int flags) {
        AccountChangeEventCreator.a(this, dest, flags);
    }
}
