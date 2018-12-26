package com.afinal.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.afinal.libreria.Mes;
import com.afinal.libreria.Recorrido;
import com.afinal.libreria.Tramo;
import com.afinal.libreria.Vehiculo;
import com.afinal.libreria.peajeMarker;
import java.util.ArrayList;
import java.util.List;

public class PeajesDataSource {
    private static final String LOGTAG = "DB";
    SQLiteDatabase database;
    SQLiteOpenHelper dbhelper;

    public PeajesDataSource(Context context) {
        this.dbhelper = new PeajesDBOpenHelper(context);
    }

    public void openDB() {
        Log.i(LOGTAG, "DB abierta");
        this.database = this.dbhelper.getWritableDatabase();
    }

    public void closeDB() {
        Log.i(LOGTAG, "DB cerrada");
        this.dbhelper.close();
    }

    public void create(int id_peaje, String nombrePeaje, int autopista, double distancia, double latitud, double longitud, float angulo) {
        double radio = 9.000009E-4d / 2.0d;
        double latSup = latitud + radio;
        double longSup = longitud + radio;
        double latInf = latitud - radio;
        double longInf = longitud - radio;
        float anguloMax = angulo + 45.0f;
        float anguloMin = angulo - 45.0f;
        ContentValues peaje = new ContentValues();
        peaje.put("id", Integer.valueOf(id_peaje));
        peaje.put("nombrePeaje", nombrePeaje);
        peaje.put("autopista", Integer.valueOf(autopista));
        peaje.put("distancia", Double.valueOf(distancia));
        peaje.put("latitud", Double.valueOf(latitud));
        peaje.put("longitud", Double.valueOf(longitud));
        peaje.put("latSup", Double.valueOf(latSup));
        peaje.put("latInf", Double.valueOf(latInf));
        peaje.put("longSup", Double.valueOf(longSup));
        peaje.put("longInf", Double.valueOf(longInf));
        peaje.put("angulo", Float.valueOf(angulo));
        peaje.put("anguloMin", Float.valueOf(anguloMin));
        peaje.put("anguloMax", Float.valueOf(anguloMax));
        this.database.insert("peaje", null, peaje);
    }

