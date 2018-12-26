package com.google.android.gms.tagmanager;

import android.content.Context;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.google.android.gms.internal.c.i;
import com.google.android.gms.tagmanager.cr.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class ct {
    private static final bz<com.google.android.gms.internal.d.a> atb = new bz(di.rb(), true);
    private final DataLayer aqn;
    private final com.google.android.gms.tagmanager.cr.c atc;
    private final ag atd;
    private final Map<String, aj> ate;
    private final Map<String, aj> atf;
    private final Map<String, aj> atg;
    private final k<com.google.android.gms.tagmanager.cr.a, bz<com.google.android.gms.internal.d.a>> ath;
    private final k<String, b> ati;
    private final Set<e> atj;
    private final Map<String, c> atk;
    private volatile String atl;
    private int atm;

    interface a {
        void a(e eVar, Set<com.google.android.gms.tagmanager.cr.a> set, Set<com.google.android.gms.tagmanager.cr.a> set2, cn cnVar);
    }

    private static class b {
        private com.google.android.gms.internal.d.a asN;
        private bz<com.google.android.gms.internal.d.a> ats;

        public b(bz<com.google.android.gms.internal.d.a> bzVar, com.google.android.gms.internal.d.a aVar) {
            this.ats = bzVar;
            this.asN = aVar;
        }

        public int getSize() {
            return (this.asN == null ? 0 : this.asN.rY()) + ((com.google.android.gms.internal.d.a) this.ats.getObject()).rY();
        }

        public bz<com.google.android.gms.internal.d.a> qG() {
            return this.ats;
        }

        public com.google.android.gms.internal.d.a qm() {
            return this.asN;
        }
    }

    private static class c {
        private final Set<e> atj = new HashSet();
        private final Map<e, List<com.google.android.gms.tagmanager.cr.a>> att = new HashMap();
        private final Map<e, List<com.google.android.gms.tagmanager.cr.a>> atu = new HashMap();
        private final Map<e, List<String>> atv = new HashMap();
        private final Map<e, List<String>> atw = new HashMap();
        private com.google.android.gms.tagmanager.cr.a atx;

        public void a(e eVar, com.google.android.gms.tagmanager.cr.a aVar) {
            List list = (List) this.att.get(eVar);
            if (list == null) {
                list = new ArrayList();
                this.att.put(eVar, list);
            }
            list.add(aVar);
        }

        public void a(e eVar, String str) {
            List list = (List) this.atv.get(eVar);
            if (list == null) {
                list = new ArrayList();
                this.atv.put(eVar, list);
            }
            list.add(str);
        }

        public void b(e eVar) {
            this.atj.add(eVar);
        }

        public void b(e eVar, com.google.android.gms.tagmanager.cr.a aVar) {
            List list = (List) this.atu.get(eVar);
            if (list == null) {
                list = new ArrayList();
                this.atu.put(eVar, list);
            }
            list.add(aVar);
        }

        public void b(e eVar, String str) {
            List list = (List) this.atw.get(eVar);
            if (list == null) {
                list = new ArrayList();
                this.atw.put(eVar, list);
            }
            list.add(str);
        }

        public void i(com.google.android.gms.tagmanager.cr.a aVar) {
            this.atx = aVar;
        }

        public Set<e> qH() {
            return this.atj;
        }

        public Map<e, List<com.google.android.gms.tagmanager.cr.a>> qI() {
            return this.att;
        }

        public Map<e, List<String>> qJ() {
            return this.atv;
        }

        public Map<e, List<String>> qK() {
            return this.atw;
        }

        public Map<e, List<com.google.android.gms.tagmanager.cr.a>> qL() {
            return this.atu;
        }

        public com.google.android.gms.tagmanager.cr.a qM() {
            return this.atx;
        }
    }

    public ct(Context context, com.google.android.gms.tagmanager.cr.c cVar, DataLayer dataLayer, com.google.android.gms.tagmanager.s.a aVar, com.google.android.gms.tagmanager.s.a aVar2, ag agVar) {
        if (cVar == null) {
            throw new NullPointerException("resource cannot be null");
        }
        this.atc = cVar;
        this.atj = new HashSet(cVar.qp());
        this.aqn = dataLayer;
        this.atd = agVar;
        this.ath = new l().a(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START, new com.google.android.gms.tagmanager.l.a<com.google.android.gms.tagmanager.cr.a, bz<com.google.android.gms.internal.d.a>>(this) {
            final /* synthetic */ ct atn;

            {
                this.atn = r1;
            }

            public int a(com.google.android.gms.tagmanager.cr.a aVar, bz<com.google.android.gms.internal.d.a> bzVar) {
                return ((com.google.android.gms.internal.d.a) bzVar.getObject()).rY();
            }

            public /* synthetic */ int sizeOf(Object x0, Object x1) {
                return a((com.google.android.gms.tagmanager.cr.a) x0, (bz) x1);
            }
        });
        this.ati = new l().a(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START, new com.google.android.gms.tagmanager.l.a<String, b>(this) {
            final /* synthetic */ ct atn;

            {
                this.atn = r1;
            }

            public int a(String str, b bVar) {
                return str.length() + bVar.getSize();
            }

            public /* synthetic */ int sizeOf(Object x0, Object x1) {
                return a((String) x0, (b) x1);
            }
        });
        this.ate = new HashMap();
        b(new i(context));
        b(new s(aVar2));
        b(new w(dataLayer));
        b(new dj(context, dataLayer));
        this.atf = new HashMap();
        c(new q());
        c(new ad());
        c(new ae());
        c(new al());
        c(new am());
        c(new bd());
        c(new be());
        c(new ci());
        c(new dc());
        this.atg = new HashMap();
        a(new b(context));
        a(new c(context));
        a(new e(context));
        a(new f(context));
        a(new g(context));
        a(new h(context));
        a(new m());
        a(new p(this.atc.getVersion()));
        a(new s(aVar));
        a(new u(dataLayer));
        a(new z(context));
        a(new aa());
        a(new ac());
        a(new ah(this));
        a(new an());
        a(new ao());
        a(new ax(context));
        a(new az());
        a(new bc());
        a(new bj());
        a(new bl(context));
        a(new ca());
        a(new cc());
        a(new cf());
        a(new ch());
        a(new cj(context));
        a(new cu());
        a(new cv());
        a(new de());
        a(new dk());
        this.atk = new HashMap();
        for (e eVar : this.atj) {
            if (agVar.pH()) {
                a(eVar.qx(), eVar.qy(), "add macro");
                a(eVar.qC(), eVar.qz(), "remove macro");
                a(eVar.qv(), eVar.qA(), "add tag");
                a(eVar.qw(), eVar.qB(), "remove tag");
            }
            int i = 0;
            while (i < eVar.qx().size()) {
                com.google.android.gms.tagmanager.cr.a aVar3 = (com.google.android.gms.tagmanager.cr.a) eVar.qx().get(i);
                String str = "Unknown";
                if (agVar.pH() && i < eVar.qy().size()) {
                    str = (String) eVar.qy().get(i);
                }
                c e = e(this.atk, h(aVar3));
                e.b(eVar);
                e.a(eVar, aVar3);
                e.a(eVar, str);
                i++;
            }
            i = 0;
            while (i < eVar.qC().size()) {
                aVar3 = (com.google.android.gms.tagmanager.cr.a) eVar.qC().get(i);
                str = "Unknown";
                if (agVar.pH() && i < eVar.qz().size()) {
                    str = (String) eVar.qz().get(i);
                }
                e = e(this.atk, h(aVar3));
                e.b(eVar);
                e.b(eVar, aVar3);
                e.b(eVar, str);
                i++;
            }
        }
        for (Entry entry : this.atc.qq().entrySet()) {
            for (com.google.android.gms.tagmanager.cr.a aVar32 : (List) entry.getValue()) {
                if (!di.n((com.google.android.gms.internal.d.a) aVar32.ql().get(com.google.android.gms.internal.b.NOT_DEFAULT_MACRO.toString())).booleanValue()) {
                    e(this.atk, (String) entry.getKey()).i(aVar32);
                }
            }
        }
    }

    private bz<com.google.android.gms.internal.d.a> a(com.google.android.gms.internal.d.a aVar, Set<String> set, dl dlVar) {
        if (!aVar.gF) {
            return new bz(aVar, true);
        }
        com.google.android.gms.internal.d.a g;
        int i;
        bz a;
        switch (aVar.type) {
            case 2:
                g = cr.g(aVar);
                g.gw = new com.google.android.gms.internal.d.a[aVar.gw.length];
                for (i = 0; i < aVar.gw.length; i++) {
                    a = a(aVar.gw[i], (Set) set, dlVar.fK(i));
                    if (a == atb) {
                        return atb;
                    }
                    g.gw[i] = (com.google.android.gms.internal.d.a) a.getObject();
                }
                return new bz(g, false);
            case 3:
                g = cr.g(aVar);
                if (aVar.gx.length != aVar.gy.length) {
                    bh.T("Invalid serving value: " + aVar.toString());
                    return atb;
                }
                g.gx = new com.google.android.gms.internal.d.a[aVar.gx.length];
                g.gy = new com.google.android.gms.internal.d.a[aVar.gx.length];
                for (i = 0; i < aVar.gx.length; i++) {
                    a = a(aVar.gx[i], (Set) set, dlVar.fL(i));
                    bz a2 = a(aVar.gy[i], (Set) set, dlVar.fM(i));
                    if (a == atb || a2 == atb) {
                        return atb;
                    }
                    g.gx[i] = (com.google.android.gms.internal.d.a) a.getObject();
                    g.gy[i] = (com.google.android.gms.internal.d.a) a2.getObject();
                }
                return new bz(g, false);
            case 4:
                if (set.contains(aVar.gz)) {
                    bh.T("Macro cycle detected.  Current macro reference: " + aVar.gz + "." + "  Previous macro references: " + set.toString() + ".");
                    return atb;
                }
                set.add(aVar.gz);
                bz<com.google.android.gms.internal.d.a> a3 = dm.a(a(aVar.gz, (Set) set, dlVar.pW()), aVar.gE);
                set.remove(aVar.gz);
                return a3;
            case 7:
                g = cr.g(aVar);
                g.gD = new com.google.android.gms.internal.d.a[aVar.gD.length];
                for (i = 0; i < aVar.gD.length; i++) {
                    a = a(aVar.gD[i], (Set) set, dlVar.fN(i));
                    if (a == atb) {
                        return atb;
                    }
                    g.gD[i] = (com.google.android.gms.internal.d.a) a.getObject();
                }
                return new bz(g, false);
            default:
                bh.T("Unknown type: " + aVar.type);
                return atb;
        }
    }

    private bz<com.google.android.gms.internal.d.a> a(String str, Set<String> set, bk bkVar) {
        this.atm++;
        b bVar = (b) this.ati.get(str);
        if (bVar == null || this.atd.pH()) {
            c cVar = (c) this.atk.get(str);
            if (cVar == null) {
                bh.T(qF() + "Invalid macro: " + str);
                this.atm--;
                return atb;
            }
            com.google.android.gms.tagmanager.cr.a qM;
            bz a = a(str, cVar.qH(), cVar.qI(), cVar.qJ(), cVar.qL(), cVar.qK(), set, bkVar.py());
            if (((Set) a.getObject()).isEmpty()) {
                qM = cVar.qM();
            } else {
                if (((Set) a.getObject()).size() > 1) {
                    bh.W(qF() + "Multiple macros active for macroName " + str);
                }
                qM = (com.google.android.gms.tagmanager.cr.a) ((Set) a.getObject()).iterator().next();
            }
            if (qM == null) {
                this.atm--;
                return atb;
            }
            bz a2 = a(this.atg, qM, (Set) set, bkVar.pN());
            boolean z = a.pX() && a2.pX();
            bz<com.google.android.gms.internal.d.a> bzVar = a2 == atb ? atb : new bz(a2.getObject(), z);
            com.google.android.gms.internal.d.a qm = qM.qm();
            if (bzVar.pX()) {
                this.ati.e(str, new b(bzVar, qm));
            }
            a(qm, (Set) set);
            this.atm--;
            return bzVar;
        }
        a(bVar.qm(), (Set) set);
        this.atm--;
        return bVar.qG();
    }

    private bz<com.google.android.gms.internal.d.a> a(Map<String, aj> map, com.google.android.gms.tagmanager.cr.a aVar, Set<String> set, ck ckVar) {
        boolean z = true;
        com.google.android.gms.internal.d.a aVar2 = (com.google.android.gms.internal.d.a) aVar.ql().get(com.google.android.gms.internal.b.FUNCTION.toString());
        if (aVar2 == null) {
            bh.T("No function id in properties");
            return atb;
        }
        String str = aVar2.gA;
        aj ajVar = (aj) map.get(str);
        if (ajVar == null) {
            bh.T(str + " has no backing implementation.");
            return atb;
        }
        bz<com.google.android.gms.internal.d.a> bzVar = (bz) this.ath.get(aVar);
        if (bzVar != null && !this.atd.pH()) {
            return bzVar;
        }
        Map hashMap = new HashMap();
        boolean z2 = true;
        for (Entry entry : aVar.ql().entrySet()) {
            bz a = a((com.google.android.gms.internal.d.a) entry.getValue(), (Set) set, ckVar.cJ((String) entry.getKey()).e((com.google.android.gms.internal.d.a) entry.getValue()));
            if (a == atb) {
                return atb;
            }
            boolean z3;
            if (a.pX()) {
                aVar.a((String) entry.getKey(), (com.google.android.gms.internal.d.a) a.getObject());
                z3 = z2;
            } else {
                z3 = false;
            }
            hashMap.put(entry.getKey(), a.getObject());
            z2 = z3;
        }
        if (ajVar.a(hashMap.keySet())) {
            if (!(z2 && ajVar.pe())) {
                z = false;
            }
            bzVar = new bz(ajVar.B(hashMap), z);
            if (z) {
                this.ath.e(aVar, bzVar);
            }
            ckVar.d((com.google.android.gms.internal.d.a) bzVar.getObject());
            return bzVar;
        }
        bh.T("Incorrect keys for function " + str + " required " + ajVar.pJ() + " had " + hashMap.keySet());
        return atb;
    }

    private bz<Set<com.google.android.gms.tagmanager.cr.a>> a(Set<e> set, Set<String> set2, a aVar, cs csVar) {
        Set hashSet = new HashSet();
        Collection hashSet2 = new HashSet();
        boolean z = true;
        for (e eVar : set) {
            cn pV = csVar.pV();
            bz a = a(eVar, (Set) set2, pV);
            if (((Boolean) a.getObject()).booleanValue()) {
                aVar.a(eVar, hashSet, hashSet2, pV);
            }
            boolean z2 = z && a.pX();
            z = z2;
        }
        hashSet.removeAll(hashSet2);
        csVar.b(hashSet);
        return new bz(hashSet, z);
    }

    private void a(com.google.android.gms.internal.d.a aVar, Set<String> set) {
        if (aVar != null) {
            bz a = a(aVar, (Set) set, new bx());
            if (a != atb) {
                Object o = di.o((com.google.android.gms.internal.d.a) a.getObject());
                if (o instanceof Map) {
                    this.aqn.push((Map) o);
                } else if (o instanceof List) {
                    for (Object o2 : (List) o2) {
                        if (o2 instanceof Map) {
                            this.aqn.push((Map) o2);
                        } else {
                            bh.W("pushAfterEvaluate: value not a Map");
                        }
                    }
                } else {
                    bh.W("pushAfterEvaluate: value not a Map or List");
                }
            }
        }
    }

    private static void a(List<com.google.android.gms.tagmanager.cr.a> list, List<String> list2, String str) {
        if (list.size() != list2.size()) {
            bh.U("Invalid resource: imbalance of rule names of functions for " + str + " operation. Using default rule name instead");
        }
    }

    private static void a(Map<String, aj> map, aj ajVar) {
        if (map.containsKey(ajVar.pI())) {
            throw new IllegalArgumentException("Duplicate function type name: " + ajVar.pI());
        }
        map.put(ajVar.pI(), ajVar);
    }

    private static c e(Map<String, c> map, String str) {
        c cVar = (c) map.get(str);
        if (cVar != null) {
            return cVar;
        }
        cVar = new c();
        map.put(str, cVar);
        return cVar;
    }

    private static String h(com.google.android.gms.tagmanager.cr.a aVar) {
        return di.j((com.google.android.gms.internal.d.a) aVar.ql().get(com.google.android.gms.internal.b.INSTANCE_NAME.toString()));
    }

    private String qF() {
        if (this.atm <= 1) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Integer.toString(this.atm));
        for (int i = 2; i < this.atm; i++) {
            stringBuilder.append(' ');
        }
        stringBuilder.append(": ");
        return stringBuilder.toString();
    }

    bz<Boolean> a(com.google.android.gms.tagmanager.cr.a aVar, Set<String> set, ck ckVar) {
        bz a = a(this.atf, aVar, (Set) set, ckVar);
        Boolean n = di.n((com.google.android.gms.internal.d.a) a.getObject());
        ckVar.d(di.u(n));
        return new bz(n, a.pX());
    }

    bz<Boolean> a(e eVar, Set<String> set, cn cnVar) {
        boolean z = true;
        for (com.google.android.gms.tagmanager.cr.a a : eVar.qu()) {
            bz a2 = a(a, (Set) set, cnVar.pP());
            if (((Boolean) a2.getObject()).booleanValue()) {
                cnVar.f(di.u(Boolean.valueOf(false)));
                return new bz(Boolean.valueOf(false), a2.pX());
            }
            boolean z2 = z && a2.pX();
            z = z2;
        }
        for (com.google.android.gms.tagmanager.cr.a a3 : eVar.qt()) {
            a2 = a(a3, (Set) set, cnVar.pQ());
            if (((Boolean) a2.getObject()).booleanValue()) {
                z = z && a2.pX();
            } else {
                cnVar.f(di.u(Boolean.valueOf(false)));
                return new bz(Boolean.valueOf(false), a2.pX());
            }
        }
        cnVar.f(di.u(Boolean.valueOf(true)));
        return new bz(Boolean.valueOf(true), z);
    }

    bz<Set<com.google.android.gms.tagmanager.cr.a>> a(String str, Set<e> set, Map<e, List<com.google.android.gms.tagmanager.cr.a>> map, Map<e, List<String>> map2, Map<e, List<com.google.android.gms.tagmanager.cr.a>> map3, Map<e, List<String>> map4, Set<String> set2, cs csVar) {
        final Map<e, List<com.google.android.gms.tagmanager.cr.a>> map5 = map;
        final Map<e, List<String>> map6 = map2;
        final Map<e, List<com.google.android.gms.tagmanager.cr.a>> map7 = map3;
        final Map<e, List<String>> map8 = map4;
        return a((Set) set, (Set) set2, new a(this) {
            final /* synthetic */ ct atn;

            public void a(e eVar, Set<com.google.android.gms.tagmanager.cr.a> set, Set<com.google.android.gms.tagmanager.cr.a> set2, cn cnVar) {
                List list = (List) map5.get(eVar);
                List list2 = (List) map6.get(eVar);
                if (list != null) {
                    set.addAll(list);
                    cnVar.pR().c(list, list2);
                }
                list = (List) map7.get(eVar);
                list2 = (List) map8.get(eVar);
                if (list != null) {
                    set2.addAll(list);
                    cnVar.pS().c(list, list2);
                }
            }
        }, csVar);
    }

    bz<Set<com.google.android.gms.tagmanager.cr.a>> a(Set<e> set, cs csVar) {
        return a((Set) set, new HashSet(), new a(this) {
            final /* synthetic */ ct atn;

            {
                this.atn = r1;
            }

            public void a(e eVar, Set<com.google.android.gms.tagmanager.cr.a> set, Set<com.google.android.gms.tagmanager.cr.a> set2, cn cnVar) {
                set.addAll(eVar.qv());
                set2.addAll(eVar.qw());
                cnVar.pT().c(eVar.qv(), eVar.qA());
                cnVar.pU().c(eVar.qw(), eVar.qB());
            }
        }, csVar);
    }

    void a(aj ajVar) {
        a(this.atg, ajVar);
    }

    void b(aj ajVar) {
        a(this.ate, ajVar);
    }

    void c(aj ajVar) {
        a(this.atf, ajVar);
    }

    public bz<com.google.android.gms.internal.d.a> cT(String str) {
        this.atm = 0;
        af cC = this.atd.cC(str);
        bz<com.google.android.gms.internal.d.a> a = a(str, new HashSet(), cC.pE());
        cC.pG();
        return a;
    }

    synchronized void cU(String str) {
        this.atl = str;
    }

    public synchronized void cr(String str) {
        cU(str);
        af cD = this.atd.cD(str);
        t pF = cD.pF();
        for (com.google.android.gms.tagmanager.cr.a a : (Set) a(this.atj, pF.py()).getObject()) {
            a(this.ate, a, new HashSet(), pF.px());
        }
        cD.pG();
        cU(null);
    }

    public synchronized void l(List<i> list) {
        for (i iVar : list) {
            if (iVar.name == null || !iVar.name.startsWith("gaExperiment:")) {
                bh.V("Ignored supplemental: " + iVar);
            } else {
                ai.a(this.aqn, iVar);
            }
        }
    }

    synchronized String qE() {
        return this.atl;
    }
}
