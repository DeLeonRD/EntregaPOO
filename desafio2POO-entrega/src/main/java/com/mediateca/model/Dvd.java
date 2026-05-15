package com.mediateca.model;

/**
 * Clase que representa un DVD dentro de la mediateca.
 */
public class Dvd extends MaterialAudiovisual {

    private String director;


    public Dvd() {}

    public Dvd(int id, String tipo, int duracion, String director) {
        super(id, tipo, duracion);
        this.director = director;
    }

    public String getDirector() {
        return director;
    }


    public void setDirector(String director) {
        this.director = director;
    }


    @Override
    public String toString() {
        return "Dvd{" +
                "id=" + getId() +
                ", tipo='" + getTipo() + '\'' +
                ", duracion=" + getDuracion() +
                ", director='" + director + '\'' +
                '}';
    }
}