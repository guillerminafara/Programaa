package Modelo;

public class Grupo {
    int cod_grupo;
    String nom_servicio;
    
    public Grupo() {
    }
    public int getCod_grupo() {
        return cod_grupo;
    }
    public void setCod_grupo(int cod_grupo) {
        this.cod_grupo = cod_grupo;
    }
    public String getNom_servicio() {
        return nom_servicio;
    }
    public void setNom_servicio(String nom_servicio) {
        this.nom_servicio = nom_servicio;
    }
    @Override
    public String toString() {
        return "Grupo [cod_grupo=" + cod_grupo + ", nom_servicio=" + nom_servicio + "]";
    }
    
}
