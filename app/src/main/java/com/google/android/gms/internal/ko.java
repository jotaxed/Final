package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.kr.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class ko implements SafeParcelable, b<String, Integer> {
    public static final kp CREATOR = new kp();
    private final int CK;
    private final HashMap<String, Integer> NG;
    private final HashMap<Integer, String> NH;
    private final ArrayList<a> NI;

    public static final class a implements SafeParcelable {
        public static final kq CREATOR = new kq();
        final String NJ;
        final int NK;
        final int versionCode;

        a(int i, String str, int i2) {
            this.versionCode = i;
            this.NJ = str;
            this.NK = i2;
        }

        a(String str, int i) {
            this.versionCode = 1;
            this.NJ = str;
            this.NK = i;
        }

        public int describeContents() {
            kq kqVar = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            kq kqVar = CREATOR;
            kq.a(this, out, flags);
        }
    }

    public ko() {
        this.CK = 1;
        this.NG = new HashMap();
        this.NH = new HashMap();
        this.NI = null;
    }

    ko(int i, ArrayList<a> arrayList) {
        this.CK = i;
        this.NG = new HashMap();
        this.NH = new HashMap();
        this.NI = null;
        b(arrayList);
    }

    private void b(ArrayList<a> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            h(aVar.NJ, aVar.NK);
        }
    }

    public String a(Integer num) {
        String str = (String) this.NH.get(num);
        return (str == null && this.NG.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    public /* synthetic */ Object convertBack(Object x0) {
        return a((Integer) x0);
    }

    public int describeContents() {
        kp kpVar = CREATOR;
        return 0;
    }

    int getVersionCode() {
        return this.CK;
    }

    public ko h(String str, int i) {
        this.NG.put(str, Integer.valueOf(i));
        this.NH.put(Integer.valueOf(i), str);
        return this;
    }

    ArrayList<a> hH() {
        ArrayList<a> arrayList = new ArrayList();
        for (String str : this.NG.keySet()) {
            arrayList.add(new a(str, ((Integer) this.NG.get(str)).intValue()));
        }
        return arrayList;
    }

    public int hI() {
        return 7;
    }

    public int hJ() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        kp kpVar = CREATOR;
        kp.a(this, out, flags);
    }
}
