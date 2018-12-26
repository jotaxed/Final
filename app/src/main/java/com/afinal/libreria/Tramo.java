package com.afinal.libreria;

public class Tramo {
    private String datetime;
    private long id;
    private int id_peaje;
    private int id_recorrido;
    private String nombreAutopista;
    private String nombrePeaje;
    private float precio;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getId_peaje() {
        return this.id_peaje;
    }

    public void setId_peaje(int id_peaje) {
        this.id_peaje = id_peaje;
    }

    public float getPrecio() {
        return this.precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getDatetime() {
        return this.datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public int getId_recorrido() {
        return this.id_recorrido;
    }

    public void setId_recorrido(int id_recorrido) {
        this.id_recorrido = id_recorrido;
    }

    public String getNombrePeaje() {
        return this.nombrePeaje;
    }

    public void setNombrePeaje(String nombrePeaje) {
        this.nombrePeaje = nombrePeaje;
    }

    public String getNombreAutopista() {
        return this.nombreAutopista;
    }

    public void setNombreAutopista(String nombreAutopista) {
        this.nombreAutopista = nombreAutopista;
    }

    public String toString() {
        return "Tramo [id=" + this.id + ", id_peaje=" + this.id_peaje + ", precio=" + this.precio + ", datetime=" + this.datetime + ", id_recorrido=" + this.id_recorrido + ", nombrePeaje=" + this.nombrePeaje + ", nombreAutopista=" + this.nombreAutopista + "]";
    }
}
