package hola;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*1. Crear un programa que permita introducir texto por teclado y lo
irá guardando en un fichero. */
public class GuardarFi {
    public static void main(String[] args) {

        String linea;
        try {
            Scanner leer = new Scanner(System.in);
            System.out.println("ingresa el nombre del fichero: ");
            String nombre=leer.nextLine();
            FileWriter fw = new FileWriter(nombre);

            // fw.write("Cómo estan? \n OK \n");
            System.out.println("ingresa las lineas: escribe salir al terminar ");
            String palabra = "";
            do {
              
                palabra = leer.nextLine();
                if (palabra.equalsIgnoreCase("salir")) {
                    continue;
                    
                }
                fw.write(palabra + "\n");
                fw.flush();

            } while (!palabra.equalsIgnoreCase("salir"));

            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // try {
        // PrintWriter pw = new PrintWriter("ficherofachero.txt");
        // // pw.println("Hola, esto es un ejemplo de PrintWriter");
        // // pw.printf("Este es un número: %d", 42);
        // pw.close();
        // } catch (IOException e) {
        // e.printStackTrace();
        // }
    }

}