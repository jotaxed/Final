package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;

public final class jc extends kj<a, Drawable> {

    public static final class a {
        public final int Mt;
        public final int Mu;

        public a(int i, int i2) {
            this.Mt = i;
            this.Mu = i2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            a aVar = (a) obj;
            return aVar.Mt == this.Mt && aVar.Mu == this.Mu;
        }

        public int hashCode() {
            return jv.hashCode(Integer.valueOf(this.Mt), Integer.valueOf(this.Mu));
        }
    }

    public jc() {
        super(10);
    }
}
