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
import com.afinal.HistorialMesActivity;
import com.afinal.R;
import com.afinal.db.PeajesDataSource;
import com.afinal.libreria.Mes;
import com.afinal.libreria.MesAdapter;
import java.util.List;

public class MesFragment extends Fragment implements OnItemClickListener {
    private static final int DETAIL_HISTORIAL_ACTIVITY = 1001;
    private static final int HISTORIAL_MES_ACTIVITY = 1004;
    private static final String LOGTAG = "MesFragment";
    PeajesDataSource datasource;
    int id;
    ListView lvMes;
    private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            Log.d("receiver", "Got message: " + intent.getStringExtra("message"));
        }
    };
    List<Mes> meses;
    MyReceiver r;

    private class MyReceiver extends BroadcastReceiver {
        private MyReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            MesFragment.this.refresh();
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(LOGTAG, "CREANDO FRAGMENT MES");
        View rootView = inflater.inflate(R.layout.fragment_recorrido, container, false);
        this.lvMes = (ListView) rootView.findViewById(R.id.lvRecorrido);
        this.lvMes.setOnItemClickListener(this);
        long id_vehiculo = getActivity().getIntent().getLongExtra("id_vehiculo", 0);
        Log.i("intent id_vehiculo", "id_vehiculo: " + id_vehiculo);
        this.id = Integer.valueOf(String.valueOf(id_vehiculo)).intValue();
        Log.i(LOGTAG, "id vehiculo recibido en fragment: " + this.id);
        this.datasource = new PeajesDataSource(getActivity());
        if (id_vehiculo != 0) {
            this.datasource.openDB();
            this.meses = this.datasource.obtenerMeses(this.id);
            this.datasource.closeDB();
            for (int i = 0; i < this.meses.size(); i++) {
                Log.i("recorrido", ((Mes) this.meses.get(i)).toString());
            }
        }
        if (this.meses.size() == 0) {
            Log.i("Size", "No hay recorridooooos para el vehiculo.");
        }
        refreshDisplay();
        Log.i(LOGTAG, "inicio receiver");
        this.r = new MyReceiver();
        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(this.r, new IntentFilter("refresh"));
        Log.i(LOGTAG, "fin Receiver");
        return rootView;
    }

    private void refreshDisplay() {
        this.lvMes.setAdapter(new MesAdapter(getActivity(), R.layout.item_detail_historial, this.meses));
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Mes mes = (Mes) this.meses.get(position);
        Intent intent = new Intent(getActivity(), HistorialMesActivity.class);
        intent.putExtra("mes", mes.getFecha());
        Log.i(LOGTAG, "enviando mes: " + mes.getFecha());
        intent.putExtra("ano", mes.getAno());
        Log.i(LOGTAG, "enviando año: " + mes.getAno());
        intent.putExtra("id_vehiculo", mes.getId_vehiculo());
        Log.i(LOGTAG, "enviando id_vehiculo: " + mes.getId_vehiculo());
        startActivityForResult(intent, HISTORIAL_MES_ACTIVITY);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i(LOGTAG, "onactivity Activity se gatillo");
        Log.i(LOGTAG, "requestcode: " + requestCode);
        Log.i(LOGTAG, "resultCode: " + resultCode);
        if (requestCode == HISTORIAL_MES_ACTIVITY && resultCode == -1) {
            Log.i(LOGTAG, "se supone que en Tramo Historial se borro uno por lo lanto hay que refrescar");
            this.datasource = new PeajesDataSource(getActivity());
            if (this.id != 0) {
                this.datasource.openDB();
                this.meses = this.datasource.obtenerMeses(this.id);
                this.datasource.closeDB();
            }
            if (this.meses.size() == 0) {
                Log.i(LOGTAG, "No hay recorridooooos para el vehiculo.");
                getActivity().setResult(-1);
                getActivity().finish();
                return;
            }
            refreshDisplay();
            LocalBroadcastManager.getInstance(getActivity()).sendBroadcast(new Intent("refresh2"));
            Log.i(LOGTAG, "Se inicio LocalBroadcastManager");
        }
    }

    public void refresh() {
        Log.i(LOGTAG, "refresh!!!!");
        this.datasource = new PeajesDataSource(getActivity());
        if (this.id != 0) {
            this.datasource.openDB();
            this.meses = this.datasource.obtenerMeses(this.id);
            this.datasource.closeDB();
        }
        if (this.meses.size() == 0) {
            Log.i("Size", "No hay recorridooooos para el vehiculo.");
            getActivity().setResult(-1);
            getActivity().finish();
            return;
        }
        refreshDisplay();
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }

    public void onDestroy() {
        super.onDestroy();
        Log.i(LOGTAG, "inicio unregister");
        LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(this.r);
        Log.i(LOGTAG, "fin unregister Receiver");
    }
}
