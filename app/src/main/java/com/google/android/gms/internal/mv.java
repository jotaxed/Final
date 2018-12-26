package com.google.android.gms.internal;

import java.io.IOException;

public interface mv {

    public static final class a extends qq<a> {
        public a[] afu;

        public static final class a extends qq<a> {
            private static volatile a[] afv;
            public String afw;
            public String afx;
            public int viewId;

            public a() {
                mY();
            }

            public static a[] mX() {
                if (afv == null) {
                    synchronized (qu.azg) {
                        if (afv == null) {
                            afv = new a[0];
                        }
                    }
                }
                return afv;
            }

            public void a(qp qpVar) throws IOException {
                if (!this.afw.equals("")) {
                    qpVar.b(1, this.afw);
                }
                if (!this.afx.equals("")) {
                    qpVar.b(2, this.afx);
                }
                if (this.viewId != 0) {
                    qpVar.t(3, this.viewId);
                }
                super.a(qpVar);
            }

            public /* synthetic */ qw b(qo qoVar) throws IOException {
                return o(qoVar);
            }

            protected int c() {
                int c = super.c();
                if (!this.afw.equals("")) {
                    c += qp.j(1, this.afw);
                }
                if (!this.afx.equals("")) {
                    c += qp.j(2, this.afx);
                }
                return this.viewId != 0 ? c + qp.v(3, this.viewId) : c;
            }

            public boolean equals(Object o) {
                if (o == this) {
                    return true;
                }
                if (!(o instanceof a)) {
                    return false;
                }
                a aVar = (a) o;
                if (this.afw == null) {
                    if (aVar.afw != null) {
                        return false;
                    }
                } else if (!this.afw.equals(aVar.afw)) {
                    return false;
                }
                if (this.afx == null) {
                    if (aVar.afx != null) {
                        return false;
                    }
                } else if (!this.afx.equals(aVar.afx)) {
                    return false;
                }
                return this.viewId == aVar.viewId ? a((qq) aVar) : false;
            }

            public int hashCode() {
                int i = 0;
                int hashCode = ((this.afw == null ? 0 : this.afw.hashCode()) + 527) * 31;
                if (this.afx != null) {
                    i = this.afx.hashCode();
                }
                return ((((hashCode + i) * 31) + this.viewId) * 31) + rQ();
            }

            public a mY() {
                this.afw = "";
                this.afx = "";
                this.viewId = 0;
                this.ayW = null;
                this.azh = -1;
                return this;
            }

            public a o(qo qoVar) throws IOException {
                while (true) {
                    int rz = qoVar.rz();
                    switch (rz) {
                        case 0:
                            break;
                        case 10:
                            this.afw = qoVar.readString();
                            continue;
                        case 18:
                            this.afx = qoVar.readString();
                            continue;
                        case 24:
                            this.viewId = qoVar.rC();
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
        }

        public a() {
            mW();
        }

        public void a(qp qpVar) throws IOException {
            if (this.afu != null && this.afu.length > 0) {
                for (qw qwVar : this.afu) {
                    if (qwVar != null) {
                        qpVar.a(1, qwVar);
                    }
                }
            }
            super.a(qpVar);
        }

        public /* synthetic */ qw b(qo qoVar) throws IOException {
            return n(qoVar);
        }

        protected int c() {
            int c = super.c();
            if (this.afu != null && this.afu.length > 0) {
                for (qw qwVar : this.afu) {
                    if (qwVar != null) {
                        c += qp.c(1, qwVar);
                    }
                }
            }
            return c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof a)) {
                return false;
            }
            a aVar = (a) o;
            return qu.equals(this.afu, aVar.afu) ? a((qq) aVar) : false;
        }

        public int hashCode() {
            return ((qu.hashCode(this.afu) + 527) * 31) + rQ();
        }

        public a mW() {
            this.afu = a.mX();
            this.ayW = null;
            this.azh = -1;
            return this;
        }

        public a n(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                switch (rz) {
                    case 0:
                        break;
                    case 10:
                        int b = qz.b(qoVar, 10);
                        rz = this.afu == null ? 0 : this.afu.length;
                        Object obj = new a[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.afu, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = new a();
                            qoVar.a(obj[rz]);
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = new a();
                        qoVar.a(obj[rz]);
                        this.afu = obj;
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
    }

    public static final class b extends qq<b> {
        private static volatile b[] afy;
        public d afz;
        public String name;

        public b() {
            na();
        }

        public static b[] mZ() {
            if (afy == null) {
                synchronized (qu.azg) {
                    if (afy == null) {
                        afy = new b[0];
                    }
                }
            }
            return afy;
        }

        public void a(qp qpVar) throws IOException {
            if (!this.name.equals("")) {
                qpVar.b(1, this.name);
            }
            if (this.afz != null) {
                qpVar.a(2, this.afz);
            }
            super.a(qpVar);
        }

        public /* synthetic */ qw b(qo qoVar) throws IOException {
            return p(qoVar);
        }

        protected int c() {
            int c = super.c();
            if (!this.name.equals("")) {
                c += qp.j(1, this.name);
            }
            return this.afz != null ? c + qp.c(2, this.afz) : c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof b)) {
                return false;
            }
            b bVar = (b) o;
            if (this.name == null) {
                if (bVar.name != null) {
                    return false;
                }
            } else if (!this.name.equals(bVar.name)) {
                return false;
            }
            if (this.afz == null) {
                if (bVar.afz != null) {
                    return false;
                }
            } else if (!this.afz.equals(bVar.afz)) {
                return false;
            }
            return a((qq) bVar);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.name == null ? 0 : this.name.hashCode()) + 527) * 31;
            if (this.afz != null) {
                i = this.afz.hashCode();
            }
            return ((hashCode + i) * 31) + rQ();
        }

