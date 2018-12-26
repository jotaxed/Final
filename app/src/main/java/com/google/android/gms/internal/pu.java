package com.google.android.gms.internal;

import com.google.android.gms.internal.c.f;
import com.google.android.gms.internal.c.j;
import java.io.IOException;

public interface pu {

    public static final class a extends qq<a> {
        public long auB;
        public j auC;
        public f gs;

        public a() {
            rc();
        }

        public static a l(byte[] bArr) throws qv {
            return (a) qw.a(new a(), bArr);
        }

        public void a(qp qpVar) throws IOException {
            qpVar.b(1, this.auB);
            if (this.gs != null) {
                qpVar.a(2, this.gs);
            }
            if (this.auC != null) {
                qpVar.a(3, this.auC);
            }
            super.a(qpVar);
        }

        public /* synthetic */ qw b(qo qoVar) throws IOException {
            return s(qoVar);
        }

        protected int c() {
            int c = super.c() + qp.d(1, this.auB);
            if (this.gs != null) {
                c += qp.c(2, this.gs);
            }
            return this.auC != null ? c + qp.c(3, this.auC) : c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof a)) {
                return false;
            }
            a aVar = (a) o;
            if (this.auB != aVar.auB) {
                return false;
            }
            if (this.gs == null) {
                if (aVar.gs != null) {
                    return false;
                }
            } else if (!this.gs.equals(aVar.gs)) {
                return false;
            }
            if (this.auC == null) {
                if (aVar.auC != null) {
                    return false;
                }
            } else if (!this.auC.equals(aVar.auC)) {
                return false;
            }
            return a((qq) aVar);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.gs == null ? 0 : this.gs.hashCode()) + ((((int) (this.auB ^ (this.auB >>> 32))) + 527) * 31)) * 31;
            if (this.auC != null) {
                i = this.auC.hashCode();
            }
            return ((hashCode + i) * 31) + rQ();
        }

        public a rc() {
            this.auB = 0;
            this.gs = null;
            this.auC = null;
            this.ayW = null;
            this.azh = -1;
            return this;
        }

        public a s(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                switch (rz) {
                    case 0:
                        break;
                    case 8:
                        this.auB = qoVar.rB();
                        continue;
                    case 18:
                        if (this.gs == null) {
                            this.gs = new f();
                        }
                        qoVar.a(this.gs);
                        continue;
                    case 26:
                        if (this.auC == null) {
                            this.auC = new j();
                        }
                        qoVar.a(this.auC);
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
