package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class GameSearchSuggestionBuffer extends DataBuffer<GameSearchSuggestion> {
    public GameSearchSuggestionBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    public GameSearchSuggestion ef(int i) {
        return new GameSearchSuggestionRef(this.JG, i);
    }

    public /* synthetic */ Object get(int x0) {
        return ef(x0);
    }
}
