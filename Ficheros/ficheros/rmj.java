package ficheros;

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
            System.out.println(fichero);

            File file = new File(fichero);
            if (file.exists()) {
                if (file.isDirectory()) {
                    System.out.println("no es posible eliminar carpetas");
                } else if (file.delete()) {
                    System.out.println("Fichero eliminado: " + file.getName());
                } else {
                    System.out.println("Fichero ya eliminado");
                }
            }else{
                System.out.println("no ha ingresado ningún fichero");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}