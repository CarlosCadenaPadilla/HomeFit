package com.example.homefitp;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.homefitp.utilidades.Utilidades;

public class ConexionSQLiteHelper extends SQLiteOpenHelper {


    public ConexionSQLiteHelper(@Nullable Context context) {
        super(context, Utilidades.DATABASE_NAME, null, Utilidades.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.tablaUsuarios.CREAR_TABLA);
        db.execSQL(Utilidades.tablaEjercicios.CREAR_TABLA);
        db.execSQL(Utilidades.tablaRutinas.CREAR_TABLA);
        insertEjercicio(db,"Saltos de Tijera","", "Paso 1 Ponte de pie con los pies juntos, y coloca las manos sobre los muslos. Paso 2 Flexiona las rodillas, salta y separa los pies en pleno salto. Paso 3 Déjate caer con los pies separados a una distancia mayor que los hombros, bajando hasta quedar en posición de sentadilla.","salto_tijera", "", "Baja", "Bajar de Peso");
        insertEjercicio(db,"Sentadilla en Pared","", "Haz una sentadilla echando las caderas hacia atrás contra la pared y manteniendo los talones apoyados y las rodillas hacia fuera. Levanta los brazos hacia adelante para mantener el equilibrio. Haz una pausa de 10 segundos y luego levántate y vuelve a la posición inicial","sentadilla_pared", "", "Media", "Tonificar");
        insertEjercicio(db,"Sentadilla en Pared","", "Acuéstese boca abajo.\n" +
                "    Coloque las palmas de las manos en el suelo a la altura de los hombros, ligeramente más abiertos que el ancho de sus hombros.\n" +
                "    Levante el cuerpo hacia arriba e ir enderezando los brazos, procura mantener una postura erguida. Evita inclinar el tronco hacia atrás.\n" +
                "    El cuerpo debe apoyarse únicamente sobre las manos y los dedos de los pies, manteniendo la posición erguida todo el tiempo.\n" +
                "    Bajamos el cuerpo doblando los brazos, volvemos a la posición inicial extendiendo los brazos.","flexiones", "", "Media", "Tonificar");

        insertRutina(db,"Entrenamiento 7 Minutos", "rutina_7min", 7, 150, 2 );

    }

    public void insertEjercicio (SQLiteDatabase db,String nombre, String descripcion, String instrucciones, String idImagen, String idAnimacion, String dificultad, String objetivo){
        ContentValues registro = new ContentValues();
        registro.put(Utilidades.tablaEjercicios.NOMBRE, nombre);
        registro.put(Utilidades.tablaEjercicios.DESCRIPCION, descripcion);
        registro.put(Utilidades.tablaEjercicios.INSTRUCCIONES, instrucciones);
        registro.put(Utilidades.tablaEjercicios.IMAGEN, idImagen);
        registro.put(Utilidades.tablaEjercicios.IMAGEN, idImagen);
        registro.put(Utilidades.tablaEjercicios.ANIMACION, idAnimacion);
        registro.put(Utilidades.tablaEjercicios.DIFICULTAD, dificultad);
        registro.put(Utilidades.tablaEjercicios.OBJETIVO, objetivo);
        db.insert(Utilidades.tablaEjercicios.NOMBRE_TABLA, Utilidades.tablaEjercicios.ID, registro);
    }

    public void insertRutina (SQLiteDatabase db,String nombre, String idImagen, int duracion, int gastoEnergia, int circuitos){
        ContentValues registro = new ContentValues();
        registro.put(Utilidades.tablaRutinas.NOMBRE, nombre);
        registro.put(Utilidades.tablaRutinas.IMAGEN, idImagen);
        registro.put(Utilidades.tablaRutinas.DURACION, duracion);
        registro.put(Utilidades.tablaRutinas.GASTO_ENERGIA, gastoEnergia);
        registro.put(Utilidades.tablaRutinas.CIRCUITOS, circuitos);
        db.insert(Utilidades.tablaRutinas.NOMBRE_TABLA, Utilidades.tablaRutinas.ID, registro);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Utilidades.tablaUsuarios.TABLA_NOMBRE);
        db.execSQL("DROP TABLE IF EXISTS " + Utilidades.tablaEjercicios.NOMBRE_TABLA);
        db.execSQL("DROP TABLE IF EXISTS " + Utilidades.tablaRutinas.NOMBRE_TABLA);
        onCreate(db);
    }
}