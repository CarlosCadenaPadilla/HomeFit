package com.example.homefitp.entidades;

public class Usuario {
    int id;
    String nombre;
    String correo;
    String contraseña;
    String edad;
    String sexo;
    String estatura;
    String peso;
    String dificultad_deseada;
    String objetivo;

    //Constructor
    public void Usuario(){

    }

    //Definiendo los sets

    public void setId(int id){
        this.id=id;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public void setCorreo(String correo){
        this.correo=correo;
    }

    public void setContraseña(String contraseña){
        this.contraseña=contraseña;
    }

    public void setEdad(String edad){
        this.edad=edad;
    }

    public void setSexo(String sexo){
        this.sexo=sexo;
    }

    public void setEstatura(String estatura){
        this.estatura=estatura;
    }

    public void setPeso(String peso){
        this.peso=peso;
    }

    public void setDificultad_deseada(String dificultad_deseada){
        this.dificultad_deseada=dificultad_deseada;
    }

    public void setObjetivo(String dificultad_deseada){
        this.dificultad_deseada=dificultad_deseada;
    }

    //Definiendo los gets

    public int getId(){
        return this.id;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getCorreo(){
        return this.correo;
    }

    public String getContraseña(){
        return this.contraseña;
    }

    public String getEdad(){
        return this.edad;
    }

    public String getSexo(){
        return this.sexo;
    }

    public String getEstatura(){
        return this.estatura;
    }

    public String getPeso(){
        return this.peso;
    }

    public String getDificultad_deseada(){
        return this.dificultad_deseada;
    }

    public String getObjetivo(){
        return this.objetivo;
    }
}

