package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.google.android.gms.common.api.BaseImplementation.b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.games.request.Requests.LoadRequestSummariesResult;
import com.google.android.gms.games.request.Requests.LoadRequestsResult;
import com.google.android.gms.games.request.Requests.SendRequestResult;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class RequestsImpl implements Requests {

    private static abstract class UpdateRequestsImpl extends BaseGamesApiMethodImpl<UpdateRequestsResult> {
        private UpdateRequestsImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public UpdateRequestsResult an(final Status status) {
            return new UpdateRequestsResult(this) {
                final /* synthetic */ UpdateRequestsImpl abE;

                public Set<String> getRequestIds() {
                    return null;
                }

                public int getRequestOutcome(String requestId) {
                    throw new IllegalArgumentException("Unknown request ID " + requestId);
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result c(Status status) {
            return an(status);
        }
    }

    private static abstract class LoadRequestsImpl extends BaseGamesApiMethodImpl<LoadRequestsResult> {
        private LoadRequestsImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadRequestsResult al(final Status status) {
            return new LoadRequestsResult(this) {
                final /* synthetic */ LoadRequestsImpl abC;

                public GameRequestBuffer getRequests(int type) {
                    return new GameRequestBuffer(DataHolder.av(status.getStatusCode()));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result c(Status status) {
            return al(status);
        }
    }

    private static abstract class SendRequestImpl extends BaseGamesApiMethodImpl<SendRequestResult> {
        public SendRequestResult am(final Status status) {
            return new SendRequestResult(this) {
                final /* synthetic */ SendRequestImpl abD;

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result c(Status status) {
            return am(status);
        }
    }

    class AnonymousClass4 extends SendRequestImpl {
        final /* synthetic */ String ZZ;
        final /* synthetic */ int abA;
        final /* synthetic */ String[] abx;
        final /* synthetic */ int aby;
        final /* synthetic */ byte[] abz;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.a((b) this, this.ZZ, this.abx, this.aby, this.abz, this.abA);
        }
    }

    class AnonymousClass5 extends SendRequestImpl {
        final /* synthetic */ String ZZ;
        final /* synthetic */ int abA;
        final /* synthetic */ String[] abx;
        final /* synthetic */ int aby;
        final /* synthetic */ byte[] abz;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.a((b) this, this.ZZ, this.abx, this.aby, this.abz, this.abA);
        }
    }

    class AnonymousClass6 extends UpdateRequestsImpl {
        final /* synthetic */ String ZZ;
        final /* synthetic */ String abp;
        final /* synthetic */ String[] abt;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.a((b) this, this.ZZ, this.abp, this.abt);
        }
    }

    class AnonymousClass7 extends LoadRequestsImpl {
        final /* synthetic */ String ZZ;
        final /* synthetic */ int aaA;
        final /* synthetic */ String abp;
        final /* synthetic */ int abv;
        final /* synthetic */ int abw;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.a((b) this, this.ZZ, this.abp, this.abv, this.abw, this.aaA);
        }
    }

    private static abstract class LoadRequestSummariesImpl extends BaseGamesApiMethodImpl<LoadRequestSummariesResult> {
        public LoadRequestSummariesResult ak(final Status status) {
            return new LoadRequestSummariesResult(this) {
                final /* synthetic */ LoadRequestSummariesImpl abB;

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result c(Status status) {
            return ak(status);
        }
    }

    class AnonymousClass8 extends LoadRequestSummariesImpl {
        final /* synthetic */ String abp;
        final /* synthetic */ int abw;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.f(this, this.abp, this.abw);
        }
    }

    public PendingResult<UpdateRequestsResult> acceptRequest(GoogleApiClient apiClient, String requestId) {
        List arrayList = new ArrayList();
        arrayList.add(requestId);
        return acceptRequests(apiClient, arrayList);
    }

    public PendingResult<UpdateRequestsResult> acceptRequests(GoogleApiClient apiClient, List<String> requestIds) {
        final String[] strArr = requestIds == null ? null : (String[]) requestIds.toArray(new String[requestIds.size()]);
        return apiClient.b(new UpdateRequestsImpl(this, apiClient) {
            final /* synthetic */ RequestsImpl abu;

            protected void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.b((b) this, strArr);
            }
        });
    }

    public PendingResult<UpdateRequestsResult> dismissRequest(GoogleApiClient apiClient, String requestId) {
        List arrayList = new ArrayList();
        arrayList.add(requestId);
        return dismissRequests(apiClient, arrayList);
    }

    public PendingResult<UpdateRequestsResult> dismissRequests(GoogleApiClient apiClient, List<String> requestIds) {
        final String[] strArr = requestIds == null ? null : (String[]) requestIds.toArray(new String[requestIds.size()]);
        return apiClient.b(new UpdateRequestsImpl(this, apiClient) {
            final /* synthetic */ RequestsImpl abu;

            protected void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.c((b) this, strArr);
            }
        });
    }

    public ArrayList<GameRequest> getGameRequestsFromBundle(Bundle extras) {
        if (extras == null || !extras.containsKey(Requests.EXTRA_REQUESTS)) {
            return new ArrayList();
        }
        ArrayList arrayList = (ArrayList) extras.get(Requests.EXTRA_REQUESTS);
        ArrayList<GameRequest> arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList2.add((GameRequest) arrayList.get(i));
        }
        return arrayList2;
    }

    public ArrayList<GameRequest> getGameRequestsFromInboxResponse(Intent response) {
        return response == null ? new ArrayList() : getGameRequestsFromBundle(response.getExtras());
    }

    public Intent getInboxIntent(GoogleApiClient apiClient) {
        return Games.d(apiClient).ly();
    }

    public int getMaxLifetimeDays(GoogleApiClient apiClient) {
        return Games.d(apiClient).lA();
    }

    public int getMaxPayloadSize(GoogleApiClient apiClient) {
        return Games.d(apiClient).lz();
    }

    public Intent getSendIntent(GoogleApiClient apiClient, int type, byte[] payload, int requestLifetimeDays, Bitmap icon, String description) {
        return Games.d(apiClient).a(type, payload, requestLifetimeDays, icon, description);
    }

    public PendingResult<LoadRequestsResult> loadRequests(GoogleApiClient apiClient, int requestDirection, int types, int sortOrder) {
        final int i = requestDirection;
        final int i2 = types;
        final int i3 = sortOrder;
        return apiClient.a(new LoadRequestsImpl(this, apiClient) {
            final /* synthetic */ RequestsImpl abu;

            protected void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.a((b) this, i, i2, i3);
            }
        });
    }

    public void registerRequestListener(GoogleApiClient apiClient, OnRequestReceivedListener listener) {
        Games.d(apiClient).d(apiClient.d(listener));
    }

    public void unregisterRequestListener(GoogleApiClient apiClient) {
        Games.d(apiClient).ls();
    }
}
