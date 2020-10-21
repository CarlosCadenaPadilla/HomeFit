package com.example.homefitp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.homefitp.Entidades.DetalleEjercicio;
import com.example.homefitp.Entidades.Ejercicio;
import com.example.homefitp.Entidades.Rutina;
import com.example.homefitp.modeloDAO.DetalleEjercicioDAO;
import com.example.homefitp.modeloDAO.EjercicioDAO;
import com.example.homefitp.modeloDAO.RutinaDAO;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;

public class AgregarEjercicioActivity extends AppCompatActivity {

    EditText tiempo;
    int idRutina;

    private RecyclerView recyclerViewEjercicios;
    ArrayList<Ejercicio> ejercicios;
    EjercicioDAO ejercicioDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_ejercicio);

        tiempo = new EditText(this);
        tiempo.setInputType(InputType.TYPE_CLASS_NUMBER);

        idRutina = getIntent().getIntExtra("idRutina", 0);

        Toolbar toolbar = (Toolbar) findViewById(R.id.AppBar);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        recyclerViewEjercicios = findViewById(R.id.listaEjercicios);
        ejercicios = new ArrayList<Ejercicio>();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewEjercicios.setLayoutManager(layoutManager);

        ejercicioDAO = new EjercicioDAO(this);
        recyclerViewEjercicios.setAdapter(new AdaptadorAgregarEjercicio(ejercicioDAO.consultarEjercicios(), this, this));


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

    public void agregarEjercicio(final int idEjercicio) {

        MaterialAlertDialogBuilder dialog = new MaterialAlertDialogBuilder(this)
                .setTitle("Ingresa la duraciòn del ejercicio en segundos: ")
                .setNeutralButton("CANCELAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })


                .setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DetalleEjercicio detalleEjercicio = new DetalleEjercicio(idEjercicio, idRutina, Integer.parseInt(tiempo.getText().toString()));
                        DetalleEjercicioDAO detalleEjercicioDAO = new DetalleEjercicioDAO(AgregarEjercicioActivity.this);
                        detalleEjercicioDAO.insertDetalleEjercicio(detalleEjercicio);
                        new MaterialAlertDialogBuilder(AgregarEjercicioActivity.this).setTitle("Se ha agregado el ejercicio al entrenamiento.")
                                .setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                }).show();
                    }
                });

        if (tiempo.getParent() != null)
            ((ViewGroup) tiempo.getParent()).removeView(tiempo); // <- fix
        dialog.setView(tiempo);

        dialog.show();
    }
}