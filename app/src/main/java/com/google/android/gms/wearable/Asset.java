package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;

public class Asset implements SafeParcelable {
    public static final Creator<Asset> CREATOR = new a();
    final int CK;
    private byte[] aeA;
    private String axa;
    public ParcelFileDescriptor axb;
    public Uri uri;

    Asset(int versionCode, byte[] data, String digest, ParcelFileDescriptor fd, Uri uri) {
        this.CK = versionCode;
        this.aeA = data;
        this.axa = digest;
        this.axb = fd;
        this.uri = uri;
    }

    public static Asset createFromBytes(byte[] assetData) {
        if (assetData != null) {
            return new Asset(1, assetData, null, null, null);
        }
        throw new IllegalArgumentException("Asset data cannot be null");
    }

    public static Asset createFromFd(ParcelFileDescriptor fd) {
        if (fd != null) {
            return new Asset(1, null, null, fd, null);
        }
        throw new IllegalArgumentException("Asset fd cannot be null");
    }

    public static Asset createFromRef(String digest) {
        if (digest != null) {
            return new Asset(1, null, digest, null, null);
        }
        throw new IllegalArgumentException("Asset digest cannot be null");
    }

    public static Asset createFromUri(Uri uri) {
        if (uri != null) {
            return new Asset(1, null, null, null, uri);
        }
        throw new IllegalArgumentException("Asset uri cannot be null");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Asset)) {
            return false;
        }
        Asset asset = (Asset) o;
        return jv.equal(this.aeA, asset.aeA) && jv.equal(this.axa, asset.axa) && jv.equal(this.axb, asset.axb) && jv.equal(this.uri, asset.uri);
    }

    public byte[] getData() {
        return this.aeA;
    }

    public String getDigest() {
        return this.axa;
    }

    public ParcelFileDescriptor getFd() {
        return this.axb;
    }

    public Uri getUri() {
        return this.uri;
    }

    public int hashCode() {
        return jv.hashCode(this.aeA, this.axa, this.axb, this.uri);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Asset[@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        if (this.axa == null) {
            stringBuilder.append(", nodigest");
        } else {
            stringBuilder.append(", ");
            stringBuilder.append(this.axa);
        }
        if (this.aeA != null) {
            stringBuilder.append(", size=");
            stringBuilder.append(this.aeA.length);
        }
        if (this.axb != null) {
            stringBuilder.append(", fd=");
            stringBuilder.append(this.axb);
        }
        if (this.uri != null) {
            stringBuilder.append(", uri=");
            stringBuilder.append(this.uri);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        a.a(this, dest, flags | 1);
    }
}
