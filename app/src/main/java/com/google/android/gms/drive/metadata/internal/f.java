package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.a;

public class f extends a<Integer> {
    public f(String str, int i) {
        super(str, i);
    }

    protected void a(Bundle bundle, Integer num) {
        bundle.putInt(getName(), num.intValue());
    }

    protected /* synthetic */ Object c(DataHolder dataHolder, int i, int i2) {
        return g(dataHolder, i, i2);
    }

    protected Integer g(DataHolder dataHolder, int i, int i2) {
        return Integer.valueOf(dataHolder.b(getName(), i, i2));
    }

    protected /* synthetic */ Object i(Bundle bundle) {
        return l(bundle);
    }

    protected Integer l(Bundle bundle) {
        return Integer.valueOf(bundle.getInt(getName()));
    }
}
