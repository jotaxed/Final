package com.google.android.gms.games.request;

import com.google.android.gms.common.data.DataBuffer;

public final class GameRequestSummaryBuffer extends DataBuffer<GameRequestSummary> {
    public GameRequestSummary ep(int i) {
        return new GameRequestSummaryRef(this.JG, i);
    }

    public /* synthetic */ Object get(int x0) {
        return ep(x0);
    }
}
