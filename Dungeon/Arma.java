public class Arma {
    int danyoMax;
    int danyoMin; //=1

public Arma(int danyoMax, int danyoMin) {
        this.danyoMax = danyoMax;
        this.danyoMin = danyoMin;
    }

    public Arma() {
}

    //Cuando se utilice el arma para atacar se usará un método danyoArma() que devuelve un valor 
//aleatorio entre danyomin y danyomax.
    public int danyoArma(){
        return 1;
    }
}
