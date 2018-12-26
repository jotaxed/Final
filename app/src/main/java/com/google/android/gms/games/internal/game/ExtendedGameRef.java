package com.google.android.gms.games.internal.game;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataRef;
import java.util.ArrayList;

public class ExtendedGameRef extends d implements ExtendedGame {
    private final int Ya;
    private final SnapshotMetadataRef acD;
    private final GameRef acr;

    ExtendedGameRef(DataHolder holder, int dataRow, int numChildren) {
        super(holder, dataRow);
        this.acr = new GameRef(holder, dataRow);
        this.Ya = numChildren;
        if (!aQ("external_snapshot_id") || aS("external_snapshot_id")) {
            this.acD = null;
        } else {
            this.acD = new SnapshotMetadataRef(holder, dataRow);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return ExtendedGameEntity.a(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return mj();
    }

    public Game getGame() {
        return this.acr;
    }

    public int hashCode() {
        return ExtendedGameEntity.a(this);
    }

    public ArrayList<GameBadge> lY() {
        int i = 0;
        if (this.JG.c("badge_title", this.KZ, this.JG.au(this.KZ)) == null) {
            return new ArrayList(0);
        }
        ArrayList<GameBadge> arrayList = new ArrayList(this.Ya);
        while (i < this.Ya) {
            arrayList.add(new GameBadgeRef(this.JG, this.KZ + i));
            i++;
        }
        return arrayList;
    }

    public int lZ() {
        return getInteger("availability");
    }

    public boolean ma() {
        return getBoolean("owned");
    }

    public int mb() {
        return getInteger("achievement_unlocked_count");
    }

    public long mc() {
        return getLong("last_played_server_time");
    }

    public long md() {
        return getLong("price_micros");
    }

    public String me() {
        return getString("formatted_price");
    }

    public long mf() {
        return getLong("full_price_micros");
    }

    public String mg() {
        return getString("formatted_full_price");
    }

    public SnapshotMetadata mh() {
        return this.acD;
    }

    public ExtendedGame mj() {
        return new ExtendedGameEntity(this);
    }

    public String toString() {
        return ExtendedGameEntity.b((ExtendedGame) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((ExtendedGameEntity) mj()).writeToParcel(dest, flags);
    }
}
