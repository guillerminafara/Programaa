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
                            String[] vector2 = vector[i].split(palabra); // le quito a la pabra larga luna

                            // String lala= vector[i];
                            // recorta
                            // System.out.println( "leyendo recortre"+ recorta);
                            // System.out.println("recortado" + recortar(recorta));
                            // recorta = recortar(recorta);
                            // if(vector[i].length()> palabra.length()){

                            // }

                            // vector[i].indexOf(palabra);
                            if (vector[i].length() == palabra.length()) {
                                // System.out.print("\u001B[32m" + palabra + "\u001B[0m" );
                                // System.out.println("señal del destino");
                                System.out.print("\u001B[32m" + palabra + "\u001B[0m" + " ");
                            } else {
                                recorta = Arrays.toString(vector2);
                                recorta = recortar(recorta);
                              //  System.out.println(recorta);
                                System.out.print("\u001B[32m" + palabra + "\u001B[0m" + recorta+" ");
                                if (vector[i].indexOf(palabra) == 0) { // si el vector comienza con luna

                                }
                                for (int j = 0; j < vector.length; j++) {

                                    // }else if (vector[i].indexOf(palabra) > 0){
                                    // // System.out.println("prueba "+ vector[i].indexOf(palabra));
                                    // System.out.print("\u001B[32m" + vector[i] + "\u001B[0m");
                                    // System.out.print(vector2[vector[i].indexOf(palabra)]);

                                    // // if (vector[i].indexOf(palabra) == j) {
                                    // // System.out.print("\u001B[32m" + vector[i] + "\u001B[0m" + " ");
                                    // //}
                                    // }
                                }

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
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static String recortar(String recorta) {
        for (int j = 0; j < recorta.length(); j++) {
            recorta.trim();
          //  System.out.println("estoy funcionnando");
            if (recorta.contains("[")) {
                recorta = recorta.replace("[", "");
            }
            if (recorta.contains("]")) {
                recorta = recorta.replace("]", "");
            }
            if (recorta.contains(",")) {

                recorta = recorta.replace(",", "");
            }
            if (recorta.contains(" ")) {

                recorta = recorta.replace(" ", "");
            }
        }
        return recorta;
    }

    public void orderna(String palabra, String[] vector, int i, String recorta) {
        vector[i].indexOf(palabra);
        System.out.println("indice " + vector[i].indexOf(palabra));
        for (int j = i; j < vector.length; j++) {
            // if(vector){
            System.out.print(vector[j]);
            // }

        }
        if (vector[i].indexOf(palabra) == 0) {
            System.out.print("\u001B[32m" + palabra + "\u001B[0m" + recorta + " ");
        } else {
            System.out.print(recorta + "\u001B[32m" + palabra + "\u001B[0m" + " ");
        }
    }
}