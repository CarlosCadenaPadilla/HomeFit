package com.example.homefitp.utilidades;


public final class Utilidades {
    public static final String DATABASE_NAME="dbApp";
    public static final int VERSION=1;

    public class tablaUsuarios{
        //CONSTANTES
        //Campos de la tabla usuarios
        public static final String TABLA_NOMBRE="usuario";
        public static final String CAMPO_ID="id";
        public static final String CAMPO_NOMBRE="nombre";
        public static final String CAMPO_CORREO="correo";
        public static final String CAMPO_CONTRASENA="password";
        public static final String CAMPO_EDAD="edad";
        public static final String CAMPO_SEXO="sexo";
        public static final String CAMPO_ESTATURA="estatura";
        public static final String CAMPO_PESO="peso";
        public static final String CAMPO_DIFICULTAD_DESEADA="dificultad_deseada";
        public static final String CAMPO_OBJETIVO="objetivo";

        public static final String CREAR_TABLA="CREATE TABLE "+TABLA_NOMBRE+"("+CAMPO_ID+" INTEGER, "+CAMPO_NOMBRE+" VARCHAR, "+CAMPO_CORREO+" VARCHAR, "+CAMPO_CONTRASENA+" VARCHAR, " +
                ""+CAMPO_EDAD+" VARCHAR, "+CAMPO_SEXO+" VARCHAR, "+CAMPO_ESTATURA+" VARCHAR, "+CAMPO_PESO+" VARCHAR, "+CAMPO_DIFICULTAD_DESEADA+" VARCHAR, "+CAMPO_OBJETIVO+" VARCHAR)";

        public static final String CONSULTAR_ALL_TABLE="SELECT * FROM "+TABLA_NOMBRE;
    }

    public class tablaRutinas{
        public static final String TABLA_NOMBRE="usuario";
        public static final String CAMPO_ID="id_rutina";
        public static final String CAMPO_NOMBRE="NOMBRE_RUTINA";
    }

}
