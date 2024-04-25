package dinosaurios;

// La clase Atraccion con los atributos nombre, dinosaurio, capacidad, edad y zona. El
// dinosaurio representa un objeto de la clase Dinosaurio y la zona representa un objeto de
// la clase Zona. Además de constructores, getters y setters, tendrá el método asignarDino
// que asignará un dinosaurio a una atracción; y tendrá el método asignarZona que permitirá
// asignar una atracción a una zona.

public class Atraccion {
    String nombre;
    Dinosaurio dinosaurio;
    int capacidad;
    int edad; 
    Zona zona;


    public Atraccion(String nombre, Dinosaurio dinosaurio, int capacidad, int edad, Zona zona) {
        this.nombre = nombre;
        this.dinosaurio = dinosaurio;
        this.capacidad = capacidad;
        this.edad = edad;
        this.zona = zona;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Dinosaurio getDinosaurio() {
        return dinosaurio;
    }

    public void setDinosaurio(Dinosaurio dinosaurio) {
        this.dinosaurio = dinosaurio;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public void asignarDino(){

    }
    public void asignarZona(){
        
    }
}
