package com.example.homefitp.modeloDAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.homefitp.ConexionSQLiteHelper;
import com.example.homefitp.Entidades.Ejercicio;
import com.example.homefitp.Entidades.Rutina;
import com.example.homefitp.utilidades.Utilidades;

import java.util.ArrayList;

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


        long id = db.insert(Utilidades.tablaEjercicios.NOMBRE_TABLA, Utilidades.tablaEjercicios.ID, registro);
        db.close();
        return id;
    }

    public ArrayList<Ejercicio> consultarEjercicios() {
        ArrayList<Ejercicio> ejercicios = new ArrayList<Ejercicio>();
        Cursor cursor = db.rawQuery(Utilidades.tablaEjercicios.CONSULTAR_ALL_TABLE, null);
        while (cursor.moveToNext()) {
            ejercicios.add(new Ejercicio(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2), cursor.getString(3), cursor.getString(4),
                    cursor.getString(5),cursor.getString(6),cursor.getString(7)));
        }
        db.close();
        return ejercicios;
    }

    public Ejercicio consultarEjercicio(int id) {
        Ejercicio ejercicio = null;
        Cursor cursor = db.rawQuery("SELECT * FROM " + Utilidades.tablaEjercicios.NOMBRE_TABLA + " WHERE " + Utilidades.tablaEjercicios.ID + "=" + id, null);
        if (cursor.moveToNext()) {
            ejercicio = new Ejercicio(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2), cursor.getString(3), cursor.getString(4),
                    cursor.getString(5),cursor.getString(6),cursor.getString(7));
        }
        db.close();
        return ejercicio;
    }
}
