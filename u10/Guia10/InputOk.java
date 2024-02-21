import java.util.InputMismatchException;
import java.util.Scanner;

public class InputOk {
    public static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
       // leeInt();
        leeIntPos();

    }
    // a) Leer un número entero (LeeInt).
/* 
    public static void leeInt() {
        int num = 0;

        try {
            num = leer.nextInt();
            System.out.println("el número: " + num);
        } catch (InputMismatchException e) {
            System.out.println("Debe ingresar un número entero ");

        }

    }*/

    // b) Leer un número entero sólo positivo (LeeIntPos).
    public static void leeIntPos() {
        int num = 0;

        try {
            num = leer.nextInt();
            negativo(num);
        } catch (ExcepcionNegativos e) {
            System.out.println("Debe ingresar un positivo ");
            System.out.println(e.getMessage());

        }

    }



    // c) Leer un número entero en un rango determinado (LeeIntRango).
    public static void leeIntRango() {

    }

    // d) Leer un número real (LeeDou).
    public static void leeDou() {

    }

    // e) Leer un número real en un rango determinado (LeeDouRango).
    public static void leeDouRango() {

    }
    public static void negativo(int num) throws ExcepcionNegativos {
        if (num < 0) {
            throw new ExcepcionNegativos("Número negativo");
        }
    
    }

}



class ExcepcionNegativos extends Exception {
    public ExcepcionNegativos(String mensaje) {
        super(mensaje);
    }

}
