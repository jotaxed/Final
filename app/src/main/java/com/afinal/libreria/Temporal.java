package com.afinal.libreria;

public class Temporal {
    private String fecha;
    private int id_peaje;
    private float precio;

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

    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String toString() {
        return "Temporal [id_peaje=" + this.id_peaje + ", precio=" + this.precio + ", fecha=" + this.fecha + "]";
    }
}
