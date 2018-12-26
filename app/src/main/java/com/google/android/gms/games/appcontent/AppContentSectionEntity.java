package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import java.util.ArrayList;
import java.util.List;

public final class AppContentSectionEntity implements SafeParcelable, AppContentSection {
    public static final AppContentSectionEntityCreator CREATOR = new AppContentSectionEntityCreator();
    private final int CK;
    private final String OH;
    private final String XK;
    private final Bundle XQ;
    private final String XR;
    private final Uri XY;
    private final ArrayList<AppContentCardEntity> XZ;
    private final ArrayList<AppContentActionEntity> mActions;
    private final String vc;

    AppContentSectionEntity(int versionCode, ArrayList<AppContentActionEntity> actions, Uri backgroundImageUri, ArrayList<AppContentCardEntity> cards, String contentDescription, Bundle extraData, String subtitle, String title, String type) {
        this.CK = versionCode;
        this.mActions = actions;
        this.XY = backgroundImageUri;
        this.XZ = cards;
        this.XK = contentDescription;
        this.XQ = extraData;
        this.XR = subtitle;
        this.OH = title;
        this.vc = type;
    }

    public AppContentSectionEntity(AppContentSection cardSection) {
        int i = 0;
        this.CK = 1;
        this.XY = cardSection.kY();
        this.XK = cardSection.kI();
        this.XQ = cardSection.kP();
        this.XR = cardSection.kQ();
        this.OH = cardSection.getTitle();
        this.vc = cardSection.getType();
        List actions = cardSection.getActions();
        int size = actions.size();
        this.mActions = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.mActions.add((AppContentActionEntity) ((AppContentAction) actions.get(i2)).freeze());
        }
        List kZ = cardSection.kZ();
        int size2 = kZ.size();
        this.XZ = new ArrayList(size2);
        while (i < size2) {
            this.XZ.add((AppContentCardEntity) ((AppContentCard) kZ.get(i)).freeze());
            i++;
        }
    }

    static int a(AppContentSection appContentSection) {
        return jv.hashCode(appContentSection.getActions(), appContentSection.kY(), appContentSection.kZ(), appContentSection.kI(), appContentSection.kP(), appContentSection.kQ(), appContentSection.getTitle(), appContentSection.getType());
    }

    static boolean a(AppContentSection appContentSection, Object obj) {
        if (!(obj instanceof AppContentSection)) {
            return false;
        }
        if (appContentSection == obj) {
            return true;
        }
        AppContentSection appContentSection2 = (AppContentSection) obj;
        return jv.equal(appContentSection2.getActions(), appContentSection.getActions()) && jv.equal(appContentSection2.kY(), appContentSection.kY()) && jv.equal(appContentSection2.kZ(), appContentSection.kZ()) && jv.equal(appContentSection2.kI(), appContentSection.kI()) && jv.equal(appContentSection2.kP(), appContentSection.kP()) && jv.equal(appContentSection2.kQ(), appContentSection.kQ()) && jv.equal(appContentSection2.getTitle(), appContentSection.getTitle()) && jv.equal(appContentSection2.getType(), appContentSection.getType());
    }

    static String b(AppContentSection appContentSection) {
        return jv.h(appContentSection).a("Actions", appContentSection.getActions()).a("BackgroundImageUri", appContentSection.kY()).a("Cards", appContentSection.kZ()).a("ContentDescription", appContentSection.kI()).a("ExtraData", appContentSection.kP()).a("Subtitle", appContentSection.kQ()).a("Title", appContentSection.getTitle()).a("Type", appContentSection.getType()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return la();
    }

    public List<AppContentAction> getActions() {
        return new ArrayList(this.mActions);
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

    public String kI() {
        return this.XK;
    }

    public Bundle kP() {
        return this.XQ;
    }

    public String kQ() {
        return this.XR;
    }

    public Uri kY() {
        return this.XY;
    }

    public List<AppContentCard> kZ() {
        return new ArrayList(this.XZ);
    }

    public AppContentSection la() {
        return this;
    }

    public String toString() {
        return b(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        AppContentSectionEntityCreator.a(this, out, flags);
    }
}
