package com.example.homefitp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homefitp.Entidades.Ejercicio;
import com.example.homefitp.Entidades.Rutina;
import com.example.homefitp.modeloDAO.EjercicioDAO;
import com.example.homefitp.modeloDAO.RutinaDAO;

import java.util.ArrayList;

public class EjerciciosFragment extends Fragment {
    private RecyclerView recyclerViewEjercicios;
    ArrayList<Ejercicio> ejercicios;
    private EjercicioDAO ejercicioDAO;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.activity_detalle_rutina, container, false);

    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        recyclerViewEjercicios = view.findViewById(R.id.listaEjercicios);
        ejercicios = new ArrayList<Ejercicio>();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewEjercicios.setLayoutManager(layoutManager);
        ejercicioDAO = new EjercicioDAO(getContext());
        ejercicios = ejercicioDAO.consultarEjercicios();
        recyclerViewEjercicios.setAdapter(new AdaptadorEjercicios(ejercicios, getContext(), this));
    }

    public void verDetalleEjercicio(int id) {
      //  Intent intent = new Intent(this.getContext(),DetalleRutinaActivity.class);
        //intent.putExtra("idEjercicio" , id);
        //startActivity(intent);

    }
}
