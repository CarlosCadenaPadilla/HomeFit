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
        db.execSQL(Utilidades.tablaDetalleEjercicio.CREAR_TABLA);

        insertEjercicio(db,"Saltos de Tijera","",   "<p><b>Paso 1</b> Ponte de pie con los pies juntos, y coloca las manos sobre los muslos.</p> <p><b>Paso 2</b> Flexiona las rodillas, salta y separa los pies en pleno salto.</p> <p><b>Paso 3</b> Déjate caer con los pies separados a una distancia mayor que los hombros, bajando hasta quedar en posición de sentadilla.</p>","salto_tijera", "", "Baja", "Bajar de Peso");
        insertEjercicio(db,"Sentadilla en Pared","", "<p><strong>Paso1 </strong> Haz una sentadilla echando las caderas hacia atrás contra la pared y manteniendo los talones apoyados y las rodillas hacia fuera.</p> <p><strong>Paso 2</strong> Levanta los brazos hacia adelante para mantener el equilibrio.</p> <p><strong>Paso 3</strong> Haz una pausa de 10 segundos y luego levántate y vuelve a la posición inicial</p>","sentadilla_pared", "", "Media", "Tonificar");
        insertEjercicio(db,"Flexiones","", "<p><strong>Paso 1 </strong> Acuéstese boca abajo.</p>" +
                "<p><strong>Paso 2</strong> Coloque las palmas de las manos en el suelo a la altura de los hombros, ligeramente más abiertos que el ancho de sus hombros.</p>" +
                "<p><strong>Paso 3</strong> Levante el cuerpo hacia arriba e ir enderezando los brazos, procura mantener una postura erguida. Evita inclinar el tronco hacia atrás.</p>" +
                "<p><strong>Paso 4</strong> Bajamos el cuerpo doblando los brazos, volvemos a la posición inicial extendiendo los brazos.</p>","flexiones", "", "Media", "Tonificar");

        insertRutina(db,"Entrenamiento 7 Minutos", "rutina_7min", 7, 150, 2 );
        insertRutina(db, "Ejercicios Abdominales","ic_circulo_azul", 7, 150, 2);
        insertRutina(db, "Ejercicios Absee", "ic_circulo_azul", 7, 150, 2);

        insertDetalleEjercicio(db,1,1,30);
        insertDetalleEjercicio(db,2,1,30);
        insertDetalleEjercicio(db,3,1,30);

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

    public void insertDetalleEjercicio (SQLiteDatabase db, int idEjercicio, int idRutina, int tiempo){
        ContentValues registro = new ContentValues();
        registro.put(Utilidades.tablaDetalleEjercicio.ID_RUTINA, idRutina);
        registro.put(Utilidades.tablaDetalleEjercicio.ID_EJERCICIO, idEjercicio);
        registro.put(Utilidades.tablaDetalleEjercicio.TIEMPO, tiempo);
        db.insert(Utilidades.tablaDetalleEjercicio.NOMBRE_TABLA, Utilidades.tablaDetalleEjercicio.ID_RUTINA, registro);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Utilidades.tablaUsuarios.TABLA_NOMBRE);
        db.execSQL("DROP TABLE IF EXISTS " + Utilidades.tablaEjercicios.NOMBRE_TABLA);
        db.execSQL("DROP TABLE IF EXISTS " + Utilidades.tablaRutinas.NOMBRE_TABLA);
        db.execSQL("DROP TABLE IF EXISTS " + Utilidades.tablaDetalleEjercicio.NOMBRE_TABLA);
        onCreate(db);
    }
}