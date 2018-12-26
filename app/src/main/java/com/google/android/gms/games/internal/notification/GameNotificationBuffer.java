package com.google.android.gms.games.internal.notification;

import com.google.android.gms.common.data.DataBuffer;

public final class GameNotificationBuffer extends DataBuffer<GameNotification> {
    public GameNotification eh(int i) {
        return new GameNotificationRef(this.JG, i);
    }

    public /* synthetic */ Object get(int x0) {
        return eh(x0);
    }
}
