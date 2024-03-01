class PiezaMain {

    public static void main(String[] args) {
        Pieza p1 = new Pieza("cuadrado","rojo");
        Pieza p2 = new Pieza("cuadrado","rojo");
        Double d = new Double(1.0);
        String k = "Hola";
        boolean b1 = p1.equals(p2);
        boolean b2 = d.equals(k);
        boolean b3 = k.equals(p2);
        boolean b4 = p1.equals(d);
    }

}

public class Pieza {

    private String forma;
    private String color;
    private String nombre;

    Pieza(String forma, String color){
        this.forma= forma;
        this.color= color;
    }
    public boolean equals(Object o) {
        Pieza p = (Pieza) o;
        return this.color.equals(p.color) &&
                this.nombre.equals(p.nombre) &&
                this.area() == p.area();
    }

    public double area() {
        return 1.2;
    }
}