    public void createHorario(int id_peaje, String tipoDia, int cero, int cerotreinta, int una, int unatreinta, int dos, int dostreinta, int tres, int trestreinta, int cuatro, int cuatrotreinta, int cinco, int cincotreinta, int seis, int seistreinta, int siete, int sietetreinta, int ocho, int ochotreinta, int nueve, int nuevetreinta, int diez, int dieztreinta, int once, int oncetreinta, int doce, int docetreinta, int trece, int trecetreinta, int catorce, int catorcetreinta, int quince, int quincetreinta, int dieciseis, int dieciseistreinta, int diecisiete, int diecisietetreinta, int dieciocho, int dieciochotreinta, int diecinueve, int diecinuevetreinta, int veinte, int veintetreinta, int veintiuna, int veintiunatreinta, int veintidos, int veintidostreinta, int veintitres, int veintitrestreinta) {
        ContentValues horario = new ContentValues();
        horario.put("id_peaje", Integer.valueOf(id_peaje));
        horario.put("tipoDia", tipoDia);
        horario.put("cero", Integer.valueOf(cero));
        horario.put("cerotreinta", Integer.valueOf(cerotreinta));
        horario.put("una", Integer.valueOf(una));
        horario.put("unatreinta", Integer.valueOf(unatreinta));
        horario.put("dos", Integer.valueOf(dos));
        horario.put("dostreinta", Integer.valueOf(dostreinta));
        horario.put("tres", Integer.valueOf(tres));
        horario.put("trestreinta", Integer.valueOf(trestreinta));
        horario.put("cuatro", Integer.valueOf(cuatro));
        horario.put("cuatrotreinta", Integer.valueOf(cuatrotreinta));
        horario.put("cinco", Integer.valueOf(cinco));
        horario.put("cincotreinta", Integer.valueOf(cincotreinta));
        horario.put("seis", Integer.valueOf(seis));
        horario.put("seistreinta", Integer.valueOf(seistreinta));
        horario.put("siete", Integer.valueOf(siete));
        horario.put("sietetreinta", Integer.valueOf(sietetreinta));
        horario.put("ocho", Integer.valueOf(ocho));
        horario.put("ochotreinta", Integer.valueOf(ochotreinta));
        horario.put("nueve", Integer.valueOf(nueve));
        horario.put("nuevetreinta", Integer.valueOf(nuevetreinta));
        horario.put("diez", Integer.valueOf(diez));
        horario.put("dieztreinta", Integer.valueOf(dieztreinta));
        horario.put("once", Integer.valueOf(once));
        horario.put("oncetreinta", Integer.valueOf(oncetreinta));
        horario.put("doce", Integer.valueOf(doce));
        horario.put("docetreinta", Integer.valueOf(docetreinta));
        horario.put("trece", Integer.valueOf(trece));
        horario.put("trecetreinta", Integer.valueOf(trecetreinta));
        horario.put("catorce", Integer.valueOf(catorce));
        horario.put("catorcetreinta", Integer.valueOf(catorcetreinta));
        horario.put("quince", Integer.valueOf(quince));
        horario.put("quincetreinta", Integer.valueOf(quincetreinta));
        horario.put("dieciseis", Integer.valueOf(dieciseis));
        horario.put("dieciseistreinta", Integer.valueOf(dieciseistreinta));
        horario.put("diecisiete", Integer.valueOf(diecisiete));
        horario.put("diecisietetreinta", Integer.valueOf(diecisietetreinta));
        horario.put("dieciocho", Integer.valueOf(dieciocho));
        horario.put("dieciochotreinta", Integer.valueOf(dieciochotreinta));
        horario.put("diecinueve", Integer.valueOf(diecinueve));
        horario.put("diecinuevetreinta", Integer.valueOf(diecinuevetreinta));
        horario.put("veinte", Integer.valueOf(veinte));
        horario.put("veintetreinta", Integer.valueOf(veintetreinta));
        horario.put("veintiuna", Integer.valueOf(veintiuna));
        horario.put("veintiunatreinta", Integer.valueOf(veintiunatreinta));
        horario.put("veintidos", Integer.valueOf(veintidos));
        horario.put("veintidostreinta", Integer.valueOf(veintidostreinta));
        horario.put("veintitres", Integer.valueOf(veintitres));
        horario.put("veintitrestreinta", Integer.valueOf(veintitrestreinta));
        this.database.insert("horario", null, horario);
    }

    public int getCountHorario() {
        Cursor dataCount = this.database.rawQuery("SELECT count(*) from horario ", null);
        dataCount.moveToFirst();
        return dataCount.getInt(0);
    }

    public int getCountPeaje() {
        Cursor dataCount = this.database.rawQuery("SELECT count(*) FROM peaje", null);
        dataCount.moveToFirst();
        return dataCount.getInt(0);
    }

    public List<peajeMarker> findAll() {
        List<peajeMarker> peajesMarker = new ArrayList();
        Cursor cursorQuery = this.database.rawQuery("SELECT nombrePeaje, latitud, longitud, angulo, nombre from peaje, autopista WHERE peaje.autopista = autopista.id", null);
        if (cursorQuery.getCount() > 0) {
            while (cursorQuery.moveToNext()) {
                peajeMarker peajeMarker = new peajeMarker();
                peajeMarker.setNombrePeaje(cursorQuery.getString(cursorQuery.getColumnIndex("nombrePeaje")));
                peajeMarker.setLatitud(cursorQuery.getDouble(cursorQuery.getColumnIndex("latitud")));
                peajeMarker.setLongitud(cursorQuery.getDouble(cursorQuery.getColumnIndex("longitud")));
                peajeMarker.setAngulo(cursorQuery.getFloat(cursorQuery.getColumnIndex("angulo")));
                peajeMarker.setNombreAutopista(cursorQuery.getString(cursorQuery.getColumnIndex("nombre")));
                peajesMarker.add(peajeMarker);
            }
        }
        return peajesMarker;
    }

