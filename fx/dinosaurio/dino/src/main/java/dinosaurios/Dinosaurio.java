package dinosaurios;

// La clase Dinosaurio tiene como atributos nombre, tamanyo (grande, mediano o peque);
// alimentación (carnivoro, omnivoro o herbivoro) y tipo (tierra, aire o agua).


public class Dinosaurio {
int idDino;
    String nombre;
    String tamanyo;
    String alimentacion;
    String tipo;

    public Dinosaurio() {

    }

    public Dinosaurio(String nombre, String tamanyo, String alimentacion, String tipo) {
        this.nombre = nombre;
        this.tamanyo = tamanyo;
        this.alimentacion = alimentacion;
        this.tipo = tipo;
    }

    public int getIdDino() {
        return idDino;
    }

    public void setIdDino(int idDino) {
        this.idDino = idDino;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTamanyo() {
        return tamanyo;
    }
    public void setTamanyo(String tamanyo) {
        this.tamanyo = tamanyo;
    }
    public String getAlimentacion() {
        return alimentacion;
    }
    public void setAlimentacion(String alimentacion) {
        this.alimentacion = alimentacion;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return   nombre + " de "+ tipo;
    }
}