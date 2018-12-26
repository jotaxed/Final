package com.google.android.gms.games;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;

public final class PlayerLevelInfo implements SafeParcelable {
    public static final PlayerLevelInfoCreator CREATOR = new PlayerLevelInfoCreator();
    private final int CK;
    private final long Xr;
    private final long Xs;
    private final PlayerLevel Xt;
    private final PlayerLevel Xu;

    PlayerLevelInfo(int versionCode, long currentXpTotal, long lastLevelUpTimestamp, PlayerLevel currentLevel, PlayerLevel nextLevel) {
        jx.K(currentXpTotal != -1);
        jx.i(currentLevel);
        jx.i(nextLevel);
        this.CK = versionCode;
        this.Xr = currentXpTotal;
        this.Xs = lastLevelUpTimestamp;
        this.Xt = currentLevel;
        this.Xu = nextLevel;
    }

    public PlayerLevelInfo(long currentXpTotal, long lastLevelUpTimestamp, PlayerLevel currentLevel, PlayerLevel nextLevel) {
        this(1, currentXpTotal, lastLevelUpTimestamp, currentLevel, nextLevel);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlayerLevelInfo)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        PlayerLevelInfo playerLevelInfo = (PlayerLevelInfo) obj;
        return jv.equal(Long.valueOf(this.Xr), Long.valueOf(playerLevelInfo.Xr)) && jv.equal(Long.valueOf(this.Xs), Long.valueOf(playerLevelInfo.Xs)) && jv.equal(this.Xt, playerLevelInfo.Xt) && jv.equal(this.Xu, playerLevelInfo.Xu);
    }

    public PlayerLevel getCurrentLevel() {
        return this.Xt;
    }

    public long getCurrentXpTotal() {
        return this.Xr;
    }

    public long getLastLevelUpTimestamp() {
        return this.Xs;
    }

    public PlayerLevel getNextLevel() {
        return this.Xu;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(Long.valueOf(this.Xr), Long.valueOf(this.Xs), this.Xt, this.Xu);
    }

    public boolean isMaxLevel() {
        return this.Xt.equals(this.Xu);
    }

    public void writeToParcel(Parcel out, int flags) {
        PlayerLevelInfoCreator.a(this, out, flags);
    }
}
