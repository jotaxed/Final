package com.afinal;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import com.afinal.db.PeajesDataSource;
import com.afinal.libreria.Tramo;
import com.afinal.libreria.TramoAdapter;
import java.util.List;

public class TramoHistorialActivity extends ListActivity {
    PeajesDataSource datasource;
    int id;
    List<Tramo> tramos;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tramo_historial);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        long id_recorrido = intent.getLongExtra("id_recorrido", 0);
        this.id = Integer.valueOf(String.valueOf(id_recorrido)).intValue();
        setTitle("Historial " + intent.getStringExtra("fecha"));
        this.datasource = new PeajesDataSource(this);
        if (id_recorrido != 0) {
            this.datasource.openDB();
            this.tramos = this.datasource.obtenerTramo(this.id);
            this.datasource.closeDB();
        }
        refreshDisplay();
    }

    private void refreshDisplay() {
        setListAdapter(new TramoAdapter(this, R.layout.item_tramo_historial, this.tramos));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.historial_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 16908332:
                finish();
                break;
            case R.id.action_borrar /*2131492949*/:
                this.datasource.openDB();
                if (this.datasource.eliminarTramo(this.id) && this.datasource.eliminarRecorridoId_recorrido((long) this.id)) {
                    Log.i("delete recorrido", "se eliminó recorrido con id_recorrido: " + this.id + " y se seteo resultado -1");
                    setResult(-1);
                    finish();
                }
                this.datasource.closeDB();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
