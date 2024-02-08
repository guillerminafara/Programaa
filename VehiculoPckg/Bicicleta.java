/**
 * Bicicleta
 */
public class Bicicleta extends Vehiculo {

   
    Bicicleta(int kilometrosTotales, int kilomerosRecorridos, Vehiculo vehiculosCreados) {

        super(kilometrosTotales, kilomerosRecorridos, vehiculosCreados);
        
        //getVehiculosCreados();
    }
    Bicicleta(){
        setVehiculosCreados(this);
    }

    @Override
    public int andaEn( int kilom) {
       kilom+=  getKilomerosRecorridos();
   
       setKilomerosRecorridos(kilom);
       setKilometrosTotales(kilom);
        return kilom;
    }
    @Override
    public String toString() {
        return "hola soy la bici y he recorrido: "+ getKilomerosRecorridos()+ " kilómetros";//"kilómetros recorridos por ";
    }



}