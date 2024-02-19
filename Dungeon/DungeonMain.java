import java.util.Scanner;

/**
 * DungeonMain
 */
public class DungeonMain {
    public static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        String arma;
        int[] pasillo = new int[40];
        System.out.println("DUNGEON CRAWLER");
        System.out.println("Elije tu personaje: \n 1.Mago \n 2.Guerrero \n 3.Enano");
        String personaje = leer.nextLine();
        System.out.println("Escoge un arma: 1. Espada \n 2.Arco \n 3.Hacha \n 4.Hechizo");
        arma = leer.nextLine();
        Heroe heroe = creaHeroe(personaje, arma);
        Monstruo mostro= creaMonstruo();
        Monstruo mostro2= creaMonstruo();
        Monstruo mostro3= creaMonstruo();
        int i=0;
        boolean batalla=false;
        do {
            if(pasillo[i]==mostro.getPosicion() ){
                batalla=true;
            }else{
                i++;
            }
                
        }while(i< pasillo.length && heroe.getPuntosVida()<0 );
       
    } // fin main

    public int[] rellenarVector(int[] pasillo) {
        for (int i = 0; i < pasillo.length; i++) {
            pasillo[i] = i;
        }

        return pasillo;
    }

    public static Arma crearArma(String arma) {
        Arma armaa = null;
        if (arma.equalsIgnoreCase("espada")) {
            arma = "1";
        } else if (arma.equalsIgnoreCase("Arco")) {
            arma = "2";
        } else if (arma.equalsIgnoreCase("Hacha")) {
            arma = "3";
        } else if (arma.equalsIgnoreCase("Hechizo")) {
            arma = "4";
        } else {
            System.out.println("arma asignada por defecto ");
            arma = "1";
        }
        switch (arma) {
            case "1":

                armaa = new Espada();
                break;
            case "2":
                armaa = new Arco();
                break;
            case "3":
                armaa = new Hacha();
                break;
            case "4":
                armaa = new Hechizo();
                break;

        }
        return armaa;
    }

    public static Monstruo creaMonstruo() {
        int num = (int) ((Math.random() * 4) + 1);
        Monstruo mostro = null;
        Arma arma = null;
        String aux = String.valueOf(num);

        num = (int) ((Math.random() * 3) + 1);

        switch (num) {
            case 1:
                mostro = new Orco("Grom", crearArma(aux));

                break;
            case 2:
                mostro = new Dragon("Fafnir", crearArma(aux));
                break;
            case 3:
                mostro = new Zombie("Carlos", crearArma(aux));
                break;
        }
        return mostro;
    }

    public static Heroe creaHeroe(String personaje, String arma) {
        int aux = 0;
        String nombre;
        Heroe heroe = null;
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

        switch (aux) {
            case 1:
                System.out.println("Tu personaje: Mago... \n Ponle un nombre: ");
                nombre = leer.nextLine();
                heroe = new Mago(nombre, crearArma(arma));
                break;
            case 2:
                System.out.println("Tu personaje: Guerrero... \n Ponle un nombre: ");
                nombre = leer.nextLine();
                heroe = new Guerrero(nombre, crearArma(arma));
                break;
            case 3:
                System.out.println("Tu personaje: Enano ... \n Ponle un nombre: ");
                nombre = leer.nextLine();
                heroe = new Enano(nombre, crearArma(arma));
                break;

        }
        return null;
    }

    public static boolean batalla () {
     
    
        
        return false;
    }
    public void posicio(Monstruo mostro){
        if(mostro.getPosicion()== mostro2.getPosicion){
            mostro2.setPosicion;
        }else if(mostro.getPosicion()== mostro3.getPosicion()){


        }
    }
}// fin clase