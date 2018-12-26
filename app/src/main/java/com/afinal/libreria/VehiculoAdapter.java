package com.afinal.libreria;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.afinal.R;
import java.util.List;

public class VehiculoAdapter extends ArrayAdapter<Vehiculo> {
    private Context context;
    private List<Vehiculo> objects;

    public VehiculoAdapter(Context context, int textViewResourceId, List<Vehiculo> objects) {
        super(context, textViewResourceId, objects);
        this.context = context;
        this.objects = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Vehiculo vehiculo = (Vehiculo) this.objects.get(position);
        View view = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(R.layout.item_vehiculo, null);
        ((TextView) view.findViewById(R.id.tvListNombreVehiculo)).setText(vehiculo.getNombre());
        String stringTipo = null;
        int tipo = vehiculo.getTipo();
        if (tipo == 1) {
            stringTipo = "Automóvil";
        }
        if (tipo == 2) {
            stringTipo = "Moto";
        }
        if (tipo == 3) {
            stringTipo = "Motoneta";
        }
        if (tipo == 4) {
            stringTipo = "Camioneta";
        }
        if (tipo == 5) {
            stringTipo = "Auto o Camioneta con Remolque";
        }
        if (tipo == 6) {
            stringTipo = "Bus";
        }
        if (tipo == 7) {
            stringTipo = "Camión";
        }
        if (tipo == 8) {
            stringTipo = "Bus o Camión con Remolque";
        }
        ((TextView) view.findViewById(R.id.tvListTipoVehiculo)).setText(stringTipo);
        return view;
    }
}
