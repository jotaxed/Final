package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;

class l<K, V> {
    final a<K, V> aqk = new a<K, V>(this) {
        final /* synthetic */ l aql;

        {
            this.aql = r1;
        }

        public int sizeOf(K k, V v) {
            return 1;
        }
    };

    public interface a<K, V> {
        int sizeOf(K k, V v);
    }

    public k<K, V> a(int i, a<K, V> aVar) {
        if (i > 0) {
            return pg() < 12 ? new da(i, aVar) : new bb(i, aVar);
        } else {
            throw new IllegalArgumentException("maxSize <= 0");
        }
    }

    int pg() {
        return VERSION.SDK_INT;
    }
}
