package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;

public final class MostRecentGameInfoEntity implements SafeParcelable, MostRecentGameInfo {
    public static final MostRecentGameInfoEntityCreator CREATOR = new MostRecentGameInfoEntityCreator();
    private final int CK;
    private final String acF;
    private final String acG;
    private final long acH;
    private final Uri acI;
    private final Uri acJ;
    private final Uri acK;

    MostRecentGameInfoEntity(int versionCode, String gameId, String gameName, long activityTimestampMillis, Uri gameIconImageUri, Uri gameHiResIconImageUri, Uri gameFeaturedImageUri) {
        this.CK = versionCode;
        this.acF = gameId;
        this.acG = gameName;
        this.acH = activityTimestampMillis;
        this.acI = gameIconImageUri;
        this.acJ = gameHiResIconImageUri;
        this.acK = gameFeaturedImageUri;
    }

    public MostRecentGameInfoEntity(MostRecentGameInfo info) {
        this.CK = 2;
        this.acF = info.mw();
        this.acG = info.mx();
        this.acH = info.my();
        this.acI = info.mz();
        this.acJ = info.mA();
        this.acK = info.mB();
    }

    static int a(MostRecentGameInfo mostRecentGameInfo) {
        return jv.hashCode(mostRecentGameInfo.mw(), mostRecentGameInfo.mx(), Long.valueOf(mostRecentGameInfo.my()), mostRecentGameInfo.mz(), mostRecentGameInfo.mA(), mostRecentGameInfo.mB());
    }

    static boolean a(MostRecentGameInfo mostRecentGameInfo, Object obj) {
        if (!(obj instanceof MostRecentGameInfo)) {
            return false;
        }
        if (mostRecentGameInfo == obj) {
            return true;
        }
        MostRecentGameInfo mostRecentGameInfo2 = (MostRecentGameInfo) obj;
        return jv.equal(mostRecentGameInfo2.mw(), mostRecentGameInfo.mw()) && jv.equal(mostRecentGameInfo2.mx(), mostRecentGameInfo.mx()) && jv.equal(Long.valueOf(mostRecentGameInfo2.my()), Long.valueOf(mostRecentGameInfo.my())) && jv.equal(mostRecentGameInfo2.mz(), mostRecentGameInfo.mz()) && jv.equal(mostRecentGameInfo2.mA(), mostRecentGameInfo.mA()) && jv.equal(mostRecentGameInfo2.mB(), mostRecentGameInfo.mB());
    }

    static String b(MostRecentGameInfo mostRecentGameInfo) {
        return jv.h(mostRecentGameInfo).a("GameId", mostRecentGameInfo.mw()).a("GameName", mostRecentGameInfo.mx()).a("ActivityTimestampMillis", Long.valueOf(mostRecentGameInfo.my())).a("GameIconUri", mostRecentGameInfo.mz()).a("GameHiResUri", mostRecentGameInfo.mA()).a("GameFeaturedUri", mostRecentGameInfo.mB()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return mC();
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

    public Uri mA() {
        return this.acJ;
    }

    public Uri mB() {
        return this.acK;
    }

    public MostRecentGameInfo mC() {
        return this;
    }

    public String mw() {
        return this.acF;
    }

    public String mx() {
        return this.acG;
    }

    public long my() {
        return this.acH;
    }

    public Uri mz() {
        return this.acI;
    }

    public String toString() {
        return b(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        MostRecentGameInfoEntityCreator.a(this, out, flags);
    }
}
