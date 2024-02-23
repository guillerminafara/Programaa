import java.util.Scanner;

public class ValidaString {
    public static final String[] COMPOSITORES = { "Bach", "Haydn", "Mozart", "Beethoven",
            "Brahms", "Mahler", "Bartok" };

    public static void main(String[] args) {
        try {
            devuelve();
        } catch (Exception e) {
        System.out.println(e.getMessage());
        }
    }

    public static void devuelve() throws ElementoNoExistente {
        Scanner leer = new Scanner(System.in);

        String nombre = leer.nextLine();
        for (int j = 0; j < COMPOSITORES.length; j++) {
            if (COMPOSITORES[j].equalsIgnoreCase(nombre)) {
                System.out.println(j);
            }
            if(!COMPOSITORES[j].equalsIgnoreCase(nombre)){
       
                throw new ElementoNoExistente("ElementoNoExistente");
            }
        }

    }

}

class ElementoNoExistente extends Exception {
    ElementoNoExistente(String mensaje) {
        super(mensaje);
    }

}
