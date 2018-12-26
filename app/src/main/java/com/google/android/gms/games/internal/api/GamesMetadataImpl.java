package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.BaseImplementation.b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.GamesMetadata;
import com.google.android.gms.games.GamesMetadata.LoadExtendedGamesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameInstancesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameSearchSuggestionsResult;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class GamesMetadataImpl implements GamesMetadata {

    private static abstract class LoadExtendedGamesImpl extends BaseGamesApiMethodImpl<LoadExtendedGamesResult> {
        public LoadExtendedGamesResult P(final Status status) {
            return new LoadExtendedGamesResult(this) {
                final /* synthetic */ LoadExtendedGamesImpl aaw;

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result c(Status status) {
            return P(status);
        }
    }

    class AnonymousClass10 extends LoadExtendedGamesImpl {
        final /* synthetic */ String aaq;
        final /* synthetic */ int aar;
        final /* synthetic */ boolean aas;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.a((b) this, this.aaq, this.aar, false, true, false, this.aas);
        }
    }

    class AnonymousClass11 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ String ZY;
        final /* synthetic */ int aar;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.c(this, this.ZY, this.aar, false, this.ZW);
        }
    }

    class AnonymousClass12 extends LoadExtendedGamesImpl {
        final /* synthetic */ String ZY;
        final /* synthetic */ int aar;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.c(this, this.ZY, this.aar, true, false);
        }
    }

    class AnonymousClass13 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ String ZY;
        final /* synthetic */ int aar;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.d(this, this.ZY, this.aar, false, this.ZW);
        }
    }

    class AnonymousClass14 extends LoadExtendedGamesImpl {
        final /* synthetic */ String ZY;
        final /* synthetic */ int aar;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.d(this, this.ZY, this.aar, true, false);
        }
    }

    class AnonymousClass15 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ String aaq;
        final /* synthetic */ int aar;
        final /* synthetic */ boolean aas;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.a((b) this, this.aaq, this.aar, true, false, this.ZW, this.aas);
        }
    }

    class AnonymousClass16 extends LoadExtendedGamesImpl {
        final /* synthetic */ String aaq;
        final /* synthetic */ int aar;
        final /* synthetic */ boolean aas;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.a((b) this, this.aaq, this.aar, true, true, false, this.aas);
        }
    }

    class AnonymousClass17 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ int aar;
        final /* synthetic */ String aat;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.e(this, this.aat, this.aar, false, this.ZW);
        }
    }

    class AnonymousClass18 extends LoadExtendedGamesImpl {
        final /* synthetic */ int aar;
        final /* synthetic */ String aat;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.e(this, this.aat, this.aar, true, false);
        }
    }

    private static abstract class LoadGameSearchSuggestionsImpl extends BaseGamesApiMethodImpl<LoadGameSearchSuggestionsResult> {
        public LoadGameSearchSuggestionsResult R(final Status status) {
            return new LoadGameSearchSuggestionsResult(this) {
                final /* synthetic */ LoadGameSearchSuggestionsImpl aay;

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result c(Status status) {
            return R(status);
        }
    }

    class AnonymousClass19 extends LoadGameSearchSuggestionsImpl {
        final /* synthetic */ String aat;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.l(this, this.aat);
        }
    }

    private static abstract class LoadGamesImpl extends BaseGamesApiMethodImpl<LoadGamesResult> {
        private LoadGamesImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadGamesResult S(final Status status) {
            return new LoadGamesResult(this) {
                final /* synthetic */ LoadGamesImpl aaz;

                public GameBuffer getGames() {
                    return new GameBuffer(DataHolder.av(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result c(Status status) {
            return S(status);
        }
    }

    class AnonymousClass2 extends LoadExtendedGamesImpl {
        final /* synthetic */ String ZZ;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.j(this, this.ZZ);
        }
    }

    private static abstract class LoadGameInstancesImpl extends BaseGamesApiMethodImpl<LoadGameInstancesResult> {
        public LoadGameInstancesResult Q(final Status status) {
            return new LoadGameInstancesResult(this) {
                final /* synthetic */ LoadGameInstancesImpl aax;

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result c(Status status) {
            return Q(status);
        }
    }

    class AnonymousClass3 extends LoadGameInstancesImpl {
        final /* synthetic */ String ZZ;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.k(this, this.ZZ);
        }
    }

    class AnonymousClass4 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ int aar;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.b(this, null, this.aar, false, this.ZW);
        }
    }

    class AnonymousClass5 extends LoadExtendedGamesImpl {
        final /* synthetic */ int aar;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.b(this, null, this.aar, true, false);
        }
    }

    class AnonymousClass6 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ String ZY;
        final /* synthetic */ int aar;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.b(this, this.ZY, this.aar, false, this.ZW);
        }
    }

    class AnonymousClass7 extends LoadExtendedGamesImpl {
        final /* synthetic */ String ZY;
        final /* synthetic */ int aar;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.b(this, this.ZY, this.aar, true, false);
        }
    }

    class AnonymousClass8 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ int aar;
        final /* synthetic */ int aau;
        final /* synthetic */ boolean aav;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.a((b) this, this.aar, this.aau, this.aav, this.ZW);
        }
    }

    class AnonymousClass9 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ String aaq;
        final /* synthetic */ int aar;
        final /* synthetic */ boolean aas;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.a((b) this, this.aaq, this.aar, false, false, this.ZW, this.aas);
        }
    }

    public Game getCurrentGame(GoogleApiClient apiClient) {
        return Games.d(apiClient).lk();
    }

    public PendingResult<LoadGamesResult> loadGame(GoogleApiClient apiClient) {
        return apiClient.a(new LoadGamesImpl(this, apiClient) {
            final /* synthetic */ GamesMetadataImpl aap;

            protected void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.f(this);
            }
        });
    }
}
