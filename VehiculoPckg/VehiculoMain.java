import java.util.ArrayList;
import java.util.Scanner;

public class VehiculoMain {
    public static void main(String[] args) {

        menu();

    }

    public static void menu() {
        ArrayList<Coche> listaAuto = new ArrayList<>();
        ArrayList<Bicicleta> listaBici = new ArrayList<>();
        // Vehiculo bici;
        // Vehiculo autito = new Coche();
        Bicicleta bici = new Bicicleta();
        Coche auto = new Coche();
        Scanner leer = new Scanner(System.in);
        int kilometros = 0;
        int resp = 0;
        do {

            System.out.println("Elige una opción (1-7):");

            System.out.println("1. Anda en bicicleta\n" + //
                    "2. Anda en coche\n" + //
                    "3. Ver kilometraje de la bicicleta\n" + //
                    "4. Ver kilometraje del coche\n" + //
                    "5. Ver kilometraje total\n" + //
                    "6. Ver vehículos totales\n" + //
                    "7. Salir");
            resp = leer.nextInt();

            if (resp == 1) {

            } else if (resp == 2) {

            }
            switch (resp) {
                case 1:

                    System.out.println("¿Cuántos kilometros desea recorrer?");

                    kilometros = leer.nextInt();
                    listaBici.add(bici);

                    bici.andaEn(kilometros);
                    break;
                case 2:

                    System.out.println("¿Cuántos kilometros desea recorrer?");
                    kilometros = leer.nextInt();
                    listaAuto.add(auto);
                    auto.andaEn(kilometros);

                    break;
                case 3:
                    System.out.println("Kilometros recorridos por la bicicleta");
                    System.out.println(bici.getKilomerosRecorridos());
                    break;
                case 4:
                    System.out.println("Kilometros recorridos por la bicicleta");
                    System.out.println(auto.getKilomerosRecorridos());
                    break;
                case 5:
                    System.out.println("kilometros recorridos por el auto: " + auto.getKilometrosTotales());
                    System.out.println("kilometros recorridos por la bici: " + bici.getKilometrosTotales());
                    break;
                case 6:
                    for (Bicicleta aux : listaBici) {
                        System.out.println(aux);
                    }
                    for (Coche aux : listaAuto) {
                        System.out.println(aux);
                    }
                    break;

                case 7:
                    System.out.println("saliendo");
                    break;

                default:
                    System.out.println("Elige una opción (1-7):");
                    resp = leer.nextInt();
                    break;
            }

        } while (resp != 7);
    }

}
