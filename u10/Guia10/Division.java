import java.util.Scanner;

/**
 * Division
 */
public class Division {

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

        } catch (Exception e) {
            System.out.println("Problemas con la division");
        }
    }
}