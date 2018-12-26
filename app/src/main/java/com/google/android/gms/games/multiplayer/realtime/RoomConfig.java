package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class RoomConfig {

    public static final class Builder {
        int adW;
        final RoomUpdateListener aeh;
        RoomStatusUpdateListener aei;
        RealTimeMessageReceivedListener aej;
        String aek;
        ArrayList<String> ael;
        Bundle aem;
        boolean aen;

        private Builder(RoomUpdateListener updateListener) {
            this.aek = null;
            this.adW = -1;
            this.ael = new ArrayList();
            this.aen = false;
            this.aeh = (RoomUpdateListener) jx.b((Object) updateListener, (Object) "Must provide a RoomUpdateListener");
        }

        public Builder addPlayersToInvite(ArrayList<String> playerIds) {
            jx.i(playerIds);
            this.ael.addAll(playerIds);
            return this;
        }

        public Builder addPlayersToInvite(String... playerIds) {
            jx.i(playerIds);
            this.ael.addAll(Arrays.asList(playerIds));
            return this;
        }

        public RoomConfig build() {
            return new RoomConfigImpl(this);
        }

        public Builder setAutoMatchCriteria(Bundle autoMatchCriteria) {
            this.aem = autoMatchCriteria;
            return this;
        }

        public Builder setInvitationIdToAccept(String invitationId) {
            jx.i(invitationId);
            this.aek = invitationId;
            return this;
        }

        public Builder setMessageReceivedListener(RealTimeMessageReceivedListener listener) {
            this.aej = listener;
            return this;
        }

        public Builder setRoomStatusUpdateListener(RoomStatusUpdateListener listener) {
            this.aei = listener;
            return this;
        }

        @Deprecated
        public Builder setSocketCommunicationEnabled(boolean enableSockets) {
            this.aen = enableSockets;
            return this;
        }

        public Builder setVariant(int variant) {
            boolean z = variant == -1 || variant > 0;
            jx.b(z, (Object) "Variant must be a positive integer or Room.ROOM_VARIANT_ANY");
            this.adW = variant;
            return this;
        }
    }

    protected RoomConfig() {
    }

    public static Builder builder(RoomUpdateListener listener) {
        return new Builder(listener);
    }

    public static Bundle createAutoMatchCriteria(int minAutoMatchPlayers, int maxAutoMatchPlayers, long exclusiveBitMask) {
        Bundle bundle = new Bundle();
        bundle.putInt(Multiplayer.EXTRA_MIN_AUTOMATCH_PLAYERS, minAutoMatchPlayers);
        bundle.putInt(Multiplayer.EXTRA_MAX_AUTOMATCH_PLAYERS, maxAutoMatchPlayers);
        bundle.putLong(Multiplayer.EXTRA_EXCLUSIVE_BIT_MASK, exclusiveBitMask);
        return bundle;
    }

    public abstract Bundle getAutoMatchCriteria();

    public abstract String getInvitationId();

    public abstract String[] getInvitedPlayerIds();

    public abstract RealTimeMessageReceivedListener getMessageReceivedListener();

    public abstract RoomStatusUpdateListener getRoomStatusUpdateListener();

    public abstract RoomUpdateListener getRoomUpdateListener();

    public abstract int getVariant();

    @Deprecated
    public abstract boolean isSocketEnabled();
}
