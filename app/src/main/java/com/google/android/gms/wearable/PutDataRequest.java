package com.google.android.gms.wearable;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jx;
import com.google.android.gms.wearable.internal.DataItemAssetParcelable;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class PutDataRequest implements SafeParcelable {
    public static final Creator<PutDataRequest> CREATOR = new e();
    public static final String WEAR_URI_SCHEME = "wear";
    private static final Random axj = new SecureRandom();
    final int CK;
    private byte[] aeA;
    private final Bundle axk;
    private final Uri mUri;

    private PutDataRequest(int versionCode, Uri uri) {
        this(versionCode, uri, new Bundle(), null);
    }

    PutDataRequest(int versionCode, Uri uri, Bundle assets, byte[] data) {
        this.CK = versionCode;
        this.mUri = uri;
        this.axk = assets;
        this.axk.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        this.aeA = data;
    }

    public static PutDataRequest create(String path) {
        return k(di(path));
    }

    public static PutDataRequest createFromDataItem(DataItem source) {
        PutDataRequest k = k(source.getUri());
        for (Entry entry : source.getAssets().entrySet()) {
            if (((DataItemAsset) entry.getValue()).getId() == null) {
                throw new IllegalStateException("Cannot create an asset for a put request without a digest: " + ((String) entry.getKey()));
            }
            k.putAsset((String) entry.getKey(), Asset.createFromRef(((DataItemAsset) entry.getValue()).getId()));
        }
        k.setData(source.getData());
        return k;
    }

    public static PutDataRequest createWithAutoAppendedId(String pathPrefix) {
        StringBuilder stringBuilder = new StringBuilder(pathPrefix);
        if (!pathPrefix.endsWith("/")) {
            stringBuilder.append("/");
        }
        stringBuilder.append("PN").append(axj.nextLong());
        return new PutDataRequest(1, di(stringBuilder.toString()));
    }

    private static Uri di(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("An empty path was supplied.");
        } else if (!str.startsWith("/")) {
            throw new IllegalArgumentException("A path must start with a single / .");
        } else if (!str.startsWith("//")) {
            return new Builder().scheme(WEAR_URI_SCHEME).path(str).build();
        } else {
            throw new IllegalArgumentException("A path must start with a single / .");
        }
    }

    public static PutDataRequest k(Uri uri) {
        return new PutDataRequest(1, uri);
    }

    public int describeContents() {
        return 0;
    }

    public Asset getAsset(String key) {
        return (Asset) this.axk.getParcelable(key);
    }

    public Map<String, Asset> getAssets() {
        Map hashMap = new HashMap();
        for (String str : this.axk.keySet()) {
            hashMap.put(str, (Asset) this.axk.getParcelable(str));
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public byte[] getData() {
        return this.aeA;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public boolean hasAsset(String key) {
        return this.axk.containsKey(key);
    }

    public PutDataRequest putAsset(String key, Asset value) {
        jx.i(key);
        jx.i(value);
        this.axk.putParcelable(key, value);
        return this;
    }

    public PutDataRequest removeAsset(String key) {
        this.axk.remove(key);
        return this;
    }

    public Bundle rk() {
        return this.axk;
    }

    public PutDataRequest setData(byte[] data) {
        this.aeA = data;
        return this;
    }

    public String toString() {
        return toString(Log.isLoggable(DataMap.TAG, 3));
    }

    public String toString(boolean verbose) {
        StringBuilder stringBuilder = new StringBuilder("PutDataRequest[");
        stringBuilder.append("dataSz=" + (this.aeA == null ? "null" : Integer.valueOf(this.aeA.length)));
        stringBuilder.append(", numAssets=" + this.axk.size());
        stringBuilder.append(", uri=" + this.mUri);
        if (verbose) {
            stringBuilder.append("]\n  assets: ");
            for (String str : this.axk.keySet()) {
                stringBuilder.append("\n    " + str + ": " + this.axk.getParcelable(str));
            }
            stringBuilder.append("\n  ]");
            return stringBuilder.toString();
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        e.a(this, dest, flags);
    }
}
