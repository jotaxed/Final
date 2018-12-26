package com.google.android.gms.tagmanager;

import android.util.LruCache;
import com.google.android.gms.tagmanager.l.a;

class bb<K, V> implements k<K, V> {
    private LruCache<K, V> arR;

    bb(int i, final a<K, V> aVar) {
        this.arR = new LruCache<K, V>(this, i) {
            final /* synthetic */ bb arT;

            protected int sizeOf(K key, V value) {
                return aVar.sizeOf(key, value);
            }
        };
    }

    public void e(K k, V v) {
        this.arR.put(k, v);
    }

    public V get(K key) {
        return this.arR.get(key);
    }
}
