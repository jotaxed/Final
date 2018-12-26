package com.google.android.gms.location;

import android.content.Intent;
import android.location.Location;
import com.google.android.gms.internal.nn;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GeofencingEvent {
    private final int agl;
    private final List<Geofence> agm;
    private final Location agn;
    private final int tq;

    private GeofencingEvent(int errorCode, int transitionType, List<Geofence> triggeringGeofences, Location triggeringLocaton) {
        this.tq = errorCode;
        this.agl = transitionType;
        this.agm = triggeringGeofences;
        this.agn = triggeringLocaton;
    }

    public static GeofencingEvent fromIntent(Intent intent) {
        return intent == null ? null : new GeofencingEvent(intent.getIntExtra("gms_error_code", -1), k(intent), l(intent), (Location) intent.getParcelableExtra("com.google.android.location.intent.extra.triggering_location"));
    }

    private static int k(Intent intent) {
        int intExtra = intent.getIntExtra("com.google.android.location.intent.extra.transition", -1);
        return intExtra == -1 ? -1 : (intExtra == 1 || intExtra == 2 || intExtra == 4) ? intExtra : -1;
    }

    private static List<Geofence> l(Intent intent) {
        ArrayList arrayList = (ArrayList) intent.getSerializableExtra("com.google.android.location.intent.extra.geofence_list");
        if (arrayList == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(nn.h((byte[]) it.next()));
        }
        return arrayList2;
    }

    public int getErrorCode() {
        return this.tq;
    }

    public int getGeofenceTransition() {
        return this.agl;
    }

    public List<Geofence> getTriggeringGeofences() {
        return this.agm;
    }

    public Location getTriggeringLocation() {
        return this.agn;
    }

    public boolean hasError() {
        return this.tq != -1;
    }
}
