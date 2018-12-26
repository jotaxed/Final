package com.afinal;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import com.afinal.db.PeajesDataSource;
import com.afinal.libreria.FuncionesComunes;
import com.afinal.libreria.Recorrido;
import com.afinal.libreria.RecorridoAdapter;
import java.util.List;

public class HistorialMesActivity extends ListActivity {
    private static final String LOGTAG = "HistorialMesActivity";
    private static final int TRAMO_HISTORIAL_ACTIVITY = 1001;
    int ano;
    PeajesDataSource datasource;
    FuncionesComunes fc = new FuncionesComunes();
    int id;
    int mes;
    List<Recorrido> recorridos;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial_mes);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        this.id = intent.getIntExtra("id_vehiculo", 0);
        this.ano = intent.getIntExtra("ano", 0);
        this.mes = intent.getIntExtra("mes", -2);
        setTitle("Historial " + this.fc.getMonth(this.mes) + " " + this.ano);
        this.datasource = new PeajesDataSource(this);
        if (!(this.id == 0 || this.ano == 0 || this.mes == -2)) {
            this.datasource.openDB();
            this.recorridos = this.datasource.obtenerRecorridoPorMes(this.id, this.mes, this.ano);
            this.datasource.closeDB();
            for (int i = 0; i < this.recorridos.size(); i++) {
            }
        }
        if (this.recorridos.size() != 0) {
            refreshDisplay();
        }
    }

    private void refreshDisplay() {
        setListAdapter(new RecorridoAdapter(this, R.layout.item_detail_historial, this.recorridos));
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 16908332:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Recorrido recorrido = (Recorrido) this.recorridos.get(position);
        Intent intent = new Intent(this, TramoHistorialActivity.class);
        intent.putExtra("id_recorrido", recorrido.getId());
        String fecha = null;
        String[] temp = recorrido.getFecha_termino().split(" ");
        for (int i = 0; i < temp.length; i++) {
            fecha = temp[0];
        }
        intent.putExtra("fecha", fecha);
        startActivityForResult(intent, 1001);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1001 && resultCode == -1) {
            Log.i(LOGTAG, "se supone que en Tramo Historial se borro uno por lo lanto hay que refrescar");
            setResult(-1);
            this.datasource.openDB();
            this.recorridos = this.datasource.obtenerRecorridoPorMes(this.id, this.mes, this.ano);
            this.datasource.closeDB();
            if (this.recorridos.size() == 0) {
                finish();
            } else {
                refreshDisplay();
            }
        }
    }
}
