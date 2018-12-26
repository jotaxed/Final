package com.google.android.gms.games.internal.experience;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.GameRef;

public final class ExperienceEventRef extends d implements ExperienceEvent {
    private final GameRef acr;

    public ExperienceEventRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
        if (aS("external_game_id")) {
            this.acr = null;
        } else {
            this.acr = new GameRef(this.JG, this.KZ);
        }
    }

    public String getIconImageUrl() {
        return getString("icon_url");
    }
}
