package com.afinal.libreria;

import android.app.Application;
import java.util.ArrayList;
import java.util.List;

public class GlobalClass extends Application {
    String fecha_inicio = null;
    String fecha_termino = null;
    int flag_fantasma = 0;
    double lat_anterior = 0.0d;
    double latitud;
    double lng_anterior = 0.0d;
    double longitud;
    float precioTotalRecorrido = 0.0f;
    List<Temporal> temporales = new ArrayList();
    String ultimoPeaje;

    public String getUltimoPeaje() {
        return this.ultimoPeaje;
    }

    public void setUltimoPeaje(String ultimoPeaje) {
        this.ultimoPeaje = ultimoPeaje;
    }

    public float getPrecioTotalRecorrido() {
        return this.precioTotalRecorrido;
    }

    public void setPrecioTotalRecorrido(float precioTotalRecorrido) {
        this.precioTotalRecorrido = precioTotalRecorrido;
    }

    public int getFlag_fantasma() {
        return this.flag_fantasma;
    }

    public void setFlag_fantasma(int flag_fantasma) {
        this.flag_fantasma = flag_fantasma;
    }

    public List<Temporal> getTemporales() {
        return this.temporales;
    }

    public void setTemporales(Temporal temporal) {
        this.temporales.add(temporal);
    }

    public double getLat_anterior() {
        return this.lat_anterior;
    }

    public void setLat_anterior(double lat_anterior) {
        this.lat_anterior = lat_anterior;
    }

    public double getLng_anterior() {
        return this.lng_anterior;
    }

    public void setLng_anterior(double lng_anterior) {
        this.lng_anterior = lng_anterior;
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
}
