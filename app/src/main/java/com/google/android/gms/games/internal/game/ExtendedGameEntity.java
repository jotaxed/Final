package com.google.android.gms.games.internal.game;

import android.os.Parcel;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.internal.ji;
import com.google.android.gms.internal.jv;
import java.util.ArrayList;

public final class ExtendedGameEntity extends GamesDowngradeableSafeParcel implements ExtendedGame {
    public static final ExtendedGameEntityCreator CREATOR = new ExtendedGameEntityCreatorCompat();
    private final int CK;
    private final String acA;
    private final ArrayList<GameBadgeEntity> acB;
    private final SnapshotMetadataEntity acC;
    private final GameEntity acs;
    private final int act;
    private final boolean acu;
    private final int acv;
    private final long acw;
    private final long acx;
    private final String acy;
    private final long acz;

    static final class ExtendedGameEntityCreatorCompat extends ExtendedGameEntityCreator {
        ExtendedGameEntityCreatorCompat() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return cu(x0);
        }

        public ExtendedGameEntity cu(Parcel parcel) {
            if (GamesDowngradeableSafeParcel.c(ji.ht()) || ji.aW(ExtendedGameEntity.class.getCanonicalName())) {
                return super.cu(parcel);
            }
            GameEntity gameEntity = (GameEntity) GameEntity.CREATOR.createFromParcel(parcel);
            int readInt = parcel.readInt();
            boolean z = parcel.readInt() == 1;
            int readInt2 = parcel.readInt();
            long readLong = parcel.readLong();
            long readLong2 = parcel.readLong();
            String readString = parcel.readString();
            long readLong3 = parcel.readLong();
            String readString2 = parcel.readString();
            int readInt3 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt3);
            for (int i = 0; i < readInt3; i++) {
                arrayList.add(GameBadgeEntity.CREATOR.cv(parcel));
            }
            return new ExtendedGameEntity(2, gameEntity, readInt, z, readInt2, readLong, readLong2, readString, readLong3, readString2, arrayList, null);
        }
    }

    ExtendedGameEntity(int versionCode, GameEntity game, int availability, boolean owned, int achievementUnlockedCount, long lastPlayedServerTimestamp, long priceMicros, String formattedPrice, long fullPriceMicros, String formattedFullPrice, ArrayList<GameBadgeEntity> badges, SnapshotMetadataEntity snapshot) {
        this.CK = versionCode;
        this.acs = game;
        this.act = availability;
        this.acu = owned;
        this.acv = achievementUnlockedCount;
        this.acw = lastPlayedServerTimestamp;
        this.acx = priceMicros;
        this.acy = formattedPrice;
        this.acz = fullPriceMicros;
        this.acA = formattedFullPrice;
        this.acB = badges;
        this.acC = snapshot;
    }

    public ExtendedGameEntity(ExtendedGame extendedGame) {
        SnapshotMetadataEntity snapshotMetadataEntity = null;
        this.CK = 2;
        Game game = extendedGame.getGame();
        this.acs = game == null ? null : new GameEntity(game);
        this.act = extendedGame.lZ();
        this.acu = extendedGame.ma();
        this.acv = extendedGame.mb();
        this.acw = extendedGame.mc();
        this.acx = extendedGame.md();
        this.acy = extendedGame.me();
        this.acz = extendedGame.mf();
        this.acA = extendedGame.mg();
        SnapshotMetadata mh = extendedGame.mh();
        if (mh != null) {
            snapshotMetadataEntity = new SnapshotMetadataEntity(mh);
        }
        this.acC = snapshotMetadataEntity;
        ArrayList lY = extendedGame.lY();
        int size = lY.size();
        this.acB = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.acB.add((GameBadgeEntity) ((GameBadge) lY.get(i)).freeze());
        }
    }

    static int a(ExtendedGame extendedGame) {
        return jv.hashCode(extendedGame.getGame(), Integer.valueOf(extendedGame.lZ()), Boolean.valueOf(extendedGame.ma()), Integer.valueOf(extendedGame.mb()), Long.valueOf(extendedGame.mc()), Long.valueOf(extendedGame.md()), extendedGame.me(), Long.valueOf(extendedGame.mf()), extendedGame.mg());
    }

    static boolean a(ExtendedGame extendedGame, Object obj) {
        if (!(obj instanceof ExtendedGame)) {
            return false;
        }
        if (extendedGame == obj) {
            return true;
        }
        ExtendedGame extendedGame2 = (ExtendedGame) obj;
        return jv.equal(extendedGame2.getGame(), extendedGame.getGame()) && jv.equal(Integer.valueOf(extendedGame2.lZ()), Integer.valueOf(extendedGame.lZ())) && jv.equal(Boolean.valueOf(extendedGame2.ma()), Boolean.valueOf(extendedGame.ma())) && jv.equal(Integer.valueOf(extendedGame2.mb()), Integer.valueOf(extendedGame.mb())) && jv.equal(Long.valueOf(extendedGame2.mc()), Long.valueOf(extendedGame.mc())) && jv.equal(Long.valueOf(extendedGame2.md()), Long.valueOf(extendedGame.md())) && jv.equal(extendedGame2.me(), extendedGame.me()) && jv.equal(Long.valueOf(extendedGame2.mf()), Long.valueOf(extendedGame.mf())) && jv.equal(extendedGame2.mg(), extendedGame.mg());
    }

    static String b(ExtendedGame extendedGame) {
        return jv.h(extendedGame).a("Game", extendedGame.getGame()).a("Availability", Integer.valueOf(extendedGame.lZ())).a("Owned", Boolean.valueOf(extendedGame.ma())).a("AchievementUnlockedCount", Integer.valueOf(extendedGame.mb())).a("LastPlayedServerTimestamp", Long.valueOf(extendedGame.mc())).a("PriceMicros", Long.valueOf(extendedGame.md())).a("FormattedPrice", extendedGame.me()).a("FullPriceMicros", Long.valueOf(extendedGame.mf())).a("FormattedFullPrice", extendedGame.mg()).a("Snapshot", extendedGame.mh()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return mj();
    }

    public /* synthetic */ Game getGame() {
        return mi();
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

    public ArrayList<GameBadge> lY() {
        return new ArrayList(this.acB);
    }

    public int lZ() {
        return this.act;
    }

    public boolean ma() {
        return this.acu;
    }

    public int mb() {
        return this.acv;
    }

    public long mc() {
        return this.acw;
    }

    public long md() {
        return this.acx;
    }

    public String me() {
        return this.acy;
    }

    public long mf() {
        return this.acz;
    }

    public String mg() {
        return this.acA;
    }

    public SnapshotMetadata mh() {
        return this.acC;
    }

    public GameEntity mi() {
        return this.acs;
    }

    public ExtendedGame mj() {
        return this;
    }

    public String toString() {
        return b((ExtendedGame) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        int i = 0;
        if (hu()) {
            this.acs.writeToParcel(dest, flags);
            dest.writeInt(this.act);
            dest.writeInt(this.acu ? 1 : 0);
            dest.writeInt(this.acv);
            dest.writeLong(this.acw);
            dest.writeLong(this.acx);
            dest.writeString(this.acy);
            dest.writeLong(this.acz);
            dest.writeString(this.acA);
            int size = this.acB.size();
            dest.writeInt(size);
            while (i < size) {
                ((GameBadgeEntity) this.acB.get(i)).writeToParcel(dest, flags);
                i++;
            }
            return;
        }
        ExtendedGameEntityCreator.a(this, dest, flags);
    }
}
