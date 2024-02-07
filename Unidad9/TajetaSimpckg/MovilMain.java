public class MovilMain {
    public static void main(String[] args) {
        Movil m1 = new Movil("678112233", "plata");
        Movil m2 = new Movil("644744469", "oro");
        Movil m3 = new Movil("622328909", "platinum");
        System.out.println(m1);
        System.out.println(m2);
        m1.llama(m2, 320);
        m1.llama(m3, 200);
        m2.llama(m3, 550);
        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m3);
    }
}
