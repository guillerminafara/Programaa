package entidades;

import java.sql.PreparedStatement;

public class Empleados {
    private int idEmpleado;
    private String nombre;
    private String apellido;
    private String telefono;
    private String fechaNac;
    private String cargo;

    private Connection con = null;

    public Empleados() {
        con = Conexion.getConexion();

    }

    
    public Empleados(String nombre, String apellido, String telefono, String fechaNac, String cargo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.fechaNac = fechaNac;
        this.cargo = cargo;
        con = Conexion.getConexion();
    }


    public int getIdEmpleado() {
        return idEmpleado;
    }
    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getFechaNac() {
        return fechaNac;
    }
    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void mostrar(){
        String sql = "Select * from empleados where idempleados=?";
        PreparedStatement ps =con.
    }
    

}
