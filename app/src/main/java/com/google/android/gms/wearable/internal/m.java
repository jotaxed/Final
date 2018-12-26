package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class m implements SafeParcelable, DataItem {
    public static final Creator<m> CREATOR = new n();
    final int CK;
    private byte[] aeA;
    private final Map<String, DataItemAsset> axH;
    private final Uri mUri;

    m(int i, Uri uri, Bundle bundle, byte[] bArr) {
        this.CK = i;
        this.mUri = uri;
        Map hashMap = new HashMap();
        bundle.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        for (String str : bundle.keySet()) {
            hashMap.put(str, (DataItemAssetParcelable) bundle.getParcelable(str));
        }
        this.axH = hashMap;
        this.aeA = bArr;
    }

    public int describeContents() {
        return 0;
    }

    public /* synthetic */ Object freeze() {
        return rq();
    }

    public Map<String, DataItemAsset> getAssets() {
        return this.axH;
    }

    public byte[] getData() {
        return this.aeA;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public boolean isDataValid() {
        return true;
    }

    public m m(byte[] bArr) {
        this.aeA = bArr;
        return this;
    }

    public Bundle rk() {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        for (Entry entry : this.axH.entrySet()) {
            bundle.putParcelable((String) entry.getKey(), new DataItemAssetParcelable((DataItemAsset) entry.getValue()));
        }
        return bundle;
    }

    public m rq() {
        return this;
    }

    public /* synthetic */ DataItem setData(byte[] x0) {
        return m(x0);
    }

    public String toString() {
        return toString(Log.isLoggable("DataItem", 3));
    }

    public String toString(boolean verbose) {
        StringBuilder stringBuilder = new StringBuilder("DataItemParcelable[");
        stringBuilder.append("@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        stringBuilder.append(",dataSz=" + (this.aeA == null ? "null" : Integer.valueOf(this.aeA.length)));
        stringBuilder.append(", numAssets=" + this.axH.size());
        stringBuilder.append(", uri=" + this.mUri);
        if (verbose) {
            stringBuilder.append("]\n  assets: ");
            for (String str : this.axH.keySet()) {
                stringBuilder.append("\n    " + str + ": " + this.axH.get(str));
            }
            stringBuilder.append("\n  ]");
            return stringBuilder.toString();
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        n.a(this, dest, flags);
    }
}
