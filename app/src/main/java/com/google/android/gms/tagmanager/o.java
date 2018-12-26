package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.BaseImplementation.AbstractPendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.c.j;
import com.google.android.gms.internal.ld;
import com.google.android.gms.internal.lf;

class o extends AbstractPendingResult<ContainerHolder> {
    private final Looper JF;
    private final d aqB;
    private final cg aqC;
    private final int aqD;
    private f aqE;
    private volatile n aqF;
    private volatile boolean aqG;
    private j aqH;
    private String aqI;
    private e aqJ;
    private a aqK;
    private final String aqm;
    private long aqr;
    private final TagManager aqy;
    private final Context mContext;
    private final ld wb;

    interface e extends Releasable {
        void a(bg<j> bgVar);

        void cw(String str);

        void e(long j, String str);
    }

    interface f extends Releasable {
        void a(bg<com.google.android.gms.internal.pu.a> bgVar);

        void b(com.google.android.gms.internal.pu.a aVar);

        com.google.android.gms.tagmanager.cr.c fH(int i);

        void pt();
    }

    interface a {
        boolean b(Container container);
    }

    private class b implements bg<com.google.android.gms.internal.pu.a> {
        final /* synthetic */ o aqL;

        private b(o oVar) {
            this.aqL = oVar;
        }

        public void a(com.google.android.gms.internal.pu.a aVar) {
            j jVar;
            if (aVar.auC != null) {
                jVar = aVar.auC;
            } else {
                com.google.android.gms.internal.c.f fVar = aVar.gs;
                jVar = new j();
                jVar.gs = fVar;
                jVar.gr = null;
                jVar.gt = fVar.version;
            }
            this.aqL.a(jVar, aVar.auB, true);
        }

        public void a(com.google.android.gms.tagmanager.bg.a aVar) {
            if (!this.aqL.aqG) {
                this.aqL.w(0);
            }
        }

        public /* synthetic */ void l(Object obj) {
            a((com.google.android.gms.internal.pu.a) obj);
        }

        public void ps() {
        }
    }

    private class c implements bg<j> {
        final /* synthetic */ o aqL;

        private c(o oVar) {
            this.aqL = oVar;
        }

