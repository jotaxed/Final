package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;

public final class ExtendedGameBuffer extends g<ExtendedGame> {
    public ExtendedGameBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected /* synthetic */ Object f(int i, int i2) {
        return i(i, i2);
    }

    protected String ha() {
        return "external_game_id";
    }

    protected ExtendedGame i(int i, int i2) {
        return new ExtendedGameRef(this.JG, i, i2);
    }
}
