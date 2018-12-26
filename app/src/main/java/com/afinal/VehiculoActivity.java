package com.afinal;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import com.afinal.db.PeajesDataSource;
import com.afinal.libreria.Vehiculo;
import com.afinal.libreria.VehiculoAdapter;
import java.util.List;

public class VehiculoActivity extends ListActivity {
    private static final int ADD_VEHICULO_ACTIVITY = 1002;
    private static final int DETAIL_VEHICULO_ACTIVITY = 1001;
    PeajesDataSource datasource;
    List<Vehiculo> vehiculos;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehiculo);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        this.datasource = new PeajesDataSource(this);
        this.datasource.openDB();
        this.vehiculos = this.datasource.findVehiculos();
        this.datasource.closeDB();
        if (this.vehiculos.size() == 0) {
            Toast.makeText(this, "No hay vehículos guardados.", 0).show();
        } else {
            refreshDisplay();
        }
    }

    private void refreshDisplay() {
        setListAdapter(new VehiculoAdapter(this, R.layout.item_vehiculo, this.vehiculos));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.vehiculo_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 16908332:
                finish();
                break;
            case R.id.action_vehiculo_agregar /*2131492957*/:
                startActivityForResult(new Intent(this, AddVehiculoActivity.class), 1002);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Vehiculo vehiculo = (Vehiculo) this.vehiculos.get(position);
        Intent intent = new Intent(this, DetailVehiculoActivity.class);
        intent.putExtra("id", vehiculo.getId());
        intent.putExtra("tipo", vehiculo.getTipo());
        intent.putExtra("nombre", vehiculo.getNombre());
        intent.putExtra("marca", vehiculo.getMarca());
        intent.putExtra("modelo", vehiculo.getModelo());
        intent.putExtra("patente", vehiculo.getPatente());
        startActivityForResult(intent, 1001);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1001 && resultCode == -1) {
            this.datasource.openDB();
            this.vehiculos = this.datasource.findVehiculos();
            this.datasource.closeDB();
            if (this.vehiculos.size() == 0) {
                Toast.makeText(this, "No hay vehículos guardados.", 0).show();
            }
            refreshDisplay();
            setResult(1);
        }
        if (requestCode == 1002 && resultCode == 1) {
            this.datasource.openDB();
            this.vehiculos = this.datasource.findVehiculos();
            this.datasource.closeDB();
            refreshDisplay();
            setResult(1);
        }
    }
}
