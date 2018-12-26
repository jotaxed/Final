package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingApi;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.GeofencingRequest.Builder;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.location.c.b;
import java.util.List;

public class ng implements GeofencingApi {

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

    public PendingResult<Status> addGeofences(GoogleApiClient client, final GeofencingRequest geofencingRequest, final PendingIntent pendingIntent) {
        return client.b(new a(this, client) {
            final /* synthetic */ ng agN;

            protected void a(nk nkVar) throws RemoteException {
                nkVar.a(geofencingRequest, pendingIntent, new com.google.android.gms.location.c.a(this) {
                    final /* synthetic */ AnonymousClass1 agO;

                    {
                        this.agO = r1;
                    }

                    public void a(int i, String[] strArr) {
                        this.agO.b(LocationStatusCodes.eD(i));
                    }
                });
            }
        });
    }

    @Deprecated
    public PendingResult<Status> addGeofences(GoogleApiClient client, List<Geofence> geofences, PendingIntent pendingIntent) {
        Builder builder = new Builder();
        builder.addGeofences(geofences);
        builder.setInitialTrigger(5);
        return addGeofences(client, builder.build(), pendingIntent);
    }

    public PendingResult<Status> removeGeofences(GoogleApiClient client, final PendingIntent pendingIntent) {
        return client.b(new a(this, client) {
            final /* synthetic */ ng agN;

            protected void a(nk nkVar) throws RemoteException {
                nkVar.a(pendingIntent, new b(this) {
                    final /* synthetic */ AnonymousClass2 agP;

                    {
                        this.agP = r1;
                    }

                    public void a(int i, PendingIntent pendingIntent) {
                        this.agP.b(LocationStatusCodes.eD(i));
                    }

                    public void b(int i, String[] strArr) {
                        Log.wtf("GeofencingImpl", "Request ID callback shouldn't have been called");
                    }
                });
            }
        });
    }

    public PendingResult<Status> removeGeofences(GoogleApiClient client, final List<String> geofenceRequestIds) {
        return client.b(new a(this, client) {
            final /* synthetic */ ng agN;

            protected void a(nk nkVar) throws RemoteException {
                nkVar.a(geofenceRequestIds, new b(this) {
                    final /* synthetic */ AnonymousClass3 agR;

                    {
                        this.agR = r1;
                    }

                    public void a(int i, PendingIntent pendingIntent) {
                        Log.wtf("GeofencingImpl", "PendingIntent callback shouldn't have been called");
                    }

                    public void b(int i, String[] strArr) {
                        this.agR.b(LocationStatusCodes.eD(i));
                    }
                });
            }
        });
    }
}
