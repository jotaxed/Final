package com.google.android.gms.internal;

import android.os.Parcel;
import android.view.View;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class jg {
    private final View JJ;
    private final a Mw;

    public static final class a implements SafeParcelable {
        public static final jw CREATOR = new jw();
        private final int CK;
        private final String DZ;
        private final int JI;
        private final String JK;
        private final List<String> Kh;

        a(int i, String str, List<String> list, int i2, String str2) {
            this.Kh = new ArrayList();
            this.CK = i;
            this.DZ = str;
            this.Kh.addAll(list);
            this.JI = i2;
            this.JK = str2;
        }

        public a(String str, Collection<String> collection, int i, String str2) {
            this(3, str, new ArrayList(collection), i, str2);
        }

        public int describeContents() {
            return 0;
        }

        public String getAccountName() {
            return this.DZ;
        }

        public int getVersionCode() {
            return this.CK;
        }

        public String hm() {
            return this.DZ != null ? this.DZ : "<<default account>>";
        }

        public int hn() {
            return this.JI;
        }

        public List<String> ho() {
            return new ArrayList(this.Kh);
        }

        public String hq() {
            return this.JK;
        }

        public void writeToParcel(Parcel out, int flags) {
            jw.a(this, out, flags);
        }
    }

    public jg(String str, Collection<String> collection, int i, View view, String str2) {
        this.Mw = new a(str, collection, i, str2);
        this.JJ = view;
    }

    public String getAccountName() {
        return this.Mw.getAccountName();
    }

    public String hm() {
        return this.Mw.hm();
    }

    public int hn() {
        return this.Mw.hn();
    }

    public List<String> ho() {
        return this.Mw.ho();
    }

    public String[] hp() {
        return (String[]) this.Mw.ho().toArray(new String[0]);
    }

    public String hq() {
        return this.Mw.hq();
    }

    public View hr() {
        return this.JJ;
    }
}
