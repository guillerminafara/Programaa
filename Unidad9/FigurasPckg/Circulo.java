public class Circulo extends Figura {

    public double radio;
    public final double PI=3.14;
    
 
    public Circulo(double radio) {
        this.radio = radio;
    }
    public double getRadio() {
        return radio;
    }


    public void setRadio(double radio) {
        this.radio = radio;
    }


    public double getPI() {
        return PI;
    }


    @Override
    public String toString() {
        return "Circulo";
    }
    public double area(){

        //área (PI * radio * radio) - 
        return (PI * radio * radio);
    }


    public double perimetro(){
      //  perímetro (2 * PI * radio);

        return (2*PI*radio);
       
    }
}
