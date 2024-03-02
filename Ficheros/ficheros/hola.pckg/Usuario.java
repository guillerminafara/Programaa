
/*
 * . Crear un programa que pida un nombre de usuario y contraseña
y lo guarde en un fichero con el formato:
<nombre>:<Contraseña>
Utiliza ese fichero para validar contraseñas. Crea un sistema que
pida el nombre de un usuario y su contraseña y valide si el nombre
existe y, en caso afirmativo, si la contraseña es correcta.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Usuario {
    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // File ficherito = new File("usuario.txt");
        // comprobarU(ficherito);
        File ficherito = crearFichero();
        if (ficherito != null) {
            comprobarU(ficherito);
        } else {
            System.out.println("no pudimos crear el ficherito ಠ_ಠ");
        }

    }

    public static File crearFichero() {
        String usuario = "";
        String pass = "";

        try {
            File ficherito = new File("usuario.txt");
            FileWriter fichero = new FileWriter(ficherito);
            System.out.println("CREANDO USUARIO. Ingresa el nombre de usuario: ");
            usuario = leer.nextLine();
            System.out.println("ingresa la contraseña");
            pass = leer.nextLine();
            fichero.write(usuario + ":" + pass + "\n");

            fichero.close();
            return ficherito;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    public static boolean comprobarU(File ficherito) {
        int i = 0;
        int j = 1;
        boolean bandera = false;
        boolean bandera2 = false;
        try {

            FileReader ficheroLeer = new FileReader(ficherito);
            BufferedReader br = new BufferedReader(ficheroLeer);
            String aux = br.readLine();
            String[] vector = aux.split(":");
            while (i < 3 && !bandera) {
                System.out.println("Ingresa tu usuario");
                String user = leer.nextLine();
                if (vector[0].equals(user)) {
                    bandera = true;

                    System.out.println("Ingresa tu contraseña");
                    String passw = leer.nextLine();

                    while (j < 3 && !bandera2) {
                        System.out.println("Ingresa tu contraseña");
                        passw = leer.nextLine();
                        if (vector[1].equals(passw)) {
                            bandera2 = true;
                            System.out.println("Bienvenido!");
                        } else {
                            j++;
                            System.out.println("contraseña invalida");

                        }
                    }
                } else {
                    i++;
                    System.out.println("Usuario invalido: ");
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }
}
