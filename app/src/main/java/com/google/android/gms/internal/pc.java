package com.google.android.gms.internal;

import com.google.android.gms.common.api.BaseImplementation.b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.internal.e;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.Collection;

public final class pc implements People {

    private static abstract class a extends com.google.android.gms.plus.Plus.a<LoadPeopleResult> {
        private a(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadPeopleResult aC(final Status status) {
            return new LoadPeopleResult(this) {
                final /* synthetic */ a aol;

                public String getNextPageToken() {
                    return null;
                }

                public PersonBuffer getPersonBuffer() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result c(Status status) {
            return aC(status);
        }
    }

    public Person getCurrentPerson(GoogleApiClient googleApiClient) {
        return Plus.a(googleApiClient, Plus.DQ).getCurrentPerson();
    }

    public PendingResult<LoadPeopleResult> load(GoogleApiClient googleApiClient, final Collection<String> personIds) {
        return googleApiClient.a(new a(this, googleApiClient) {
            final /* synthetic */ pc aoi;

            protected void a(e eVar) {
                eVar.a((b) this, personIds);
            }
        });
    }

    public PendingResult<LoadPeopleResult> load(GoogleApiClient googleApiClient, final String... personIds) {
        return googleApiClient.a(new a(this, googleApiClient) {
            final /* synthetic */ pc aoi;

            protected void a(e eVar) {
                eVar.d(this, personIds);
            }
        });
    }

    public PendingResult<LoadPeopleResult> loadConnected(GoogleApiClient googleApiClient) {
        return googleApiClient.a(new a(this, googleApiClient) {
            final /* synthetic */ pc aoi;

            protected void a(e eVar) {
                eVar.k(this);
            }
        });
    }

    public PendingResult<LoadPeopleResult> loadVisible(GoogleApiClient googleApiClient, final int orderBy, final String pageToken) {
        return googleApiClient.a(new a(this, googleApiClient) {
            final /* synthetic */ pc aoi;

            protected void a(e eVar) {
                a(eVar.a((b) this, orderBy, pageToken));
            }
        });
    }

    public PendingResult<LoadPeopleResult> loadVisible(GoogleApiClient googleApiClient, final String pageToken) {
        return googleApiClient.a(new a(this, googleApiClient) {
            final /* synthetic */ pc aoi;

            protected void a(e eVar) {
                a(eVar.q(this, pageToken));
            }
        });
    }
}
