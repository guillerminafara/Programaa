

import java.io.File;
import java.io.IOException;

/**
 * 1. Crear un programa en java (llamado rmj) que permita borrar un
 * fichero pasándole el nombre del fichero como argumento. El script
 * tendrá la forma:
 * java rmj fichero.txt
 * El programa debe comprobar errores como que el fichero no exista
 * o que sea un directorio.
 */
public class rmj {
    public static void main(String[] args) {
        try {
            String fichero = args[0];
           // System.out.println(fichero);

            File file = new File(fichero);
            if (file.exists()) {
                if (file.isDirectory()) {
                    System.out.println("No es posible eliminar carpetas/directorios");
                } else if (file.delete()) {
                    System.out.println("Fichero eliminado: " + file.getName());
                } 
            }else{
                System.out.println( "El fichero no ha sido encontrado");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No ha ingresado ningún fichero");
        }
    }

}