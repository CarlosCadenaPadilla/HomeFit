package com.example.homefitp.Entidades;




public class DetalleEjercicio {
    int idEjercicio;
    int idRutina;
    int tiempo;

    public DetalleEjercicio(int idEjercicio, int idRutina, int tiempo) {
        this.idEjercicio = idEjercicio;
        this.idRutina = idRutina;
        this.tiempo = tiempo;
    }

    public int getIdEjercicio() {
        return idEjercicio;
    }

    public void setIdEjercicio(int idEjercicio) {
        this.idEjercicio = idEjercicio;
    }

    public int getIdRutina() {
        return idRutina;
    }

    public void setIdRutina(int idRutina) {
        this.idRutina = idRutina;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
}
