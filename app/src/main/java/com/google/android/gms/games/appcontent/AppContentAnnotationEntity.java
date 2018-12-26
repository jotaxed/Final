package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;

public final class AppContentAnnotationEntity implements SafeParcelable, AppContentAnnotation {
    public static final AppContentAnnotationEntityCreator CREATOR = new AppContentAnnotationEntityCreator();
    private final int CK;
    private final String OH;
    private final String UO;
    private final Uri XN;
    private final String vc;

    AppContentAnnotationEntity(int versionCode, String description, Uri imageUri, String title, String type) {
        this.CK = versionCode;
        this.UO = description;
        this.XN = imageUri;
        this.OH = title;
        this.vc = type;
    }

    public AppContentAnnotationEntity(AppContentAnnotation card) {
        this.CK = 1;
        this.UO = card.getDescription();
        this.XN = card.kL();
        this.OH = card.getTitle();
        this.vc = card.getType();
    }

    static int a(AppContentAnnotation appContentAnnotation) {
        return jv.hashCode(appContentAnnotation.getDescription(), appContentAnnotation.kL(), appContentAnnotation.getTitle(), appContentAnnotation.getType());
    }

    static boolean a(AppContentAnnotation appContentAnnotation, Object obj) {
        if (!(obj instanceof AppContentAnnotation)) {
            return false;
        }
        if (appContentAnnotation == obj) {
            return true;
        }
        AppContentAnnotation appContentAnnotation2 = (AppContentAnnotation) obj;
        return jv.equal(appContentAnnotation2.getDescription(), appContentAnnotation.getDescription()) && jv.equal(appContentAnnotation2.kL(), appContentAnnotation.kL()) && jv.equal(appContentAnnotation2.getTitle(), appContentAnnotation.getTitle()) && jv.equal(appContentAnnotation2.getType(), appContentAnnotation.getType());
    }

    static String b(AppContentAnnotation appContentAnnotation) {
        return jv.h(appContentAnnotation).a("Description", appContentAnnotation.getDescription()).a("ImageUri", appContentAnnotation.kL()).a("Title", appContentAnnotation.getTitle()).a("Type", appContentAnnotation.getType()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return kM();
    }

    public String getDescription() {
        return this.UO;
    }

    public String getTitle() {
        return this.OH;
    }

    public String getType() {
        return this.vc;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public Uri kL() {
        return this.XN;
    }

    public AppContentAnnotation kM() {
        return this;
    }

    public String toString() {
        return b(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        AppContentAnnotationEntityCreator.a(this, out, flags);
    }
}
