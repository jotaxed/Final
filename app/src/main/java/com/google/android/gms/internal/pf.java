package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.internal.kr.a;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public final class pf extends ks implements Moment {
    public static final pg CREATOR = new pg();
    private static final HashMap<String, a<?, ?>> aom = new HashMap();
    String CE;
    final int CK;
    final Set<Integer> aon;
    String apa;
    pd api;
    pd apj;
    String vc;

    static {
        aom.put("id", a.l("id", 2));
        aom.put("result", a.a("result", 4, pd.class));
        aom.put("startDate", a.l("startDate", 5));
        aom.put("target", a.a("target", 6, pd.class));
        aom.put("type", a.l("type", 7));
    }

    public pf() {
        this.CK = 1;
        this.aon = new HashSet();
    }

    pf(Set<Integer> set, int i, String str, pd pdVar, String str2, pd pdVar2, String str3) {
        this.aon = set;
        this.CK = i;
        this.CE = str;
        this.api = pdVar;
        this.apa = str2;
        this.apj = pdVar2;
        this.vc = str3;
    }

    public pf(Set<Integer> set, String str, pd pdVar, String str2, pd pdVar2, String str3) {
        this.aon = set;
        this.CK = 1;
        this.CE = str;
        this.api = pdVar;
        this.apa = str2;
        this.apj = pdVar2;
        this.vc = str3;
    }

    protected boolean a(a aVar) {
        return this.aon.contains(Integer.valueOf(aVar.hR()));
    }

    protected Object b(a aVar) {
        switch (aVar.hR()) {
            case 2:
                return this.CE;
            case 4:
                return this.api;
            case 5:
                return this.apa;
            case 6:
                return this.apj;
            case 7:
                return this.vc;
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + aVar.hR());
        }
    }

    public int describeContents() {
        pg pgVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof pf)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        pf pfVar = (pf) obj;
        for (a aVar : aom.values()) {
            if (a(aVar)) {
                if (!pfVar.a(aVar)) {
                    return false;
                }
                if (!b(aVar).equals(pfVar.b(aVar))) {
                    return false;
                }
            } else if (pfVar.a(aVar)) {
                return false;
            }
        }
        return true;
    }

    public /* synthetic */ Object freeze() {
        return oJ();
    }

    public String getId() {
        return this.CE;
    }

    public ItemScope getResult() {
        return this.api;
    }

    public String getStartDate() {
        return this.apa;
    }

    public ItemScope getTarget() {
        return this.apj;
    }

    public String getType() {
        return this.vc;
    }

    public HashMap<String, a<?, ?>> hK() {
        return aom;
    }

    public boolean hasId() {
        return this.aon.contains(Integer.valueOf(2));
    }

    public boolean hasResult() {
        return this.aon.contains(Integer.valueOf(4));
    }

    public boolean hasStartDate() {
        return this.aon.contains(Integer.valueOf(5));
    }

    public boolean hasTarget() {
        return this.aon.contains(Integer.valueOf(6));
    }

    public boolean hasType() {
        return this.aon.contains(Integer.valueOf(7));
    }

    public int hashCode() {
        int i = 0;
        for (a aVar : aom.values()) {
            int hashCode;
            if (a(aVar)) {
                hashCode = b(aVar).hashCode() + (i + aVar.hR());
            } else {
                hashCode = i;
            }
            i = hashCode;
        }
        return i;
    }

    public boolean isDataValid() {
        return true;
    }

    public pf oJ() {
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        pg pgVar = CREATOR;
        pg.a(this, out, flags);
    }
}
