package com.google.android.gms.games;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.view.View;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.b;
import com.google.android.gms.common.api.Api.c;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.BaseImplementation.a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.appcontent.AppContents;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.api.AchievementsImpl;
import com.google.android.gms.games.internal.api.AclsImpl;
import com.google.android.gms.games.internal.api.AppContentsImpl;
import com.google.android.gms.games.internal.api.EventsImpl;
import com.google.android.gms.games.internal.api.GamesMetadataImpl;
import com.google.android.gms.games.internal.api.InvitationsImpl;
import com.google.android.gms.games.internal.api.LeaderboardsImpl;
import com.google.android.gms.games.internal.api.MultiplayerImpl;
import com.google.android.gms.games.internal.api.NotificationsImpl;
import com.google.android.gms.games.internal.api.PlayersImpl;
import com.google.android.gms.games.internal.api.QuestsImpl;
import com.google.android.gms.games.internal.api.RealTimeMultiplayerImpl;
import com.google.android.gms.games.internal.api.RequestsImpl;
import com.google.android.gms.games.internal.api.SnapshotsImpl;
import com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl;
import com.google.android.gms.games.internal.game.Acls;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.internal.jg;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;

public final class Games {
    public static final Api<GamesOptions> API = new Api(DR, DQ, SCOPE_GAMES);
    public static final Achievements Achievements = new AchievementsImpl();
    static final c<GamesClientImpl> DQ = new c();
    private static final b<GamesClientImpl, GamesOptions> DR = new b<GamesClientImpl, GamesOptions>() {
        public GamesClientImpl a(Context context, Looper looper, jg jgVar, GamesOptions gamesOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new GamesClientImpl(context, looper, jgVar.hq(), jgVar.hm(), connectionCallbacks, onConnectionFailedListener, jgVar.hp(), jgVar.hn(), jgVar.hr(), gamesOptions == null ? new GamesOptions() : gamesOptions);
        }

        public int getPriority() {
            return 1;
        }
    };
    public static final String EXTRA_PLAYER_IDS = "players";
    public static final Events Events = new EventsImpl();
    public static final GamesMetadata GamesMetadata = new GamesMetadataImpl();
    public static final Invitations Invitations = new InvitationsImpl();
    public static final Leaderboards Leaderboards = new LeaderboardsImpl();
    public static final Notifications Notifications = new NotificationsImpl();
    public static final Players Players = new PlayersImpl();
    public static final Quests Quests = new QuestsImpl();
    public static final RealTimeMultiplayer RealTimeMultiplayer = new RealTimeMultiplayerImpl();
    public static final Requests Requests = new RequestsImpl();
    public static final Scope SCOPE_GAMES = new Scope(Scopes.GAMES);
    public static final Snapshots Snapshots = new SnapshotsImpl();
    public static final TurnBasedMultiplayer TurnBasedMultiplayer = new TurnBasedMultiplayerImpl();
    public static final Scope WV = new Scope("https://www.googleapis.com/auth/games.firstparty");
    public static final Api<GamesOptions> WW = new Api(DR, DQ, WV);
    public static final AppContents WX = new AppContentsImpl();
    public static final Multiplayer WY = new MultiplayerImpl();
    public static final Acls WZ = new AclsImpl();

    public static abstract class BaseGamesApiMethodImpl<R extends Result> extends a<R, GamesClientImpl> {
        public BaseGamesApiMethodImpl(GoogleApiClient googleApiClient) {
            super(Games.DQ, googleApiClient);
        }
    }

    private static abstract class SignOutImpl extends BaseGamesApiMethodImpl<Status> {
        private SignOutImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public Status b(Status status) {
            return status;
        }

        public /* synthetic */ Result c(Status status) {
            return b(status);
        }
    }

    public static final class GamesOptions implements Optional {
        public final boolean Xa;
        public final boolean Xb;
        public final int Xc;
        public final boolean Xd;
        public final int Xe;
        public final String Xf;
        public final ArrayList<String> Xg;

        public static final class Builder {
            boolean Xa;
            boolean Xb;
            int Xc;
            boolean Xd;
            int Xe;
            String Xf;
            ArrayList<String> Xg;

            private Builder() {
                this.Xa = false;
                this.Xb = true;
                this.Xc = 17;
                this.Xd = false;
                this.Xe = 4368;
                this.Xf = null;
                this.Xg = new ArrayList();
            }

            public GamesOptions build() {
                return new GamesOptions();
            }

            public Builder setSdkVariant(int variant) {
                this.Xe = variant;
                return this;
            }

            public Builder setShowConnectingPopup(boolean showConnectingPopup) {
                this.Xb = showConnectingPopup;
                this.Xc = 17;
                return this;
            }

            public Builder setShowConnectingPopup(boolean showConnectingPopup, int gravity) {
                this.Xb = showConnectingPopup;
                this.Xc = gravity;
                return this;
            }
        }

        private GamesOptions() {
            this.Xa = false;
            this.Xb = true;
            this.Xc = 17;
            this.Xd = false;
            this.Xe = 4368;
            this.Xf = null;
            this.Xg = new ArrayList();
        }

        private GamesOptions(Builder builder) {
            this.Xa = builder.Xa;
            this.Xb = builder.Xb;
            this.Xc = builder.Xc;
            this.Xd = builder.Xd;
            this.Xe = builder.Xe;
            this.Xf = builder.Xf;
            this.Xg = builder.Xg;
        }

        public static Builder builder() {
            return new Builder();
        }
    }

    private Games() {
    }

    public static GamesClientImpl d(GoogleApiClient googleApiClient) {
        jx.b(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        jx.a(googleApiClient.isConnected(), "GoogleApiClient must be connected.");
        return e(googleApiClient);
    }

    public static GamesClientImpl e(GoogleApiClient googleApiClient) {
        GamesClientImpl gamesClientImpl = (GamesClientImpl) googleApiClient.a(DQ);
        jx.a(gamesClientImpl != null, "GoogleApiClient is not configured to use the Games Api. Pass Games.API into GoogleApiClient.Builder#addApi() to use this feature.");
        return gamesClientImpl;
    }

    public static String getAppId(GoogleApiClient apiClient) {
        return d(apiClient).lw();
    }

    public static String getCurrentAccountName(GoogleApiClient apiClient) {
        return d(apiClient).lh();
    }

    public static int getSdkVariant(GoogleApiClient apiClient) {
        return d(apiClient).lv();
    }

    public static Intent getSettingsIntent(GoogleApiClient apiClient) {
        return d(apiClient).lu();
    }

    public static void setGravityForPopups(GoogleApiClient apiClient, int gravity) {
        d(apiClient).dS(gravity);
    }

    public static void setViewForPopups(GoogleApiClient apiClient, View gamesContentView) {
        jx.i(gamesContentView);
        d(apiClient).k(gamesContentView);
    }

    public static PendingResult<Status> signOut(GoogleApiClient apiClient) {
        return apiClient.b(new SignOutImpl(apiClient) {
            protected void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.b((BaseImplementation.b) this);
            }
        });
    }
}
