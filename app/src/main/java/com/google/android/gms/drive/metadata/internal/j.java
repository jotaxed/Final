package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.drive.metadata.a;
import java.util.Collection;

public abstract class j<T extends Parcelable> extends a<T> {
    public j(String str, Collection<String> collection, Collection<String> collection2, int i) {
        super(str, collection, collection2, i);
    }

    protected void a(Bundle bundle, T t) {
        bundle.putParcelable(getName(), t);
    }

    protected /* synthetic */ Object i(Bundle bundle) {
        return o(bundle);
    }

    protected T o(Bundle bundle) {
        return bundle.getParcelable(getName());
    }
}
