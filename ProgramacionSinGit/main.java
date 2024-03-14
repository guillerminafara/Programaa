import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        preguntas pregunta = new preguntas();
        for (int i = 1; i <17; i++) {
            String num= Integer.toString(i);
            pregunta.leerPregunta(num);
        }
       
    }
}
