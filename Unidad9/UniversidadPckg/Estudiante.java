public class Estudiante extends Persona{
    int IDestudiante;
    

    public Estudiante(String nombre, String apellidos, String nif, String direccion, int IDestudiante) {
        super(nombre, apellidos, nif, direccion);
        this.IDestudiante= IDestudiante;
        //TODO Auto-generated constructor stub
    }


    public Estudiante() {
    }


    public int getIDestudiante() {
        return IDestudiante;
    }


    public void setIDestudiante(int iDestudiante) {
        IDestudiante = iDestudiante;
    }


    @Override
    public String toString() {
        return "Estudiante [IDestudiante=" + IDestudiante + "]";
    }


    
}
