package com.example.tp3moviles.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.tp3moviles.R;
import com.example.tp3moviles.model.Libro;
import com.example.tp3moviles.viewmodel.DetalleViewModel;

public class DetalleActivity extends AppCompatActivity {

    private DetalleViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        ImageView ivPortada = findViewById(R.id.ivPortadaDetalle);
        TextView tvTitulo = findViewById(R.id.tvTituloDetalle);
        TextView tvAutor = findViewById(R.id.tvAutorDetalle);
        TextView tvDescripcion = findViewById(R.id.tvDescripcionDetalle);

        vm = new ViewModelProvider(this).get(DetalleViewModel.class);

        Libro libro = getIntent().getParcelableExtra("libro");
        vm.cargarLibro(libro);

        vm.getLibro().observe(this, l -> {
            if (l != null) {
                ivPortada.setImageResource(l.getPortadaResId());
                tvTitulo.setText(l.getTitulo());
                tvAutor.setText(l.getAutor());
                tvDescripcion.setText(l.getDescripcion());
            }
        });
    }
}
