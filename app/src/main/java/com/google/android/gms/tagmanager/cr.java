package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.c.h;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class cr {

    public static class a {
        private final Map<String, com.google.android.gms.internal.d.a> asM;
        private final com.google.android.gms.internal.d.a asN;

        private a(Map<String, com.google.android.gms.internal.d.a> map, com.google.android.gms.internal.d.a aVar) {
            this.asM = map;
            this.asN = aVar;
        }

        public static b qk() {
            return new b();
        }

        public void a(String str, com.google.android.gms.internal.d.a aVar) {
            this.asM.put(str, aVar);
        }

        public Map<String, com.google.android.gms.internal.d.a> ql() {
            return Collections.unmodifiableMap(this.asM);
        }

        public com.google.android.gms.internal.d.a qm() {
            return this.asN;
        }

        public String toString() {
            return "Properties: " + ql() + " pushAfterEvaluate: " + this.asN;
        }
    }

    public static class b {
        private final Map<String, com.google.android.gms.internal.d.a> asM;
        private com.google.android.gms.internal.d.a asN;

        private b() {
            this.asM = new HashMap();
        }

        public b b(String str, com.google.android.gms.internal.d.a aVar) {
            this.asM.put(str, aVar);
            return this;
        }

        public b i(com.google.android.gms.internal.d.a aVar) {
            this.asN = aVar;
            return this;
        }

        public a qn() {
            return new a(this.asM, this.asN);
        }
    }

    public static class c {
        private final String TU;
        private final List<e> asO;
        private final Map<String, List<a>> asP;
        private final int asQ;

        private c(List<e> list, Map<String, List<a>> map, String str, int i) {
            this.asO = Collections.unmodifiableList(list);
            this.asP = Collections.unmodifiableMap(map);
            this.TU = str;
            this.asQ = i;
        }

        public static d qo() {
            return new d();
        }

        public String getVersion() {
            return this.TU;
        }

        public List<e> qp() {
            return this.asO;
        }

        public Map<String, List<a>> qq() {
            return this.asP;
        }

        public String toString() {
            return "Rules: " + qp() + "  Macros: " + this.asP;
        }
    }

    public static class d {
        private String TU;
        private final List<e> asO;
        private final Map<String, List<a>> asP;
        private int asQ;

        private d() {
            this.asO = new ArrayList();
            this.asP = new HashMap();
            this.TU = "";
            this.asQ = 0;
        }

        public d a(a aVar) {
            String j = di.j((com.google.android.gms.internal.d.a) aVar.ql().get(com.google.android.gms.internal.b.INSTANCE_NAME.toString()));
            List list = (List) this.asP.get(j);
            if (list == null) {
                list = new ArrayList();
                this.asP.put(j, list);
            }
            list.add(aVar);
            return this;
        }

        public d a(e eVar) {
            this.asO.add(eVar);
            return this;
        }

        public d cO(String str) {
            this.TU = str;
            return this;
        }

        public d fO(int i) {
            this.asQ = i;
            return this;
        }

        public c qr() {
            return new c(this.asO, this.asP, this.TU, this.asQ);
        }
    }

    public static class e {
        private final List<a> asR;
        private final List<a> asS;
        private final List<a> asT;
        private final List<a> asU;
        private final List<a> asV;
        private final List<a> asW;
        private final List<String> asX;
        private final List<String> asY;
        private final List<String> asZ;
        private final List<String> ata;

        private e(List<a> list, List<a> list2, List<a> list3, List<a> list4, List<a> list5, List<a> list6, List<String> list7, List<String> list8, List<String> list9, List<String> list10) {
            this.asR = Collections.unmodifiableList(list);
            this.asS = Collections.unmodifiableList(list2);
            this.asT = Collections.unmodifiableList(list3);
            this.asU = Collections.unmodifiableList(list4);
            this.asV = Collections.unmodifiableList(list5);
            this.asW = Collections.unmodifiableList(list6);
            this.asX = Collections.unmodifiableList(list7);
            this.asY = Collections.unmodifiableList(list8);
            this.asZ = Collections.unmodifiableList(list9);
            this.ata = Collections.unmodifiableList(list10);
        }

        public static f qs() {
            return new f();
        }

        public List<String> qA() {
            return this.asZ;
        }

        public List<String> qB() {
            return this.ata;
        }

        public List<a> qC() {
            return this.asW;
        }

        public List<a> qt() {
            return this.asR;
        }

        public List<a> qu() {
            return this.asS;
        }

        public List<a> qv() {
            return this.asT;
        }

        public List<a> qw() {
            return this.asU;
        }

        public List<a> qx() {
            return this.asV;
        }

        public List<String> qy() {
            return this.asX;
        }

        public List<String> qz() {
            return this.asY;
        }

        public String toString() {
            return "Positive predicates: " + qt() + "  Negative predicates: " + qu() + "  Add tags: " + qv() + "  Remove tags: " + qw() + "  Add macros: " + qx() + "  Remove macros: " + qC();
        }
    }

    public static class f {
        private final List<a> asR;
        private final List<a> asS;
        private final List<a> asT;
        private final List<a> asU;
        private final List<a> asV;
        private final List<a> asW;
        private final List<String> asX;
        private final List<String> asY;
        private final List<String> asZ;
        private final List<String> ata;

        private f() {
            this.asR = new ArrayList();
            this.asS = new ArrayList();
            this.asT = new ArrayList();
            this.asU = new ArrayList();
            this.asV = new ArrayList();
            this.asW = new ArrayList();
            this.asX = new ArrayList();
            this.asY = new ArrayList();
            this.asZ = new ArrayList();
            this.ata = new ArrayList();
        }

        public f b(a aVar) {
            this.asR.add(aVar);
            return this;
        }

        public f c(a aVar) {
            this.asS.add(aVar);
            return this;
        }

        public f cP(String str) {
            this.asZ.add(str);
            return this;
        }

        public f cQ(String str) {
            this.ata.add(str);
            return this;
        }

        public f cR(String str) {
            this.asX.add(str);
            return this;
        }

        public f cS(String str) {
            this.asY.add(str);
            return this;
        }

        public f d(a aVar) {
            this.asT.add(aVar);
            return this;
        }

        public f e(a aVar) {
            this.asU.add(aVar);
            return this;
        }

        public f f(a aVar) {
            this.asV.add(aVar);
            return this;
        }

        public f g(a aVar) {
            this.asW.add(aVar);
            return this;
        }

        public e qD() {
            return new e(this.asR, this.asS, this.asT, this.asU, this.asV, this.asW, this.asX, this.asY, this.asZ, this.ata);
        }
    }

    public static class g extends Exception {
        public g(String str) {
            super(str);
        }
    }

    private static com.google.android.gms.internal.d.a a(int i, com.google.android.gms.internal.c.f fVar, com.google.android.gms.internal.d.a[] aVarArr, Set<Integer> set) throws g {
        int i2 = 0;
        if (set.contains(Integer.valueOf(i))) {
            cN("Value cycle detected.  Current value reference: " + i + "." + "  Previous value references: " + set + ".");
        }
        com.google.android.gms.internal.d.a aVar = (com.google.android.gms.internal.d.a) a(fVar.fG, i, "values");
        if (aVarArr[i] != null) {
            return aVarArr[i];
        }
        com.google.android.gms.internal.d.a aVar2 = null;
        set.add(Integer.valueOf(i));
        h h;
        int[] iArr;
        int length;
        int i3;
        int i4;
        switch (aVar.type) {
            case 1:
            case 5:
            case 6:
            case 8:
                aVar2 = aVar;
                break;
            case 2:
                h = h(aVar);
                aVar2 = g(aVar);
                aVar2.gw = new com.google.android.gms.internal.d.a[h.gh.length];
                iArr = h.gh;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    aVar2.gw[i3] = a(iArr[i2], fVar, aVarArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                break;
            case 3:
                aVar2 = g(aVar);
                h h2 = h(aVar);
                if (h2.gi.length != h2.gj.length) {
                    cN("Uneven map keys (" + h2.gi.length + ") and map values (" + h2.gj.length + ")");
                }
                aVar2.gx = new com.google.android.gms.internal.d.a[h2.gi.length];
                aVar2.gy = new com.google.android.gms.internal.d.a[h2.gi.length];
                int[] iArr2 = h2.gi;
                int length2 = iArr2.length;
                i3 = 0;
                i4 = 0;
                while (i3 < length2) {
                    int i5 = i4 + 1;
                    aVar2.gx[i4] = a(iArr2[i3], fVar, aVarArr, (Set) set);
                    i3++;
                    i4 = i5;
                }
                iArr = h2.gj;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    aVar2.gy[i3] = a(iArr[i2], fVar, aVarArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                break;
            case 4:
                aVar2 = g(aVar);
                aVar2.gz = di.j(a(h(aVar).gm, fVar, aVarArr, (Set) set));
                break;
            case 7:
                aVar2 = g(aVar);
                h = h(aVar);
                aVar2.gD = new com.google.android.gms.internal.d.a[h.gl.length];
                iArr = h.gl;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    aVar2.gD[i3] = a(iArr[i2], fVar, aVarArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                break;
        }
        if (aVar2 == null) {
            cN("Invalid value: " + aVar);
        }
        aVarArr[i] = aVar2;
        set.remove(Integer.valueOf(i));
        return aVar2;
    }

    private static a a(com.google.android.gms.internal.c.b bVar, com.google.android.gms.internal.c.f fVar, com.google.android.gms.internal.d.a[] aVarArr, int i) throws g {
        b qk = a.qk();
        for (int valueOf : bVar.fq) {
            com.google.android.gms.internal.c.e eVar = (com.google.android.gms.internal.c.e) a(fVar.fH, Integer.valueOf(valueOf).intValue(), "properties");
            String str = (String) a(fVar.fF, eVar.key, "keys");
            com.google.android.gms.internal.d.a aVar = (com.google.android.gms.internal.d.a) a(aVarArr, eVar.value, "values");
            if (com.google.android.gms.internal.b.PUSH_AFTER_EVALUATE.toString().equals(str)) {
                qk.i(aVar);
            } else {
                qk.b(str, aVar);
            }
        }
        return qk.qn();
    }

    private static e a(com.google.android.gms.internal.c.g gVar, List<a> list, List<a> list2, List<a> list3, com.google.android.gms.internal.c.f fVar) {
        f qs = e.qs();
        for (int valueOf : gVar.fV) {
            qs.b((a) list3.get(Integer.valueOf(valueOf).intValue()));
        }
        for (int valueOf2 : gVar.fW) {
            qs.c((a) list3.get(Integer.valueOf(valueOf2).intValue()));
        }
        for (int valueOf22 : gVar.fX) {
            qs.d((a) list.get(Integer.valueOf(valueOf22).intValue()));
        }
        for (int valueOf3 : gVar.fZ) {
            qs.cP(fVar.fG[Integer.valueOf(valueOf3).intValue()].gv);
        }
        for (int valueOf222 : gVar.fY) {
            qs.e((a) list.get(Integer.valueOf(valueOf222).intValue()));
        }
        for (int valueOf32 : gVar.ga) {
            qs.cQ(fVar.fG[Integer.valueOf(valueOf32).intValue()].gv);
        }
        for (int valueOf2222 : gVar.gb) {
            qs.f((a) list2.get(Integer.valueOf(valueOf2222).intValue()));
        }
        for (int valueOf322 : gVar.gd) {
            qs.cR(fVar.fG[Integer.valueOf(valueOf322).intValue()].gv);
        }
        for (int valueOf22222 : gVar.gc) {
            qs.g((a) list2.get(Integer.valueOf(valueOf22222).intValue()));
        }
        for (int valueOf4 : gVar.ge) {
            qs.cS(fVar.fG[Integer.valueOf(valueOf4).intValue()].gv);
        }
        return qs.qD();
    }

    private static <T> T a(T[] tArr, int i, String str) throws g {
        if (i < 0 || i >= tArr.length) {
            cN("Index out of bounds detected: " + i + " in " + str);
        }
        return tArr[i];
    }

    public static c b(com.google.android.gms.internal.c.f fVar) throws g {
        int i;
        int i2 = 0;
        com.google.android.gms.internal.d.a[] aVarArr = new com.google.android.gms.internal.d.a[fVar.fG.length];
        for (i = 0; i < fVar.fG.length; i++) {
            a(i, fVar, aVarArr, new HashSet(0));
        }
        d qo = c.qo();
        List arrayList = new ArrayList();
        for (i = 0; i < fVar.fJ.length; i++) {
            arrayList.add(a(fVar.fJ[i], fVar, aVarArr, i));
        }
        List arrayList2 = new ArrayList();
        for (i = 0; i < fVar.fK.length; i++) {
            arrayList2.add(a(fVar.fK[i], fVar, aVarArr, i));
        }
        List arrayList3 = new ArrayList();
        for (i = 0; i < fVar.fI.length; i++) {
            a a = a(fVar.fI[i], fVar, aVarArr, i);
            qo.a(a);
            arrayList3.add(a);
        }
        com.google.android.gms.internal.c.g[] gVarArr = fVar.fL;
        int length = gVarArr.length;
        while (i2 < length) {
            qo.a(a(gVarArr[i2], arrayList, arrayList3, arrayList2, fVar));
            i2++;
        }
        qo.cO(fVar.version);
        qo.fO(fVar.fT);
        return qo.qr();
    }

    public static void b(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    private static void cN(String str) throws g {
        bh.T(str);
        throw new g(str);
    }

    public static com.google.android.gms.internal.d.a g(com.google.android.gms.internal.d.a aVar) {
        com.google.android.gms.internal.d.a aVar2 = new com.google.android.gms.internal.d.a();
        aVar2.type = aVar.type;
        aVar2.gE = (int[]) aVar.gE.clone();
        if (aVar.gF) {
            aVar2.gF = aVar.gF;
        }
        return aVar2;
    }

    private static h h(com.google.android.gms.internal.d.a aVar) throws g {
        if (((h) aVar.a(h.gf)) == null) {
            cN("Expected a ServingValue and didn't get one. Value is: " + aVar);
        }
        return (h) aVar.a(h.gf);
    }
}
