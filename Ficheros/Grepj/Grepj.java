import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Grepj {
    public static void main(String[] args) {
        try {
            String texto = args[0];
            String palabra = args[1];
            File ficherito = new File(texto);
            if(ficherito.isDirectory()){
                throw new Exception("Ingresa un fichero de texto");
            } 
            FileReader fichero = new FileReader(ficherito);
            BufferedReader entrada = new BufferedReader(fichero);
            String pruebita = entrada.readLine();
            int linea = 0;
            int aux = 0;
            String recorta = "";
            while (pruebita != null) {
                String[] vector = pruebita.split(" ");
                if (pruebita.contains(palabra)) {
                    aux = linea + 1;
                    System.out.print(aux + ". ");
                    for (int i = 0; i < vector.length; i++) {
                        if (vector[i].contains(palabra)) {
                            if (vector[i].length() == palabra.length()) { // si la palabra tiene la extension de luna
                                                                          // por ej
                                System.out.print("\u001B[32m" + palabra + "\u001B[0m" + " ");
                            } else {
                                recorta = vector[i];
                                int j = 0;
                                while (j < recorta.length()) {
                                    if (recorta.charAt(j) == palabra.charAt(0)) {
                                        System.out.print("\u001B[32m" + palabra + "\u001B[0m");
                                        j += palabra.length();
                                    } else {
                                        System.out.print(recorta.charAt(j));
                                        j++;
                                    }
                                }
                                System.out.print(" ");
                            }
                        } else {
                            System.out.print(vector[i] + " ");
                        }
                    }
                    System.out.println();
                }
                linea++;
                pruebita = entrada.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Debe ingresar el fichero y una palabra a buscar");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}