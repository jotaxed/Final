package com.afinal;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import com.afinal.db.PeajesDataSource;
import com.afinal.libreria.Preferencias;
import com.afinal.libreria.Recorrido;
import java.util.List;

public class DetailVehiculoActivity extends Activity {
    private static final String LOGTAG = "DetailVehiculoActivity";
    PeajesDataSource datasource;
    long id_vehiculo;
    String nombre;
    List<Recorrido> recorridos;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_vehiculo);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        this.datasource = new PeajesDataSource(this);
        String stringTipo = null;
        Intent intent = getIntent();
        this.id_vehiculo = intent.getLongExtra("id", 0);
        this.nombre = intent.getStringExtra("nombre");
        int tipo = intent.getIntExtra("tipo", 0);
        if (tipo == 1) {
            stringTipo = "Automóvil";
        }
        if (tipo == 2) {
            stringTipo = "Moto";
        }
        if (tipo == 3) {
            stringTipo = "Motoneta";
        }
        if (tipo == 4) {
            stringTipo = "Camioneta";
        }
        if (tipo == 5) {
            stringTipo = "Auto o Camioneta con Remolque";
        }
        if (tipo == 6) {
            stringTipo = "Bus";
        }
        if (tipo == 7) {
            stringTipo = "Camión";
        }
        if (tipo == 8) {
            stringTipo = "Bus o Camión con Remolque";
        }
        String marca = intent.getStringExtra("marca");
        String modelo = intent.getStringExtra("modelo");
        String patente = intent.getStringExtra("patente");
        EditText etTipo = (EditText) findViewById(R.id.etDetailTipoVehiculo);
        etTipo.setText(stringTipo);
        EditText etNombre = (EditText) findViewById(R.id.etDetailNombreVehiculo);
        etNombre.setText(this.nombre);
        EditText etMarca = (EditText) findViewById(R.id.etDetailMarca);
        etMarca.setText(marca);
        EditText etModelo = (EditText) findViewById(R.id.etDetailModelo);
        etModelo.setText(modelo);
        EditText etPatente = (EditText) findViewById(R.id.etDetailPatente);
        etPatente.setText(patente);
        etTipo.setClickable(false);
        etTipo.setFocusable(false);
        etNombre.setClickable(false);
        etNombre.setFocusable(false);
        etMarca.setClickable(false);
        etMarca.setFocusable(false);
        etModelo.setClickable(false);
        etModelo.setFocusable(false);
        etPatente.setClickable(false);
        etPatente.setFocusable(false);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_vehiculo_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 16908332:
                finish();
                break;
            case R.id.action_vehiculo_borrar /*2131492948*/:
                DialogEliminarVehiculo();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void DialogEliminarVehiculo() {
        Builder builder = new Builder(this);
        builder.setTitle("Aviso");
        builder.setMessage("Este vehículo se borrará junto con su historial.");
        builder.setIcon(R.drawable.ic_action_delete_holo_light);
        builder.setPositiveButton("Aceptar", new OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                DetailVehiculoActivity.this.borrarVehiculo();
            }
        });
        builder.setNegativeButton("Cancelar", new OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.setCancelable(true);
        dialog.show();
    }

    public void borrarVehiculo() {
        this.datasource.openDB();
        if (this.datasource.eliminarVehiculo(this.id_vehiculo)) {
            setResult(-1);
            finish();
            this.recorridos = this.datasource.obtenerRecorrido(Integer.valueOf(String.valueOf(this.id_vehiculo)).intValue());
            Log.i(LOGTAG, "VEHICULO A ELIMINAAR: " + this.nombre);
            if (this.recorridos.size() != 0) {
                for (int i = 0; i < this.recorridos.size(); i++) {
                    int id_recorrido = Integer.valueOf(String.valueOf(((Recorrido) this.recorridos.get(i)).getId())).intValue();
                    if (this.datasource.eliminarTramo(id_recorrido)) {
                        this.datasource.eliminarRecorridoId_recorrido((long) id_recorrido);
                    }
                }
                this.datasource.closeDB();
            }
            Preferencias pref = new Preferencias(this);
            if (pref.getItemSeleccionado() == this.nombre) {
                pref.clearPreferencias();
            }
        }
    }
}
