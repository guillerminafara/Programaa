package Modelo;

public class Trabajador {
    int cod_trabajador;
    String nom_trabajador;
    public Trabajador() {
    }
    public int getCod_trabajador() {
        return cod_trabajador;
    }
    public void setCod_trabajador(int cod_trabajador) {
        this.cod_trabajador = cod_trabajador;
    }
    public String getNom_trabajador() {
        return nom_trabajador;
    }
    public void setNom_trabajador(String nom_trabajador) {
        this.nom_trabajador = nom_trabajador;
    }
    @Override
    public String toString() {
        return "Trabajador [cod_trabajador=" + cod_trabajador + ", nom_trabajador=" + nom_trabajador + "]";
    }
    
}
