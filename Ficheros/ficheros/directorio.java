/*2. Crear un programa que a partir de un nombre pasado como
argumento diga si es un fichero o un directorio y muestre la ruta
absoluta, el tamaño y sus permisos */

import java.io.File;

public class directorio {
    public static void main(String[] args) {
        try {
            String nombre = args[0];
            File archivo = new File(nombre);
            if (archivo.isDirectory()) {
                System.out.printf("el archivo %s es un directorio\n su ruta absoluta es: %s \n Tamaño: %s \n",
                        archivo.getName(), archivo.getAbsolutePath(), archivo.getTotalSpace());

                System.out.println("Consta de los siguientes permisos:");
                System.out.printf(" Ejecución: %b\n Lectura: %b\n Escritura: %b\n", archivo.canExecute(),
                        archivo.canRead(),
                        archivo.canWrite());

            } else if (archivo.isFile()) {
                System.out.printf("el archivo %s es un fichero\n su ruta absoluta es: %s \n Tamaño: %s \n",
                        archivo.getName(), archivo.getAbsolutePath(), archivo.getTotalSpace());
                System.out.println("Consta de los siguientes permisos:");
                System.out.printf(" Ejecución: %b\n Lectura: %b\n Escritura: %b\n", archivo.canExecute(),
                        archivo.canRead(),
                        archivo.canWrite());
            }else{
                System.out.println( "El archivo no ha sido encontrado");
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No ha ingresado ningún fichero");
        }
    }
}
