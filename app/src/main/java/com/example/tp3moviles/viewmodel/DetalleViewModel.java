package com.example.tp3moviles.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tp3moviles.model.Libro;

public class DetalleViewModel extends ViewModel {
    private final MutableLiveData<Libro> libro = new MutableLiveData<>();

    public LiveData<Libro> getLibro() { return libro; }

    public void cargarLibro(Libro l) { libro.setValue(l); }
}
