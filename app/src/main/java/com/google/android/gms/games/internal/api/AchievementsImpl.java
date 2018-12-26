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
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class AchievementsImpl implements Achievements {

    private static abstract class LoadImpl extends BaseGamesApiMethodImpl<LoadAchievementsResult> {
        private LoadImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadAchievementsResult I(final Status status) {
            return new LoadAchievementsResult(this) {
                final /* synthetic */ LoadImpl aac;

                public AchievementBuffer getAchievements() {
                    return new AchievementBuffer(DataHolder.av(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result c(Status status) {
            return I(status);
        }
    }

    class AnonymousClass10 extends LoadImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ String ZY;
        final /* synthetic */ String ZZ;

        public void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.b((b) this, this.ZY, this.ZZ, this.ZW);
        }
    }

    private static abstract class UpdateImpl extends BaseGamesApiMethodImpl<UpdateAchievementResult> {
        private final String CE;

        public UpdateImpl(String id, GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.CE = id;
        }

        public UpdateAchievementResult J(final Status status) {
            return new UpdateAchievementResult(this) {
                final /* synthetic */ UpdateImpl aad;

                public String getAchievementId() {
                    return this.aad.CE;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result c(Status status) {
            return J(status);
        }
    }

    public Intent getAchievementsIntent(GoogleApiClient apiClient) {
        return Games.d(apiClient).lm();
    }

    public void increment(GoogleApiClient apiClient, String id, int numSteps) {
        final String str = id;
        final int i = numSteps;
        apiClient.b(new UpdateImpl(this, id, apiClient) {
            final /* synthetic */ AchievementsImpl ZX;

            public void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.a(null, str, i);
            }
        });
    }

    public PendingResult<UpdateAchievementResult> incrementImmediate(GoogleApiClient apiClient, String id, int numSteps) {
        final String str = id;
        final int i = numSteps;
        return apiClient.b(new UpdateImpl(this, id, apiClient) {
            final /* synthetic */ AchievementsImpl ZX;

            public void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.a((b) this, str, i);
            }
        });
    }

    public PendingResult<LoadAchievementsResult> load(GoogleApiClient apiClient, final boolean forceReload) {
        return apiClient.a(new LoadImpl(this, apiClient) {
            final /* synthetic */ AchievementsImpl ZX;

            public void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.c((b) this, forceReload);
            }
        });
    }

    public void reveal(GoogleApiClient apiClient, final String id) {
        apiClient.b(new UpdateImpl(this, apiClient, id) {
            final /* synthetic */ AchievementsImpl ZX;

            public void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.a(null, id);
            }
        });
    }

    public PendingResult<UpdateAchievementResult> revealImmediate(GoogleApiClient apiClient, final String id) {
        return apiClient.b(new UpdateImpl(this, apiClient, id) {
            final /* synthetic */ AchievementsImpl ZX;

            public void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.a((b) this, id);
            }
        });
    }

    public void setSteps(GoogleApiClient apiClient, String id, int numSteps) {
        final String str = id;
        final int i = numSteps;
        apiClient.b(new UpdateImpl(this, id, apiClient) {
            final /* synthetic */ AchievementsImpl ZX;

            public void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.b(null, str, i);
            }
        });
    }

    public PendingResult<UpdateAchievementResult> setStepsImmediate(GoogleApiClient apiClient, String id, int numSteps) {
        final String str = id;
        final int i = numSteps;
        return apiClient.b(new UpdateImpl(this, id, apiClient) {
            final /* synthetic */ AchievementsImpl ZX;

            public void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.b((b) this, str, i);
            }
        });
    }

    public void unlock(GoogleApiClient apiClient, final String id) {
        apiClient.b(new UpdateImpl(this, apiClient, id) {
            final /* synthetic */ AchievementsImpl ZX;

            public void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.b(null, id);
            }
        });
    }

    public PendingResult<UpdateAchievementResult> unlockImmediate(GoogleApiClient apiClient, final String id) {
        return apiClient.b(new UpdateImpl(this, apiClient, id) {
            final /* synthetic */ AchievementsImpl ZX;

            public void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.b((b) this, id);
            }
        });
    }
}
