package com.google.android.gms.plus.model.people;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.e;
import com.google.android.gms.internal.pi;
import com.google.android.gms.internal.pt;

public final class PersonBuffer extends DataBuffer<Person> {
    private final e<pi> apT;

    public PersonBuffer(DataHolder dataHolder) {
        super(dataHolder);
        if (dataHolder.gV() == null || !dataHolder.gV().getBoolean("com.google.android.gms.plus.IsSafeParcelable", false)) {
            this.apT = null;
        } else {
            this.apT = new e(dataHolder, pi.CREATOR);
        }
    }

    public Person get(int position) {
        return this.apT != null ? (Person) this.apT.at(position) : new pt(this.JG, position);
    }
}
