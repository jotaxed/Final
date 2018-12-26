package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.DataBuffer;

public final class GameBadgeBuffer extends DataBuffer<GameBadge> {
    public GameBadge ec(int i) {
        return new GameBadgeRef(this.JG, i);
    }

    public /* synthetic */ Object get(int x0) {
        return ec(x0);
    }
}
