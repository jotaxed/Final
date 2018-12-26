package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.api.BaseImplementation.b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult;
import java.util.List;

public final class TurnBasedMultiplayerImpl implements TurnBasedMultiplayer {

    private static abstract class LoadMatchImpl extends BaseGamesApiMethodImpl<LoadMatchResult> {
        private LoadMatchImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadMatchResult av(final Status status) {
            return new LoadMatchResult(this) {
                final /* synthetic */ LoadMatchImpl acd;

                public TurnBasedMatch getMatch() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result c(Status status) {
            return av(status);
        }
    }

    private static abstract class InitiateMatchImpl extends BaseGamesApiMethodImpl<InitiateMatchResult> {
        private InitiateMatchImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public InitiateMatchResult at(final Status status) {
            return new InitiateMatchResult(this) {
                final /* synthetic */ InitiateMatchImpl acb;

                public TurnBasedMatch getMatch() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result c(Status status) {
            return at(status);
        }
    }

    class AnonymousClass11 extends InitiateMatchImpl {
        final /* synthetic */ String ZZ;
        final /* synthetic */ String abU;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.c((b) this, this.ZZ, this.abU);
        }
    }

    class AnonymousClass12 extends InitiateMatchImpl {
        final /* synthetic */ String ZZ;
        final /* synthetic */ String abU;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.d((b) this, this.ZZ, this.abU);
        }
    }

    private static abstract class LoadMatchesImpl extends BaseGamesApiMethodImpl<LoadMatchesResult> {
        private LoadMatchesImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadMatchesResult aw(final Status status) {
            return new LoadMatchesResult(this) {
                final /* synthetic */ LoadMatchesImpl ace;

                public LoadMatchesResponse getMatches() {
                    return new LoadMatchesResponse(new Bundle());
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result c(Status status) {
            return aw(status);
        }
    }

    class AnonymousClass13 extends LoadMatchesImpl {
        final /* synthetic */ String ZZ;
        final /* synthetic */ int abV;
        final /* synthetic */ int[] abW;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.a((b) this, this.ZZ, this.abV, this.abW);
        }
    }

    private static abstract class UpdateMatchImpl extends BaseGamesApiMethodImpl<UpdateMatchResult> {
        private UpdateMatchImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public UpdateMatchResult ax(final Status status) {
            return new UpdateMatchResult(this) {
                final /* synthetic */ UpdateMatchImpl acf;

                public TurnBasedMatch getMatch() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result c(Status status) {
            return ax(status);
        }
    }

    private static abstract class LeaveMatchImpl extends BaseGamesApiMethodImpl<LeaveMatchResult> {
        private LeaveMatchImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LeaveMatchResult au(final Status status) {
            return new LeaveMatchResult(this) {
                final /* synthetic */ LeaveMatchImpl acc;

                public TurnBasedMatch getMatch() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result c(Status status) {
            return au(status);
        }
    }

    private static abstract class CancelMatchImpl extends BaseGamesApiMethodImpl<CancelMatchResult> {
        private final String CE;

        public CancelMatchImpl(String id, GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.CE = id;
        }

        public CancelMatchResult as(final Status status) {
            return new CancelMatchResult(this) {
                final /* synthetic */ CancelMatchImpl aca;

                public String getMatchId() {
                    return this.aca.CE;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result c(Status status) {
            return as(status);
        }
    }

    public PendingResult<InitiateMatchResult> acceptInvitation(GoogleApiClient apiClient, final String invitationId) {
        return apiClient.b(new InitiateMatchImpl(this, apiClient) {
            final /* synthetic */ TurnBasedMultiplayerImpl abT;

            protected void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.d((b) this, invitationId);
            }
        });
    }

    public PendingResult<CancelMatchResult> cancelMatch(GoogleApiClient apiClient, final String matchId) {
        return apiClient.b(new CancelMatchImpl(this, apiClient, matchId) {
            final /* synthetic */ TurnBasedMultiplayerImpl abT;

            protected void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.f((b) this, matchId);
            }
        });
    }

    public PendingResult<InitiateMatchResult> createMatch(GoogleApiClient apiClient, final TurnBasedMatchConfig config) {
        return apiClient.b(new InitiateMatchImpl(this, apiClient) {
            final /* synthetic */ TurnBasedMultiplayerImpl abT;

            protected void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.a((b) this, config);
            }
        });
    }

    public void declineInvitation(GoogleApiClient apiClient, String invitationId) {
        Games.d(apiClient).q(invitationId, 1);
    }

    public void dismissInvitation(GoogleApiClient apiClient, String invitationId) {
        Games.d(apiClient).p(invitationId, 1);
    }

    public void dismissMatch(GoogleApiClient apiClient, String matchId) {
        Games.d(apiClient).bA(matchId);
    }

    public PendingResult<UpdateMatchResult> finishMatch(GoogleApiClient apiClient, String matchId) {
        return finishMatch(apiClient, matchId, null, (ParticipantResult[]) null);
    }

    public PendingResult<UpdateMatchResult> finishMatch(GoogleApiClient apiClient, String matchId, byte[] matchData, List<ParticipantResult> results) {
        return finishMatch(apiClient, matchId, matchData, results == null ? null : (ParticipantResult[]) results.toArray(new ParticipantResult[results.size()]));
    }

    public PendingResult<UpdateMatchResult> finishMatch(GoogleApiClient apiClient, String matchId, byte[] matchData, ParticipantResult... results) {
        final String str = matchId;
        final byte[] bArr = matchData;
        final ParticipantResult[] participantResultArr = results;
        return apiClient.b(new UpdateMatchImpl(this, apiClient) {
            final /* synthetic */ TurnBasedMultiplayerImpl abT;

            protected void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.a((b) this, str, bArr, participantResultArr);
            }
        });
    }

    public Intent getInboxIntent(GoogleApiClient apiClient) {
        return Games.d(apiClient).ln();
    }

    public int getMaxMatchDataSize(GoogleApiClient apiClient) {
        return Games.d(apiClient).lx();
    }

    public Intent getSelectOpponentsIntent(GoogleApiClient apiClient, int minPlayers, int maxPlayers) {
        return Games.d(apiClient).a(minPlayers, maxPlayers, true);
    }

    public Intent getSelectOpponentsIntent(GoogleApiClient apiClient, int minPlayers, int maxPlayers, boolean allowAutomatch) {
        return Games.d(apiClient).a(minPlayers, maxPlayers, allowAutomatch);
    }

    public PendingResult<LeaveMatchResult> leaveMatch(GoogleApiClient apiClient, final String matchId) {
        return apiClient.b(new LeaveMatchImpl(this, apiClient) {
            final /* synthetic */ TurnBasedMultiplayerImpl abT;

            protected void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.e((b) this, matchId);
            }
        });
    }

    public PendingResult<LeaveMatchResult> leaveMatchDuringTurn(GoogleApiClient apiClient, final String matchId, final String pendingParticipantId) {
        return apiClient.b(new LeaveMatchImpl(this, apiClient) {
            final /* synthetic */ TurnBasedMultiplayerImpl abT;

            protected void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.a((b) this, matchId, pendingParticipantId);
            }
        });
    }

    public PendingResult<LoadMatchResult> loadMatch(GoogleApiClient apiClient, final String matchId) {
        return apiClient.a(new LoadMatchImpl(this, apiClient) {
            final /* synthetic */ TurnBasedMultiplayerImpl abT;

            protected void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.g((b) this, matchId);
            }
        });
    }

    public PendingResult<LoadMatchesResult> loadMatchesByStatus(GoogleApiClient apiClient, final int invitationSortOrder, final int[] matchTurnStatuses) {
        return apiClient.a(new LoadMatchesImpl(this, apiClient) {
            final /* synthetic */ TurnBasedMultiplayerImpl abT;

            protected void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.a((b) this, invitationSortOrder, matchTurnStatuses);
            }
        });
    }

    public PendingResult<LoadMatchesResult> loadMatchesByStatus(GoogleApiClient apiClient, int[] matchTurnStatuses) {
        return loadMatchesByStatus(apiClient, 0, matchTurnStatuses);
    }

    public void registerMatchUpdateListener(GoogleApiClient apiClient, OnTurnBasedMatchUpdateReceivedListener listener) {
        Games.d(apiClient).b(apiClient.d(listener));
    }

    public PendingResult<InitiateMatchResult> rematch(GoogleApiClient apiClient, final String matchId) {
        return apiClient.b(new InitiateMatchImpl(this, apiClient) {
            final /* synthetic */ TurnBasedMultiplayerImpl abT;

            protected void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.c((b) this, matchId);
            }
        });
    }

    public PendingResult<UpdateMatchResult> takeTurn(GoogleApiClient apiClient, String matchId, byte[] matchData, String pendingParticipantId) {
        return takeTurn(apiClient, matchId, matchData, pendingParticipantId, (ParticipantResult[]) null);
    }

    public PendingResult<UpdateMatchResult> takeTurn(GoogleApiClient apiClient, String matchId, byte[] matchData, String pendingParticipantId, List<ParticipantResult> results) {
        return takeTurn(apiClient, matchId, matchData, pendingParticipantId, results == null ? null : (ParticipantResult[]) results.toArray(new ParticipantResult[results.size()]));
    }

    public PendingResult<UpdateMatchResult> takeTurn(GoogleApiClient apiClient, String matchId, byte[] matchData, String pendingParticipantId, ParticipantResult... results) {
        final String str = matchId;
        final byte[] bArr = matchData;
        final String str2 = pendingParticipantId;
        final ParticipantResult[] participantResultArr = results;
        return apiClient.b(new UpdateMatchImpl(this, apiClient) {
            final /* synthetic */ TurnBasedMultiplayerImpl abT;

            protected void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.a((b) this, str, bArr, str2, participantResultArr);
            }
        });
    }

    public void unregisterMatchUpdateListener(GoogleApiClient apiClient) {
        Games.d(apiClient).lq();
    }
}
