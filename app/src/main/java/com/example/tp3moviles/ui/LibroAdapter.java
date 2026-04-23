package com.example.tp3moviles.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.tp3moviles.R;
import com.example.tp3moviles.model.Libro;
import java.util.List;
public class LibroAdapter extends RecyclerView.Adapter<LibroAdapter.VH> {

    public interface OnItemClick {
        void onClick(Libro libro);
    }

    private List<Libro> items;
    private final OnItemClick listener;

    public LibroAdapter(List<Libro> items, OnItemClick listener) {
        this.items = items;
        this.listener = listener;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_libro, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Libro l = items.get(position);
        holder.titulo.setText(l.getTitulo());
        holder.autor.setText(l.getAutor());
        holder.portada.setImageResource(l.getPortadaResId());
        holder.itemView.setOnClickListener(v -> listener.onClick(l));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void updateList(List<Libro> nuevos) {
        this.items = nuevos;
        notifyDataSetChanged();
    }

    static class VH extends RecyclerView.ViewHolder {
        ImageView portada;
        TextView titulo, autor;

        VH(@NonNull View itemView) {
            super(itemView);
            portada = itemView.findViewById(R.id.ivPortada);
            titulo = itemView.findViewById(R.id.tvTituloItem);
            autor = itemView.findViewById(R.id.tvAutorItem);
        }
    }
}