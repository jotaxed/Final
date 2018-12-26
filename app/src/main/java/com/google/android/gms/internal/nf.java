package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

public class nf implements FusedLocationProviderApi {

    private static abstract class a extends com.google.android.gms.location.LocationServices.a<Status> {
        public a(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public Status b(Status status) {
            return status;
        }

        public /* synthetic */ Result c(Status status) {
            return b(status);
        }
    }

    public Location getLastLocation(GoogleApiClient client) {
        try {
            return LocationServices.f(client).nl();
        } catch (Exception e) {
            return null;
        }
    }

    public PendingResult<Status> removeLocationUpdates(GoogleApiClient client, final PendingIntent callbackIntent) {
        return client.b(new a(this, client) {
            final /* synthetic */ nf agH;

            protected void a(nk nkVar) throws RemoteException {
                nkVar.c(callbackIntent);
                b(Status.Kw);
            }
        });
    }

    public PendingResult<Status> removeLocationUpdates(GoogleApiClient client, final LocationListener listener) {
        return client.b(new a(this, client) {
            final /* synthetic */ nf agH;

            protected void a(nk nkVar) throws RemoteException {
                nkVar.a(listener);
                b(Status.Kw);
            }
        });
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient client, final LocationRequest request, final PendingIntent callbackIntent) {
        return client.b(new a(this, client) {
            final /* synthetic */ nf agH;

            protected void a(nk nkVar) throws RemoteException {
                nkVar.b(request, callbackIntent);
                b(Status.Kw);
            }
        });
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient client, final LocationRequest request, final LocationListener listener) {
        return client.b(new a(this, client) {
            final /* synthetic */ nf agH;

            protected void a(nk nkVar) throws RemoteException {
                nkVar.a(request, listener, null);
                b(Status.Kw);
            }
        });
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient client, LocationRequest request, LocationListener listener, Looper looper) {
        final LocationRequest locationRequest = request;
        final LocationListener locationListener = listener;
        final Looper looper2 = looper;
        return client.b(new a(this, client) {
            final /* synthetic */ nf agH;

            protected void a(nk nkVar) throws RemoteException {
                nkVar.a(locationRequest, locationListener, looper2);
                b(Status.Kw);
            }
        });
    }

    public PendingResult<Status> setMockLocation(GoogleApiClient client, final Location mockLocation) {
        return client.b(new a(this, client) {
            final /* synthetic */ nf agH;

            protected void a(nk nkVar) throws RemoteException {
                nkVar.b(mockLocation);
                b(Status.Kw);
            }
        });
    }

    public PendingResult<Status> setMockMode(GoogleApiClient client, final boolean isMockMode) {
        return client.b(new a(this, client) {
            final /* synthetic */ nf agH;

            protected void a(nk nkVar) throws RemoteException {
                nkVar.S(isMockMode);
                b(Status.Kw);
            }
        });
    }
}
