package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.a;

public class b extends a<Boolean> {
    public b(String str, int i) {
        super(str, i);
    }

    protected void a(Bundle bundle, Boolean bool) {
        bundle.putBoolean(getName(), bool.booleanValue());
    }

    protected /* synthetic */ Object c(DataHolder dataHolder, int i, int i2) {
        return e(dataHolder, i, i2);
    }

    protected Boolean e(DataHolder dataHolder, int i, int i2) {
        return Boolean.valueOf(dataHolder.d(getName(), i, i2));
    }

    protected /* synthetic */ Object i(Bundle bundle) {
        return j(bundle);
    }

    protected Boolean j(Bundle bundle) {
        return Boolean.valueOf(bundle.getBoolean(getName()));
    }
}
