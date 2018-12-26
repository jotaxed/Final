package com.afinal.tab;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.afinal.R;
import com.afinal.TramoHistorialActivity;
import com.afinal.db.PeajesDataSource;
import com.afinal.libreria.Recorrido;
import com.afinal.libreria.RecorridoAdapter;
import java.util.List;

public class RecorridoFragment extends Fragment implements OnItemClickListener {
    private static final int DETAIL_HISTORIAL_ACTIVITY = 1001;
    private static final String LOGTAG = "RecorridoFragment";
    private static final int TRAMO_HISTORIAL_ACTIVITY = 1001;
    RecorridoAdapter adapter;
    PeajesDataSource datasource;
    int id;
    ListView lvRecorrido;
    MyReceiver r;
    List<Recorrido> recorridos;

    private class MyReceiver extends BroadcastReceiver {
        private MyReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            RecorridoFragment.this.refresh();
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(LOGTAG, "CREANDO FRAGMENT RECORRIDO");
        View rootView = inflater.inflate(R.layout.fragment_recorrido, container, false);
        this.lvRecorrido = (ListView) rootView.findViewById(R.id.lvRecorrido);
        this.lvRecorrido.setOnItemClickListener(this);
        long id_vehiculo = getActivity().getIntent().getLongExtra("id_vehiculo", 0);
        Log.i("intent id_vehiculo", "id_vehiculo: " + id_vehiculo);
        this.id = Integer.valueOf(String.valueOf(id_vehiculo)).intValue();
        this.datasource = new PeajesDataSource(getActivity());
        if (id_vehiculo != 0) {
            this.datasource.openDB();
            this.recorridos = this.datasource.obtenerRecorrido(this.id);
            this.datasource.closeDB();
        }
        if (this.recorridos.size() != 0) {
            refreshDisplay();
        }
        Log.i(LOGTAG, "inicio receiver");
        this.r = new MyReceiver();
        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(this.r, new IntentFilter("refresh"));
        Log.i(LOGTAG, "fin receiver");
        return rootView;
    }

    private void refreshDisplay() {
        this.lvRecorrido.setAdapter(new RecorridoAdapter(getActivity(), R.layout.item_detail_historial, this.recorridos));
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Recorrido recorrido = (Recorrido) this.recorridos.get(position);
        Intent intent = new Intent(getActivity(), TramoHistorialActivity.class);
        intent.putExtra("id_recorrido", recorrido.getId());
        String fecha = null;
        String[] temp = recorrido.getFecha_termino().split(" ");
        for (int i = 0; i < temp.length; i++) {
            fecha = temp[0];
        }
        intent.putExtra("fecha", fecha);
        startActivityForResult(intent, 1001);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1001 && resultCode == -1) {
            Log.i(LOGTAG, "se supone que en Tramo Historial se borro uno por lo lanto hay que refrescar");
            this.datasource.openDB();
            this.recorridos = this.datasource.obtenerRecorrido(this.id);
            this.datasource.closeDB();
            if (this.recorridos.size() == 0) {
                getActivity().setResult(-1);
                getActivity().finish();
                return;
            }
            refreshDisplay();
        }
    }

    public void refresh() {
        Log.i(LOGTAG, "refresh!!!!");
        this.datasource.openDB();
        this.recorridos = this.datasource.obtenerRecorrido(this.id);
        this.datasource.closeDB();
        if (this.recorridos.size() == 0) {
            getActivity().setResult(-1);
            getActivity().finish();
            return;
        }
        refreshDisplay();
    }

    public void onDestroy() {
        super.onDestroy();
        Log.i(LOGTAG, "inicio unregister");
        LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(this.r);
        Log.i(LOGTAG, "fin unregister Receiver");
    }
}
