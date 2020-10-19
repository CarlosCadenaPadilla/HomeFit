package com.example.homefitp.utilidades;


public final class Utilidades {
    public static final String DATABASE_NAME = "dbApp";
    public static final int VERSION = 1;

    public class tablaUsuarios {
        //CONSTANTES
        //Campos de la tabla usuarios
        public static final String TABLA_NOMBRE = "usuario";
        public static final String ID = "id";
        public static final String NOMBRE = "nombre";
        public static final String CORREO = "correo";
        public static final String CONTRASEÑA = "contraseña";
        public static final String EDAD = "edad";
        public static final String SEXO = "sexo";
        public static final String ESTATURA = "estatura";
        public static final String PESO = "peso";
        public static final String DIFICULTAD_DESEADA = "dificultad_deseada";
        public static final String OBJETIVO = "objetivo";

        public static final String CREAR_TABLA = "CREATE TABLE " + TABLA_NOMBRE + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NOMBRE + " VARCHAR, " + CORREO + " VARCHAR, " + CONTRASEÑA + " VARCHAR, " +
                "" + EDAD + " VARCHAR, " + SEXO + " VARCHAR, " + ESTATURA + " INTEGER, " + PESO + " INTEGER, " + DIFICULTAD_DESEADA + " VARCHAR, " + OBJETIVO + " VARCHAR)";

        public static final String CONSULTAR_ALL_TABLE = "SELECT * FROM " + TABLA_NOMBRE;
    }

    public class tablaEjercicios {
        public static final String NOMBRE_TABLA = "ejercicio";
        public static final String ID = "id";
        public static final String NOMBRE = "nombre";
        public static final String DESCRIPCION = "descripcion";
        public static final String INSTRUCCIONES = "instrucciones";
        public static final String IMAGEN = "id_imagen";
        public static final String ANIMACION = "id_animacion";
        public static final String DIFICULTAD = "dificultad";
        public static final String OBJETIVO = "objetivo";

        public static final String CREAR_TABLA = "CREATE TABLE " + NOMBRE_TABLA + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NOMBRE + " VARCHAR, " + DESCRIPCION + " VARCHAR, " + INSTRUCCIONES + " VARCHAR, " + IMAGEN + " VARCHAR, " +
                "" + ANIMACION + " VARCHAR, " + DIFICULTAD + " VARCHAR, " + OBJETIVO + " VARCHAR)";

        public static final String CONSULTAR_ALL_TABLE = "SELECT * FROM " + NOMBRE_TABLA;
    }

    public class tablaRutinas {
        public static final String NOMBRE_TABLA = "rutina";
        public static final String ID = "id";
        public static final String NOMBRE = "nombre";
        public static final String IMAGEN = "id_imagen";
        public static final String DURACION = "duracion";
        public static final String GASTO_ENERGIA = "gasto_energia";
        public static final String CIRCUITOS = "circuitos";

        public static final String CREAR_TABLA = "CREATE TABLE " + NOMBRE_TABLA + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NOMBRE + " VARCHAR, " + IMAGEN + " VARCHAR, " + DURACION + " INTEGER, " + GASTO_ENERGIA + " INTEGER, " +
                "" + CIRCUITOS + " INTEGER)";

        public static final String CONSULTAR_ALL_TABLE = "SELECT * FROM " + NOMBRE_TABLA;
    }

    public class tablaDetalleEjercicio{
        public static final String NOMBRE_TABLA = "detalle_ejercicio";
        public static final String ID_RUTINA = "id_rutina";
        public static final String ID_EJERCICIO = "id_ejercicio";
        public static final String TIEMPO = "tiempo";

        public static final String CREAR_TABLA = "CREATE TABLE " + NOMBRE_TABLA + "(" +
                                                ID_EJERCICIO + " INTEGER, " +
                                                ID_RUTINA + " INTEGER , " +
                                                TIEMPO + " INTEGER," +
                                                "PRIMARY KEY (" + ID_RUTINA + ", " + ID_EJERCICIO + ")," +
                                                "FOREIGN KEY (" + ID_RUTINA + ") REFERENCES " + tablaRutinas.NOMBRE_TABLA + "(" + tablaRutinas.ID + ")" +
                                                "FOREIGN KEY (" + ID_EJERCICIO + ") REFERENCES " + tablaEjercicios.NOMBRE_TABLA + "(" + tablaRutinas.ID + "))";

        public static final String CONSULTAR_ALL_TABLE = "SELECT * FROM " + NOMBRE_TABLA;
    }

}