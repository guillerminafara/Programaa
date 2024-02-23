import java.util.InputMismatchException;
import java.util.Scanner;

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