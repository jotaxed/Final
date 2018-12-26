package com.afinal;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.CancelableCallback;
import com.google.android.gms.maps.GoogleMap.OnCameraChangeListener;
import com.google.android.gms.maps.GoogleMap.OnMyLocationButtonClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.afinal.db.PeajesDataSource;
import com.afinal.libreria.FuncionesComunes;
import com.afinal.libreria.Preferencias;
import com.afinal.libreria.Recorrido;
import com.afinal.libreria.Temporal;
import com.afinal.libreria.Tramo;
import com.afinal.libreria.peajeMarker;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends FragmentActivity implements ConnectionCallbacks, OnConnectionFailedListener, LocationListener {
    private static final int CONNECTION_FAILURE_RESOLUTION_REQUEST = 9002;
    private static final float DEFAULTZOOM = 15.0f;
    private static final int GPS_ERRORDIALOG_REQUEST = 9001;
    private static final String LOGTAG = "MainActivity";
    private AdView adView = null;
    MediaPlayer beep;
    Marker currentLocation;
    PeajesDataSource datasource;
    FuncionesComunes fc = new FuncionesComunes();
    String fecha_inicio = null;
    String fecha_termino = null;
    int flag_anuncio = 0;
    int flag_fantasma = 0;
    int id_vehiculo;
    double lat_anterior = 0.0d;
    double latitud;
    LinearLayout layoutAdMob;
    double lng_anterior = 0.0d;
    double longitud;
    GoogleApiClient mGoogleApiClient;
    GoogleMap mMap;
    Marker marker;
    private boolean nextCameraChangeIsManual;
    float precioTotalRecorrido = 0.0f;
    List<Temporal> temporales = new ArrayList();
    int tipo_vehiculo;
    String ultimoPeaje;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("MAIN", "oncreate");
        setTitle(new Preferencias(this).getItemSeleccionado());
        Intent intent = getIntent();
        this.id_vehiculo = intent.getIntExtra("id_vehiculo", 0);
        this.tipo_vehiculo = intent.getIntExtra("tipo_vehiculo", 0);
        if (this.id_vehiculo != 0) {
            setResult(1);
        }
        this.datasource = new PeajesDataSource(this);
        this.datasource.openDB();
        List<peajeMarker> peajesMarker = this.datasource.findAll();
        this.datasource.closeDB();
        peajesMarker.size();
        if (servicesOK()) {
            setContentView(R.layout.activity_map);
            if (initMap()) {
                this.mMap.setMyLocationEnabled(true);
                this.mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-33.466906d, -70.679229d), 11.0f));
                this.mGoogleApiClient = new Builder(this).addApi(LocationServices.API).addConnectionCallbacks(this).addOnConnectionFailedListener(this).build();
                this.mGoogleApiClient.connect();
                this.fecha_inicio = obtenerDatetime();
                if (peajesMarker.size() != 0) {
                    for (int i = 0; i < peajesMarker.size(); i++) {
                        String nombrePeaje = ((peajeMarker) peajesMarker.get(i)).getNombrePeaje();
                        String nombreAutopista = ((peajeMarker) peajesMarker.get(i)).getNombreAutopista();
                        double latitud = Double.valueOf(((peajeMarker) peajesMarker.get(i)).getLatitud()).doubleValue();
                        double longitud = ((peajeMarker) peajesMarker.get(i)).getLongitud();
                        if (!nombrePeaje.equals("FFF")) {
                            setMarker(nombrePeaje, latitud, longitud, nombreAutopista);
                        }
                    }
                }
            } else {
                Toast.makeText(this, "¡Mapa no disponible!", 0).show();
            }
        }
        getWindow().addFlags(128);
        this.layoutAdMob = (LinearLayout) findViewById(R.id.layoutAdmob);
        agregarAdView();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean servicesOK() {
        int isAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (isAvailable == 0) {
            return true;
        }
        if (GooglePlayServicesUtil.isUserRecoverableError(isAvailable)) {
            GooglePlayServicesUtil.getErrorDialog(isAvailable, this, GPS_ERRORDIALOG_REQUEST).show();
            return false;
        }
        Toast.makeText(this, "No es posible conectarse con Google Play services", 0).show();
        return false;
    }

    private boolean initMap() {
        if (this.mMap == null) {
            this.mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
            if (this.mMap != null) {
                this.mMap.setOnMyLocationButtonClickListener(new OnMyLocationButtonClickListener() {
                    public boolean onMyLocationButtonClick() {
                        MainActivity.this.nextCameraChangeIsManual = false;
                        return false;
                    }
                });
                this.mMap.setOnCameraChangeListener(new OnCameraChangeListener() {
                    public void onCameraChange(CameraPosition arg0) {
                    }
                });
            }
        }
        return this.mMap != null;
    }

    private void gotoLocation(double lat, double lng, float zoom) {
        this.mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat, lng), zoom));
    }

    public void geoLocate(View v) throws IOException {
        String location = ((TextView) findViewById(R.id.tvTotalAcumulado)).getText().toString();
        if (location.length() == 0) {
            Toast.makeText(this, "Please enter a location", 0).show();
            return;
        }
        hideSoftKeyboard(v);
        Address add = (Address) new Geocoder(this).getFromLocationName(location, 1).get(0);
        Toast.makeText(this, add.getLocality(), 1).show();
        gotoLocation(add.getLatitude(), add.getLongitude(), DEFAULTZOOM);
    }

    private void hideSoftKeyboard(View v) {
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 16908332:
                crearAlerta();
                break;
            case R.id.detenerRecorrido /*2131492950*/:
                crearAlerta();
                break;
            case R.id.guardarRecorrido /*2131492951*/:
                if (this.temporales.size() != 0) {
                    removeLocationUpdate();
                    stopBeep();
                    this.fecha_termino = obtenerDatetime();
                    int id_recorrido = (int) crearRecorrido(this.id_vehiculo);
                    JSONArray jsonArray = new JSONArray();
                    JSONObject jsonObjectRecorrido = new JSONObject();
                    JSONObject jsonObjectTramo = new JSONObject();
                    try {
                        jsonObjectRecorrido.put("fecha", this.fecha_inicio);
                        jsonObjectRecorrido.put("total", (double) this.precioTotalRecorrido);
                        jsonObjectRecorrido.put("plataforma", "2");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    Log.w(LOGTAG, "json:" + jsonObjectRecorrido.toString());
                    jsonArray.put(jsonObjectRecorrido);
                    for (int i = 0; i < this.temporales.size(); i++) {
                        int id_peaje = ((Temporal) this.temporales.get(i)).getId_peaje();
                        Log.i(LOGTAG, "id_peaje: " + id_peaje);
                        crearTramo(((Temporal) this.temporales.get(i)).getId_peaje(), ((Temporal) this.temporales.get(i)).getPrecio(), ((Temporal) this.temporales.get(i)).getFecha(), id_recorrido);
                        try {
                            jsonObjectTramo.put("horario", ((Temporal) this.temporales.get(i)).getFecha());
                            jsonObjectTramo.put("id_peaje", id_peaje);
                            jsonObjectTramo.put("precio", (double) ((Temporal) this.temporales.get(i)).getPrecio());
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        Log.w(LOGTAG, "json:" + jsonObjectTramo.toString());
                        jsonArray.put(jsonObjectTramo);
                    }
                    String jsonString = jsonArray.toString();
                    Log.w(LOGTAG, "jsonString: " + jsonString);
                    this.fc.enviarJson(jsonString);
                    String total = String.valueOf(roundToTwo(this.precioTotalRecorrido));
                    this.datasource.openDB();
                    if (this.datasource.actualizarRecorrido((long) id_recorrido, total, this.fecha_inicio, this.fecha_termino)) {
                        Toast.makeText(this, "Recorrido guardado.", 0).show();
                        finish();
                    } else {
                        Toast.makeText(this, "Error al guardar el recorrido.", 0).show();
                        finish();
                    }
                    this.datasource.closeDB();
                    getWindow().clearFlags(128);
                    break;
                }
                Toast.makeText(this, "No es posible guardar el recorrido porque no has pasado por ningún peaje.", 0).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void onStop() {
        super.onStop();
        Log.i("MAIN", "onStop");
    }

    public void removeLocationUpdate() {
        if (this.mGoogleApiClient.isConnected()) {
            Log.i("Ubicacion", "remmoviendo LocationUpdates");
            LocationServices.FusedLocationApi.removeLocationUpdates(this.mGoogleApiClient, (LocationListener) this);
        }
        this.mGoogleApiClient.disconnect();
    }

    protected void onResume() {
        super.onResume();
        Log.i("MAIN", "onResume");
    }

    protected void onPause() {
        super.onPause();
        Log.i("MAIN", "onPAUSE");
    }

    protected void gotoCurrentLocation() {
        Location currentLocation = LocationServices.FusedLocationApi.getLastLocation(this.mGoogleApiClient);
        if (currentLocation == null) {
            Toast.makeText(this, "Current location isn't available", 0).show();
            return;
        }
        this.mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude()), DEFAULTZOOM));
    }

    public void onConnectionFailed(ConnectionResult arg0) {
    }

    public void onConnected(Bundle arg0) {
        LocationRequest request = LocationRequest.create();
        request.setPriority(100);
        request.setInterval(1000);
        request.setFastestInterval(1000);
        LocationServices.FusedLocationApi.requestLocationUpdates(this.mGoogleApiClient, request, (LocationListener) this);
    }

    public void onLocationChanged(Location location) {
        if (location == null) {
            Toast.makeText(this, "No es posible obtener su ubicación actual", 0).show();
            return;
        }
        if (this.lat_anterior == 0.0d) {
            this.lat_anterior = location.getLatitude();
            this.lng_anterior = location.getLongitude();
        }
        this.latitud = location.getLatitude();
        this.longitud = location.getLongitude();
        calcular();
        float bearing = location.getBearing();
        this.lat_anterior = this.latitud;
        this.lng_anterior = this.longitud;
        Log.d("Ubicacion actual", "Ubicación actual: " + this.latitud + "," + this.longitud);
        CameraUpdate update = CameraUpdateFactory.newCameraPosition(new CameraPosition(new LatLng(this.latitud, this.longitud), 17.0f, 67.5f, bearing));
        if (!this.nextCameraChangeIsManual) {
            this.mMap.animateCamera(update, new CancelableCallback() {
                public void onFinish() {
                    MainActivity.this.nextCameraChangeIsManual = false;
                }

                public void onCancel() {
                    MainActivity.this.nextCameraChangeIsManual = true;
                }
            });
        }
    }

    private void setMarker(String nombrePeaje, double lat, double lng, String nombreAutopista) {
        this.marker = this.mMap.addMarker(new MarkerOptions().title(nombrePeaje).snippet(nombreAutopista).position(new LatLng(lat, lng)).icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_icono_peaje)));
    }

    public String obtenerFechaActual() {
        Calendar calendar = Calendar.getInstance();
        int anho = calendar.get(1);
        String mes = String.valueOf(Calendar.getInstance().get(2) + 1);
        if (Integer.valueOf(mes).intValue() < 10) {
            mes = "0" + mes;
        }
        String dia = String.valueOf(calendar.get(5));
        if (Integer.valueOf(dia).intValue() < 10) {
            dia = "0" + dia;
        }
        return new StringBuilder(String.valueOf(anho)).append("-").append(mes).append("-").append(dia).toString();
    }

    public String obtenerDatetime() {
        Calendar calendar = Calendar.getInstance();
        String hora = String.valueOf(calendar.get(11));
        String minutos = String.valueOf(calendar.get(12));
        String segundos = String.valueOf(calendar.get(13));
        if (Integer.valueOf(hora).intValue() < 10) {
            hora = "0" + hora;
        }
        if (Integer.valueOf(minutos).intValue() < 10) {
            minutos = "0" + minutos;
        }
        if (Integer.valueOf(segundos).intValue() < 10) {
            segundos = "0" + segundos;
        }
        String time = new StringBuilder(String.valueOf(hora)).append(":").append(minutos).append(":").append(segundos).toString();
        int anho = calendar.get(1);
        String mes = String.valueOf(Calendar.getInstance().get(2) + 1);
        if (Integer.valueOf(mes).intValue() < 10) {
            mes = "0" + mes;
        }
        String dia = String.valueOf(calendar.get(5));
        if (Integer.valueOf(dia).intValue() < 10) {
            dia = "0" + dia;
        }
        return new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(anho)).append("-").append(mes).append("-").append(dia).toString())).append(" ").append(time).toString();
    }

    public float roundToTwo(float num) {
        return (float) (((double) Math.round(((double) num) * 100.0d)) / 100.0d);
    }

    public double calcularAngulo(double lat_anterior, double lng_anterior, double lat_actual, double lng_actual) {
        double angulo = (180.0d * Math.atan2(lat_actual - lat_anterior, lng_actual - lng_anterior)) / 3.141592653589793d;
        if (angulo < 0.0d) {
            angulo += 360.0d;
        }
        return angulo + 360.0d;
    }

    public String obtenerHora() {
        int hora = Calendar.getInstance().get(11);
        String horario = "";
        if (hora == 0) {
            horario = "cero";
        }
        if (hora == 1) {
            horario = "una";
        }
        if (hora == 2) {
            horario = "dos";
        }
        if (hora == 3) {
            horario = "tres";
        }
        if (hora == 4) {
            horario = "cuatro";
        }
        if (hora == 5) {
            horario = "cinco";
        }
        if (hora == 6) {
            horario = "seis";
        }
        if (hora == 7) {
            horario = "siete";
        }
        if (hora == 8) {
            horario = "ocho";
        }
        if (hora == 9) {
            horario = "nueve";
        }
        if (hora == 10) {
            horario = "diez";
        }
        if (hora == 11) {
            horario = "once";
        }
        if (hora == 12) {
            horario = "doce";
        }
        if (hora == 13) {
            horario = "trece";
        }
        if (hora == 14) {
            horario = "catorce";
        }
        if (hora == 15) {
            horario = "quince";
        }
        if (hora == 16) {
            horario = "dieciseis";
        }
        if (hora == 17) {
            horario = "diecisiete";
        }
        if (hora == 18) {
            horario = "dieciocho";
        }
        if (hora == 19) {
            horario = "diecinueve";
        }
        if (hora == 20) {
            horario = "veinte";
        }
        if (hora == 21) {
            horario = "veintiuna";
        }
        if (hora == 22) {
            horario = "veintidos";
        }
        if (hora == 23) {
            horario = "veintitres";
        }
        if (hora == 24) {
            return "veinticuatro";
        }
        return horario;
    }

    public String obtenerTipoDia() {
        String fechaActual = obtenerFechaActual();
        int dia = Calendar.getInstance().get(7);
        this.datasource.openDB();
        List<String> feriados = this.datasource.obtenerFeriados();
        this.datasource.closeDB();
        if (feriados.size() != 0) {
            for (int i = 0; i < feriados.size(); i++) {
                if (((String) feriados.get(i)).equals(fechaActual)) {
                    return "festivo";
                }
            }
        }
        if (dia == 7) {
            return "sabado";
        }
        if (dia == 1) {
            return "domingo";
        }
        return "laboral";
    }

    public String obtenerMinutos() {
        if (Integer.valueOf(String.valueOf(Calendar.getInstance().get(12))).intValue() < 30) {
            return "";
        }
        return "treinta";
    }

    public void calcular() {
        String peajeFantasma = "FFF";
        String tipodia = obtenerTipoDia();
        String minutos = obtenerMinutos();
        Log.i("Feriado", "minutos: " + minutos);
        String hora = obtenerHora();
        Log.i("Feriado", "hora: " + hora);
        String datetime = obtenerDatetime();
        double angulo = calcularAngulo(this.lat_anterior, this.lng_anterior, this.latitud, this.longitud);
        String nombrePeaje = "";
        String distancia = "";
        String id_autopista = "";
        String nombreAutopista = "";
        String horario = "";
        String id_peaje = "";
        String tiempo = new StringBuilder(String.valueOf(hora)).append(minutos).toString();
        this.datasource.openDB();
        List<String> peajes = this.datasource.obtenerPeajes(tiempo, this.latitud, this.longitud, angulo, tipodia);
        this.datasource.closeDB();
        if (peajes.size() != 0) {
            for (int i = 0; i < peajes.size(); i++) {
                if (i == 0) {
                    nombrePeaje = (String) peajes.get(i);
                }
                if (i == 1) {
                    distancia = (String) peajes.get(i);
                }
                if (i == 2) {
                    id_autopista = (String) peajes.get(i);
                }
                if (i == 3) {
                    horario = (String) peajes.get(i);
                }
                if (i == 4) {
                    id_peaje = ((String) peajes.get(i)).toString();
                }
                if (i == 5) {
                    nombreAutopista = (String) peajes.get(i);
                }
            }
            if (!nombrePeaje.equals(this.ultimoPeaje)) {
                this.ultimoPeaje = nombrePeaje;
                if (nombrePeaje.equals(peajeFantasma)) {
                    this.flag_fantasma = 1;
                    return;
                }
                if (this.flag_fantasma == 1) {
                    if (nombrePeaje.equals("PA15 N-S")) {
                        this.flag_fantasma = 0;
                        return;
                    }
                }
                if (this.flag_fantasma == 0) {
                    if (nombrePeaje.equals("P5 P-O")) {
                        this.flag_fantasma = 0;
                        return;
                    }
                }
                this.datasource.openDB();
                float tarifaPeaje = this.datasource.obtenerTarifa(id_autopista, horario, this.tipo_vehiculo);
                this.datasource.closeDB();
                Log.i("main", "tarifa: " + tarifaPeaje);
                Log.i("main", "distancia: " + distancia);
                float precioPeaje = tarifaPeaje * Float.valueOf(distancia).floatValue();
                Log.i("main", "precioPeaje: " + precioPeaje);
                precioPeaje = roundToTwo(precioPeaje);
                Toast toast = Toast.makeText(this, "Precio: $ " + precioPeaje + "\n" + "Peaje: " + nombrePeaje + "\n" + "Autopista: " + nombreAutopista, 1);
                toast.setGravity(80, 0, 220);
                toast.show();
                Temporal temporal = new Temporal();
                temporal.setId_peaje(Integer.valueOf(id_peaje).intValue());
                temporal.setFecha(datetime);
                temporal.setPrecio(precioPeaje);
                this.temporales.add(temporal);
                this.precioTotalRecorrido += precioPeaje;
                this.precioTotalRecorrido = roundToTwo(this.precioTotalRecorrido);
                ((TextView) findViewById(R.id.tvTotalAcumulado)).setText("$ " + String.valueOf(this.precioTotalRecorrido));
                playBeep();
            }
        }
    }

    public void playBeep() {
        this.beep = MediaPlayer.create(this, R.raw.beep);
        this.beep.start();
    }

    public void stopBeep() {
        this.beep.stop();
        this.beep.release();
        this.beep = null;
    }

    public long crearRecorrido(int id_vehiculo) {
        this.datasource.openDB();
        Recorrido recorrido = new Recorrido();
        recorrido.setFecha_inicio(" ");
        recorrido.setFecha_termino(" ");
        recorrido.setId_vehiculo(id_vehiculo);
        recorrido.setTotal("");
        recorrido = this.datasource.insertarRecorrido(recorrido);
        Log.i("BD", "recorrido creado con id: " + recorrido.getId());
        this.datasource.closeDB();
        return recorrido.getId();
    }

    public long crearTramo(int id_peaje, float precio, String datetime, int id_recorrido) {
        this.datasource.openDB();
        Tramo tramo = new Tramo();
        tramo.setId_peaje(id_peaje);
        tramo.setPrecio(precio);
        tramo.setDatetime(datetime);
        tramo.setId_recorrido(id_recorrido);
        tramo = this.datasource.insertarTramo(tramo);
        this.datasource.closeDB();
        return tramo.getId();
    }

    public void onBackPressed() {
        crearAlerta();
    }

    public void crearAlerta() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Tag'Z dejará de seguir su recorrido, ¿Desea salir sin guardar?").setTitle("Volver al menú");
        builder.setPositiveButton("Si", new OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                MainActivity.this.getWindow().clearFlags(128);
                MainActivity.this.removeLocationUpdate();
                MainActivity.this.finish();
            }
        });
        builder.setNegativeButton("No", new OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        builder.create().show();
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.i(LOGTAG, "onConfigurationChanged");
        agregarAdView();
    }

    private void agregarAdView() {
        if (this.adView != null) {
            this.layoutAdMob.removeView(this.adView);
            Log.i(LOGTAG, "se elimino adView existente");
        }
        this.adView = new AdView(this);
        this.adView.setAdUnitId("ca-app-pub-9346551290517443/9130158410");
        this.adView.setAdSize(AdSize.SMART_BANNER);
        this.layoutAdMob.addView(this.adView);
        this.adView.loadAd(new AdRequest.Builder().build());
        this.adView.setAdListener(new AdListener() {
            public void onAdLoaded() {
                if (MainActivity.this.flag_anuncio == 0) {
                    MainActivity.this.layoutAdMob.setBackgroundColor(-16777216);
                    MainActivity.this.flag_anuncio = 1;
                }
            }
        });
    }

    public void onConnectionSuspended(int cause) {
    }
}
