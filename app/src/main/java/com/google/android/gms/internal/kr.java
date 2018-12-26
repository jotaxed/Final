package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class kr {

    public interface b<I, O> {
        I convertBack(O o);

        int hI();

        int hJ();
    }

    public static class a<I, O> implements SafeParcelable {
        public static final kt CREATOR = new kt();
        private final int CK;
        protected final int NL;
        protected final boolean NM;
        protected final int NN;
        protected final boolean NO;
        protected final String NP;
        protected final int NQ;
        protected final Class<? extends kr> NR;
        protected final String NS;
        private kv NT;
        private b<I, O> NU;

        a(int i, int i2, boolean z, int i3, boolean z2, String str, int i4, String str2, km kmVar) {
            this.CK = i;
            this.NL = i2;
            this.NM = z;
            this.NN = i3;
            this.NO = z2;
            this.NP = str;
            this.NQ = i4;
            if (str2 == null) {
                this.NR = null;
                this.NS = null;
            } else {
                this.NR = ky.class;
                this.NS = str2;
            }
            if (kmVar == null) {
                this.NU = null;
            } else {
                this.NU = kmVar.hG();
            }
        }

        protected a(int i, boolean z, int i2, boolean z2, String str, int i3, Class<? extends kr> cls, b<I, O> bVar) {
            this.CK = 1;
            this.NL = i;
            this.NM = z;
            this.NN = i2;
            this.NO = z2;
            this.NP = str;
            this.NQ = i3;
            this.NR = cls;
            if (cls == null) {
                this.NS = null;
            } else {
                this.NS = cls.getCanonicalName();
            }
            this.NU = bVar;
        }

        public static a a(String str, int i, b<?, ?> bVar, boolean z) {
            return new a(bVar.hI(), z, bVar.hJ(), false, str, i, null, bVar);
        }

        public static <T extends kr> a<T, T> a(String str, int i, Class<T> cls) {
            return new a(11, false, 11, false, str, i, cls, null);
        }

        public static <T extends kr> a<ArrayList<T>, ArrayList<T>> b(String str, int i, Class<T> cls) {
            return new a(11, true, 11, true, str, i, cls, null);
        }

        public static a<Integer, Integer> i(String str, int i) {
            return new a(0, false, 0, false, str, i, null, null);
        }

        public static a<Double, Double> j(String str, int i) {
            return new a(4, false, 4, false, str, i, null, null);
        }

        public static a<Boolean, Boolean> k(String str, int i) {
            return new a(6, false, 6, false, str, i, null, null);
        }

        public static a<String, String> l(String str, int i) {
            return new a(7, false, 7, false, str, i, null, null);
        }

        public static a<ArrayList<String>, ArrayList<String>> m(String str, int i) {
            return new a(7, true, 7, true, str, i, null, null);
        }

        public void a(kv kvVar) {
            this.NT = kvVar;
        }

        public I convertBack(O output) {
            return this.NU.convertBack(output);
        }

        public int describeContents() {
            kt ktVar = CREATOR;
            return 0;
        }

        public int getVersionCode() {
            return this.CK;
        }

        public int hI() {
            return this.NL;
        }

        public int hJ() {
            return this.NN;
        }

        public a<I, O> hN() {
            return new a(this.CK, this.NL, this.NM, this.NN, this.NO, this.NP, this.NQ, this.NS, hV());
        }

        public boolean hO() {
            return this.NM;
        }

        public boolean hP() {
            return this.NO;
        }

        public String hQ() {
            return this.NP;
        }

        public int hR() {
            return this.NQ;
        }

        public Class<? extends kr> hS() {
            return this.NR;
        }

        String hT() {
            return this.NS == null ? null : this.NS;
        }

        public boolean hU() {
            return this.NU != null;
        }

        km hV() {
            return this.NU == null ? null : km.a(this.NU);
        }

        public HashMap<String, a<?, ?>> hW() {
            jx.i(this.NS);
            jx.i(this.NT);
            return this.NT.bg(this.NS);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Field\n");
            stringBuilder.append("            versionCode=").append(this.CK).append('\n');
            stringBuilder.append("                 typeIn=").append(this.NL).append('\n');
            stringBuilder.append("            typeInArray=").append(this.NM).append('\n');
            stringBuilder.append("                typeOut=").append(this.NN).append('\n');
            stringBuilder.append("           typeOutArray=").append(this.NO).append('\n');
            stringBuilder.append("        outputFieldName=").append(this.NP).append('\n');
            stringBuilder.append("      safeParcelFieldId=").append(this.NQ).append('\n');
            stringBuilder.append("       concreteTypeName=").append(hT()).append('\n');
            if (hS() != null) {
                stringBuilder.append("     concreteType.class=").append(hS().getCanonicalName()).append('\n');
            }
            stringBuilder.append("          converterName=").append(this.NU == null ? "null" : this.NU.getClass().getCanonicalName()).append('\n');
            return stringBuilder.toString();
        }

        public void writeToParcel(Parcel out, int flags) {
            kt ktVar = CREATOR;
            kt.a(this, out, flags);
        }
    }

    private void a(StringBuilder stringBuilder, a aVar, Object obj) {
        if (aVar.hI() == 11) {
            stringBuilder.append(((kr) aVar.hS().cast(obj)).toString());
        } else if (aVar.hI() == 7) {
            stringBuilder.append("\"");
            stringBuilder.append(li.bh((String) obj));
            stringBuilder.append("\"");
        } else {
            stringBuilder.append(obj);
        }
    }

    private void a(StringBuilder stringBuilder, a aVar, ArrayList<Object> arrayList) {
        stringBuilder.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                stringBuilder.append(",");
            }
            Object obj = arrayList.get(i);
            if (obj != null) {
                a(stringBuilder, aVar, obj);
            }
        }
        stringBuilder.append("]");
    }

    protected <O, I> I a(a<I, O> aVar, Object obj) {
        return aVar.NU != null ? aVar.convertBack(obj) : obj;
    }

    protected boolean a(a aVar) {
        return aVar.hJ() == 11 ? aVar.hP() ? bf(aVar.hQ()) : be(aVar.hQ()) : bd(aVar.hQ());
    }

    protected Object b(a aVar) {
        String hQ = aVar.hQ();
        if (aVar.hS() == null) {
            return bc(aVar.hQ());
        }
        jx.a(bc(aVar.hQ()) == null, "Concrete field shouldn't be value object: %s", aVar.hQ());
        Map hM = aVar.hP() ? hM() : hL();
        if (hM != null) {
            return hM.get(hQ);
        }
        try {
            return getClass().getMethod("get" + Character.toUpperCase(hQ.charAt(0)) + hQ.substring(1), new Class[0]).invoke(this, new Object[0]);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    protected abstract Object bc(String str);

    protected abstract boolean bd(String str);

    protected boolean be(String str) {
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    protected boolean bf(String str) {
        throw new UnsupportedOperationException("Concrete type arrays not supported");
    }

    public abstract HashMap<String, a<?, ?>> hK();

    public HashMap<String, Object> hL() {
        return null;
    }

    public HashMap<String, Object> hM() {
        return null;
    }

    public String toString() {
        HashMap hK = hK();
        StringBuilder stringBuilder = new StringBuilder(100);
        for (String str : hK.keySet()) {
            a aVar = (a) hK.get(str);
            if (a(aVar)) {
                Object a = a(aVar, b(aVar));
                if (stringBuilder.length() == 0) {
                    stringBuilder.append("{");
                } else {
                    stringBuilder.append(",");
                }
                stringBuilder.append("\"").append(str).append("\":");
                if (a != null) {
                    switch (aVar.hJ()) {
                        case 8:
                            stringBuilder.append("\"").append(lb.d((byte[]) a)).append("\"");
                            break;
                        case 9:
                            stringBuilder.append("\"").append(lb.e((byte[]) a)).append("\"");
                            break;
                        case 10:
                            lj.a(stringBuilder, (HashMap) a);
                            break;
                        default:
                            if (!aVar.hO()) {
                                a(stringBuilder, aVar, a);
                                break;
                            }
                            a(stringBuilder, aVar, (ArrayList) a);
                            break;
                    }
                }
                stringBuilder.append("null");
            }
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.append("}");
        } else {
            stringBuilder.append("{}");
        }
        return stringBuilder.toString();
    }
}
