package com.example.homefitp.modeloDAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.homefitp.ConexionSQLiteHelper;
import com.example.homefitp.Entidades.DetalleEjercicio;
import com.example.homefitp.Entidades.Ejercicio;
import com.example.homefitp.Entidades.Rutina;
import com.example.homefitp.Entidades.Usuario;
import com.example.homefitp.utilidades.Utilidades;

import java.util.ArrayList;

public class DetalleEjercicioDAO {
    private ConexionSQLiteHelper conexionSQLiteHelper;
    private SQLiteDatabase db;

    public DetalleEjercicioDAO(Context context) {
        conexionSQLiteHelper = new ConexionSQLiteHelper(context);
        db = conexionSQLiteHelper.getWritableDatabase();
    }

    public long insertDetalleEjercicio(DetalleEjercicio detalleEjercicio) {
        ContentValues registro = new ContentValues();
        registro.put(Utilidades.tablaDetalleEjercicio.ID_EJERCICIO, detalleEjercicio.getIdEjercicio());
        registro.put(Utilidades.tablaDetalleEjercicio.ID_RUTINA, detalleEjercicio.getIdRutina());
        registro.put(Utilidades.tablaDetalleEjercicio.TIEMPO, detalleEjercicio.getTiempo());

        long id = db.insert(Utilidades.tablaDetalleEjercicio.NOMBRE_TABLA, Utilidades.tablaDetalleEjercicio.ID_RUTINA, registro);
        db.close();
        return id;
    }

    public ArrayList<DetalleEjercicio> consultarEjerciciosRutina(int idRutina) {
        ArrayList<DetalleEjercicio> detalleEjercicios = new ArrayList<DetalleEjercicio>();
        Cursor cursor = db.rawQuery(Utilidades.tablaDetalleEjercicio.CONSULTAR_ALL_TABLE + " WHERE " + Utilidades.tablaDetalleEjercicio.ID_RUTINA + "=" + idRutina, null);
        while (cursor.moveToNext()) {
            detalleEjercicios.add(new DetalleEjercicio(cursor.getInt(0),
                    cursor.getInt(1), cursor.getInt(2)));
        }
        db.close();
        return detalleEjercicios;
    }
}
