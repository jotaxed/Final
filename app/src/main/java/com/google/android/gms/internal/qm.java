package com.google.android.gms.internal;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.ads.AdSize;
import com.google.android.gms.location.LocationRequest;
import java.io.IOException;
import java.util.Arrays;

public final class qm extends qq<qm> {
    public a[] ayq;

    public static final class a extends qq<a> {
        private static volatile a[] ayr;
        public a ays;
        public String name;

        public static final class a extends qq<a> {
            private static volatile a[] ayt;
            public a ayu;
            public int type;

            public static final class a extends qq<a> {
                public int ayA;
                public int ayB;
                public boolean ayC;
                public a[] ayD;
                public a[] ayE;
                public String[] ayF;
                public long[] ayG;
                public float[] ayH;
                public long ayI;
                public byte[] ayv;
                public String ayw;
                public double ayx;
                public float ayy;
                public long ayz;

                public a() {
                    ry();
                }

                public void a(qp qpVar) throws IOException {
                    int i = 0;
                    if (!Arrays.equals(this.ayv, qz.azq)) {
                        qpVar.a(1, this.ayv);
                    }
                    if (!this.ayw.equals("")) {
                        qpVar.b(2, this.ayw);
                    }
                    if (Double.doubleToLongBits(this.ayx) != Double.doubleToLongBits(0.0d)) {
                        qpVar.a(3, this.ayx);
                    }
                    if (Float.floatToIntBits(this.ayy) != Float.floatToIntBits(0.0f)) {
                        qpVar.b(4, this.ayy);
                    }
                    if (this.ayz != 0) {
                        qpVar.b(5, this.ayz);
                    }
                    if (this.ayA != 0) {
                        qpVar.t(6, this.ayA);
                    }
                    if (this.ayB != 0) {
                        qpVar.u(7, this.ayB);
                    }
                    if (this.ayC) {
                        qpVar.b(8, this.ayC);
                    }
                    if (this.ayD != null && this.ayD.length > 0) {
                        for (qw qwVar : this.ayD) {
                            if (qwVar != null) {
                                qpVar.a(9, qwVar);
                            }
                        }
                    }
                    if (this.ayE != null && this.ayE.length > 0) {
                        for (qw qwVar2 : this.ayE) {
                            if (qwVar2 != null) {
                                qpVar.a(10, qwVar2);
                            }
                        }
                    }
                    if (this.ayF != null && this.ayF.length > 0) {
                        for (String str : this.ayF) {
                            if (str != null) {
                                qpVar.b(11, str);
                            }
                        }
                    }
                    if (this.ayG != null && this.ayG.length > 0) {
                        for (long b : this.ayG) {
                            qpVar.b(12, b);
                        }
                    }
                    if (this.ayI != 0) {
                        qpVar.b(13, this.ayI);
                    }
                    if (this.ayH != null && this.ayH.length > 0) {
                        while (i < this.ayH.length) {
                            qpVar.b(14, this.ayH[i]);
                            i++;
                        }
                    }
                    super.a(qpVar);
                }

                public /* synthetic */ qw b(qo qoVar) throws IOException {
                    return w(qoVar);
                }

                protected int c() {
                    int i;
                    int i2 = 0;
                    int c = super.c();
                    if (!Arrays.equals(this.ayv, qz.azq)) {
                        c += qp.b(1, this.ayv);
                    }
                    if (!this.ayw.equals("")) {
                        c += qp.j(2, this.ayw);
                    }
                    if (Double.doubleToLongBits(this.ayx) != Double.doubleToLongBits(0.0d)) {
                        c += qp.b(3, this.ayx);
                    }
                    if (Float.floatToIntBits(this.ayy) != Float.floatToIntBits(0.0f)) {
                        c += qp.c(4, this.ayy);
                    }
                    if (this.ayz != 0) {
                        c += qp.d(5, this.ayz);
                    }
                    if (this.ayA != 0) {
                        c += qp.v(6, this.ayA);
                    }
                    if (this.ayB != 0) {
                        c += qp.w(7, this.ayB);
                    }
                    if (this.ayC) {
                        c += qp.c(8, this.ayC);
                    }
                    if (this.ayD != null && this.ayD.length > 0) {
                        i = c;
                        for (qw qwVar : this.ayD) {
                            if (qwVar != null) {
                                i += qp.c(9, qwVar);
                            }
                        }
                        c = i;
                    }
                    if (this.ayE != null && this.ayE.length > 0) {
                        i = c;
                        for (qw qwVar2 : this.ayE) {
                            if (qwVar2 != null) {
                                i += qp.c(10, qwVar2);
                            }
                        }
                        c = i;
                    }
                    if (this.ayF != null && this.ayF.length > 0) {
                        int i3 = 0;
                        int i4 = 0;
                        for (String str : this.ayF) {
                            if (str != null) {
                                i4++;
                                i3 += qp.dk(str);
                            }
                        }
                        c = (c + i3) + (i4 * 1);
                    }
                    if (this.ayG != null && this.ayG.length > 0) {
                        i = 0;
                        while (i2 < this.ayG.length) {
                            i += qp.D(this.ayG[i2]);
                            i2++;
                        }
                        c = (c + i) + (this.ayG.length * 1);
                    }
                    if (this.ayI != 0) {
                        c += qp.d(13, this.ayI);
                    }
                    return (this.ayH == null || this.ayH.length <= 0) ? c : (c + (this.ayH.length * 4)) + (this.ayH.length * 1);
                }

