package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONException;

public class k extends b<String> {
    public k(String str, int i) {
        super(str, Collections.singleton(str), Collections.emptySet(), i);
    }

    public static final Collection<String> bn(String str) throws JSONException {
        if (str == null) {
            return null;
        }
        Collection arrayList = new ArrayList();
        JSONArray jSONArray = new JSONArray(str);
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        return Collections.unmodifiableCollection(arrayList);
    }

    protected void a(Bundle bundle, Collection<String> collection) {
        bundle.putStringArrayList(getName(), new ArrayList(collection));
    }

    protected /* synthetic */ Object c(DataHolder dataHolder, int i, int i2) {
        return d(dataHolder, i, i2);
    }

    protected Collection<String> d(DataHolder dataHolder, int i, int i2) {
        try {
            return bn(dataHolder.c(getName(), i, i2));
        } catch (Throwable e) {
            throw new IllegalStateException("DataHolder supplied invalid JSON", e);
        }
    }

    protected /* synthetic */ Object i(Bundle bundle) {
        return n(bundle);
    }

    protected Collection<String> n(Bundle bundle) {
        return bundle.getStringArrayList(getName());
    }
}