    public List<String> obtenerFeriados() {
        String[] feriadoColumnas = new String[]{"fecha"};
        List<String> feriados = new ArrayList();
        Cursor cursor = this.database.query("feriado", feriadoColumnas, null, null, null, null, "id");
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                feriados.add(cursor.getString(cursor.getColumnIndex("fecha")));
            }
        }
        return feriados;
    }

    public List<String> obtenerPeajes(String hora, double latitud, double longitud, double angulo, String tipoDia) {
        List<String> peajes = new ArrayList();
        Cursor cursor = this.database.rawQuery("SELECT distinct nombre, peaje.nombrePeaje, peaje.distancia, peaje.id as id_peaje, autopista.id as autopista_id, horario." + hora + " as hora FROM peaje, autopista, tarifa, horario where latSup > " + latitud + " and latInf < " + latitud + " and longSup > " + longitud + " and longInf < " + longitud + " and anguloMin < " + angulo + " and anguloMax > " + angulo + " and peaje.autopista = autopista.id and autopista.id = tarifa.id_autopista and horario.id_peaje = peaje.id and horario.tipoDia = " + "'" + tipoDia + "'", null);
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                peajes.add(cursor.getString(cursor.getColumnIndex("nombrePeaje")));
                peajes.add(cursor.getString(cursor.getColumnIndex("distancia")));
                peajes.add(cursor.getString(cursor.getColumnIndex("autopista_id")));
                peajes.add(cursor.getString(cursor.getColumnIndex("hora")));
                peajes.add(cursor.getString(cursor.getColumnIndex("id_peaje")));
                peajes.add(cursor.getString(cursor.getColumnIndex("nombre")));
            }
        }
        return peajes;
    }

    public float obtenerTarifa(String id_autopista, String horario, int vehiculo) {
        if (vehiculo < 6) {
            vehiculo = 1;
        }
        if (vehiculo > 5 && vehiculo < 8) {
            vehiculo = 2;
        }
        if (vehiculo > 7) {
            vehiculo = 3;
        }
        String tipoTarifa = "";
        String tarifa = "";
        int horario_int = Integer.valueOf(horario).intValue();
        if (vehiculo == 1 && horario_int == 1) {
            tipoTarifa = "TBFPauto";
        }
        if (vehiculo == 1 && horario_int == 2) {
            tipoTarifa = "TBPauto";
        }
        if (vehiculo == 1 && horario_int == 3) {
            tipoTarifa = "TSauto";
        }
        if (vehiculo == 2 && horario_int == 1) {
            tipoTarifa = "TBFPbus";
        }
        if (vehiculo == 2 && horario_int == 2) {
            tipoTarifa = "TBPbus";
        }
        if (vehiculo == 2 && horario_int == 3) {
            tipoTarifa = "TSbus";
        }
        if (vehiculo == 3 && horario_int == 1) {
            tipoTarifa = "TBFPcamion";
        }
        if (vehiculo == 3 && horario_int == 2) {
            tipoTarifa = "TBPcamion";
        }
        if (vehiculo == 3 && horario_int == 3) {
            tipoTarifa = "TScamion";
        }
        String query = "SELECT " + tipoTarifa + " FROM tarifa where id_autopista = ?";
        Cursor cursor = this.database.rawQuery(query, new String[]{id_autopista});
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                tarifa = cursor.getString(cursor.getColumnIndex(tipoTarifa));
            }
        }
        return Float.valueOf(tarifa).floatValue();
    }

    public Vehiculo insertarVehiculo(Vehiculo vehiculo) {
        ContentValues valores = new ContentValues();
        valores.put("nombre", vehiculo.getNombre());
        valores.put("patente", vehiculo.getPatente());
        valores.put("modelo", vehiculo.getModelo());
        valores.put("marca", vehiculo.getMarca());
        valores.put("tipo", Integer.valueOf(vehiculo.getTipo()));
        vehiculo.setId(this.database.insert("vehiculo", null, valores));
        return vehiculo;
    }

    public List<Vehiculo> findVehiculos() {
        List<Vehiculo> vehiculos = new ArrayList();
        Cursor cursor = this.database.query("vehiculo", null, null, null, null, null, "id");
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                Vehiculo vehiculo = new Vehiculo();
                vehiculo.setId(cursor.getLong(cursor.getColumnIndex("id")));
                vehiculo.setTipo(cursor.getInt(cursor.getColumnIndex("tipo")));
                vehiculo.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));
                vehiculo.setPatente(cursor.getString(cursor.getColumnIndex("patente")));
                vehiculo.setModelo(cursor.getString(cursor.getColumnIndex("modelo")));
                vehiculo.setMarca(cursor.getString(cursor.getColumnIndex("marca")));
                vehiculos.add(vehiculo);
            }
        }
        return vehiculos;
    }

    public boolean eliminarVehiculo(long id) {
        if (this.database.delete("vehiculo", "id = " + id, null) == 1) {
            return true;
        }
        return false;
    }

    public boolean eliminarRecorridoId_vehiculo(long id_vehiculo) {
        if (this.database.delete("recorrido", "id_vehiculo = " + id_vehiculo, null) == 1) {
            return true;
        }
        return false;
    }

    public boolean eliminarRecorridoId_recorrido(long id_recorrido) {
        if (this.database.delete("recorrido", "id = " + id_recorrido, null) == 1) {
            return true;
        }
        return false;
    }

    public boolean eliminarTramo(int id_recorrido) {
        return this.database.delete("tramo", new StringBuilder("id_recorrido = ").append(id_recorrido).toString(), null) != 0;
    }

    public Recorrido insertarRecorrido(Recorrido recorrido) {
        ContentValues valores = new ContentValues();
        valores.put("fecha_inicio", recorrido.getFecha_inicio());
        valores.put("fecha_termino", recorrido.getFecha_termino());
        valores.put("total", recorrido.getTotal());
        valores.put("id_vehiculo", Integer.valueOf(recorrido.getId_vehiculo()));
        recorrido.setId(this.database.insert("recorrido", null, valores));
        return recorrido;
    }

    public List<Vehiculo> obtenerVehiculosConRecorrido() {
        List<Vehiculo> vehiculosRecorrido = new ArrayList();
        Cursor cursor = this.database.rawQuery("SELECT distinct id_vehiculo, nombre FROM recorrido, vehiculo WHERE vehiculo.id = recorrido.id_vehiculo ORDER BY id_vehiculo", null);
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                Vehiculo vehiculo = new Vehiculo();
                vehiculo.setId(cursor.getLong(cursor.getColumnIndex("id_vehiculo")));
                vehiculo.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));
                vehiculosRecorrido.add(vehiculo);
            }
        }
        return vehiculosRecorrido;
    }

    public List<Recorrido> obtenerRecorridoVehiculo(int id_vehiculo) {
        List<Recorrido> recorridosVehiculo = new ArrayList();
        Cursor cursor = this.database.rawQuery("SELECT distinct id_recorrido FROM recorrido WHERE id_vehiculo = " + id_vehiculo + " ORDER BY id_vehiculo", null);
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                Recorrido recorrido = new Recorrido();
                recorrido.setId(cursor.getLong(cursor.getColumnIndex("id_recorrido")));
                recorridosVehiculo.add(recorrido);
            }
        }
        return recorridosVehiculo;
    }

    public List<Recorrido> obtenerRecorrido(int id_vehiculo) {
        List<Recorrido> recorridos = new ArrayList();
        Cursor cursor = this.database.rawQuery("SELECT * FROM recorrido WHERE id_vehiculo = " + id_vehiculo + ";", null);
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                Recorrido recorrido = new Recorrido();
                recorrido.setId((long) cursor.getInt(cursor.getColumnIndex("id")));
                recorrido.setId_vehiculo(cursor.getInt(cursor.getColumnIndex("id_vehiculo")));
                recorrido.setFecha_inicio(cursor.getString(cursor.getColumnIndex("fecha_inicio")));
                recorrido.setFecha_termino(cursor.getString(cursor.getColumnIndex("fecha_termino")));
                recorrido.setTotal(cursor.getString(cursor.getColumnIndex("total")));
                recorridos.add(recorrido);
            }
        }
        return recorridos;
    }

    public List<Recorrido> obtenerRecorridoPorMes(int id_vehiculo, int mes, int ano) {
        List<Recorrido> recorridos = new ArrayList();
        String query = "SELECT * FROM recorrido WHERE id_vehiculo = " + id_vehiculo + ";";
        String query2 = "SELECT id, strftime('%H:%M:%S %d/%m/%Y', fecha_inicio) as fecha_inicio, strftime('%H:%M:%S %d/%m/%Y', fecha_termino) as fecha_termino, total, id_vehiculo FROM recorrido WHERE id_vehiculo = " + id_vehiculo + " and " + "strftime('%m', fecha_termino) = " + mes + " and " + "strftime('%Y', fecha_termino) = " + ano + " " + "ORDER BY id ASC";
        Cursor cursor = this.database.rawQuery(query, null);
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                Recorrido recorrido = new Recorrido();
                recorrido.setId((long) cursor.getInt(cursor.getColumnIndex("id")));
                recorrido.setId_vehiculo(cursor.getInt(cursor.getColumnIndex("id_vehiculo")));
                recorrido.setFecha_inicio(cursor.getString(cursor.getColumnIndex("fecha_inicio")));
                recorrido.setFecha_termino(cursor.getString(cursor.getColumnIndex("fecha_termino")));
                recorrido.setTotal(cursor.getString(cursor.getColumnIndex("total")));
                recorridos.add(recorrido);
            }
        }
        return recorridos;
    }

    public boolean actualizarRecorrido(long id_recorrido, String total, String fecha_inicio, String fecha_termino) {
        ContentValues values = new ContentValues();
        values.put("total", total);
        values.put("fecha_inicio", fecha_inicio);
        values.put("fecha_termino", fecha_termino);
        if (this.database.update("recorrido", values, "id = ?", new String[]{String.valueOf(id_recorrido)}) == 1) {
            return true;
        }
        return false;
    }

    public Tramo insertarTramo(Tramo tramo) {
        ContentValues valores = new ContentValues();
        valores.put("id_peaje", Integer.valueOf(tramo.getId_peaje()));
        valores.put("fecha", tramo.getDatetime());
        valores.put("precio", Float.valueOf(tramo.getPrecio()));
        valores.put("id_recorrido", Integer.valueOf(tramo.getId_recorrido()));
        tramo.setId(this.database.insert("tramo", null, valores));
        return tramo;
    }

    public List<Tramo> obtenerTramo(int id_recorrido) {
        List<Tramo> tramos = new ArrayList();
        Cursor cursor = this.database.rawQuery("SELECT tramo.id as id_tramo, id_recorrido, precio, fecha, nombrePeaje, nombre as nombreAutopista FROM tramo, recorrido, peaje, autopista WHERE  tramo.id_peaje = peaje.id and recorrido.id = tramo.id_recorrido and autopista.id = peaje.autopista and id_recorrido = " + id_recorrido + ";", null);
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                Tramo tramo = new Tramo();
                tramo.setPrecio(cursor.getFloat(cursor.getColumnIndex("precio")));
                tramo.setDatetime(cursor.getString(cursor.getColumnIndex("fecha")));
                tramo.setNombrePeaje(cursor.getString(cursor.getColumnIndex("nombrePeaje")));
                tramo.setNombreAutopista(cursor.getString(cursor.getColumnIndex("nombreAutopista")));
                tramo.setId(cursor.getLong(cursor.getColumnIndex("id_tramo")));
                tramo.setId_recorrido(cursor.getInt(cursor.getColumnIndex("id_recorrido")));
                tramos.add(tramo);
            }
        }
        return tramos;
    }

    public List<Mes> obtenerMeses(int id_vehiculo) {
        Log.i(LOGTAG, "Obtener meses");
        List<Mes> meses = new ArrayList();
        Cursor cursor = this.database.rawQuery("SELECT id, strftime('%m', fecha_inicio) as mes,SUM(total) as total, id_vehiculo, strftime('%Y', fecha_inicio) as ano FROM recorrido WHERE id_vehiculo = " + id_vehiculo + " GROUP BY strftime('%m%Y', fecha_inicio) ORDER BY id DESC", null);
        Log.i(LOGTAG, "Filas retornadas meses: " + cursor.getCount());
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                Mes mes = new Mes();
                mes.setFecha(cursor.getInt(cursor.getColumnIndex("mes")));
                mes.setAno(cursor.getInt(cursor.getColumnIndex("ano")));
                mes.setId_vehiculo(cursor.getInt(cursor.getColumnIndex("id_vehiculo")));
                mes.setTotal(cursor.getString(cursor.getColumnIndex("total")));
                Log.i(LOGTAG, "fecha: " + cursor.getString(cursor.getColumnIndex("mes")));
                Log.i(LOGTAG, "año: " + cursor.getInt(cursor.getColumnIndex("ano")));
                Log.i(LOGTAG, "id_vehiculo: " + cursor.getInt(cursor.getColumnIndex("id_vehiculo")));
                Log.i(LOGTAG, "total: " + cursor.getString(cursor.getColumnIndex("total")));
                meses.add(mes);
            }
        }
        return meses;
    }
}
