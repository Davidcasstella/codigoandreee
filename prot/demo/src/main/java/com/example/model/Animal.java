package com.example.model;

public class Animal {
    private String nombre;
    private String descripcion;
    private String especie;
    private String estado;
    private String imagen;

    public Animal(String nombre, String descripcion, String especie, String estado, String imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.especie = especie;
        this.estado = estado;
        this.imagen = imagen;
    }

    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public String getEspecie() { return especie; }
    public String getEstado() { return estado; }
    public String getImagen() { return imagen; }
}

