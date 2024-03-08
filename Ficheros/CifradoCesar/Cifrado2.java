/*Realiza otro programa que permita descifrar los códigos César. En este caso sólo se le pasa un
argumento con el nombre del archivo encriptado y por la extensión se deducirá que
desplazamiento se le ha aplicado y guardará el archivo descifrado.
> descifrado prueba.cf2 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Cifrado2 {
    public static void main(String[] args) {
        String nombre= args[0];
        String n= nombre.substring(nombre.length()-1);
        int num= Integer.parseInt(n);
        File f= new File(nombre);
        
        try {
            FileReader fr= new FileReader(f);

          FileWriter fw = new FileWriter("descifrado.txt");
            fw.write(descifrado(fr, num));
            fw.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }// fin main
    public static String descifrado(FileReader fr, int num) throws IOException {
        int aux = 0;
        String devolver = "";

        try {
            while ((aux = fr.read()) != -1) {
                devolver += (char) (aux - num) + "";
            }
            fr.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return devolver;
    }
}// fin clase
