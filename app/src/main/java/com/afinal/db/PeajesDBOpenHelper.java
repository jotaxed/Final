package com.afinal.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class PeajesDBOpenHelper extends SQLiteOpenHelper {
    private static final String COPIAR_HISTORIAL = "INSERT INTO tramo_tmp SELECT * FROM tramo";
    private static final String COPIAR_RECORRIDO = "INSERT INTO recorrido_tmp SELECT * FROM recorrido";
    private static final String COPIAR_VEHICULO = "INSERT INTO vehiculo_tmp SELECT * FROM vehiculo";
    private static final String DATABASE_NAME = "peajes.db";
    private static final int DATABASE_VERSION = 2;
    private static final String INSERT_AUTOPISTA1 = "INSERT INTO autopista (id,nombre) VALUES (1,'Costanera Norte')";
    private static final String INSERT_AUTOPISTA2 = "INSERT INTO autopista (id,nombre) VALUES (2,'Vespucio Norte')";
    private static final String INSERT_AUTOPISTA3 = "INSERT INTO autopista (id,nombre) VALUES (3,'Vespucio Sur')";
    private static final String INSERT_AUTOPISTA4 = "INSERT INTO autopista (id,nombre) VALUES (4,'Autopista Central')";
    private static final String INSERT_AUTOPISTA5 = "INSERT INTO autopista (id,nombre) VALUES (5,'T. San Cristobal N-S')";
    private static final String INSERT_AUTOPISTA6 = "INSERT INTO autopista (id,nombre) VALUES (6,'T. San Cristobal S-N')";
    private static final String INSERT_AUTOPISTA7 = "INSERT INTO autopista (id,nombre) VALUES (7,'Acceso Vial AMB')";
    private static final String INSERT_FERIADO1 = "INSERT INTO feriado (fecha) VALUES ('2015-01-01')";
    private static final String INSERT_FERIADO10 = "INSERT INTO feriado (fecha) VALUES ('2015-09-19')";
    private static final String INSERT_FERIADO11 = "INSERT INTO feriado (fecha) VALUES ('2015-10-12')";
    private static final String INSERT_FERIADO12 = "INSERT INTO feriado (fecha) VALUES ('2015-10-31')";
    private static final String INSERT_FERIADO13 = "INSERT INTO feriado (fecha) VALUES ('2015-11-01')";
    private static final String INSERT_FERIADO14 = "INSERT INTO feriado (fecha) VALUES ('2015-12-08')";
    private static final String INSERT_FERIADO15 = "INSERT INTO feriado (fecha) VALUES ('2015-12-25')";
    private static final String INSERT_FERIADO16 = "INSERT INTO feriado (fecha) VALUES ('2016-01-01')";
    private static final String INSERT_FERIADO2 = "INSERT INTO feriado (fecha) VALUES ('2015-04-03')";
    private static final String INSERT_FERIADO3 = "INSERT INTO feriado (fecha) VALUES ('2015-04-04')";
    private static final String INSERT_FERIADO4 = "INSERT INTO feriado (fecha) VALUES ('2015-05-01')";
    private static final String INSERT_FERIADO5 = "INSERT INTO feriado (fecha) VALUES ('2015-05-21')";
    private static final String INSERT_FERIADO6 = "INSERT INTO feriado (fecha) VALUES ('2015-06-29')";
    private static final String INSERT_FERIADO7 = "INSERT INTO feriado (fecha) VALUES ('2015-07-16')";
    private static final String INSERT_FERIADO8 = "INSERT INTO feriado (fecha) VALUES ('2015-08-15')";
    private static final String INSERT_FERIADO9 = "INSERT INTO feriado (fecha) VALUES ('2015-09-18')";
    private static final String INSERT_TARIFA1 = "INSERT INTO tarifa (id_autopista, TBFPauto, TBPauto, TSauto, TBFPbus, TBPbus, TSbus, TBFPcamion, TBPcamion, TScamion) VALUES (1, 58, 111, 168, 116, 222, 336, 174, 333, 504)";
    private static final String INSERT_TARIFA2 = "INSERT INTO tarifa (id_autopista, TBFPauto, TBPauto, TSauto, TBFPbus, TBPbus, TSbus, TBFPcamion, TBPcamion, TScamion) VALUES (2, 67.737, 135.485, 162.503, 108.334, 216.670, 325.006, 162.501, 325.005, 487.509)";
    private static final String INSERT_TARIFA3 = "INSERT INTO tarifa (id_autopista, TBFPauto, TBPauto, TSauto, TBFPbus, TBPbus, TSbus, TBFPcamion, TBPcamion, TScamion) VALUES (3, 54.167, 108.335, 162.503, 108.334, 216.670, 325.006, 162.501, 325.005, 487.509)";
    private static final String INSERT_TARIFA4 = "INSERT INTO tarifa (id_autopista, TBFPauto, TBPauto, TSauto, TBFPbus, TBPbus, TSbus, TBFPcamion, TBPcamion, TScamion) VALUES (4, 56.014, 112.028, 168.042, 112.0278, 224.0552, 336.082, 168.041, 336.083, 504.125)";
    private static final String INSERT_TARIFA5 = "INSERT INTO tarifa (id_autopista, TBFPauto, TBPauto, TSauto, TBFPbus, TBPbus, TSbus, TBFPcamion, TBPcamion, TScamion) VALUES (5, 305, 488, 609, 914, 1463, 1828, 1524, 2438, 3047)";
    private static final String INSERT_TARIFA6 = "INSERT INTO tarifa (id_autopista, TBFPauto, TBPauto, TSauto, TBFPbus, TBPbus, TSbus, TBFPcamion, TBPcamion, TScamion) VALUES (6, 244, 366,  1, 731, 1097, 1, 1219, 1828, 1)";
    private static final String INSERT_TARIFA7 = "INSERT INTO tarifa (id_autopista, TBFPauto, TBPauto, TSauto, TBFPbus, TBPbus, TSbus, TBFPcamion, TBPcamion, TScamion) VALUES (7,481 ,481 ,481 ,962 ,962 ,962 ,1443 ,1443 ,1443);";
    private static final String LOGTAG = "Creando DB";
    private static final String REPLICAR_HISTORIAL = "INSERT INTO tramo SELECT * FROM tramo_tmp";
    private static final String REPLICAR_RECORRIDO = "INSERT INTO recorrido SELECT * FROM recorrido_tmp";
    private static final String REPLICAR_VEHICULO = "INSERT INTO vehiculo SELECT * FROM vehiculo_tmp";
    private static final String TABLE_AUTOPISTA = "autopista";
    private static final String TABLE_CREATE_AUTOPISTA = "CREATE TABLE autopista (id INT, nombre TEXT)";
    private static final String TABLE_CREATE_FERIADO = "CREATE TABLE feriado (id INTEGER PRIMARY KEY AUTOINCREMENT, fecha datetime)";
    private static final String TABLE_CREATE_HISTORIAL = "CREATE TABLE tramo(id INTEGER PRIMARY KEY AUTOINCREMENT, id_peaje int, fecha TEXT, precio TEXT, id_recorrido INT, FOREIGN KEY(id_peaje) REFERENCES peaje(id), FOREIGN KEY(id_recorrido) REFERENCES recorrido(id))";
    private static final String TABLE_CREATE_HISTORIAL_TEMPORAL = "CREATE TABLE tramo_tmp(id INTEGER PRIMARY KEY AUTOINCREMENT, id_peaje int, fecha TEXT, precio TEXT, id_recorrido INT, FOREIGN KEY(id_peaje) REFERENCES peaje(id), FOREIGN KEY(id_recorrido) REFERENCES recorrido(id))";
    private static final String TABLE_CREATE_HORARIO = "CREATE TABLE horario (id_peaje int,tipoDia TEXT,cero INT,cerotreinta INT,una INT,unatreinta INT, dos INT, dostreinta INT, tres INT, trestreinta INT, cuatro INT, cuatrotreinta INT, cinco INT, cincotreinta INT, seis INT, seistreinta INT, siete INT, sietetreinta INT, ocho INT, ochotreinta INT, nueve INT, nuevetreinta INT, diez INT, dieztreinta INT, once INT, oncetreinta INT, doce INT, docetreinta INT, trece INT, trecetreinta INT, catorce INT, catorcetreinta INT, quince INT, quincetreinta INT, dieciseis INT, dieciseistreinta INT, diecisiete INT, diecisietetreinta INT, dieciocho INT, dieciochotreinta INT, diecinueve INT, diecinuevetreinta INT, veinte INT, veintetreinta INT, veintiuna INT, veintiunatreinta INT, veintidos INT, veintidostreinta INT, veintitres INT, veintitrestreinta INT,FOREIGN KEY(id_peaje) REFERENCES peaje(id))";
    private static final String TABLE_CREATE_PEAJE = "CREATE TABLE peaje (id INT, nombrePeaje TEXT, autopista INT, distancia INT, latitud INT, longitud INT, latSup INT, latInf INT, longSup INT, longInf INT, angulo INT,anguloMin INT,anguloMax INT, FOREIGN KEY(autopista) REFERENCES autopista(id))";
    private static final String TABLE_CREATE_RECORRIDO = "CREATE TABLE recorrido(id INTEGER PRIMARY KEY AUTOINCREMENT,fecha_inicio DATETIME, fecha_termino DATETIME, total TEXT, id_vehiculo INT, FOREIGN KEY(id_vehiculo) REFERENCES vehiculo(id))";
    private static final String TABLE_CREATE_RECORRIDO_TEMPORAL = "CREATE TABLE recorrido_tmp(id INTEGER PRIMARY KEY AUTOINCREMENT,fecha_inicio DATETIME, fecha_termino DATETIME, total TEXT, id_vehiculo INT, FOREIGN KEY(id_vehiculo) REFERENCES vehiculo(id))";
    private static final String TABLE_CREATE_TARIFA = "CREATE TABLE tarifa (id INTEGER PRIMARY KEY autoincrement, id_autopista INT, TBFPauto INT, TBPauto INT, TSauto INT, TBFPbus INT, TBPbus INT, TSbus INT, TBFPcamion INT, TBPcamion INT, TScamion INT, FOREIGN KEY(id_autopista) REFERENCES autopista(id))";
    private static final String TABLE_CREATE_VEHICULO = "CREATE TABLE vehiculo(id INTEGER PRIMARY KEY AUTOINCREMENT,nombre TEXT, patente TEXT, modelo TEXT, marca TEXT, tipo INT)";
    private static final String TABLE_CREATE_VEHICULO_TEMPORAL = "CREATE TABLE vehiculo_tmp(id INTEGER PRIMARY KEY AUTOINCREMENT,nombre TEXT, patente TEXT, modelo TEXT, marca TEXT, tipo INT)";
    private static final String TABLE_FERIADO = "feriado";
    private static final String TABLE_HISTORIAL = "tramo";
    private static final String TABLE_HISTORIAL_TEMPORAL = "tramo_tmp";
    private static final String TABLE_HORARIO = "horario";
    private static final String TABLE_PEAJE = "peaje";
    private static final String TABLE_RECORRIDO = "recorrido";
    private static final String TABLE_RECORRIDO_TEMPORAL = "recorrido_tmp";
    private static final String TABLE_TARIFA = "tarifa";
    private static final String TABLE_VEHICULO = "vehiculo";
    private static final String TABLE_VEHICULO_TEMPORAL = "vehiculo_tmp";
    Context context;

    public PeajesDBOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, 2);
        this.context = context;
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE_AUTOPISTA);
        Log.i(LOGTAG, "La tabla autopista fue creada");
        db.execSQL(INSERT_AUTOPISTA1);
        db.execSQL(INSERT_AUTOPISTA2);
        db.execSQL(INSERT_AUTOPISTA3);
        db.execSQL(INSERT_AUTOPISTA4);
        db.execSQL(INSERT_AUTOPISTA5);
        db.execSQL(INSERT_AUTOPISTA6);
        db.execSQL(INSERT_AUTOPISTA7);
        Log.i(LOGTAG, "Se insertaron los registros de la autopista");
        db.execSQL(TABLE_CREATE_TARIFA);
        Log.i(LOGTAG, "La tabla tarifa fue creada");
        db.execSQL("INSERT INTO tarifa (id_autopista, TBFPauto, TBPauto, TSauto, TBFPbus, TBPbus, TSbus, TBFPcamion, TBPcamion, TScamion) VALUES (1, 70, 134, 204, 140, 268, 408, 210, 402, 612)");
        db.execSQL("INSERT INTO tarifa (id_autopista, TBFPauto, TBPauto, TSauto, TBFPbus, TBPbus, TSbus, TBFPcamion, TBPcamion, TScamion) VALUES (2, 65.479, 130.958, 196.437, 130.958, 261.916, 392.874, 196.437, 392.874, 589.311)");
        db.execSQL("INSERT INTO tarifa (id_autopista, TBFPauto, TBPauto, TSauto, TBFPbus, TBPbus, TSbus, TBFPcamion, TBPcamion, TScamion) VALUES (3, 65.479, 130.958, 196.437, 130.958, 261.916, 392.874, 196.437, 392.874, 589.311)");
        db.execSQL("INSERT INTO tarifa (id_autopista, TBFPauto, TBPauto, TSauto, TBFPbus, TBPbus, TSbus, TBFPcamion, TBPcamion, TScamion) VALUES (4, 67.710, 135.421, 203.132, 112.0278, 224.0552, 336.082, 168.041, 336.083, 504.125)");
        db.execSQL("INSERT INTO tarifa (id_autopista, TBFPauto, TBPauto, TSauto, TBFPbus, TBPbus, TSbus, TBFPcamion, TBPcamion, TScamion) VALUES (5, 368, 589, 737, 1105, 1768, 2210, 1842, 2947, 3683)");
        db.execSQL("INSERT INTO tarifa (id_autopista, TBFPauto, TBPauto, TSauto, TBFPbus, TBPbus, TSbus, TBFPcamion, TBPcamion, TScamion) VALUES (6, 295, 442,  1, 884, 1326, 1, 1473, 2210, 1)");
        db.execSQL(INSERT_TARIFA7);
        Log.i(LOGTAG, "Se insertaron los registros de tarifa");
        db.execSQL(TABLE_CREATE_FERIADO);
        Log.i(LOGTAG, "La tabla feriado fue creada");
        db.execSQL(INSERT_FERIADO1);
        db.execSQL(INSERT_FERIADO2);
        db.execSQL(INSERT_FERIADO3);
        db.execSQL(INSERT_FERIADO4);
        db.execSQL(INSERT_FERIADO5);
        db.execSQL(INSERT_FERIADO6);
        db.execSQL(INSERT_FERIADO7);
        db.execSQL(INSERT_FERIADO8);
        db.execSQL(INSERT_FERIADO9);
        db.execSQL(INSERT_FERIADO10);
        db.execSQL(INSERT_FERIADO11);
        db.execSQL(INSERT_FERIADO12);
        db.execSQL(INSERT_FERIADO13);
        db.execSQL(INSERT_FERIADO14);
        db.execSQL(INSERT_FERIADO15);
        db.execSQL(INSERT_FERIADO16);
        Log.i(LOGTAG, "Se insertaron los registros de feriado");
        db.execSQL(TABLE_CREATE_PEAJE);
        Log.i(LOGTAG, "La tabla peaje fue creada");
        db.execSQL(TABLE_CREATE_HORARIO);
        Log.i(LOGTAG, "La tabla horario fue creada");
        db.execSQL(TABLE_CREATE_VEHICULO);
        Log.i(LOGTAG, "La tabla vehiculo fue creada");
        db.execSQL(TABLE_CREATE_RECORRIDO);
        Log.i(LOGTAG, "La tabla recorrido fue creada");
        db.execSQL(TABLE_CREATE_HISTORIAL);
        Log.i(LOGTAG, "La tabla historial fue creada");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(LOGTAG, String.format("onUpgrade (%d -> %d)", new Object[]{Integer.valueOf(oldVersion), Integer.valueOf(newVersion)}));
        switch (newVersion) {
            case 2:
                Log.d(LOGTAG, "Hay que respaldar data del usuario, crear tablas temporales");
                db.execSQL(TABLE_CREATE_VEHICULO_TEMPORAL);
                Log.i(LOGTAG, "La tabla vehiculo temporal fue creada");
                db.execSQL(TABLE_CREATE_RECORRIDO_TEMPORAL);
                Log.i(LOGTAG, "La tabla recorrido temporal fue creada");
                db.execSQL(TABLE_CREATE_HISTORIAL_TEMPORAL);
                Log.i(LOGTAG, "La tabla historial temporal fue creada");
                db.execSQL(COPIAR_VEHICULO);
                Log.d(LOGTAG, "se copio vehiculo");
                db.execSQL(COPIAR_RECORRIDO);
                Log.d(LOGTAG, "se copio recorrido");
                db.execSQL(COPIAR_HISTORIAL);
                Log.d(LOGTAG, "se copio historial");
                Log.d(LOGTAG, "Hay que borrar todo");
                db.execSQL("DROP TABLE IF EXISTS autopista");
                db.execSQL("DROP TABLE IF EXISTS tarifa");
                db.execSQL("DROP TABLE IF EXISTS feriado");
                db.execSQL("DROP TABLE IF EXISTS peaje");
                db.execSQL("DROP TABLE IF EXISTS horario");
                db.execSQL("DROP TABLE IF EXISTS vehiculo");
                db.execSQL("DROP TABLE IF EXISTS recorrido");
                db.execSQL("DROP TABLE IF EXISTS tramo");
                Log.d(LOGTAG, "Se borro todo, crear de nuevo");
                onCreate(db);
                db.execSQL(REPLICAR_VEHICULO);
                db.execSQL(REPLICAR_RECORRIDO);
                db.execSQL(REPLICAR_HISTORIAL);
                Log.d(LOGTAG, "se replico todo asi q borrar tablas temporales");
                db.execSQL("DROP TABLE IF EXISTS vehiculo_tmp");
                db.execSQL("DROP TABLE IF EXISTS recorrido_tmp");
                db.execSQL("DROP TABLE IF EXISTS tramo_tmp");
                Log.d(LOGTAG, "FIN borrar tablas temporales");
                return;
            case 3:
                Log.d(LOGTAG, "Ya se acualizó la bd");
                return;
            default:
                throw new IllegalStateException("onUpgrade() with unknown newVersion" + newVersion);
        }
    }
}
