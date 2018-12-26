package com.google.android.gms.games;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;

public final class PlayerLevel implements SafeParcelable {
    public static final PlayerLevelCreator CREATOR = new PlayerLevelCreator();
    private final int CK;
    private final int Xo;
    private final long Xp;
    private final long Xq;

    PlayerLevel(int versionCode, int levelNumber, long minXp, long maxXp) {
        boolean z = true;
        jx.a(minXp >= 0, "Min XP must be positive!");
        if (maxXp <= minXp) {
            z = false;
        }
        jx.a(z, "Max XP must be more than min XP!");
        this.CK = versionCode;
        this.Xo = levelNumber;
        this.Xp = minXp;
        this.Xq = maxXp;
    }

    public PlayerLevel(int value, long minXp, long maxXp) {
        this(1, value, minXp, maxXp);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlayerLevel)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        PlayerLevel playerLevel = (PlayerLevel) obj;
        return jv.equal(Integer.valueOf(playerLevel.getLevelNumber()), Integer.valueOf(getLevelNumber())) && jv.equal(Long.valueOf(playerLevel.getMinXp()), Long.valueOf(getMinXp())) && jv.equal(Long.valueOf(playerLevel.getMaxXp()), Long.valueOf(getMaxXp()));
    }

    public int getLevelNumber() {
        return this.Xo;
    }

    public long getMaxXp() {
        return this.Xq;
    }

    public long getMinXp() {
        return this.Xp;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(Integer.valueOf(this.Xo), Long.valueOf(this.Xp), Long.valueOf(this.Xq));
    }

    public String toString() {
        return jv.h(this).a("LevelNumber", Integer.valueOf(getLevelNumber())).a("MinXp", Long.valueOf(getMinXp())).a("MaxXp", Long.valueOf(getMaxXp())).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        PlayerLevelCreator.a(this, out, flags);
    }
}
