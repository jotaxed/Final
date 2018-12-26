package com.afinal;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.afinal.db.PeajesDataSource;
import com.afinal.libreria.HistorialAdapter;
import com.afinal.libreria.Vehiculo;
import java.util.List;

public class HistorialActivity extends ListActivity {
    private static final int DETAIL_HISTORIAL_ACTIVITY = 1001;
    private AdView adView;
    PeajesDataSource datasource;
    int flag_anuncio = 0;
    LinearLayout layout;
    List<Vehiculo> vehiculosConRecorrido;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        this.datasource = new PeajesDataSource(this);
        this.datasource.openDB();
        this.vehiculosConRecorrido = this.datasource.obtenerVehiculosConRecorrido();
        this.datasource.closeDB();
        if (this.vehiculosConRecorrido.size() == 0) {
            Toast.makeText(this, "No hay recorridos guardados.", 0).show();
        } else {
            for (int i = 0; i < this.vehiculosConRecorrido.size(); i++) {
            }
        }
        refreshDisplay();
        this.adView = new AdView(this);
        this.adView.setAdUnitId("ca-app-pub-9346551290517443/9130158410");
        this.adView.setAdSize(AdSize.SMART_BANNER);
        this.layout = (LinearLayout) findViewById(R.id.mainLayout2);
        this.layout.addView(this.adView);
        this.adView.loadAd(new Builder().build());
        this.adView.setAdListener(new AdListener() {
            public void onAdLoaded() {
                if (HistorialActivity.this.flag_anuncio == 0) {
                    HistorialActivity.this.layout.setBackgroundColor(-16777216);
                    HistorialActivity.this.flag_anuncio = 1;
                }
            }
        });
    }

    private void refreshDisplay() {
        setListAdapter(new HistorialAdapter(this, R.layout.item_historial, this.vehiculosConRecorrido));
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
        Vehiculo vehiculo = (Vehiculo) this.vehiculosConRecorrido.get(position);
        Intent intent = new Intent(this, DetailHistorialActivity.class);
        intent.putExtra("id_vehiculo", vehiculo.getId());
        intent.putExtra("nombre", vehiculo.getNombre());
        startActivityForResult(intent, 1001);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1001 && resultCode == -1) {
            this.datasource.openDB();
            this.vehiculosConRecorrido = this.datasource.obtenerVehiculosConRecorrido();
            this.datasource.closeDB();
            if (this.vehiculosConRecorrido.size() == 0) {
                Toast.makeText(this, "No hay recorridos guardados.", 0).show();
            }
            refreshDisplay();
        }
    }

    protected void onPause() {
        this.adView.pause();
        super.onPause();
    }

    protected void onResume() {
        this.adView.resume();
        super.onResume();
    }

    protected void onDestroy() {
        this.adView.destroy();
        super.onDestroy();
    }
}
