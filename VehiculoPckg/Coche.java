public class Coche extends Vehiculo {

    Coche(){
        setVehiculosCreados(this);
    }
     
    Coche(int kilometrosTotales, int kilomerosRecorridos, Vehiculo vehiculosCreados) {
        super(kilometrosTotales, kilomerosRecorridos,vehiculosCreados);
  
    }

    public int andaEn(int kilom) {
        kilom+=  getKilomerosRecorridos();
   
        setKilomerosRecorridos(kilom);
        setKilometrosTotales(kilom);
         return kilom;
    }

    @Override
    public String toString() {
        return "hola soy el auto y he recorrido: "+ getKilomerosRecorridos()+ " kilómetros";
    }
  


}