                public boolean equals(Object o) {
                    if (o == this) {
                        return true;
                    }
                    if (!(o instanceof a)) {
                        return false;
                    }
                    a aVar = (a) o;
                    if (!Arrays.equals(this.ayv, aVar.ayv)) {
                        return false;
                    }
                    if (this.ayw == null) {
                        if (aVar.ayw != null) {
                            return false;
                        }
                    } else if (!this.ayw.equals(aVar.ayw)) {
                        return false;
                    }
                    return (Double.doubleToLongBits(this.ayx) == Double.doubleToLongBits(aVar.ayx) && Float.floatToIntBits(this.ayy) == Float.floatToIntBits(aVar.ayy) && this.ayz == aVar.ayz && this.ayA == aVar.ayA && this.ayB == aVar.ayB && this.ayC == aVar.ayC && qu.equals(this.ayD, aVar.ayD) && qu.equals(this.ayE, aVar.ayE) && qu.equals(this.ayF, aVar.ayF) && qu.equals(this.ayG, aVar.ayG) && qu.equals(this.ayH, aVar.ayH) && this.ayI == aVar.ayI) ? a((qq) aVar) : false;
                }

                public int hashCode() {
                    int hashCode = (this.ayw == null ? 0 : this.ayw.hashCode()) + ((Arrays.hashCode(this.ayv) + 527) * 31);
                    long doubleToLongBits = Double.doubleToLongBits(this.ayx);
                    return (((((((((((((((this.ayC ? 1231 : 1237) + (((((((((((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + Float.floatToIntBits(this.ayy)) * 31) + ((int) (this.ayz ^ (this.ayz >>> 32)))) * 31) + this.ayA) * 31) + this.ayB) * 31)) * 31) + qu.hashCode(this.ayD)) * 31) + qu.hashCode(this.ayE)) * 31) + qu.hashCode(this.ayF)) * 31) + qu.hashCode(this.ayG)) * 31) + qu.hashCode(this.ayH)) * 31) + ((int) (this.ayI ^ (this.ayI >>> 32)))) * 31) + rQ();
                }

                public a ry() {
                    this.ayv = qz.azq;
                    this.ayw = "";
                    this.ayx = 0.0d;
                    this.ayy = 0.0f;
                    this.ayz = 0;
                    this.ayA = 0;
                    this.ayB = 0;
                    this.ayC = false;
                    this.ayD = a.ru();
                    this.ayE = a.rw();
                    this.ayF = qz.azo;
                    this.ayG = qz.azk;
                    this.ayH = qz.azl;
                    this.ayI = 0;
                    this.ayW = null;
                    this.azh = -1;
                    return this;
                }

                public a w(qo qoVar) throws IOException {
                    while (true) {
                        int rz = qoVar.rz();
                        int b;
                        Object obj;
                        int gS;
                        switch (rz) {
                            case 0:
                                break;
                            case 10:
                                this.ayv = qoVar.readBytes();
                                continue;
                            case 18:
                                this.ayw = qoVar.readString();
                                continue;
                            case 25:
                                this.ayx = qoVar.readDouble();
                                continue;
                            case 37:
                                this.ayy = qoVar.readFloat();
                                continue;
                            case 40:
                                this.ayz = qoVar.rB();
                                continue;
                            case 48:
                                this.ayA = qoVar.rC();
                                continue;
                            case 56:
                                this.ayB = qoVar.rE();
                                continue;
                            case AccessibilityNodeInfoCompat.ACTION_ACCESSIBILITY_FOCUS /*64*/:
                                this.ayC = qoVar.rD();
                                continue;
                            case 74:
                                b = qz.b(qoVar, 74);
                                rz = this.ayD == null ? 0 : this.ayD.length;
                                obj = new a[(b + rz)];
                                if (rz != 0) {
                                    System.arraycopy(this.ayD, 0, obj, 0, rz);
                                }
                                while (rz < obj.length - 1) {
                                    obj[rz] = new a();
                                    qoVar.a(obj[rz]);
                                    qoVar.rz();
                                    rz++;
                                }
                                obj[rz] = new a();
                                qoVar.a(obj[rz]);
                                this.ayD = obj;
                                continue;
                            case 82:
                                b = qz.b(qoVar, 82);
                                rz = this.ayE == null ? 0 : this.ayE.length;
                                obj = new a[(b + rz)];
                                if (rz != 0) {
                                    System.arraycopy(this.ayE, 0, obj, 0, rz);
                                }
                                while (rz < obj.length - 1) {
                                    obj[rz] = new a();
                                    qoVar.a(obj[rz]);
                                    qoVar.rz();
                                    rz++;
                                }
                                obj[rz] = new a();
                                qoVar.a(obj[rz]);
                                this.ayE = obj;
                                continue;
                            case AdSize.LARGE_AD_HEIGHT /*90*/:
                                b = qz.b(qoVar, 90);
                                rz = this.ayF == null ? 0 : this.ayF.length;
                                obj = new String[(b + rz)];
                                if (rz != 0) {
                                    System.arraycopy(this.ayF, 0, obj, 0, rz);
                                }
                                while (rz < obj.length - 1) {
                                    obj[rz] = qoVar.readString();
                                    qoVar.rz();
                                    rz++;
                                }
                                obj[rz] = qoVar.readString();
                                this.ayF = obj;
                                continue;
                            case 96:
                                b = qz.b(qoVar, 96);
                                rz = this.ayG == null ? 0 : this.ayG.length;
                                obj = new long[(b + rz)];
                                if (rz != 0) {
                                    System.arraycopy(this.ayG, 0, obj, 0, rz);
                                }
                                while (rz < obj.length - 1) {
                                    obj[rz] = qoVar.rB();
                                    qoVar.rz();
                                    rz++;
                                }
                                obj[rz] = qoVar.rB();
                                this.ayG = obj;
                                continue;
                            case 98:
                                gS = qoVar.gS(qoVar.rG());
                                b = qoVar.getPosition();
                                rz = 0;
                                while (qoVar.rL() > 0) {
                                    qoVar.rB();
                                    rz++;
                                }
                                qoVar.gU(b);
                                b = this.ayG == null ? 0 : this.ayG.length;
                                Object obj2 = new long[(rz + b)];
                                if (b != 0) {
                                    System.arraycopy(this.ayG, 0, obj2, 0, b);
                                }
                                while (b < obj2.length) {
                                    obj2[b] = qoVar.rB();
                                    b++;
                                }
                                this.ayG = obj2;
                                qoVar.gT(gS);
                                continue;
                            case LocationRequest.PRIORITY_LOW_POWER /*104*/:
                                this.ayI = qoVar.rB();
                                continue;
                            case 114:
                                rz = qoVar.rG();
                                b = qoVar.gS(rz);
                                gS = rz / 4;
                                rz = this.ayH == null ? 0 : this.ayH.length;
                                Object obj3 = new float[(gS + rz)];
                                if (rz != 0) {
                                    System.arraycopy(this.ayH, 0, obj3, 0, rz);
                                }
                                while (rz < obj3.length) {
                                    obj3[rz] = qoVar.readFloat();
                                    rz++;
                                }
                                this.ayH = obj3;
                                qoVar.gT(b);
                                continue;
                            case 117:
                                b = qz.b(qoVar, 117);
                                rz = this.ayH == null ? 0 : this.ayH.length;
                                obj = new float[(b + rz)];
                                if (rz != 0) {
                                    System.arraycopy(this.ayH, 0, obj, 0, rz);
                                }
                                while (rz < obj.length - 1) {
                                    obj[rz] = qoVar.readFloat();
                                    qoVar.rz();
                                    rz++;
                                }
                                obj[rz] = qoVar.readFloat();
                                this.ayH = obj;
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
                rx();
            }

            public static a[] rw() {
                if (ayt == null) {
                    synchronized (qu.azg) {
                        if (ayt == null) {
                            ayt = new a[0];
                        }
                    }
                }
                return ayt;
            }

            public void a(qp qpVar) throws IOException {
                qpVar.t(1, this.type);
                if (this.ayu != null) {
                    qpVar.a(2, this.ayu);
                }
                super.a(qpVar);
            }

            public /* synthetic */ qw b(qo qoVar) throws IOException {
                return v(qoVar);
            }

            protected int c() {
                int c = super.c() + qp.v(1, this.type);
                return this.ayu != null ? c + qp.c(2, this.ayu) : c;
            }

            public boolean equals(Object o) {
                if (o == this) {
                    return true;
                }
                if (!(o instanceof a)) {
                    return false;
                }
                a aVar = (a) o;
                if (this.type != aVar.type) {
                    return false;
                }
                if (this.ayu == null) {
                    if (aVar.ayu != null) {
                        return false;
                    }
                } else if (!this.ayu.equals(aVar.ayu)) {
                    return false;
                }
                return a((qq) aVar);
            }

            public int hashCode() {
                return (((this.ayu == null ? 0 : this.ayu.hashCode()) + ((this.type + 527) * 31)) * 31) + rQ();
            }

            public a rx() {
                this.type = 1;
                this.ayu = null;
                this.ayW = null;
                this.azh = -1;
                return this;
            }

            public a v(qo qoVar) throws IOException {
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
                                    this.type = rz;
                                    break;
                                default:
                                    continue;
                            }
                        case 18:
                            if (this.ayu == null) {
                                this.ayu = new a();
                            }
                            qoVar.a(this.ayu);
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
            rv();
        }

        public static a[] ru() {
            if (ayr == null) {
                synchronized (qu.azg) {
                    if (ayr == null) {
                        ayr = new a[0];
                    }
                }
            }
            return ayr;
        }

        public void a(qp qpVar) throws IOException {
            qpVar.b(1, this.name);
            if (this.ays != null) {
                qpVar.a(2, this.ays);
            }
            super.a(qpVar);
        }

        public /* synthetic */ qw b(qo qoVar) throws IOException {
            return u(qoVar);
        }

        protected int c() {
            int c = super.c() + qp.j(1, this.name);
            return this.ays != null ? c + qp.c(2, this.ays) : c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof a)) {
                return false;
            }
            a aVar = (a) o;
            if (this.name == null) {
                if (aVar.name != null) {
                    return false;
                }
            } else if (!this.name.equals(aVar.name)) {
                return false;
            }
            if (this.ays == null) {
                if (aVar.ays != null) {
                    return false;
                }
            } else if (!this.ays.equals(aVar.ays)) {
                return false;
            }
            return a((qq) aVar);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.name == null ? 0 : this.name.hashCode()) + 527) * 31;
            if (this.ays != null) {
                i = this.ays.hashCode();
            }
            return ((hashCode + i) * 31) + rQ();
        }

