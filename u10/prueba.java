import javax.swing.JOptionPane;

/**
 * prueba
 */
public class prueba {

    public static void main(String[] args) {
        // JOptionPane.showMessageDialog(null, "hola");
        int[] numbers = { 1, 2, 3, 4 };
        try {
            System.out.println(numbers[10]);
        } catch (Exception e) {
          //  System.out.println("Ha ocurrido un error " +e.getMessage());
            System.out.println(e);
        }
    }
}