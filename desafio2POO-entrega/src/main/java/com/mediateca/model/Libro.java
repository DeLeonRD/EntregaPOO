package com.mediateca.model;


public class Libro extends MaterialEscrito {

    private String titulo;
    private int anio;

    public Libro() {
    }

    public String getTitulo() {
        return titulo;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public int getAnio() {
        return anio;
    }


    public void setAnio(int anio) {
        this.anio = anio;
    }


    @Override
    public String toString() {
        return "Libro{" +
                "id=" + getId() +
                ", tipo='" + getTipo() + '\'' +
                ", autor='" + getAutor() + '\'' +
                ", titulo='" + titulo + '\'' +
                ", anio=" + anio +
                '}';
    }
}