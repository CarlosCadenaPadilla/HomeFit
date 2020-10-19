package com.example.homefitp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.homefitp.Entidades.Ejercicio;
import com.example.homefitp.modeloDAO.EjercicioDAO;

public class DetalleEjercicioActivity extends AppCompatActivity {
    private ImageView imagenEjercicio;
    private TextView instrucciones;

    private EjercicioDAO ejercicioDAO;
    private Ejercicio ejercicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_ejercicio);

        int idEjercicio = getIntent().getIntExtra("idEjercicio", 0);

        ejercicioDAO = new EjercicioDAO(this);
        ejercicio = ejercicioDAO.consultarEjercicio(idEjercicio);

        imagenEjercicio = findViewById(R.id.imageViewImagenEjercicio);
        instrucciones = findViewById(R.id.textViewInstrucciones);

        int idImagen = getResources().getIdentifier(ejercicio.getIdImagen(), "drawable", getPackageName());
        imagenEjercicio.setImageResource(idImagen);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            instrucciones.setText(Html.fromHtml(ejercicio.getInstrucciones(), Html.FROM_HTML_MODE_LEGACY));
        } else {
            instrucciones.setText(Html.fromHtml(ejercicio.getInstrucciones()));
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.AppBarEjercicio);
        toolbar.setTitle(ejercicio.getNombre());
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