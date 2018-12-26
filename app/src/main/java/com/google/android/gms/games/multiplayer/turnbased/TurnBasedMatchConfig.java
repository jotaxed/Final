package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;

public abstract class TurnBasedMatchConfig {

    public static final class Builder {
        int adW;
        ArrayList<String> ael;
        Bundle aem;
        int aew;

        private Builder() {
            this.adW = -1;
            this.ael = new ArrayList();
            this.aem = null;
            this.aew = 2;
        }

        public Builder addInvitedPlayer(String playerId) {
            jx.i(playerId);
            this.ael.add(playerId);
            return this;
        }

        public Builder addInvitedPlayers(ArrayList<String> playerIds) {
            jx.i(playerIds);
            this.ael.addAll(playerIds);
            return this;
        }

        public TurnBasedMatchConfig build() {
            return new TurnBasedMatchConfigImpl(this);
        }

        public Builder setAutoMatchCriteria(Bundle autoMatchCriteria) {
            this.aem = autoMatchCriteria;
            return this;
        }

        public Builder setVariant(int variant) {
            boolean z = variant == -1 || variant > 0;
            jx.b(z, (Object) "Variant must be a positive integer or TurnBasedMatch.MATCH_VARIANT_ANY");
            this.adW = variant;
            return this;
        }
    }

    protected TurnBasedMatchConfig() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Bundle createAutoMatchCriteria(int minAutoMatchPlayers, int maxAutoMatchPlayers, long exclusiveBitMask) {
        Bundle bundle = new Bundle();
        bundle.putInt(Multiplayer.EXTRA_MIN_AUTOMATCH_PLAYERS, minAutoMatchPlayers);
        bundle.putInt(Multiplayer.EXTRA_MAX_AUTOMATCH_PLAYERS, maxAutoMatchPlayers);
        bundle.putLong(Multiplayer.EXTRA_EXCLUSIVE_BIT_MASK, exclusiveBitMask);
        return bundle;
    }

    public abstract Bundle getAutoMatchCriteria();

    public abstract String[] getInvitedPlayerIds();

    public abstract int getVariant();

    public abstract int mO();
}
