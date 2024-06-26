package entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import agenda.PrimaryController;

public class Empleados {
    private int idEmpleado;
    private String nombre;
    private String apellido;
    private String telefono;
    private String fechaNac;
    private String cargo;

    Connection con = Conexion.getConexion();

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

    public void mostrar(int i) {
        Empleados empleado = new Empleados();
        String sql = "Select * from empleados where idempleados=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, i);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                empleado.setIdEmpleado(i);
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellido(rs.getString("apellido"));
                empleado.setTelefono(rs.getString("telefono"));
                empleado.setFechaNac(rs.getString("fechaNac"));
                empleado.setCargo(rs.getString("cargo"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
            System.out.println("esta nullo");
        }

    }


    

    
    public int totalidad() {
        String sql = "SELECT * FROM empleados ORDER BY idempleados DESC LIMIT 1";
        int i = 0;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                i = rs.getInt("idempleados");
                System.out.println("esta bien");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("error en metodo totalidad");
        }
        return i;
    }

}
