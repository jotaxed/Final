package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.BaseImplementation.b;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.game.Acls;
import com.google.android.gms.games.internal.game.Acls.LoadAclResult;

public final class AclsImpl implements Acls {

    private static abstract class LoadNotifyAclImpl extends BaseGamesApiMethodImpl<LoadAclResult> {
        public LoadAclResult M(Status status) {
            return AclsImpl.K(status);
        }

        public /* synthetic */ Result c(Status status) {
            return M(status);
        }
    }

    class AnonymousClass2 extends LoadNotifyAclImpl {
        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.h(this);
        }
    }

    private static abstract class UpdateNotifyAclImpl extends BaseGamesApiMethodImpl<Status> {
        public Status b(Status status) {
            return status;
        }

        public /* synthetic */ Result c(Status status) {
            return b(status);
        }
    }

    class AnonymousClass3 extends UpdateNotifyAclImpl {
        final /* synthetic */ String aae;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.o((b) this, this.aae);
        }
    }

    private static LoadAclResult K(final Status status) {
        return new LoadAclResult() {
            public Status getStatus() {
                return status;
            }

            public void release() {
            }
        };
    }
}
