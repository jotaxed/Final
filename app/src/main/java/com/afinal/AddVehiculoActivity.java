package com.afinal;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.afinal.db.PeajesDataSource;
import com.afinal.libreria.Vehiculo;

public class AddVehiculoActivity extends Activity implements OnItemSelectedListener {
    PeajesDataSource datasource;
    private EditText editTextMarca;
    private EditText editTextModelo;
    private EditText editTextNombre;
    private EditText editTextPatente;
    private Spinner spinner;
    private String stringMarca;
    private String stringModelo;
    private String stringNombre;
    private String stringPatente;
    private int tipo;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitity_add_vehiculo);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        llenarSpinner();
        this.datasource = new PeajesDataSource(this);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_vehiculo_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 16908332:
                finish();
                break;
            case R.id.action_guardar_vehiculo /*2131492947*/:
                guardarVehiculo();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void llenarSpinner() {
        this.spinner = (Spinner) findViewById(R.id.spinnerTipoVehiculo);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.tipos_array, 17367048);
        adapter.setDropDownViewResource(17367049);
        this.spinner.setAdapter(adapter);
        this.spinner.setOnItemSelectedListener(this);
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        this.tipo = this.spinner.getSelectedItemPosition();
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void guardarVehiculo() {
        this.editTextNombre = (EditText) findViewById(R.id.etNombreVehiculo);
        this.stringNombre = this.editTextNombre.getText().toString();
        this.editTextMarca = (EditText) findViewById(R.id.etMarca);
        this.stringMarca = this.editTextMarca.getText().toString();
        this.editTextModelo = (EditText) findViewById(R.id.etModelo);
        this.stringModelo = this.editTextModelo.getText().toString();
        this.editTextPatente = (EditText) findViewById(R.id.etPatente);
        this.stringPatente = this.editTextPatente.getText().toString();
        if (this.tipo == 0 || this.stringNombre.length() <= 0) {
            if (this.tipo == 0) {
                Toast.makeText(this, "Debe seleccionar un tipo de vehículo.", 0).show();
            } else if (this.stringNombre.matches("")) {
                Toast.makeText(this, "Debe ingresar nombre del vehículo.", 0).show();
            }
        } else if (crearVehiculo() != -1) {
            Toast.makeText(this, "Vehículo guardado.", 0).show();
            setResult(1);
            finish();
        }
    }

    public long crearVehiculo() {
        this.datasource.openDB();
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setNombre(this.stringNombre);
        vehiculo.setPatente(this.stringPatente);
        vehiculo.setModelo(this.stringModelo);
        vehiculo.setMarca(this.stringMarca);
        vehiculo.setPatente(this.stringPatente);
        vehiculo.setTipo(this.tipo);
        vehiculo = this.datasource.insertarVehiculo(vehiculo);
        this.datasource.closeDB();
        return vehiculo.getId();
    }
}
