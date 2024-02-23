import java.util.InputMismatchException;
import java.util.Scanner;

public class InputOk {
    public static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        // int num = 0;
        // num = leer.nextInt();

        /*
          try {
          leeInt();
          } catch (Exception e) {
          System.out.println(e.getMessage());
          }
         */

        /*
          try {
          
          leeIntPos();
          
          } catch (Exception e) {
          System.out.println(e.getMessage());
          }
         */
        //

        /*try {
            leeIntRango();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }*/

    
    /*      try {
          System.out.println(leeDou());
          } catch (Exception e) {
          System.out.println(e.getMessage());
          }
 */         

          try {
            System.out.println(leeDouRango());
          } catch (Exception e) {
            System.out.println(e.getMessage());
          }
    }
    // a) Leer un número entero (LeeInt).

    public static void leeInt() throws InputMismatchException {
        int num = 0;

        try {
            System.out.println("ingrese un número entero");
            num = leer.nextInt();
            System.out.println("el número: " + num);
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Debe ingresar un número entero ");

        }

    }

    // b) Leer un número entero sólo positivo (LeeIntPos).
    public static int leeIntPos() throws ExcepcionNegativos {
        int num;
        try {
            System.out.println("ingrese un número entero positivo");
            num = leer.nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Debes ingresar un número");
        }
        if (num < 0) {
            throw new ExcepcionNegativos("Número negativo");
        }
        return num;
    }

    // c) Leer un número entero en un rango determinado (LeeIntRango).
    public static int leeIntRango() throws FueraRangoExcepcion, InputMismatchException {
        int num = 0;
        try {
            System.out.println("ingrese un número entero entre 0 y 100");
           num = leer.nextInt();
        
            if (num > 100 || num < 0) {
                throw new FueraRangoExcepcion("Número fuera de rango");
            }
            return num; 
        } catch ( InputMismatchException e) {
            throw new InputMismatchException("Debe ingresar números");
        }
        
            
    }

    // d) Leer un número real (LeeDou).
    public static double leeDou() throws InputMismatchException {
        System.out.println("ingresa un número decimal");
        // double numd = 0;

        // numd = leer.nextDouble();

        try {
            double numd = leer.nextDouble();
            return numd;
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Debe ingresar un número decimal");
        } 

    }

    // e) Leer un número real en un rango determinado (LeeDouRango).
    public static double leeDouRango() throws FueraRangoExcepcion, InputMismatchException {
        double num=0;
        try {
            System.out.println("ingrese un número decimal entre 25 y 50");
            num=leer.nextDouble();
            if(num>50.1|| num <= 24.99){
                throw new FueraRangoExcepcion("Número fuera de rango");
            }
            return num;
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Debe ingresar un número decimal");
        }
    }

   
}// fin clase InputOK comienzo de otras clases






 // ----------------------------------------------------------------------

class ExcepcionNegativos extends Exception {
    public ExcepcionNegativos(String mensaje) {
        super(mensaje);
    }

}

class FueraRangoExcepcion extends Exception {
    public FueraRangoExcepcion(String mensaje) {
        super(mensaje);
    }

}