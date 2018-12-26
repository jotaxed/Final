package com.afinal.libreria;

public class Mes {
    int ano;
    int fecha;
    int id_vehiculo;
    int numero_mes;
    String total;

    public int getFecha() {
        return this.fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
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

    public int getAno() {
        return this.ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getNumero_mes() {
        return this.numero_mes;
    }

    public void setNumero_mes(int numero_mes) {
        this.numero_mes = numero_mes;
    }
}
