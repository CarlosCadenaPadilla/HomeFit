package com.example.homefitp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.homefitp.modeloDAO.UsuarioDAO;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.navigation.NavigationView;

public class ConfiguracionActivity extends AppCompatActivity {
    NavigationView menuConfiguracion;
    UsuarioDAO usuarioDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        usuarioDAO = new UsuarioDAO(this);

        menuConfiguracion = findViewById(R.id.menuConfiguracion);
        menuConfiguracion.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.cerrarSesion:
                        MyApplication.setUsuario(null);
                        Intent intent = new Intent(ConfiguracionActivity.this, PrincipalActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.eliminarCuenta:
                        new MaterialAlertDialogBuilder(ConfiguracionActivity.this).setTitle("¿Estás seguro que deseas eliminar tu cuenta?")
                                .setNeutralButton("CANCELAR", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                }).setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                usuarioDAO.deleteUsuario(MyApplication.getUsuario());
                                MyApplication.setUsuario(null);
                                Intent intent = new Intent(ConfiguracionActivity.this, PrincipalActivity.class);
                                startActivity(intent);
                            }
                        }).show();
                }
                return true;
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.AppBar);
        toolbar.setTitle("Configuración");
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }


}