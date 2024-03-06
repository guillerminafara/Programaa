import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Grepj
 */
public class Grepj {

    public static void main(String[] args) {
        try {
            String texto = args[0];
            String palabra = args[1];
            int cont = 0;
            File ficherito = new File(texto);
            FileReader fichero = new FileReader(ficherito);
            BufferedReader entrada = new BufferedReader(fichero);
            String pruebita = entrada.readLine();
            String[] vector = pruebita.split(" ");
            int linea = 0;
            int aux = 0;
            while (pruebita != null) {
                // System.out.println(pruebita);

                if (pruebita.contains(palabra)) {
                    cont++;
                    aux = linea + 1;
                    // leyendo(aux, pruebita, palabra);
                    System.out.print(aux + ". ");
                    for (int i = 0; i < vector.length; i++) {

                        if (vector[i].contains(palabra)) {
                            System.out.print("\u001B[32m" + palabra + "\u001B[0m"+ " ");
                        }else{
                            System.out.print(vector[i]+ " ");
                        }
                        
                    }
                    System.out.println();
                }

                linea++;
                pruebita = entrada.readLine();
            }

            // for (int i = 0; i < cont; i++) {
            // String devolucion = " " + pruebita;
            // System.out.println(devolucion);

            // }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void leyendo(int aux, String pruebita, String palabra) {

    }
}