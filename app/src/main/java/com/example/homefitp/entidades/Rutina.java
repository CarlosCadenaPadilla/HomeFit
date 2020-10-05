package com.example.homefitp.entidades;

import java.util.ArrayList;

public class Rutina {
    String id;
    int repeticiones;
    int tiempo;
    ArrayList listaEjercicios;

    //Constructor
    public void Rutina(){

    }

    //Definiendo los sets
    public void setId(String id){
        this.id=id;
    }

    public void setRepeticiones(int repeticiones){
        this.repeticiones=repeticiones;
    }

    public void setTiempo(int tiempo){
        this.tiempo=tiempo;
    }

    public void setListaEjercicios(ArrayList listaEjercicios){
        this.listaEjercicios=listaEjercicios;
    }

    //Definiendo los gets

    public String getId(){
        return this.id;
    }

    public int getRepeticiones(){
        return this.repeticiones;
    }

    public int getTiempo(){
        return this.tiempo;
    }

    public ArrayList getListaEjercicios(){
        return this.listaEjercicios;
    }
}
