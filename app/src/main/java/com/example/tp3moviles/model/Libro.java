package com.example.tp3moviles.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Libro implements Parcelable {
    private final String titulo;
    private final String autor;
    private final int paginas;
    private final int anio;
    private final List<String> categorias;
    private final int portadaResId;
    private final String descripcion;

    public Libro(String titulo, String autor, int paginas, int anio,
                 List<String> categorias, int portadaResId, String descripcion) {
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
        this.anio = anio;
        this.categorias = categorias;
        this.portadaResId = portadaResId;
        this.descripcion = descripcion;
    }

    protected Libro(Parcel in) {
        titulo = in.readString();
        autor = in.readString();
        paginas = in.readInt();
        anio = in.readInt();
        portadaResId = in.readInt();
        descripcion = in.readString();
        categorias = in.createStringArrayList();
    }

    public static final Creator<Libro> CREATOR = new Creator<Libro>() {
        @Override public Libro createFromParcel(Parcel in) { return new Libro(in); }
        @Override public Libro[] newArray(int size) { return new Libro[size]; }
    };

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getPaginas() { return paginas; }
    public int getAnio() { return anio; }
    public List<String> getCategorias() { return categorias; }
    public int getPortadaResId() { return portadaResId; }
    public String getDescripcion() { return descripcion; }

    @Override public int describeContents() { return 0; }
    @Override public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(titulo);
        dest.writeString(autor);
        dest.writeInt(paginas);
        dest.writeInt(anio);
        dest.writeInt(portadaResId);
        dest.writeString(descripcion);
        dest.writeStringList(categorias);
    }
}
