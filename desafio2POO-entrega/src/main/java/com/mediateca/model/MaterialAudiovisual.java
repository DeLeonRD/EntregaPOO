package com.mediateca.model;

public class MaterialAudiovisual extends Material {

    protected int duracion;

    public MaterialAudiovisual() {
    }


    public MaterialAudiovisual(int id, String tipo, int duracion) {
        super(id, tipo);
        this.duracion = duracion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }


    @Override
    public String toString() {
        return "MaterialAudiovisual{" +
                "id=" + getId() +
                ", tipo='" + getTipo() + '\'' +
                ", duracion=" + duracion +
                '}';
    }
}