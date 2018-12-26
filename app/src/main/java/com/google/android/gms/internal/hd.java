package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class hd implements SafeParcelable {
    public static final he CREATOR = new he();
    final int CK;
    final hh[] CL;
    public final String CM;
    public final boolean CN;
    public final Account account;

    public static class a {
        private List<hh> CO;
        private String CP;
        private boolean CQ;
        private Account CR;

        public a F(boolean z) {
            this.CQ = z;
            return this;
        }

        public a a(hh hhVar) {
            if (this.CO == null) {
                this.CO = new ArrayList();
            }
            this.CO.add(hhVar);
            return this;
        }

        public a ar(String str) {
            this.CP = str;
            return this;
        }

        public hd fD() {
            return new hd(this.CP, this.CQ, this.CR, this.CO != null ? (hh[]) this.CO.toArray(new hh[this.CO.size()]) : null);
        }
    }

    hd(int i, hh[] hhVarArr, String str, boolean z, Account account) {
        this.CK = i;
        this.CL = hhVarArr;
        this.CM = str;
        this.CN = z;
        this.account = account;
    }

    hd(String str, boolean z, Account account, hh... hhVarArr) {
        this(1, hhVarArr, str, z, account);
        BitSet bitSet = new BitSet(ho.fF());
        for (hh hhVar : hhVarArr) {
            int i = hhVar.CZ;
            if (i != -1) {
                if (bitSet.get(i)) {
                    throw new IllegalArgumentException("Duplicate global search section type " + ho.P(i));
                }
                bitSet.set(i);
            }
        }
    }

    public int describeContents() {
        he heVar = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        he heVar = CREATOR;
        he.a(this, dest, flags);
    }
}
