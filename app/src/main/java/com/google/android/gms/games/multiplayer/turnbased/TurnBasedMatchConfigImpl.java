package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig.Builder;

public final class TurnBasedMatchConfigImpl extends TurnBasedMatchConfig {
    private final int adW;
    private final Bundle aem;
    private final String[] aeo;
    private final int aew;

    TurnBasedMatchConfigImpl(Builder builder) {
        this.adW = builder.adW;
        this.aew = builder.aew;
        this.aem = builder.aem;
        this.aeo = (String[]) builder.ael.toArray(new String[builder.ael.size()]);
    }

    public Bundle getAutoMatchCriteria() {
        return this.aem;
    }

    public String[] getInvitedPlayerIds() {
        return this.aeo;
    }

    public int getVariant() {
        return this.adW;
    }

    public int mO() {
        return this.aew;
    }
}
