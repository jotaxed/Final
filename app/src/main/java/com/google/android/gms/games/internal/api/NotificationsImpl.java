package com.google.android.gms.games.internal.api;

import android.os.Bundle;
import com.google.android.gms.common.api.BaseImplementation.b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.Notifications.ContactSettingLoadResult;
import com.google.android.gms.games.Notifications.GameMuteStatusChangeResult;
import com.google.android.gms.games.Notifications.GameMuteStatusLoadResult;
import com.google.android.gms.games.Notifications.InboxCountResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class NotificationsImpl implements Notifications {

    class AnonymousClass1 extends BaseGamesApiMethodImpl<GameMuteStatusChangeResult> {
        final /* synthetic */ String aaR;

        public GameMuteStatusChangeResult Y(final Status status) {
            return new GameMuteStatusChangeResult(this) {
                final /* synthetic */ AnonymousClass1 aaS;

                public Status getStatus() {
                    return status;
                }
            };
        }

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.e((b) this, this.aaR, true);
        }

        public /* synthetic */ Result c(Status status) {
            return Y(status);
        }
    }

    class AnonymousClass2 extends BaseGamesApiMethodImpl<GameMuteStatusChangeResult> {
        final /* synthetic */ String aaR;

        public GameMuteStatusChangeResult Y(final Status status) {
            return new GameMuteStatusChangeResult(this) {
                final /* synthetic */ AnonymousClass2 aaT;

                public Status getStatus() {
                    return status;
                }
            };
        }

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.e((b) this, this.aaR, false);
        }

        public /* synthetic */ Result c(Status status) {
            return Y(status);
        }
    }

    class AnonymousClass3 extends BaseGamesApiMethodImpl<GameMuteStatusLoadResult> {
        final /* synthetic */ String aaR;

        public GameMuteStatusLoadResult Z(final Status status) {
            return new GameMuteStatusLoadResult(this) {
                final /* synthetic */ AnonymousClass3 aaU;

                public Status getStatus() {
                    return status;
                }
            };
        }

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.p((b) this, this.aaR);
        }

        public /* synthetic */ Result c(Status status) {
            return Z(status);
        }
    }

    private static abstract class ContactSettingLoadImpl extends BaseGamesApiMethodImpl<ContactSettingLoadResult> {
        public ContactSettingLoadResult aa(final Status status) {
            return new ContactSettingLoadResult(this) {
                final /* synthetic */ ContactSettingLoadImpl aaX;

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result c(Status status) {
            return aa(status);
        }
    }

    class AnonymousClass4 extends ContactSettingLoadImpl {
        final /* synthetic */ boolean ZW;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.h((b) this, this.ZW);
        }
    }

    private static abstract class ContactSettingUpdateImpl extends BaseGamesApiMethodImpl<Status> {
        public Status b(Status status) {
            return status;
        }

        public /* synthetic */ Result c(Status status) {
            return b(status);
        }
    }

    class AnonymousClass5 extends ContactSettingUpdateImpl {
        final /* synthetic */ boolean aaV;
        final /* synthetic */ Bundle aaW;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.a((b) this, this.aaV, this.aaW);
        }
    }

    private static abstract class InboxCountImpl extends BaseGamesApiMethodImpl<InboxCountResult> {
        public InboxCountResult ab(final Status status) {
            return new InboxCountResult(this) {
                final /* synthetic */ InboxCountImpl aaY;

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result c(Status status) {
            return ab(status);
        }
    }

    class AnonymousClass6 extends InboxCountImpl {
        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.i(this);
        }
    }

    public void clear(GoogleApiClient apiClient, int notificationTypes) {
        Games.d(apiClient).dT(notificationTypes);
    }

    public void clearAll(GoogleApiClient apiClient) {
        clear(apiClient, 31);
    }
}
