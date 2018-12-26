package com.google.android.gms.games.leaderboard;

import android.os.Bundle;

public final class LeaderboardScoreBufferHeader {
    private final Bundle DJ;

    public static final class Builder {
        private Builder() {
        }
    }

    public LeaderboardScoreBufferHeader(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.DJ = bundle;
    }

    public Bundle mI() {
        return this.DJ;
    }
}
