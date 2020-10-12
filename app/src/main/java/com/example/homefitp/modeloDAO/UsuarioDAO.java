package com.example.homefitp.modeloDAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.homefitp.ConexionSQLiteHelper;
import com.example.homefitp.utilidades.Utilidades;
import com.example.homefitp.Entidades.Usuario;

import java.util.ArrayList;

public class UsuarioDAO {
    private ConexionSQLiteHelper conexionSQLiteHelper;
    private SQLiteDatabase db;

    public UsuarioDAO(Context context) {

        conexionSQLiteHelper = new ConexionSQLiteHelper(context);
        db = conexionSQLiteHelper.getWritableDatabase();

    }

    public long insertUsuario(Usuario usuario) {
        ContentValues registro = new ContentValues();
        registro.put(Utilidades.tablaUsuarios.NOMBRE, usuario.getNombre());
        registro.put(Utilidades.tablaUsuarios.CORREO, usuario.getCorreo());
        registro.put(Utilidades.tablaUsuarios.CONTRASEÑA, usuario.getContraseña());
        registro.put(Utilidades.tablaUsuarios.EDAD, usuario.getEdad());
        registro.put(Utilidades.tablaUsuarios.SEXO, usuario.getSexo());
        registro.put(Utilidades.tablaUsuarios.ESTATURA, usuario.getEstatura());
        registro.put(Utilidades.tablaUsuarios.PESO, usuario.getPeso());
        registro.put(Utilidades.tablaUsuarios.DIFICULTAD_DESEADA, usuario.getDificultad_deseada());
        registro.put(Utilidades.tablaUsuarios.OBJETIVO, usuario.getObjetivo());

        long id = db.insert(Utilidades.tablaUsuarios.TABLA_NOMBRE, Utilidades.tablaUsuarios.ID, registro);
        db.close();
        return id;
    }

    public ArrayList<Usuario> consultarUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        Cursor cursor = db.rawQuery(Utilidades.tablaUsuarios.CONSULTAR_ALL_TABLE, null);
        while (cursor.moveToNext()) {
            usuarios.add(new Usuario(cursor.getInt(0), cursor.getString(1),
                    cursor.getString(2), cursor.getString(3), cursor.getString(4),
                    cursor.getString(5), cursor.getInt(6), cursor.getInt(7),
                    cursor.getString(8), cursor.getString(9)));
        }
        db.close();
        return usuarios;
    }

    public Usuario consultarUsuarioByCorreo(String correo) {
        Usuario usuario = null;
        String[] campos = new String[]{
                Utilidades.tablaUsuarios.NOMBRE, Utilidades.tablaUsuarios.CORREO, Utilidades.tablaUsuarios.CONTRASEÑA, Utilidades.tablaUsuarios.EDAD,
                Utilidades.tablaUsuarios.SEXO, Utilidades.tablaUsuarios.ESTATURA, Utilidades.tablaUsuarios.PESO, Utilidades.tablaUsuarios.DIFICULTAD_DESEADA
                , Utilidades.tablaUsuarios.OBJETIVO};

        String[] parametros = new String[]{Utilidades.tablaUsuarios.CORREO};
        String[] argumentos = new String[]{correo};


        Cursor cursor = db.query(Utilidades.tablaUsuarios.TABLA_NOMBRE, campos, parametros[0] + "=?", argumentos, null, null, null);
        if (cursor.moveToFirst()) {
            usuario = new Usuario(cursor.getString(0),
                    cursor.getString(1), cursor.getString(2), cursor.getString(3),
                    cursor.getString(4), cursor.getInt(5), cursor.getInt(6),
                    cursor.getString(7), cursor.getString(8));

        }
        db.close();
        return usuario;
    }

    public Usuario login(String correo, String contraseña) {
        Usuario usuario = null;
        String[] campos = new String[]{
                Utilidades.tablaUsuarios.NOMBRE, Utilidades.tablaUsuarios.CORREO, Utilidades.tablaUsuarios.CONTRASEÑA, Utilidades.tablaUsuarios.EDAD,
                Utilidades.tablaUsuarios.SEXO, Utilidades.tablaUsuarios.ESTATURA, Utilidades.tablaUsuarios.PESO, Utilidades.tablaUsuarios.DIFICULTAD_DESEADA
                , Utilidades.tablaUsuarios.OBJETIVO};

        String[] parametros = new String[]{Utilidades.tablaUsuarios.CORREO, Utilidades.tablaUsuarios.CONTRASEÑA};
        String[] argumentos = new String[]{correo, contraseña};


        Cursor cursor = db.rawQuery("Select * from " + Utilidades.tablaUsuarios.TABLA_NOMBRE + " WHERE " + parametros[0] + "=? and " + parametros[1] + "=?", argumentos);

        if (cursor.moveToFirst()) {
            usuario = new Usuario(cursor.getString(1),
                    cursor.getString(2), cursor.getString(3), cursor.getString(4),
                    cursor.getString(5), cursor.getInt(6), cursor.getInt(7),
                    cursor.getString(8), cursor.getString(9));

            db.close();
            return usuario;
        }
        return null;
    }

    public long updateUsuario(Usuario usuario) {
        ContentValues registro = new ContentValues();
        registro.put(Utilidades.tablaUsuarios.NOMBRE, usuario.getNombre());
        registro.put(Utilidades.tablaUsuarios.EDAD, usuario.getEdad());
        registro.put(Utilidades.tablaUsuarios.SEXO, usuario.getSexo());
        registro.put(Utilidades.tablaUsuarios.ESTATURA, usuario.getEstatura());
        registro.put(Utilidades.tablaUsuarios.PESO, usuario.getPeso());
        registro.put(Utilidades.tablaUsuarios.DIFICULTAD_DESEADA, usuario.getDificultad_deseada());
        registro.put(Utilidades.tablaUsuarios.OBJETIVO, usuario.getObjetivo());

        long id = db.update(Utilidades.tablaUsuarios.TABLA_NOMBRE, registro, Utilidades.tablaUsuarios.CORREO + "='" + usuario.getCorreo() + "'", null);
        db.close();
        return id;
    }

    public long deleteUsuario(Usuario usuario) {
        long id = db.delete(Utilidades.tablaUsuarios.TABLA_NOMBRE, Utilidades.tablaUsuarios.CORREO + "='" + usuario.getCorreo() + "'", null);
        return id;
    }


}