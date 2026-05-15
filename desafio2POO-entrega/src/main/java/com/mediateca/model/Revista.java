package com.mediateca.model;


public class Revista extends Material {

    private String nombre;
    private int edicion;

    public Revista() {}


    public Revista(int id, String nombre, int edicion) {
        this.id = id;
        this.nombre = nombre;
        this.edicion = edicion;
    }
    public String getNombre() {
        return nombre;
    }

 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

 
    public int getEdicion() {
        return edicion;
    }


    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }


    @Override
    public String toString() {
        return "Revista{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edicion=" + edicion +
                '}';
    }
}