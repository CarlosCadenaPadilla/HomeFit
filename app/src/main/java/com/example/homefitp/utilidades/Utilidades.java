package com.example.homefitp.utilidades;


public final class Utilidades {
    public static final String DATABASE_NAME="dbApp";
    public static final int VERSION=1;

    public class tablaUsuarios{
        //CONSTANTES
        //Campos de la tabla usuarios
        public static final String TABLA_NOMBRE="usuario";
        public static final String ID ="id";
        public static final String NOMBRE ="nombre";
        public static final String CORREO ="correo";
        public static final String CONTRASEÑA ="contraseña";
        public static final String EDAD ="edad";
        public static final String SEXO ="sexo";
        public static final String ESTATURA ="estatura";
        public static final String PESO ="peso";
        public static final String DIFICULTAD_DESEADA ="dificultad_deseada";
        public static final String OBJETIVO ="objetivo";

        public static final String CREAR_TABLA="CREATE TABLE "+TABLA_NOMBRE+"("+ ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+ NOMBRE +" VARCHAR, "+ CORREO +" VARCHAR, "+ CONTRASEÑA +" VARCHAR, " +
                ""+ EDAD +" VARCHAR, "+ SEXO +" VARCHAR, "+ ESTATURA +" INTEGER, "+ PESO +" INTEGER, "+ DIFICULTAD_DESEADA +" VARCHAR, "+ OBJETIVO +" VARCHAR)";

        public static final String CONSULTAR_ALL_TABLE="SELECT * FROM "+TABLA_NOMBRE;
    }

}