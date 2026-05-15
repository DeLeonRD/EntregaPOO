package com.mediateca.model;


public class MaterialEscrito extends Material {

    protected String autor;

    public MaterialEscrito() {
    }


    public MaterialEscrito(int id, String tipo, String autor) {
        super(id, tipo);
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }


    public void setAutor(String autor) {
        this.autor = autor;
    }


    @Override
    public String toString() {
        return "MaterialEscrito{" +
                "id=" + getId() +
                ", tipo='" + getTipo() + '\'' +
                ", autor='" + autor + '\'' +
                '}';
    }
}