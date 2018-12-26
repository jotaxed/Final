package com.google.android.gms.internal;

import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Moments;
import com.google.android.gms.plus.Moments.LoadMomentsResult;
import com.google.android.gms.plus.internal.e;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;

public final class pb implements Moments {

    private static abstract class a extends com.google.android.gms.plus.Plus.a<LoadMomentsResult> {
        private a(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadMomentsResult aB(final Status status) {
            return new LoadMomentsResult(this) {
                final /* synthetic */ a aog;

                public MomentBuffer getMomentBuffer() {
                    return null;
                }

                public String getNextPageToken() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }

                public String getUpdated() {
                    return null;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result c(Status status) {
            return aB(status);
        }
    }

    private static abstract class c extends com.google.android.gms.plus.Plus.a<Status> {
        private c(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public Status b(Status status) {
            return status;
        }

        public /* synthetic */ Result c(Status status) {
            return b(status);
        }
    }

    private static abstract class b extends com.google.android.gms.plus.Plus.a<Status> {
        private b(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public Status b(Status status) {
            return status;
        }

        public /* synthetic */ Result c(Status status) {
            return b(status);
        }
    }

    public PendingResult<LoadMomentsResult> load(GoogleApiClient googleApiClient) {
        return googleApiClient.a(new a(this, googleApiClient) {
            final /* synthetic */ pb anZ;

            protected void a(e eVar) {
                eVar.j(this);
            }
        });
    }

    public PendingResult<LoadMomentsResult> load(GoogleApiClient googleApiClient, int maxResults, String pageToken, Uri targetUrl, String type, String userId) {
        final int i = maxResults;
        final String str = pageToken;
        final Uri uri = targetUrl;
        final String str2 = type;
        final String str3 = userId;
        return googleApiClient.a(new a(this, googleApiClient) {
            final /* synthetic */ pb anZ;

            protected void a(e eVar) {
                eVar.a(this, i, str, uri, str2, str3);
            }
        });
    }

    public PendingResult<Status> remove(GoogleApiClient googleApiClient, final String momentId) {
        return googleApiClient.b(new b(this, googleApiClient) {
            final /* synthetic */ pb anZ;

            protected void a(e eVar) {
                eVar.removeMoment(momentId);
                b(Status.Kw);
            }
        });
    }

    public PendingResult<Status> write(GoogleApiClient googleApiClient, final Moment moment) {
        return googleApiClient.b(new c(this, googleApiClient) {
            final /* synthetic */ pb anZ;

            protected void a(e eVar) {
                eVar.a((com.google.android.gms.common.api.BaseImplementation.b) this, moment);
            }
        });
    }
}
