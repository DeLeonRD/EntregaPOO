package com.mediateca.model;

/**
 * Clase que representa un CD
 */
public class CdAudio extends MaterialAudiovisual {

    private String artista;

    public CdAudio() {}


    public CdAudio(int id, String tipo, int duracion, String artista) {
        super(id, tipo, duracion);
        this.artista = artista;
    }


    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }


    @Override
    public String toString() {
        return "CdAudio{" +
                "id=" + getId() +
                ", tipo='" + getTipo() + '\'' +
                ", duracion=" + getDuracion() +
                ", artista='" + artista + '\'' +
                '}';
    }
}