package com.google.android.gms.drive.widget;

import android.content.Context;
import android.database.CursorIndexOutOfBoundsException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.drive.internal.w;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataBufferAdapter<T> extends BaseAdapter {
    private final int To;
    private int Tp;
    private final int Tq;
    private final List<DataBuffer<T>> Tr;
    private final LayoutInflater Ts;
    private boolean Tt;
    private final Context mContext;

    public DataBufferAdapter(Context context, int resource) {
        this(context, resource, 0, new ArrayList());
    }

    public DataBufferAdapter(Context context, int resource, int textViewResourceId) {
        this(context, resource, textViewResourceId, new ArrayList());
    }

    public DataBufferAdapter(Context context, int resource, int textViewResourceId, List<DataBuffer<T>> objects) {
        this.Tt = true;
        this.mContext = context;
        this.Tp = resource;
        this.To = resource;
        this.Tq = textViewResourceId;
        this.Tr = objects;
        this.Ts = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public DataBufferAdapter(Context context, int resource, int textViewResourceId, DataBuffer<T>... buffers) {
        this(context, resource, textViewResourceId, Arrays.asList(buffers));
    }

    public DataBufferAdapter(Context context, int resource, List<DataBuffer<T>> objects) {
        this(context, resource, 0, (List) objects);
    }

    public DataBufferAdapter(Context context, int resource, DataBuffer<T>... buffers) {
        this(context, resource, 0, Arrays.asList(buffers));
    }

    private View a(int i, View view, ViewGroup viewGroup, int i2) {
        View inflate = view == null ? this.Ts.inflate(i2, viewGroup, false) : view;
        try {
            TextView textView = this.Tq == 0 ? (TextView) inflate : (TextView) inflate.findViewById(this.Tq);
            Object item = getItem(i);
            if (item instanceof CharSequence) {
                textView.setText((CharSequence) item);
            } else {
                textView.setText(item.toString());
            }
            return inflate;
        } catch (Throwable e) {
            w.a("DataBufferAdapter", e, "You must supply a resource ID for a TextView");
            throw new IllegalStateException("DataBufferAdapter requires the resource ID to be a TextView", e);
        }
    }

    public void append(DataBuffer<T> buffer) {
        this.Tr.add(buffer);
        if (this.Tt) {
            notifyDataSetChanged();
        }
    }

    public void clear() {
        for (DataBuffer release : this.Tr) {
            release.release();
        }
        this.Tr.clear();
        if (this.Tt) {
            notifyDataSetChanged();
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getCount() {
        int i = 0;
        for (DataBuffer count : this.Tr) {
            i = count.getCount() + i;
        }
        return i;
    }

    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return a(position, convertView, parent, this.Tp);
    }

    public T getItem(int position) throws CursorIndexOutOfBoundsException {
        int i = position;
        for (DataBuffer dataBuffer : this.Tr) {
            int count = dataBuffer.getCount();
            if (count <= i) {
                i -= count;
            } else {
                try {
                    return dataBuffer.get(i);
                } catch (CursorIndexOutOfBoundsException e) {
                    throw new CursorIndexOutOfBoundsException(position, getCount());
                }
            }
        }
        throw new CursorIndexOutOfBoundsException(position, getCount());
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        return a(position, convertView, parent, this.To);
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.Tt = true;
    }

    public void setDropDownViewResource(int resource) {
        this.Tp = resource;
    }

    public void setNotifyOnChange(boolean notifyOnChange) {
        this.Tt = notifyOnChange;
    }
}
