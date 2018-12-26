package com.afinal.libreria;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class MapStateManager {
    private static final String BEARING = "bearing";
    private static final String LATITUDE = "latitude";
    private static final String LONGITUDE = "longitude";
    private static final String MAPTYPE = "MAPTYPE";
    private static final String PREFS_NAME = "mapCameraState";
    private static final String TILT = "tilt";
    private static final String ZOOM = "zoom";
    private SharedPreferences mapStatePrefs;

    public MapStateManager(Context context) {
        this.mapStatePrefs = context.getSharedPreferences(PREFS_NAME, 0);
    }

    public void saveMapState(GoogleMap map) {
        Editor editor = this.mapStatePrefs.edit();
        CameraPosition position = map.getCameraPosition();
        editor.putFloat(LATITUDE, (float) position.target.latitude);
        editor.putFloat(LONGITUDE, (float) position.target.longitude);
        editor.putFloat(ZOOM, position.zoom);
        editor.putFloat(TILT, position.tilt);
        editor.putFloat(BEARING, position.bearing);
        editor.putInt(MAPTYPE, map.getMapType());
        editor.commit();
    }

    public CameraPosition getSavedCameraPosition() {
        double latitude = (double) this.mapStatePrefs.getFloat(LATITUDE, 0.0f);
        if (latitude == 0.0d) {
            return null;
        }
        return new CameraPosition(new LatLng(latitude, (double) this.mapStatePrefs.getFloat(LONGITUDE, 0.0f)), this.mapStatePrefs.getFloat(ZOOM, 0.0f), this.mapStatePrefs.getFloat(TILT, 0.0f), this.mapStatePrefs.getFloat(BEARING, 0.0f));
    }

    public int getSavedMapType() {
        return this.mapStatePrefs.getInt(MAPTYPE, 1);
    }
}
