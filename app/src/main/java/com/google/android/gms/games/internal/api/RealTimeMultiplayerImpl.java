package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.d;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import java.util.List;

public final class RealTimeMultiplayerImpl implements RealTimeMultiplayer {
    private static <L> d<L> a(GoogleApiClient googleApiClient, L l) {
        return l == null ? null : googleApiClient.d(l);
    }

    public void create(GoogleApiClient apiClient, RoomConfig config) {
        Games.d(apiClient).a(apiClient.d(config.getRoomUpdateListener()), a(apiClient, config.getRoomStatusUpdateListener()), a(apiClient, config.getMessageReceivedListener()), config);
    }

    public void declineInvitation(GoogleApiClient apiClient, String invitationId) {
        Games.d(apiClient).q(invitationId, 0);
    }

    public void dismissInvitation(GoogleApiClient apiClient, String invitationId) {
        Games.d(apiClient).p(invitationId, 0);
    }

    public Intent getSelectOpponentsIntent(GoogleApiClient apiClient, int minPlayers, int maxPlayers) {
        return Games.d(apiClient).b(minPlayers, maxPlayers, true);
    }

    public Intent getSelectOpponentsIntent(GoogleApiClient apiClient, int minPlayers, int maxPlayers, boolean allowAutomatch) {
        return Games.d(apiClient).b(minPlayers, maxPlayers, allowAutomatch);
    }

    public RealTimeSocket getSocketForParticipant(GoogleApiClient apiClient, String roomId, String participantId) {
        return Games.d(apiClient).s(roomId, participantId);
    }

    public Intent getWaitingRoomIntent(GoogleApiClient apiClient, Room room, int minParticipantsToStart) {
        return Games.d(apiClient).a(room, minParticipantsToStart);
    }

    public void join(GoogleApiClient apiClient, RoomConfig config) {
        Games.d(apiClient).b(apiClient.d(config.getRoomUpdateListener()), a(apiClient, config.getRoomStatusUpdateListener()), a(apiClient, config.getMessageReceivedListener()), config);
    }

    public void leave(GoogleApiClient apiClient, RoomUpdateListener listener, String roomId) {
        Games.d(apiClient).a(apiClient.d(listener), roomId);
    }

    public int sendReliableMessage(GoogleApiClient apiClient, ReliableMessageSentCallback callback, byte[] messageData, String roomId, String recipientParticipantId) {
        return Games.d(apiClient).a(a(apiClient, callback), messageData, roomId, recipientParticipantId);
    }

    public int sendUnreliableMessage(GoogleApiClient apiClient, byte[] messageData, String roomId, String recipientParticipantId) {
        return Games.d(apiClient).a(messageData, roomId, new String[]{recipientParticipantId});
    }

    public int sendUnreliableMessage(GoogleApiClient apiClient, byte[] messageData, String roomId, List<String> recipientParticipantIds) {
        return Games.d(apiClient).a(messageData, roomId, (String[]) recipientParticipantIds.toArray(new String[recipientParticipantIds.size()]));
    }

    public int sendUnreliableMessageToOthers(GoogleApiClient apiClient, byte[] messageData, String roomId) {
        return Games.d(apiClient).d(messageData, roomId);
    }
}
