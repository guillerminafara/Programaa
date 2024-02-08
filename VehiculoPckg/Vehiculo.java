
public abstract class Vehiculo {
    protected static Vehiculo vehiculosCreados;
    protected int kilometrosTotales;
    protected int kilomerosRecorridos;

    
    public Vehiculo() {
    }

    
    public Vehiculo(int kilometrosTotales, int kilomerosRecorridos, Vehiculo vehiculosCreados) {
        this.kilometrosTotales = kilometrosTotales;
        this.kilomerosRecorridos = kilomerosRecorridos;
        
    }


    public static Vehiculo getVehiculosCreados() {
        return vehiculosCreados;
    }
    public void setVehiculosCreados(Vehiculo vehiculosCreados) {
        this.vehiculosCreados = vehiculosCreados;
    }
    public int getKilometrosTotales() {
        return kilometrosTotales;
    }
    public void setKilometrosTotales(int kilometrosTotales) {
        this.kilometrosTotales = kilometrosTotales;
    }
    public int getKilomerosRecorridos() {
        return kilomerosRecorridos;
    }
    public void setKilomerosRecorridos(int kilomerosRecorridos) {
        this.kilomerosRecorridos = kilomerosRecorridos;
    }

    
    abstract int andaEn(int kilom);


}