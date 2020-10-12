package com.example.homefitp;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homefitp.Entidades.Rutina;

import java.util.ArrayList;

public class AdaptadorRutinas extends RecyclerView.Adapter<AdaptadorRutinas.ViewHolderRutinas> {
    private ArrayList<Rutina> dataSet;
    private Context context;
    private RutinasFragment fragment;

    public AdaptadorRutinas(ArrayList<Rutina> dataSet, Context context, RutinasFragment fragment) {
        this.dataSet = dataSet;
        this.context = context;
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public AdaptadorRutinas.ViewHolderRutinas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_rutinas, parent, false);
        return new ViewHolderRutinas(view, fragment);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorRutinas.ViewHolderRutinas holder, int position) {
        final Rutina rutina = dataSet.get(position);
        holder.nombreRutina.setText(rutina.getNombre());
        int idImagen = context.getResources().getIdentifier(rutina.getIdImagen(), "drawable", context.getPackageName());
        holder.imagenRutina.setImageResource(idImagen);
        holder.idRutina.setText(rutina.getId());
    }


    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class ViewHolderRutinas extends RecyclerView.ViewHolder {
        private ImageView imagenRutina;
        private TextView nombreRutina;
        private TextView idRutina;

        public ViewHolderRutinas(@NonNull View itemView, final RutinasFragment fragment) {
            super(itemView);
            idRutina = (TextView) itemView.findViewById(R.id.textViewIdRutina);
            imagenRutina = itemView.findViewById(R.id.imageViewRutina);
            nombreRutina = itemView.findViewById(R.id.textViewNombreRutina);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fragment.verDetalleRutina(Integer.parseInt(idRutina.getText().toString()));
                }
            });
        }


    }
}