        public b na() {
            this.name = "";
            this.afz = null;
            this.ayW = null;
            this.azh = -1;
            return this;
        }

        public b p(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                switch (rz) {
                    case 0:
                        break;
                    case 10:
                        this.name = qoVar.readString();
                        continue;
                    case 18:
                        if (this.afz == null) {
                            this.afz = new d();
                        }
                        qoVar.a(this.afz);
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
    }

    public static final class c extends qq<c> {
        public b[] afA;
        public String type;

        public c() {
            nb();
        }

        public void a(qp qpVar) throws IOException {
            if (!this.type.equals("")) {
                qpVar.b(1, this.type);
            }
            if (this.afA != null && this.afA.length > 0) {
                for (qw qwVar : this.afA) {
                    if (qwVar != null) {
                        qpVar.a(2, qwVar);
                    }
                }
            }
            super.a(qpVar);
        }

        public /* synthetic */ qw b(qo qoVar) throws IOException {
            return q(qoVar);
        }

        protected int c() {
            int c = super.c();
            if (!this.type.equals("")) {
                c += qp.j(1, this.type);
            }
            if (this.afA == null || this.afA.length <= 0) {
                return c;
            }
            int i = c;
            for (qw qwVar : this.afA) {
                if (qwVar != null) {
                    i += qp.c(2, qwVar);
                }
            }
            return i;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof c)) {
                return false;
            }
            c cVar = (c) o;
            if (this.type == null) {
                if (cVar.type != null) {
                    return false;
                }
            } else if (!this.type.equals(cVar.type)) {
                return false;
            }
            return qu.equals(this.afA, cVar.afA) ? a((qq) cVar) : false;
        }

        public int hashCode() {
            return (((((this.type == null ? 0 : this.type.hashCode()) + 527) * 31) + qu.hashCode(this.afA)) * 31) + rQ();
        }

        public c nb() {
            this.type = "";
            this.afA = b.mZ();
            this.ayW = null;
            this.azh = -1;
            return this;
        }

        public c q(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                switch (rz) {
                    case 0:
                        break;
                    case 10:
                        this.type = qoVar.readString();
                        continue;
                    case 18:
                        int b = qz.b(qoVar, 18);
                        rz = this.afA == null ? 0 : this.afA.length;
                        Object obj = new b[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.afA, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = new b();
                            qoVar.a(obj[rz]);
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = new b();
                        qoVar.a(obj[rz]);
                        this.afA = obj;
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
    }

    public static final class d extends qq<d> {
        public String NJ;
        public boolean afB;
        public long afC;
        public double afD;
        public c afE;

        public d() {
            nc();
        }

        public void a(qp qpVar) throws IOException {
            if (this.afB) {
                qpVar.b(1, this.afB);
            }
            if (!this.NJ.equals("")) {
                qpVar.b(2, this.NJ);
            }
            if (this.afC != 0) {
                qpVar.b(3, this.afC);
            }
            if (Double.doubleToLongBits(this.afD) != Double.doubleToLongBits(0.0d)) {
                qpVar.a(4, this.afD);
            }
            if (this.afE != null) {
                qpVar.a(5, this.afE);
            }
            super.a(qpVar);
        }

        public /* synthetic */ qw b(qo qoVar) throws IOException {
            return r(qoVar);
        }

        protected int c() {
            int c = super.c();
            if (this.afB) {
                c += qp.c(1, this.afB);
            }
            if (!this.NJ.equals("")) {
                c += qp.j(2, this.NJ);
            }
            if (this.afC != 0) {
                c += qp.d(3, this.afC);
            }
            if (Double.doubleToLongBits(this.afD) != Double.doubleToLongBits(0.0d)) {
                c += qp.b(4, this.afD);
            }
            return this.afE != null ? c + qp.c(5, this.afE) : c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof d)) {
                return false;
            }
            d dVar = (d) o;
            if (this.afB != dVar.afB) {
                return false;
            }
            if (this.NJ == null) {
                if (dVar.NJ != null) {
                    return false;
                }
            } else if (!this.NJ.equals(dVar.NJ)) {
                return false;
            }
            if (this.afC != dVar.afC || Double.doubleToLongBits(this.afD) != Double.doubleToLongBits(dVar.afD)) {
                return false;
            }
            if (this.afE == null) {
                if (dVar.afE != null) {
                    return false;
                }
            } else if (!this.afE.equals(dVar.afE)) {
                return false;
            }
            return a((qq) dVar);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = (((this.NJ == null ? 0 : this.NJ.hashCode()) + (((this.afB ? 1231 : 1237) + 527) * 31)) * 31) + ((int) (this.afC ^ (this.afC >>> 32)));
            long doubleToLongBits = Double.doubleToLongBits(this.afD);
            hashCode = ((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31;
            if (this.afE != null) {
                i = this.afE.hashCode();
            }
            return ((hashCode + i) * 31) + rQ();
        }

        public d nc() {
            this.afB = false;
            this.NJ = "";
            this.afC = 0;
            this.afD = 0.0d;
            this.afE = null;
            this.ayW = null;
            this.azh = -1;
            return this;
        }

        public d r(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                switch (rz) {
                    case 0:
                        break;
                    case 8:
                        this.afB = qoVar.rD();
                        continue;
                    case 18:
                        this.NJ = qoVar.readString();
                        continue;
                    case 24:
                        this.afC = qoVar.rB();
                        continue;
                    case 33:
                        this.afD = qoVar.readDouble();
                        continue;
                    case 42:
                        if (this.afE == null) {
                            this.afE = new c();
                        }
                        qoVar.a(this.afE);
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
    }
}
