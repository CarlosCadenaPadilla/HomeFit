package com.example.homefitp.Entidades;

public class Usuario {
    int id;
    String nombre;
    String correo;
    String contraseña;
    String edad;
    String sexo;
    int estatura;
    int peso;
    String dificultad_deseada;
    String objetivo;

    public Usuario(int id, String nombre, String correo, String contraseña, String edad, String sexo, int estatura, int peso, String dificultad_deseada, String objetivo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        this.edad = edad;
        this.sexo = sexo;
        this.estatura = estatura;
        this.peso = peso;
        this.dificultad_deseada = dificultad_deseada;
        this.objetivo = objetivo;
    }

    public Usuario(String nombre, String correo, String contraseña, String edad, String sexo, int estatura, int peso, String dificultad_deseada, String objetivo) {
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        this.edad = edad;
        this.sexo = sexo;
        this.estatura = estatura;
        this.peso = peso;
        this.dificultad_deseada = dificultad_deseada;
        this.objetivo = objetivo;
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

    public void setEstatura(int estatura){
        this.estatura=estatura;
    }

    public void setPeso(int peso){
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

    public int getEstatura(){
        return this.estatura;
    }

    public int getPeso(){
        return this.peso;
    }

    public String getDificultad_deseada(){
        return this.dificultad_deseada;
    }

    public String getObjetivo(){
        return this.objetivo;
    }
}
