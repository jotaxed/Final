package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class hl {

    public static class a implements SafeParcelable {
        public static final hm CREATOR = new hm();
        final int CK;
        public final Account Dc;

        public a() {
            this(null);
        }

        a(int i, Account account) {
            this.CK = i;
            this.Dc = account;
        }

        public a(Account account) {
            this(1, account);
        }

        public int describeContents() {
            hm hmVar = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            hm hmVar = CREATOR;
            hm.a(this, out, flags);
        }
    }

    public static class b implements Result, SafeParcelable {
        public static final hn CREATOR = new hn();
        final int CK;
        public Status Dd;
        public List<hr> De;

        public b() {
            this.CK = 1;
        }

        b(int i, Status status, List<hr> list) {
            this.CK = i;
            this.Dd = status;
            this.De = list;
        }

        public int describeContents() {
            hn hnVar = CREATOR;
            return 0;
        }

        public Status getStatus() {
            return this.Dd;
        }

        public void writeToParcel(Parcel out, int flags) {
            hn hnVar = CREATOR;
            hn.a(this, out, flags);
        }
    }
}
