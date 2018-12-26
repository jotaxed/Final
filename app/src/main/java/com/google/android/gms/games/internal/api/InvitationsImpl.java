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
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;

public final class InvitationsImpl implements Invitations {

    private static abstract class LoadInvitationsImpl extends BaseGamesApiMethodImpl<LoadInvitationsResult> {
        private LoadInvitationsImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadInvitationsResult T(final Status status) {
            return new LoadInvitationsResult(this) {
                final /* synthetic */ LoadInvitationsImpl aaD;

                public InvitationBuffer getInvitations() {
                    return new InvitationBuffer(DataHolder.av(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result c(Status status) {
            return T(status);
        }
    }

    class AnonymousClass2 extends LoadInvitationsImpl {
        final /* synthetic */ String ZZ;
        final /* synthetic */ int aaA;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.e((b) this, this.ZZ, this.aaA);
        }
    }

    class AnonymousClass3 extends LoadInvitationsImpl {
        final /* synthetic */ String aaC;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.n((b) this, this.aaC);
        }
    }

    public Intent getInvitationInboxIntent(GoogleApiClient apiClient) {
        return Games.d(apiClient).lo();
    }

    public PendingResult<LoadInvitationsResult> loadInvitations(GoogleApiClient apiClient) {
        return loadInvitations(apiClient, 0);
    }

    public PendingResult<LoadInvitationsResult> loadInvitations(GoogleApiClient apiClient, final int sortOrder) {
        return apiClient.a(new LoadInvitationsImpl(this, apiClient) {
            final /* synthetic */ InvitationsImpl aaB;

            protected void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.c((b) this, sortOrder);
            }
        });
    }

    public void registerInvitationListener(GoogleApiClient apiClient, OnInvitationReceivedListener listener) {
        Games.d(apiClient).a(apiClient.d(listener));
    }

    public void unregisterInvitationListener(GoogleApiClient apiClient) {
        Games.d(apiClient).lp();
    }
}
