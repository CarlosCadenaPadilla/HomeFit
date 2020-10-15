package com.example.homefitp;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.homefitp.Entidades.Ejercicio;
import com.example.homefitp.modeloDAO.EjercicioDAO;
import com.example.homefitp.modeloDAO.RutinaDAO;


public class DetalleEjercicioActivity extends AppCompatActivity {
    TextView instrucciones;
    ImageView imagenEjercicio;
    Ejercicio ejercicio;
    EjercicioDAO ejercicioDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_ejercicio);

        instrucciones=findViewById(R.id.textViewInstrucciones);
        //imagenEjercicio=findViewById(R.id.imageViewEjercicioImg);

        ejercicioDAO=new EjercicioDAO(this);
        int idEjercicio=getIntent().getIntExtra("idEjercicio",0);
        ejercicio= ejercicioDAO.consultarEjercicio(idEjercicio);

        if(ejercicio !=null){
            instrucciones.setText(ejercicio.getInstrucciones());
            int idimagenEjercicio=getApplicationContext().getResources().getIdentifier(ejercicio.getIdImagen(),"drawable",getApplicationContext().getPackageName());
            imagenEjercicio.setImageResource(idimagenEjercicio);
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

