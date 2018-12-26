package com.afinal.libreria;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.fitness.FitnessStatusCodes;
import com.afinal.db.PeajesDataSource;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.params.HttpConnectionParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FuncionesComunes {
    private static final String LOGTAG = "FuncionesComunes";
    PeajesDataSource datasource;

    public String servidor() {
        return "http://www.tagz.neocube.cl";
    }

    public String getMonth(int month) {
        String mes = new DateFormatSymbols().getMonths()[month - 1];
        return new StringBuilder(String.valueOf(mes.substring(0, 1).toUpperCase())).append(mes.substring(1)).toString();
    }

    public String crearJson() {
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObjectRecorrido = new JSONObject();
        try {
            jsonObjectRecorrido.put("fecha", "2015-01-28 17:46:33");
            jsonObjectRecorrido.put("total", "389.759979");
            jsonObjectRecorrido.put("plataforma", "2");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.i(LOGTAG, "json:" + jsonObjectRecorrido.toString());
        jsonArray.put(jsonObjectRecorrido);
        JSONObject jsonObjectTramo = new JSONObject();
        try {
            jsonObjectTramo.put("horario", "17:46");
            jsonObjectTramo.put("id_peaje", "3");
            jsonObjectTramo.put("precio", "389.759979");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        Log.i(LOGTAG, "json:" + jsonObjectTramo.toString());
        jsonArray.put(jsonObjectTramo);
        String jsonStr = jsonArray.toString();
        Log.i(LOGTAG, "jsonString: " + jsonStr);
        return jsonStr;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String convertStreamToString(java.io.InputStream r8) {
        /*
        r7 = this;
        r2 = new java.io.BufferedReader;
        r4 = new java.io.InputStreamReader;
        r4.<init>(r8);
        r2.<init>(r4);
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r1 = 0;
    L_0x0010:
        r1 = r2.readLine();	 Catch:{ IOException -> 0x0035 }
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r8.close();	 Catch:{ IOException -> 0x0064 }
    L_0x0019:
        r4 = r3.toString();
        return r4;
    L_0x001e:
        r4 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0035 }
        r5 = java.lang.String.valueOf(r1);	 Catch:{ IOException -> 0x0035 }
        r4.<init>(r5);	 Catch:{ IOException -> 0x0035 }
        r5 = "\n";
        r4 = r4.append(r5);	 Catch:{ IOException -> 0x0035 }
        r4 = r4.toString();	 Catch:{ IOException -> 0x0035 }
        r3.append(r4);	 Catch:{ IOException -> 0x0035 }
        goto L_0x0010;
    L_0x0035:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x005a }
        r4 = "Buffer Error";
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x005a }
        r6 = "Error converting result ";
        r5.<init>(r6);	 Catch:{ all -> 0x005a }
        r6 = r0.toString();	 Catch:{ all -> 0x005a }
        r5 = r5.append(r6);	 Catch:{ all -> 0x005a }
        r5 = r5.toString();	 Catch:{ all -> 0x005a }
        android.util.Log.e(r4, r5);	 Catch:{ all -> 0x005a }
        r8.close();	 Catch:{ IOException -> 0x0055 }
        goto L_0x0019;
    L_0x0055:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0019;
    L_0x005a:
        r4 = move-exception;
        r8.close();	 Catch:{ IOException -> 0x005f }
    L_0x005e:
        throw r4;
    L_0x005f:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x005e;
    L_0x0064:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0019;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tagz.libreria.FuncionesComunes.convertStreamToString(java.io.InputStream):java.lang.String");
    }

    public boolean isValidNumber(String value) {
        for (int i = 0; i < value.length(); i++) {
            if (!Character.isDigit(value.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public void enviarJson(final String jsonString) {
        final String url = servidor() + "/nuevo_recorrido.php";
        Log.i(LOGTAG, "inicio enviarJson");
        new Thread() {
            public void run() {
                Looper.prepare();
                HttpClient httpClient = new DefaultHttpClient();
                HttpConnectionParams.setConnectionTimeout(httpClient.getParams(), FitnessStatusCodes.NEEDS_OAUTH_PERMISSIONS);
                try {
                    HttpPost httpPost = new HttpPost(url);
                    StringEntity stringEntity = new StringEntity(jsonString);
                    stringEntity.setContentType(new BasicHeader("Content-Type", "application/json; charset=utf-8"));
                    httpPost.setEntity(stringEntity);
                    HttpResponse response = httpClient.execute(httpPost);
                    Log.i(FuncionesComunes.LOGTAG, "Respuesta servidor: " + response.getStatusLine().toString());
                    HttpEntity httpEntity = response.getEntity();
                    if (httpEntity != null) {
                        String result = FuncionesComunes.this.convertStreamToString(httpEntity.getContent());
                        Log.i(FuncionesComunes.LOGTAG, "Resultados a string:" + result);
                        int resultInteger = 0;
                        if (FuncionesComunes.this.isValidNumber(result)) {
                            try {
                                resultInteger = 0 + Integer.parseInt(result);
                            } catch (NumberFormatException nfe) {
                                System.out.println("Could not parse " + nfe);
                            }
                        }
                        if (resultInteger == 1) {
                            Log.i(FuncionesComunes.LOGTAG, "Se ha enviado la información exitosamente");
                        } else {
                            Log.i(FuncionesComunes.LOGTAG, "Cueck");
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e(FuncionesComunes.LOGTAG, "Error Cannot Estabilish Connection: " + e.toString());
                }
                Looper.loop();
            }
        }.start();
    }

    public String obtenerFechaActual() {
        Calendar calendar = Calendar.getInstance();
        int anho = calendar.get(1);
        String mes = String.valueOf(Calendar.getInstance().get(2) + 1);
        if (Integer.valueOf(mes).intValue() < 10) {
            mes = "0" + mes;
        }
        String dia = String.valueOf(calendar.get(5));
        if (Integer.valueOf(dia).intValue() < 10) {
            dia = "0" + dia;
        }
        return new StringBuilder(String.valueOf(anho)).append("-").append(mes).append("-").append(dia).toString();
    }

    public String obtenerTipoDia(Context context) {
        this.datasource = new PeajesDataSource(context);
        String fechaActual = obtenerFechaActual();
        int dia = Calendar.getInstance().get(7);
        this.datasource.openDB();
        List<String> feriados = this.datasource.obtenerFeriados();
        this.datasource.closeDB();
        if (feriados.size() != 0) {
            for (int i = 0; i < feriados.size(); i++) {
                if (((String) feriados.get(i)).equals(fechaActual)) {
                    return "festivo";
                }
            }
        }
        if (dia == 7) {
            return "sabado";
        }
        if (dia == 1) {
            return "domingo";
        }
        return "laboral";
    }

    public String obtenerMinutos() {
        if (Integer.valueOf(String.valueOf(Calendar.getInstance().get(12))).intValue() < 30) {
            return "";
        }
        return "treinta";
    }

    public String obtenerHora() {
        int hora = Calendar.getInstance().get(11);
        String horario = "";
        if (hora == 0) {
            horario = "cero";
        }
        if (hora == 1) {
            horario = "una";
        }
        if (hora == 2) {
            horario = "dos";
        }
        if (hora == 3) {
            horario = "tres";
        }
        if (hora == 4) {
            horario = "cuatro";
        }
        if (hora == 5) {
            horario = "cinco";
        }
        if (hora == 6) {
            horario = "seis";
        }
        if (hora == 7) {
            horario = "siete";
        }
        if (hora == 8) {
            horario = "ocho";
        }
        if (hora == 9) {
            horario = "nueve";
        }
        if (hora == 10) {
            horario = "diez";
        }
        if (hora == 11) {
            horario = "once";
        }
        if (hora == 12) {
            horario = "doce";
        }
        if (hora == 13) {
            horario = "trece";
        }
        if (hora == 14) {
            horario = "catorce";
        }
        if (hora == 15) {
            horario = "quince";
        }
        if (hora == 16) {
            horario = "dieciseis";
        }
        if (hora == 17) {
            horario = "diecisiete";
        }
        if (hora == 18) {
            horario = "dieciocho";
        }
        if (hora == 19) {
            horario = "diecinueve";
        }
        if (hora == 20) {
            horario = "veinte";
        }
        if (hora == 21) {
            horario = "veintiuna";
        }
        if (hora == 22) {
            horario = "veintidos";
        }
        if (hora == 23) {
            horario = "veintitres";
        }
        if (hora == 24) {
            return "veinticuatro";
        }
        return horario;
    }

    public String obtenerDatetime() {
        Calendar calendar = Calendar.getInstance();
        String hora = String.valueOf(calendar.get(11));
        String minutos = String.valueOf(calendar.get(12));
        String segundos = String.valueOf(calendar.get(13));
        if (Integer.valueOf(hora).intValue() < 10) {
            hora = "0" + hora;
        }
        if (Integer.valueOf(minutos).intValue() < 10) {
            minutos = "0" + minutos;
        }
        if (Integer.valueOf(segundos).intValue() < 10) {
            segundos = "0" + segundos;
        }
        String time = new StringBuilder(String.valueOf(hora)).append(":").append(minutos).append(":").append(segundos).toString();
        int anho = calendar.get(1);
        String mes = String.valueOf(Calendar.getInstance().get(2) + 1);
        if (Integer.valueOf(mes).intValue() < 10) {
            mes = "0" + mes;
        }
        String dia = String.valueOf(calendar.get(5));
        if (Integer.valueOf(dia).intValue() < 10) {
            dia = "0" + dia;
        }
        return new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(anho)).append("-").append(mes).append("-").append(dia).toString())).append(" ").append(time).toString();
    }

    public double calcularAngulo(double lat_anterior, double lng_anterior, double lat_actual, double lng_actual) {
        double angulo = (180.0d * Math.atan2(lat_actual - lat_anterior, lng_actual - lng_anterior)) / 3.141592653589793d;
        if (angulo < 0.0d) {
            angulo += 360.0d;
        }
        return angulo + 360.0d;
    }
}
