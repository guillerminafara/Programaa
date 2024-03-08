import java.io.*;
import java.util.*;

class Equipo implements Serializable, Comparable<Equipo> {
    private String nombre;
    private int puntos;

    public Equipo(String nombre, int puntos) {
        this.nombre = nombre;
        this.puntos = puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    @Override
    public String toString() {
        return nombre + " - " + puntos + " puntos";
    }

    @Override
    public int compareTo(Equipo o) {
        int dev = 0;
        if (this.puntos < o.puntos) {
            dev--;
        } else if (this.puntos > o.puntos) {
            dev++;
        }
        return dev;
    }
}

public class Clasificacion implements Serializable {
    private List<Equipo> equipos;

    public Clasificacion() {
        equipos = new ArrayList<>();
    }

    public void addEquipo(Equipo equipo) {
        equipos.add(equipo);
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void imprimirClasificacion() {
        System.out.println("Clasificación");
        for (Equipo equipo : equipos) {
            System.out.println(equipo);
        }
    }

    public void serializar(String archivo) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(archivo))) {
            out.writeObject(this);
            System.out.println("Clasificación serializada en " + archivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Clasificacion deserializar(String archivo) {
        Clasificacion clasificacion = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))) {
            clasificacion = (Clasificacion) in.readObject();
            System.out.println("Clasificación deserializada de " + archivo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clasificacion;
    }

    public static void main(String[] args) {
        Clasificacion clasificacion = new Clasificacion();
        clasificacion.addEquipo(new Equipo("R. Madrid", 66));
        clasificacion.addEquipo(new Equipo("Girona", 58));
        clasificacion.addEquipo(new Equipo("Barcelona", 59));
        clasificacion.addEquipo(new Equipo("Atlético", 55));

        clasificacion.imprimirClasificacion();

        clasificacion.serializar("clasificacion.dat");

        Clasificacion clasificacionRec = Clasificacion.deserializar("clasificacion.dat");
        clasificacionRec.imprimirClasificacion();

        ArrayList<Equipo> eq1 = new ArrayList<>();
        eq1.addAll(clasificacion.getEquipos());
        // int i = 0;
        int j = 0;
        int k = 0;
        // int l = 0;
        int[] vector = new int[clasificacion.getEquipos().size()];
        System.out.println("-----------------------");
        HashMap<String, Integer> mapita = new HashMap<>();
        for (Equipo equipo : eq1) {
            j = 0;

            for (int i = 0; i < clasificacion.getEquipos().size(); i++) {
                j += equipo.compareTo(clasificacion.getEquipos().get(i));
            }
            vector[k] = j;

            mapita.put(equipo.getNombre(), j);
            k++;

        }
        System.out.println(mapita);
      
        System.out.println(Arrays.toString(vector));
        // System.out.println("valores: " +mapita.get());
       mapita.values();

        // System.out.printf("i: %d j: %d k: %d l: %d \n", i, j, k, l);
       
    }

}
// List<Integer> lista = new ArrayList<>(mapita.values());
// lista.sort(Comparator.naturalOrder()); System.out.println("lista  " + lista);