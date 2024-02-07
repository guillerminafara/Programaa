/**
 * TarjetaSimMain
 */
public class TarjetaSimMain {
    public static void main(String[] args) {
        TarjetaSIM t1 = new TarjetaSIM("678112233");
        TarjetaSIM t2 = new TarjetaSIM("644744469");
        TarjetaSIM t3 = new TarjetaSIM("622328909");
        TarjetaSIM t4 = new TarjetaSIM("664739818");
        System.out.println(t1);
        System.out.println(t2);
        t1.llama(t2, 320);
        t1.llama(t3, 200);
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
        System.out.println(t4);
    }

}