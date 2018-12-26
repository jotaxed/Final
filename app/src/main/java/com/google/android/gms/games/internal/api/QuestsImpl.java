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
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.games.quest.Quests.AcceptQuestResult;
import com.google.android.gms.games.quest.Quests.ClaimMilestoneResult;
import com.google.android.gms.games.quest.Quests.LoadQuestsResult;

public final class QuestsImpl implements Quests {

    private static abstract class AcceptImpl extends BaseGamesApiMethodImpl<AcceptQuestResult> {
        private AcceptImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public AcceptQuestResult ah(final Status status) {
            return new AcceptQuestResult(this) {
                final /* synthetic */ AcceptImpl abq;

                public Quest getQuest() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result c(Status status) {
            return ah(status);
        }
    }

    private static abstract class ClaimImpl extends BaseGamesApiMethodImpl<ClaimMilestoneResult> {
        private ClaimImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public ClaimMilestoneResult ai(final Status status) {
            return new ClaimMilestoneResult(this) {
                final /* synthetic */ ClaimImpl abr;

                public Milestone getMilestone() {
                    return null;
                }

                public Quest getQuest() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result c(Status status) {
            return ai(status);
        }
    }

    private static abstract class LoadsImpl extends BaseGamesApiMethodImpl<LoadQuestsResult> {
        private LoadsImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadQuestsResult aj(final Status status) {
            return new LoadQuestsResult(this) {
                final /* synthetic */ LoadsImpl abs;

                public QuestBuffer getQuests() {
                    return new QuestBuffer(DataHolder.av(status.getStatusCode()));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result c(Status status) {
            return aj(status);
        }
    }

    class AnonymousClass5 extends LoadsImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ String ZZ;
        final /* synthetic */ int aaA;
        final /* synthetic */ int[] abn;
        final /* synthetic */ String abp;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.a((b) this, this.ZZ, this.abp, this.abn, this.aaA, this.ZW);
        }
    }

    class AnonymousClass6 extends LoadsImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ String ZZ;
        final /* synthetic */ String[] abo;
        final /* synthetic */ String abp;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.a((b) this, this.ZZ, this.abp, this.ZW, this.abo);
        }
    }

    public PendingResult<AcceptQuestResult> accept(GoogleApiClient apiClient, final String questId) {
        return apiClient.b(new AcceptImpl(this, apiClient) {
            final /* synthetic */ QuestsImpl abl;

            protected void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.h((b) this, questId);
            }
        });
    }

    public PendingResult<ClaimMilestoneResult> claim(GoogleApiClient apiClient, final String questId, final String milestoneId) {
        return apiClient.b(new ClaimImpl(this, apiClient) {
            final /* synthetic */ QuestsImpl abl;

            protected void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.b((b) this, questId, milestoneId);
            }
        });
    }

    public Intent getQuestIntent(GoogleApiClient apiClient, String questId) {
        return Games.d(apiClient).bE(questId);
    }

    public Intent getQuestsIntent(GoogleApiClient apiClient, int[] questSelectors) {
        return Games.d(apiClient).b(questSelectors);
    }

    public PendingResult<LoadQuestsResult> load(GoogleApiClient apiClient, int[] questSelectors, int sortOrder, boolean forceReload) {
        final int[] iArr = questSelectors;
        final int i = sortOrder;
        final boolean z = forceReload;
        return apiClient.a(new LoadsImpl(this, apiClient) {
            final /* synthetic */ QuestsImpl abl;

            protected void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.a((b) this, iArr, i, z);
            }
        });
    }

    public PendingResult<LoadQuestsResult> loadByIds(GoogleApiClient apiClient, final boolean forceReload, final String... questIds) {
        return apiClient.a(new LoadsImpl(this, apiClient) {
            final /* synthetic */ QuestsImpl abl;

            protected void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.b((b) this, forceReload, questIds);
            }
        });
    }

    public void registerQuestUpdateListener(GoogleApiClient apiClient, QuestUpdateListener listener) {
        Games.d(apiClient).c(apiClient.d(listener));
    }

    public void showStateChangedPopup(GoogleApiClient apiClient, String questId) {
        Games.d(apiClient).bF(questId);
    }

    public void unregisterQuestUpdateListener(GoogleApiClient apiClient) {
        Games.d(apiClient).lr();
    }
}
