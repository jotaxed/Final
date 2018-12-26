package com.afinal;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.afinal.db.PeajesDataSource;
import com.afinal.libreria.Preferencias;
import com.afinal.libreria.Vehiculo;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"NewApi"})
public class MenuActivity extends Activity implements OnItemSelectedListener, OnMenuItemClickListener {
    private static final int ADD_VEHICULO_ACTIVITY = 1004;
    private static final int CONFIGURACION_GPS = 1003;
    private static final String LOGTAG = "MenuActivity";
    private static final int MAIN_ACTIVITY = 1002;
    public static final String PREFS_NAME = "MyPrefsFile";
    private static final int VEHICULO_ACTIVITY = 1001;
    private AdView adView;
    PeajesDataSource datasource;
    int flag_anuncio = 0;
    int gps_on = 0;
    int id_vehiculo_seleccionado = 0;
    LinearLayout layout;
    LinearLayout layout2;
    String nameItemSelected = null;
    private Spinner spinner;
    int tipo_vehiculo_seleccionado = 0;
    TextView tvVehiculo;
    List<Vehiculo> vehiculos;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        this.datasource = new PeajesDataSource(this);
        this.tvVehiculo = (TextView) findViewById(R.id.tvSeleccionar);
        setPreferences();
        this.adView = new AdView(this);
        this.adView.setAdUnitId("ca-app-pub-9346551290517443/9130158410");
        this.adView.setAdSize(AdSize.SMART_BANNER);
        this.layout = (LinearLayout) findViewById(R.id.mainLayout);
        this.layout2 = (LinearLayout) findViewById(R.id.linearLayout2);
        this.layout.addView(this.adView);
        this.adView.loadAd(new Builder().build());
        this.adView.setAdListener(new AdListener() {
            public void onAdLoaded() {
                if (MenuActivity.this.flag_anuncio == 0) {
                    MenuActivity.this.layout.setBackgroundColor(-16777216);
                    MenuActivity.this.flag_anuncio = 1;
                }
            }
        });
    }

    public void setPreferences() {
        Log.i(LOGTAG, "*****setPreferences*****");
        this.datasource.openDB();
        this.vehiculos = this.datasource.findVehiculos();
        this.datasource.closeDB();
        if (this.vehiculos.size() == 0) {
            Log.i(LOGTAG, "vehiculos == 0");
            this.tvVehiculo.setText("SELECCIONAR");
        } else {
            Preferencias pref = new Preferencias(this);
            String itemSelected = pref.getItemSeleccionado();
            this.nameItemSelected = itemSelected;
            Log.i(LOGTAG, "NOMBRE ITEM SELECTED: " + itemSelected);
            this.id_vehiculo_seleccionado = pref.getIdItemSeleccionado();
            Log.i(LOGTAG, "ID ITEM SELECTED: " + this.id_vehiculo_seleccionado);
            this.tipo_vehiculo_seleccionado = pref.getTipoItemSeleccionado();
            Log.i(LOGTAG, "TIPO ITEM SELECTED: " + this.tipo_vehiculo_seleccionado);
            if (itemSelected.equals("no seleccionado")) {
                Log.i(LOGTAG, "else, setear seleccine");
                this.tvVehiculo.setText("SELECCIONAR");
            } else {
                Log.i(LOGTAG, "!= no seleccinado");
                this.tvVehiculo.setText(itemSelected);
            }
        }
        Log.i(LOGTAG, "*****setPreferences*****");
    }

    public void clearPreferences() {
        this.nameItemSelected = "no seleccionado";
        this.id_vehiculo_seleccionado = 0;
        this.tipo_vehiculo_seleccionado = 0;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_activity_vehiculos /*2131492952*/:
                startActivityForResult(new Intent(this, VehiculoActivity.class), 1001);
                break;
            case R.id.action_activity_historial /*2131492953*/:
                startActivity(new Intent(this, HistorialActivity.class));
                break;
            case R.id.action_activity_informacion /*2131492954*/:
                startActivity(new Intent(this, SOSActivity.class));
                break;
            case R.id.action_activity_acercade /*2131492955*/:
                startActivity(new Intent(this, AcercaDeActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void gotoMap(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        Log.i(LOGTAG, "*********Go to map ********");
        Log.i(LOGTAG, "id_vehiculo_seleccionado: " + this.id_vehiculo_seleccionado);
        Log.i(LOGTAG, "*********Go to map ********");
        this.datasource.openDB();
        this.vehiculos = this.datasource.findVehiculos();
        this.datasource.closeDB();
        if (this.vehiculos.size() == 0) {
            DialogAgregarVehiculo("Para iniciar un recorrido debes agregar un vehículo y luego seleccionarlo.");
            this.id_vehiculo_seleccionado = 0;
        } else if (this.id_vehiculo_seleccionado == 0) {
            Toast.makeText(this, "Debe seleccionar un vehículo.", 0).show();
        } else if (((LocationManager) getSystemService("location")).isProviderEnabled("gps")) {
            Log.i(LOGTAG, "*********Go to map ********");
            Log.i(LOGTAG, "Iniciando con vehiculo: " + this.nameItemSelected);
            Log.i(LOGTAG, "Iniciando con id vehiculo: " + this.id_vehiculo_seleccionado);
            Log.i(LOGTAG, "Iniciando con tipo vehiculo: " + this.tipo_vehiculo_seleccionado);
            intent.putExtra("nameItemSelected", this.nameItemSelected);
            intent.putExtra("id_vehiculo", this.id_vehiculo_seleccionado);
            intent.putExtra("tipo_vehiculo", this.tipo_vehiculo_seleccionado);
            startActivityForResult(intent, 1002);
        } else {
            showGPSDisabledAlertToUser();
        }
    }

    private void showGPSDisabledAlertToUser() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("El GPS no está activado en su dispositivo. Por favor, actívelo para que Tag'Z funcione correctamente.").setTitle("GPS");
        builder.setPositiveButton("Habilitar", new OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent callGPSSettingIntent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
                MenuActivity.this.gps_on = 1;
                MenuActivity.this.startActivityForResult(callGPSSettingIntent, MenuActivity.CONFIGURACION_GPS);
            }
        });
        builder.setNegativeButton("Cancelar", new OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        builder.create().show();
    }

    public void llenarSpinner() {
        this.spinner = (Spinner) findViewById(R.id.spinnerNombreVehiculo);
        List<String> labels = new ArrayList();
        this.datasource.openDB();
        this.vehiculos = this.datasource.findVehiculos();
        this.datasource.closeDB();
        if (this.vehiculos.size() == 0) {
            this.id_vehiculo_seleccionado = 0;
            ArrayAdapter<String> adapter = new ArrayAdapter(this, 17367048, new ArrayList());
            adapter.setDropDownViewResource(17367049);
            this.spinner.setAdapter(adapter);
            this.spinner.setOnItemSelectedListener(this);
            return;
        }
        for (int i = 0; i < this.vehiculos.size(); i++) {
            labels.add(((Vehiculo) this.vehiculos.get(i)).getNombre());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter(this, 17367048, labels);
        adapter.setDropDownViewResource(17367049);
        this.spinner.setAdapter(adapter);
        this.spinner.setOnItemSelectedListener(this);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1001 && resultCode == 1) {
            Log.i("intent", "result VEHICULO_ACTIVITY");
            clearPreferences();
            llenarTvSeleccionar();
        }
        if (requestCode == 1002) {
        }
        if (requestCode == CONFIGURACION_GPS && resultCode == 0 && this.gps_on == 1) {
            Intent intent = new Intent(this, MainActivity.class);
            if (this.id_vehiculo_seleccionado == 0) {
                Toast.makeText(this, "Debe seleccionar un vehículo.", 0).show();
            } else if (((LocationManager) getSystemService("location")).isProviderEnabled("gps")) {
                intent.putExtra("id_vehiculo", this.id_vehiculo_seleccionado);
                intent.putExtra("tipo_vehiculo", this.tipo_vehiculo_seleccionado);
                startActivity(intent);
            }
        }
        if (requestCode == ADD_VEHICULO_ACTIVITY && resultCode == 1) {
            Log.i("intent", "result ADD_VEHICULO_ACTIVITY");
            clearPreferences();
            llenarTvSeleccionar();
        }
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        this.nameItemSelected = parent.getItemAtPosition(position).toString();
        this.id_vehiculo_seleccionado = Integer.valueOf(String.valueOf(((Vehiculo) this.vehiculos.get(position)).getId())).intValue();
        this.tipo_vehiculo_seleccionado = ((Vehiculo) this.vehiculos.get(position)).getTipo();
        Log.i(LOGTAG, "*********onItemSelected********");
        Log.i(LOGTAG, "id_vehiculo_seleccionado: " + this.id_vehiculo_seleccionado);
        Log.i(LOGTAG, "nameItemSelected: " + this.nameItemSelected);
        Log.i(LOGTAG, "*********onItemSelected********");
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setItemSelectedSpinner(String itemName) {
        if (this.vehiculos.size() != 0) {
            this.spinner = (Spinner) findViewById(R.id.spinnerNombreVehiculo);
            this.spinner.setSelection(((ArrayAdapter) this.spinner.getAdapter()).getPosition(itemName));
        }
    }

    protected void onPause() {
        this.adView.pause();
        super.onPause();
        if (this.nameItemSelected != null) {
            Preferencias prefs = new Preferencias(this);
            prefs.saveItemSeleccionado(this.nameItemSelected);
            prefs.saveIdItemSeleccionado(this.id_vehiculo_seleccionado);
            prefs.saveTipoItemSeleccionado(this.tipo_vehiculo_seleccionado);
            Log.i(LOGTAG, "ITEM A GUARDAR: " + this.nameItemSelected);
        }
    }

    protected void onResume() {
        this.adView.resume();
        super.onResume();
    }

    protected void onDestroy() {
        this.adView.destroy();
        super.onDestroy();
    }

    protected void onStop() {
        super.onStop();
    }

    public void DialogAgregarVehiculo(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Aviso");
        builder.setMessage(message);
        builder.setIcon(R.drawable.ic_action_vehiculo_holo_light);
        builder.setPositiveButton("Aceptar", new OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                MenuActivity.this.startActivityForResult(new Intent(MenuActivity.this.getApplicationContext(), AddVehiculoActivity.class), MenuActivity.ADD_VEHICULO_ACTIVITY);
            }
        });
        AlertDialog dialog = builder.create();
        dialog.setCancelable(true);
        dialog.show();
    }

    public void seleccionarVehiculo(View view) {
        Toast.makeText(this, "holi", 0).show();
    }

    public boolean onMenuItemClick(MenuItem item) {
        Toast.makeText(this, "You Clicked : " + item.getTitle(), 0).show();
        return false;
    }

    public void DialogVehiculo() {
        Log.i(LOGTAG, "DialogVehiculo");
        List<String> nombreVehiculos = new ArrayList();
        for (int i = 0; i < this.vehiculos.size(); i++) {
            nombreVehiculos.add(((Vehiculo) this.vehiculos.get(i)).getNombre());
            Log.i(LOGTAG, "vehiculo: " + ((Vehiculo) this.vehiculos.get(i)).getNombre());
            Log.i(LOGTAG, "position: " + i);
        }
        final CharSequence[] itemRadioVehiculo = (CharSequence[]) nombreVehiculos.toArray(new CharSequence[nombreVehiculos.size()]);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setItems(itemRadioVehiculo, new OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                String vehiculo = itemRadioVehiculo[which];
                Log.i(MenuActivity.LOGTAG, "radiobutton vehiculo seleccionado: " + vehiculo);
                Log.i(MenuActivity.LOGTAG, "which: " + which);
                MenuActivity.this.tvVehiculo.setText(vehiculo);
                MenuActivity.this.nameItemSelected = vehiculo;
                MenuActivity.this.id_vehiculo_seleccionado = Integer.valueOf(String.valueOf(((Vehiculo) MenuActivity.this.vehiculos.get(which)).getId())).intValue();
                MenuActivity.this.tipo_vehiculo_seleccionado = ((Vehiculo) MenuActivity.this.vehiculos.get(which)).getTipo();
                Log.i(MenuActivity.LOGTAG, "*********onItemSelected********");
                Log.i(MenuActivity.LOGTAG, "id_vehiculo_seleccionado: " + MenuActivity.this.id_vehiculo_seleccionado);
                Log.i(MenuActivity.LOGTAG, "nameItemSelected: " + MenuActivity.this.nameItemSelected);
                Log.i(MenuActivity.LOGTAG, "*********onItemSelected********");
                dialog.cancel();
            }
        });
        builder.create().show();
    }

    public void openDialogVehiculo(View view) {
        this.datasource.openDB();
        this.vehiculos = this.datasource.findVehiculos();
        this.datasource.closeDB();
        if (this.vehiculos.size() == 0) {
            DialogAgregarVehiculo("Debes agregar un vehículo y luego seleccionarlo.");
            return;
        }
        Log.i(LOGTAG, "openDialogVehiculo");
        DialogVehiculo();
    }

    public void llenarTvSeleccionar() {
        this.datasource.openDB();
        this.vehiculos = this.datasource.findVehiculos();
        this.datasource.closeDB();
        this.tvVehiculo.setText("SELECCIONAR");
    }
}