        public a rv() {
            this.name = "";
            this.ays = null;
            this.ayW = null;
            this.azh = -1;
            return this;
        }

        public a u(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                switch (rz) {
                    case 0:
                        break;
                    case 10:
                        this.name = qoVar.readString();
                        continue;
                    case 18:
                        if (this.ays == null) {
                            this.ays = new a();
                        }
                        qoVar.a(this.ays);
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

    public qm() {
        rt();
    }

    public static qm n(byte[] bArr) throws qv {
        return (qm) qw.a(new qm(), bArr);
    }

    public void a(qp qpVar) throws IOException {
        if (this.ayq != null && this.ayq.length > 0) {
            for (qw qwVar : this.ayq) {
                if (qwVar != null) {
                    qpVar.a(1, qwVar);
                }
            }
        }
        super.a(qpVar);
    }

    public /* synthetic */ qw b(qo qoVar) throws IOException {
        return t(qoVar);
    }

    protected int c() {
        int c = super.c();
        if (this.ayq != null && this.ayq.length > 0) {
            for (qw qwVar : this.ayq) {
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
        if (!(o instanceof qm)) {
            return false;
        }
        qm qmVar = (qm) o;
        return qu.equals(this.ayq, qmVar.ayq) ? a((qq) qmVar) : false;
    }

    public int hashCode() {
        return ((qu.hashCode(this.ayq) + 527) * 31) + rQ();
    }

    public qm rt() {
        this.ayq = a.ru();
        this.ayW = null;
        this.azh = -1;
        return this;
    }

    public qm t(qo qoVar) throws IOException {
        while (true) {
            int rz = qoVar.rz();
            switch (rz) {
                case 0:
                    break;
                case 10:
                    int b = qz.b(qoVar, 10);
                    rz = this.ayq == null ? 0 : this.ayq.length;
                    Object obj = new a[(b + rz)];
                    if (rz != 0) {
                        System.arraycopy(this.ayq, 0, obj, 0, rz);
                    }
                    while (rz < obj.length - 1) {
                        obj[rz] = new a();
                        qoVar.a(obj[rz]);
                        qoVar.rz();
                        rz++;
                    }
                    obj[rz] = new a();
                    qoVar.a(obj[rz]);
                    this.ayq = obj;
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
