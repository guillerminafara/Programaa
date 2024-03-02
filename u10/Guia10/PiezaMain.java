public class PiezaMain {

    public static void main(String[] args) {
        Pieza p1 = new Pieza("cuadrado","rojo");
        Pieza p2 = new Pieza("cuadrado","rojo");
        Double d = Double.valueOf(1.0);
        String k = "Hola";
        boolean b1 = p1.equalos(p2); // p2 usa el metodo equaloscreado en la clase
        boolean b2 = d.equals(k); //d k y p1 usan el metodo equals que heredan
        boolean b3 = k.equals(p2);
       boolean b4 = p1.equals(d); 
       

        System.out.printf(" %b \n %b \n %b \n %b \n ", b1, b2, b3, b4);
    }

}

 class Pieza {

    private String color;
    private String nombre;

    Pieza(String nombre, String color){
        this.nombre= nombre;
        this.color= color;
    }
    public boolean equalos(Object o) {
        Pieza p = (Pieza) o;
        return this.color.equals(p.color) &&
                this.nombre.equals(p.nombre) &&
                this.area() == p.area();
    }

    public double area() {
        return 1.2;
    }
}
