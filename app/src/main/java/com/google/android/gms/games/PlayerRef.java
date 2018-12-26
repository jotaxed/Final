package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoRef;
import com.google.android.gms.games.internal.player.PlayerColumnNames;

public final class PlayerRef extends d implements Player {
    private final PlayerLevelInfo Xm;
    private final PlayerColumnNames Xv;
    private final MostRecentGameInfoRef Xw;

    public PlayerRef(DataHolder holder, int dataRow) {
        this(holder, dataRow, null);
    }

    public PlayerRef(DataHolder holder, int dataRow, String prefix) {
        super(holder, dataRow);
        this.Xv = new PlayerColumnNames(prefix);
        this.Xw = new MostRecentGameInfoRef(holder, dataRow, this.Xv);
        if (kG()) {
            PlayerLevel playerLevel;
            int integer = getInteger(this.Xv.acV);
            int integer2 = getInteger(this.Xv.acY);
            PlayerLevel playerLevel2 = new PlayerLevel(integer, getLong(this.Xv.acW), getLong(this.Xv.acX));
            if (integer != integer2) {
                playerLevel = new PlayerLevel(integer2, getLong(this.Xv.acX), getLong(this.Xv.acZ));
            } else {
                playerLevel = playerLevel2;
            }
            this.Xm = new PlayerLevelInfo(getLong(this.Xv.acU), getLong(this.Xv.ada), playerLevel2, playerLevel);
            return;
        }
        this.Xm = null;
    }

    private boolean kG() {
        return (aS(this.Xv.acU) || getLong(this.Xv.acU) == -1) ? false : true;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return PlayerEntity.a(this, obj);
    }

    public Player freeze() {
        return new PlayerEntity(this);
    }

    public String getDisplayName() {
        return getString(this.Xv.acM);
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        a(this.Xv.acM, dataOut);
    }

    public Uri getHiResImageUri() {
        return aR(this.Xv.acP);
    }

    public String getHiResImageUrl() {
        return getString(this.Xv.acQ);
    }

    public Uri getIconImageUri() {
        return aR(this.Xv.acN);
    }

    public String getIconImageUrl() {
        return getString(this.Xv.acO);
    }

    public long getLastPlayedWithTimestamp() {
        return (!aQ(this.Xv.acT) || aS(this.Xv.acT)) ? -1 : getLong(this.Xv.acT);
    }

    public PlayerLevelInfo getLevelInfo() {
        return this.Xm;
    }

    public String getPlayerId() {
        return getString(this.Xv.acL);
    }

    public long getRetrievedTimestamp() {
        return getLong(this.Xv.acR);
    }

    public String getTitle() {
        return getString(this.Xv.adb);
    }

    public void getTitle(CharArrayBuffer dataOut) {
        a(this.Xv.adb, dataOut);
    }

    public boolean hasHiResImage() {
        return getHiResImageUri() != null;
    }

    public boolean hasIconImage() {
        return getIconImageUri() != null;
    }

    public int hashCode() {
        return PlayerEntity.b((Player) this);
    }

    public boolean isProfileVisible() {
        return getBoolean(this.Xv.add);
    }

    public int kE() {
        return getInteger(this.Xv.acS);
    }

    public MostRecentGameInfo kF() {
        return aS(this.Xv.ade) ? null : this.Xw;
    }

    public String toString() {
        return PlayerEntity.c(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((PlayerEntity) freeze()).writeToParcel(dest, flags);
    }
}
