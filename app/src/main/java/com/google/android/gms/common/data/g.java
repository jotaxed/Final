package com.google.android.gms.common.data;

import java.util.ArrayList;

public abstract class g<T> extends DataBuffer<T> {
    private boolean Lr = false;
    private ArrayList<Integer> Ls;

    protected g(DataHolder dataHolder) {
        super(dataHolder);
    }

    private void hb() {
        synchronized (this) {
            if (!this.Lr) {
                int count = this.JG.getCount();
                this.Ls = new ArrayList();
                if (count > 0) {
                    this.Ls.add(Integer.valueOf(0));
                    String ha = ha();
                    String c = this.JG.c(ha, 0, this.JG.au(0));
                    int i = 1;
                    while (i < count) {
                        int au = this.JG.au(i);
                        String c2 = this.JG.c(ha, i, au);
                        if (c2 == null) {
                            throw new NullPointerException("Missing value for markerColumn: " + ha + ", at row: " + i + ", for window: " + au);
                        }
                        if (c2.equals(c)) {
                            c2 = c;
                        } else {
                            this.Ls.add(Integer.valueOf(i));
                        }
                        i++;
                        c = c2;
                    }
                }
                this.Lr = true;
            }
        }
    }

    int ax(int i) {
        if (i >= 0 && i < this.Ls.size()) {
            return ((Integer) this.Ls.get(i)).intValue();
        }
        throw new IllegalArgumentException("Position " + i + " is out of bounds for this buffer");
    }

    protected int ay(int i) {
        if (i < 0 || i == this.Ls.size()) {
            return 0;
        }
        int count = i == this.Ls.size() + -1 ? this.JG.getCount() - ((Integer) this.Ls.get(i)).intValue() : ((Integer) this.Ls.get(i + 1)).intValue() - ((Integer) this.Ls.get(i)).intValue();
        if (count != 1) {
            return count;
        }
        int ax = ax(i);
        int au = this.JG.au(ax);
        String hc = hc();
        return (hc == null || this.JG.c(hc, ax, au) != null) ? count : 0;
    }

    protected abstract T f(int i, int i2);

    public final T get(int position) {
        hb();
        return f(ax(position), ay(position));
    }

    public int getCount() {
        hb();
        return this.Ls.size();
    }

    protected abstract String ha();

    protected String hc() {
        return null;
    }
}
