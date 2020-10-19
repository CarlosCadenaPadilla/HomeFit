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
import com.example.homefitp.Entidades.Rutina;
import com.example.homefitp.modeloDAO.EjercicioDAO;

import java.util.ArrayList;

public class AdaptadorEjercicios extends RecyclerView.Adapter<AdaptadorEjercicios.ViewHolderEjercicios> {
    private ArrayList<DetalleEjercicio> dataSet;
    private Context context;
    private DetalleRutinaActivity detalleRutinaActivity;


    public AdaptadorEjercicios(ArrayList<DetalleEjercicio> dataSet, Context context, DetalleRutinaActivity detalleRutinaActivity) {
        this.dataSet = dataSet;
        this.context = context;
        this.detalleRutinaActivity = detalleRutinaActivity;
    }

    @NonNull
    @Override
    public AdaptadorEjercicios.ViewHolderEjercicios onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_ejercicios, parent, false);
        return new AdaptadorEjercicios.ViewHolderEjercicios(view, detalleRutinaActivity);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorEjercicios.ViewHolderEjercicios holder, int position) {
        final DetalleEjercicio detalleEjercicio = dataSet.get(position);
        final Ejercicio ejercicio = detalleRutinaActivity.ejercicioDAO.consultarEjercicio(detalleEjercicio.getIdEjercicio());
        holder.nombreEjercicio.setText(ejercicio.getNombre());
        int idImagen = context.getResources().getIdentifier(ejercicio.getIdImagen(), "drawable", context.getPackageName());
        holder.imagenEjercicio.setImageResource(idImagen);
        holder.idEjercicio.setText(String.valueOf(ejercicio.getId()));
        holder.tiempoEjercicio.setText(String.valueOf(detalleEjercicio.getTiempo()) + " seg");
        int posicion = position + 1;
        holder.posicionEjercicio.setText(posicion + "/" + dataSet.size());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class ViewHolderEjercicios extends RecyclerView.ViewHolder {
        private ImageView imagenEjercicio;
        private TextView nombreEjercicio;
        private TextView idEjercicio;
        private TextView tiempoEjercicio;
        private TextView posicionEjercicio;

        public ViewHolderEjercicios(@NonNull View itemView, final DetalleRutinaActivity detalleRutinaActivity) {
            super(itemView);
            idEjercicio = (TextView) itemView.findViewById(R.id.textViewIdEjercicio);
            imagenEjercicio = itemView.findViewById(R.id.imageViewEjercicio);
            nombreEjercicio = itemView.findViewById(R.id.textViewNombreEjercicio);
            tiempoEjercicio = itemView.findViewById(R.id.textViewTiempoEjercicio);
            posicionEjercicio = itemView.findViewById(R.id.textViewPosicionEjercicio);
            itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    detalleRutinaActivity.verDetalleEjercicio(Integer.parseInt(idEjercicio.getText().toString()));
                }
            });
        }
    }
}
