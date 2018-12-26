package com.afinal.libreria;

public class Vehiculo {
    private long id;
    private String marca;
    private String modelo;
    private String nombre;
    private String patente;
    private int tipo;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getTipo() {
        return this.tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPatente() {
        return this.patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String toString() {
        return "vehiculo [id=" + this.id + ", tipo=" + this.tipo + ", nombre=" + this.nombre + ", modelo=" + this.modelo + ", marca=" + this.marca + ", patente=" + this.patente + "]";
    }
}
