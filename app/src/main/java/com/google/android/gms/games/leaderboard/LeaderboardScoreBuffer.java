package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class LeaderboardScoreBuffer extends DataBuffer<LeaderboardScore> {
    private final LeaderboardScoreBufferHeader adr;

    public LeaderboardScoreBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.adr = new LeaderboardScoreBufferHeader(dataHolder.gV());
    }

    public LeaderboardScore get(int position) {
        return new LeaderboardScoreRef(this.JG, position);
    }

    public LeaderboardScoreBufferHeader mH() {
        return this.adr;
    }
}
