package com.example.tp3moviles.data;

import com.example.tp3moviles.model.Libro;

import java.util.List;
import java.util.stream.Collectors;

public class CatalogHelper {
    public static List<Libro> filtrarPorCoincidencia(List<Libro> lista, String q) {
        if (q == null || q.trim().isEmpty()) return lista;
        String lower = q.trim().toLowerCase();
        return lista.stream()
                .filter(b -> b.getTitulo().toLowerCase().contains(lower))
                .collect(Collectors.toList());
    }
}
