package com.google.android.gms.internal;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.ads.AdSize;
import java.io.IOException;

public interface c {

    public static final class a extends qq<a> {
        public int fn;
        public int fo;
        public int level;

        public a() {
            b();
        }

        public a a(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                switch (rz) {
                    case 0:
                        break;
                    case 8:
                        rz = qoVar.rC();
                        switch (rz) {
                            case 1:
                            case 2:
                            case 3:
                                this.level = rz;
                                break;
                            default:
                                continue;
                        }
                    case 16:
                        this.fn = qoVar.rC();
                        continue;
                    case 24:
                        this.fo = qoVar.rC();
                        continue;
                    default:
                        if (!a(qoVar, rz)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void a(qp qpVar) throws IOException {
            if (this.level != 1) {
                qpVar.t(1, this.level);
            }
            if (this.fn != 0) {
                qpVar.t(2, this.fn);
            }
            if (this.fo != 0) {
                qpVar.t(3, this.fo);
            }
            super.a(qpVar);
        }

        public a b() {
            this.level = 1;
            this.fn = 0;
            this.fo = 0;
            this.ayW = null;
            this.azh = -1;
            return this;
        }

        public /* synthetic */ qw b(qo qoVar) throws IOException {
            return a(qoVar);
        }

        protected int c() {
            int c = super.c();
            if (this.level != 1) {
                c += qp.v(1, this.level);
            }
            if (this.fn != 0) {
                c += qp.v(2, this.fn);
            }
            return this.fo != 0 ? c + qp.v(3, this.fo) : c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof a)) {
                return false;
            }
            a aVar = (a) o;
            return (this.level == aVar.level && this.fn == aVar.fn && this.fo == aVar.fo) ? a((qq) aVar) : false;
        }

        public int hashCode() {
            return ((((((this.level + 527) * 31) + this.fn) * 31) + this.fo) * 31) + rQ();
        }
    }

    public static final class b extends qq<b> {
        private static volatile b[] fp;
        public int[] fq;
        public int fr;
        public boolean fs;
        public boolean ft;
        public int name;

        public b() {
            e();
        }

        public static b[] d() {
            if (fp == null) {
                synchronized (qu.azg) {
                    if (fp == null) {
                        fp = new b[0];
                    }
                }
            }
            return fp;
        }

        public void a(qp qpVar) throws IOException {
            if (this.ft) {
                qpVar.b(1, this.ft);
            }
            qpVar.t(2, this.fr);
            if (this.fq != null && this.fq.length > 0) {
                for (int t : this.fq) {
                    qpVar.t(3, t);
                }
            }
            if (this.name != 0) {
                qpVar.t(4, this.name);
            }
            if (this.fs) {
                qpVar.b(6, this.fs);
            }
            super.a(qpVar);
        }

        public /* synthetic */ qw b(qo qoVar) throws IOException {
            return c(qoVar);
        }

        protected int c() {
            int i = 0;
            int c = super.c();
            if (this.ft) {
                c += qp.c(1, this.ft);
            }
            int v = qp.v(2, this.fr) + c;
            if (this.fq == null || this.fq.length <= 0) {
                c = v;
            } else {
                for (int gZ : this.fq) {
                    i += qp.gZ(gZ);
                }
                c = (v + i) + (this.fq.length * 1);
            }
            if (this.name != 0) {
                c += qp.v(4, this.name);
            }
            return this.fs ? c + qp.c(6, this.fs) : c;
        }

