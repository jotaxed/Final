package com.google.android.gms.internal;

import android.os.Parcel;
import android.support.v4.util.TimeUtils;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.Person.AgeRange;
import com.google.android.gms.plus.model.people.Person.Cover;
import com.google.android.gms.plus.model.people.Person.Cover.CoverInfo;
import com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto;
import com.google.android.gms.plus.model.people.Person.Image;
import com.google.android.gms.plus.model.people.Person.Name;
import com.google.android.gms.plus.model.people.Person.Organizations;
import com.google.android.gms.plus.model.people.Person.PlacesLived;
import com.google.android.gms.plus.model.people.Person.Urls;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class pi extends ks implements Person {
    public static final pj CREATOR = new pj();
    private static final HashMap<String, com.google.android.gms.internal.kr.a<?, ?>> aom = new HashMap();
    String CE;
    final int CK;
    String FR;
    String OS;
    final Set<Integer> aon;
    int apA;
    String apB;
    List<h> apC;
    boolean apD;
    String apl;
    a apm;
    String apn;
    String apo;
    int app;
    b apq;
    String apr;
    c aps;
    boolean apt;
    d apu;
    String apv;
    int apw;
    List<f> apx;
    List<g> apy;
    int apz;
    int ow;
    String vf;

    public static final class a extends ks implements AgeRange {
        public static final pk CREATOR = new pk();
        private static final HashMap<String, com.google.android.gms.internal.kr.a<?, ?>> aom = new HashMap();
        final int CK;
        final Set<Integer> aon;
        int apE;
        int apF;

        static {
            aom.put("max", com.google.android.gms.internal.kr.a.i("max", 2));
            aom.put("min", com.google.android.gms.internal.kr.a.i("min", 3));
        }

        public a() {
            this.CK = 1;
            this.aon = new HashSet();
        }

        a(Set<Integer> set, int i, int i2, int i3) {
            this.aon = set;
            this.CK = i;
            this.apE = i2;
            this.apF = i3;
        }

        protected boolean a(com.google.android.gms.internal.kr.a aVar) {
            return this.aon.contains(Integer.valueOf(aVar.hR()));
        }

        protected Object b(com.google.android.gms.internal.kr.a aVar) {
            switch (aVar.hR()) {
                case 2:
                    return Integer.valueOf(this.apE);
                case 3:
                    return Integer.valueOf(this.apF);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + aVar.hR());
            }
        }

        public int describeContents() {
            pk pkVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            a aVar = (a) obj;
            for (com.google.android.gms.internal.kr.a aVar2 : aom.values()) {
                if (a(aVar2)) {
                    if (!aVar.a(aVar2)) {
                        return false;
                    }
                    if (!b(aVar2).equals(aVar.b(aVar2))) {
                        return false;
                    }
                } else if (aVar.a(aVar2)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return oM();
        }

        public int getMax() {
            return this.apE;
        }

        public int getMin() {
            return this.apF;
        }

        public HashMap<String, com.google.android.gms.internal.kr.a<?, ?>> hK() {
            return aom;
        }

        public boolean hasMax() {
            return this.aon.contains(Integer.valueOf(2));
        }

        public boolean hasMin() {
            return this.aon.contains(Integer.valueOf(3));
        }

        public int hashCode() {
            int i = 0;
            for (com.google.android.gms.internal.kr.a aVar : aom.values()) {
                int hashCode;
                if (a(aVar)) {
                    hashCode = b(aVar).hashCode() + (i + aVar.hR());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public a oM() {
            return this;
        }

        public void writeToParcel(Parcel out, int flags) {
            pk pkVar = CREATOR;
            pk.a(this, out, flags);
        }
    }

    public static final class b extends ks implements Cover {
        public static final pl CREATOR = new pl();
        private static final HashMap<String, com.google.android.gms.internal.kr.a<?, ?>> aom = new HashMap();
        final int CK;
        final Set<Integer> aon;
        a apG;
        b apH;
        int apI;

        public static final class a extends ks implements CoverInfo {
            public static final pm CREATOR = new pm();
            private static final HashMap<String, com.google.android.gms.internal.kr.a<?, ?>> aom = new HashMap();
            final int CK;
            final Set<Integer> aon;
            int apJ;
            int apK;

            static {
                aom.put("leftImageOffset", com.google.android.gms.internal.kr.a.i("leftImageOffset", 2));
                aom.put("topImageOffset", com.google.android.gms.internal.kr.a.i("topImageOffset", 3));
            }

            public a() {
                this.CK = 1;
                this.aon = new HashSet();
            }

            a(Set<Integer> set, int i, int i2, int i3) {
                this.aon = set;
                this.CK = i;
                this.apJ = i2;
                this.apK = i3;
            }

            protected boolean a(com.google.android.gms.internal.kr.a aVar) {
                return this.aon.contains(Integer.valueOf(aVar.hR()));
            }

            protected Object b(com.google.android.gms.internal.kr.a aVar) {
                switch (aVar.hR()) {
                    case 2:
                        return Integer.valueOf(this.apJ);
                    case 3:
                        return Integer.valueOf(this.apK);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + aVar.hR());
                }
            }

            public int describeContents() {
                pm pmVar = CREATOR;
                return 0;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof a)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                a aVar = (a) obj;
                for (com.google.android.gms.internal.kr.a aVar2 : aom.values()) {
                    if (a(aVar2)) {
                        if (!aVar.a(aVar2)) {
                            return false;
                        }
                        if (!b(aVar2).equals(aVar.b(aVar2))) {
                            return false;
                        }
                    } else if (aVar.a(aVar2)) {
                        return false;
                    }
                }
                return true;
            }

            public /* synthetic */ Object freeze() {
                return oO();
            }

            public int getLeftImageOffset() {
                return this.apJ;
            }

            public int getTopImageOffset() {
                return this.apK;
            }

            public HashMap<String, com.google.android.gms.internal.kr.a<?, ?>> hK() {
                return aom;
            }

            public boolean hasLeftImageOffset() {
                return this.aon.contains(Integer.valueOf(2));
            }

            public boolean hasTopImageOffset() {
                return this.aon.contains(Integer.valueOf(3));
            }

            public int hashCode() {
                int i = 0;
                for (com.google.android.gms.internal.kr.a aVar : aom.values()) {
                    int hashCode;
                    if (a(aVar)) {
                        hashCode = b(aVar).hashCode() + (i + aVar.hR());
                    } else {
                        hashCode = i;
                    }
                    i = hashCode;
                }
                return i;
            }

            public boolean isDataValid() {
                return true;
            }

            public a oO() {
                return this;
            }

            public void writeToParcel(Parcel out, int flags) {
                pm pmVar = CREATOR;
                pm.a(this, out, flags);
            }
        }

        public static final class b extends ks implements CoverPhoto {
            public static final pn CREATOR = new pn();
            private static final HashMap<String, com.google.android.gms.internal.kr.a<?, ?>> aom = new HashMap();
            final int CK;
            final Set<Integer> aon;
            int li;
            int lj;
            String vf;

            static {
                aom.put("height", com.google.android.gms.internal.kr.a.i("height", 2));
                aom.put(PlusShare.KEY_CALL_TO_ACTION_URL, com.google.android.gms.internal.kr.a.l(PlusShare.KEY_CALL_TO_ACTION_URL, 3));
                aom.put("width", com.google.android.gms.internal.kr.a.i("width", 4));
            }

            public b() {
                this.CK = 1;
                this.aon = new HashSet();
            }

            b(Set<Integer> set, int i, int i2, String str, int i3) {
                this.aon = set;
                this.CK = i;
                this.lj = i2;
                this.vf = str;
                this.li = i3;
            }

            protected boolean a(com.google.android.gms.internal.kr.a aVar) {
                return this.aon.contains(Integer.valueOf(aVar.hR()));
            }

            protected Object b(com.google.android.gms.internal.kr.a aVar) {
                switch (aVar.hR()) {
                    case 2:
                        return Integer.valueOf(this.lj);
                    case 3:
                        return this.vf;
                    case 4:
                        return Integer.valueOf(this.li);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + aVar.hR());
                }
            }

            public int describeContents() {
                pn pnVar = CREATOR;
                return 0;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof b)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                b bVar = (b) obj;
                for (com.google.android.gms.internal.kr.a aVar : aom.values()) {
                    if (a(aVar)) {
                        if (!bVar.a(aVar)) {
                            return false;
                        }
                        if (!b(aVar).equals(bVar.b(aVar))) {
                            return false;
                        }
                    } else if (bVar.a(aVar)) {
                        return false;
                    }
                }
                return true;
            }

            public /* synthetic */ Object freeze() {
                return oP();
            }

            public int getHeight() {
                return this.lj;
            }

            public String getUrl() {
                return this.vf;
            }

            public int getWidth() {
                return this.li;
            }

            public HashMap<String, com.google.android.gms.internal.kr.a<?, ?>> hK() {
                return aom;
            }

            public boolean hasHeight() {
                return this.aon.contains(Integer.valueOf(2));
            }

            public boolean hasUrl() {
                return this.aon.contains(Integer.valueOf(3));
            }

            public boolean hasWidth() {
                return this.aon.contains(Integer.valueOf(4));
            }

            public int hashCode() {
                int i = 0;
                for (com.google.android.gms.internal.kr.a aVar : aom.values()) {
                    int hashCode;
                    if (a(aVar)) {
                        hashCode = b(aVar).hashCode() + (i + aVar.hR());
                    } else {
                        hashCode = i;
                    }
                    i = hashCode;
                }
                return i;
            }

            public boolean isDataValid() {
                return true;
            }

            public b oP() {
                return this;
            }

            public void writeToParcel(Parcel out, int flags) {
                pn pnVar = CREATOR;
                pn.a(this, out, flags);
            }
        }

        static {
            aom.put("coverInfo", com.google.android.gms.internal.kr.a.a("coverInfo", 2, a.class));
            aom.put("coverPhoto", com.google.android.gms.internal.kr.a.a("coverPhoto", 3, b.class));
            aom.put("layout", com.google.android.gms.internal.kr.a.a("layout", 4, new ko().h("banner", 0), false));
        }

        public b() {
            this.CK = 1;
            this.aon = new HashSet();
        }

        b(Set<Integer> set, int i, a aVar, b bVar, int i2) {
            this.aon = set;
            this.CK = i;
            this.apG = aVar;
            this.apH = bVar;
            this.apI = i2;
        }

        protected boolean a(com.google.android.gms.internal.kr.a aVar) {
            return this.aon.contains(Integer.valueOf(aVar.hR()));
        }

        protected Object b(com.google.android.gms.internal.kr.a aVar) {
            switch (aVar.hR()) {
                case 2:
                    return this.apG;
                case 3:
                    return this.apH;
                case 4:
                    return Integer.valueOf(this.apI);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + aVar.hR());
            }
        }

        public int describeContents() {
            pl plVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            b bVar = (b) obj;
            for (com.google.android.gms.internal.kr.a aVar : aom.values()) {
                if (a(aVar)) {
                    if (!bVar.a(aVar)) {
                        return false;
                    }
                    if (!b(aVar).equals(bVar.b(aVar))) {
                        return false;
                    }
                } else if (bVar.a(aVar)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return oN();
        }

        public CoverInfo getCoverInfo() {
            return this.apG;
        }

        public CoverPhoto getCoverPhoto() {
            return this.apH;
        }

        public int getLayout() {
            return this.apI;
        }

        public HashMap<String, com.google.android.gms.internal.kr.a<?, ?>> hK() {
            return aom;
        }

        public boolean hasCoverInfo() {
            return this.aon.contains(Integer.valueOf(2));
        }

        public boolean hasCoverPhoto() {
            return this.aon.contains(Integer.valueOf(3));
        }

        public boolean hasLayout() {
            return this.aon.contains(Integer.valueOf(4));
        }

        public int hashCode() {
            int i = 0;
            for (com.google.android.gms.internal.kr.a aVar : aom.values()) {
                int hashCode;
                if (a(aVar)) {
                    hashCode = b(aVar).hashCode() + (i + aVar.hR());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public b oN() {
            return this;
        }

        public void writeToParcel(Parcel out, int flags) {
            pl plVar = CREATOR;
            pl.a(this, out, flags);
        }
    }

    public static final class c extends ks implements Image {
        public static final po CREATOR = new po();
        private static final HashMap<String, com.google.android.gms.internal.kr.a<?, ?>> aom = new HashMap();
        final int CK;
        final Set<Integer> aon;
        String vf;

        static {
            aom.put(PlusShare.KEY_CALL_TO_ACTION_URL, com.google.android.gms.internal.kr.a.l(PlusShare.KEY_CALL_TO_ACTION_URL, 2));
        }

        public c() {
            this.CK = 1;
            this.aon = new HashSet();
        }

        public c(String str) {
            this.aon = new HashSet();
            this.CK = 1;
            this.vf = str;
            this.aon.add(Integer.valueOf(2));
        }

        c(Set<Integer> set, int i, String str) {
            this.aon = set;
            this.CK = i;
            this.vf = str;
        }

        protected boolean a(com.google.android.gms.internal.kr.a aVar) {
            return this.aon.contains(Integer.valueOf(aVar.hR()));
        }

        protected Object b(com.google.android.gms.internal.kr.a aVar) {
            switch (aVar.hR()) {
                case 2:
                    return this.vf;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + aVar.hR());
            }
        }

        public int describeContents() {
            po poVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            c cVar = (c) obj;
            for (com.google.android.gms.internal.kr.a aVar : aom.values()) {
                if (a(aVar)) {
                    if (!cVar.a(aVar)) {
                        return false;
                    }
                    if (!b(aVar).equals(cVar.b(aVar))) {
                        return false;
                    }
                } else if (cVar.a(aVar)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return oQ();
        }

        public String getUrl() {
            return this.vf;
        }

        public HashMap<String, com.google.android.gms.internal.kr.a<?, ?>> hK() {
            return aom;
        }

        public boolean hasUrl() {
            return this.aon.contains(Integer.valueOf(2));
        }

        public int hashCode() {
            int i = 0;
            for (com.google.android.gms.internal.kr.a aVar : aom.values()) {
                int hashCode;
                if (a(aVar)) {
                    hashCode = b(aVar).hashCode() + (i + aVar.hR());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public c oQ() {
            return this;
        }

        public void writeToParcel(Parcel out, int flags) {
            po poVar = CREATOR;
            po.a(this, out, flags);
        }
    }

    public static final class d extends ks implements Name {
        public static final pp CREATOR = new pp();
        private static final HashMap<String, com.google.android.gms.internal.kr.a<?, ?>> aom = new HashMap();
        final int CK;
        String aoL;
        String aoO;
        final Set<Integer> aon;
        String apL;
        String apM;
        String apN;
        String apO;

        static {
            aom.put("familyName", com.google.android.gms.internal.kr.a.l("familyName", 2));
            aom.put("formatted", com.google.android.gms.internal.kr.a.l("formatted", 3));
            aom.put("givenName", com.google.android.gms.internal.kr.a.l("givenName", 4));
            aom.put("honorificPrefix", com.google.android.gms.internal.kr.a.l("honorificPrefix", 5));
            aom.put("honorificSuffix", com.google.android.gms.internal.kr.a.l("honorificSuffix", 6));
            aom.put("middleName", com.google.android.gms.internal.kr.a.l("middleName", 7));
        }

        public d() {
            this.CK = 1;
            this.aon = new HashSet();
        }

        d(Set<Integer> set, int i, String str, String str2, String str3, String str4, String str5, String str6) {
            this.aon = set;
            this.CK = i;
            this.aoL = str;
            this.apL = str2;
            this.aoO = str3;
            this.apM = str4;
            this.apN = str5;
            this.apO = str6;
        }

        protected boolean a(com.google.android.gms.internal.kr.a aVar) {
            return this.aon.contains(Integer.valueOf(aVar.hR()));
        }

        protected Object b(com.google.android.gms.internal.kr.a aVar) {
            switch (aVar.hR()) {
                case 2:
                    return this.aoL;
                case 3:
                    return this.apL;
                case 4:
                    return this.aoO;
                case 5:
                    return this.apM;
                case 6:
                    return this.apN;
                case 7:
                    return this.apO;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + aVar.hR());
            }
        }

        public int describeContents() {
            pp ppVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof d)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            d dVar = (d) obj;
            for (com.google.android.gms.internal.kr.a aVar : aom.values()) {
                if (a(aVar)) {
                    if (!dVar.a(aVar)) {
                        return false;
                    }
                    if (!b(aVar).equals(dVar.b(aVar))) {
                        return false;
                    }
                } else if (dVar.a(aVar)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return oR();
        }

        public String getFamilyName() {
            return this.aoL;
        }

        public String getFormatted() {
            return this.apL;
        }

        public String getGivenName() {
            return this.aoO;
        }

        public String getHonorificPrefix() {
            return this.apM;
        }

        public String getHonorificSuffix() {
            return this.apN;
        }

        public String getMiddleName() {
            return this.apO;
        }

        public HashMap<String, com.google.android.gms.internal.kr.a<?, ?>> hK() {
            return aom;
        }

        public boolean hasFamilyName() {
            return this.aon.contains(Integer.valueOf(2));
        }

        public boolean hasFormatted() {
            return this.aon.contains(Integer.valueOf(3));
        }

        public boolean hasGivenName() {
            return this.aon.contains(Integer.valueOf(4));
        }

        public boolean hasHonorificPrefix() {
            return this.aon.contains(Integer.valueOf(5));
        }

        public boolean hasHonorificSuffix() {
            return this.aon.contains(Integer.valueOf(6));
        }

        public boolean hasMiddleName() {
            return this.aon.contains(Integer.valueOf(7));
        }

        public int hashCode() {
            int i = 0;
            for (com.google.android.gms.internal.kr.a aVar : aom.values()) {
                int hashCode;
                if (a(aVar)) {
                    hashCode = b(aVar).hashCode() + (i + aVar.hR());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public d oR() {
            return this;
        }

        public void writeToParcel(Parcel out, int flags) {
            pp ppVar = CREATOR;
            pp.a(this, out, flags);
        }
    }

    public static class e {
        public static int ck(String str) {
            if (str.equals("person")) {
                return 0;
            }
            if (str.equals("page")) {
                return 1;
            }
            throw new IllegalArgumentException("Unknown objectType string: " + str);
        }
    }

    public static final class f extends ks implements Organizations {
        public static final pq CREATOR = new pq();
        private static final HashMap<String, com.google.android.gms.internal.kr.a<?, ?>> aom = new HashMap();
        final int CK;
        int Gt;
        String OH;
        String UO;
        String aoK;
        final Set<Integer> aon;
        String apP;
        String apQ;
        boolean apR;
        String apa;
        String mName;

        static {
            aom.put("department", com.google.android.gms.internal.kr.a.l("department", 2));
            aom.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, com.google.android.gms.internal.kr.a.l(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 3));
            aom.put("endDate", com.google.android.gms.internal.kr.a.l("endDate", 4));
            aom.put("location", com.google.android.gms.internal.kr.a.l("location", 5));
            aom.put("name", com.google.android.gms.internal.kr.a.l("name", 6));
            aom.put("primary", com.google.android.gms.internal.kr.a.k("primary", 7));
            aom.put("startDate", com.google.android.gms.internal.kr.a.l("startDate", 8));
            aom.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, com.google.android.gms.internal.kr.a.l(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, 9));
            aom.put("type", com.google.android.gms.internal.kr.a.a("type", 10, new ko().h("work", 0).h("school", 1), false));
        }

        public f() {
            this.CK = 1;
            this.aon = new HashSet();
        }

        f(Set<Integer> set, int i, String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, int i2) {
            this.aon = set;
            this.CK = i;
            this.apP = str;
            this.UO = str2;
            this.aoK = str3;
            this.apQ = str4;
            this.mName = str5;
            this.apR = z;
            this.apa = str6;
            this.OH = str7;
            this.Gt = i2;
        }

        protected boolean a(com.google.android.gms.internal.kr.a aVar) {
            return this.aon.contains(Integer.valueOf(aVar.hR()));
        }

        protected Object b(com.google.android.gms.internal.kr.a aVar) {
            switch (aVar.hR()) {
                case 2:
                    return this.apP;
                case 3:
                    return this.UO;
                case 4:
                    return this.aoK;
                case 5:
                    return this.apQ;
                case 6:
                    return this.mName;
                case 7:
                    return Boolean.valueOf(this.apR);
                case 8:
                    return this.apa;
                case 9:
                    return this.OH;
                case 10:
                    return Integer.valueOf(this.Gt);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + aVar.hR());
            }
        }

        public int describeContents() {
            pq pqVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof f)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            f fVar = (f) obj;
            for (com.google.android.gms.internal.kr.a aVar : aom.values()) {
                if (a(aVar)) {
                    if (!fVar.a(aVar)) {
                        return false;
                    }
                    if (!b(aVar).equals(fVar.b(aVar))) {
                        return false;
                    }
                } else if (fVar.a(aVar)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return oS();
        }

        public String getDepartment() {
            return this.apP;
        }

        public String getDescription() {
            return this.UO;
        }

        public String getEndDate() {
            return this.aoK;
        }

        public String getLocation() {
            return this.apQ;
        }

        public String getName() {
            return this.mName;
        }

        public String getStartDate() {
            return this.apa;
        }

        public String getTitle() {
            return this.OH;
        }

        public int getType() {
            return this.Gt;
        }

        public HashMap<String, com.google.android.gms.internal.kr.a<?, ?>> hK() {
            return aom;
        }

        public boolean hasDepartment() {
            return this.aon.contains(Integer.valueOf(2));
        }

        public boolean hasDescription() {
            return this.aon.contains(Integer.valueOf(3));
        }

        public boolean hasEndDate() {
            return this.aon.contains(Integer.valueOf(4));
        }

        public boolean hasLocation() {
            return this.aon.contains(Integer.valueOf(5));
        }

        public boolean hasName() {
            return this.aon.contains(Integer.valueOf(6));
        }

        public boolean hasPrimary() {
            return this.aon.contains(Integer.valueOf(7));
        }

        public boolean hasStartDate() {
            return this.aon.contains(Integer.valueOf(8));
        }

        public boolean hasTitle() {
            return this.aon.contains(Integer.valueOf(9));
        }

        public boolean hasType() {
            return this.aon.contains(Integer.valueOf(10));
        }

        public int hashCode() {
            int i = 0;
            for (com.google.android.gms.internal.kr.a aVar : aom.values()) {
                int hashCode;
                if (a(aVar)) {
                    hashCode = b(aVar).hashCode() + (i + aVar.hR());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public boolean isPrimary() {
            return this.apR;
        }

        public f oS() {
            return this;
        }

        public void writeToParcel(Parcel out, int flags) {
            pq pqVar = CREATOR;
            pq.a(this, out, flags);
        }
    }

    public static final class g extends ks implements PlacesLived {
        public static final pr CREATOR = new pr();
        private static final HashMap<String, com.google.android.gms.internal.kr.a<?, ?>> aom = new HashMap();
        final int CK;
        final Set<Integer> aon;
        boolean apR;
        String mValue;

        static {
            aom.put("primary", com.google.android.gms.internal.kr.a.k("primary", 2));
            aom.put("value", com.google.android.gms.internal.kr.a.l("value", 3));
        }

        public g() {
            this.CK = 1;
            this.aon = new HashSet();
        }

        g(Set<Integer> set, int i, boolean z, String str) {
            this.aon = set;
            this.CK = i;
            this.apR = z;
            this.mValue = str;
        }

        protected boolean a(com.google.android.gms.internal.kr.a aVar) {
            return this.aon.contains(Integer.valueOf(aVar.hR()));
        }

        protected Object b(com.google.android.gms.internal.kr.a aVar) {
            switch (aVar.hR()) {
                case 2:
                    return Boolean.valueOf(this.apR);
                case 3:
                    return this.mValue;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + aVar.hR());
            }
        }

        public int describeContents() {
            pr prVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof g)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            g gVar = (g) obj;
            for (com.google.android.gms.internal.kr.a aVar : aom.values()) {
                if (a(aVar)) {
                    if (!gVar.a(aVar)) {
                        return false;
                    }
                    if (!b(aVar).equals(gVar.b(aVar))) {
                        return false;
                    }
                } else if (gVar.a(aVar)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return oT();
        }

        public String getValue() {
            return this.mValue;
        }

        public HashMap<String, com.google.android.gms.internal.kr.a<?, ?>> hK() {
            return aom;
        }

        public boolean hasPrimary() {
            return this.aon.contains(Integer.valueOf(2));
        }

        public boolean hasValue() {
            return this.aon.contains(Integer.valueOf(3));
        }

        public int hashCode() {
            int i = 0;
            for (com.google.android.gms.internal.kr.a aVar : aom.values()) {
                int hashCode;
                if (a(aVar)) {
                    hashCode = b(aVar).hashCode() + (i + aVar.hR());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public boolean isPrimary() {
            return this.apR;
        }

        public g oT() {
            return this;
        }

        public void writeToParcel(Parcel out, int flags) {
            pr prVar = CREATOR;
            pr.a(this, out, flags);
        }
    }

    public static final class h extends ks implements Urls {
        public static final ps CREATOR = new ps();
        private static final HashMap<String, com.google.android.gms.internal.kr.a<?, ?>> aom = new HashMap();
        final int CK;
        int Gt;
        String XL;
        final Set<Integer> aon;
        private final int apS;
        String mValue;

        static {
            aom.put(PlusShare.KEY_CALL_TO_ACTION_LABEL, com.google.android.gms.internal.kr.a.l(PlusShare.KEY_CALL_TO_ACTION_LABEL, 5));
            aom.put("type", com.google.android.gms.internal.kr.a.a("type", 6, new ko().h("home", 0).h("work", 1).h("blog", 2).h(Scopes.PROFILE, 3).h(FitnessActivities.OTHER, 4).h("otherProfile", 5).h("contributor", 6).h("website", 7), false));
            aom.put("value", com.google.android.gms.internal.kr.a.l("value", 4));
        }

        public h() {
            this.apS = 4;
            this.CK = 1;
            this.aon = new HashSet();
        }

        h(Set<Integer> set, int i, String str, int i2, String str2, int i3) {
            this.apS = 4;
            this.aon = set;
            this.CK = i;
            this.XL = str;
            this.Gt = i2;
            this.mValue = str2;
        }

        protected boolean a(com.google.android.gms.internal.kr.a aVar) {
            return this.aon.contains(Integer.valueOf(aVar.hR()));
        }

        protected Object b(com.google.android.gms.internal.kr.a aVar) {
            switch (aVar.hR()) {
                case 4:
                    return this.mValue;
                case 5:
                    return this.XL;
                case 6:
                    return Integer.valueOf(this.Gt);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + aVar.hR());
            }
        }

        public int describeContents() {
            ps psVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof h)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            h hVar = (h) obj;
            for (com.google.android.gms.internal.kr.a aVar : aom.values()) {
                if (a(aVar)) {
                    if (!hVar.a(aVar)) {
                        return false;
                    }
                    if (!b(aVar).equals(hVar.b(aVar))) {
                        return false;
                    }
                } else if (hVar.a(aVar)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return oV();
        }

        public String getLabel() {
            return this.XL;
        }

        public int getType() {
            return this.Gt;
        }

        public String getValue() {
            return this.mValue;
        }

        public HashMap<String, com.google.android.gms.internal.kr.a<?, ?>> hK() {
            return aom;
        }

        public boolean hasLabel() {
            return this.aon.contains(Integer.valueOf(5));
        }

        public boolean hasType() {
            return this.aon.contains(Integer.valueOf(6));
        }

        public boolean hasValue() {
            return this.aon.contains(Integer.valueOf(4));
        }

        public int hashCode() {
            int i = 0;
            for (com.google.android.gms.internal.kr.a aVar : aom.values()) {
                int hashCode;
                if (a(aVar)) {
                    hashCode = b(aVar).hashCode() + (i + aVar.hR());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        @Deprecated
        public int oU() {
            return 4;
        }

        public h oV() {
            return this;
        }

        public void writeToParcel(Parcel out, int flags) {
            ps psVar = CREATOR;
            ps.a(this, out, flags);
        }
    }

    static {
        aom.put("aboutMe", com.google.android.gms.internal.kr.a.l("aboutMe", 2));
        aom.put("ageRange", com.google.android.gms.internal.kr.a.a("ageRange", 3, a.class));
        aom.put("birthday", com.google.android.gms.internal.kr.a.l("birthday", 4));
        aom.put("braggingRights", com.google.android.gms.internal.kr.a.l("braggingRights", 5));
        aom.put("circledByCount", com.google.android.gms.internal.kr.a.i("circledByCount", 6));
        aom.put("cover", com.google.android.gms.internal.kr.a.a("cover", 7, b.class));
        aom.put("currentLocation", com.google.android.gms.internal.kr.a.l("currentLocation", 8));
        aom.put("displayName", com.google.android.gms.internal.kr.a.l("displayName", 9));
        aom.put("gender", com.google.android.gms.internal.kr.a.a("gender", 12, new ko().h("male", 0).h("female", 1).h(FitnessActivities.OTHER, 2), false));
        aom.put("id", com.google.android.gms.internal.kr.a.l("id", 14));
        aom.put("image", com.google.android.gms.internal.kr.a.a("image", 15, c.class));
        aom.put("isPlusUser", com.google.android.gms.internal.kr.a.k("isPlusUser", 16));
        aom.put("language", com.google.android.gms.internal.kr.a.l("language", 18));
        aom.put("name", com.google.android.gms.internal.kr.a.a("name", 19, d.class));
        aom.put("nickname", com.google.android.gms.internal.kr.a.l("nickname", 20));
        aom.put("objectType", com.google.android.gms.internal.kr.a.a("objectType", 21, new ko().h("person", 0).h("page", 1), false));
        aom.put("organizations", com.google.android.gms.internal.kr.a.b("organizations", 22, f.class));
        aom.put("placesLived", com.google.android.gms.internal.kr.a.b("placesLived", 23, g.class));
        aom.put("plusOneCount", com.google.android.gms.internal.kr.a.i("plusOneCount", 24));
        aom.put("relationshipStatus", com.google.android.gms.internal.kr.a.a("relationshipStatus", 25, new ko().h("single", 0).h("in_a_relationship", 1).h("engaged", 2).h("married", 3).h("its_complicated", 4).h("open_relationship", 5).h("widowed", 6).h("in_domestic_partnership", 7).h("in_civil_union", 8), false));
        aom.put("tagline", com.google.android.gms.internal.kr.a.l("tagline", 26));
        aom.put(PlusShare.KEY_CALL_TO_ACTION_URL, com.google.android.gms.internal.kr.a.l(PlusShare.KEY_CALL_TO_ACTION_URL, 27));
        aom.put("urls", com.google.android.gms.internal.kr.a.b("urls", 28, h.class));
        aom.put("verified", com.google.android.gms.internal.kr.a.k("verified", 29));
    }

    public pi() {
        this.CK = 1;
        this.aon = new HashSet();
    }

    public pi(String str, String str2, c cVar, int i, String str3) {
        this.CK = 1;
        this.aon = new HashSet();
        this.OS = str;
        this.aon.add(Integer.valueOf(9));
        this.CE = str2;
        this.aon.add(Integer.valueOf(14));
        this.aps = cVar;
        this.aon.add(Integer.valueOf(15));
        this.apw = i;
        this.aon.add(Integer.valueOf(21));
        this.vf = str3;
        this.aon.add(Integer.valueOf(27));
    }

    pi(Set<Integer> set, int i, String str, a aVar, String str2, String str3, int i2, b bVar, String str4, String str5, int i3, String str6, c cVar, boolean z, String str7, d dVar, String str8, int i4, List<f> list, List<g> list2, int i5, int i6, String str9, String str10, List<h> list3, boolean z2) {
        this.aon = set;
        this.CK = i;
        this.apl = str;
        this.apm = aVar;
        this.apn = str2;
        this.apo = str3;
        this.app = i2;
        this.apq = bVar;
        this.apr = str4;
        this.OS = str5;
        this.ow = i3;
        this.CE = str6;
        this.aps = cVar;
        this.apt = z;
        this.FR = str7;
        this.apu = dVar;
        this.apv = str8;
        this.apw = i4;
        this.apx = list;
        this.apy = list2;
        this.apz = i5;
        this.apA = i6;
        this.apB = str9;
        this.vf = str10;
        this.apC = list3;
        this.apD = z2;
    }

    public static pi i(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        pi dz = CREATOR.dz(obtain);
        obtain.recycle();
        return dz;
    }

    protected boolean a(com.google.android.gms.internal.kr.a aVar) {
        return this.aon.contains(Integer.valueOf(aVar.hR()));
    }

    protected Object b(com.google.android.gms.internal.kr.a aVar) {
        switch (aVar.hR()) {
            case 2:
                return this.apl;
            case 3:
                return this.apm;
            case 4:
                return this.apn;
            case 5:
                return this.apo;
            case 6:
                return Integer.valueOf(this.app);
            case 7:
                return this.apq;
            case 8:
                return this.apr;
            case 9:
                return this.OS;
            case 12:
                return Integer.valueOf(this.ow);
            case 14:
                return this.CE;
            case 15:
                return this.aps;
            case 16:
                return Boolean.valueOf(this.apt);
            case 18:
                return this.FR;
            case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                return this.apu;
            case 20:
                return this.apv;
            case 21:
                return Integer.valueOf(this.apw);
            case 22:
                return this.apx;
            case 23:
                return this.apy;
            case 24:
                return Integer.valueOf(this.apz);
            case 25:
                return Integer.valueOf(this.apA);
            case 26:
                return this.apB;
            case 27:
                return this.vf;
            case 28:
                return this.apC;
            case 29:
                return Boolean.valueOf(this.apD);
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + aVar.hR());
        }
    }

    public int describeContents() {
        pj pjVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof pi)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        pi piVar = (pi) obj;
        for (com.google.android.gms.internal.kr.a aVar : aom.values()) {
            if (a(aVar)) {
                if (!piVar.a(aVar)) {
                    return false;
                }
                if (!b(aVar).equals(piVar.b(aVar))) {
                    return false;
                }
            } else if (piVar.a(aVar)) {
                return false;
            }
        }
        return true;
    }

    public /* synthetic */ Object freeze() {
        return oL();
    }

    public String getAboutMe() {
        return this.apl;
    }

    public AgeRange getAgeRange() {
        return this.apm;
    }

    public String getBirthday() {
        return this.apn;
    }

    public String getBraggingRights() {
        return this.apo;
    }

    public int getCircledByCount() {
        return this.app;
    }

    public Cover getCover() {
        return this.apq;
    }

    public String getCurrentLocation() {
        return this.apr;
    }

    public String getDisplayName() {
        return this.OS;
    }

    public int getGender() {
        return this.ow;
    }

    public String getId() {
        return this.CE;
    }

    public Image getImage() {
        return this.aps;
    }

    public String getLanguage() {
        return this.FR;
    }

    public Name getName() {
        return this.apu;
    }

    public String getNickname() {
        return this.apv;
    }

    public int getObjectType() {
        return this.apw;
    }

    public List<Organizations> getOrganizations() {
        return (ArrayList) this.apx;
    }

    public List<PlacesLived> getPlacesLived() {
        return (ArrayList) this.apy;
    }

    public int getPlusOneCount() {
        return this.apz;
    }

    public int getRelationshipStatus() {
        return this.apA;
    }

    public String getTagline() {
        return this.apB;
    }

    public String getUrl() {
        return this.vf;
    }

    public List<Urls> getUrls() {
        return (ArrayList) this.apC;
    }

    public HashMap<String, com.google.android.gms.internal.kr.a<?, ?>> hK() {
        return aom;
    }

    public boolean hasAboutMe() {
        return this.aon.contains(Integer.valueOf(2));
    }

    public boolean hasAgeRange() {
        return this.aon.contains(Integer.valueOf(3));
    }

    public boolean hasBirthday() {
        return this.aon.contains(Integer.valueOf(4));
    }

    public boolean hasBraggingRights() {
        return this.aon.contains(Integer.valueOf(5));
    }

    public boolean hasCircledByCount() {
        return this.aon.contains(Integer.valueOf(6));
    }

    public boolean hasCover() {
        return this.aon.contains(Integer.valueOf(7));
    }

    public boolean hasCurrentLocation() {
        return this.aon.contains(Integer.valueOf(8));
    }

    public boolean hasDisplayName() {
        return this.aon.contains(Integer.valueOf(9));
    }

    public boolean hasGender() {
        return this.aon.contains(Integer.valueOf(12));
    }

    public boolean hasId() {
        return this.aon.contains(Integer.valueOf(14));
    }

    public boolean hasImage() {
        return this.aon.contains(Integer.valueOf(15));
    }

    public boolean hasIsPlusUser() {
        return this.aon.contains(Integer.valueOf(16));
    }

    public boolean hasLanguage() {
        return this.aon.contains(Integer.valueOf(18));
    }

    public boolean hasName() {
        return this.aon.contains(Integer.valueOf(19));
    }

    public boolean hasNickname() {
        return this.aon.contains(Integer.valueOf(20));
    }

    public boolean hasObjectType() {
        return this.aon.contains(Integer.valueOf(21));
    }

    public boolean hasOrganizations() {
        return this.aon.contains(Integer.valueOf(22));
    }

    public boolean hasPlacesLived() {
        return this.aon.contains(Integer.valueOf(23));
    }

    public boolean hasPlusOneCount() {
        return this.aon.contains(Integer.valueOf(24));
    }

    public boolean hasRelationshipStatus() {
        return this.aon.contains(Integer.valueOf(25));
    }

    public boolean hasTagline() {
        return this.aon.contains(Integer.valueOf(26));
    }

    public boolean hasUrl() {
        return this.aon.contains(Integer.valueOf(27));
    }

    public boolean hasUrls() {
        return this.aon.contains(Integer.valueOf(28));
    }

    public boolean hasVerified() {
        return this.aon.contains(Integer.valueOf(29));
    }

    public int hashCode() {
        int i = 0;
        for (com.google.android.gms.internal.kr.a aVar : aom.values()) {
            int hashCode;
            if (a(aVar)) {
                hashCode = b(aVar).hashCode() + (i + aVar.hR());
            } else {
                hashCode = i;
            }
            i = hashCode;
        }
        return i;
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isPlusUser() {
        return this.apt;
    }

    public boolean isVerified() {
        return this.apD;
    }

    public pi oL() {
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        pj pjVar = CREATOR;
        pj.a(this, out, flags);
    }
}
