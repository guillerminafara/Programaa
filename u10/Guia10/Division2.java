import java.util.InputMismatchException;
import java.util.Scanner;

public class Division2 {
    public static void main(String[] args) {
              Scanner leer = new Scanner(System.in);
        int num;
        int num2;
        int resultado;
        try {
            System.out.println("ingrese 2 números ");
            num = leer.nextInt();
            num2 = leer.nextInt();
            resultado = num / num2;

        } catch (InputMismatchException e) {
            System.out.println("Debe ingresar un número entero ");
        }catch(ArithmeticException e){
            System.out.println("No puedes dividir por 0");
        }catch(Exception e){
            System.out.println("Hubo porblemas para hacer la división estamos tratando de solucionarlo ");
        }
    }
}
