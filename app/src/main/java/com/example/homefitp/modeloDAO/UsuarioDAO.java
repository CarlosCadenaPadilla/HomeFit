package com.example.homefitp.modeloDAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.homefitp.DatabaseHelper;
import com.example.homefitp.utilidades.Utilidades;
import com.example.homefitp.entidades.Usuario;

public class UsuarioDAO {
    DatabaseHelper conexionSQLiteHelper;
    SQLiteDatabase db;

    public void UsuarioDAO(Context context){
        conexionSQLiteHelper=new DatabaseHelper(context);
    }

    public long insertarUsuario(Usuario usuario){
        ContentValues registro= new ContentValues();
        registro.put(Utilidades.tablaUsuarios.CAMPO_ID,usuario.getId());

        return 0;
    }
}
