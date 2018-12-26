package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.BaseImplementation.b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.Players;
import com.google.android.gms.games.Players.LoadOwnerCoverPhotoUrisResult;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.Players.LoadProfileSettingsResult;
import com.google.android.gms.games.Players.LoadXpForGameCategoriesResult;
import com.google.android.gms.games.Players.LoadXpStreamResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class PlayersImpl implements Players {

    private static abstract class LoadPlayersImpl extends BaseGamesApiMethodImpl<LoadPlayersResult> {
        private LoadPlayersImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadPlayersResult ad(final Status status) {
            return new LoadPlayersResult(this) {
                final /* synthetic */ LoadPlayersImpl abg;

                public PlayerBuffer getPlayers() {
                    return new PlayerBuffer(DataHolder.av(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result c(Status status) {
            return ad(status);
        }
    }

    class AnonymousClass10 extends LoadPlayersImpl {
        final /* synthetic */ String ZZ;
        final /* synthetic */ int aar;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.a((b) this, "nearby", this.ZZ, this.aar, true, false);
        }
    }

    class AnonymousClass11 extends LoadPlayersImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ String ZZ;
        final /* synthetic */ int aar;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.a((b) this, "played_with", this.ZZ, this.aar, false, this.ZW);
        }
    }

    class AnonymousClass12 extends LoadPlayersImpl {
        final /* synthetic */ String ZZ;
        final /* synthetic */ int aar;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.a((b) this, "played_with", this.ZZ, this.aar, true, false);
        }
    }

    class AnonymousClass13 extends LoadPlayersImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ int aar;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.b((b) this, this.aar, false, this.ZW);
        }
    }

    class AnonymousClass14 extends LoadPlayersImpl {
        final /* synthetic */ int aar;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.b((b) this, this.aar, true, false);
        }
    }

    class AnonymousClass15 extends LoadPlayersImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ int aar;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.c((b) this, this.aar, false, this.ZW);
        }
    }

    class AnonymousClass16 extends LoadPlayersImpl {
        final /* synthetic */ int aar;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.c((b) this, this.aar, true, false);
        }
    }

    class AnonymousClass17 extends LoadPlayersImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ int aar;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.d(this, this.aar, false, this.ZW);
        }
    }

    class AnonymousClass18 extends LoadPlayersImpl {
        final /* synthetic */ int aar;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.d(this, this.aar, true, false);
        }
    }

    class AnonymousClass19 extends LoadPlayersImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ int aar;
        final /* synthetic */ String aat;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.f(this, this.aat, this.aar, false, this.ZW);
        }
    }

    class AnonymousClass20 extends LoadPlayersImpl {
        final /* synthetic */ int aar;
        final /* synthetic */ String aat;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.f(this, this.aat, this.aar, true, false);
        }
    }

    class AnonymousClass21 extends LoadPlayersImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ String aaR;
        final /* synthetic */ int aar;
        final /* synthetic */ String aba;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.b((b) this, this.aba, this.aaR, this.aar, false, this.ZW);
        }
    }

    class AnonymousClass22 extends LoadPlayersImpl {
        final /* synthetic */ String aaR;
        final /* synthetic */ int aar;
        final /* synthetic */ String aba;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.b((b) this, this.aba, this.aaR, this.aar, true, false);
        }
    }

    private static abstract class LoadOwnerCoverPhotoUrisImpl extends BaseGamesApiMethodImpl<LoadOwnerCoverPhotoUrisResult> {
        public LoadOwnerCoverPhotoUrisResult ac(final Status status) {
            return new LoadOwnerCoverPhotoUrisResult(this) {
                final /* synthetic */ LoadOwnerCoverPhotoUrisImpl abf;

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result c(Status status) {
            return ac(status);
        }
    }

    class AnonymousClass23 extends LoadOwnerCoverPhotoUrisImpl {
        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.g(this);
        }
    }

    private static abstract class LoadXpForGameCategoriesResultImpl extends BaseGamesApiMethodImpl<LoadXpForGameCategoriesResult> {
        public LoadXpForGameCategoriesResult af(final Status status) {
            return new LoadXpForGameCategoriesResult(this) {
                final /* synthetic */ LoadXpForGameCategoriesResultImpl abi;

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result c(Status status) {
            return af(status);
        }
    }

    class AnonymousClass24 extends LoadXpForGameCategoriesResultImpl {
        final /* synthetic */ String abb;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m(this, this.abb);
        }
    }

    private static abstract class LoadXpStreamResultImpl extends BaseGamesApiMethodImpl<LoadXpStreamResult> {
        public LoadXpStreamResult ag(final Status status) {
            return new LoadXpStreamResult(this) {
                final /* synthetic */ LoadXpStreamResultImpl abj;

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result c(Status status) {
            return ag(status);
        }
    }

    class AnonymousClass25 extends LoadXpStreamResultImpl {
        final /* synthetic */ String abb;
        final /* synthetic */ int abc;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.c((b) this, this.abb, this.abc);
        }
    }

    class AnonymousClass26 extends LoadXpStreamResultImpl {
        final /* synthetic */ String abb;
        final /* synthetic */ int abc;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.d((b) this, this.abb, this.abc);
        }
    }

    private static abstract class LoadProfileSettingsResultImpl extends BaseGamesApiMethodImpl<LoadProfileSettingsResult> {
        protected LoadProfileSettingsResult ae(final Status status) {
            return new LoadProfileSettingsResult(this) {
                final /* synthetic */ LoadProfileSettingsResultImpl abh;

                public Status getStatus() {
                    return status;
                }

                public boolean isProfileVisible() {
                    return true;
                }

                public boolean isVisibilityExplicitlySet() {
                    return false;
                }
            };
        }

        protected /* synthetic */ Result c(Status status) {
            return ae(status);
        }
    }

    class AnonymousClass27 extends LoadProfileSettingsResultImpl {
        final /* synthetic */ boolean ZW;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.f((b) this, this.ZW);
        }
    }

    private static abstract class UpdateProfileSettingsResultImpl extends BaseGamesApiMethodImpl<Status> {
        protected Status b(Status status) {
            return status;
        }

        protected /* synthetic */ Result c(Status status) {
            return b(status);
        }
    }

    class AnonymousClass28 extends UpdateProfileSettingsResultImpl {
        final /* synthetic */ boolean abd;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.g((b) this, this.abd);
        }
    }

    class AnonymousClass3 extends LoadPlayersImpl {
        final /* synthetic */ String[] abe;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.a((b) this, this.abe);
        }
    }

    class AnonymousClass9 extends LoadPlayersImpl {
        final /* synthetic */ String ZZ;
        final /* synthetic */ int aar;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.a((b) this, "nearby", this.ZZ, this.aar, false, false);
        }
    }

    public Player getCurrentPlayer(GoogleApiClient apiClient) {
        return Games.d(apiClient).lj();
    }

    public String getCurrentPlayerId(GoogleApiClient apiClient) {
        return Games.d(apiClient).li();
    }

    public Intent getPlayerSearchIntent(GoogleApiClient apiClient) {
        return Games.d(apiClient).lt();
    }

    public PendingResult<LoadPlayersResult> loadConnectedPlayers(GoogleApiClient apiClient, final boolean forceReload) {
        return apiClient.a(new LoadPlayersImpl(this, apiClient) {
            final /* synthetic */ PlayersImpl aaZ;

            protected void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.a((b) this, forceReload);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadInvitablePlayers(GoogleApiClient apiClient, final int pageSize, final boolean forceReload) {
        return apiClient.a(new LoadPlayersImpl(this, apiClient) {
            final /* synthetic */ PlayersImpl aaZ;

            protected void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.a((b) this, pageSize, false, forceReload);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadMoreInvitablePlayers(GoogleApiClient apiClient, final int pageSize) {
        return apiClient.a(new LoadPlayersImpl(this, apiClient) {
            final /* synthetic */ PlayersImpl aaZ;

            protected void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.a((b) this, pageSize, true, false);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadMoreRecentlyPlayedWithPlayers(GoogleApiClient apiClient, final int pageSize) {
        return apiClient.a(new LoadPlayersImpl(this, apiClient) {
            final /* synthetic */ PlayersImpl aaZ;

            protected void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.a((b) this, "played_with", pageSize, true, false);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadPlayer(GoogleApiClient apiClient, final String playerId) {
        return apiClient.a(new LoadPlayersImpl(this, apiClient) {
            final /* synthetic */ PlayersImpl aaZ;

            protected void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.a((b) this, playerId, false);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadPlayer(GoogleApiClient apiClient, final String playerId, final boolean forceReload) {
        return apiClient.a(new LoadPlayersImpl(this, apiClient) {
            final /* synthetic */ PlayersImpl aaZ;

            protected void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.a((b) this, playerId, forceReload);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadRecentlyPlayedWithPlayers(GoogleApiClient apiClient, final int pageSize, final boolean forceReload) {
        return apiClient.a(new LoadPlayersImpl(this, apiClient) {
            final /* synthetic */ PlayersImpl aaZ;

            protected void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.a((b) this, "played_with", pageSize, false, forceReload);
            }
        });
    }
}
