public class Hacha extends Arma{

    public Hacha(int danyoMax, int danyoMin) {
        super(danyoMax, danyoMin);
        //TODO Auto-generated constructor stub
    }

    public Hacha(){
        super();
        this.danyoMax=5;
        this.danyoMin=1;
    }
    public int danyoArma(){
        int devolver;
        devolver= (int) ((Math.random()*danyoMax)+danyoMin);
        return devolver;
    }
}
