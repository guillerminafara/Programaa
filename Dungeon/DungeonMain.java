import java.util.Scanner;

/**
 * DungeonMain
 */
public class DungeonMain {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int aux = 0;

        String nombre;
        String arma;
        Arma armaa;
        int[] pasillo = new int[40];
        System.out.println("DUNGEON CRAWLER");
        System.out.println("Elije tu personaje: \n 1.Mago \n 2.Guerrero \n 3.Enano");
        String personaje = leer.nextLine();
        System.out.println("Escoge un arma: 1. Espada \n 2.Arco \n 3.Hacha \n 4.Hechizo");
        arma = leer.nextLine();
        if (personaje.equals("1") || personaje.equalsIgnoreCase("mago")) {
            aux = 1;
        } else if (personaje.equals("2") || personaje.equalsIgnoreCase("guerrero")) {
            aux = 2;
        } else if (personaje.equals("3") || personaje.equalsIgnoreCase("Enano")) {
            aux = 3;
        } else {
            aux = (int) ((Math.random() * 3) + 1);
            System.out.println("Se te ha asignado un personaje por defecto..");
        }
        if (arma.equals("1") || arma.equalsIgnoreCase("espada")) {
            arma = "1";
        } else if (arma.equals("2") || arma.equalsIgnoreCase("Arco")) {
            arma = "2";
        } else if (arma.equals("3") || arma.equalsIgnoreCase("Hacha")) {
            arma = "3";
        } else if (arma.equals("4") || arma.equalsIgnoreCase("Hechizo")) {
            arma = "4";
        } else {
            System.out.println("arma asignada por defecto ");
            arma = "1";
        }
  

        switch (arma) {
            case "1":
       
           armaa=  new Espada(3, 1);
                break;
            case "2":
           armaa =new Arco(2, 1);
                break;
            case "3":
          armaa=  new Hacha(4, 0);
                break;
            case "4":
           armaa= new Hechizo(5,1);
                break;

        }
        switch (aux) {
            case 1:
                System.out.println("Tu personaje: Mago... \n Ponle un nombre: ");
                nombre = leer.nextLine();
                new Mago(nombre, armaa);
                break;
            case 2:
                System.out.println("Tu personaje: Guerrero... \n Ponle un nombre: ");
                nombre = leer.nextLine();
                break;
            case 3:
                System.out.println("Tu personaje: Enano ... \n Ponle un nombre: ");
                nombre = leer.nextLine();
                break;

        }
    }

    public int[] rellenarVector(int[] pasillo) {
        for (int i = 0; i < pasillo.length; i++) {
            pasillo[i] = i;
        }

        return pasillo;
    }
}