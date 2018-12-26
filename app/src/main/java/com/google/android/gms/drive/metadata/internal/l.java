package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.a;

public class l extends a<String> {
    public l(String str, int i) {
        super(str, i);
    }

    protected void a(Bundle bundle, String str) {
        bundle.putString(getName(), str);
    }

    protected /* synthetic */ Object c(DataHolder dataHolder, int i, int i2) {
        return i(dataHolder, i, i2);
    }

    protected /* synthetic */ Object i(Bundle bundle) {
        return p(bundle);
    }

    protected String i(DataHolder dataHolder, int i, int i2) {
        return dataHolder.c(getName(), i, i2);
    }

    protected String p(Bundle bundle) {
        return bundle.getString(getName());
    }
}
