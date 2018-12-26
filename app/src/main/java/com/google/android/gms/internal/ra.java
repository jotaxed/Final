package com.google.android.gms.internal;

import android.support.v4.util.TimeUtils;
import com.google.ads.AdSize;
import java.io.IOException;
import java.util.Arrays;

public interface ra {

    public static final class a extends qq<a> {
        public String[] azr;
        public String[] azs;
        public int[] azt;

        public a() {
            sa();
        }

        public void a(qp qpVar) throws IOException {
            int i = 0;
            if (this.azr != null && this.azr.length > 0) {
                for (String str : this.azr) {
                    if (str != null) {
                        qpVar.b(1, str);
                    }
                }
            }
            if (this.azs != null && this.azs.length > 0) {
                for (String str2 : this.azs) {
                    if (str2 != null) {
                        qpVar.b(2, str2);
                    }
                }
            }
            if (this.azt != null && this.azt.length > 0) {
                while (i < this.azt.length) {
                    qpVar.t(3, this.azt[i]);
                    i++;
                }
            }
            super.a(qpVar);
        }

        public /* synthetic */ qw b(qo qoVar) throws IOException {
            return y(qoVar);
        }

        protected int c() {
            int i;
            int i2;
            int i3;
            int i4 = 0;
            int c = super.c();
            if (this.azr == null || this.azr.length <= 0) {
                i = c;
            } else {
                i2 = 0;
                i3 = 0;
                for (String str : this.azr) {
                    if (str != null) {
                        i3++;
                        i2 += qp.dk(str);
                    }
                }
                i = (c + i2) + (i3 * 1);
            }
            if (this.azs != null && this.azs.length > 0) {
                i3 = 0;
                c = 0;
                for (String str2 : this.azs) {
                    if (str2 != null) {
                        c++;
                        i3 += qp.dk(str2);
                    }
                }
                i = (i + i3) + (c * 1);
            }
            if (this.azt == null || this.azt.length <= 0) {
                return i;
            }
            i2 = 0;
            while (i4 < this.azt.length) {
                i2 += qp.gZ(this.azt[i4]);
                i4++;
            }
            return (i + i2) + (this.azt.length * 1);
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof a)) {
                return false;
            }
            a aVar = (a) o;
            return (qu.equals(this.azr, aVar.azr) && qu.equals(this.azs, aVar.azs) && qu.equals(this.azt, aVar.azt)) ? a((qq) aVar) : false;
        }

        public int hashCode() {
            return ((((((qu.hashCode(this.azr) + 527) * 31) + qu.hashCode(this.azs)) * 31) + qu.hashCode(this.azt)) * 31) + rQ();
        }

        public a sa() {
            this.azr = qz.azo;
            this.azs = qz.azo;
            this.azt = qz.azj;
            this.ayW = null;
            this.azh = -1;
            return this;
        }

        public a y(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                int b;
                Object obj;
                switch (rz) {
                    case 0:
                        break;
                    case 10:
                        b = qz.b(qoVar, 10);
                        rz = this.azr == null ? 0 : this.azr.length;
                        obj = new String[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.azr, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.readString();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.readString();
                        this.azr = obj;
                        continue;
                    case 18:
                        b = qz.b(qoVar, 18);
                        rz = this.azs == null ? 0 : this.azs.length;
                        obj = new String[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.azs, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.readString();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.readString();
                        this.azs = obj;
                        continue;
                    case 24:
                        b = qz.b(qoVar, 24);
                        rz = this.azt == null ? 0 : this.azt.length;
                        obj = new int[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.azt, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.rC();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.rC();
                        this.azt = obj;
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
                        b = this.azt == null ? 0 : this.azt.length;
                        Object obj2 = new int[(rz + b)];
                        if (b != 0) {
                            System.arraycopy(this.azt, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = qoVar.rC();
                            b++;
                        }
                        this.azt = obj2;
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
    }

    public static final class b extends qq<b> {
        public int azu;
        public String azv;
        public String version;

        public b() {
            sb();
        }

        public void a(qp qpVar) throws IOException {
            if (this.azu != 0) {
                qpVar.t(1, this.azu);
            }
            if (!this.azv.equals("")) {
                qpVar.b(2, this.azv);
            }
            if (!this.version.equals("")) {
                qpVar.b(3, this.version);
            }
            super.a(qpVar);
        }

        public /* synthetic */ qw b(qo qoVar) throws IOException {
            return z(qoVar);
        }

        protected int c() {
            int c = super.c();
            if (this.azu != 0) {
                c += qp.v(1, this.azu);
            }
            if (!this.azv.equals("")) {
                c += qp.j(2, this.azv);
            }
            return !this.version.equals("") ? c + qp.j(3, this.version) : c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof b)) {
                return false;
            }
            b bVar = (b) o;
            if (this.azu != bVar.azu) {
                return false;
            }
            if (this.azv == null) {
                if (bVar.azv != null) {
                    return false;
                }
            } else if (!this.azv.equals(bVar.azv)) {
                return false;
            }
            if (this.version == null) {
                if (bVar.version != null) {
                    return false;
                }
            } else if (!this.version.equals(bVar.version)) {
                return false;
            }
            return a((qq) bVar);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.azv == null ? 0 : this.azv.hashCode()) + ((this.azu + 527) * 31)) * 31;
            if (this.version != null) {
                i = this.version.hashCode();
            }
            return ((hashCode + i) * 31) + rQ();
        }

        public b sb() {
            this.azu = 0;
            this.azv = "";
            this.version = "";
            this.ayW = null;
            this.azh = -1;
            return this;
        }

        public b z(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                switch (rz) {
                    case 0:
                        break;
                    case 8:
                        rz = qoVar.rC();
                        switch (rz) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                            case 13:
                            case 14:
                            case 15:
                            case 16:
                            case 17:
                            case 18:
                            case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                            case 20:
                            case 21:
                            case 22:
                                this.azu = rz;
                                break;
                            default:
                                continue;
                        }
                    case 18:
                        this.azv = qoVar.readString();
                        continue;
                    case 26:
                        this.version = qoVar.readString();
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
        public d[] azA;
        public b azB;
        public byte[] azC;
        public byte[] azD;
        public byte[] azE;
        public a azF;
        public String azG;
        public long azH;
        public long azw;
        public int azx;
        public int azy;
        public boolean azz;
        public String tag;

        public c() {
            sc();
        }

        public c A(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                switch (rz) {
                    case 0:
                        break;
                    case 8:
                        this.azw = qoVar.rB();
                        continue;
                    case 18:
                        this.tag = qoVar.readString();
                        continue;
                    case 26:
                        int b = qz.b(qoVar, 26);
                        rz = this.azA == null ? 0 : this.azA.length;
                        Object obj = new d[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.azA, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = new d();
                            qoVar.a(obj[rz]);
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = new d();
                        qoVar.a(obj[rz]);
                        this.azA = obj;
                        continue;
                    case AdSize.PORTRAIT_AD_HEIGHT /*50*/:
                        this.azC = qoVar.readBytes();
                        continue;
                    case 58:
                        if (this.azF == null) {
                            this.azF = new a();
                        }
                        qoVar.a(this.azF);
                        continue;
                    case 66:
                        this.azD = qoVar.readBytes();
                        continue;
                    case 74:
                        if (this.azB == null) {
                            this.azB = new b();
                        }
                        qoVar.a(this.azB);
                        continue;
                    case 80:
                        this.azz = qoVar.rD();
                        continue;
                    case 88:
                        this.azx = qoVar.rC();
                        continue;
                    case 96:
                        this.azy = qoVar.rC();
                        continue;
                    case 106:
                        this.azE = qoVar.readBytes();
                        continue;
                    case 114:
                        this.azG = qoVar.readString();
                        continue;
                    case 120:
                        this.azH = qoVar.rF();
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
            if (this.azw != 0) {
                qpVar.b(1, this.azw);
            }
            if (!this.tag.equals("")) {
                qpVar.b(2, this.tag);
            }
            if (this.azA != null && this.azA.length > 0) {
                for (qw qwVar : this.azA) {
                    if (qwVar != null) {
                        qpVar.a(3, qwVar);
                    }
                }
            }
            if (!Arrays.equals(this.azC, qz.azq)) {
                qpVar.a(6, this.azC);
            }
            if (this.azF != null) {
                qpVar.a(7, this.azF);
            }
            if (!Arrays.equals(this.azD, qz.azq)) {
                qpVar.a(8, this.azD);
            }
            if (this.azB != null) {
                qpVar.a(9, this.azB);
            }
            if (this.azz) {
                qpVar.b(10, this.azz);
            }
            if (this.azx != 0) {
                qpVar.t(11, this.azx);
            }
            if (this.azy != 0) {
                qpVar.t(12, this.azy);
            }
            if (!Arrays.equals(this.azE, qz.azq)) {
                qpVar.a(13, this.azE);
            }
            if (!this.azG.equals("")) {
                qpVar.b(14, this.azG);
            }
            if (this.azH != 0) {
                qpVar.c(15, this.azH);
            }
            super.a(qpVar);
        }

        public /* synthetic */ qw b(qo qoVar) throws IOException {
            return A(qoVar);
        }

        protected int c() {
            int c = super.c();
            if (this.azw != 0) {
                c += qp.d(1, this.azw);
            }
            if (!this.tag.equals("")) {
                c += qp.j(2, this.tag);
            }
            if (this.azA != null && this.azA.length > 0) {
                int i = c;
                for (qw qwVar : this.azA) {
                    if (qwVar != null) {
                        i += qp.c(3, qwVar);
                    }
                }
                c = i;
            }
            if (!Arrays.equals(this.azC, qz.azq)) {
                c += qp.b(6, this.azC);
            }
            if (this.azF != null) {
                c += qp.c(7, this.azF);
            }
            if (!Arrays.equals(this.azD, qz.azq)) {
                c += qp.b(8, this.azD);
            }
            if (this.azB != null) {
                c += qp.c(9, this.azB);
            }
            if (this.azz) {
                c += qp.c(10, this.azz);
            }
            if (this.azx != 0) {
                c += qp.v(11, this.azx);
            }
            if (this.azy != 0) {
                c += qp.v(12, this.azy);
            }
            if (!Arrays.equals(this.azE, qz.azq)) {
                c += qp.b(13, this.azE);
            }
            if (!this.azG.equals("")) {
                c += qp.j(14, this.azG);
            }
            return this.azH != 0 ? c + qp.e(15, this.azH) : c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof c)) {
                return false;
            }
            c cVar = (c) o;
            if (this.azw != cVar.azw) {
                return false;
            }
            if (this.tag == null) {
                if (cVar.tag != null) {
                    return false;
                }
            } else if (!this.tag.equals(cVar.tag)) {
                return false;
            }
            if (this.azx != cVar.azx || this.azy != cVar.azy || this.azz != cVar.azz || !qu.equals(this.azA, cVar.azA)) {
                return false;
            }
            if (this.azB == null) {
                if (cVar.azB != null) {
                    return false;
                }
            } else if (!this.azB.equals(cVar.azB)) {
                return false;
            }
            if (!Arrays.equals(this.azC, cVar.azC) || !Arrays.equals(this.azD, cVar.azD) || !Arrays.equals(this.azE, cVar.azE)) {
                return false;
            }
            if (this.azF == null) {
                if (cVar.azF != null) {
                    return false;
                }
            } else if (!this.azF.equals(cVar.azF)) {
                return false;
            }
            if (this.azG == null) {
                if (cVar.azG != null) {
                    return false;
                }
            } else if (!this.azG.equals(cVar.azG)) {
                return false;
            }
            return this.azH == cVar.azH ? a((qq) cVar) : false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.azF == null ? 0 : this.azF.hashCode()) + (((((((((this.azB == null ? 0 : this.azB.hashCode()) + (((((this.azz ? 1231 : 1237) + (((((((this.tag == null ? 0 : this.tag.hashCode()) + ((((int) (this.azw ^ (this.azw >>> 32))) + 527) * 31)) * 31) + this.azx) * 31) + this.azy) * 31)) * 31) + qu.hashCode(this.azA)) * 31)) * 31) + Arrays.hashCode(this.azC)) * 31) + Arrays.hashCode(this.azD)) * 31) + Arrays.hashCode(this.azE)) * 31)) * 31;
            if (this.azG != null) {
                i = this.azG.hashCode();
            }
            return ((((hashCode + i) * 31) + ((int) (this.azH ^ (this.azH >>> 32)))) * 31) + rQ();
        }

        public c sc() {
            this.azw = 0;
            this.tag = "";
            this.azx = 0;
            this.azy = 0;
            this.azz = false;
            this.azA = d.sd();
            this.azB = null;
            this.azC = qz.azq;
            this.azD = qz.azq;
            this.azE = qz.azq;
            this.azF = null;
            this.azG = "";
            this.azH = 0;
            this.ayW = null;
            this.azh = -1;
            return this;
        }
    }

    public static final class d extends qq<d> {
        private static volatile d[] azI;
        public String fv;
        public String value;

        public d() {
            se();
        }

        public static d[] sd() {
            if (azI == null) {
                synchronized (qu.azg) {
                    if (azI == null) {
                        azI = new d[0];
                    }
                }
            }
            return azI;
        }

        public d B(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                switch (rz) {
                    case 0:
                        break;
                    case 10:
                        this.fv = qoVar.readString();
                        continue;
                    case 18:
                        this.value = qoVar.readString();
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
            if (!this.fv.equals("")) {
                qpVar.b(1, this.fv);
            }
            if (!this.value.equals("")) {
                qpVar.b(2, this.value);
            }
            super.a(qpVar);
        }

        public /* synthetic */ qw b(qo qoVar) throws IOException {
            return B(qoVar);
        }

        protected int c() {
            int c = super.c();
            if (!this.fv.equals("")) {
                c += qp.j(1, this.fv);
            }
            return !this.value.equals("") ? c + qp.j(2, this.value) : c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof d)) {
                return false;
            }
            d dVar = (d) o;
            if (this.fv == null) {
                if (dVar.fv != null) {
                    return false;
                }
            } else if (!this.fv.equals(dVar.fv)) {
                return false;
            }
            if (this.value == null) {
                if (dVar.value != null) {
                    return false;
                }
            } else if (!this.value.equals(dVar.value)) {
                return false;
            }
            return a((qq) dVar);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.fv == null ? 0 : this.fv.hashCode()) + 527) * 31;
            if (this.value != null) {
                i = this.value.hashCode();
            }
            return ((hashCode + i) * 31) + rQ();
        }

        public d se() {
            this.fv = "";
            this.value = "";
            this.ayW = null;
            this.azh = -1;
            return this;
        }
    }
}
