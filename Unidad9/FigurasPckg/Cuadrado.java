public class Cuadrado extends Figura{
    public double lado;


    public Cuadrado(double lado) {
        this.lado = lado;
    }


    public double getLado() {
        return lado;
    }



    public void setLado(double lado) {
        this.lado = lado;
    }

    @Override
    public String toString() {
        return "Cuadrado";
    }

    public double area(){
        double devolver=0;
        devolver= lado*lado;
        return devolver;
    }

   

    public double perimetro(){
      //  perímetro (4 * lado)
        return (4 * lado);
       
    }




}
