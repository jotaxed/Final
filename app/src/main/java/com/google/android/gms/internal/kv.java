package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;

public class kv implements SafeParcelable {
    public static final kw CREATOR = new kw();
    private final int CK;
    private final HashMap<String, HashMap<String, com.google.android.gms.internal.kr.a<?, ?>>> NV;
    private final ArrayList<a> NW;
    private final String NX;

    public static class a implements SafeParcelable {
        public static final kx CREATOR = new kx();
        final ArrayList<b> NY;
        final String className;
        final int versionCode;

        a(int i, String str, ArrayList<b> arrayList) {
            this.versionCode = i;
            this.className = str;
            this.NY = arrayList;
        }

        a(String str, HashMap<String, com.google.android.gms.internal.kr.a<?, ?>> hashMap) {
            this.versionCode = 1;
            this.className = str;
            this.NY = a(hashMap);
        }

        private static ArrayList<b> a(HashMap<String, com.google.android.gms.internal.kr.a<?, ?>> hashMap) {
            if (hashMap == null) {
                return null;
            }
            ArrayList<b> arrayList = new ArrayList();
            for (String str : hashMap.keySet()) {
                arrayList.add(new b(str, (com.google.android.gms.internal.kr.a) hashMap.get(str)));
            }
            return arrayList;
        }

        public int describeContents() {
            kx kxVar = CREATOR;
            return 0;
        }

        HashMap<String, com.google.android.gms.internal.kr.a<?, ?>> ib() {
            HashMap<String, com.google.android.gms.internal.kr.a<?, ?>> hashMap = new HashMap();
            int size = this.NY.size();
            for (int i = 0; i < size; i++) {
                b bVar = (b) this.NY.get(i);
                hashMap.put(bVar.fv, bVar.NZ);
            }
            return hashMap;
        }

        public void writeToParcel(Parcel out, int flags) {
            kx kxVar = CREATOR;
            kx.a(this, out, flags);
        }
    }

    public static class b implements SafeParcelable {
        public static final ku CREATOR = new ku();
        final com.google.android.gms.internal.kr.a<?, ?> NZ;
        final String fv;
        final int versionCode;

        b(int i, String str, com.google.android.gms.internal.kr.a<?, ?> aVar) {
            this.versionCode = i;
            this.fv = str;
            this.NZ = aVar;
        }

        b(String str, com.google.android.gms.internal.kr.a<?, ?> aVar) {
            this.versionCode = 1;
            this.fv = str;
            this.NZ = aVar;
        }

        public int describeContents() {
            ku kuVar = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            ku kuVar = CREATOR;
            ku.a(this, out, flags);
        }
    }

    kv(int i, ArrayList<a> arrayList, String str) {
        this.CK = i;
        this.NW = null;
        this.NV = c(arrayList);
        this.NX = (String) jx.i(str);
        hX();
    }

    public kv(Class<? extends kr> cls) {
        this.CK = 1;
        this.NW = null;
        this.NV = new HashMap();
        this.NX = cls.getCanonicalName();
    }

    private static HashMap<String, HashMap<String, com.google.android.gms.internal.kr.a<?, ?>>> c(ArrayList<a> arrayList) {
        HashMap<String, HashMap<String, com.google.android.gms.internal.kr.a<?, ?>>> hashMap = new HashMap();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            a aVar = (a) arrayList.get(i);
            hashMap.put(aVar.className, aVar.ib());
        }
        return hashMap;
    }

    public void a(Class<? extends kr> cls, HashMap<String, com.google.android.gms.internal.kr.a<?, ?>> hashMap) {
        this.NV.put(cls.getCanonicalName(), hashMap);
    }

    public boolean b(Class<? extends kr> cls) {
        return this.NV.containsKey(cls.getCanonicalName());
    }

    public HashMap<String, com.google.android.gms.internal.kr.a<?, ?>> bg(String str) {
        return (HashMap) this.NV.get(str);
    }

    public int describeContents() {
        kw kwVar = CREATOR;
        return 0;
    }

    int getVersionCode() {
        return this.CK;
    }

    public void hX() {
        for (String str : this.NV.keySet()) {
            HashMap hashMap = (HashMap) this.NV.get(str);
            for (String str2 : hashMap.keySet()) {
                ((com.google.android.gms.internal.kr.a) hashMap.get(str2)).a(this);
            }
        }
    }

    public void hY() {
        for (String str : this.NV.keySet()) {
            HashMap hashMap = (HashMap) this.NV.get(str);
            HashMap hashMap2 = new HashMap();
            for (String str2 : hashMap.keySet()) {
                hashMap2.put(str2, ((com.google.android.gms.internal.kr.a) hashMap.get(str2)).hN());
            }
            this.NV.put(str, hashMap2);
        }
    }

    ArrayList<a> hZ() {
        ArrayList<a> arrayList = new ArrayList();
        for (String str : this.NV.keySet()) {
            arrayList.add(new a(str, (HashMap) this.NV.get(str)));
        }
        return arrayList;
    }

    public String ia() {
        return this.NX;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : this.NV.keySet()) {
            stringBuilder.append(str).append(":\n");
            HashMap hashMap = (HashMap) this.NV.get(str);
            for (String str2 : hashMap.keySet()) {
                stringBuilder.append("  ").append(str2).append(": ");
                stringBuilder.append(hashMap.get(str2));
            }
        }
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        kw kwVar = CREATOR;
        kw.a(this, out, flags);
    }
}
