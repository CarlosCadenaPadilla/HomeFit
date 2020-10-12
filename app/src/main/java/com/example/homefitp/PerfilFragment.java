package com.example.homefitp;

import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



public class PerfilFragment extends Fragment {

    Toolbar topAppBar;
    TextView nombreUsuario;

    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_perfil, container, false);

        topAppBar = view.findViewById(R.id.AppBarPerfil);
        topAppBar.setOnMenuItemClickListener(appBarListener);

        nombreUsuario = view.findViewById(R.id.textViewNombreUsuario);
        nombreUsuario.setText(MyApplication.getUsuario().getNombre());

        return view;
    }

    private Toolbar.OnMenuItemClickListener appBarListener = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            Intent intent;
            switch (item.getItemId()) {
                case R.id.edit:
                    intent = new Intent(getContext(), EditarDatosActivity.class);
                    startActivity(intent);
                    break;
                case R.id.settings:
                    intent = new Intent(getContext(), ConfiguracionActivity.class);
                    startActivity(intent);
                    break;
            }
            return true;
        }
    };


}