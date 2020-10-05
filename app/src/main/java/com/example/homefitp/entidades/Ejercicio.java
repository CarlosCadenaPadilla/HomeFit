package com.example.homefitp.entidades;

public class Ejercicio {
    int id;
    String nombre;
    String descripcion;
    String instrucciones;
    String idImagen;
    String idVideo;
    String dificultad;
    String objetivo;

    //constructor
    public void Ejercicio(){

    }

    //Definiendo los sets

    public void setId(int id){
        this.id=id;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public void setDescripcion(String descripcion){
        this.descripcion=descripcion;
    }

    public void setInstrucciones(String Instrucciones){
        this.instrucciones=instrucciones;
    }

    public void setIdImagen(String idImagen){
        this.idImagen=idImagen;
    }

    public void setIdVideo(String idVideo){
        this.idVideo=idVideo;
    }

    public void setDificultad(String dificultad){
        this.dificultad=dificultad;
    }

    public void setObjetivo(String objetivo){
        this.objetivo=objetivo;
    }

    //Definiendo los gets

    public int getId(){
        return this.id;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getDescripcion(){
        return this.descripcion;
    }

    public String getInstrucciones(){
        return this.instrucciones;
    }

    public String getIdImagen(){
        return this.idImagen;
    }

    public String getIdVideo(){
        return this.idVideo;
    }

    public String getDificultad(){
        return this.dificultad;
    }

    public String getObjetivo(){
        return this.objetivo;
    }
}
