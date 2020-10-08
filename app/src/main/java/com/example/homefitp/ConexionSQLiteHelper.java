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

    }

    private void insertUsuario(SQLiteDatabase bd, int id, String nombre, String correo, String contraseña, String edad, String sexo, int estatura, int peso, String dificultad_deseada, String objetivo) {
        ContentValues registro = new ContentValues();
        registro.put(Utilidades.tablaUsuarios.ID, id);
        registro.put(Utilidades.tablaUsuarios.NOMBRE, nombre);
        registro.put(Utilidades.tablaUsuarios.CONTRASEÑA, contraseña);
        registro.put(Utilidades.tablaUsuarios.EDAD, edad);
        registro.put(Utilidades.tablaUsuarios.SEXO, sexo);
        registro.put(Utilidades.tablaUsuarios.ESTATURA, estatura);
        registro.put(Utilidades.tablaUsuarios.PESO, peso);
        registro.put(Utilidades.tablaUsuarios.DIFICULTAD_DESEADA, dificultad_deseada);
        registro.put(Utilidades.tablaUsuarios.OBJETIVO, objetivo);

        bd.insert(Utilidades.tablaUsuarios.TABLA_NOMBRE, null, registro);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Utilidades.tablaUsuarios.TABLA_NOMBRE);
        onCreate(db);
    }
}