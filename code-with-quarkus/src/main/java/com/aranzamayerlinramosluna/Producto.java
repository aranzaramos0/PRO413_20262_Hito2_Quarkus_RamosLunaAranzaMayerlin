package com.aranzamayerlinramosluna;

public class Producto {
    public Long id;
    public String nombre;
    public double precio;

    public Producto() {}

    public Producto(Long id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }
}