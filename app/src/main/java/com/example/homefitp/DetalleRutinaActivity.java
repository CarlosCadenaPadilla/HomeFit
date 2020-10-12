package com.example.homefitp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.homefitp.Entidades.Rutina;
import com.example.homefitp.modeloDAO.RutinaDAO;

public class DetalleRutinaActivity extends AppCompatActivity {
    TextView duracion, gastoEnergia, circuitos;
    Rutina rutina;
    RutinaDAO rutinaDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_rutina);


        duracion = findViewById(R.id.textview_duracion_rutina);
        gastoEnergia = findViewById(R.id.textview_gasto_energia);
        circuitos = findViewById(R.id.textview_circuitos);

        rutinaDAO = new RutinaDAO(this);
        int idRutina = getIntent().getIntExtra("idRutina", 0);
        rutina = rutinaDAO.consultarRutina(idRutina);

        if (rutina != null) {
            duracion.setText(rutina.getDuracion() + " min");
            gastoEnergia.setText(rutina.getGastoEnergia() + " kcal");
            circuitos.setText(rutina.getCircuitos() + "");
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.AppBarRutina);
        toolbar.setTitle(rutina.getNombre());
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