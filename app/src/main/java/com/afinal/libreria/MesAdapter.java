package com.afinal.libreria;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.afinal.R;
import java.util.List;

public class MesAdapter extends ArrayAdapter<Mes> {
    private Context context;
    FuncionesComunes fc = new FuncionesComunes();
    private List<Mes> objects;

    public MesAdapter(Context context, int textViewResourceId, List<Mes> objects) {
        super(context, textViewResourceId, objects);
        this.context = context;
        this.objects = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Mes mes = (Mes) this.objects.get(position);
        String total = "$ " + mes.getTotal();
        String fecha = new StringBuilder(String.valueOf(this.fc.getMonth(mes.getFecha()))).append(" ").append(mes.getAno()).toString();
        View view = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(R.layout.item_detail_historial, null);
        ((TextView) view.findViewById(R.id.tvListFechaDetailHistorial)).setText(fecha);
        ((TextView) view.findViewById(R.id.tvListTotalDetailHistorial)).setText(total);
        return view;
    }
}
