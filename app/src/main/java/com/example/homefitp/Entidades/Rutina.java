package com.example.homefitp.Entidades;

import java.util.ArrayList;

public class Rutina {
    String id;
    String nombre;
    String idImagen;
    int duracion;
    int gastoEnergia;
    int circuitos;
    ArrayList<DetalleEjercicio> detalleEjercicios;


    public ArrayList<DetalleEjercicio> getDetalleEjercicios() {
        return detalleEjercicios;
    }

    public void setDetalleEjercicios(ArrayList<DetalleEjercicio> detalleEjercicios) {
        this.detalleEjercicios = detalleEjercicios;
    }

    public Rutina(String id, String nombre, String idImagen, int duracion, int gastoEnergia, int circuitos) {
        this.id = id;
        this.nombre = nombre;
        this.idImagen = idImagen;
        this.duracion = duracion;
        this.gastoEnergia = gastoEnergia;
        this.circuitos = circuitos;
    }

    public Rutina(String nombre, String idImagen, int duracion, int gastoEnergia, int circuitos) {
        this.nombre = nombre;
        this.idImagen = idImagen;
        this.duracion = duracion;
        this.gastoEnergia = gastoEnergia;
        this.circuitos = circuitos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(String idImagen) {
        this.idImagen = idImagen;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getGastoEnergia() {
        return gastoEnergia;
    }

    public void setGastoEnergia(int gastoEnergia) {
        this.gastoEnergia = gastoEnergia;
    }

    public int getCircuitos() {
        return circuitos;
    }

    public void setCircuitos(int circuitos) {
        this.circuitos = circuitos;
    }
}
