package com.example.homefitp.Entidades;

public class Ejercicio {
    int id;
    String nombre;
    String descripcion;
    String instrucciones;
    String idImagen;
    String idAnimacion;
    String dificultad;
    String objetivo;

    public Ejercicio(int id, String nombre, String descripcion, String instrucciones, String idImagen, String idAnimacion, String dificultad, String objetivo) {

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.instrucciones = instrucciones;
        this.idImagen = idImagen;
        this.idAnimacion = idAnimacion;
        this.dificultad = dificultad;
        this.objetivo = objetivo;
    }

    public Ejercicio(String nombre, String descripcion, String instrucciones, String idImagen, String idAnimacion, String dificultad, String objetivo) {

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.instrucciones = instrucciones;
        this.idImagen = idImagen;
        this.idAnimacion = idAnimacion;
        this.dificultad = dificultad;
        this.objetivo = objetivo;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }

    public String getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(String idImagen) {
        this.idImagen = idImagen;
    }

    public String getIdAnimacion() {
        return idAnimacion;
    }

    public void setIdAnimacion(String idAnimacion) {
        this.idAnimacion = idAnimacion;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }
}
