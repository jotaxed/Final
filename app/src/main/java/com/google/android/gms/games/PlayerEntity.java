package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;
import com.google.android.gms.internal.je;
import com.google.android.gms.internal.ji;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.le;

public final class PlayerEntity extends GamesDowngradeableSafeParcel implements Player {
    public static final Creator<PlayerEntity> CREATOR = new PlayerEntityCreatorCompat();
    private final int CK;
    private final String OH;
    private final String OS;
    private final Uri WD;
    private final Uri WE;
    private final String WO;
    private final String WP;
    private final String Xh;
    private final long Xi;
    private final int Xj;
    private final long Xk;
    private final MostRecentGameInfoEntity Xl;
    private final PlayerLevelInfo Xm;
    private final boolean Xn;

    static final class PlayerEntityCreatorCompat extends PlayerEntityCreator {
        PlayerEntityCreatorCompat() {
        }

        public PlayerEntity cm(Parcel parcel) {
            if (GamesDowngradeableSafeParcel.c(ji.ht()) || ji.aW(PlayerEntity.class.getCanonicalName())) {
                return super.cm(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            return new PlayerEntity(11, readString, readString2, readString3 == null ? null : Uri.parse(readString3), readString4 == null ? null : Uri.parse(readString4), parcel.readLong(), -1, -1, null, null, null, null, null, true);
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return cm(x0);
        }
    }

    PlayerEntity(int versionCode, String playerId, String displayName, Uri iconImageUri, Uri hiResImageUri, long retrievedTimestamp, int isInCircles, long lastPlayedWithTimestamp, String iconImageUrl, String hiResImageUrl, String title, MostRecentGameInfoEntity mostRecentGameInfo, PlayerLevelInfo playerLevelInfo, boolean isProfileVisible) {
        this.CK = versionCode;
        this.Xh = playerId;
        this.OS = displayName;
        this.WD = iconImageUri;
        this.WO = iconImageUrl;
        this.WE = hiResImageUri;
        this.WP = hiResImageUrl;
        this.Xi = retrievedTimestamp;
        this.Xj = isInCircles;
        this.Xk = lastPlayedWithTimestamp;
        this.OH = title;
        this.Xn = isProfileVisible;
        this.Xl = mostRecentGameInfo;
        this.Xm = playerLevelInfo;
    }

    public PlayerEntity(Player player) {
        this.CK = 11;
        this.Xh = player.getPlayerId();
        this.OS = player.getDisplayName();
        this.WD = player.getIconImageUri();
        this.WO = player.getIconImageUrl();
        this.WE = player.getHiResImageUri();
        this.WP = player.getHiResImageUrl();
        this.Xi = player.getRetrievedTimestamp();
        this.Xj = player.kE();
        this.Xk = player.getLastPlayedWithTimestamp();
        this.OH = player.getTitle();
        this.Xn = player.isProfileVisible();
        MostRecentGameInfo kF = player.kF();
        this.Xl = kF == null ? null : new MostRecentGameInfoEntity(kF);
        this.Xm = player.getLevelInfo();
        je.f(this.Xh);
        je.f(this.OS);
        je.K(this.Xi > 0);
    }

    static boolean a(Player player, Object obj) {
        if (!(obj instanceof Player)) {
            return false;
        }
        if (player == obj) {
            return true;
        }
        Player player2 = (Player) obj;
        return jv.equal(player2.getPlayerId(), player.getPlayerId()) && jv.equal(player2.getDisplayName(), player.getDisplayName()) && jv.equal(player2.getIconImageUri(), player.getIconImageUri()) && jv.equal(player2.getHiResImageUri(), player.getHiResImageUri()) && jv.equal(Long.valueOf(player2.getRetrievedTimestamp()), Long.valueOf(player.getRetrievedTimestamp())) && jv.equal(player2.getTitle(), player.getTitle()) && jv.equal(player2.getLevelInfo(), player.getLevelInfo());
    }

    static int b(Player player) {
        return jv.hashCode(player.getPlayerId(), player.getDisplayName(), player.getIconImageUri(), player.getHiResImageUri(), Long.valueOf(player.getRetrievedTimestamp()), player.getTitle(), player.getLevelInfo());
    }

    static String c(Player player) {
        return jv.h(player).a("PlayerId", player.getPlayerId()).a("DisplayName", player.getDisplayName()).a("IconImageUri", player.getIconImageUri()).a("IconImageUrl", player.getIconImageUrl()).a("HiResImageUri", player.getHiResImageUri()).a("HiResImageUrl", player.getHiResImageUrl()).a("RetrievedTimestamp", Long.valueOf(player.getRetrievedTimestamp())).a("Title", player.getTitle()).a("LevelInfo", player.getLevelInfo()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    public Player freeze() {
        return this;
    }

    public String getDisplayName() {
        return this.OS;
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        le.b(this.OS, dataOut);
    }

    public Uri getHiResImageUri() {
        return this.WE;
    }

    public String getHiResImageUrl() {
        return this.WP;
    }

    public Uri getIconImageUri() {
        return this.WD;
    }

    public String getIconImageUrl() {
        return this.WO;
    }

    public long getLastPlayedWithTimestamp() {
        return this.Xk;
    }

    public PlayerLevelInfo getLevelInfo() {
        return this.Xm;
    }

    public String getPlayerId() {
        return this.Xh;
    }

    public long getRetrievedTimestamp() {
        return this.Xi;
    }

    public String getTitle() {
        return this.OH;
    }

    public void getTitle(CharArrayBuffer dataOut) {
        le.b(this.OH, dataOut);
    }

    public int getVersionCode() {
        return this.CK;
    }

    public boolean hasHiResImage() {
        return getHiResImageUri() != null;
    }

    public boolean hasIconImage() {
        return getIconImageUri() != null;
    }

    public int hashCode() {
        return b((Player) this);
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isProfileVisible() {
        return this.Xn;
    }

    public int kE() {
        return this.Xj;
    }

    public MostRecentGameInfo kF() {
        return this.Xl;
    }

    public String toString() {
        return c(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        String str = null;
        if (hu()) {
            dest.writeString(this.Xh);
            dest.writeString(this.OS);
            dest.writeString(this.WD == null ? null : this.WD.toString());
            if (this.WE != null) {
                str = this.WE.toString();
            }
            dest.writeString(str);
            dest.writeLong(this.Xi);
            return;
        }
        PlayerEntityCreator.a(this, dest, flags);
    }
}
