package com.example;

public class Prueba {
    String nombre;
    int edad;
    
    public Prueba() {
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    @Override
    public String toString() {
        return "Prueba [nombre=" + nombre + ", edad=" + edad + "]";
    }
    
}
