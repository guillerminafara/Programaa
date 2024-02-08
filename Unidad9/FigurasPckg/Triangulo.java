public class Triangulo extends Figura{
    public double base;
    public double altura;
    public double lado;

    public Triangulo(double base, double altura) {
      this.base = base;
      this.altura = altura;
    }

    
    public double getBase() {
      return base;
    }


    public void setBase(double base) {
      this.base = base;
    }


    public double getAltura() {
      return altura;
    }


    public void setAltura(double altura) {
      this.altura = altura;
    }

    @Override
    public String toString() {
        return "Triangulo";
    }
    public double area(){
      //  área((base * altura) / 2) - 
        return((base*altura)/2);
       
    }

    public double perimetro(){
      //  perímetro (suponemos isósceles – usar Pitágoras)
      //a2 + b2 = c2
      double aux= base/2;
      double devolver= (altura*altura)+(aux* aux);
      lado=Math.sqrt(devolver);

        return base+lado+lado;
       
    }

}
