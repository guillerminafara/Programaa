public class Arco extends Arma {

    public Arco(int danyoMax, int danyoMin) {
        super(danyoMax, danyoMin);
        // TODO Auto-generated constructor stub
    }

    public Arco() {
        super();
        this.danyoMax=4;
        this.danyoMin=3;
    }

    public int danyoArma() {
        int devolver;
        devolver = (int)((Math.random()*danyoMax)+danyoMin);
        return devolver;

    }

    @Override
    public String toString() {
        return "Arco []";
    }
}
