package com.example.homefitp;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homefitp.Entidades.Rutina;
import com.example.homefitp.modeloDAO.RutinaDAO;

import java.util.ArrayList;


public class RutinasFragment extends Fragment {
    private RecyclerView recyclerViewRutinas;
    ArrayList<Rutina> rutinas;
    private RutinaDAO rutinaDAO;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_rutinas, container, false);

    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        recyclerViewRutinas = view.findViewById(R.id.listaRutinas);
        rutinas = new ArrayList<Rutina>();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerViewRutinas.setLayoutManager(layoutManager);
        rutinaDAO = new RutinaDAO(getContext());
        rutinas = rutinaDAO.consultarRutinas();
        recyclerViewRutinas.setAdapter(new AdaptadorRutinas(rutinas, getContext(), this));
    }


    public void verDetalleRutina(int id) {
        Intent intent = new Intent(this.getContext(),DetalleRutinaActivity.class);
        intent.putExtra("idRutina" , id);
        startActivity(intent);

    }
}