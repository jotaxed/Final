package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.a;

public class g extends a<Long> {
    public g(String str, int i) {
        super(str, i);
    }

    protected void a(Bundle bundle, Long l) {
        bundle.putLong(getName(), l.longValue());
    }

    protected /* synthetic */ Object c(DataHolder dataHolder, int i, int i2) {
        return h(dataHolder, i, i2);
    }

    protected Long h(DataHolder dataHolder, int i, int i2) {
        return Long.valueOf(dataHolder.a(getName(), i, i2));
    }

    protected /* synthetic */ Object i(Bundle bundle) {
        return m(bundle);
    }

    protected Long m(Bundle bundle) {
        return Long.valueOf(bundle.getLong(getName()));
    }
}
