package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.ji;
import com.google.android.gms.internal.jv;

public final class GameBadgeEntity extends GamesDowngradeableSafeParcel implements GameBadge {
    public static final GameBadgeEntityCreator CREATOR = new GameBadgeEntityCreatorCompat();
    private final int CK;
    private int Gt;
    private String OH;
    private String UO;
    private Uri WD;

    static final class GameBadgeEntityCreatorCompat extends GameBadgeEntityCreator {
        GameBadgeEntityCreatorCompat() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return cv(x0);
        }

        public GameBadgeEntity cv(Parcel parcel) {
            if (GamesDowngradeableSafeParcel.c(ji.ht()) || ji.aW(GameBadgeEntity.class.getCanonicalName())) {
                return super.cv(parcel);
            }
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            return new GameBadgeEntity(1, readInt, readString, readString2, readString3 == null ? null : Uri.parse(readString3));
        }
    }

    GameBadgeEntity(int versionCode, int type, String title, String description, Uri iconImageUri) {
        this.CK = versionCode;
        this.Gt = type;
        this.OH = title;
        this.UO = description;
        this.WD = iconImageUri;
    }

    public GameBadgeEntity(GameBadge gameBadge) {
        this.CK = 1;
        this.Gt = gameBadge.getType();
        this.OH = gameBadge.getTitle();
        this.UO = gameBadge.getDescription();
        this.WD = gameBadge.getIconImageUri();
    }

    static int a(GameBadge gameBadge) {
        return jv.hashCode(Integer.valueOf(gameBadge.getType()), gameBadge.getTitle(), gameBadge.getDescription(), gameBadge.getIconImageUri());
    }

    static boolean a(GameBadge gameBadge, Object obj) {
        if (!(obj instanceof GameBadge)) {
            return false;
        }
        if (gameBadge == obj) {
            return true;
        }
        GameBadge gameBadge2 = (GameBadge) obj;
        return jv.equal(Integer.valueOf(gameBadge2.getType()), gameBadge.getTitle()) && jv.equal(gameBadge2.getDescription(), gameBadge.getIconImageUri());
    }

    static String b(GameBadge gameBadge) {
        return jv.h(gameBadge).a("Type", Integer.valueOf(gameBadge.getType())).a("Title", gameBadge.getTitle()).a("Description", gameBadge.getDescription()).a("IconImageUri", gameBadge.getIconImageUri()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return mk();
    }

    public String getDescription() {
        return this.UO;
    }

    public Uri getIconImageUri() {
        return this.WD;
    }

    public String getTitle() {
        return this.OH;
    }

    public int getType() {
        return this.Gt;
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

    public GameBadge mk() {
        return this;
    }

    public String toString() {
        return b((GameBadge) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        if (hu()) {
            dest.writeInt(this.Gt);
            dest.writeString(this.OH);
            dest.writeString(this.UO);
            dest.writeString(this.WD == null ? null : this.WD.toString());
            return;
        }
        GameBadgeEntityCreator.a(this, dest, flags);
    }
}
