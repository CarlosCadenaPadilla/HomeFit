package com.example.homefitp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homefitp.Entidades.DetalleEjercicio;
import com.example.homefitp.Entidades.Ejercicio;

import java.util.ArrayList;



    public class AdaptadorAgregarEjercicio extends RecyclerView.Adapter<AdaptadorAgregarEjercicio.ViewHolderAgregarEjercicios> {
        private ArrayList<Ejercicio> dataSet;
        private Context context;
        private AgregarEjercicioActivity agregarEjercicioActivity;


        public AdaptadorAgregarEjercicio(ArrayList<Ejercicio> dataSet, Context context, AgregarEjercicioActivity agregarEjercicioActivity) {
            this.dataSet = dataSet;
            this.context = context;
            this.agregarEjercicioActivity = agregarEjercicioActivity;
        }

        @NonNull
        @Override
        public AdaptadorAgregarEjercicio.ViewHolderAgregarEjercicios onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_agregar_ejercicio, parent, false);
            return new AdaptadorAgregarEjercicio.ViewHolderAgregarEjercicios(view, agregarEjercicioActivity);
        }


        @Override
        public void onBindViewHolder(@NonNull AdaptadorAgregarEjercicio.ViewHolderAgregarEjercicios holder, int position) {
            final Ejercicio ejercicio = dataSet.get(position);
            holder.nombreEjercicio.setText(ejercicio.getNombre());
            int idImagen = context.getResources().getIdentifier(ejercicio.getIdImagen(), "drawable", context.getPackageName());
            holder.imagenEjercicio.setImageResource(idImagen);
            holder.idEjercicio.setText(String.valueOf(ejercicio.getId()));
        }

        @Override
        public int getItemCount() {
            return dataSet.size();
        }

        public static class ViewHolderAgregarEjercicios extends RecyclerView.ViewHolder {
            private ImageView imagenEjercicio;
            private TextView nombreEjercicio;
            private TextView idEjercicio;

            public ViewHolderAgregarEjercicios(@NonNull View itemView, final AgregarEjercicioActivity agregarEjercicioActivity) {
                super(itemView);
                idEjercicio = (TextView) itemView.findViewById(R.id.textViewIdEjercicio);
                imagenEjercicio = itemView.findViewById(R.id.imageViewEjercicio);
                nombreEjercicio = itemView.findViewById(R.id.textViewNombreEjercicio);

                itemView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        agregarEjercicioActivity.agregarEjercicio(Integer.parseInt(idEjercicio.getText().toString()));
                    }
                });
            }
        }
    }


