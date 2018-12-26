package com.afinal.libreria;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.afinal.R;
import java.util.List;

public class SOSAdapter extends ArrayAdapter<String> {
    private Context context;
    private List<String> objects;

    public SOSAdapter(Context context, int textViewResourceId, List<String> objects) {
        super(context, textViewResourceId, objects);
        this.context = context;
        this.objects = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        String label = (String) this.objects.get(position);
        View view = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(R.layout.item_sos, null);
        ((TextView) view.findViewById(R.id.tvListSOSNombreAutopista)).setText(label);
        return view;
    }
}
