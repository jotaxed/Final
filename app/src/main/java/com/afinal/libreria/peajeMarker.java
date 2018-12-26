package com.afinal.libreria;

public class peajeMarker {
    private float angulo;
    private int id;
    private double latitud;
    private double longitud;
    private String nombreAutopista;
    private String nombrePeaje;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrePeaje() {
        return this.nombrePeaje;
    }

    public void setNombrePeaje(String nombrePeaje) {
        this.nombrePeaje = nombrePeaje;
    }

    public double getLatitud() {
        return this.latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return this.longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public float getAngulo() {
        return this.angulo;
    }

    public void setAngulo(float angulo) {
        this.angulo = angulo;
    }

    public String getNombreAutopista() {
        return this.nombreAutopista;
    }

    public void setNombreAutopista(String nombreAutopista) {
        this.nombreAutopista = nombreAutopista;
    }

    public String toString() {
        return "peajeMarker [id=" + this.id + ", nombrePeaje=" + this.nombrePeaje + ", latitud=" + this.latitud + ", longitud=" + this.longitud + ", angulo=" + this.angulo + ", nombreAutopista=" + this.nombreAutopista + "]";
    }
}
