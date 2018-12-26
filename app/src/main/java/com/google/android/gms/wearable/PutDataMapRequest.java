package com.google.android.gms.wearable;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.internal.ql;
import com.google.android.gms.internal.ql.a;
import com.google.android.gms.internal.qw;

public class PutDataMapRequest {
    private final DataMap axh = new DataMap();
    private final PutDataRequest axi;

    private PutDataMapRequest(PutDataRequest putDataRequest, DataMap dataMap) {
        this.axi = putDataRequest;
        if (dataMap != null) {
            this.axh.putAll(dataMap);
        }
    }

    public static PutDataMapRequest create(String path) {
        return new PutDataMapRequest(PutDataRequest.create(path), null);
    }

    public static PutDataMapRequest createFromDataMapItem(DataMapItem source) {
        return new PutDataMapRequest(PutDataRequest.k(source.getUri()), source.getDataMap());
    }

    public static PutDataMapRequest createWithAutoAppendedId(String pathPrefix) {
        return new PutDataMapRequest(PutDataRequest.createWithAutoAppendedId(pathPrefix), null);
    }

    public PutDataRequest asPutDataRequest() {
        a a = ql.a(this.axh);
        this.axi.setData(qw.f(a.ayo));
        int size = a.ayp.size();
        int i = 0;
        while (i < size) {
            String num = Integer.toString(i);
            Asset asset = (Asset) a.ayp.get(i);
            if (num == null) {
                throw new IllegalStateException("asset key cannot be null: " + asset);
            } else if (asset == null) {
                throw new IllegalStateException("asset cannot be null: key=" + num);
            } else {
                if (Log.isLoggable(DataMap.TAG, 3)) {
                    Log.d(DataMap.TAG, "asPutDataRequest: adding asset: " + num + " " + asset);
                }
                this.axi.putAsset(num, asset);
                i++;
            }
        }
        return this.axi;
    }

    public DataMap getDataMap() {
        return this.axh;
    }

    public Uri getUri() {
        return this.axi.getUri();
    }
}
