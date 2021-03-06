package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.drive.metadata.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class i<T extends Parcelable> extends b<T> {
    public i(String str, int i) {
        super(str, Collections.emptySet(), Collections.singleton(str), i);
    }

    protected void a(Bundle bundle, Collection<T> collection) {
        bundle.putParcelableArrayList(getName(), new ArrayList(collection));
    }

    protected /* synthetic */ Object i(Bundle bundle) {
        return n(bundle);
    }

    protected Collection<T> n(Bundle bundle) {
        return bundle.getParcelableArrayList(getName());
    }
}
