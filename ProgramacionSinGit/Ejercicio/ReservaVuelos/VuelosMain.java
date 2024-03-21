import java.util.Scanner;

/**
 * VuelosMain
 */
public class VuelosMain {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int resp;
        do {

            System.out.println(
                    "1. Alta Vuelo\n 2. Alta Pasajero\n 3. Reserva Vuelo\n 4. Modificar reserva\n 5. Baja reserva\n 6. Salir");
            resp = leer.nextInt();

            switch (resp) {
                case 1:
                
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;

                default:
                    System.out.println("Opción no válida");

                    break;
            }

        } while (resp != 6);
    }// fin main
}// fin clase