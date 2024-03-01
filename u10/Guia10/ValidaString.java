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

    public static void devuelve() throws ElementoNoExistente, NullPointerException {
        Scanner leer = new Scanner(System.in);
        System.out.println("ingresa el nombre de un compositor: ");
        String nombre = leer.nextLine();
        boolean bandera = true;
        int i = 0;
        if (nombre.isEmpty()) {
            System.out.println("has ingresado un nombre vacio, ingresa un nombre:");
            nombre = leer.nextLine();
        }
        while (bandera && i <= COMPOSITORES.length) {
            if (!nombre.equalsIgnoreCase(COMPOSITORES[i])) {
                if (i < COMPOSITORES.length - 1) {
                    i++;
                } else {
                    throw new ElementoNoExistente("ElementoNoExistente");
                }
            }
            if (nombre.equalsIgnoreCase(COMPOSITORES[i])) {
                System.out.println("ubicacion: " + i);
                bandera = false;
            }
        }
    }
}

class ElementoNoExistente extends Exception {
    ElementoNoExistente(String mensaje) {
        super(mensaje);
    }

}
