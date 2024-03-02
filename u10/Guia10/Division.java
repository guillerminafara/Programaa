import java.util.Scanner;

/**
Crea un programa que intente realizar en el main una división entre 2 números enteros
introducidos por teclado y que capture cualquier tipo de excepción (por ejemplo, que el
usuario no teclee números enteros o que el denominador sea distinto de 0).
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