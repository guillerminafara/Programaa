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
            int cont = 0;
            File ficherito = new File(texto);
            FileReader fichero = new FileReader(ficherito);
            BufferedReader entrada = new BufferedReader(fichero);
            String pruebita = entrada.readLine();
            // String[] vector = pruebita.split(" ");
            int linea = 0;
            int aux = 0;
            String recorta = "";
            while (pruebita != null) {
                String[] vector = pruebita.split(" ");
                // System.out.println(pruebita);

                if (pruebita.contains(palabra)) {
                    cont++;
                    aux = linea + 1;
                    // leyendo(aux, pruebita, palabra);
                    System.out.print(aux + ". ");
                    for (int i = 0; i < vector.length; i++) {

                        if (vector[i].contains(palabra)) {
                          //.  recorta = Arrays.toString(vector[i].split(recorta));
                           
                           //System.out.println( "leyendo recortre"+ recorta);
                            // recortar(recorta);
                            System.out.print("\u001B[32m" + palabra + recorta + "\u001B[0m" + " ");

                            //vector[i].indexOf(palabra);

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
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String recortar(String recorta) {
        for (int j = 0; j < recorta.length(); j++) {
            recorta.trim();
            if (recorta.charAt(j) == '[') {
                recorta = recorta.replace("[", "");
            }
            if (recorta.charAt(j) == ']') {
                recorta = recorta.replace("]", "");
            }
            // if (recorta.charAt(j) == ',') {

            // recorta = recorta.replace(",", "");
            // }
        }
        return recorta;
    }
}