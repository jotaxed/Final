package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.l.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class da<K, V> implements k<K, V> {
    private final Map<K, V> atM = new HashMap();
    private final int atN;
    private final a<K, V> atO;
    private int atP;

    da(int i, a<K, V> aVar) {
        this.atN = i;
        this.atO = aVar;
    }

    public synchronized void e(K k, V v) {
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        this.atP += this.atO.sizeOf(k, v);
        if (this.atP > this.atN) {
            Iterator it = this.atM.entrySet().iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                this.atP -= this.atO.sizeOf(entry.getKey(), entry.getValue());
                it.remove();
                if (this.atP <= this.atN) {
                    break;
                }
            }
        }
        this.atM.put(k, v);
    }

    public synchronized V get(K key) {
        return this.atM.get(key);
    }
}
