package Reserva;

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
            leer.nextLine();

            switch (resp) {
                case 1:
                    System.out.println("Id Vuelo: ");
                    String id_Vuelo = leer.nextLine();
                    System.out.println("Origen: ");
                    String origen = leer.nextLine();
                    System.out.println("Destino: ");
                    String destino = leer.nextLine();
                    System.out.println("Fecha: ");
                    String fecha = leer.nextLine();
                    System.out.println("Capacidad: ");
                    int capacidad = leer.nextInt();
                    Vuelos vuelo = new Vuelos(id_Vuelo, origen, destino, fecha, capacidad);
                    vuelo.agregarVuelo();
                    break;
                case 2:
                    System.out.println("Ingresa el pasaporte");
                    String pasaporte = leer.nextLine();
                    System.out.println("nombre del pasajero");
                    String nombre = leer.nextLine();
                    Pasajeros pasajero = new Pasajeros(pasaporte, nombre);
                    pasajero.agregarPasajero();
                    break;
                case 3:
                    System.out.println("Ingresa pasaporte");
                    String pasp= leer.nextLine();
                    
                    Vuelo_Pasajeros reserva= new Vuelo_Pasajeros();
                    if (reserva.corroboraAsiento()) {
                        System.out.println("sisePuede");
                    }else{
                        System.out.println("Asiento reservado");
                    }

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