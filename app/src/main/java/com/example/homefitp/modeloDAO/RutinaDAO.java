package com.example.homefitp.modeloDAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.homefitp.ConexionSQLiteHelper;
import com.example.homefitp.Entidades.Rutina;
import com.example.homefitp.Entidades.Usuario;
import com.example.homefitp.utilidades.Utilidades;

import java.util.ArrayList;

public class RutinaDAO {
    private ConexionSQLiteHelper conexionSQLiteHelper;
    private SQLiteDatabase db;

    public RutinaDAO(Context context) {
        conexionSQLiteHelper = new ConexionSQLiteHelper(context);
        db = conexionSQLiteHelper.getWritableDatabase();
    }

    public long insertRutina(Rutina rutina) {
        ContentValues registro = new ContentValues();
        registro.put(Utilidades.tablaRutinas.NOMBRE, rutina.getNombre());
        registro.put(Utilidades.tablaRutinas.IMAGEN, rutina.getIdImagen());
        registro.put(Utilidades.tablaRutinas.DURACION, rutina.getDuracion());
        registro.put(Utilidades.tablaRutinas.GASTO_ENERGIA, rutina.getGastoEnergia());
        registro.put(Utilidades.tablaRutinas.CIRCUITOS, rutina.getCircuitos());


        long id = db.insert(Utilidades.tablaRutinas.NOMBRE_TABLA, Utilidades.tablaRutinas.ID, registro);
        db.close();
        return id;
    }

    public ArrayList<Rutina> consultarRutinas() {
        ArrayList<Rutina> rutinas = new ArrayList<Rutina>();
        Cursor cursor = db.rawQuery(Utilidades.tablaRutinas.CONSULTAR_ALL_TABLE, null);
        while (cursor.moveToNext()) {
            rutinas.add(new Rutina(cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2), cursor.getInt(3), cursor.getInt(4),
                    cursor.getInt(5)));
        }
        db.close();
        return rutinas;
    }

    public Rutina consultarRutina(int id) {
        Rutina rutina = null;
        Cursor cursor = db.rawQuery("SELECT * FROM " + Utilidades.tablaRutinas.NOMBRE_TABLA + " WHERE " + Utilidades.tablaRutinas.ID + "=" + id, null);
        if (cursor.moveToNext()) {
            rutina = new Rutina(cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2), cursor.getInt(3), cursor.getInt(4),
                    cursor.getInt(5));
        }
        db.close();
        return rutina;
    }

}
