package com.afinal.libreria;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.afinal.R;
import java.util.List;

public class HistorialAdapter extends ArrayAdapter<Vehiculo> {
    private static final String LOGATG = "HistorialAdapter";
    private Context context;
    private List<Vehiculo> objects;

    public HistorialAdapter(Context context, int textViewResourceId, List<Vehiculo> objects) {
        super(context, textViewResourceId, objects);
        this.context = context;
        this.objects = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Vehiculo vehiculo = (Vehiculo) this.objects.get(position);
        Log.i(LOGATG, "inicio getView");
        View view = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(R.layout.item_historial, null);
        ((TextView) view.findViewById(R.id.tvListHistorialNombreVehiculo)).setText(vehiculo.getNombre());
        return view;
    }
}
