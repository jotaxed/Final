package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.in;
import com.google.android.gms.internal.jv;
import java.util.ArrayList;
import java.util.List;

public final class ApplicationMetadata implements SafeParcelable {
    public static final Creator<ApplicationMetadata> CREATOR = new a();
    private final int CK;
    String Fo;
    List<WebImage> Fp;
    List<String> Fq;
    String Fr;
    Uri Fs;
    String mName;

    private ApplicationMetadata() {
        this.CK = 1;
        this.Fp = new ArrayList();
        this.Fq = new ArrayList();
    }

    ApplicationMetadata(int versionCode, String applicationId, String name, List<WebImage> images, List<String> namespaces, String senderAppIdentifier, Uri senderAppLaunchUrl) {
        this.CK = versionCode;
        this.Fo = applicationId;
        this.mName = name;
        this.Fp = images;
        this.Fq = namespaces;
        this.Fr = senderAppIdentifier;
        this.Fs = senderAppLaunchUrl;
    }

    public boolean areNamespacesSupported(List<String> namespaces) {
        return this.Fq != null && this.Fq.containsAll(namespaces);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ApplicationMetadata)) {
            return false;
        }
        ApplicationMetadata applicationMetadata = (ApplicationMetadata) obj;
        return in.a(this.Fo, applicationMetadata.Fo) && in.a(this.Fp, applicationMetadata.Fp) && in.a(this.mName, applicationMetadata.mName) && in.a(this.Fq, applicationMetadata.Fq) && in.a(this.Fr, applicationMetadata.Fr) && in.a(this.Fs, applicationMetadata.Fs);
    }

    public Uri fP() {
        return this.Fs;
    }

    public String getApplicationId() {
        return this.Fo;
    }

    public List<WebImage> getImages() {
        return this.Fp;
    }

    public String getName() {
        return this.mName;
    }

    public String getSenderAppIdentifier() {
        return this.Fr;
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(Integer.valueOf(this.CK), this.Fo, this.mName, this.Fp, this.Fq, this.Fr, this.Fs);
    }

    public boolean isNamespaceSupported(String namespace) {
        return this.Fq != null && this.Fq.contains(namespace);
    }

    public String toString() {
        return this.mName;
    }

    public void writeToParcel(Parcel out, int flags) {
        a.a(this, out, flags);
    }
}
