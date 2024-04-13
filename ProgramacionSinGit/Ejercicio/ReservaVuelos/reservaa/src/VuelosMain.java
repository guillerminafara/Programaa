import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;

/**
 * VuelosMain
 */
public class VuelosMain {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        int resp;
        Vuelo_Pasajeros reserva = null;
        Vuelos vuelo = null;
        Pasajeros pasajero = null;
        try {
            String respS;
            int codigo;

            do {

                System.out.println(
                        " 1. Alta Vuelo\n 2. Alta Pasajero\n 3. Reserva Vuelo\n 4. Modificar reserva\n 5. Baja reserva\n 6. Salir");
                resp = leer.nextInt();
                leer.nextLine();

                switch (resp) {
                    case 1:
                        // Para crear un vuelo solicitaremos un codigo de 6 caracteres, origen, destino,
                        // fecha (yyyy/mm/dd) y la capacidad
                        System.out.println("Agregar un Vuelo");
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
                        vuelo = new Vuelos(id_Vuelo, origen, destino, fecha, capacidad);
                        vuelo.agregarVuelo();
                        break;
                    case 2:
                        // para crear un pasajero pediremos su pasaporte, nombre, el id se genera
                        // automaticamente
                        System.out.println("Agregar un Pasajero");
                        System.out.println("Ingresa el pasaporte");
                        String pasaporte = leer.nextLine();
                        System.out.println("nombre del pasajero");
                        String nombre = leer.nextLine();
                        pasajero = new Pasajeros(pasaporte, nombre);
                        pasajero.agregarPasajero();
                        break;
                    case 3:
                        // Crear reserva mostramos los vuelos disponible y solicitamos el codigo del
                        // vuelo
                        System.out.println("Reservar vuelo");
                        pasajero = new Pasajeros();
                        vuelo = new Vuelos();
                        reserva = new Vuelo_Pasajeros();
                        ArrayList<Vuelos> lista = new ArrayList<>();
                        lista.addAll(vuelo.mostrarVuelos());
                        System.out.println(lista);
                        try {
                            System.out.println("Selecciona un vuelo");
                            String idVuelo = leer.nextLine();

                            System.out.println("Ingresa pasaporte");
                            String pasp = leer.nextLine(); // busco a ver si existe en la base

                            pasajero = pasajero.buscarPasajeros(pasp);

                            if (!pasajero.getNombre_pasajero().equals(null)) { // compruebo si existe el pasajero

                                System.out.println("Selecciona el número de asiento");
                                int numAsiento = leer.nextInt();
                                leer.nextLine();

                                if (!reserva.buscarAsientos(numAsiento, pasp)) {
                                    // pasajeros.getId_pasajero();
                                    reserva.reservarViaje(idVuelo, pasajero.getId_pasajero(), numAsiento);
                                } else {
                                    System.out.println("pos nada ");
                                }
                            }
                        } catch (NullPointerException e) {
                            System.out.println("Debes crear al pasajero");
                        }

                        break;
                    case 4:
                        System.out.println("Modificar una reserva");
                        reserva = new Vuelo_Pasajeros();
                        System.out.println("Indique el código de la reserva");
                        codigo = leer.nextInt();
                        reserva = reserva.buscarReserva(codigo);
                        reserva.setId_reserva(codigo);
                        System.out.println(reserva);
                        System.out.println("¿Qué asiento quieres?");
                        resp = leer.nextInt();
                        leer.nextLine();

                        // reserva.modificarReserva(resp, codigo);
                        reserva.modificarReserva(reserva, resp);
                        break;
                    case 5:
                        System.out.println("Eliminar una reserva");
                        reserva = new Vuelo_Pasajeros();
                        System.out.println("Ingrese el código de la reserva");
                        codigo = leer.nextInt();
                        leer.nextLine();
                        reserva.buscarReserva(codigo);
                        System.out.println("Estas serguro que deseas eliminar la reserva? y/n");
                        respS = leer.nextLine();
                        if (respS.equals("y")) {
                            reserva.eliminarReserva(codigo);
                        }
                        break;
                    case 6:
                        break;
                    case 7:
                        // bloque para probar cosas random
                        // reserva = new Vuelo_Pasajeros();
                        // reserva.buscarAsientos(2, "QW3456");
                        // pasajero = pasajero.buscarPasajerosPorId(2);
                        pasajero = new Pasajeros();
                        // System.out.println(pasajero.buscarPasajerosPorId(2));
                        pasajero.busca();
                        break;
                    default:
                        System.out.println("Escoge una opción válida");

                        break;
                }

            } while (resp != 6);
            // } catch (NullPointerException e) {
            // System.out.println("Ingresa valores");
        } catch (InputMismatchException e) {
            System.out.println("Ingresa un número");
        } catch (MysqlDataTruncation e1) {
            // TODO Auto-generated catch block
            System.out.println("error");
        }
    }// fin main

}// fin clase