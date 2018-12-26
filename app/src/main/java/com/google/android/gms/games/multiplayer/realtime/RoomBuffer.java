package com.google.android.gms.games.multiplayer.realtime;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;

public final class RoomBuffer extends g<Room> {
    public RoomBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected /* synthetic */ Object f(int i, int i2) {
        return l(i, i2);
    }

    protected String ha() {
        return "external_match_id";
    }

    protected Room l(int i, int i2) {
        return new RoomRef(this.JG, i, i2);
    }
}
