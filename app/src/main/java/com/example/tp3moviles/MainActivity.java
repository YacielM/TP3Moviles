package com.example.tp3moviles;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tp3moviles.ui.DetalleActivity;
import com.example.tp3moviles.ui.LibroAdapter;
import com.example.tp3moviles.viewmodel.MainViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MainViewModel vm;
    private LibroAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = findViewById(R.id.recyclerView);
        EditText etBuscar = findViewById(R.id.etBuscar);
        Button btnBuscar = findViewById(R.id.btnBuscar);

        adapter = new LibroAdapter(new ArrayList<>(), libro -> {
            Intent i = new Intent(MainActivity.this, DetalleActivity.class);
            i.putExtra("libro", libro);
            startActivity(i);
        });

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);

        vm = new ViewModelProvider(this).get(MainViewModel.class);
        vm.getLibros().observe(this, lista -> {
            adapter.updateList(lista);
            if (lista.isEmpty()) Toast.makeText(this, "No se encontraron resultados", Toast.LENGTH_SHORT).show();
        });

        btnBuscar.setOnClickListener(v -> vm.buscar(etBuscar.getText().toString()));
    }
}