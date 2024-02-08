public class Estudiante extends Persona{
    int iDestudiante;
    

    public Estudiante(String nombre, String apellidos, String nif, Direccion direccion, int iDestudiante) {
        super(nombre, apellidos, nif, direccion);
        this.iDestudiante= iDestudiante;
        //TODO Auto-generated constructor stub
    }


    public Estudiante() {
    }


    public int getIDestudiante() {
        return iDestudiante;
    }


    public void setIDestudiante(int iDestudiante) {
        iDestudiante = iDestudiante;
    }


    @Override
    public String toString() {
        return "Estudiante: -nombre: " +nombre + " apellido: "+ apellidos+ " NIF: "+ nif+ " Dirección: "+ direccion+ " idEstudiante: " + iDestudiante;
    }


    
}
