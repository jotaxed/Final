package com.google.android.gms.games.internal;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.b;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Games.GamesOptions;
import com.google.android.gms.games.GamesMetadata.LoadExtendedGamesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameInstancesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameSearchSuggestionsResult;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;
import com.google.android.gms.games.Notifications.ContactSettingLoadResult;
import com.google.android.gms.games.Notifications.GameMuteStatusChangeResult;
import com.google.android.gms.games.Notifications.GameMuteStatusLoadResult;
import com.google.android.gms.games.Notifications.InboxCountResult;
import com.google.android.gms.games.OnNearbyPlayerDetectedListener;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players.LoadOwnerCoverPhotoUrisResult;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.Players.LoadProfileSettingsResult;
import com.google.android.gms.games.Players.LoadXpForGameCategoriesResult;
import com.google.android.gms.games.Players.LoadXpStreamResult;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;
import com.google.android.gms.games.appcontent.AppContents.LoadAppContentResult;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events.LoadEventsResult;
import com.google.android.gms.games.internal.IGamesService.Stub;
import com.google.android.gms.games.internal.constants.RequestType;
import com.google.android.gms.games.internal.events.EventIncrementCache;
import com.google.android.gms.games.internal.events.EventIncrementManager;
import com.google.android.gms.games.internal.experience.ExperienceEventBuffer;
import com.google.android.gms.games.internal.game.Acls.LoadAclResult;
import com.google.android.gms.games.internal.game.ExtendedGameBuffer;
import com.google.android.gms.games.internal.game.GameInstanceBuffer;
import com.google.android.gms.games.internal.game.GameSearchSuggestionBuffer;
import com.google.android.gms.games.internal.request.RequestUpdateOutcomes;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardEntity;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScoreEntity;
import com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult;
import com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.ParticipantUtils;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomBuffer;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchBuffer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestEntity;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests.AcceptQuestResult;
import com.google.android.gms.games.quest.Quests.ClaimMilestoneResult;
import com.google.android.gms.games.quest.Quests.LoadQuestsResult;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests.LoadRequestSummariesResult;
import com.google.android.gms.games.request.Requests.LoadRequestsResult;
import com.google.android.gms.games.request.Requests.SendRequestResult;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotContentsEntity;
import com.google.android.gms.games.snapshot.SnapshotEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult;
import com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult;
import com.google.android.gms.internal.je;
import com.google.android.gms.internal.jl;
import com.google.android.gms.internal.jl.e;
import com.google.android.gms.internal.jt;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.ll;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class GamesClientImpl extends jl<IGamesService> implements ConnectionCallbacks, OnConnectionFailedListener {
    private final String DZ;
    EventIncrementManager Yk = new EventIncrementManager(this) {
        final /* synthetic */ GamesClientImpl Yu;

        {
            this.Yu = r1;
        }

        public EventIncrementCache lF() {
            return new GameClientEventIncrementCache(this.Yu);
        }
    };
    private final String Yl;
    private final Map<String, RealTimeSocket> Ym;
    private PlayerEntity Yn;
    private GameEntity Yo;
    private final PopupManager Yp;
    private boolean Yq = false;
    private final Binder Yr;
    private final long Ys;
    private final GamesOptions Yt;

    private static abstract class AbstractRoomStatusNotifier extends a<RoomStatusUpdateListener> {
        AbstractRoomStatusNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        protected void a(RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder) {
            a(roomStatusUpdateListener, GamesClientImpl.R(dataHolder));
        }

        protected abstract void a(RoomStatusUpdateListener roomStatusUpdateListener, Room room);
    }

    private static abstract class AbstractPeerStatusNotifier extends AbstractRoomStatusNotifier {
        private final ArrayList<String> Yv = new ArrayList();

        AbstractPeerStatusNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder);
            for (Object add : participantIds) {
                this.Yv.add(add);
            }
        }

        protected void a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            a(roomStatusUpdateListener, room, this.Yv);
        }

        protected abstract void a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList);
    }

    private static abstract class AbstractRoomNotifier extends a<RoomUpdateListener> {
        AbstractRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        protected void a(RoomUpdateListener roomUpdateListener, DataHolder dataHolder) {
            a(roomUpdateListener, GamesClientImpl.R(dataHolder), dataHolder.getStatusCode());
        }

        protected abstract void a(RoomUpdateListener roomUpdateListener, Room room, int i);
    }

    private static final class AcceptQuestResultImpl extends b implements AcceptQuestResult {
        private final Quest Yw;

        AcceptQuestResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            try {
                if (questBuffer.getCount() > 0) {
                    this.Yw = new QuestEntity((Quest) questBuffer.get(0));
                } else {
                    this.Yw = null;
                }
                questBuffer.release();
            } catch (Throwable th) {
                questBuffer.release();
            }
        }

        public Quest getQuest() {
            return this.Yw;
        }
    }

    private static final class AchievementUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final BaseImplementation.b<UpdateAchievementResult> Ea;

        AchievementUpdatedBinderCallback(BaseImplementation.b<UpdateAchievementResult> resultHolder) {
            this.Ea = (BaseImplementation.b) jx.b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void g(int i, String str) {
            this.Ea.b(new UpdateAchievementResultImpl(i, str));
        }
    }

    private static final class AchievementsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final BaseImplementation.b<LoadAchievementsResult> Ea;

        AchievementsLoadedBinderCallback(BaseImplementation.b<LoadAchievementsResult> resultHolder) {
            this.Ea = (BaseImplementation.b) jx.b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void c(DataHolder dataHolder) {
            this.Ea.b(new LoadAchievementsResultImpl(dataHolder));
        }
    }

    private static final class AppContentLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final BaseImplementation.b<LoadAppContentResult> Yx;

        public AppContentLoadedBinderCallbacks(BaseImplementation.b<LoadAppContentResult> resultHolder) {
            this.Yx = (BaseImplementation.b) jx.b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void a(DataHolder[] dataHolderArr) {
            this.Yx.b(new LoadAppContentsResultImpl(dataHolderArr));
        }
    }

    private static final class CancelMatchResultImpl implements CancelMatchResult {
        private final Status Eb;
        private final String Yy;

        CancelMatchResultImpl(Status status, String externalMatchId) {
            this.Eb = status;
            this.Yy = externalMatchId;
        }

        public String getMatchId() {
            return this.Yy;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    private static final class ClaimMilestoneResultImpl extends b implements ClaimMilestoneResult {
        private final Quest Yw;
        private final Milestone Yz;

        ClaimMilestoneResultImpl(DataHolder dataHolder, String milestoneId) {
            super(dataHolder);
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            try {
                if (questBuffer.getCount() > 0) {
                    this.Yw = new QuestEntity((Quest) questBuffer.get(0));
                    List mQ = this.Yw.mQ();
                    int size = mQ.size();
                    for (int i = 0; i < size; i++) {
                        if (((Milestone) mQ.get(i)).getMilestoneId().equals(milestoneId)) {
                            this.Yz = (Milestone) mQ.get(i);
                            return;
                        }
                    }
                    this.Yz = null;
                } else {
                    this.Yz = null;
                    this.Yw = null;
                }
                questBuffer.release();
            } finally {
                questBuffer.release();
            }
        }

        public Milestone getMilestone() {
            return this.Yz;
        }

        public Quest getQuest() {
            return this.Yw;
        }
    }

    private static final class CommitSnapshotResultImpl extends b implements CommitSnapshotResult {
        private final SnapshotMetadata YA;

        CommitSnapshotResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(dataHolder);
            try {
                if (snapshotMetadataBuffer.getCount() > 0) {
                    this.YA = new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0));
                } else {
                    this.YA = null;
                }
                snapshotMetadataBuffer.release();
            } catch (Throwable th) {
                snapshotMetadataBuffer.release();
            }
        }

        public SnapshotMetadata getSnapshotMetadata() {
            return this.YA;
        }
    }

    private static final class ConnectedToRoomNotifier extends AbstractRoomStatusNotifier {
        ConnectedToRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onConnectedToRoom(room);
        }
    }

    private static final class ContactSettingLoadResultImpl extends b implements ContactSettingLoadResult {
        ContactSettingLoadResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class ContactSettingsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final BaseImplementation.b<ContactSettingLoadResult> Ea;

        ContactSettingsLoadedBinderCallback(BaseImplementation.b<ContactSettingLoadResult> holder) {
            this.Ea = (BaseImplementation.b) jx.b((Object) holder, (Object) "Holder must not be null");
        }

        public void D(DataHolder dataHolder) {
            this.Ea.b(new ContactSettingLoadResultImpl(dataHolder));
        }
    }

    private static final class ContactSettingsUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final BaseImplementation.b<Status> Ea;

        ContactSettingsUpdatedBinderCallback(BaseImplementation.b<Status> holder) {
            this.Ea = (BaseImplementation.b) jx.b((Object) holder, (Object) "Holder must not be null");
        }

        public void dP(int i) {
            this.Ea.b(new Status(i));
        }
    }

    private static final class DeleteSnapshotResultImpl implements DeleteSnapshotResult {
        private final Status Eb;
        private final String YB;

        DeleteSnapshotResultImpl(int statusCode, String snapshotId) {
            this.Eb = new Status(statusCode);
            this.YB = snapshotId;
        }

        public String getSnapshotId() {
            return this.YB;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    private static final class DisconnectedFromRoomNotifier extends AbstractRoomStatusNotifier {
        DisconnectedFromRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onDisconnectedFromRoom(room);
        }
    }

    private static final class EventsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final BaseImplementation.b<LoadEventsResult> Ea;

        EventsLoadedBinderCallback(BaseImplementation.b<LoadEventsResult> resultHolder) {
            this.Ea = (BaseImplementation.b) jx.b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void d(DataHolder dataHolder) {
            this.Ea.b(new LoadEventResultImpl(dataHolder));
        }
    }

    private static final class ExtendedGamesLoadedBinderCallback extends AbstractGamesCallbacks {
        private final BaseImplementation.b<LoadExtendedGamesResult> Ea;

        ExtendedGamesLoadedBinderCallback(BaseImplementation.b<LoadExtendedGamesResult> holder) {
            this.Ea = (BaseImplementation.b) jx.b((Object) holder, (Object) "Holder must not be null");
        }

        public void j(DataHolder dataHolder) {
            this.Ea.b(new LoadExtendedGamesResultImpl(dataHolder));
        }
    }

    private class GameClientEventIncrementCache extends EventIncrementCache {
        final /* synthetic */ GamesClientImpl Yu;

        public GameClientEventIncrementCache(GamesClientImpl gamesClientImpl) {
            this.Yu = gamesClientImpl;
            super(gamesClientImpl.getContext().getMainLooper(), 1000);
        }

        protected void r(String str, int i) {
            try {
                if (this.Yu.isConnected()) {
                    ((IGamesService) this.Yu.hw()).o(str, i);
                } else {
                    GamesLog.p("GamesClientImpl", "Unable to increment event " + str + " by " + i + " because the games client is no longer connected");
                }
            } catch (RemoteException e) {
                GamesLog.o("GamesClientImpl", "service died");
            }
        }
    }

    private static final class GameInstancesLoadedBinderCallback extends AbstractGamesCallbacks {
        private final BaseImplementation.b<LoadGameInstancesResult> Ea;

        GameInstancesLoadedBinderCallback(BaseImplementation.b<LoadGameInstancesResult> holder) {
            this.Ea = (BaseImplementation.b) jx.b((Object) holder, (Object) "Holder must not be null");
        }

        public void k(DataHolder dataHolder) {
            this.Ea.b(new LoadGameInstancesResultImpl(dataHolder));
        }
    }

    private static final class GameMuteStatusChangeResultImpl implements GameMuteStatusChangeResult {
        private final Status Eb;
        private final String YC;
        private final boolean YD;

        public GameMuteStatusChangeResultImpl(int statusCode, String externalGameId, boolean isMuted) {
            this.Eb = new Status(statusCode);
            this.YC = externalGameId;
            this.YD = isMuted;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    private static final class GameMuteStatusChangedBinderCallback extends AbstractGamesCallbacks {
        private final BaseImplementation.b<GameMuteStatusChangeResult> Ea;

        GameMuteStatusChangedBinderCallback(BaseImplementation.b<GameMuteStatusChangeResult> holder) {
            this.Ea = (BaseImplementation.b) jx.b((Object) holder, (Object) "Holder must not be null");
        }

        public void a(int i, String str, boolean z) {
            this.Ea.b(new GameMuteStatusChangeResultImpl(i, str, z));
        }
    }

    private static final class GameMuteStatusLoadResultImpl implements GameMuteStatusLoadResult {
        private final Status Eb;
        private final String YC;
        private final boolean YD;

        public GameMuteStatusLoadResultImpl(DataHolder dataHolder) {
            try {
                this.Eb = new Status(dataHolder.getStatusCode());
                if (dataHolder.getCount() > 0) {
                    this.YC = dataHolder.c("external_game_id", 0, 0);
                    this.YD = dataHolder.d("muted", 0, 0);
                } else {
                    this.YC = null;
                    this.YD = false;
                }
                dataHolder.close();
            } catch (Throwable th) {
                dataHolder.close();
            }
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    private static final class GameMuteStatusLoadedBinderCallback extends AbstractGamesCallbacks {
        private final BaseImplementation.b<GameMuteStatusLoadResult> Ea;

        GameMuteStatusLoadedBinderCallback(BaseImplementation.b<GameMuteStatusLoadResult> holder) {
            this.Ea = (BaseImplementation.b) jx.b((Object) holder, (Object) "Holder must not be null");
        }

        public void B(DataHolder dataHolder) {
            this.Ea.b(new GameMuteStatusLoadResultImpl(dataHolder));
        }
    }

    private static final class GameSearchSuggestionsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final BaseImplementation.b<LoadGameSearchSuggestionsResult> Ea;

        GameSearchSuggestionsLoadedBinderCallback(BaseImplementation.b<LoadGameSearchSuggestionsResult> holder) {
            this.Ea = (BaseImplementation.b) jx.b((Object) holder, (Object) "Holder must not be null");
        }

        public void l(DataHolder dataHolder) {
            this.Ea.b(new LoadGameSearchSuggestionsResultImpl(dataHolder));
        }
    }

    private static final class GamesLoadedBinderCallback extends AbstractGamesCallbacks {
        private final BaseImplementation.b<LoadGamesResult> Ea;

        GamesLoadedBinderCallback(BaseImplementation.b<LoadGamesResult> holder) {
            this.Ea = (BaseImplementation.b) jx.b((Object) holder, (Object) "Holder must not be null");
        }

        public void i(DataHolder dataHolder) {
            this.Ea.b(new LoadGamesResultImpl(dataHolder));
        }
    }

    private static final class InboxCountResultImpl implements InboxCountResult {
        private final Status Eb;
        private final Bundle YE;

        InboxCountResultImpl(Status status, Bundle inboxCounts) {
            this.Eb = status;
            this.YE = inboxCounts;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    private static final class InboxCountsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final BaseImplementation.b<InboxCountResult> Ea;

        InboxCountsLoadedBinderCallback(BaseImplementation.b<InboxCountResult> holder) {
            this.Ea = (BaseImplementation.b) jx.b((Object) holder, (Object) "Holder must not be null");
        }

        public void f(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.Ea.b(new InboxCountResultImpl(new Status(i), bundle));
        }
    }

    private static abstract class TurnBasedMatchResult extends b {
        final TurnBasedMatch Zc;

        TurnBasedMatchResult(DataHolder dataHolder) {
            super(dataHolder);
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            try {
                if (turnBasedMatchBuffer.getCount() > 0) {
                    this.Zc = (TurnBasedMatch) ((TurnBasedMatch) turnBasedMatchBuffer.get(0)).freeze();
                } else {
                    this.Zc = null;
                }
                turnBasedMatchBuffer.release();
            } catch (Throwable th) {
                turnBasedMatchBuffer.release();
            }
        }

        public TurnBasedMatch getMatch() {
            return this.Zc;
        }
    }

    private static final class InitiateMatchResultImpl extends TurnBasedMatchResult implements InitiateMatchResult {
        InitiateMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class InvitationReceivedBinderCallback extends AbstractGamesCallbacks {
        private final d<OnInvitationReceivedListener> Qe;

        InvitationReceivedBinderCallback(d<OnInvitationReceivedListener> listener) {
            this.Qe = listener;
        }

        public void n(DataHolder dataHolder) {
            InvitationBuffer invitationBuffer = new InvitationBuffer(dataHolder);
            Invitation invitation = null;
            try {
                if (invitationBuffer.getCount() > 0) {
                    invitation = (Invitation) ((Invitation) invitationBuffer.get(0)).freeze();
                }
                invitationBuffer.release();
                if (invitation != null) {
                    this.Qe.a(new InvitationReceivedNotifier(invitation));
                }
            } catch (Throwable th) {
                invitationBuffer.release();
            }
        }

        public void onInvitationRemoved(String invitationId) {
            this.Qe.a(new InvitationRemovedNotifier(invitationId));
        }
    }

    private static final class InvitationReceivedNotifier implements d.b<OnInvitationReceivedListener> {
        private final Invitation YF;

        InvitationReceivedNotifier(Invitation invitation) {
            this.YF = invitation;
        }

        public void a(OnInvitationReceivedListener onInvitationReceivedListener) {
            onInvitationReceivedListener.onInvitationReceived(this.YF);
        }

        public /* synthetic */ void c(Object obj) {
            a((OnInvitationReceivedListener) obj);
        }

        public void gG() {
        }
    }

    private static final class InvitationRemovedNotifier implements d.b<OnInvitationReceivedListener> {
        private final String YG;

        InvitationRemovedNotifier(String invitationId) {
            this.YG = invitationId;
        }

        public void a(OnInvitationReceivedListener onInvitationReceivedListener) {
            onInvitationReceivedListener.onInvitationRemoved(this.YG);
        }

        public /* synthetic */ void c(Object obj) {
            a((OnInvitationReceivedListener) obj);
        }

        public void gG() {
        }
    }

    private static final class InvitationsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final BaseImplementation.b<LoadInvitationsResult> Ea;

        InvitationsLoadedBinderCallback(BaseImplementation.b<LoadInvitationsResult> resultHolder) {
            this.Ea = (BaseImplementation.b) jx.b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void m(DataHolder dataHolder) {
            this.Ea.b(new LoadInvitationsResultImpl(dataHolder));
        }
    }

    private static final class JoinedRoomNotifier extends AbstractRoomNotifier {
        public JoinedRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void a(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onJoinedRoom(i, room);
        }
    }

    private static final class LeaderboardMetadataResultImpl extends b implements LeaderboardMetadataResult {
        private final LeaderboardBuffer YH;

        LeaderboardMetadataResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.YH = new LeaderboardBuffer(dataHolder);
        }

        public LeaderboardBuffer getLeaderboards() {
            return this.YH;
        }
    }

    private static final class LeaderboardScoresLoadedBinderCallback extends AbstractGamesCallbacks {
        private final BaseImplementation.b<LoadScoresResult> Ea;

        LeaderboardScoresLoadedBinderCallback(BaseImplementation.b<LoadScoresResult> resultHolder) {
            this.Ea = (BaseImplementation.b) jx.b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void a(DataHolder dataHolder, DataHolder dataHolder2) {
            this.Ea.b(new LoadScoresResultImpl(dataHolder, dataHolder2));
        }
    }

    private static final class LeaderboardsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final BaseImplementation.b<LeaderboardMetadataResult> Ea;

        LeaderboardsLoadedBinderCallback(BaseImplementation.b<LeaderboardMetadataResult> resultHolder) {
            this.Ea = (BaseImplementation.b) jx.b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void e(DataHolder dataHolder) {
            this.Ea.b(new LeaderboardMetadataResultImpl(dataHolder));
        }
    }

    private static final class LeaveMatchResultImpl extends TurnBasedMatchResult implements LeaveMatchResult {
        LeaveMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LeftRoomNotifier implements d.b<RoomUpdateListener> {
        private final int Iv;
        private final String YI;

        LeftRoomNotifier(int statusCode, String roomId) {
            this.Iv = statusCode;
            this.YI = roomId;
        }

        public void a(RoomUpdateListener roomUpdateListener) {
            roomUpdateListener.onLeftRoom(this.Iv, this.YI);
        }

        public /* synthetic */ void c(Object obj) {
            a((RoomUpdateListener) obj);
        }

        public void gG() {
        }
    }

    private static final class LoadAchievementsResultImpl extends b implements LoadAchievementsResult {
        private final AchievementBuffer YJ;

        LoadAchievementsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.YJ = new AchievementBuffer(dataHolder);
        }

        public AchievementBuffer getAchievements() {
            return this.YJ;
        }
    }

    private static final class LoadAclResultImpl extends b implements LoadAclResult {
        LoadAclResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LoadAppContentsResultImpl extends b implements LoadAppContentResult {
        private final ArrayList<DataHolder> YK;

        LoadAppContentsResultImpl(DataHolder[] appContentData) {
            super(appContentData[0]);
            this.YK = new ArrayList(Arrays.asList(appContentData));
        }
    }

    private static final class LoadEventResultImpl extends b implements LoadEventsResult {
        private final EventBuffer YL;

        LoadEventResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.YL = new EventBuffer(dataHolder);
        }

        public EventBuffer getEvents() {
            return this.YL;
        }
    }

    private static final class LoadExtendedGamesResultImpl extends b implements LoadExtendedGamesResult {
        private final ExtendedGameBuffer YM;

        LoadExtendedGamesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.YM = new ExtendedGameBuffer(dataHolder);
        }
    }

    private static final class LoadGameInstancesResultImpl extends b implements LoadGameInstancesResult {
        private final GameInstanceBuffer YN;

        LoadGameInstancesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.YN = new GameInstanceBuffer(dataHolder);
        }
    }

    private static final class LoadGameSearchSuggestionsResultImpl extends b implements LoadGameSearchSuggestionsResult {
        private final GameSearchSuggestionBuffer YO;

        LoadGameSearchSuggestionsResultImpl(DataHolder data) {
            super(data);
            this.YO = new GameSearchSuggestionBuffer(data);
        }
    }

    private static final class LoadGamesResultImpl extends b implements LoadGamesResult {
        private final GameBuffer YP;

        LoadGamesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.YP = new GameBuffer(dataHolder);
        }

        public GameBuffer getGames() {
            return this.YP;
        }
    }

    private static final class LoadInvitationsResultImpl extends b implements LoadInvitationsResult {
        private final InvitationBuffer YQ;

        LoadInvitationsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.YQ = new InvitationBuffer(dataHolder);
        }

        public InvitationBuffer getInvitations() {
            return this.YQ;
        }
    }

    private static final class LoadMatchResultImpl extends TurnBasedMatchResult implements LoadMatchResult {
        LoadMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LoadMatchesResultImpl implements LoadMatchesResult {
        private final Status Eb;
        private final LoadMatchesResponse YR;

        LoadMatchesResultImpl(Status status, Bundle matchData) {
            this.Eb = status;
            this.YR = new LoadMatchesResponse(matchData);
        }

        public LoadMatchesResponse getMatches() {
            return this.YR;
        }

        public Status getStatus() {
            return this.Eb;
        }

        public void release() {
            this.YR.release();
        }
    }

    private static final class LoadOwnerCoverPhotoUrisResultImpl implements LoadOwnerCoverPhotoUrisResult {
        private final Bundle DJ;
        private final Status Eb;

        LoadOwnerCoverPhotoUrisResultImpl(int statusCode, Bundle bundle) {
            this.Eb = new Status(statusCode);
            this.DJ = bundle;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    private static final class LoadPlayerScoreResultImpl extends b implements LoadPlayerScoreResult {
        private final LeaderboardScoreEntity YS;

        LoadPlayerScoreResultImpl(DataHolder scoreHolder) {
            super(scoreHolder);
            LeaderboardScoreBuffer leaderboardScoreBuffer = new LeaderboardScoreBuffer(scoreHolder);
            try {
                if (leaderboardScoreBuffer.getCount() > 0) {
                    this.YS = (LeaderboardScoreEntity) leaderboardScoreBuffer.get(0).freeze();
                } else {
                    this.YS = null;
                }
                leaderboardScoreBuffer.release();
            } catch (Throwable th) {
                leaderboardScoreBuffer.release();
            }
        }

        public LeaderboardScore getScore() {
            return this.YS;
        }
    }

    private static final class LoadPlayersResultImpl extends b implements LoadPlayersResult {
        private final PlayerBuffer YT;

        LoadPlayersResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.YT = new PlayerBuffer(dataHolder);
        }

        public PlayerBuffer getPlayers() {
            return this.YT;
        }
    }

    private static final class LoadProfileSettingsResultImpl extends b implements LoadProfileSettingsResult {
        private final boolean YU;
        private final boolean Yh;

        LoadProfileSettingsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            try {
                if (dataHolder.getCount() > 0) {
                    int au = dataHolder.au(0);
                    this.Yh = dataHolder.d("profile_visible", 0, au);
                    this.YU = dataHolder.d("profile_visibility_explicitly_set", 0, au);
                } else {
                    this.Yh = true;
                    this.YU = false;
                }
                dataHolder.close();
            } catch (Throwable th) {
                dataHolder.close();
            }
        }

        public Status getStatus() {
            return this.Eb;
        }

        public boolean isProfileVisible() {
            return this.Yh;
        }

        public boolean isVisibilityExplicitlySet() {
            return this.YU;
        }
    }

    private static final class LoadQuestsResultImpl extends b implements LoadQuestsResult {
        private final DataHolder JG;

        LoadQuestsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.JG = dataHolder;
        }

        public QuestBuffer getQuests() {
            return new QuestBuffer(this.JG);
        }
    }

    private static final class LoadRequestSummariesResultImpl extends b implements LoadRequestSummariesResult {
        LoadRequestSummariesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LoadRequestsResultImpl implements LoadRequestsResult {
        private final Status Eb;
        private final Bundle YV;

        LoadRequestsResultImpl(Status status, Bundle requestData) {
            this.Eb = status;
            this.YV = requestData;
        }

        public GameRequestBuffer getRequests(int requestType) {
            String dZ = RequestType.dZ(requestType);
            return !this.YV.containsKey(dZ) ? null : new GameRequestBuffer((DataHolder) this.YV.get(dZ));
        }

        public Status getStatus() {
            return this.Eb;
        }

        public void release() {
            for (String parcelable : this.YV.keySet()) {
                DataHolder dataHolder = (DataHolder) this.YV.getParcelable(parcelable);
                if (dataHolder != null) {
                    dataHolder.close();
                }
            }
        }
    }

    private static final class LoadScoresResultImpl extends b implements LoadScoresResult {
        private final LeaderboardEntity YW;
        private final LeaderboardScoreBuffer YX;

        LoadScoresResultImpl(DataHolder leaderboard, DataHolder scores) {
            super(scores);
            LeaderboardBuffer leaderboardBuffer = new LeaderboardBuffer(leaderboard);
            try {
                if (leaderboardBuffer.getCount() > 0) {
                    this.YW = (LeaderboardEntity) ((Leaderboard) leaderboardBuffer.get(0)).freeze();
                } else {
                    this.YW = null;
                }
                leaderboardBuffer.release();
                this.YX = new LeaderboardScoreBuffer(scores);
            } catch (Throwable th) {
                leaderboardBuffer.release();
            }
        }

        public Leaderboard getLeaderboard() {
            return this.YW;
        }

        public LeaderboardScoreBuffer getScores() {
            return this.YX;
        }
    }

    private static final class LoadSnapshotsResultImpl extends b implements LoadSnapshotsResult {
        LoadSnapshotsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }

        public SnapshotMetadataBuffer getSnapshots() {
            return new SnapshotMetadataBuffer(this.JG);
        }
    }

    private static final class LoadXpForGameCategoriesResultImpl implements LoadXpForGameCategoriesResult {
        private final Status Eb;
        private final List<String> YY;
        private final Bundle YZ;

        LoadXpForGameCategoriesResultImpl(Status status, Bundle xpData) {
            this.Eb = status;
            this.YY = xpData.getStringArrayList("game_category_list");
            this.YZ = xpData;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    private static final class LoadXpStreamResultImpl extends b implements LoadXpStreamResult {
        private final ExperienceEventBuffer Za;

        LoadXpStreamResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.Za = new ExperienceEventBuffer(dataHolder);
        }
    }

    private static final class MatchRemovedNotifier implements d.b<OnTurnBasedMatchUpdateReceivedListener> {
        private final String Zb;

        MatchRemovedNotifier(String matchId) {
            this.Zb = matchId;
        }

        public void a(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
            onTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchRemoved(this.Zb);
        }

        public /* synthetic */ void c(Object obj) {
            a((OnTurnBasedMatchUpdateReceivedListener) obj);
        }

        public void gG() {
        }
    }

    private static final class MatchUpdateReceivedBinderCallback extends AbstractGamesCallbacks {
        private final d<OnTurnBasedMatchUpdateReceivedListener> Qe;

        MatchUpdateReceivedBinderCallback(d<OnTurnBasedMatchUpdateReceivedListener> listener) {
            this.Qe = listener;
        }

        public void onTurnBasedMatchRemoved(String matchId) {
            this.Qe.a(new MatchRemovedNotifier(matchId));
        }

        public void t(DataHolder dataHolder) {
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            TurnBasedMatch turnBasedMatch = null;
            try {
                if (turnBasedMatchBuffer.getCount() > 0) {
                    turnBasedMatch = (TurnBasedMatch) ((TurnBasedMatch) turnBasedMatchBuffer.get(0)).freeze();
                }
                turnBasedMatchBuffer.release();
                if (turnBasedMatch != null) {
                    this.Qe.a(new MatchUpdateReceivedNotifier(turnBasedMatch));
                }
            } catch (Throwable th) {
                turnBasedMatchBuffer.release();
            }
        }
    }

    private static final class MatchUpdateReceivedNotifier implements d.b<OnTurnBasedMatchUpdateReceivedListener> {
        private final TurnBasedMatch Zc;

        MatchUpdateReceivedNotifier(TurnBasedMatch match) {
            this.Zc = match;
        }

        public void a(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
            onTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchReceived(this.Zc);
        }

        public /* synthetic */ void c(Object obj) {
            a((OnTurnBasedMatchUpdateReceivedListener) obj);
        }

        public void gG() {
        }
    }

    private static final class MessageReceivedNotifier implements d.b<RealTimeMessageReceivedListener> {
        private final RealTimeMessage Zd;

        MessageReceivedNotifier(RealTimeMessage message) {
            this.Zd = message;
        }

        public void a(RealTimeMessageReceivedListener realTimeMessageReceivedListener) {
            realTimeMessageReceivedListener.onRealTimeMessageReceived(this.Zd);
        }

        public /* synthetic */ void c(Object obj) {
            a((RealTimeMessageReceivedListener) obj);
        }

        public void gG() {
        }
    }

    private static final class NearbyPlayerDetectedNotifier implements d.b<OnNearbyPlayerDetectedListener> {
        private final Player Ze;

        public void a(OnNearbyPlayerDetectedListener onNearbyPlayerDetectedListener) {
            onNearbyPlayerDetectedListener.a(this.Ze);
        }

        public /* synthetic */ void c(Object obj) {
            a((OnNearbyPlayerDetectedListener) obj);
        }

        public void gG() {
        }
    }

    private static final class NotifyAclLoadedBinderCallback extends AbstractGamesCallbacks {
        private final BaseImplementation.b<LoadAclResult> Ea;

        NotifyAclLoadedBinderCallback(BaseImplementation.b<LoadAclResult> resultHolder) {
            this.Ea = (BaseImplementation.b) jx.b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void C(DataHolder dataHolder) {
            this.Ea.b(new LoadAclResultImpl(dataHolder));
        }
    }

    private static final class NotifyAclUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final BaseImplementation.b<Status> Ea;

        NotifyAclUpdatedBinderCallback(BaseImplementation.b<Status> resultHolder) {
            this.Ea = (BaseImplementation.b) jx.b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void dO(int i) {
            this.Ea.b(new Status(i));
        }
    }

    private static final class OpenSnapshotResultImpl extends b implements OpenSnapshotResult {
        private final Snapshot Zf;
        private final String Zg;
        private final Snapshot Zh;
        private final Contents Zi;
        private final SnapshotContents Zj;

        OpenSnapshotResultImpl(DataHolder dataHolder, Contents currentContents) {
            this(dataHolder, null, currentContents, null, null);
        }

        OpenSnapshotResultImpl(DataHolder metadataHolder, String conflictId, Contents currentContents, Contents conflictContents, Contents resolutionContents) {
            boolean z = true;
            super(metadataHolder);
            SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(metadataHolder);
            try {
                if (snapshotMetadataBuffer.getCount() == 0) {
                    this.Zf = null;
                    this.Zh = null;
                } else if (snapshotMetadataBuffer.getCount() == 1) {
                    if (metadataHolder.getStatusCode() == 4004) {
                        z = false;
                    }
                    je.K(z);
                    this.Zf = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0)), new SnapshotContentsEntity(currentContents));
                    this.Zh = null;
                } else {
                    this.Zf = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0)), new SnapshotContentsEntity(currentContents));
                    this.Zh = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(1)), new SnapshotContentsEntity(conflictContents));
                }
                snapshotMetadataBuffer.release();
                this.Zg = conflictId;
                this.Zi = resolutionContents;
                this.Zj = new SnapshotContentsEntity(resolutionContents);
            } catch (Throwable th) {
                snapshotMetadataBuffer.release();
            }
        }

        public String getConflictId() {
            return this.Zg;
        }

        public Snapshot getConflictingSnapshot() {
            return this.Zh;
        }

        public SnapshotContents getResolutionSnapshotContents() {
            return this.Zj;
        }

        public Snapshot getSnapshot() {
            return this.Zf;
        }
    }

    private static final class OwnerCoverPhotoUrisLoadedBinderCallback extends AbstractGamesCallbacks {
        private final BaseImplementation.b<LoadOwnerCoverPhotoUrisResult> Ea;

        OwnerCoverPhotoUrisLoadedBinderCallback(BaseImplementation.b<LoadOwnerCoverPhotoUrisResult> holder) {
            this.Ea = (BaseImplementation.b) jx.b((Object) holder, (Object) "Holder must not be null");
        }

        public void d(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.Ea.b(new LoadOwnerCoverPhotoUrisResultImpl(i, bundle));
        }
    }

    private static final class P2PConnectedNotifier implements d.b<RoomStatusUpdateListener> {
        private final String Zk;

        P2PConnectedNotifier(String participantId) {
            this.Zk = participantId;
        }

        public void a(RoomStatusUpdateListener roomStatusUpdateListener) {
            roomStatusUpdateListener.onP2PConnected(this.Zk);
        }

        public /* synthetic */ void c(Object obj) {
            a((RoomStatusUpdateListener) obj);
        }

        public void gG() {
        }
    }

    private static final class P2PDisconnectedNotifier implements d.b<RoomStatusUpdateListener> {
        private final String Zk;

        P2PDisconnectedNotifier(String participantId) {
            this.Zk = participantId;
        }

        public void a(RoomStatusUpdateListener roomStatusUpdateListener) {
            roomStatusUpdateListener.onP2PDisconnected(this.Zk);
        }

        public /* synthetic */ void c(Object obj) {
            a((RoomStatusUpdateListener) obj);
        }

        public void gG() {
        }
    }

    private static final class PeerConnectedNotifier extends AbstractPeerStatusNotifier {
        PeerConnectedNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        protected void a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeersConnected(room, arrayList);
        }
    }

    private static final class PeerDeclinedNotifier extends AbstractPeerStatusNotifier {
        PeerDeclinedNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        protected void a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerDeclined(room, arrayList);
        }
    }

    private static final class PeerDisconnectedNotifier extends AbstractPeerStatusNotifier {
        PeerDisconnectedNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        protected void a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeersDisconnected(room, arrayList);
        }
    }

    private static final class PeerInvitedToRoomNotifier extends AbstractPeerStatusNotifier {
        PeerInvitedToRoomNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        protected void a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerInvitedToRoom(room, arrayList);
        }
    }

    private static final class PeerJoinedRoomNotifier extends AbstractPeerStatusNotifier {
        PeerJoinedRoomNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        protected void a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerJoined(room, arrayList);
        }
    }

    private static final class PeerLeftRoomNotifier extends AbstractPeerStatusNotifier {
        PeerLeftRoomNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        protected void a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerLeft(room, arrayList);
        }
    }

    private static final class PlayerLeaderboardScoreLoadedBinderCallback extends AbstractGamesCallbacks {
        private final BaseImplementation.b<LoadPlayerScoreResult> Ea;

        PlayerLeaderboardScoreLoadedBinderCallback(BaseImplementation.b<LoadPlayerScoreResult> resultHolder) {
            this.Ea = (BaseImplementation.b) jx.b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void E(DataHolder dataHolder) {
            this.Ea.b(new LoadPlayerScoreResultImpl(dataHolder));
        }
    }

    private static final class PlayerXpForGameCategoriesLoadedBinderCallback extends AbstractGamesCallbacks {
        private final BaseImplementation.b<LoadXpForGameCategoriesResult> Ea;

        PlayerXpForGameCategoriesLoadedBinderCallback(BaseImplementation.b<LoadXpForGameCategoriesResult> holder) {
            this.Ea = (BaseImplementation.b) jx.b((Object) holder, (Object) "Holder must not be null");
        }

        public void e(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.Ea.b(new LoadXpForGameCategoriesResultImpl(new Status(i), bundle));
        }
    }

    static final class PlayerXpStreamLoadedBinderCallback extends AbstractGamesCallbacks {
        private final BaseImplementation.b<LoadXpStreamResult> Ea;

        PlayerXpStreamLoadedBinderCallback(BaseImplementation.b<LoadXpStreamResult> holder) {
            this.Ea = (BaseImplementation.b) jx.b((Object) holder, (Object) "Holder must not be null");
        }

        public void P(DataHolder dataHolder) {
            this.Ea.b(new LoadXpStreamResultImpl(dataHolder));
        }
    }

    private static final class PlayersLoadedBinderCallback extends AbstractGamesCallbacks {
        private final BaseImplementation.b<LoadPlayersResult> Ea;

        PlayersLoadedBinderCallback(BaseImplementation.b<LoadPlayersResult> holder) {
            this.Ea = (BaseImplementation.b) jx.b((Object) holder, (Object) "Holder must not be null");
        }

        public void g(DataHolder dataHolder) {
            this.Ea.b(new LoadPlayersResultImpl(dataHolder));
        }

        public void h(DataHolder dataHolder) {
            this.Ea.b(new LoadPlayersResultImpl(dataHolder));
        }
    }

    static final class ProfileSettingsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final BaseImplementation.b<LoadProfileSettingsResult> Ea;

        ProfileSettingsLoadedBinderCallback(BaseImplementation.b<LoadProfileSettingsResult> holder) {
            this.Ea = (BaseImplementation.b) jx.b((Object) holder, (Object) "Holder must not be null");
        }

        public void Q(DataHolder dataHolder) {
            this.Ea.b(new LoadProfileSettingsResultImpl(dataHolder));
        }
    }

    private static final class ProfileSettingsUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final BaseImplementation.b<Status> Ea;

        ProfileSettingsUpdatedBinderCallback(BaseImplementation.b<Status> holder) {
            this.Ea = (BaseImplementation.b) jx.b((Object) holder, (Object) "Holder must not be null");
        }

        public void dQ(int i) {
            this.Ea.b(new Status(i));
        }
    }

    private static final class QuestAcceptedBinderCallbacks extends AbstractGamesCallbacks {
        private final BaseImplementation.b<AcceptQuestResult> Zl;

        public QuestAcceptedBinderCallbacks(BaseImplementation.b<AcceptQuestResult> resultHolder) {
            this.Zl = (BaseImplementation.b) jx.b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void L(DataHolder dataHolder) {
            this.Zl.b(new AcceptQuestResultImpl(dataHolder));
        }
    }

    private static final class QuestCompletedNotifier implements d.b<QuestUpdateListener> {
        private final Quest Yw;

        QuestCompletedNotifier(Quest quest) {
            this.Yw = quest;
        }

        public void a(QuestUpdateListener questUpdateListener) {
            questUpdateListener.onQuestCompleted(this.Yw);
        }

        public /* synthetic */ void c(Object obj) {
            a((QuestUpdateListener) obj);
        }

        public void gG() {
        }
    }

    private static final class QuestMilestoneClaimBinderCallbacks extends AbstractGamesCallbacks {
        private final BaseImplementation.b<ClaimMilestoneResult> Zm;
        private final String Zn;

        public QuestMilestoneClaimBinderCallbacks(BaseImplementation.b<ClaimMilestoneResult> resultHolder, String milestoneId) {
            this.Zm = (BaseImplementation.b) jx.b((Object) resultHolder, (Object) "Holder must not be null");
            this.Zn = (String) jx.b((Object) milestoneId, (Object) "MilestoneId must not be null");
        }

        public void K(DataHolder dataHolder) {
            this.Zm.b(new ClaimMilestoneResultImpl(dataHolder, this.Zn));
        }
    }

    private static final class QuestUpdateBinderCallback extends AbstractGamesCallbacks {
        private final d<QuestUpdateListener> Qe;

        QuestUpdateBinderCallback(d<QuestUpdateListener> listener) {
            this.Qe = listener;
        }

        private Quest T(DataHolder dataHolder) {
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            Quest quest = null;
            try {
                if (questBuffer.getCount() > 0) {
                    quest = (Quest) ((Quest) questBuffer.get(0)).freeze();
                }
                questBuffer.release();
                return quest;
            } catch (Throwable th) {
                questBuffer.release();
            }
        }

        public void M(DataHolder dataHolder) {
            Quest T = T(dataHolder);
            if (T != null) {
                this.Qe.a(new QuestCompletedNotifier(T));
            }
        }
    }

    private static final class QuestsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final BaseImplementation.b<LoadQuestsResult> Zo;

        public QuestsLoadedBinderCallbacks(BaseImplementation.b<LoadQuestsResult> resultHolder) {
            this.Zo = (BaseImplementation.b) jx.b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void O(DataHolder dataHolder) {
            this.Zo.b(new LoadQuestsResultImpl(dataHolder));
        }
    }

    private static final class RealTimeMessageSentNotifier implements d.b<ReliableMessageSentCallback> {
        private final int Iv;
        private final String Zp;
        private final int Zq;

        RealTimeMessageSentNotifier(int statusCode, int token, String recipientParticipantId) {
            this.Iv = statusCode;
            this.Zq = token;
            this.Zp = recipientParticipantId;
        }

        public void a(ReliableMessageSentCallback reliableMessageSentCallback) {
            if (reliableMessageSentCallback != null) {
                reliableMessageSentCallback.onRealTimeMessageSent(this.Iv, this.Zq, this.Zp);
            }
        }

        public /* synthetic */ void c(Object obj) {
            a((ReliableMessageSentCallback) obj);
        }

        public void gG() {
        }
    }

    private static final class RealTimeReliableMessageBinderCallbacks extends AbstractGamesCallbacks {
        final d<ReliableMessageSentCallback> Zr;

        public RealTimeReliableMessageBinderCallbacks(d<ReliableMessageSentCallback> messageSentCallbacks) {
            this.Zr = messageSentCallbacks;
        }

        public void b(int i, int i2, String str) {
            if (this.Zr != null) {
                this.Zr.a(new RealTimeMessageSentNotifier(i, i2, str));
            }
        }
    }

    private static final class RequestReceivedBinderCallback extends AbstractGamesCallbacks {
        private final d<OnRequestReceivedListener> Qe;

        RequestReceivedBinderCallback(d<OnRequestReceivedListener> listener) {
            this.Qe = listener;
        }

        public void o(DataHolder dataHolder) {
            GameRequestBuffer gameRequestBuffer = new GameRequestBuffer(dataHolder);
            GameRequest gameRequest = null;
            try {
                if (gameRequestBuffer.getCount() > 0) {
                    gameRequest = (GameRequest) ((GameRequest) gameRequestBuffer.get(0)).freeze();
                }
                gameRequestBuffer.release();
                if (gameRequest != null) {
                    this.Qe.a(new RequestReceivedNotifier(gameRequest));
                }
            } catch (Throwable th) {
                gameRequestBuffer.release();
            }
        }

        public void onRequestRemoved(String requestId) {
            this.Qe.a(new RequestRemovedNotifier(requestId));
        }
    }

    private static final class RequestReceivedNotifier implements d.b<OnRequestReceivedListener> {
        private final GameRequest Zs;

        RequestReceivedNotifier(GameRequest request) {
            this.Zs = request;
        }

        public void a(OnRequestReceivedListener onRequestReceivedListener) {
            onRequestReceivedListener.onRequestReceived(this.Zs);
        }

        public /* synthetic */ void c(Object obj) {
            a((OnRequestReceivedListener) obj);
        }

        public void gG() {
        }
    }

    private static final class RequestRemovedNotifier implements d.b<OnRequestReceivedListener> {
        private final String Zt;

        RequestRemovedNotifier(String requestId) {
            this.Zt = requestId;
        }

        public void a(OnRequestReceivedListener onRequestReceivedListener) {
            onRequestReceivedListener.onRequestRemoved(this.Zt);
        }

        public /* synthetic */ void c(Object obj) {
            a((OnRequestReceivedListener) obj);
        }

        public void gG() {
        }
    }

    private static final class RequestSentBinderCallbacks extends AbstractGamesCallbacks {
        private final BaseImplementation.b<SendRequestResult> Zu;

        public RequestSentBinderCallbacks(BaseImplementation.b<SendRequestResult> resultHolder) {
            this.Zu = (BaseImplementation.b) jx.b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void G(DataHolder dataHolder) {
            this.Zu.b(new SendRequestResultImpl(dataHolder));
        }
    }

    private static final class RequestSummariesLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final BaseImplementation.b<LoadRequestSummariesResult> Zv;

        public RequestSummariesLoadedBinderCallbacks(BaseImplementation.b<LoadRequestSummariesResult> resultHolder) {
            this.Zv = (BaseImplementation.b) jx.b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void H(DataHolder dataHolder) {
            this.Zv.b(new LoadRequestSummariesResultImpl(dataHolder));
        }
    }

    private static final class RequestsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final BaseImplementation.b<LoadRequestsResult> Zw;

        public RequestsLoadedBinderCallbacks(BaseImplementation.b<LoadRequestsResult> resultHolder) {
            this.Zw = (BaseImplementation.b) jx.b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void c(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.Zw.b(new LoadRequestsResultImpl(new Status(i), bundle));
        }
    }

    private static final class RequestsUpdatedBinderCallbacks extends AbstractGamesCallbacks {
        private final BaseImplementation.b<UpdateRequestsResult> Zx;

        public RequestsUpdatedBinderCallbacks(BaseImplementation.b<UpdateRequestsResult> resultHolder) {
            this.Zx = (BaseImplementation.b) jx.b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void F(DataHolder dataHolder) {
            this.Zx.b(new UpdateRequestsResultImpl(dataHolder));
        }
    }

    private static final class RoomAutoMatchingNotifier extends AbstractRoomStatusNotifier {
        RoomAutoMatchingNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomAutoMatching(room);
        }
    }

    private static final class RoomBinderCallbacks extends AbstractGamesCallbacks {
        private final d<RealTimeMessageReceivedListener> ZA;
        private final d<? extends RoomUpdateListener> Zy;
        private final d<? extends RoomStatusUpdateListener> Zz;

        public RoomBinderCallbacks(d<RoomUpdateListener> roomCallbacks) {
            this.Zy = (d) jx.b((Object) roomCallbacks, (Object) "Callbacks must not be null");
            this.Zz = null;
            this.ZA = null;
        }

        public RoomBinderCallbacks(d<? extends RoomUpdateListener> roomCallbacks, d<? extends RoomStatusUpdateListener> roomStatusCallbacks, d<RealTimeMessageReceivedListener> realTimeMessageReceivedCallbacks) {
            this.Zy = (d) jx.b((Object) roomCallbacks, (Object) "Callbacks must not be null");
            this.Zz = roomStatusCallbacks;
            this.ZA = realTimeMessageReceivedCallbacks;
        }

        public void A(DataHolder dataHolder) {
            if (this.Zz != null) {
                this.Zz.a(new DisconnectedFromRoomNotifier(dataHolder));
            }
        }

        public void a(DataHolder dataHolder, String[] strArr) {
            if (this.Zz != null) {
                this.Zz.a(new PeerInvitedToRoomNotifier(dataHolder, strArr));
            }
        }

        public void b(DataHolder dataHolder, String[] strArr) {
            if (this.Zz != null) {
                this.Zz.a(new PeerJoinedRoomNotifier(dataHolder, strArr));
            }
        }

        public void c(DataHolder dataHolder, String[] strArr) {
            if (this.Zz != null) {
                this.Zz.a(new PeerLeftRoomNotifier(dataHolder, strArr));
            }
        }

        public void d(DataHolder dataHolder, String[] strArr) {
            if (this.Zz != null) {
                this.Zz.a(new PeerDeclinedNotifier(dataHolder, strArr));
            }
        }

        public void e(DataHolder dataHolder, String[] strArr) {
            if (this.Zz != null) {
                this.Zz.a(new PeerConnectedNotifier(dataHolder, strArr));
            }
        }

        public void f(DataHolder dataHolder, String[] strArr) {
            if (this.Zz != null) {
                this.Zz.a(new PeerDisconnectedNotifier(dataHolder, strArr));
            }
        }

        public void onLeftRoom(int statusCode, String externalRoomId) {
            this.Zy.a(new LeftRoomNotifier(statusCode, externalRoomId));
        }

        public void onP2PConnected(String participantId) {
            if (this.Zz != null) {
                this.Zz.a(new P2PConnectedNotifier(participantId));
            }
        }

        public void onP2PDisconnected(String participantId) {
            if (this.Zz != null) {
                this.Zz.a(new P2PDisconnectedNotifier(participantId));
            }
        }

        public void onRealTimeMessageReceived(RealTimeMessage message) {
            if (this.ZA != null) {
                this.ZA.a(new MessageReceivedNotifier(message));
            }
        }

        public void u(DataHolder dataHolder) {
            this.Zy.a(new RoomCreatedNotifier(dataHolder));
        }

        public void v(DataHolder dataHolder) {
            this.Zy.a(new JoinedRoomNotifier(dataHolder));
        }

        public void w(DataHolder dataHolder) {
            if (this.Zz != null) {
                this.Zz.a(new RoomConnectingNotifier(dataHolder));
            }
        }

        public void x(DataHolder dataHolder) {
            if (this.Zz != null) {
                this.Zz.a(new RoomAutoMatchingNotifier(dataHolder));
            }
        }

        public void y(DataHolder dataHolder) {
            this.Zy.a(new RoomConnectedNotifier(dataHolder));
        }

        public void z(DataHolder dataHolder) {
            if (this.Zz != null) {
                this.Zz.a(new ConnectedToRoomNotifier(dataHolder));
            }
        }
    }

    private static final class RoomConnectedNotifier extends AbstractRoomNotifier {
        RoomConnectedNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void a(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onRoomConnected(i, room);
        }
    }

    private static final class RoomConnectingNotifier extends AbstractRoomStatusNotifier {
        RoomConnectingNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomConnecting(room);
        }
    }

    private static final class RoomCreatedNotifier extends AbstractRoomNotifier {
        public RoomCreatedNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void a(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onRoomCreated(i, room);
        }
    }

    private static final class SendRequestResultImpl extends b implements SendRequestResult {
        private final GameRequest Zs;

        SendRequestResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            GameRequestBuffer gameRequestBuffer = new GameRequestBuffer(dataHolder);
            try {
                if (gameRequestBuffer.getCount() > 0) {
                    this.Zs = (GameRequest) ((GameRequest) gameRequestBuffer.get(0)).freeze();
                } else {
                    this.Zs = null;
                }
                gameRequestBuffer.release();
            } catch (Throwable th) {
                gameRequestBuffer.release();
            }
        }
    }

    private static final class SignOutCompleteBinderCallbacks extends AbstractGamesCallbacks {
        private final BaseImplementation.b<Status> Ea;

        public SignOutCompleteBinderCallbacks(BaseImplementation.b<Status> resultHolder) {
            this.Ea = (BaseImplementation.b) jx.b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void fK() {
            this.Ea.b(new Status(0));
        }
    }

    private static final class SnapshotCommittedBinderCallbacks extends AbstractGamesCallbacks {
        private final BaseImplementation.b<CommitSnapshotResult> ZB;

        public SnapshotCommittedBinderCallbacks(BaseImplementation.b<CommitSnapshotResult> resultHolder) {
            this.ZB = (BaseImplementation.b) jx.b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void J(DataHolder dataHolder) {
            this.ZB.b(new CommitSnapshotResultImpl(dataHolder));
        }
    }

    static final class SnapshotDeletedBinderCallbacks extends AbstractGamesCallbacks {
        private final BaseImplementation.b<DeleteSnapshotResult> Ea;

        public SnapshotDeletedBinderCallbacks(BaseImplementation.b<DeleteSnapshotResult> resultHolder) {
            this.Ea = (BaseImplementation.b) jx.b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void i(int i, String str) {
            this.Ea.b(new DeleteSnapshotResultImpl(i, str));
        }
    }

    private static final class SnapshotOpenedBinderCallbacks extends AbstractGamesCallbacks {
        private final BaseImplementation.b<OpenSnapshotResult> ZC;

        public SnapshotOpenedBinderCallbacks(BaseImplementation.b<OpenSnapshotResult> resultHolder) {
            this.ZC = (BaseImplementation.b) jx.b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void a(DataHolder dataHolder, Contents contents) {
            this.ZC.b(new OpenSnapshotResultImpl(dataHolder, contents));
        }

        public void a(DataHolder dataHolder, String str, Contents contents, Contents contents2, Contents contents3) {
            this.ZC.b(new OpenSnapshotResultImpl(dataHolder, str, contents, contents2, contents3));
        }
    }

    private static final class SnapshotsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final BaseImplementation.b<LoadSnapshotsResult> ZD;

        public SnapshotsLoadedBinderCallbacks(BaseImplementation.b<LoadSnapshotsResult> resultHolder) {
            this.ZD = (BaseImplementation.b) jx.b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void I(DataHolder dataHolder) {
            this.ZD.b(new LoadSnapshotsResultImpl(dataHolder));
        }
    }

    private static final class SubmitScoreBinderCallbacks extends AbstractGamesCallbacks {
        private final BaseImplementation.b<SubmitScoreResult> Ea;

        public SubmitScoreBinderCallbacks(BaseImplementation.b<SubmitScoreResult> resultHolder) {
            this.Ea = (BaseImplementation.b) jx.b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void f(DataHolder dataHolder) {
            this.Ea.b(new SubmitScoreResultImpl(dataHolder));
        }
    }

    private static final class SubmitScoreResultImpl extends b implements SubmitScoreResult {
        private final ScoreSubmissionData ZE;

        public SubmitScoreResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            try {
                this.ZE = new ScoreSubmissionData(dataHolder);
            } finally {
                dataHolder.close();
            }
        }

        public ScoreSubmissionData getScoreData() {
            return this.ZE;
        }
    }

    private static final class TurnBasedMatchCanceledBinderCallbacks extends AbstractGamesCallbacks {
        private final BaseImplementation.b<CancelMatchResult> ZF;

        public TurnBasedMatchCanceledBinderCallbacks(BaseImplementation.b<CancelMatchResult> resultHolder) {
            this.ZF = (BaseImplementation.b) jx.b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void h(int i, String str) {
            this.ZF.b(new CancelMatchResultImpl(new Status(i), str));
        }
    }

    private static final class TurnBasedMatchInitiatedBinderCallbacks extends AbstractGamesCallbacks {
        private final BaseImplementation.b<InitiateMatchResult> ZG;

        public TurnBasedMatchInitiatedBinderCallbacks(BaseImplementation.b<InitiateMatchResult> resultHolder) {
            this.ZG = (BaseImplementation.b) jx.b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void q(DataHolder dataHolder) {
            this.ZG.b(new InitiateMatchResultImpl(dataHolder));
        }
    }

    private static final class TurnBasedMatchLeftBinderCallbacks extends AbstractGamesCallbacks {
        private final BaseImplementation.b<LeaveMatchResult> ZH;

        public TurnBasedMatchLeftBinderCallbacks(BaseImplementation.b<LeaveMatchResult> resultHolder) {
            this.ZH = (BaseImplementation.b) jx.b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void s(DataHolder dataHolder) {
            this.ZH.b(new LeaveMatchResultImpl(dataHolder));
        }
    }

    private static final class TurnBasedMatchLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final BaseImplementation.b<LoadMatchResult> ZI;

        public TurnBasedMatchLoadedBinderCallbacks(BaseImplementation.b<LoadMatchResult> resultHolder) {
            this.ZI = (BaseImplementation.b) jx.b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void p(DataHolder dataHolder) {
            this.ZI.b(new LoadMatchResultImpl(dataHolder));
        }
    }

    private static final class TurnBasedMatchUpdatedBinderCallbacks extends AbstractGamesCallbacks {
        private final BaseImplementation.b<UpdateMatchResult> ZJ;

        public TurnBasedMatchUpdatedBinderCallbacks(BaseImplementation.b<UpdateMatchResult> resultHolder) {
            this.ZJ = (BaseImplementation.b) jx.b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void r(DataHolder dataHolder) {
            this.ZJ.b(new UpdateMatchResultImpl(dataHolder));
        }
    }

    private static final class TurnBasedMatchesLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final BaseImplementation.b<LoadMatchesResult> ZK;

        public TurnBasedMatchesLoadedBinderCallbacks(BaseImplementation.b<LoadMatchesResult> resultHolder) {
            this.ZK = (BaseImplementation.b) jx.b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void b(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.ZK.b(new LoadMatchesResultImpl(new Status(i), bundle));
        }
    }

    private static final class UpdateAchievementResultImpl implements UpdateAchievementResult {
        private final Status Eb;
        private final String Xx;

        UpdateAchievementResultImpl(int statusCode, String achievementId) {
            this.Eb = new Status(statusCode);
            this.Xx = achievementId;
        }

        public String getAchievementId() {
            return this.Xx;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    private static final class UpdateMatchResultImpl extends TurnBasedMatchResult implements UpdateMatchResult {
        UpdateMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class UpdateRequestsResultImpl extends b implements UpdateRequestsResult {
        private final RequestUpdateOutcomes ZL;

        UpdateRequestsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.ZL = RequestUpdateOutcomes.W(dataHolder);
        }

        public Set<String> getRequestIds() {
            return this.ZL.getRequestIds();
        }

        public int getRequestOutcome(String requestId) {
            return this.ZL.getRequestOutcome(requestId);
        }
    }

    public GamesClientImpl(Context context, Looper looper, String gamePackageName, String accountName, ConnectionCallbacks connectedListener, OnConnectionFailedListener connectionFailedListener, String[] scopes, int gravity, View gamesContentView, GamesOptions options) {
        super(context, looper, connectedListener, connectionFailedListener, scopes);
        this.Yl = gamePackageName;
        this.DZ = (String) jx.i(accountName);
        this.Yr = new Binder();
        this.Ym = new HashMap();
        this.Yp = PopupManager.a(this, gravity);
        k(gamesContentView);
        this.Ys = (long) hashCode();
        this.Yt = options;
        registerConnectionCallbacks((ConnectionCallbacks) this);
        registerConnectionFailedListener((OnConnectionFailedListener) this);
    }

    private static Room R(DataHolder dataHolder) {
        RoomBuffer roomBuffer = new RoomBuffer(dataHolder);
        Room room = null;
        try {
            if (roomBuffer.getCount() > 0) {
                room = (Room) ((Room) roomBuffer.get(0)).freeze();
            }
            roomBuffer.release();
            return room;
        } catch (Throwable th) {
            roomBuffer.release();
        }
    }

    private RealTimeSocket bB(String str) {
        RealTimeSocket bD = ll.ii() ? bD(str) : bC(str);
        if (bD != null) {
            this.Ym.put(str, bD);
        }
        return bD;
    }

    private RealTimeSocket bC(String str) {
        try {
            String bH = ((IGamesService) hw()).bH(str);
            if (bH == null) {
                return null;
            }
            LocalSocket localSocket = new LocalSocket();
            localSocket.connect(new LocalSocketAddress(bH));
            return new RealTimeSocketImpl(localSocket, str);
        } catch (RemoteException e) {
            GamesLog.p("GamesClientImpl", "Unable to create socket. Service died.");
            return null;
        } catch (IOException e2) {
            GamesLog.p("GamesClientImpl", "connect() call failed on socket: " + e2.getMessage());
            return null;
        }
    }

    private RealTimeSocket bD(String str) {
        try {
            ParcelFileDescriptor bN = ((IGamesService) hw()).bN(str);
            if (bN != null) {
                GamesLog.n("GamesClientImpl", "Created native libjingle socket.");
                return new LibjingleNativeSocket(bN);
            }
            GamesLog.p("GamesClientImpl", "Unable to create socket for " + str);
            return null;
        } catch (RemoteException e) {
            GamesLog.p("GamesClientImpl", "Unable to create socket. Service died.");
            return null;
        }
    }

    private void lD() {
        for (RealTimeSocket close : this.Ym.values()) {
            try {
                close.close();
            } catch (Throwable e) {
                GamesLog.c("GamesClientImpl", "IOException:", e);
            }
        }
        this.Ym.clear();
    }

    private void lg() {
        this.Yn = null;
    }

    public int a(d<ReliableMessageSentCallback> dVar, byte[] bArr, String str, String str2) {
        try {
            return ((IGamesService) hw()).a(new RealTimeReliableMessageBinderCallbacks(dVar), bArr, str, str2);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
            return -1;
        }
    }

    public int a(byte[] bArr, String str, String[] strArr) {
        jx.b((Object) strArr, (Object) "Participant IDs must not be null");
        try {
            return ((IGamesService) hw()).b(bArr, str, strArr);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
            return -1;
        }
    }

    public Intent a(int i, int i2, boolean z) {
        try {
            return ((IGamesService) hw()).a(i, i2, z);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent a(int i, byte[] bArr, int i2, Bitmap bitmap, String str) {
        try {
            Intent a = ((IGamesService) hw()).a(i, bArr, i2, str);
            jx.b((Object) bitmap, (Object) "Must provide a non null icon");
            a.putExtra("com.google.android.gms.games.REQUEST_ITEM_ICON", bitmap);
            return a;
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent a(Room room, int i) {
        try {
            return ((IGamesService) hw()).a((RoomEntity) room.freeze(), i);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent a(String str, boolean z, boolean z2, int i) {
        try {
            return ((IGamesService) hw()).a(str, z, z2, i);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
            return null;
        }
    }

    protected void a(int i, IBinder iBinder, Bundle bundle) {
        if (i == 0 && bundle != null) {
            this.Yq = bundle.getBoolean("show_welcome_popup");
        }
        super.a(i, iBinder, bundle);
    }

    public void a(IBinder iBinder, Bundle bundle) {
        if (isConnected()) {
            try {
                ((IGamesService) hw()).a(iBinder, bundle);
            } catch (RemoteException e) {
                GamesLog.o("GamesClientImpl", "service died");
            }
        }
    }

    public void a(BaseImplementation.b<LoadRequestsResult> bVar, int i, int i2, int i3) {
        try {
            ((IGamesService) hw()).a(new RequestsLoadedBinderCallbacks(bVar), i, i2, i3);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void a(BaseImplementation.b<LoadExtendedGamesResult> bVar, int i, int i2, boolean z, boolean z2) {
        try {
            ((IGamesService) hw()).a(new ExtendedGamesLoadedBinderCallback(bVar), i, i2, z, z2);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void a(BaseImplementation.b<LoadAppContentResult> bVar, int i, String str, String[] strArr, boolean z) {
        try {
            ((IGamesService) hw()).a(new AppContentLoadedBinderCallbacks(bVar), i, str, strArr, z);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void a(BaseImplementation.b<LoadPlayersResult> bVar, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) hw()).a(new PlayersLoadedBinderCallback(bVar), i, z, z2);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void a(BaseImplementation.b<LoadMatchesResult> bVar, int i, int[] iArr) {
        try {
            ((IGamesService) hw()).a(new TurnBasedMatchesLoadedBinderCallbacks(bVar), i, iArr);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void a(BaseImplementation.b<LoadScoresResult> bVar, LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) {
        try {
            ((IGamesService) hw()).a(new LeaderboardScoresLoadedBinderCallback(bVar), leaderboardScoreBuffer.mH().mI(), i, i2);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void a(BaseImplementation.b<InitiateMatchResult> bVar, TurnBasedMatchConfig turnBasedMatchConfig) {
        try {
            ((IGamesService) hw()).a(new TurnBasedMatchInitiatedBinderCallbacks(bVar), turnBasedMatchConfig.getVariant(), turnBasedMatchConfig.mO(), turnBasedMatchConfig.getInvitedPlayerIds(), turnBasedMatchConfig.getAutoMatchCriteria());
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void a(BaseImplementation.b<CommitSnapshotResult> bVar, Snapshot snapshot, SnapshotMetadataChange snapshotMetadataChange) {
        SnapshotContents snapshotContents = snapshot.getSnapshotContents();
        jx.a(!snapshotContents.isClosed(), "Snapshot already closed");
        com.google.android.gms.common.data.a mT = snapshotMetadataChange.mT();
        if (mT != null) {
            mT.a(getContext().getCacheDir());
        }
        Contents ir = snapshotContents.ir();
        snapshotContents.close();
        try {
            ((IGamesService) hw()).a(new SnapshotCommittedBinderCallbacks(bVar), snapshot.getMetadata().getSnapshotId(), (SnapshotMetadataChangeEntity) snapshotMetadataChange, ir);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void a(BaseImplementation.b<UpdateAchievementResult> bVar, String str) {
        if (bVar == null) {
            IGamesCallbacks iGamesCallbacks = null;
        } else {
            Object achievementUpdatedBinderCallback = new AchievementUpdatedBinderCallback(bVar);
        }
        try {
            ((IGamesService) hw()).a(iGamesCallbacks, str, this.Yp.lV(), this.Yp.lU());
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void a(BaseImplementation.b<UpdateAchievementResult> bVar, String str, int i) {
        try {
            ((IGamesService) hw()).a(bVar == null ? null : new AchievementUpdatedBinderCallback(bVar), str, i, this.Yp.lV(), this.Yp.lU());
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void a(BaseImplementation.b<LoadScoresResult> bVar, String str, int i, int i2, int i3, boolean z) {
        try {
            ((IGamesService) hw()).a(new LeaderboardScoresLoadedBinderCallback(bVar), str, i, i2, i3, z);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void a(BaseImplementation.b<LoadPlayersResult> bVar, String str, int i, boolean z, boolean z2) {
        Object obj = -1;
        switch (str.hashCode()) {
            case 156408498:
                if (str.equals("played_with")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                try {
                    ((IGamesService) hw()).d(new PlayersLoadedBinderCallback(bVar), str, i, z, z2);
                    return;
                } catch (RemoteException e) {
                    GamesLog.o("GamesClientImpl", "service died");
                    return;
                }
            default:
                throw new IllegalArgumentException("Invalid player collection: " + str);
        }
    }

    public void a(BaseImplementation.b<LoadExtendedGamesResult> bVar, String str, int i, boolean z, boolean z2, boolean z3, boolean z4) {
        try {
            ((IGamesService) hw()).a(new ExtendedGamesLoadedBinderCallback(bVar), str, i, z, z2, z3, z4);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void a(BaseImplementation.b<LoadMatchesResult> bVar, String str, int i, int[] iArr) {
        try {
            ((IGamesService) hw()).a(new TurnBasedMatchesLoadedBinderCallbacks(bVar), str, i, iArr);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void a(BaseImplementation.b<SubmitScoreResult> bVar, String str, long j, String str2) {
        try {
            ((IGamesService) hw()).a(bVar == null ? null : new SubmitScoreBinderCallbacks(bVar), str, j, str2);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void a(BaseImplementation.b<LeaveMatchResult> bVar, String str, String str2) {
        try {
            ((IGamesService) hw()).c(new TurnBasedMatchLeftBinderCallbacks(bVar), str, str2);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void a(BaseImplementation.b<LoadPlayerScoreResult> bVar, String str, String str2, int i, int i2) {
        try {
            ((IGamesService) hw()).a(new PlayerLeaderboardScoreLoadedBinderCallback(bVar), str, str2, i, i2);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void a(BaseImplementation.b<LoadRequestsResult> bVar, String str, String str2, int i, int i2, int i3) {
        try {
            ((IGamesService) hw()).a(new RequestsLoadedBinderCallbacks(bVar), str, str2, i, i2, i3);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void a(BaseImplementation.b<LoadScoresResult> bVar, String str, String str2, int i, int i2, int i3, boolean z) {
        try {
            ((IGamesService) hw()).a(new LeaderboardScoresLoadedBinderCallback(bVar), str, str2, i, i2, i3, z);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void a(BaseImplementation.b<LoadPlayersResult> bVar, String str, String str2, int i, boolean z, boolean z2) {
        Object obj = -1;
        switch (str.hashCode()) {
            case -1049482625:
                if (str.equals("nearby")) {
                    obj = 2;
                    break;
                }
                break;
            case 156408498:
                if (str.equals("played_with")) {
                    obj = 1;
                    break;
                }
                break;
            case 782949780:
                if (str.equals("circled")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
            case 1:
            case 2:
                try {
                    ((IGamesService) hw()).a(new PlayersLoadedBinderCallback(bVar), str, str2, i, z, z2);
                    return;
                } catch (RemoteException e) {
                    GamesLog.o("GamesClientImpl", "service died");
                    return;
                }
            default:
                throw new IllegalArgumentException("Invalid player collection: " + str);
        }
    }

    public void a(BaseImplementation.b<OpenSnapshotResult> bVar, String str, String str2, SnapshotMetadataChange snapshotMetadataChange, SnapshotContents snapshotContents) {
        jx.a(!snapshotContents.isClosed(), "SnapshotContents already closed");
        com.google.android.gms.common.data.a mT = snapshotMetadataChange.mT();
        if (mT != null) {
            mT.a(getContext().getCacheDir());
        }
        Contents ir = snapshotContents.ir();
        snapshotContents.close();
        try {
            ((IGamesService) hw()).a(new SnapshotOpenedBinderCallbacks(bVar), str, str2, (SnapshotMetadataChangeEntity) snapshotMetadataChange, ir);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void a(BaseImplementation.b<LeaderboardMetadataResult> bVar, String str, String str2, boolean z) {
        try {
            ((IGamesService) hw()).b(new LeaderboardsLoadedBinderCallback(bVar), str, str2, z);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void a(BaseImplementation.b<LoadQuestsResult> bVar, String str, String str2, boolean z, String[] strArr) {
        try {
            this.Yk.flush();
            ((IGamesService) hw()).a(new QuestsLoadedBinderCallbacks(bVar), str, str2, strArr, z);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void a(BaseImplementation.b<LoadQuestsResult> bVar, String str, String str2, int[] iArr, int i, boolean z) {
        try {
            this.Yk.flush();
            ((IGamesService) hw()).a(new QuestsLoadedBinderCallbacks(bVar), str, str2, iArr, i, z);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void a(BaseImplementation.b<UpdateRequestsResult> bVar, String str, String str2, String[] strArr) {
        try {
            ((IGamesService) hw()).a(new RequestsUpdatedBinderCallbacks(bVar), str, str2, strArr);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void a(BaseImplementation.b<LoadPlayersResult> bVar, String str, boolean z) {
        try {
            ((IGamesService) hw()).f(new PlayersLoadedBinderCallback(bVar), str, z);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void a(BaseImplementation.b<UpdateMatchResult> bVar, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) {
        try {
            ((IGamesService) hw()).a(new TurnBasedMatchUpdatedBinderCallbacks(bVar), str, bArr, str2, participantResultArr);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void a(BaseImplementation.b<UpdateMatchResult> bVar, String str, byte[] bArr, ParticipantResult[] participantResultArr) {
        try {
            ((IGamesService) hw()).a(new TurnBasedMatchUpdatedBinderCallbacks(bVar), str, bArr, participantResultArr);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void a(BaseImplementation.b<SendRequestResult> bVar, String str, String[] strArr, int i, byte[] bArr, int i2) {
        try {
            ((IGamesService) hw()).a(new RequestSentBinderCallbacks(bVar), str, strArr, i, bArr, i2);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void a(BaseImplementation.b<LoadPlayersResult> bVar, boolean z) {
        try {
            ((IGamesService) hw()).c(new PlayersLoadedBinderCallback(bVar), z);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void a(BaseImplementation.b<Status> bVar, boolean z, Bundle bundle) {
        try {
            ((IGamesService) hw()).a(new ContactSettingsUpdatedBinderCallback(bVar), z, bundle);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void a(BaseImplementation.b<LoadEventsResult> bVar, boolean z, String... strArr) {
        try {
            this.Yk.flush();
            ((IGamesService) hw()).a(new EventsLoadedBinderCallback(bVar), z, strArr);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void a(BaseImplementation.b<LoadQuestsResult> bVar, int[] iArr, int i, boolean z) {
        try {
            this.Yk.flush();
            ((IGamesService) hw()).a(new QuestsLoadedBinderCallbacks(bVar), iArr, i, z);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void a(BaseImplementation.b<LoadPlayersResult> bVar, String[] strArr) {
        try {
            ((IGamesService) hw()).c(new PlayersLoadedBinderCallback(bVar), strArr);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void a(d<OnInvitationReceivedListener> dVar) {
        try {
            ((IGamesService) hw()).a(new InvitationReceivedBinderCallback(dVar), this.Ys);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void a(d<RoomUpdateListener> dVar, d<RoomStatusUpdateListener> dVar2, d<RealTimeMessageReceivedListener> dVar3, RoomConfig roomConfig) {
        lD();
        try {
            ((IGamesService) hw()).a(new RoomBinderCallbacks(dVar, dVar2, dVar3), this.Yr, roomConfig.getVariant(), roomConfig.getInvitedPlayerIds(), roomConfig.getAutoMatchCriteria(), roomConfig.isSocketEnabled(), this.Ys);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void a(d<RoomUpdateListener> dVar, String str) {
        try {
            ((IGamesService) hw()).c(new RoomBinderCallbacks(dVar), str);
            lD();
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void a(Snapshot snapshot) {
        SnapshotContents snapshotContents = snapshot.getSnapshotContents();
        jx.a(!snapshotContents.isClosed(), "Snapshot already closed");
        Contents ir = snapshotContents.ir();
        snapshotContents.close();
        try {
            ((IGamesService) hw()).a(ir);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    protected void a(jt jtVar, e eVar) throws RemoteException {
        String locale = getContext().getResources().getConfiguration().locale.toString();
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.google.android.gms.games.key.isHeadless", this.Yt.Xa);
        bundle.putBoolean("com.google.android.gms.games.key.showConnectingPopup", this.Yt.Xb);
        bundle.putInt("com.google.android.gms.games.key.connectingPopupGravity", this.Yt.Xc);
        bundle.putBoolean("com.google.android.gms.games.key.retryingSignIn", this.Yt.Xd);
        bundle.putInt("com.google.android.gms.games.key.sdkVariant", this.Yt.Xe);
        bundle.putString("com.google.android.gms.games.key.forceResolveAccountKey", this.Yt.Xf);
        bundle.putStringArrayList("com.google.android.gms.games.key.proxyApis", this.Yt.Xg);
        jtVar.a(eVar, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), this.DZ, hv(), this.Yl, this.Yp.lV(), locale, bundle);
    }

    protected IGamesService aC(IBinder iBinder) {
        return Stub.aE(iBinder);
    }

    public Intent b(int i, int i2, boolean z) {
        try {
            return ((IGamesService) hw()).b(i, i2, z);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent b(int[] iArr) {
        try {
            return ((IGamesService) hw()).b(iArr);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
            return null;
        }
    }

    public void b(BaseImplementation.b<Status> bVar) {
        try {
            this.Yk.flush();
            ((IGamesService) hw()).a(new SignOutCompleteBinderCallbacks(bVar));
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void b(BaseImplementation.b<LoadPlayersResult> bVar, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) hw()).b(new PlayersLoadedBinderCallback(bVar), i, z, z2);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void b(BaseImplementation.b<UpdateAchievementResult> bVar, String str) {
        if (bVar == null) {
            IGamesCallbacks iGamesCallbacks = null;
        } else {
            Object achievementUpdatedBinderCallback = new AchievementUpdatedBinderCallback(bVar);
        }
        try {
            ((IGamesService) hw()).b(iGamesCallbacks, str, this.Yp.lV(), this.Yp.lU());
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void b(BaseImplementation.b<UpdateAchievementResult> bVar, String str, int i) {
        try {
            ((IGamesService) hw()).b(bVar == null ? null : new AchievementUpdatedBinderCallback(bVar), str, i, this.Yp.lV(), this.Yp.lU());
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void b(BaseImplementation.b<LoadScoresResult> bVar, String str, int i, int i2, int i3, boolean z) {
        try {
            ((IGamesService) hw()).b(new LeaderboardScoresLoadedBinderCallback(bVar), str, i, i2, i3, z);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void b(BaseImplementation.b<LoadExtendedGamesResult> bVar, String str, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) hw()).a(new ExtendedGamesLoadedBinderCallback(bVar), str, i, z, z2);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void b(BaseImplementation.b<ClaimMilestoneResult> bVar, String str, String str2) {
        try {
            this.Yk.flush();
            ((IGamesService) hw()).f(new QuestMilestoneClaimBinderCallbacks(bVar, str2), str, str2);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void b(BaseImplementation.b<LoadScoresResult> bVar, String str, String str2, int i, int i2, int i3, boolean z) {
        try {
            ((IGamesService) hw()).b(new LeaderboardScoresLoadedBinderCallback(bVar), str, str2, i, i2, i3, z);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void b(BaseImplementation.b<LoadPlayersResult> bVar, String str, String str2, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) hw()).b(new PlayersLoadedBinderCallback(bVar), str, str2, i, z, z2);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void b(BaseImplementation.b<LoadAchievementsResult> bVar, String str, String str2, boolean z) {
        try {
            ((IGamesService) hw()).a(new AchievementsLoadedBinderCallback(bVar), str, str2, z);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void b(BaseImplementation.b<LeaderboardMetadataResult> bVar, String str, boolean z) {
        try {
            ((IGamesService) hw()).c(new LeaderboardsLoadedBinderCallback(bVar), str, z);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void b(BaseImplementation.b<LeaderboardMetadataResult> bVar, boolean z) {
        try {
            ((IGamesService) hw()).b(new LeaderboardsLoadedBinderCallback(bVar), z);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void b(BaseImplementation.b<LoadQuestsResult> bVar, boolean z, String[] strArr) {
        try {
            this.Yk.flush();
            ((IGamesService) hw()).a(new QuestsLoadedBinderCallbacks(bVar), strArr, z);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void b(BaseImplementation.b<UpdateRequestsResult> bVar, String[] strArr) {
        try {
            ((IGamesService) hw()).a(new RequestsUpdatedBinderCallbacks(bVar), strArr);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void b(d<OnTurnBasedMatchUpdateReceivedListener> dVar) {
        try {
            ((IGamesService) hw()).b(new MatchUpdateReceivedBinderCallback(dVar), this.Ys);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void b(d<RoomUpdateListener> dVar, d<RoomStatusUpdateListener> dVar2, d<RealTimeMessageReceivedListener> dVar3, RoomConfig roomConfig) {
        lD();
        try {
            ((IGamesService) hw()).a(new RoomBinderCallbacks(dVar, dVar2, dVar3), this.Yr, roomConfig.getInvitationId(), roomConfig.isSocketEnabled(), this.Ys);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void bA(String str) {
        try {
            ((IGamesService) hw()).bL(str);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public Intent bE(String str) {
        try {
            return ((IGamesService) hw()).bE(str);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
            return null;
        }
    }

    public void bF(String str) {
        try {
            ((IGamesService) hw()).a(str, this.Yp.lV(), this.Yp.lU());
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    protected String bK() {
        return "com.google.android.gms.games.service.START";
    }

    protected String bL() {
        return "com.google.android.gms.games.internal.IGamesService";
    }

    public void c(BaseImplementation.b<LoadInvitationsResult> bVar, int i) {
        try {
            ((IGamesService) hw()).a(new InvitationsLoadedBinderCallback(bVar), i);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void c(BaseImplementation.b<LoadPlayersResult> bVar, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) hw()).c(new PlayersLoadedBinderCallback(bVar), i, z, z2);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void c(BaseImplementation.b<InitiateMatchResult> bVar, String str) {
        try {
            ((IGamesService) hw()).l(new TurnBasedMatchInitiatedBinderCallbacks(bVar), str);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void c(BaseImplementation.b<LoadXpStreamResult> bVar, String str, int i) {
        try {
            ((IGamesService) hw()).b(new PlayerXpStreamLoadedBinderCallback(bVar), str, i);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void c(BaseImplementation.b<LoadExtendedGamesResult> bVar, String str, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) hw()).e(new ExtendedGamesLoadedBinderCallback(bVar), str, i, z, z2);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void c(BaseImplementation.b<InitiateMatchResult> bVar, String str, String str2) {
        try {
            ((IGamesService) hw()).d(new TurnBasedMatchInitiatedBinderCallbacks(bVar), str, str2);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void c(BaseImplementation.b<LoadSnapshotsResult> bVar, String str, String str2, boolean z) {
        try {
            ((IGamesService) hw()).c(new SnapshotsLoadedBinderCallbacks(bVar), str, str2, z);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void c(BaseImplementation.b<OpenSnapshotResult> bVar, String str, boolean z) {
        try {
            ((IGamesService) hw()).e(new SnapshotOpenedBinderCallbacks(bVar), str, z);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void c(BaseImplementation.b<LoadAchievementsResult> bVar, boolean z) {
        try {
            ((IGamesService) hw()).a(new AchievementsLoadedBinderCallback(bVar), z);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void c(BaseImplementation.b<UpdateRequestsResult> bVar, String[] strArr) {
        try {
            ((IGamesService) hw()).b(new RequestsUpdatedBinderCallbacks(bVar), strArr);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void c(d<QuestUpdateListener> dVar) {
        try {
            ((IGamesService) hw()).d(new QuestUpdateBinderCallback(dVar), this.Ys);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    protected void c(String... strArr) {
        int i = 0;
        boolean z = false;
        for (String str : strArr) {
            if (str.equals(Scopes.GAMES)) {
                z = true;
            } else if (str.equals("https://www.googleapis.com/auth/games.firstparty")) {
                i = 1;
            }
        }
        if (i != 0) {
            jx.a(!z, "Cannot have both %s and %s!", Scopes.GAMES, "https://www.googleapis.com/auth/games.firstparty");
            return;
        }
        jx.a(z, "Games APIs requires %s to function.", Scopes.GAMES);
    }

    public void connect() {
        lg();
        super.connect();
    }

    public int d(byte[] bArr, String str) {
        try {
            return ((IGamesService) hw()).b(bArr, str, null);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
            return -1;
        }
    }

    public void d(BaseImplementation.b<LoadPlayersResult> bVar, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) hw()).e(new PlayersLoadedBinderCallback(bVar), i, z, z2);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void d(BaseImplementation.b<InitiateMatchResult> bVar, String str) {
        try {
            ((IGamesService) hw()).m(new TurnBasedMatchInitiatedBinderCallbacks(bVar), str);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void d(BaseImplementation.b<LoadXpStreamResult> bVar, String str, int i) {
        try {
            ((IGamesService) hw()).c(new PlayerXpStreamLoadedBinderCallback(bVar), str, i);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void d(BaseImplementation.b<LoadExtendedGamesResult> bVar, String str, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) hw()).f(new ExtendedGamesLoadedBinderCallback(bVar), str, i, z, z2);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void d(BaseImplementation.b<InitiateMatchResult> bVar, String str, String str2) {
        try {
            ((IGamesService) hw()).e(new TurnBasedMatchInitiatedBinderCallbacks(bVar), str, str2);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void d(BaseImplementation.b<LeaderboardMetadataResult> bVar, String str, boolean z) {
        try {
            ((IGamesService) hw()).d(new LeaderboardsLoadedBinderCallback(bVar), str, z);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void d(BaseImplementation.b<LoadEventsResult> bVar, boolean z) {
        try {
            this.Yk.flush();
            ((IGamesService) hw()).f(new EventsLoadedBinderCallback(bVar), z);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void d(d<OnRequestReceivedListener> dVar) {
        try {
            ((IGamesService) hw()).c(new RequestReceivedBinderCallback(dVar), this.Ys);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void dS(int i) {
        this.Yp.setGravity(i);
    }

    public void dT(int i) {
        try {
            ((IGamesService) hw()).dT(i);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void disconnect() {
        this.Yq = false;
        if (isConnected()) {
            try {
                IGamesService iGamesService = (IGamesService) hw();
                iGamesService.lE();
                this.Yk.flush();
                iGamesService.q(this.Ys);
            } catch (RemoteException e) {
                GamesLog.o("GamesClientImpl", "Failed to notify client disconnect.");
            }
        }
        lD();
        super.disconnect();
    }

    public void e(BaseImplementation.b<LeaveMatchResult> bVar, String str) {
        try {
            ((IGamesService) hw()).o(new TurnBasedMatchLeftBinderCallbacks(bVar), str);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void e(BaseImplementation.b<LoadInvitationsResult> bVar, String str, int i) {
        try {
            ((IGamesService) hw()).b(new InvitationsLoadedBinderCallback(bVar), str, i, false);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void e(BaseImplementation.b<LoadExtendedGamesResult> bVar, String str, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) hw()).c(new ExtendedGamesLoadedBinderCallback(bVar), str, i, z, z2);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void e(BaseImplementation.b<GameMuteStatusChangeResult> bVar, String str, boolean z) {
        try {
            ((IGamesService) hw()).a(new GameMuteStatusChangedBinderCallback(bVar), str, z);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void e(BaseImplementation.b<LoadSnapshotsResult> bVar, boolean z) {
        try {
            ((IGamesService) hw()).d(new SnapshotsLoadedBinderCallbacks(bVar), z);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void f(BaseImplementation.b<LoadGamesResult> bVar) {
        try {
            ((IGamesService) hw()).d(new GamesLoadedBinderCallback(bVar));
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void f(BaseImplementation.b<CancelMatchResult> bVar, String str) {
        try {
            ((IGamesService) hw()).n(new TurnBasedMatchCanceledBinderCallbacks(bVar), str);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void f(BaseImplementation.b<LoadRequestSummariesResult> bVar, String str, int i) {
        try {
            ((IGamesService) hw()).a(new RequestSummariesLoadedBinderCallbacks(bVar), str, i);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void f(BaseImplementation.b<LoadPlayersResult> bVar, String str, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) hw()).b(new PlayersLoadedBinderCallback(bVar), str, i, z, z2);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void f(BaseImplementation.b<LoadProfileSettingsResult> bVar, boolean z) {
        try {
            ((IGamesService) hw()).g(new ProfileSettingsLoadedBinderCallback(bVar), z);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public Bundle fX() {
        try {
            Bundle fX = ((IGamesService) hw()).fX();
            if (fX == null) {
                return fX;
            }
            fX.setClassLoader(GamesClientImpl.class.getClassLoader());
            return fX;
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
            return null;
        }
    }

    public void g(BaseImplementation.b<LoadOwnerCoverPhotoUrisResult> bVar) {
        try {
            ((IGamesService) hw()).j(new OwnerCoverPhotoUrisLoadedBinderCallback(bVar));
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void g(BaseImplementation.b<LoadMatchResult> bVar, String str) {
        try {
            ((IGamesService) hw()).p(new TurnBasedMatchLoadedBinderCallbacks(bVar), str);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void g(BaseImplementation.b<Status> bVar, boolean z) {
        try {
            ((IGamesService) hw()).h(new ProfileSettingsUpdatedBinderCallback(bVar), z);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void h(BaseImplementation.b<LoadAclResult> bVar) {
        try {
            ((IGamesService) hw()).h(new NotifyAclLoadedBinderCallback(bVar));
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void h(BaseImplementation.b<AcceptQuestResult> bVar, String str) {
        try {
            this.Yk.flush();
            ((IGamesService) hw()).u(new QuestAcceptedBinderCallbacks(bVar), str);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void h(BaseImplementation.b<ContactSettingLoadResult> bVar, boolean z) {
        try {
            ((IGamesService) hw()).e(new ContactSettingsLoadedBinderCallback(bVar), z);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void i(BaseImplementation.b<InboxCountResult> bVar) {
        try {
            ((IGamesService) hw()).t(new InboxCountsLoadedBinderCallback(bVar), null);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void i(BaseImplementation.b<DeleteSnapshotResult> bVar, String str) {
        try {
            ((IGamesService) hw()).r(new SnapshotDeletedBinderCallbacks(bVar), str);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void j(BaseImplementation.b<LoadExtendedGamesResult> bVar, String str) {
        try {
            ((IGamesService) hw()).e(new ExtendedGamesLoadedBinderCallback(bVar), str);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void k(View view) {
        this.Yp.l(view);
    }

    public void k(BaseImplementation.b<LoadGameInstancesResult> bVar, String str) {
        try {
            ((IGamesService) hw()).f(new GameInstancesLoadedBinderCallback(bVar), str);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    protected /* synthetic */ IInterface l(IBinder iBinder) {
        return aC(iBinder);
    }

    public void l(BaseImplementation.b<LoadGameSearchSuggestionsResult> bVar, String str) {
        try {
            ((IGamesService) hw()).q(new GameSearchSuggestionsLoadedBinderCallback(bVar), str);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public int lA() {
        try {
            return ((IGamesService) hw()).lA();
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
            return -1;
        }
    }

    public int lB() {
        try {
            return ((IGamesService) hw()).lB();
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
            return -1;
        }
    }

    public int lC() {
        try {
            return ((IGamesService) hw()).lC();
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
            return -1;
        }
    }

    public void lE() {
        if (isConnected()) {
            try {
                ((IGamesService) hw()).lE();
            } catch (RemoteException e) {
                GamesLog.o("GamesClientImpl", "service died");
            }
        }
    }

    public String lh() {
        try {
            return ((IGamesService) hw()).lh();
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
            return null;
        }
    }

    public String li() {
        try {
            return ((IGamesService) hw()).li();
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
            return null;
        }
    }

    public Player lj() {
        dS();
        synchronized (this) {
            if (this.Yn == null) {
                PlayerBuffer playerBuffer;
                try {
                    playerBuffer = new PlayerBuffer(((IGamesService) hw()).lG());
                    if (playerBuffer.getCount() > 0) {
                        this.Yn = (PlayerEntity) playerBuffer.get(0).freeze();
                    }
                    playerBuffer.release();
                } catch (RemoteException e) {
                    GamesLog.o("GamesClientImpl", "service died");
                } catch (Throwable th) {
                    playerBuffer.release();
                }
            }
        }
        return this.Yn;
    }

    public Game lk() {
        dS();
        synchronized (this) {
            if (this.Yo == null) {
                GameBuffer gameBuffer;
                try {
                    gameBuffer = new GameBuffer(((IGamesService) hw()).lI());
                    if (gameBuffer.getCount() > 0) {
                        this.Yo = (GameEntity) gameBuffer.get(0).freeze();
                    }
                    gameBuffer.release();
                } catch (RemoteException e) {
                    GamesLog.o("GamesClientImpl", "service died");
                } catch (Throwable th) {
                    gameBuffer.release();
                }
            }
        }
        return this.Yo;
    }

    public Intent ll() {
        try {
            return ((IGamesService) hw()).ll();
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent lm() {
        try {
            return ((IGamesService) hw()).lm();
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent ln() {
        try {
            return ((IGamesService) hw()).ln();
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent lo() {
        try {
            return ((IGamesService) hw()).lo();
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
            return null;
        }
    }

    public void lp() {
        try {
            ((IGamesService) hw()).r(this.Ys);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void lq() {
        try {
            ((IGamesService) hw()).s(this.Ys);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void lr() {
        try {
            ((IGamesService) hw()).u(this.Ys);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void ls() {
        try {
            ((IGamesService) hw()).t(this.Ys);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public Intent lt() {
        try {
            return ((IGamesService) hw()).lt();
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent lu() {
        try {
            return ((IGamesService) hw()).lu();
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
            return null;
        }
    }

    public int lv() {
        try {
            return ((IGamesService) hw()).lv();
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
            return 4368;
        }
    }

    public String lw() {
        try {
            return ((IGamesService) hw()).lw();
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
            return null;
        }
    }

    public int lx() {
        try {
            return ((IGamesService) hw()).lx();
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
            return -1;
        }
    }

    public Intent ly() {
        try {
            return ((IGamesService) hw()).ly();
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
            return null;
        }
    }

    public int lz() {
        try {
            return ((IGamesService) hw()).lz();
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
            return -1;
        }
    }

    public void m(BaseImplementation.b<LoadXpForGameCategoriesResult> bVar, String str) {
        try {
            ((IGamesService) hw()).s(new PlayerXpForGameCategoriesLoadedBinderCallback(bVar), str);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public Intent n(String str, int i) {
        try {
            return ((IGamesService) hw()).u(str, i);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
            return null;
        }
    }

    public void n(BaseImplementation.b<LoadInvitationsResult> bVar, String str) {
        try {
            ((IGamesService) hw()).k(new InvitationsLoadedBinderCallback(bVar), str);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void o(BaseImplementation.b<Status> bVar, String str) {
        try {
            ((IGamesService) hw()).j(new NotifyAclUpdatedBinderCallback(bVar), str);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void o(String str, int i) {
        this.Yk.o(str, i);
    }

    public void onConnected(Bundle connectionHint) {
        if (this.Yq) {
            this.Yp.lT();
            this.Yq = false;
        }
    }

    public void onConnectionFailed(ConnectionResult result) {
        this.Yq = false;
    }

    public void onConnectionSuspended(int cause) {
    }

    public void p(BaseImplementation.b<GameMuteStatusLoadResult> bVar, String str) {
        try {
            ((IGamesService) hw()).i(new GameMuteStatusLoadedBinderCallback(bVar), str);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void p(String str, int i) {
        try {
            ((IGamesService) hw()).p(str, i);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public void q(String str, int i) {
        try {
            ((IGamesService) hw()).q(str, i);
        } catch (RemoteException e) {
            GamesLog.o("GamesClientImpl", "service died");
        }
    }

    public RealTimeSocket s(String str, String str2) {
        if (str2 == null || !ParticipantUtils.bY(str2)) {
            throw new IllegalArgumentException("Bad participant ID");
        }
        RealTimeSocket realTimeSocket = (RealTimeSocket) this.Ym.get(str2);
        return (realTimeSocket == null || realTimeSocket.isClosed()) ? bB(str2) : realTimeSocket;
    }
}
