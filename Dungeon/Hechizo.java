public class Hechizo extends Arma {

    public Hechizo(int danyoMax, int danyoMin) {
        super(danyoMax, danyoMin);
        //TODO Auto-generated constructor stub
    }

    public Hechizo(){
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
