import java.util.ArrayList;
import java.util.List;

public class PersonaMain {
    public static void main(String[] args) {

        Direccion dirP = new Direccion("calle falsa 611", "Paiporta", 45333, "España");
        Profesor profesor = new Profesor("profe", "nombreprofe", "4234324g", dirP, 2);
        Direccion dirE = new Direccion("laprida", "paiporta", 45333, "España");
        Persona estudiante = new Estudiante("Paquito", "fara", "645455d", dirE, 12332);
        List<Persona> p1 = new ArrayList<>();
        p1.add(estudiante);
        p1.add(profesor);
        for (Persona persona : p1) {
            System.out.println(persona);
        }

        //System.out.println(p1);
    }

}
