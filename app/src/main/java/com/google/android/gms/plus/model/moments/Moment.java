package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.internal.pd;
import com.google.android.gms.internal.pf;
import java.util.HashSet;
import java.util.Set;

public interface Moment extends Freezable<Moment> {

    public static class Builder {
        private String CE;
        private final Set<Integer> aon = new HashSet();
        private String apa;
        private pd api;
        private pd apj;
        private String vc;

        public Moment build() {
            return new pf(this.aon, this.CE, this.api, this.apa, this.apj, this.vc);
        }

        public Builder setId(String id) {
            this.CE = id;
            this.aon.add(Integer.valueOf(2));
            return this;
        }

        public Builder setResult(ItemScope result) {
            this.api = (pd) result;
            this.aon.add(Integer.valueOf(4));
            return this;
        }

        public Builder setStartDate(String startDate) {
            this.apa = startDate;
            this.aon.add(Integer.valueOf(5));
            return this;
        }

        public Builder setTarget(ItemScope target) {
            this.apj = (pd) target;
            this.aon.add(Integer.valueOf(6));
            return this;
        }

        public Builder setType(String type) {
            this.vc = type;
            this.aon.add(Integer.valueOf(7));
            return this;
        }
    }

    String getId();

    ItemScope getResult();

    String getStartDate();

    ItemScope getTarget();

    String getType();

    boolean hasId();

    boolean hasResult();

    boolean hasStartDate();

    boolean hasTarget();

    boolean hasType();
}
