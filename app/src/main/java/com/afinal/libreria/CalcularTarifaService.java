package com.afinal.libreria;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import com.afinal.db.PeajesDataSource;

public class CalcularTarifaService extends IntentService {
    private static final String LOGTAG = "CalcularTarifaService";
    PeajesDataSource datasource;
    FuncionesComunes fc = new FuncionesComunes();
    int flag_fantasma = 0;
    float precioTotalRecorrido = 0.0f;
    String ultimoPeaje;

    public CalcularTarifaService() {
        super(LOGTAG);
    }

    protected void onHandleIntent(Intent intent) {
        Log.i(LOGTAG, "onHandleIntent");
        this.datasource = new PeajesDataSource(getApplicationContext());
    }
}
