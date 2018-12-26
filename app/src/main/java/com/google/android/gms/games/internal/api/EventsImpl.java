package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.BaseImplementation.b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.event.Events.LoadEventsResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class EventsImpl implements Events {

    private static abstract class LoadImpl extends BaseGamesApiMethodImpl<LoadEventsResult> {
        private LoadImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadEventsResult O(final Status status) {
            return new LoadEventsResult(this) {
                final /* synthetic */ LoadImpl aan;

                public EventBuffer getEvents() {
                    return new EventBuffer(DataHolder.av(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result c(Status status) {
            return O(status);
        }
    }

    private static abstract class UpdateImpl extends BaseGamesApiMethodImpl<Result> {
        private UpdateImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public Result c(final Status status) {
            return new Result(this) {
                final /* synthetic */ UpdateImpl aao;

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    public void increment(GoogleApiClient apiClient, final String eventId, final int incrementAmount) {
        GamesClientImpl e = Games.e(apiClient);
        if (e.isConnected()) {
            e.o(eventId, incrementAmount);
        } else {
            apiClient.b(new UpdateImpl(this, apiClient) {
                final /* synthetic */ EventsImpl aak;

                public void a(GamesClientImpl gamesClientImpl) {
                    gamesClientImpl.o(eventId, incrementAmount);
                }
            });
        }
    }

    public PendingResult<LoadEventsResult> load(GoogleApiClient apiClient, final boolean forceReload) {
        return apiClient.a(new LoadImpl(this, apiClient) {
            final /* synthetic */ EventsImpl aak;

            public void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.d((b) this, forceReload);
            }
        });
    }

    public PendingResult<LoadEventsResult> loadByIds(GoogleApiClient apiClient, final boolean forceReload, final String... eventIds) {
        return apiClient.a(new LoadImpl(this, apiClient) {
            final /* synthetic */ EventsImpl aak;

            public void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.a((b) this, forceReload, eventIds);
            }
        });
    }
}
