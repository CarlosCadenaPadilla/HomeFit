package com.example.homefitp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.homefitp.utilidades.Utilidades;

public class DatabaseHelper extends SQLiteOpenHelper{
    //public static final String DATABASE_NAME ="register.db";
    //public static final String TABLE_NAME ="registeruser";
    //public static final String COL_1 ="ID";
    //public static final String COL_2 ="username";
    //public static final String COL_3 ="password";

    public DatabaseHelper(Context context) {
        super(context, Utilidades.DATABASE_NAME, null, Utilidades.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Utilidades.tablaUsuarios.CREAR_TABLA);
        //sqLiteDatabase.execSQL("CREATE TABLE registeruser (ID INTEGER PRIMARY  KEY AUTOINCREMENT, username TEXT, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Utilidades.tablaUsuarios.TABLA_NOMBRE);
        onCreate(sqLiteDatabase);
    }

    public long addUser(String user, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Utilidades.tablaUsuarios.CAMPO_CORREO,user);
        contentValues.put(Utilidades.tablaUsuarios.CAMPO_CONTRASENA,password);
        long res = db.insert(Utilidades.tablaUsuarios.TABLA_NOMBRE,null,contentValues);
        db.close();
        return  res;
    }

    public boolean checkUser(String username, String password){
        //String[] columns = { COL_1 };
        SQLiteDatabase db = getReadableDatabase();
        //String selection = COL_2 + "=?" + " and " + COL_3 + "=?";
        String[] selectionArgs = { username, password };
        //Cursor cursor = db.query(TABLE_NAME,columns,selection,selectionArgs,null,null,null);
        Cursor cursor = db.rawQuery("SELECT * FROM "+ Utilidades.tablaUsuarios.TABLA_NOMBRE+ " WHERE "+ Utilidades.tablaUsuarios.CAMPO_CORREO+"='"+username +"' AND "+Utilidades.tablaUsuarios.CAMPO_CONTRASENA+"= '"+password+"'",null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        if(count>0)
            return  true;
        else
            return  false;

    }
}
