package com.afinal.libreria;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;

public class Preferencias {
    private static final String ID_ITEM_SELECTED = "idItemSelected";
    private static final String ITEM_SELECTED = "nameItemSelected";
    private static final String LOGTAG = "Preferencias";
    private static final String PREFS_NAME = "vehiculoSeleccionado";
    private static final String TIPO_ITEM_SELECTED = "tipoItemSelected";
    private Editor editor = this.tagzPrefs.edit();
    private SharedPreferences tagzPrefs;

    public Preferencias(Context context) {
        this.tagzPrefs = context.getSharedPreferences(PREFS_NAME, 0);
    }

    public void saveItemSeleccionado(String nameItemSelected) {
        this.editor.putString(ITEM_SELECTED, nameItemSelected);
        this.editor.commit();
    }

    public String getItemSeleccionado() {
        return this.tagzPrefs.getString(ITEM_SELECTED, "no seleccionado");
    }

    public void saveIdItemSeleccionado(int id_vehiculo_seleccionado) {
        this.editor.putInt(ID_ITEM_SELECTED, id_vehiculo_seleccionado);
        this.editor.commit();
    }

    public int getIdItemSeleccionado() {
        return this.tagzPrefs.getInt(ID_ITEM_SELECTED, 0);
    }

    public void saveTipoItemSeleccionado(int tipo_vehiculo_seleccionado) {
        this.editor.putInt(TIPO_ITEM_SELECTED, tipo_vehiculo_seleccionado);
        this.editor.commit();
    }

    public int getTipoItemSeleccionado() {
        return this.tagzPrefs.getInt(TIPO_ITEM_SELECTED, 0);
    }

    public void clearPreferencias() {
        this.editor.clear().commit();
        Log.i(LOGTAG, "FIN clearPreferencias");
    }
}
