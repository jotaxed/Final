package com.google.android.gms.games.request;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;

public final class GameRequestBuffer extends g<GameRequest> {
    public GameRequestBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected /* synthetic */ Object f(int i, int i2) {
        return o(i, i2);
    }

    protected String ha() {
        return "external_request_id";
    }

    protected GameRequest o(int i, int i2) {
        return new GameRequestRef(this.JG, i, i2);
    }
}
