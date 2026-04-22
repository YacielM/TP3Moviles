package com.example.tp3moviles.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tp3moviles.data.Biblioteca;
import com.example.tp3moviles.data.CatalogHelper;
import com.example.tp3moviles.model.Libro;

import java.util.List;

public class MainViewModel extends ViewModel {
    private final MutableLiveData<List<Libro>> libros = new MutableLiveData<>(Biblioteca.obtenerLibros());

    public LiveData<List<Libro>> getLibros() { return libros; }

    public void buscar(String q) {
        List<Libro> all = Biblioteca.obtenerLibros();
        libros.setValue(CatalogHelper.filtrarPorCoincidencia(all, q));
    }
}
