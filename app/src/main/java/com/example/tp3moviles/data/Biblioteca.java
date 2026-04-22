package com.example.tp3moviles.data;

import com.example.tp3moviles.R;
import com.example.tp3moviles.model.Libro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Biblioteca {
    private static final List<Libro> LIBROS = new ArrayList<>();

    static {
        LIBROS.add(new Libro("El Principito", "Antoine de Saint-Exupéry", 96, 1943,
                Arrays.asList("Ficción", "Clásico"), R.drawable.cover_principito,
                "Una breve y poética historia sobre un niño y su viaje."));
        LIBROS.add(new Libro("Cien Años de Soledad", "Gabriel García Márquez", 417, 1967,
                Arrays.asList("Realismo mágico", "Novela"), R.drawable.cover_cien_anos,
                "Saga familiar que mezcla lo cotidiano con lo fantástico."));
        // Agrega más libros con nombres y descripciones propias
    }

    public static List<Libro> obtenerLibros() {
        return new ArrayList<>(LIBROS);
    }

    public static Libro buscarPorTituloExacto(String titulo) {
        if (titulo == null) return null;
        for (Libro l : LIBROS) {
            if (l.getTitulo().equalsIgnoreCase(titulo.trim())) return l;
        }
        return null;
    }
}