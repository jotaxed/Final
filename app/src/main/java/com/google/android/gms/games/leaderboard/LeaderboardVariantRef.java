package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;

public final class LeaderboardVariantRef extends d implements LeaderboardVariant {
    LeaderboardVariantRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
    }

    public boolean equals(Object obj) {
        return LeaderboardVariantEntity.a(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return mN();
    }

    public int getCollection() {
        return getInteger("collection");
    }

    public String getDisplayPlayerRank() {
        return getString("player_display_rank");
    }

    public String getDisplayPlayerScore() {
        return getString("player_display_score");
    }

    public long getNumScores() {
        return aS("total_scores") ? -1 : getLong("total_scores");
    }

    public long getPlayerRank() {
        return aS("player_rank") ? -1 : getLong("player_rank");
    }

    public String getPlayerScoreTag() {
        return getString("player_score_tag");
    }

    public long getRawPlayerScore() {
        return aS("player_raw_score") ? -1 : getLong("player_raw_score");
    }

    public int getTimeSpan() {
        return getInteger("timespan");
    }

    public boolean hasPlayerInfo() {
        return !aS("player_raw_score");
    }

    public int hashCode() {
        return LeaderboardVariantEntity.a(this);
    }

    public String mK() {
        return getString("top_page_token_next");
    }

    public String mL() {
        return getString("window_page_token_prev");
    }

    public String mM() {
        return getString("window_page_token_next");
    }

    public LeaderboardVariant mN() {
        return new LeaderboardVariantEntity(this);
    }

    public String toString() {
        return LeaderboardVariantEntity.b(this);
    }
}
