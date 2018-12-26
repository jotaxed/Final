package com.google.android.gms.internal;

import com.google.android.gms.internal.ra.c;
import java.util.ArrayList;

public class os {
    private final ArrayList<a> amZ;
    private int ana;

    public static class a {
        public final ov anb;
        public final or anc;
        public final c and;

        private a(ov ovVar, or orVar) {
            this.anb = (ov) jx.i(ovVar);
            this.anc = (or) jx.i(orVar);
            this.and = null;
        }
    }

    public os() {
        this(100);
    }

    public os(int i) {
        this.amZ = new ArrayList();
        this.ana = i;
    }

    private void oq() {
        while (getSize() > getCapacity()) {
            this.amZ.remove(0);
        }
    }

    public void a(ov ovVar, or orVar) {
        this.amZ.add(new a(ovVar, orVar));
        oq();
    }

    public void clear() {
        this.amZ.clear();
    }

    public int getCapacity() {
        return this.ana;
    }

    public int getSize() {
        return this.amZ.size();
    }

    public boolean isEmpty() {
        return this.amZ.isEmpty();
    }

    public ArrayList<a> op() {
        return this.amZ;
    }
}
