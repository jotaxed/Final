package com.afinal.libreria;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.afinal.R;
import java.util.List;

public class RecorridoAdapter extends ArrayAdapter<Recorrido> {
    private Context context;
    private List<Recorrido> objects;

    public RecorridoAdapter(Context context, int textViewResourceId, List<Recorrido> objects) {
        super(context, textViewResourceId, objects);
        this.context = context;
        this.objects = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Recorrido recorrido = (Recorrido) this.objects.get(position);
        String total = "$ " + recorrido.getTotal();
        String fecha = null;
        String[] temp = recorrido.getFecha_termino().split(" ");
        for (int i = 0; i < temp.length; i++) {
            fecha = temp[0];
        }
        View view = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(R.layout.item_detail_historial, null);
        ((TextView) view.findViewById(R.id.tvListFechaDetailHistorial)).setText(fecha);
        ((TextView) view.findViewById(R.id.tvListTotalDetailHistorial)).setText(total);
        return view;
    }
}
