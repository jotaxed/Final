package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.BaseImplementation.b;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.appcontent.AppContents;
import com.google.android.gms.games.appcontent.AppContents.LoadAppContentResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class AppContentsImpl implements AppContents {

    private static abstract class LoadsImpl extends BaseGamesApiMethodImpl<LoadAppContentResult> {
        public LoadAppContentResult N(final Status status) {
            return new LoadAppContentResult(this) {
                final /* synthetic */ LoadsImpl aai;

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result c(Status status) {
            return N(status);
        }
    }

    class AnonymousClass1 extends LoadsImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ int aaf;
        final /* synthetic */ String aag;
        final /* synthetic */ String[] aah;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.a((b) this, this.aaf, this.aag, this.aah, this.ZW);
        }
    }
}