        public void a(com.google.android.gms.tagmanager.bg.a aVar) {
            if (this.aqL.aqF != null) {
                this.aqL.b(this.aqL.aqF);
            } else {
                this.aqL.b(this.aqL.aD(Status.Kz));
            }
            this.aqL.w(3600000);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b(com.google.android.gms.internal.c.j r6) {
            /*
            r5 = this;
            r1 = r5.aqL;
            monitor-enter(r1);
            r0 = r6.gs;	 Catch:{ all -> 0x0065 }
            if (r0 != 0) goto L_0x002a;
        L_0x0007:
            r0 = r5.aqL;	 Catch:{ all -> 0x0065 }
            r0 = r0.aqH;	 Catch:{ all -> 0x0065 }
            r0 = r0.gs;	 Catch:{ all -> 0x0065 }
            if (r0 != 0) goto L_0x0020;
        L_0x0011:
            r0 = "Current resource is null; network resource is also null";
            com.google.android.gms.tagmanager.bh.T(r0);	 Catch:{ all -> 0x0065 }
            r0 = r5.aqL;	 Catch:{ all -> 0x0065 }
            r2 = 3600000; // 0x36ee80 float:5.044674E-39 double:1.7786363E-317;
            r0.w(r2);	 Catch:{ all -> 0x0065 }
            monitor-exit(r1);	 Catch:{ all -> 0x0065 }
        L_0x001f:
            return;
        L_0x0020:
            r0 = r5.aqL;	 Catch:{ all -> 0x0065 }
            r0 = r0.aqH;	 Catch:{ all -> 0x0065 }
            r0 = r0.gs;	 Catch:{ all -> 0x0065 }
            r6.gs = r0;	 Catch:{ all -> 0x0065 }
        L_0x002a:
            r0 = r5.aqL;	 Catch:{ all -> 0x0065 }
            r2 = r5.aqL;	 Catch:{ all -> 0x0065 }
            r2 = r2.wb;	 Catch:{ all -> 0x0065 }
            r2 = r2.currentTimeMillis();	 Catch:{ all -> 0x0065 }
            r4 = 0;
            r0.a(r6, r2, r4);	 Catch:{ all -> 0x0065 }
            r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0065 }
            r0.<init>();	 Catch:{ all -> 0x0065 }
            r2 = "setting refresh time to current time: ";
            r0 = r0.append(r2);	 Catch:{ all -> 0x0065 }
            r2 = r5.aqL;	 Catch:{ all -> 0x0065 }
            r2 = r2.aqr;	 Catch:{ all -> 0x0065 }
            r0 = r0.append(r2);	 Catch:{ all -> 0x0065 }
            r0 = r0.toString();	 Catch:{ all -> 0x0065 }
            com.google.android.gms.tagmanager.bh.V(r0);	 Catch:{ all -> 0x0065 }
            r0 = r5.aqL;	 Catch:{ all -> 0x0065 }
            r0 = r0.pr();	 Catch:{ all -> 0x0065 }
            if (r0 != 0) goto L_0x0063;
        L_0x005e:
            r0 = r5.aqL;	 Catch:{ all -> 0x0065 }
            r0.a(r6);	 Catch:{ all -> 0x0065 }
        L_0x0063:
            monitor-exit(r1);	 Catch:{ all -> 0x0065 }
            goto L_0x001f;
        L_0x0065:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0065 }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.o.c.b(com.google.android.gms.internal.c$j):void");
        }

        public /* synthetic */ void l(Object obj) {
            b((j) obj);
        }

        public void ps() {
        }
    }

    private class d implements com.google.android.gms.tagmanager.n.a {
        final /* synthetic */ o aqL;

        private d(o oVar) {
            this.aqL = oVar;
        }

        public void ct(String str) {
            this.aqL.ct(str);
        }

        public String pl() {
            return this.aqL.pl();
        }

        public void pn() {
            if (this.aqL.aqC.fe()) {
                this.aqL.w(0);
            }
        }
    }

    o(Context context, TagManager tagManager, Looper looper, String str, int i, f fVar, e eVar, ld ldVar, cg cgVar) {
        super(looper == null ? Looper.getMainLooper() : looper);
        this.mContext = context;
        this.aqy = tagManager;
        if (looper == null) {
            looper = Looper.getMainLooper();
        }
        this.JF = looper;
        this.aqm = str;
        this.aqD = i;
        this.aqE = fVar;
        this.aqJ = eVar;
        this.aqB = new d();
        this.aqH = new j();
        this.wb = ldVar;
        this.aqC = cgVar;
        if (pr()) {
            ct(ce.qa().qc());
        }
    }

    public o(Context context, TagManager tagManager, Looper looper, String str, int i, r rVar) {
        this(context, tagManager, looper, str, i, new cq(context, str), new cp(context, str, rVar), lf.if(), new bf(30, 900000, 5000, "refreshing", lf.if()));
    }

    private void V(final boolean z) {
        this.aqE.a(new b());
        this.aqJ.a(new c());
        com.google.android.gms.tagmanager.cr.c fH = this.aqE.fH(this.aqD);
        if (fH != null) {
            this.aqF = new n(this.aqy, this.JF, new Container(this.mContext, this.aqy.getDataLayer(), this.aqm, 0, fH), this.aqB);
        }
        this.aqK = new a(this) {
            final /* synthetic */ o aqL;

            public boolean b(Container container) {
                return z ? container.getLastRefreshTime() + 43200000 >= this.aqL.wb.currentTimeMillis() : !container.isDefault();
            }
        };
        if (pr()) {
            this.aqJ.e(0, "");
        } else {
            this.aqE.pt();
        }
    }

    private synchronized void a(j jVar) {
        if (this.aqE != null) {
            com.google.android.gms.internal.pu.a aVar = new com.google.android.gms.internal.pu.a();
            aVar.auB = this.aqr;
            aVar.gs = new com.google.android.gms.internal.c.f();
            aVar.auC = jVar;
            this.aqE.b(aVar);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void a(com.google.android.gms.internal.c.j r9, long r10, boolean r12) {
        /*
        r8 = this;
        r6 = 43200000; // 0x2932e00 float:2.1626111E-37 double:2.1343636E-316;
        monitor-enter(r8);
        if (r12 == 0) goto L_0x000c;
    L_0x0006:
        r0 = r8.aqG;	 Catch:{ all -> 0x006a }
        if (r0 == 0) goto L_0x000c;
    L_0x000a:
        monitor-exit(r8);
        return;
    L_0x000c:
        r0 = r8.isReady();	 Catch:{ all -> 0x006a }
        if (r0 == 0) goto L_0x0016;
    L_0x0012:
        r0 = r8.aqF;	 Catch:{ all -> 0x006a }
        if (r0 != 0) goto L_0x0016;
    L_0x0016:
        r8.aqH = r9;	 Catch:{ all -> 0x006a }
        r8.aqr = r10;	 Catch:{ all -> 0x006a }
        r0 = 0;
        r2 = 43200000; // 0x2932e00 float:2.1626111E-37 double:2.1343636E-316;
        r4 = r8.aqr;	 Catch:{ all -> 0x006a }
        r4 = r4 + r6;
        r6 = r8.wb;	 Catch:{ all -> 0x006a }
        r6 = r6.currentTimeMillis();	 Catch:{ all -> 0x006a }
        r4 = r4 - r6;
        r2 = java.lang.Math.min(r2, r4);	 Catch:{ all -> 0x006a }
        r0 = java.lang.Math.max(r0, r2);	 Catch:{ all -> 0x006a }
        r8.w(r0);	 Catch:{ all -> 0x006a }
        r0 = new com.google.android.gms.tagmanager.Container;	 Catch:{ all -> 0x006a }
        r1 = r8.mContext;	 Catch:{ all -> 0x006a }
        r2 = r8.aqy;	 Catch:{ all -> 0x006a }
        r2 = r2.getDataLayer();	 Catch:{ all -> 0x006a }
        r3 = r8.aqm;	 Catch:{ all -> 0x006a }
        r4 = r10;
        r6 = r9;
        r0.<init>(r1, r2, r3, r4, r6);	 Catch:{ all -> 0x006a }
        r1 = r8.aqF;	 Catch:{ all -> 0x006a }
        if (r1 != 0) goto L_0x006d;
    L_0x0049:
        r1 = new com.google.android.gms.tagmanager.n;	 Catch:{ all -> 0x006a }
        r2 = r8.aqy;	 Catch:{ all -> 0x006a }
        r3 = r8.JF;	 Catch:{ all -> 0x006a }
        r4 = r8.aqB;	 Catch:{ all -> 0x006a }
        r1.<init>(r2, r3, r0, r4);	 Catch:{ all -> 0x006a }
        r8.aqF = r1;	 Catch:{ all -> 0x006a }
    L_0x0056:
        r1 = r8.isReady();	 Catch:{ all -> 0x006a }
        if (r1 != 0) goto L_0x000a;
    L_0x005c:
        r1 = r8.aqK;	 Catch:{ all -> 0x006a }
        r0 = r1.b(r0);	 Catch:{ all -> 0x006a }
        if (r0 == 0) goto L_0x000a;
    L_0x0064:
        r0 = r8.aqF;	 Catch:{ all -> 0x006a }
        r8.b(r0);	 Catch:{ all -> 0x006a }
        goto L_0x000a;
    L_0x006a:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
    L_0x006d:
        r1 = r8.aqF;	 Catch:{ all -> 0x006a }
        r1.a(r0);	 Catch:{ all -> 0x006a }
        goto L_0x0056;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.o.a(com.google.android.gms.internal.c$j, long, boolean):void");
    }

    private boolean pr() {
        ce qa = ce.qa();
        return (qa.qb() == a.CONTAINER || qa.qb() == a.CONTAINER_DEBUG) && this.aqm.equals(qa.getContainerId());
    }

    private synchronized void w(long j) {
        if (this.aqJ == null) {
            bh.W("Refresh requested, but no network load scheduler.");
        } else {
            this.aqJ.e(j, this.aqH.gt);
        }
    }

    protected ContainerHolder aD(Status status) {
        if (this.aqF != null) {
            return this.aqF;
        }
        if (status == Status.Kz) {
            bh.T("timer expired: setting result to failure");
        }
        return new n(status);
    }

    protected /* synthetic */ Result c(Status status) {
        return aD(status);
    }

    synchronized void ct(String str) {
        this.aqI = str;
        if (this.aqJ != null) {
            this.aqJ.cw(str);
        }
    }

    synchronized String pl() {
        return this.aqI;
    }

    public void po() {
        com.google.android.gms.tagmanager.cr.c fH = this.aqE.fH(this.aqD);
        if (fH != null) {
            b(new n(this.aqy, this.JF, new Container(this.mContext, this.aqy.getDataLayer(), this.aqm, 0, fH), new com.google.android.gms.tagmanager.n.a(this) {
                final /* synthetic */ o aqL;

                {
                    this.aqL = r1;
                }

                public void ct(String str) {
                    this.aqL.ct(str);
                }

                public String pl() {
                    return this.aqL.pl();
                }

                public void pn() {
                    bh.W("Refresh ignored: container loaded as default only.");
                }
            }));
        } else {
            String str = "Default was requested, but no default container was found";
            bh.T(str);
            b(aD(new Status(10, str, null)));
        }
        this.aqJ = null;
        this.aqE = null;
    }

    public void pp() {
        V(false);
    }

    public void pq() {
        V(true);
    }
}
