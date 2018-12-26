package com.afinal.libreria;

public class Recorrido {
    private String fecha_inicio;
    private String fecha_termino;
    private long id;
    private int id_vehiculo;
    private String total;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFecha_inicio() {
        return this.fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_termino() {
        return this.fecha_termino;
    }

    public void setFecha_termino(String fecha_termino) {
        this.fecha_termino = fecha_termino;
    }

    public String getTotal() {
        return this.total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public int getId_vehiculo() {
        return this.id_vehiculo;
    }

    public void setId_vehiculo(int id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public String toString() {
        return "Recorrido [id=" + this.id + ", fecha_inicio=" + this.fecha_inicio + ", fecha_termino=" + this.fecha_termino + ", total=" + this.total + ", id_vehiculo=" + this.id_vehiculo + "]";
    }
}
