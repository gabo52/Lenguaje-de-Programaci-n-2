package com.gamesoft.project.model;
public class Genero {
    private String nombre;
    private String descripcion;
    
    public Genero(String nombre, String descripcion){
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }
    
}
