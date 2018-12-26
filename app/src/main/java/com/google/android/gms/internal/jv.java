package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class jv {

    public static final class a {
        private final List<String> Nr;
        private final Object Ns;

        private a(Object obj) {
            this.Ns = jx.i(obj);
            this.Nr = new ArrayList();
        }

        public a a(String str, Object obj) {
            this.Nr.add(((String) jx.i(str)) + "=" + String.valueOf(obj));
            return this;
        }

        public String toString() {
            StringBuilder append = new StringBuilder(100).append(this.Ns.getClass().getSimpleName()).append('{');
            int size = this.Nr.size();
            for (int i = 0; i < size; i++) {
                append.append((String) this.Nr.get(i));
                if (i < size - 1) {
                    append.append(", ");
                }
            }
            return append.append('}').toString();
        }
    }

    public static boolean equal(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }

    public static a h(Object obj) {
        return new a(obj);
    }

    public static int hashCode(Object... objects) {
        return Arrays.hashCode(objects);
    }
}