        public b c(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                int b;
                switch (rz) {
                    case 0:
                        break;
                    case 8:
                        this.ft = qoVar.rD();
                        continue;
                    case 16:
                        this.fr = qoVar.rC();
                        continue;
                    case 24:
                        b = qz.b(qoVar, 24);
                        rz = this.fq == null ? 0 : this.fq.length;
                        Object obj = new int[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fq, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.rC();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.rC();
                        this.fq = obj;
                        continue;
                    case 26:
                        int gS = qoVar.gS(qoVar.rG());
                        b = qoVar.getPosition();
                        rz = 0;
                        while (qoVar.rL() > 0) {
                            qoVar.rC();
                            rz++;
                        }
                        qoVar.gU(b);
                        b = this.fq == null ? 0 : this.fq.length;
                        Object obj2 = new int[(rz + b)];
                        if (b != 0) {
                            System.arraycopy(this.fq, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = qoVar.rC();
                            b++;
                        }
                        this.fq = obj2;
                        qoVar.gT(gS);
                        continue;
                    case 32:
                        this.name = qoVar.rC();
                        continue;
                    case 48:
                        this.fs = qoVar.rD();
                        continue;
                    default:
                        if (!a(qoVar, rz)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public b e() {
            this.fq = qz.azj;
            this.fr = 0;
            this.name = 0;
            this.fs = false;
            this.ft = false;
            this.ayW = null;
            this.azh = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof b)) {
                return false;
            }
            b bVar = (b) o;
            return (qu.equals(this.fq, bVar.fq) && this.fr == bVar.fr && this.name == bVar.name && this.fs == bVar.fs && this.ft == bVar.ft) ? a((qq) bVar) : false;
        }

        public int hashCode() {
            int i = 1231;
            int hashCode = ((this.fs ? 1231 : 1237) + ((((((qu.hashCode(this.fq) + 527) * 31) + this.fr) * 31) + this.name) * 31)) * 31;
            if (!this.ft) {
                i = 1237;
            }
            return ((hashCode + i) * 31) + rQ();
        }
    }

    public static final class c extends qq<c> {
        private static volatile c[] fu;
        public String fv;
        public long fw;
        public long fx;
        public boolean fy;
        public long fz;

        public c() {
            g();
        }

        public static c[] f() {
            if (fu == null) {
                synchronized (qu.azg) {
                    if (fu == null) {
                        fu = new c[0];
                    }
                }
            }
            return fu;
        }

        public void a(qp qpVar) throws IOException {
            if (!this.fv.equals("")) {
                qpVar.b(1, this.fv);
            }
            if (this.fw != 0) {
                qpVar.b(2, this.fw);
            }
            if (this.fx != 2147483647L) {
                qpVar.b(3, this.fx);
            }
            if (this.fy) {
                qpVar.b(4, this.fy);
            }
            if (this.fz != 0) {
                qpVar.b(5, this.fz);
            }
            super.a(qpVar);
        }

        public /* synthetic */ qw b(qo qoVar) throws IOException {
            return d(qoVar);
        }

        protected int c() {
            int c = super.c();
            if (!this.fv.equals("")) {
                c += qp.j(1, this.fv);
            }
            if (this.fw != 0) {
                c += qp.d(2, this.fw);
            }
            if (this.fx != 2147483647L) {
                c += qp.d(3, this.fx);
            }
            if (this.fy) {
                c += qp.c(4, this.fy);
            }
            return this.fz != 0 ? c + qp.d(5, this.fz) : c;
        }

        public c d(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                switch (rz) {
                    case 0:
                        break;
                    case 10:
                        this.fv = qoVar.readString();
                        continue;
                    case 16:
                        this.fw = qoVar.rB();
                        continue;
                    case 24:
                        this.fx = qoVar.rB();
                        continue;
                    case 32:
                        this.fy = qoVar.rD();
                        continue;
                    case 40:
                        this.fz = qoVar.rB();
                        continue;
                    default:
                        if (!a(qoVar, rz)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof c)) {
                return false;
            }
            c cVar = (c) o;
            if (this.fv == null) {
                if (cVar.fv != null) {
                    return false;
                }
            } else if (!this.fv.equals(cVar.fv)) {
                return false;
            }
            return (this.fw == cVar.fw && this.fx == cVar.fx && this.fy == cVar.fy && this.fz == cVar.fz) ? a((qq) cVar) : false;
        }

        public c g() {
            this.fv = "";
            this.fw = 0;
            this.fx = 2147483647L;
            this.fy = false;
            this.fz = 0;
            this.ayW = null;
            this.azh = -1;
            return this;
        }

        public int hashCode() {
            return (((((this.fy ? 1231 : 1237) + (((((((this.fv == null ? 0 : this.fv.hashCode()) + 527) * 31) + ((int) (this.fw ^ (this.fw >>> 32)))) * 31) + ((int) (this.fx ^ (this.fx >>> 32)))) * 31)) * 31) + ((int) (this.fz ^ (this.fz >>> 32)))) * 31) + rQ();
        }
    }

    public static final class d extends qq<d> {
        public com.google.android.gms.internal.d.a[] fA;
        public com.google.android.gms.internal.d.a[] fB;
        public c[] fC;

        public d() {
            h();
        }

        public void a(qp qpVar) throws IOException {
            int i = 0;
            if (this.fA != null && this.fA.length > 0) {
                for (qw qwVar : this.fA) {
                    if (qwVar != null) {
                        qpVar.a(1, qwVar);
                    }
                }
            }
            if (this.fB != null && this.fB.length > 0) {
                for (qw qwVar2 : this.fB) {
                    if (qwVar2 != null) {
                        qpVar.a(2, qwVar2);
                    }
                }
            }
            if (this.fC != null && this.fC.length > 0) {
                while (i < this.fC.length) {
                    qw qwVar3 = this.fC[i];
                    if (qwVar3 != null) {
                        qpVar.a(3, qwVar3);
                    }
                    i++;
                }
            }
            super.a(qpVar);
        }

        public /* synthetic */ qw b(qo qoVar) throws IOException {
            return e(qoVar);
        }

        protected int c() {
            int i;
            int i2 = 0;
            int c = super.c();
            if (this.fA != null && this.fA.length > 0) {
                i = c;
                for (qw qwVar : this.fA) {
                    if (qwVar != null) {
                        i += qp.c(1, qwVar);
                    }
                }
                c = i;
            }
            if (this.fB != null && this.fB.length > 0) {
                i = c;
                for (qw qwVar2 : this.fB) {
                    if (qwVar2 != null) {
                        i += qp.c(2, qwVar2);
                    }
                }
                c = i;
            }
            if (this.fC != null && this.fC.length > 0) {
                while (i2 < this.fC.length) {
                    qw qwVar3 = this.fC[i2];
                    if (qwVar3 != null) {
                        c += qp.c(3, qwVar3);
                    }
                    i2++;
                }
            }
            return c;
        }

        public d e(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                int b;
                Object obj;
                switch (rz) {
                    case 0:
                        break;
                    case 10:
                        b = qz.b(qoVar, 10);
                        rz = this.fA == null ? 0 : this.fA.length;
                        obj = new com.google.android.gms.internal.d.a[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fA, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = new com.google.android.gms.internal.d.a();
                            qoVar.a(obj[rz]);
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = new com.google.android.gms.internal.d.a();
                        qoVar.a(obj[rz]);
                        this.fA = obj;
                        continue;
                    case 18:
                        b = qz.b(qoVar, 18);
                        rz = this.fB == null ? 0 : this.fB.length;
                        obj = new com.google.android.gms.internal.d.a[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fB, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = new com.google.android.gms.internal.d.a();
                            qoVar.a(obj[rz]);
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = new com.google.android.gms.internal.d.a();
                        qoVar.a(obj[rz]);
                        this.fB = obj;
                        continue;
                    case 26:
                        b = qz.b(qoVar, 26);
                        rz = this.fC == null ? 0 : this.fC.length;
                        obj = new c[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fC, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = new c();
                            qoVar.a(obj[rz]);
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = new c();
                        qoVar.a(obj[rz]);
                        this.fC = obj;
                        continue;
                    default:
                        if (!a(qoVar, rz)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof d)) {
                return false;
            }
            d dVar = (d) o;
            return (qu.equals(this.fA, dVar.fA) && qu.equals(this.fB, dVar.fB) && qu.equals(this.fC, dVar.fC)) ? a((qq) dVar) : false;
        }

        public d h() {
            this.fA = com.google.android.gms.internal.d.a.r();
            this.fB = com.google.android.gms.internal.d.a.r();
            this.fC = c.f();
            this.ayW = null;
            this.azh = -1;
            return this;
        }

        public int hashCode() {
            return ((((((qu.hashCode(this.fA) + 527) * 31) + qu.hashCode(this.fB)) * 31) + qu.hashCode(this.fC)) * 31) + rQ();
        }
    }

    public static final class e extends qq<e> {
        private static volatile e[] fD;
        public int key;
        public int value;

        public e() {
            j();
        }

        public static e[] i() {
            if (fD == null) {
                synchronized (qu.azg) {
                    if (fD == null) {
                        fD = new e[0];
                    }
                }
            }
            return fD;
        }

        public void a(qp qpVar) throws IOException {
            qpVar.t(1, this.key);
            qpVar.t(2, this.value);
            super.a(qpVar);
        }

        public /* synthetic */ qw b(qo qoVar) throws IOException {
            return f(qoVar);
        }

        protected int c() {
            return (super.c() + qp.v(1, this.key)) + qp.v(2, this.value);
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof e)) {
                return false;
            }
            e eVar = (e) o;
            return (this.key == eVar.key && this.value == eVar.value) ? a((qq) eVar) : false;
        }

        public e f(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                switch (rz) {
                    case 0:
                        break;
                    case 8:
                        this.key = qoVar.rC();
                        continue;
                    case 16:
                        this.value = qoVar.rC();
                        continue;
                    default:
                        if (!a(qoVar, rz)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public int hashCode() {
            return ((((this.key + 527) * 31) + this.value) * 31) + rQ();
        }

        public e j() {
            this.key = 0;
            this.value = 0;
            this.ayW = null;
            this.azh = -1;
            return this;
        }
    }

    public static final class f extends qq<f> {
        public String[] fE;
        public String[] fF;
        public com.google.android.gms.internal.d.a[] fG;
        public e[] fH;
        public b[] fI;
        public b[] fJ;
        public b[] fK;
        public g[] fL;
        public String fM;
        public String fN;
        public String fO;
        public a fP;
        public float fQ;
        public boolean fR;
        public String[] fS;
        public int fT;
        public String version;

        public f() {
            k();
        }

        public static f a(byte[] bArr) throws qv {
            return (f) qw.a(new f(), bArr);
        }

        public void a(qp qpVar) throws IOException {
            int i = 0;
            if (this.fF != null && this.fF.length > 0) {
                for (String str : this.fF) {
                    if (str != null) {
                        qpVar.b(1, str);
                    }
                }
            }
            if (this.fG != null && this.fG.length > 0) {
                for (qw qwVar : this.fG) {
                    if (qwVar != null) {
                        qpVar.a(2, qwVar);
                    }
                }
            }
            if (this.fH != null && this.fH.length > 0) {
                for (qw qwVar2 : this.fH) {
                    if (qwVar2 != null) {
                        qpVar.a(3, qwVar2);
                    }
                }
            }
            if (this.fI != null && this.fI.length > 0) {
                for (qw qwVar22 : this.fI) {
                    if (qwVar22 != null) {
                        qpVar.a(4, qwVar22);
                    }
                }
            }
            if (this.fJ != null && this.fJ.length > 0) {
                for (qw qwVar222 : this.fJ) {
                    if (qwVar222 != null) {
                        qpVar.a(5, qwVar222);
                    }
                }
            }
            if (this.fK != null && this.fK.length > 0) {
                for (qw qwVar2222 : this.fK) {
                    if (qwVar2222 != null) {
                        qpVar.a(6, qwVar2222);
                    }
                }
            }
            if (this.fL != null && this.fL.length > 0) {
                for (qw qwVar22222 : this.fL) {
                    if (qwVar22222 != null) {
                        qpVar.a(7, qwVar22222);
                    }
                }
            }
            if (!this.fM.equals("")) {
                qpVar.b(9, this.fM);
            }
            if (!this.fN.equals("")) {
                qpVar.b(10, this.fN);
            }
            if (!this.fO.equals("0")) {
                qpVar.b(12, this.fO);
            }
            if (!this.version.equals("")) {
                qpVar.b(13, this.version);
            }
            if (this.fP != null) {
                qpVar.a(14, this.fP);
            }
            if (Float.floatToIntBits(this.fQ) != Float.floatToIntBits(0.0f)) {
                qpVar.b(15, this.fQ);
            }
            if (this.fS != null && this.fS.length > 0) {
                for (String str2 : this.fS) {
                    if (str2 != null) {
                        qpVar.b(16, str2);
                    }
                }
            }
            if (this.fT != 0) {
                qpVar.t(17, this.fT);
            }
            if (this.fR) {
                qpVar.b(18, this.fR);
            }
            if (this.fE != null && this.fE.length > 0) {
                while (i < this.fE.length) {
                    String str3 = this.fE[i];
                    if (str3 != null) {
                        qpVar.b(19, str3);
                    }
                    i++;
                }
            }
            super.a(qpVar);
        }

        public /* synthetic */ qw b(qo qoVar) throws IOException {
            return g(qoVar);
        }

        protected int c() {
            int i;
            int i2;
            int i3;
            int i4 = 0;
            int c = super.c();
            if (this.fF == null || this.fF.length <= 0) {
                i = c;
            } else {
                i2 = 0;
                i3 = 0;
                for (String str : this.fF) {
                    if (str != null) {
                        i3++;
                        i2 += qp.dk(str);
                    }
                }
                i = (c + i2) + (i3 * 1);
            }
            if (this.fG != null && this.fG.length > 0) {
                i2 = i;
                for (qw qwVar : this.fG) {
                    if (qwVar != null) {
                        i2 += qp.c(2, qwVar);
                    }
                }
                i = i2;
            }
            if (this.fH != null && this.fH.length > 0) {
                i2 = i;
                for (qw qwVar2 : this.fH) {
                    if (qwVar2 != null) {
                        i2 += qp.c(3, qwVar2);
                    }
                }
                i = i2;
            }
            if (this.fI != null && this.fI.length > 0) {
                i2 = i;
                for (qw qwVar22 : this.fI) {
                    if (qwVar22 != null) {
                        i2 += qp.c(4, qwVar22);
                    }
                }
                i = i2;
            }
            if (this.fJ != null && this.fJ.length > 0) {
                i2 = i;
                for (qw qwVar222 : this.fJ) {
                    if (qwVar222 != null) {
                        i2 += qp.c(5, qwVar222);
                    }
                }
                i = i2;
            }
            if (this.fK != null && this.fK.length > 0) {
                i2 = i;
                for (qw qwVar2222 : this.fK) {
                    if (qwVar2222 != null) {
                        i2 += qp.c(6, qwVar2222);
                    }
                }
                i = i2;
            }
            if (this.fL != null && this.fL.length > 0) {
                i2 = i;
                for (qw qwVar22222 : this.fL) {
                    if (qwVar22222 != null) {
                        i2 += qp.c(7, qwVar22222);
                    }
                }
                i = i2;
            }
            if (!this.fM.equals("")) {
                i += qp.j(9, this.fM);
            }
            if (!this.fN.equals("")) {
                i += qp.j(10, this.fN);
            }
            if (!this.fO.equals("0")) {
                i += qp.j(12, this.fO);
            }
            if (!this.version.equals("")) {
                i += qp.j(13, this.version);
            }
            if (this.fP != null) {
                i += qp.c(14, this.fP);
            }
            if (Float.floatToIntBits(this.fQ) != Float.floatToIntBits(0.0f)) {
                i += qp.c(15, this.fQ);
            }
            if (this.fS != null && this.fS.length > 0) {
                i3 = 0;
                c = 0;
                for (String str2 : this.fS) {
                    if (str2 != null) {
                        c++;
                        i3 += qp.dk(str2);
                    }
                }
                i = (i + i3) + (c * 2);
            }
            if (this.fT != 0) {
                i += qp.v(17, this.fT);
            }
            if (this.fR) {
                i += qp.c(18, this.fR);
            }
            if (this.fE == null || this.fE.length <= 0) {
                return i;
            }
            i2 = 0;
            i3 = 0;
            while (i4 < this.fE.length) {
                String str3 = this.fE[i4];
                if (str3 != null) {
                    i3++;
                    i2 += qp.dk(str3);
                }
                i4++;
            }
            return (i + i2) + (i3 * 2);
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof f)) {
                return false;
            }
            f fVar = (f) o;
            if (!qu.equals(this.fE, fVar.fE) || !qu.equals(this.fF, fVar.fF) || !qu.equals(this.fG, fVar.fG) || !qu.equals(this.fH, fVar.fH) || !qu.equals(this.fI, fVar.fI) || !qu.equals(this.fJ, fVar.fJ) || !qu.equals(this.fK, fVar.fK) || !qu.equals(this.fL, fVar.fL)) {
                return false;
            }
            if (this.fM == null) {
                if (fVar.fM != null) {
                    return false;
                }
            } else if (!this.fM.equals(fVar.fM)) {
                return false;
            }
            if (this.fN == null) {
                if (fVar.fN != null) {
                    return false;
                }
            } else if (!this.fN.equals(fVar.fN)) {
                return false;
            }
            if (this.fO == null) {
                if (fVar.fO != null) {
                    return false;
                }
            } else if (!this.fO.equals(fVar.fO)) {
                return false;
            }
            if (this.version == null) {
                if (fVar.version != null) {
                    return false;
                }
            } else if (!this.version.equals(fVar.version)) {
                return false;
            }
            if (this.fP == null) {
                if (fVar.fP != null) {
                    return false;
                }
            } else if (!this.fP.equals(fVar.fP)) {
                return false;
            }
            return (Float.floatToIntBits(this.fQ) == Float.floatToIntBits(fVar.fQ) && this.fR == fVar.fR && qu.equals(this.fS, fVar.fS) && this.fT == fVar.fT) ? a((qq) fVar) : false;
        }

        public f g(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                int b;
                Object obj;
                switch (rz) {
                    case 0:
                        break;
                    case 10:
                        b = qz.b(qoVar, 10);
                        rz = this.fF == null ? 0 : this.fF.length;
                        obj = new String[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fF, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.readString();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.readString();
                        this.fF = obj;
                        continue;
                    case 18:
                        b = qz.b(qoVar, 18);
                        rz = this.fG == null ? 0 : this.fG.length;
                        obj = new com.google.android.gms.internal.d.a[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fG, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = new com.google.android.gms.internal.d.a();
                            qoVar.a(obj[rz]);
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = new com.google.android.gms.internal.d.a();
                        qoVar.a(obj[rz]);
                        this.fG = obj;
                        continue;
                    case 26:
                        b = qz.b(qoVar, 26);
                        rz = this.fH == null ? 0 : this.fH.length;
                        obj = new e[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fH, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = new e();
                            qoVar.a(obj[rz]);
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = new e();
                        qoVar.a(obj[rz]);
                        this.fH = obj;
                        continue;
                    case 34:
                        b = qz.b(qoVar, 34);
                        rz = this.fI == null ? 0 : this.fI.length;
                        obj = new b[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fI, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = new b();
                            qoVar.a(obj[rz]);
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = new b();
                        qoVar.a(obj[rz]);
                        this.fI = obj;
                        continue;
                    case 42:
                        b = qz.b(qoVar, 42);
                        rz = this.fJ == null ? 0 : this.fJ.length;
                        obj = new b[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fJ, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = new b();
                            qoVar.a(obj[rz]);
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = new b();
                        qoVar.a(obj[rz]);
                        this.fJ = obj;
                        continue;
                    case AdSize.PORTRAIT_AD_HEIGHT /*50*/:
                        b = qz.b(qoVar, 50);
                        rz = this.fK == null ? 0 : this.fK.length;
                        obj = new b[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fK, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = new b();
                            qoVar.a(obj[rz]);
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = new b();
                        qoVar.a(obj[rz]);
                        this.fK = obj;
                        continue;
                    case 58:
                        b = qz.b(qoVar, 58);
                        rz = this.fL == null ? 0 : this.fL.length;
                        obj = new g[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fL, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = new g();
                            qoVar.a(obj[rz]);
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = new g();
                        qoVar.a(obj[rz]);
                        this.fL = obj;
                        continue;
                    case 74:
                        this.fM = qoVar.readString();
                        continue;
                    case 82:
                        this.fN = qoVar.readString();
                        continue;
                    case 98:
                        this.fO = qoVar.readString();
                        continue;
                    case 106:
                        this.version = qoVar.readString();
                        continue;
                    case 114:
                        if (this.fP == null) {
                            this.fP = new a();
                        }
                        qoVar.a(this.fP);
                        continue;
                    case 125:
                        this.fQ = qoVar.readFloat();
                        continue;
                    case 130:
                        b = qz.b(qoVar, 130);
                        rz = this.fS == null ? 0 : this.fS.length;
                        obj = new String[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fS, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.readString();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.readString();
                        this.fS = obj;
                        continue;
                    case 136:
                        this.fT = qoVar.rC();
                        continue;
                    case 144:
                        this.fR = qoVar.rD();
                        continue;
                    case 154:
                        b = qz.b(qoVar, 154);
                        rz = this.fE == null ? 0 : this.fE.length;
                        obj = new String[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fE, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.readString();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.readString();
                        this.fE = obj;
                        continue;
                    default:
                        if (!a(qoVar, rz)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.version == null ? 0 : this.version.hashCode()) + (((this.fO == null ? 0 : this.fO.hashCode()) + (((this.fN == null ? 0 : this.fN.hashCode()) + (((this.fM == null ? 0 : this.fM.hashCode()) + ((((((((((((((((qu.hashCode(this.fE) + 527) * 31) + qu.hashCode(this.fF)) * 31) + qu.hashCode(this.fG)) * 31) + qu.hashCode(this.fH)) * 31) + qu.hashCode(this.fI)) * 31) + qu.hashCode(this.fJ)) * 31) + qu.hashCode(this.fK)) * 31) + qu.hashCode(this.fL)) * 31)) * 31)) * 31)) * 31)) * 31;
            if (this.fP != null) {
                i = this.fP.hashCode();
            }
            return (((((((this.fR ? 1231 : 1237) + ((((hashCode + i) * 31) + Float.floatToIntBits(this.fQ)) * 31)) * 31) + qu.hashCode(this.fS)) * 31) + this.fT) * 31) + rQ();
        }

        public f k() {
            this.fE = qz.azo;
            this.fF = qz.azo;
            this.fG = com.google.android.gms.internal.d.a.r();
            this.fH = e.i();
            this.fI = b.d();
            this.fJ = b.d();
            this.fK = b.d();
            this.fL = g.l();
            this.fM = "";
            this.fN = "";
            this.fO = "0";
            this.version = "";
            this.fP = null;
            this.fQ = 0.0f;
            this.fR = false;
            this.fS = qz.azo;
            this.fT = 0;
            this.ayW = null;
            this.azh = -1;
            return this;
        }
    }

    public static final class g extends qq<g> {
        private static volatile g[] fU;
        public int[] fV;
        public int[] fW;
        public int[] fX;
        public int[] fY;
        public int[] fZ;
        public int[] ga;
        public int[] gb;
        public int[] gc;
        public int[] gd;
        public int[] ge;

        public g() {
            m();
        }

        public static g[] l() {
            if (fU == null) {
                synchronized (qu.azg) {
                    if (fU == null) {
                        fU = new g[0];
                    }
                }
            }
            return fU;
        }

        public void a(qp qpVar) throws IOException {
            int i = 0;
            if (this.fV != null && this.fV.length > 0) {
                for (int t : this.fV) {
                    qpVar.t(1, t);
                }
            }
            if (this.fW != null && this.fW.length > 0) {
                for (int t2 : this.fW) {
                    qpVar.t(2, t2);
                }
            }
            if (this.fX != null && this.fX.length > 0) {
                for (int t22 : this.fX) {
                    qpVar.t(3, t22);
                }
            }
            if (this.fY != null && this.fY.length > 0) {
                for (int t222 : this.fY) {
                    qpVar.t(4, t222);
                }
            }
            if (this.fZ != null && this.fZ.length > 0) {
                for (int t2222 : this.fZ) {
                    qpVar.t(5, t2222);
                }
            }
            if (this.ga != null && this.ga.length > 0) {
                for (int t22222 : this.ga) {
                    qpVar.t(6, t22222);
                }
            }
            if (this.gb != null && this.gb.length > 0) {
                for (int t222222 : this.gb) {
                    qpVar.t(7, t222222);
                }
            }
            if (this.gc != null && this.gc.length > 0) {
                for (int t2222222 : this.gc) {
                    qpVar.t(8, t2222222);
                }
            }
            if (this.gd != null && this.gd.length > 0) {
                for (int t22222222 : this.gd) {
                    qpVar.t(9, t22222222);
                }
            }
            if (this.ge != null && this.ge.length > 0) {
                while (i < this.ge.length) {
                    qpVar.t(10, this.ge[i]);
                    i++;
                }
            }
            super.a(qpVar);
        }

        public /* synthetic */ qw b(qo qoVar) throws IOException {
            return h(qoVar);
        }

        protected int c() {
            int i;
            int i2;
            int i3 = 0;
            int c = super.c();
            if (this.fV == null || this.fV.length <= 0) {
                i = c;
            } else {
                i2 = 0;
                for (int gZ : this.fV) {
                    i2 += qp.gZ(gZ);
                }
                i = (c + i2) + (this.fV.length * 1);
            }
            if (this.fW != null && this.fW.length > 0) {
                c = 0;
                for (int gZ2 : this.fW) {
                    c += qp.gZ(gZ2);
                }
                i = (i + c) + (this.fW.length * 1);
            }
            if (this.fX != null && this.fX.length > 0) {
                c = 0;
                for (int gZ22 : this.fX) {
                    c += qp.gZ(gZ22);
                }
                i = (i + c) + (this.fX.length * 1);
            }
            if (this.fY != null && this.fY.length > 0) {
                c = 0;
                for (int gZ222 : this.fY) {
                    c += qp.gZ(gZ222);
                }
                i = (i + c) + (this.fY.length * 1);
            }
            if (this.fZ != null && this.fZ.length > 0) {
                c = 0;
                for (int gZ2222 : this.fZ) {
                    c += qp.gZ(gZ2222);
                }
                i = (i + c) + (this.fZ.length * 1);
            }
            if (this.ga != null && this.ga.length > 0) {
                c = 0;
                for (int gZ22222 : this.ga) {
                    c += qp.gZ(gZ22222);
                }
                i = (i + c) + (this.ga.length * 1);
            }
            if (this.gb != null && this.gb.length > 0) {
                c = 0;
                for (int gZ222222 : this.gb) {
                    c += qp.gZ(gZ222222);
                }
                i = (i + c) + (this.gb.length * 1);
            }
            if (this.gc != null && this.gc.length > 0) {
                c = 0;
                for (int gZ2222222 : this.gc) {
                    c += qp.gZ(gZ2222222);
                }
                i = (i + c) + (this.gc.length * 1);
            }
            if (this.gd != null && this.gd.length > 0) {
                c = 0;
                for (int gZ22222222 : this.gd) {
                    c += qp.gZ(gZ22222222);
                }
                i = (i + c) + (this.gd.length * 1);
            }
            if (this.ge == null || this.ge.length <= 0) {
                return i;
            }
            i2 = 0;
            while (i3 < this.ge.length) {
                i2 += qp.gZ(this.ge[i3]);
                i3++;
            }
            return (i + i2) + (this.ge.length * 1);
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof g)) {
                return false;
            }
            g gVar = (g) o;
            return (qu.equals(this.fV, gVar.fV) && qu.equals(this.fW, gVar.fW) && qu.equals(this.fX, gVar.fX) && qu.equals(this.fY, gVar.fY) && qu.equals(this.fZ, gVar.fZ) && qu.equals(this.ga, gVar.ga) && qu.equals(this.gb, gVar.gb) && qu.equals(this.gc, gVar.gc) && qu.equals(this.gd, gVar.gd) && qu.equals(this.ge, gVar.ge)) ? a((qq) gVar) : false;
        }

        public g h(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                int b;
                Object obj;
                int gS;
                Object obj2;
                switch (rz) {
                    case 0:
                        break;
                    case 8:
                        b = qz.b(qoVar, 8);
                        rz = this.fV == null ? 0 : this.fV.length;
                        obj = new int[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fV, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.rC();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.rC();
                        this.fV = obj;
                        continue;
                    case 10:
                        gS = qoVar.gS(qoVar.rG());
                        b = qoVar.getPosition();
                        rz = 0;
                        while (qoVar.rL() > 0) {
                            qoVar.rC();
                            rz++;
                        }
                        qoVar.gU(b);
                        b = this.fV == null ? 0 : this.fV.length;
                        obj2 = new int[(rz + b)];
                        if (b != 0) {
                            System.arraycopy(this.fV, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = qoVar.rC();
                            b++;
                        }
                        this.fV = obj2;
                        qoVar.gT(gS);
                        continue;
                    case 16:
                        b = qz.b(qoVar, 16);
                        rz = this.fW == null ? 0 : this.fW.length;
                        obj = new int[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fW, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.rC();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.rC();
                        this.fW = obj;
                        continue;
                    case 18:
                        gS = qoVar.gS(qoVar.rG());
                        b = qoVar.getPosition();
                        rz = 0;
                        while (qoVar.rL() > 0) {
                            qoVar.rC();
                            rz++;
                        }
                        qoVar.gU(b);
                        b = this.fW == null ? 0 : this.fW.length;
                        obj2 = new int[(rz + b)];
                        if (b != 0) {
                            System.arraycopy(this.fW, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = qoVar.rC();
                            b++;
                        }
                        this.fW = obj2;
                        qoVar.gT(gS);
                        continue;
                    case 24:
                        b = qz.b(qoVar, 24);
                        rz = this.fX == null ? 0 : this.fX.length;
                        obj = new int[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fX, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.rC();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.rC();
                        this.fX = obj;
                        continue;
                    case 26:
                        gS = qoVar.gS(qoVar.rG());
                        b = qoVar.getPosition();
                        rz = 0;
                        while (qoVar.rL() > 0) {
                            qoVar.rC();
                            rz++;
                        }
                        qoVar.gU(b);
                        b = this.fX == null ? 0 : this.fX.length;
                        obj2 = new int[(rz + b)];
                        if (b != 0) {
                            System.arraycopy(this.fX, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = qoVar.rC();
                            b++;
                        }
                        this.fX = obj2;
                        qoVar.gT(gS);
                        continue;
                    case 32:
                        b = qz.b(qoVar, 32);
                        rz = this.fY == null ? 0 : this.fY.length;
                        obj = new int[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fY, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.rC();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.rC();
                        this.fY = obj;
                        continue;
                    case 34:
                        gS = qoVar.gS(qoVar.rG());
                        b = qoVar.getPosition();
                        rz = 0;
                        while (qoVar.rL() > 0) {
                            qoVar.rC();
                            rz++;
                        }
                        qoVar.gU(b);
                        b = this.fY == null ? 0 : this.fY.length;
                        obj2 = new int[(rz + b)];
                        if (b != 0) {
                            System.arraycopy(this.fY, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = qoVar.rC();
                            b++;
                        }
                        this.fY = obj2;
                        qoVar.gT(gS);
                        continue;
                    case 40:
                        b = qz.b(qoVar, 40);
                        rz = this.fZ == null ? 0 : this.fZ.length;
                        obj = new int[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fZ, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.rC();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.rC();
                        this.fZ = obj;
                        continue;
                    case 42:
                        gS = qoVar.gS(qoVar.rG());
                        b = qoVar.getPosition();
                        rz = 0;
                        while (qoVar.rL() > 0) {
                            qoVar.rC();
                            rz++;
                        }
                        qoVar.gU(b);
                        b = this.fZ == null ? 0 : this.fZ.length;
                        obj2 = new int[(rz + b)];
                        if (b != 0) {
                            System.arraycopy(this.fZ, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = qoVar.rC();
                            b++;
                        }
                        this.fZ = obj2;
                        qoVar.gT(gS);
                        continue;
                    case 48:
                        b = qz.b(qoVar, 48);
                        rz = this.ga == null ? 0 : this.ga.length;
                        obj = new int[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.ga, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.rC();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.rC();
                        this.ga = obj;
                        continue;
                    case AdSize.PORTRAIT_AD_HEIGHT /*50*/:
                        gS = qoVar.gS(qoVar.rG());
                        b = qoVar.getPosition();
                        rz = 0;
                        while (qoVar.rL() > 0) {
                            qoVar.rC();
                            rz++;
                        }
                        qoVar.gU(b);
                        b = this.ga == null ? 0 : this.ga.length;
                        obj2 = new int[(rz + b)];
                        if (b != 0) {
                            System.arraycopy(this.ga, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = qoVar.rC();
                            b++;
                        }
                        this.ga = obj2;
                        qoVar.gT(gS);
                        continue;
                    case 56:
                        b = qz.b(qoVar, 56);
                        rz = this.gb == null ? 0 : this.gb.length;
                        obj = new int[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.gb, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.rC();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.rC();
                        this.gb = obj;
                        continue;
                    case 58:
                        gS = qoVar.gS(qoVar.rG());
                        b = qoVar.getPosition();
                        rz = 0;
                        while (qoVar.rL() > 0) {
                            qoVar.rC();
                            rz++;
                        }
                        qoVar.gU(b);
                        b = this.gb == null ? 0 : this.gb.length;
                        obj2 = new int[(rz + b)];
                        if (b != 0) {
                            System.arraycopy(this.gb, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = qoVar.rC();
                            b++;
                        }
                        this.gb = obj2;
                        qoVar.gT(gS);
                        continue;
                    case AccessibilityNodeInfoCompat.ACTION_ACCESSIBILITY_FOCUS /*64*/:
                        b = qz.b(qoVar, 64);
                        rz = this.gc == null ? 0 : this.gc.length;
                        obj = new int[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.gc, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.rC();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.rC();
                        this.gc = obj;
                        continue;
                    case 66:
                        gS = qoVar.gS(qoVar.rG());
                        b = qoVar.getPosition();
                        rz = 0;
                        while (qoVar.rL() > 0) {
                            qoVar.rC();
                            rz++;
                        }
                        qoVar.gU(b);
                        b = this.gc == null ? 0 : this.gc.length;
                        obj2 = new int[(rz + b)];
                        if (b != 0) {
                            System.arraycopy(this.gc, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = qoVar.rC();
                            b++;
                        }
                        this.gc = obj2;
                        qoVar.gT(gS);
                        continue;
                    case 72:
                        b = qz.b(qoVar, 72);
                        rz = this.gd == null ? 0 : this.gd.length;
                        obj = new int[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.gd, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.rC();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.rC();
                        this.gd = obj;
                        continue;
                    case 74:
                        gS = qoVar.gS(qoVar.rG());
                        b = qoVar.getPosition();
                        rz = 0;
                        while (qoVar.rL() > 0) {
                            qoVar.rC();
                            rz++;
                        }
                        qoVar.gU(b);
                        b = this.gd == null ? 0 : this.gd.length;
                        obj2 = new int[(rz + b)];
                        if (b != 0) {
                            System.arraycopy(this.gd, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = qoVar.rC();
                            b++;
                        }
                        this.gd = obj2;
                        qoVar.gT(gS);
                        continue;
                    case 80:
                        b = qz.b(qoVar, 80);
                        rz = this.ge == null ? 0 : this.ge.length;
                        obj = new int[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.ge, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.rC();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.rC();
                        this.ge = obj;
                        continue;
                    case 82:
                        gS = qoVar.gS(qoVar.rG());
                        b = qoVar.getPosition();
                        rz = 0;
                        while (qoVar.rL() > 0) {
                            qoVar.rC();
                            rz++;
                        }
                        qoVar.gU(b);
                        b = this.ge == null ? 0 : this.ge.length;
                        obj2 = new int[(rz + b)];
                        if (b != 0) {
                            System.arraycopy(this.ge, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = qoVar.rC();
                            b++;
                        }
                        this.ge = obj2;
                        qoVar.gT(gS);
                        continue;
                    default:
                        if (!a(qoVar, rz)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public int hashCode() {
            return ((((((((((((((((((((qu.hashCode(this.fV) + 527) * 31) + qu.hashCode(this.fW)) * 31) + qu.hashCode(this.fX)) * 31) + qu.hashCode(this.fY)) * 31) + qu.hashCode(this.fZ)) * 31) + qu.hashCode(this.ga)) * 31) + qu.hashCode(this.gb)) * 31) + qu.hashCode(this.gc)) * 31) + qu.hashCode(this.gd)) * 31) + qu.hashCode(this.ge)) * 31) + rQ();
        }

        public g m() {
            this.fV = qz.azj;
            this.fW = qz.azj;
            this.fX = qz.azj;
            this.fY = qz.azj;
            this.fZ = qz.azj;
            this.ga = qz.azj;
            this.gb = qz.azj;
            this.gc = qz.azj;
            this.gd = qz.azj;
            this.ge = qz.azj;
            this.ayW = null;
            this.azh = -1;
            return this;
        }
    }

    public static final class h extends qq<h> {
        public static final qr<com.google.android.gms.internal.d.a, h> gf = qr.a(11, h.class, 810);
        private static final h[] gg = new h[0];
        public int[] gh;
        public int[] gi;
        public int[] gj;
        public int gk;
        public int[] gl;
        public int gm;
        public int gn;

        public h() {
            n();
        }

        public void a(qp qpVar) throws IOException {
            int i = 0;
            if (this.gh != null && this.gh.length > 0) {
                for (int t : this.gh) {
                    qpVar.t(1, t);
                }
            }
            if (this.gi != null && this.gi.length > 0) {
                for (int t2 : this.gi) {
                    qpVar.t(2, t2);
                }
            }
            if (this.gj != null && this.gj.length > 0) {
                for (int t22 : this.gj) {
                    qpVar.t(3, t22);
                }
            }
            if (this.gk != 0) {
                qpVar.t(4, this.gk);
            }
            if (this.gl != null && this.gl.length > 0) {
                while (i < this.gl.length) {
                    qpVar.t(5, this.gl[i]);
                    i++;
                }
            }
            if (this.gm != 0) {
                qpVar.t(6, this.gm);
            }
            if (this.gn != 0) {
                qpVar.t(7, this.gn);
            }
            super.a(qpVar);
        }

        public /* synthetic */ qw b(qo qoVar) throws IOException {
            return i(qoVar);
        }

        protected int c() {
            int i;
            int i2;
            int i3 = 0;
            int c = super.c();
            if (this.gh == null || this.gh.length <= 0) {
                i = c;
            } else {
                i2 = 0;
                for (int gZ : this.gh) {
                    i2 += qp.gZ(gZ);
                }
                i = (c + i2) + (this.gh.length * 1);
            }
            if (this.gi != null && this.gi.length > 0) {
                c = 0;
                for (int gZ2 : this.gi) {
                    c += qp.gZ(gZ2);
                }
                i = (i + c) + (this.gi.length * 1);
            }
            if (this.gj != null && this.gj.length > 0) {
                c = 0;
                for (int gZ22 : this.gj) {
                    c += qp.gZ(gZ22);
                }
                i = (i + c) + (this.gj.length * 1);
            }
            if (this.gk != 0) {
                i += qp.v(4, this.gk);
            }
            if (this.gl != null && this.gl.length > 0) {
                i2 = 0;
                while (i3 < this.gl.length) {
                    i2 += qp.gZ(this.gl[i3]);
                    i3++;
                }
                i = (i + i2) + (this.gl.length * 1);
            }
            if (this.gm != 0) {
                i += qp.v(6, this.gm);
            }
            return this.gn != 0 ? i + qp.v(7, this.gn) : i;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof h)) {
                return false;
            }
            h hVar = (h) o;
            return (qu.equals(this.gh, hVar.gh) && qu.equals(this.gi, hVar.gi) && qu.equals(this.gj, hVar.gj) && this.gk == hVar.gk && qu.equals(this.gl, hVar.gl) && this.gm == hVar.gm && this.gn == hVar.gn) ? a((qq) hVar) : false;
        }

        public int hashCode() {
            return ((((((((((((((qu.hashCode(this.gh) + 527) * 31) + qu.hashCode(this.gi)) * 31) + qu.hashCode(this.gj)) * 31) + this.gk) * 31) + qu.hashCode(this.gl)) * 31) + this.gm) * 31) + this.gn) * 31) + rQ();
        }

        public h i(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                int b;
                Object obj;
                int gS;
                Object obj2;
                switch (rz) {
                    case 0:
                        break;
                    case 8:
                        b = qz.b(qoVar, 8);
                        rz = this.gh == null ? 0 : this.gh.length;
                        obj = new int[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.gh, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.rC();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.rC();
                        this.gh = obj;
                        continue;
                    case 10:
                        gS = qoVar.gS(qoVar.rG());
                        b = qoVar.getPosition();
                        rz = 0;
                        while (qoVar.rL() > 0) {
                            qoVar.rC();
                            rz++;
                        }
                        qoVar.gU(b);
                        b = this.gh == null ? 0 : this.gh.length;
                        obj2 = new int[(rz + b)];
                        if (b != 0) {
                            System.arraycopy(this.gh, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = qoVar.rC();
                            b++;
                        }
                        this.gh = obj2;
                        qoVar.gT(gS);
                        continue;
                    case 16:
                        b = qz.b(qoVar, 16);
                        rz = this.gi == null ? 0 : this.gi.length;
                        obj = new int[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.gi, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.rC();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.rC();
                        this.gi = obj;
                        continue;
                    case 18:
                        gS = qoVar.gS(qoVar.rG());
                        b = qoVar.getPosition();
                        rz = 0;
                        while (qoVar.rL() > 0) {
                            qoVar.rC();
                            rz++;
                        }
                        qoVar.gU(b);
                        b = this.gi == null ? 0 : this.gi.length;
                        obj2 = new int[(rz + b)];
                        if (b != 0) {
                            System.arraycopy(this.gi, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = qoVar.rC();
                            b++;
                        }
                        this.gi = obj2;
                        qoVar.gT(gS);
                        continue;
                    case 24:
                        b = qz.b(qoVar, 24);
                        rz = this.gj == null ? 0 : this.gj.length;
                        obj = new int[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.gj, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.rC();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.rC();
                        this.gj = obj;
                        continue;
                    case 26:
                        gS = qoVar.gS(qoVar.rG());
                        b = qoVar.getPosition();
                        rz = 0;
                        while (qoVar.rL() > 0) {
                            qoVar.rC();
                            rz++;
                        }
                        qoVar.gU(b);
                        b = this.gj == null ? 0 : this.gj.length;
                        obj2 = new int[(rz + b)];
                        if (b != 0) {
                            System.arraycopy(this.gj, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = qoVar.rC();
                            b++;
                        }
                        this.gj = obj2;
                        qoVar.gT(gS);
                        continue;
                    case 32:
                        this.gk = qoVar.rC();
                        continue;
                    case 40:
                        b = qz.b(qoVar, 40);
                        rz = this.gl == null ? 0 : this.gl.length;
                        obj = new int[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.gl, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.rC();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.rC();
                        this.gl = obj;
                        continue;
                    case 42:
                        gS = qoVar.gS(qoVar.rG());
                        b = qoVar.getPosition();
                        rz = 0;
                        while (qoVar.rL() > 0) {
                            qoVar.rC();
                            rz++;
                        }
                        qoVar.gU(b);
                        b = this.gl == null ? 0 : this.gl.length;
                        obj2 = new int[(rz + b)];
                        if (b != 0) {
                            System.arraycopy(this.gl, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = qoVar.rC();
                            b++;
                        }
                        this.gl = obj2;
                        qoVar.gT(gS);
                        continue;
                    case 48:
                        this.gm = qoVar.rC();
                        continue;
                    case 56:
                        this.gn = qoVar.rC();
                        continue;
                    default:
                        if (!a(qoVar, rz)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public h n() {
            this.gh = qz.azj;
            this.gi = qz.azj;
            this.gj = qz.azj;
            this.gk = 0;
            this.gl = qz.azj;
            this.gm = 0;
            this.gn = 0;
            this.ayW = null;
            this.azh = -1;
            return this;
        }
    }

    public static final class i extends qq<i> {
        private static volatile i[] go;
        public com.google.android.gms.internal.d.a gp;
        public d gq;
        public String name;

        public i() {
            p();
        }

        public static i[] o() {
            if (go == null) {
                synchronized (qu.azg) {
                    if (go == null) {
                        go = new i[0];
                    }
                }
            }
            return go;
        }

        public void a(qp qpVar) throws IOException {
            if (!this.name.equals("")) {
                qpVar.b(1, this.name);
            }
            if (this.gp != null) {
                qpVar.a(2, this.gp);
            }
            if (this.gq != null) {
                qpVar.a(3, this.gq);
            }
            super.a(qpVar);
        }

        public /* synthetic */ qw b(qo qoVar) throws IOException {
            return j(qoVar);
        }

        protected int c() {
            int c = super.c();
            if (!this.name.equals("")) {
                c += qp.j(1, this.name);
            }
            if (this.gp != null) {
                c += qp.c(2, this.gp);
            }
            return this.gq != null ? c + qp.c(3, this.gq) : c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof i)) {
                return false;
            }
            i iVar = (i) o;
            if (this.name == null) {
                if (iVar.name != null) {
                    return false;
                }
            } else if (!this.name.equals(iVar.name)) {
                return false;
            }
            if (this.gp == null) {
                if (iVar.gp != null) {
                    return false;
                }
            } else if (!this.gp.equals(iVar.gp)) {
                return false;
            }
            if (this.gq == null) {
                if (iVar.gq != null) {
                    return false;
                }
            } else if (!this.gq.equals(iVar.gq)) {
                return false;
            }
            return a((qq) iVar);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.gp == null ? 0 : this.gp.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + 527) * 31)) * 31;
            if (this.gq != null) {
                i = this.gq.hashCode();
            }
            return ((hashCode + i) * 31) + rQ();
        }

        public i j(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                switch (rz) {
                    case 0:
                        break;
                    case 10:
                        this.name = qoVar.readString();
                        continue;
                    case 18:
                        if (this.gp == null) {
                            this.gp = new com.google.android.gms.internal.d.a();
                        }
                        qoVar.a(this.gp);
                        continue;
                    case 26:
                        if (this.gq == null) {
                            this.gq = new d();
                        }
                        qoVar.a(this.gq);
                        continue;
                    default:
                        if (!a(qoVar, rz)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public i p() {
            this.name = "";
            this.gp = null;
            this.gq = null;
            this.ayW = null;
            this.azh = -1;
            return this;
        }
    }

    public static final class j extends qq<j> {
        public i[] gr;
        public f gs;
        public String gt;

        public j() {
            q();
        }

        public static j b(byte[] bArr) throws qv {
            return (j) qw.a(new j(), bArr);
        }

        public void a(qp qpVar) throws IOException {
            if (this.gr != null && this.gr.length > 0) {
                for (qw qwVar : this.gr) {
                    if (qwVar != null) {
                        qpVar.a(1, qwVar);
                    }
                }
            }
            if (this.gs != null) {
                qpVar.a(2, this.gs);
            }
            if (!this.gt.equals("")) {
                qpVar.b(3, this.gt);
            }
            super.a(qpVar);
        }

        public /* synthetic */ qw b(qo qoVar) throws IOException {
            return k(qoVar);
        }

        protected int c() {
            int c = super.c();
            if (this.gr != null && this.gr.length > 0) {
                for (qw qwVar : this.gr) {
                    if (qwVar != null) {
                        c += qp.c(1, qwVar);
                    }
                }
            }
            if (this.gs != null) {
                c += qp.c(2, this.gs);
            }
            return !this.gt.equals("") ? c + qp.j(3, this.gt) : c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof j)) {
                return false;
            }
            j jVar = (j) o;
            if (!qu.equals(this.gr, jVar.gr)) {
                return false;
            }
            if (this.gs == null) {
                if (jVar.gs != null) {
                    return false;
                }
            } else if (!this.gs.equals(jVar.gs)) {
                return false;
            }
            if (this.gt == null) {
                if (jVar.gt != null) {
                    return false;
                }
            } else if (!this.gt.equals(jVar.gt)) {
                return false;
            }
            return a((qq) jVar);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.gs == null ? 0 : this.gs.hashCode()) + ((qu.hashCode(this.gr) + 527) * 31)) * 31;
            if (this.gt != null) {
                i = this.gt.hashCode();
            }
            return ((hashCode + i) * 31) + rQ();
        }

        public j k(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                switch (rz) {
                    case 0:
                        break;
                    case 10:
                        int b = qz.b(qoVar, 10);
                        rz = this.gr == null ? 0 : this.gr.length;
                        Object obj = new i[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.gr, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = new i();
                            qoVar.a(obj[rz]);
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = new i();
                        qoVar.a(obj[rz]);
                        this.gr = obj;
                        continue;
                    case 18:
                        if (this.gs == null) {
                            this.gs = new f();
                        }
                        qoVar.a(this.gs);
                        continue;
                    case 26:
                        this.gt = qoVar.readString();
                        continue;
                    default:
                        if (!a(qoVar, rz)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public j q() {
            this.gr = i.o();
            this.gs = null;
            this.gt = "";
            this.ayW = null;
            this.azh = -1;
            return this;
        }
    }
}
