import java.util.InputMismatchException;
import java.util.Scanner;
/*
 * Modifica el programa anterior para que la excepción de la división entre 0 se traslade a un
subprograma que se llamará desde el programa principal.
Para ello, acuérdate que este subprograma tendrá un bloque try-catch donde hará la
división y, en caso de producirse la excepción, incluirá la palabra reservada “throw” en el
cuerpo del subprograma y “throws” en la cabecera para indicar al programa principal que el
módulo ha fallado.
 */
public class Throws {
    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            
            System.out.println(otroPrograma());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static int otroPrograma() throws InputMismatchException, Exception, ArithmeticException {
        int resultado;
        int num;
        int num2;

        try {
            System.out.println("ingrese 2 números ");
            num = leer.nextInt();
            num2 = leer.nextInt();
            resultado = num / num2;
            return resultado;
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Debe ingresar un número entero ");

        } catch (ArithmeticException e) {
            throw new ArithmeticException("No se puede dividir por 0 :c");
        } catch (Exception e) {
            throw new Exception("Hubo porblemas para hacer la división estamos tratando de solucionarlo ;)");
        }

    }

}