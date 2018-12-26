package com.google.android.gms.drive.metadata.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.w;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.ln;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class MetadataBundle implements SafeParcelable {
    public static final Creator<MetadataBundle> CREATOR = new h();
    final int CK;
    final Bundle Ri;

    MetadataBundle(int versionCode, Bundle valueBundle) {
        this.CK = versionCode;
        this.Ri = (Bundle) jx.i(valueBundle);
        this.Ri.setClassLoader(getClass().getClassLoader());
        List<String> arrayList = new ArrayList();
        for (String str : this.Ri.keySet()) {
            if (e.bm(str) == null) {
                arrayList.add(str);
                w.o("MetadataBundle", "Ignored unknown metadata field in bundle: " + str);
            }
        }
        for (String str2 : arrayList) {
            this.Ri.remove(str2);
        }
    }

    private MetadataBundle(Bundle valueBundle) {
        this(1, valueBundle);
    }

    public static <T> MetadataBundle a(MetadataField<T> metadataField, T t) {
        MetadataBundle iZ = iZ();
        iZ.b(metadataField, t);
        return iZ;
    }

    public static MetadataBundle a(MetadataBundle metadataBundle) {
        return new MetadataBundle(new Bundle(metadataBundle.Ri));
    }

    public static MetadataBundle iZ() {
        return new MetadataBundle(new Bundle());
    }

    public <T> T a(MetadataField<T> metadataField) {
        return metadataField.h(this.Ri);
    }

    public <T> void b(MetadataField<T> metadataField, T t) {
        if (e.bm(metadataField.getName()) == null) {
            throw new IllegalArgumentException("Unregistered field: " + metadataField.getName());
        }
        metadataField.a(t, this.Ri);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MetadataBundle)) {
            return false;
        }
        MetadataBundle metadataBundle = (MetadataBundle) obj;
        Set<String> keySet = this.Ri.keySet();
        if (!keySet.equals(metadataBundle.Ri.keySet())) {
            return false;
        }
        for (String str : keySet) {
            if (!jv.equal(this.Ri.get(str), metadataBundle.Ri.get(str))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 1;
        for (String str : this.Ri.keySet()) {
            i *= 31;
            i = this.Ri.get(str).hashCode() + i;
        }
        return i;
    }

    public Set<MetadataField<?>> ja() {
        Set<MetadataField<?>> hashSet = new HashSet();
        for (String bm : this.Ri.keySet()) {
            hashSet.add(e.bm(bm));
        }
        return hashSet;
    }

    public void setContext(Context context) {
        a aVar = (a) a(ln.RI);
        if (aVar != null) {
            aVar.a(context.getCacheDir());
        }
    }

    public String toString() {
        return "MetadataBundle [values=" + this.Ri + "]";
    }

    public void writeToParcel(Parcel dest, int flags) {
        h.a(this, dest, flags);
    }
}
