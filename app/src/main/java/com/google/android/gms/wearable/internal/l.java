package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class l implements DataItem {
    private byte[] aeA;
    private Map<String, DataItemAsset> axH;
    private Uri mUri;

    public l(DataItem dataItem) {
        this.mUri = dataItem.getUri();
        this.aeA = dataItem.getData();
        Map hashMap = new HashMap();
        for (Entry entry : dataItem.getAssets().entrySet()) {
            if (entry.getKey() != null) {
                hashMap.put(entry.getKey(), ((DataItemAsset) entry.getValue()).freeze());
            }
        }
        this.axH = Collections.unmodifiableMap(hashMap);
    }

    public /* synthetic */ Object freeze() {
        return rp();
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

    public DataItem rp() {
        return this;
    }

    public DataItem setData(byte[] data) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return toString(Log.isLoggable("DataItem", 3));
    }

    public String toString(boolean verbose) {
        StringBuilder stringBuilder = new StringBuilder("DataItemEntity[");
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
}
