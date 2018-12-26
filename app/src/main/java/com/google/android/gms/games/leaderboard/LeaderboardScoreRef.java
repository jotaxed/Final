package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

public final class LeaderboardScoreRef extends d implements LeaderboardScore {
    private final PlayerRef adE;

    LeaderboardScoreRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
        this.adE = new PlayerRef(holder, dataRow);
    }

    public boolean equals(Object obj) {
        return LeaderboardScoreEntity.a(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return mJ();
    }

    public String getDisplayRank() {
        return getString("display_rank");
    }

    public void getDisplayRank(CharArrayBuffer dataOut) {
        a("display_rank", dataOut);
    }

    public String getDisplayScore() {
        return getString("display_score");
    }

    public void getDisplayScore(CharArrayBuffer dataOut) {
        a("display_score", dataOut);
    }

    public long getRank() {
        return getLong("rank");
    }

    public long getRawScore() {
        return getLong("raw_score");
    }

    public Player getScoreHolder() {
        return aS("external_player_id") ? null : this.adE;
    }

    public String getScoreHolderDisplayName() {
        return aS("external_player_id") ? getString("default_display_name") : this.adE.getDisplayName();
    }

    public void getScoreHolderDisplayName(CharArrayBuffer dataOut) {
        if (aS("external_player_id")) {
            a("default_display_name", dataOut);
        } else {
            this.adE.getDisplayName(dataOut);
        }
    }

    public Uri getScoreHolderHiResImageUri() {
        return aS("external_player_id") ? null : this.adE.getHiResImageUri();
    }

    public String getScoreHolderHiResImageUrl() {
        return aS("external_player_id") ? null : this.adE.getHiResImageUrl();
    }

    public Uri getScoreHolderIconImageUri() {
        return aS("external_player_id") ? aR("default_display_image_uri") : this.adE.getIconImageUri();
    }

    public String getScoreHolderIconImageUrl() {
        return aS("external_player_id") ? getString("default_display_image_url") : this.adE.getIconImageUrl();
    }

    public String getScoreTag() {
        return getString("score_tag");
    }

    public long getTimestampMillis() {
        return getLong("achieved_timestamp");
    }

    public int hashCode() {
        return LeaderboardScoreEntity.a(this);
    }

    public LeaderboardScore mJ() {
        return new LeaderboardScoreEntity(this);
    }

    public String toString() {
        return LeaderboardScoreEntity.b(this);
    }
}
