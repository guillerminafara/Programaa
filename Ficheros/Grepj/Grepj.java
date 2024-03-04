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
            String palabra=args[1];
            int cont=0;
            File ficherito = new File(texto);
            FileReader fichero = new FileReader(ficherito);
            BufferedReader entrada = new BufferedReader(fichero);
            String[] pruebita = entrada.readLine().split(" ");
            System.out.println(Arrays.toString(pruebita));
            for (int i = 0; i < pruebita.length; i++) {
               if(pruebita[i].contains(palabra)){
                    cont++;
                }
            }
            for (int i = 0; i < cont; i++) {
                String devolucion= cont+" "+ pruebita[i];
                System.out.println(devolucion);
            }
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}