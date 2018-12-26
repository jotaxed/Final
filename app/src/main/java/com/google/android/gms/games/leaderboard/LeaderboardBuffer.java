package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;

public final class LeaderboardBuffer extends g<Leaderboard> {
    public LeaderboardBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected /* synthetic */ Object f(int i, int i2) {
        return j(i, i2);
    }

    protected String ha() {
        return "external_leaderboard_id";
    }

    protected Leaderboard j(int i, int i2) {
        return new LeaderboardRef(this.JG, i, i2);
    }
}
