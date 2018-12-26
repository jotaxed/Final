package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

@ey
public class fz {
    private final Object mH;
    private boolean uQ;
    private final ga vL;
    private final LinkedList<a> vM;
    private final String vN;
    private final String vO;
    private long vP;
    private long vQ;
    private long vR;
    private long vS;
    private long vT;
    private long vU;

    @ey
    private static final class a {
        private long vV = -1;
        private long vW = -1;

        public long cZ() {
            return this.vW;
        }

        public void da() {
            this.vW = SystemClock.elapsedRealtime();
        }

        public void db() {
            this.vV = SystemClock.elapsedRealtime();
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putLong("topen", this.vV);
            bundle.putLong("tclose", this.vW);
            return bundle;
        }
    }

    public fz(ga gaVar, String str, String str2) {
        this.mH = new Object();
        this.vP = -1;
        this.vQ = -1;
        this.uQ = false;
        this.vR = -1;
        this.vS = 0;
        this.vT = -1;
        this.vU = -1;
        this.vL = gaVar;
        this.vN = str;
        this.vO = str2;
        this.vM = new LinkedList();
    }

    public fz(String str, String str2) {
        this(ga.dc(), str, str2);
    }

    public void cW() {
        synchronized (this.mH) {
            if (this.vU != -1 && this.vQ == -1) {
                this.vQ = SystemClock.elapsedRealtime();
                this.vL.a(this);
            }
            ga gaVar = this.vL;
            ga.dh().cW();
        }
    }

    public void cX() {
        synchronized (this.mH) {
            if (this.vU != -1) {
                a aVar = new a();
                aVar.db();
                this.vM.add(aVar);
                this.vS++;
                ga gaVar = this.vL;
                ga.dh().cX();
                this.vL.a(this);
            }
        }
    }

    public void cY() {
        synchronized (this.mH) {
            if (!(this.vU == -1 || this.vM.isEmpty())) {
                a aVar = (a) this.vM.getLast();
                if (aVar.cZ() == -1) {
                    aVar.da();
                    this.vL.a(this);
                }
            }
        }
    }

    public void e(av avVar) {
        synchronized (this.mH) {
            this.vT = SystemClock.elapsedRealtime();
            ga gaVar = this.vL;
            ga.dh().b(avVar, this.vT);
        }
    }

    public void j(long j) {
        synchronized (this.mH) {
            this.vU = j;
            if (this.vU != -1) {
                this.vL.a(this);
            }
        }
    }

    public void k(long j) {
        synchronized (this.mH) {
            if (this.vU != -1) {
                this.vP = j;
                this.vL.a(this);
            }
        }
    }

    public Bundle toBundle() {
        Bundle bundle;
        synchronized (this.mH) {
            bundle = new Bundle();
            bundle.putString("seq_num", this.vN);
            bundle.putString("slotid", this.vO);
            bundle.putBoolean("ismediation", this.uQ);
            bundle.putLong("treq", this.vT);
            bundle.putLong("tresponse", this.vU);
            bundle.putLong("timp", this.vQ);
            bundle.putLong("tload", this.vR);
            bundle.putLong("pcc", this.vS);
            bundle.putLong("tfetch", this.vP);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.vM.iterator();
            while (it.hasNext()) {
                arrayList.add(((a) it.next()).toBundle());
            }
            bundle.putParcelableArrayList("tclick", arrayList);
        }
        return bundle;
    }

    public void v(boolean z) {
        synchronized (this.mH) {
            if (this.vU != -1) {
                this.vR = SystemClock.elapsedRealtime();
                if (!z) {
                    this.vQ = this.vR;
                    this.vL.a(this);
                }
            }
        }
    }

    public void w(boolean z) {
        synchronized (this.mH) {
            if (this.vU != -1) {
                this.uQ = z;
                this.vL.a(this);
            }
        }
    }
}
