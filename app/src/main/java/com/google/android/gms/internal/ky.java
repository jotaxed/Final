package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.kr.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class ky extends kr implements SafeParcelable {
    public static final kz CREATOR = new kz();
    private final int CK;
    private final kv NT;
    private final Parcel Oa;
    private final int Ob;
    private int Oc;
    private int Od;
    private final String mClassName;

    ky(int i, Parcel parcel, kv kvVar) {
        this.CK = i;
        this.Oa = (Parcel) jx.i(parcel);
        this.Ob = 2;
        this.NT = kvVar;
        if (this.NT == null) {
            this.mClassName = null;
        } else {
            this.mClassName = this.NT.ia();
        }
        this.Oc = 2;
    }

    private ky(SafeParcelable safeParcelable, kv kvVar, String str) {
        this.CK = 1;
        this.Oa = Parcel.obtain();
        safeParcelable.writeToParcel(this.Oa, 0);
        this.Ob = 1;
        this.NT = (kv) jx.i(kvVar);
        this.mClassName = (String) jx.i(str);
        this.Oc = 2;
    }

    public static <T extends kr & SafeParcelable> ky a(T t) {
        String canonicalName = t.getClass().getCanonicalName();
        return new ky((SafeParcelable) t, b((kr) t), canonicalName);
    }

    private static void a(kv kvVar, kr krVar) {
        Class cls = krVar.getClass();
        if (!kvVar.b(cls)) {
            HashMap hK = krVar.hK();
            kvVar.a(cls, krVar.hK());
            for (String str : hK.keySet()) {
                a aVar = (a) hK.get(str);
                Class hS = aVar.hS();
                if (hS != null) {
                    try {
                        a(kvVar, (kr) hS.newInstance());
                    } catch (Throwable e) {
                        throw new IllegalStateException("Could not instantiate an object of type " + aVar.hS().getCanonicalName(), e);
                    } catch (Throwable e2) {
                        throw new IllegalStateException("Could not access object of type " + aVar.hS().getCanonicalName(), e2);
                    }
                }
            }
        }
    }

    private void a(StringBuilder stringBuilder, int i, Object obj) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                stringBuilder.append(obj);
                return;
            case 7:
                stringBuilder.append("\"").append(li.bh(obj.toString())).append("\"");
                return;
            case 8:
                stringBuilder.append("\"").append(lb.d((byte[]) obj)).append("\"");
                return;
            case 9:
                stringBuilder.append("\"").append(lb.e((byte[]) obj));
                stringBuilder.append("\"");
                return;
            case 10:
                lj.a(stringBuilder, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown type = " + i);
        }
    }

    private void a(StringBuilder stringBuilder, a<?, ?> aVar, Parcel parcel, int i) {
        switch (aVar.hJ()) {
            case 0:
                b(stringBuilder, (a) aVar, a(aVar, Integer.valueOf(com.google.android.gms.common.internal.safeparcel.a.g(parcel, i))));
                return;
            case 1:
                b(stringBuilder, (a) aVar, a(aVar, com.google.android.gms.common.internal.safeparcel.a.k(parcel, i)));
                return;
            case 2:
                b(stringBuilder, (a) aVar, a(aVar, Long.valueOf(com.google.android.gms.common.internal.safeparcel.a.i(parcel, i))));
                return;
            case 3:
                b(stringBuilder, (a) aVar, a(aVar, Float.valueOf(com.google.android.gms.common.internal.safeparcel.a.l(parcel, i))));
                return;
            case 4:
                b(stringBuilder, (a) aVar, a(aVar, Double.valueOf(com.google.android.gms.common.internal.safeparcel.a.m(parcel, i))));
                return;
            case 5:
                b(stringBuilder, (a) aVar, a(aVar, com.google.android.gms.common.internal.safeparcel.a.n(parcel, i)));
                return;
            case 6:
                b(stringBuilder, (a) aVar, a(aVar, Boolean.valueOf(com.google.android.gms.common.internal.safeparcel.a.c(parcel, i))));
                return;
            case 7:
                b(stringBuilder, (a) aVar, a(aVar, com.google.android.gms.common.internal.safeparcel.a.o(parcel, i)));
                return;
            case 8:
            case 9:
                b(stringBuilder, (a) aVar, a(aVar, com.google.android.gms.common.internal.safeparcel.a.r(parcel, i)));
                return;
            case 10:
                b(stringBuilder, (a) aVar, a(aVar, g(com.google.android.gms.common.internal.safeparcel.a.q(parcel, i))));
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown field out type = " + aVar.hJ());
        }
    }

    private void a(StringBuilder stringBuilder, String str, a<?, ?> aVar, Parcel parcel, int i) {
        stringBuilder.append("\"").append(str).append("\":");
        if (aVar.hU()) {
            a(stringBuilder, aVar, parcel, i);
        } else {
            b(stringBuilder, aVar, parcel, i);
        }
    }

    private void a(StringBuilder stringBuilder, HashMap<String, a<?, ?>> hashMap, Parcel parcel) {
        HashMap b = b((HashMap) hashMap);
        stringBuilder.append('{');
        int G = com.google.android.gms.common.internal.safeparcel.a.G(parcel);
        Object obj = null;
        while (parcel.dataPosition() < G) {
            int F = com.google.android.gms.common.internal.safeparcel.a.F(parcel);
            Entry entry = (Entry) b.get(Integer.valueOf(com.google.android.gms.common.internal.safeparcel.a.aH(F)));
            if (entry != null) {
                if (obj != null) {
                    stringBuilder.append(",");
                }
                a(stringBuilder, (String) entry.getKey(), (a) entry.getValue(), parcel, F);
                obj = 1;
            }
        }
        if (parcel.dataPosition() != G) {
            throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + G, parcel);
        }
        stringBuilder.append('}');
    }

    private static kv b(kr krVar) {
        kv kvVar = new kv(krVar.getClass());
        a(kvVar, krVar);
        kvVar.hY();
        kvVar.hX();
        return kvVar;
    }

    private static HashMap<Integer, Entry<String, a<?, ?>>> b(HashMap<String, a<?, ?>> hashMap) {
        HashMap<Integer, Entry<String, a<?, ?>>> hashMap2 = new HashMap();
        for (Entry entry : hashMap.entrySet()) {
            hashMap2.put(Integer.valueOf(((a) entry.getValue()).hR()), entry);
        }
        return hashMap2;
    }

    private void b(StringBuilder stringBuilder, a<?, ?> aVar, Parcel parcel, int i) {
        if (aVar.hP()) {
            stringBuilder.append("[");
            switch (aVar.hJ()) {
                case 0:
                    la.a(stringBuilder, com.google.android.gms.common.internal.safeparcel.a.u(parcel, i));
                    break;
                case 1:
                    la.a(stringBuilder, com.google.android.gms.common.internal.safeparcel.a.w(parcel, i));
                    break;
                case 2:
                    la.a(stringBuilder, com.google.android.gms.common.internal.safeparcel.a.v(parcel, i));
                    break;
                case 3:
                    la.a(stringBuilder, com.google.android.gms.common.internal.safeparcel.a.x(parcel, i));
                    break;
                case 4:
                    la.a(stringBuilder, com.google.android.gms.common.internal.safeparcel.a.y(parcel, i));
                    break;
                case 5:
                    la.a(stringBuilder, com.google.android.gms.common.internal.safeparcel.a.z(parcel, i));
                    break;
                case 6:
                    la.a(stringBuilder, com.google.android.gms.common.internal.safeparcel.a.t(parcel, i));
                    break;
                case 7:
                    la.a(stringBuilder, com.google.android.gms.common.internal.safeparcel.a.A(parcel, i));
                    break;
                case 8:
                case 9:
                case 10:
                    throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                case 11:
                    Parcel[] E = com.google.android.gms.common.internal.safeparcel.a.E(parcel, i);
                    int length = E.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (i2 > 0) {
                            stringBuilder.append(",");
                        }
                        E[i2].setDataPosition(0);
                        a(stringBuilder, aVar.hW(), E[i2]);
                    }
                    break;
                default:
                    throw new IllegalStateException("Unknown field type out.");
            }
            stringBuilder.append("]");
            return;
        }
        switch (aVar.hJ()) {
            case 0:
                stringBuilder.append(com.google.android.gms.common.internal.safeparcel.a.g(parcel, i));
                return;
            case 1:
                stringBuilder.append(com.google.android.gms.common.internal.safeparcel.a.k(parcel, i));
                return;
            case 2:
                stringBuilder.append(com.google.android.gms.common.internal.safeparcel.a.i(parcel, i));
                return;
            case 3:
                stringBuilder.append(com.google.android.gms.common.internal.safeparcel.a.l(parcel, i));
                return;
            case 4:
                stringBuilder.append(com.google.android.gms.common.internal.safeparcel.a.m(parcel, i));
                return;
            case 5:
                stringBuilder.append(com.google.android.gms.common.internal.safeparcel.a.n(parcel, i));
                return;
            case 6:
                stringBuilder.append(com.google.android.gms.common.internal.safeparcel.a.c(parcel, i));
                return;
            case 7:
                stringBuilder.append("\"").append(li.bh(com.google.android.gms.common.internal.safeparcel.a.o(parcel, i))).append("\"");
                return;
            case 8:
                stringBuilder.append("\"").append(lb.d(com.google.android.gms.common.internal.safeparcel.a.r(parcel, i))).append("\"");
                return;
            case 9:
                stringBuilder.append("\"").append(lb.e(com.google.android.gms.common.internal.safeparcel.a.r(parcel, i)));
                stringBuilder.append("\"");
                return;
            case 10:
                Bundle q = com.google.android.gms.common.internal.safeparcel.a.q(parcel, i);
                Set<String> keySet = q.keySet();
                keySet.size();
                stringBuilder.append("{");
                int i3 = 1;
                for (String str : keySet) {
                    if (i3 == 0) {
                        stringBuilder.append(",");
                    }
                    stringBuilder.append("\"").append(str).append("\"");
                    stringBuilder.append(":");
                    stringBuilder.append("\"").append(li.bh(q.getString(str))).append("\"");
                    i3 = 0;
                }
                stringBuilder.append("}");
                return;
            case 11:
                Parcel D = com.google.android.gms.common.internal.safeparcel.a.D(parcel, i);
                D.setDataPosition(0);
                a(stringBuilder, aVar.hW(), D);
                return;
            default:
                throw new IllegalStateException("Unknown field type out");
        }
    }

    private void b(StringBuilder stringBuilder, a<?, ?> aVar, Object obj) {
        if (aVar.hO()) {
            b(stringBuilder, (a) aVar, (ArrayList) obj);
        } else {
            a(stringBuilder, aVar.hI(), obj);
        }
    }

    private void b(StringBuilder stringBuilder, a<?, ?> aVar, ArrayList<?> arrayList) {
        stringBuilder.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            a(stringBuilder, aVar.hI(), arrayList.get(i));
        }
        stringBuilder.append("]");
    }

    public static HashMap<String, String> g(Bundle bundle) {
        HashMap<String, String> hashMap = new HashMap();
        for (String str : bundle.keySet()) {
            hashMap.put(str, bundle.getString(str));
        }
        return hashMap;
    }

    protected Object bc(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    protected boolean bd(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public int describeContents() {
        kz kzVar = CREATOR;
        return 0;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public HashMap<String, a<?, ?>> hK() {
        return this.NT == null ? null : this.NT.bg(this.mClassName);
    }

    public Parcel ic() {
        switch (this.Oc) {
            case 0:
                this.Od = b.H(this.Oa);
                b.H(this.Oa, this.Od);
                this.Oc = 2;
                break;
            case 1:
                b.H(this.Oa, this.Od);
                this.Oc = 2;
                break;
        }
        return this.Oa;
    }

    kv id() {
        switch (this.Ob) {
            case 0:
                return null;
            case 1:
                return this.NT;
            case 2:
                return this.NT;
            default:
                throw new IllegalStateException("Invalid creation type: " + this.Ob);
        }
    }

    public String toString() {
        jx.b(this.NT, (Object) "Cannot convert to JSON on client side.");
        Parcel ic = ic();
        ic.setDataPosition(0);
        StringBuilder stringBuilder = new StringBuilder(100);
        a(stringBuilder, this.NT.bg(this.mClassName), ic);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        kz kzVar = CREATOR;
        kz.a(this, out, flags);
    }
}
