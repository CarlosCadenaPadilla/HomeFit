package com.example.homefitp.modeloDAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.homefitp.ConexionSQLiteHelper;
import com.example.homefitp.Entidades.Ejercicio;
import com.example.homefitp.utilidades.Utilidades;

public class EjercicioDAO {
    private ConexionSQLiteHelper conexionSQLiteHelper;
    private SQLiteDatabase db;

    public EjercicioDAO(Context context) {
        conexionSQLiteHelper = new ConexionSQLiteHelper(context);
        db = conexionSQLiteHelper.getWritableDatabase();
    }

    public long insertEjercicio(Ejercicio ejercicio) {
        ContentValues registro = new ContentValues();
        registro.put(Utilidades.tablaEjercicios.NOMBRE, ejercicio.getNombre());
        registro.put(Utilidades.tablaEjercicios.DESCRIPCION, ejercicio.getDescripcion());
        registro.put(Utilidades.tablaEjercicios.INSTRUCCIONES, ejercicio.getInstrucciones());
        registro.put(Utilidades.tablaEjercicios.IMAGEN, ejercicio.getIdImagen());
        registro.put(Utilidades.tablaEjercicios.ANIMACION, ejercicio.getIdAnimacion());
        registro.put(Utilidades.tablaEjercicios.DIFICULTAD, ejercicio.getDificultad());
        registro.put(Utilidades.tablaEjercicios.OBJETIVO, ejercicio.getObjetivo());


        long id = db.insert(Utilidades.tablaUsuarios.TABLA_NOMBRE, Utilidades.tablaUsuarios.ID, registro);
        db.close();
        return id;
    }
}