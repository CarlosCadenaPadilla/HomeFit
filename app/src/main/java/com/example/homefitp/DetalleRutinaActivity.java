package com.example.homefitp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.example.homefitp.Entidades.DetalleEjercicio;
import com.example.homefitp.Entidades.Rutina;
import com.example.homefitp.modeloDAO.DetalleEjercicioDAO;
import com.example.homefitp.modeloDAO.EjercicioDAO;
import com.example.homefitp.modeloDAO.RutinaDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class DetalleRutinaActivity extends AppCompatActivity {
    TextView duracion, gastoEnergia, circuitos;
    Rutina rutina;
    RutinaDAO rutinaDAO;
    private RecyclerView recyclerViewEjercicios;
    ArrayList<DetalleEjercicio> detalleEjercicios;

    EjercicioDAO ejercicioDAO;
    FloatingActionButton btnIniciarRutina;

    Toolbar toolbar;
    int idRutina;
    AdaptadorEjercicios adaptadorEjercicios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_rutina);


        duracion = findViewById(R.id.textview_duracion_rutina);
        gastoEnergia = findViewById(R.id.textview_gasto_energia);
        circuitos = findViewById(R.id.textview_circuitos);

        rutinaDAO = new RutinaDAO(this);
        idRutina = getIntent().getIntExtra("idRutina", 0);
        rutina = rutinaDAO.consultarRutina(idRutina);


        if (rutina != null) {
            duracion.setText(rutina.getDuracion() + " min");
            gastoEnergia.setText(rutina.getGastoEnergia() + " kcal");
            circuitos.setText(rutina.getCircuitos() + "");
        }

        toolbar = (Toolbar) findViewById(R.id.AppBarRutina);
        toolbar.setTitle(rutina.getNombre());
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        recyclerViewEjercicios = findViewById(R.id.listaEjercicios);
        detalleEjercicios = new ArrayList<DetalleEjercicio>();


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewEjercicios.setLayoutManager(layoutManager);


        ejercicioDAO = new EjercicioDAO(this);
        adaptadorEjercicios = new AdaptadorEjercicios(rutina.getDetalleEjercicios(), this, this);
        recyclerViewEjercicios.setAdapter(adaptadorEjercicios);

        btnIniciarRutina = findViewById(R.id.btnIniciarRutina);
        btnIniciarRutina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetalleRutinaActivity.this, RealizarRutinaActivity.class);
                intent.putExtra("idRutina", idRutina);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }else{
            Intent intent = new Intent(DetalleRutinaActivity.this, AgregarEjercicioActivity.class);
            intent.putExtra("idRutina", idRutina);
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_rutina, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void verDetalleEjercicio(int idEjercicio) {
        Intent intent = new Intent(this, DetalleEjercicioActivity.class);
        intent.putExtra("idEjercicio", idEjercicio);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DetalleEjercicioDAO detalleEjercicioDAO = new DetalleEjercicioDAO(this);
        detalleEjercicios = detalleEjercicioDAO.consultarEjerciciosRutina(idRutina);
        adaptadorEjercicios = new AdaptadorEjercicios(detalleEjercicios, this, this);
        recyclerViewEjercicios.setAdapter(adaptadorEjercicios);
    }
}