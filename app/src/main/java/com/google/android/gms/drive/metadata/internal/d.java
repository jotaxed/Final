package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import java.util.Date;

public class d extends com.google.android.gms.drive.metadata.d<Date> {
    public d(String str, int i) {
        super(str, i);
    }

    protected void a(Bundle bundle, Date date) {
        bundle.putLong(getName(), date.getTime());
    }

    protected /* synthetic */ Object c(DataHolder dataHolder, int i, int i2) {
        return f(dataHolder, i, i2);
    }

    protected Date f(DataHolder dataHolder, int i, int i2) {
        return new Date(dataHolder.a(getName(), i, i2));
    }

    protected /* synthetic */ Object i(Bundle bundle) {
        return k(bundle);
    }

    protected Date k(Bundle bundle) {
        return new Date(bundle.getLong(getName()));
    }
}
