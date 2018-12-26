package com.afinal;

import android.app.AlertDialog.Builder;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import com.afinal.libreria.SOSAdapter;
import java.util.ArrayList;
import java.util.List;

public class SOSActivity extends ListActivity {
    List<String> labels = new ArrayList();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sos);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        this.labels.add("Autopista Central");
        this.labels.add("Costanera Norte");
        this.labels.add("Túnel San Cristobal");
        this.labels.add("Vespucio Norte");
        this.labels.add("Vespucio Sur");
        this.labels.add("Acceso Vial AMB");
        setListAdapter(new SOSAdapter(this, R.layout.item_sos, this.labels));
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
        String posicion = (String) this.labels.get(position);
        switch ((int) l.getItemIdAtPosition(position)) {
            case 0:
                crearAlerta(posicion, "tel:+56224900767");
                return;
            case 1:
                crearAlerta(posicion, "tel:+56224900767");
                return;
            case 2:
                crearAlerta(posicion, "tel:+56224101500");
                return;
            case 3:
                crearAlerta(posicion, "tel:+56224101500");
                return;
            case 4:
                crearAlerta(posicion, "tel:+56226943400");
                return;
            case 5:
                crearAlerta(posicion, "tel:+56224900767");
                return;
            default:
                return;
        }
    }

    public void crearAlerta(String nombreautopista, final String telefono) {
        Builder builder = new Builder(this);
        builder.setMessage("¿Desea llamar a " + nombreautopista + "?").setTitle("Llamar");
        builder.setPositiveButton("Si", new OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                SOSActivity.this.startActivity(new Intent("android.intent.action.CALL", Uri.parse(telefono)));
            }
        });
        builder.setNegativeButton("No", new OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        builder.create().show();
    }
}
