public class Espada extends Arma{

    public Espada(int danyoMax, int danyoMin) {
        super(danyoMax, danyoMin);
        //TODO Auto-generated constructor stub
    }
    public Espada(){
        super();
        this.danyoMax=4;
        this.danyoMin=3;
    }
    public int danyoArma(){
        int devolver;
        devolver= (int) ((Math.random()*danyoMax)+danyoMin);
        return devolver;
    }
}
