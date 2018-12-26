package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class hp implements SafeParcelable {
    public static final hq CREATOR = new hq();
    final int CK;
    public final String Dh;
    public final boolean Di;
    public final boolean Dj;
    public final String Dk;
    public final hj[] Dl;
    final int[] Dm;
    public final String Dn;
    public final String name;
    public final int weight;

    public static final class a {
        private String Do;
        private boolean Dp;
        private int Dq = 1;
        private boolean Dr;
        private String Ds;
        private final List<hj> Dt = new ArrayList();
        private BitSet Du;
        private String Dv;
        private final String mName;

        public a(String str) {
            this.mName = str;
        }

        public a G(boolean z) {
            this.Dp = z;
            return this;
        }

        public a H(boolean z) {
            this.Dr = z;
            return this;
        }

        public a Q(int i) {
            if (this.Du == null) {
                this.Du = new BitSet();
            }
            this.Du.set(i);
            return this;
        }

        public a at(String str) {
            this.Do = str;
            return this;
        }

        public a au(String str) {
            this.Dv = str;
            return this;
        }

        public hp fG() {
            int i = 0;
            int[] iArr = null;
            if (this.Du != null) {
                iArr = new int[this.Du.cardinality()];
                int nextSetBit = this.Du.nextSetBit(0);
                while (nextSetBit >= 0) {
                    int i2 = i + 1;
                    iArr[i] = nextSetBit;
                    nextSetBit = this.Du.nextSetBit(nextSetBit + 1);
                    i = i2;
                }
            }
            return new hp(this.mName, this.Do, this.Dp, this.Dq, this.Dr, this.Ds, (hj[]) this.Dt.toArray(new hj[this.Dt.size()]), iArr, this.Dv);
        }
    }

    hp(int i, String str, String str2, boolean z, int i2, boolean z2, String str3, hj[] hjVarArr, int[] iArr, String str4) {
        this.CK = i;
        this.name = str;
        this.Dh = str2;
        this.Di = z;
        this.weight = i2;
        this.Dj = z2;
        this.Dk = str3;
        this.Dl = hjVarArr;
        this.Dm = iArr;
        this.Dn = str4;
    }

    hp(String str, String str2, boolean z, int i, boolean z2, String str3, hj[] hjVarArr, int[] iArr, String str4) {
        this(2, str, str2, z, i, z2, str3, hjVarArr, iArr, str4);
    }

    public int describeContents() {
        hq hqVar = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (!(object instanceof hp)) {
            return false;
        }
        hp hpVar = (hp) object;
        return this.name.equals(hpVar.name) && this.Dh.equals(hpVar.Dh) && this.Di == hpVar.Di;
    }

    public void writeToParcel(Parcel out, int flags) {
        hq hqVar = CREATOR;
        hq.a(this, out, flags);
    }
}
