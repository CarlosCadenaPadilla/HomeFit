package com.example.homefitp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.homefitp.Entidades.Rutina;
import com.example.homefitp.modeloDAO.EjercicioDAO;
import com.example.homefitp.modeloDAO.RutinaDAO;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class RealizarRutinaActivity extends AppCompatActivity {

    ImageView imagenEjercicio;
    TextView tiempo, descanso, nombreEjercicio, posicionEj;
    MaterialButton btnStartStop, btnSiguiente;
    RutinaDAO rutinaDAO;
    EjercicioDAO ejercicioDAO;
    Rutina rutina;

    ProgressBar progreso;

    int posicionEjercicio = 0, descansos, contadorDescansos = 0, secondsEjercicio, secondsRest = 20;

    boolean resting, siguiente, running, rutinaTerminada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realizar_rutina);

        rutinaDAO = new RutinaDAO(this);
        ejercicioDAO = new EjercicioDAO(this);
        rutina = rutinaDAO.consultarRutina(getIntent().getIntExtra("idRutina", 0));

        imagenEjercicio = findViewById(R.id.imageViewEjercicio);
        tiempo = findViewById(R.id.textViewTiempo);
        descanso = findViewById(R.id.textViewDescanso);
        nombreEjercicio = findViewById(R.id.textViewNombreEjercicio);
        progreso = findViewById(R.id.progressBar);
        btnStartStop = findViewById(R.id.btn_start_stop);
        btnSiguiente = findViewById(R.id.btnSiguiente);

        Toolbar toolbar = (Toolbar) findViewById(R.id.AppBarEjercicio);
        toolbar.setTitle(rutina.getNombre());
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        secondsEjercicio = rutina.getDetalleEjercicios().get(posicionEjercicio).getTiempo();
        descansos = rutina.getDetalleEjercicios().size() - 1;
        runTimer();

        descanso.setText(ejercicioDAO.consultarEjercicio(rutina.getDetalleEjercicios().get(posicionEjercicio).getIdEjercicio()).getNombre());
        int idImagen = getResources().getIdentifier(ejercicioDAO.consultarEjercicio(rutina.getDetalleEjercicios().get(posicionEjercicio).getIdEjercicio()).getIdImagen(), "drawable", getPackageName());
        imagenEjercicio.setImageResource(idImagen);
        nombreEjercicio.setText("");

        posicionEj = findViewById(R.id.textViewPosicionEjercicio);
        posicionEj.setText("");

        tiempo.setText(String.valueOf(rutina.getDetalleEjercicios().get(posicionEjercicio).getTiempo()));
        progreso.setMax(rutina.getDetalleEjercicios().get(posicionEjercicio).getTiempo());
        progreso.setProgress(0);

    }

    public void onClickStart(View view) {
        siguiente = false;
        if (running) {
            btnStartStop.setIconResource(R.drawable.ic_iniciar);
        } else {
            btnStartStop.setIconResource(R.drawable.ic_pause);
        }
        running = !running;
    }

    public void onClickNext(View view) {

        btnStartStop.setIconResource(R.drawable.ic_iniciar);

        if ((posicionEjercicio + 1) < rutina.getDetalleEjercicios().size()) {
            posicionEjercicio++;
            siguiente = true;
            secondsEjercicio = rutina.getDetalleEjercicios().get(posicionEjercicio).getTiempo();
            tiempo.setText(String.valueOf(rutina.getDetalleEjercicios().get(posicionEjercicio).getTiempo()));
            progreso.setMax(rutina.getDetalleEjercicios().get(posicionEjercicio).getTiempo());
            progreso.setProgress(0);

            running = false;
        }

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onStop() {
        super.onStop();
        running = false;
        btnStartStop.setIconResource(R.drawable.ic_iniciar);
    }

    private void runTimer() {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {

                if (running) {

                    if (secondsEjercicio > -1) {
                        tiempo.setText(String.valueOf(secondsEjercicio));
                        secondsEjercicio--;
                        if (progreso.getProgress() == progreso.getMax()) {
                            progreso.setMax(rutina.getDetalleEjercicios().get(posicionEjercicio).getTiempo());
                        }
                        progreso.setProgress(progreso.getMax() - secondsEjercicio);
                    } else {

                        if (secondsRest > -1 && contadorDescansos < descansos) {
                            resting = true;
                            tiempo.setText(String.valueOf(secondsRest));
                            secondsRest--;
                            if (progreso.getProgress() == progreso.getMax()) {
                                progreso.setMax(20);
                            }
                            progreso.setProgress(progreso.getMax() - secondsRest);

                        } else {
                            resting = false;
                            ++contadorDescansos;
                            secondsRest = 20;

                            ++posicionEjercicio;
                            if (posicionEjercicio < rutina.getDetalleEjercicios().size()) {
                                secondsEjercicio = rutina.getDetalleEjercicios().get(posicionEjercicio).getTiempo();
                            } else {
                                running = false;
                                rutinaTerminada = true;
                                new MaterialAlertDialogBuilder(RealizarRutinaActivity.this).setTitle("Felicidades! Has completado tu entrenamiento con éxito").setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent intent = new Intent(RealizarRutinaActivity.this, HomeActivity.class);
                                        startActivity(intent);
                                    }
                                }).show();

                            }
                        }
                    }
                }

                if (resting) {
                    descanso.setText("DESCANSAR");
                    if (posicionEjercicio + 1 < rutina.getDetalleEjercicios().size()) {
                        nombreEjercicio.setText("Próximo Ejercicio : " + ejercicioDAO.consultarEjercicio(rutina.getDetalleEjercicios().get(posicionEjercicio + 1).getIdEjercicio()).getNombre());
                        int idImagen = getResources().getIdentifier(ejercicioDAO.consultarEjercicio(rutina.getDetalleEjercicios().get(posicionEjercicio + 1).getIdEjercicio()).getIdImagen(), "drawable", getPackageName());
                        imagenEjercicio.setImageResource(idImagen);
                        int pos = posicionEjercicio + 2;
                        posicionEj.setText(pos + "/" + rutina.getDetalleEjercicios().size());
                    }
                } else {
                    if (posicionEjercicio > 0 && posicionEjercicio < rutina.getDetalleEjercicios().size()) {
                        descanso.setText(ejercicioDAO.consultarEjercicio(rutina.getDetalleEjercicios().get(posicionEjercicio).getIdEjercicio()).getNombre());
                        nombreEjercicio.setText("");
                        posicionEj.setText("");
                        if (siguiente) {
                            int idImagen = getResources().getIdentifier(ejercicioDAO.consultarEjercicio(rutina.getDetalleEjercicios().get(posicionEjercicio).getIdEjercicio()).getIdImagen(), "drawable", getPackageName());
                            imagenEjercicio.setImageResource(idImagen);
                        }
                    }
                }
                handler.postDelayed(this, 200);
            }
        });
    }
}