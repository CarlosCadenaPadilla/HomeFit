package com.example.homefitp;

import android.app.Application;

import com.example.homefitp.Entidades.Usuario;

public class MyApplication extends Application {


    private static Usuario usuario;

    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usuario) {
        MyApplication.usuario = usuario;
    }

}
