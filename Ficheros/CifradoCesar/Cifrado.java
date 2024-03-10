import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Realiza un programa al que se le pasen dos argumentos: el nombre de un
 * archivo de texto y
 * un número entre el 1 y el 9. Por ejemplo:
 * > cifrado prueba.txt 4
 * El programa usará el número para cifrar el texto del archivo tantas
 * posiciones como dice el
 * número.
 * El resultado se guardará en un archivo con el nombre igual que el original
 * pero con la
 * extensión cfN, donde la N representa el número de posiciones de la
 * codificación. En el
 * ejemplo, se llamará prueba.cf4
 */
public class Cifrado {

    public static void main(String[] args) throws IOException {
        try {
        String nombre = args[0];
        String n = args[1];
            if(!nombre.contains(".txt")){
                throw new Exception("Asegurate de ingresar una extension '.txt'");
            }
        if(!n.matches("[0-9]+")){
           throw new InputMismatchException("Ingresa el número después del fichero");
        }
        char aux = 0;
        int num = Integer.parseInt(n);
       
            File fi = new File(nombre);
            // fi.renameTo(fi2); // el rename pide un fichero, no puedo agregarle un String

            if (fi.isDirectory()) {
                throw new Exception("Haz ingresado un directorio");
            }
            FileReader fr = new FileReader(fi);
            nombre = nombre.replace(".txt", "");
            FileWriter fw = new FileWriter(nombre + ".cf" + n);
            fw.write(cifrado(fr, n));
            fw.close();
        } catch (FileNotFoundException e) {
            System.out.println("El sistema no puede encontrar el archivo especificado o no existe");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Debes ingresar 1 fichero y un número");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }// fin main

    public static String cifrado(FileReader fr, String n) throws IOException {
        int num = Integer.parseInt(n);
        int aux = 0;
        String devolver = "";

        try {
            while ((aux = fr.read()) != -1) {
                devolver += (char) (aux + num) + "";
            }
            fr.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return devolver;
    }
}// fin clase