package com.google.android.gms.games.multiplayer.turnbased;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;

public final class TurnBasedMatchBuffer extends g<TurnBasedMatch> {
    public TurnBasedMatchBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected /* synthetic */ Object f(int i, int i2) {
        return m(i, i2);
    }

    protected String ha() {
        return "external_match_id";
    }

    protected TurnBasedMatch m(int i, int i2) {
        return new TurnBasedMatchRef(this.JG, i, i2);
    }
}
