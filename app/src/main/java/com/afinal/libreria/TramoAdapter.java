package com.afinal.libreria;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.afinal.R;
import java.util.List;

public class TramoAdapter extends ArrayAdapter<Tramo> {
    private Context context;
    private List<Tramo> objects;

    public TramoAdapter(Context context, int textViewResourceId, List<Tramo> objects) {
        super(context, textViewResourceId, objects);
        this.context = context;
        this.objects = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        int i;
        Tramo tramo = (Tramo) this.objects.get(position);
        View view = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(R.layout.item_tramo_historial, null);
        String precio = "$ " + tramo.getPrecio();
        String hora = null;
        String[] temp = tramo.getDatetime().split(" ");
        for (i = 0; i < temp.length; i++) {
            hora = temp[1];
        }
        temp = hora.split(":");
        String horaMin = null;
        for (i = 0; i < temp.length; i++) {
            horaMin = temp[0] + ":" + temp[1];
        }
        ((TextView) view.findViewById(R.id.tvListPrecioPeaje)).setText(precio);
        ((TextView) view.findViewById(R.id.tvListHoraPeaje)).setText(new StringBuilder(String.valueOf(horaMin)).append(" hrs.").toString());
        ((TextView) view.findViewById(R.id.tvListNombrePeaje)).setText(tramo.getNombrePeaje());
        ((TextView) view.findViewById(R.id.tvListNombreAutopista)).setText(tramo.getNombreAutopista());
        return view;
    }
}
