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
            e.printStackTrace();
        }

    }

    PrimaryController control = new PrimaryController();

    public Empleados primero() {

        Empleados empleado = new Empleados();
        int i = 1;
        String sql = "Select * from empleados ";

        Statement ps;
        try {
            ps = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            // ps.setInt(1, i);
            ResultSet rs = ps.executeQuery(sql);
            rs.first();

            empleado.setIdEmpleado(i);
            empleado.setNombre(rs.getString("nombre"));
            empleado.setApellido(rs.getString("apellido"));
            empleado.setTelefono(rs.getString("telefono"));
            empleado.setFechaNac(rs.getString("fechaNac"));
            empleado.setCargo(rs.getString("cargo"));

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } // con.prepareStatement(sql);
        return empleado;
    }

    public Empleados ultimo() {
        Empleados empleado = new Empleados();
        int i = 1;
        String sql = "Select * from empleados ";

        Statement ps;
        try {
            ps = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            // ps.setInt(1, i);
            ResultSet rs = ps.executeQuery(sql);
            rs.last();

            empleado.setIdEmpleado(rs.getInt("idempleados"));
            empleado.setNombre(rs.getString("nombre"));
            empleado.setApellido(rs.getString("apellido"));
            empleado.setTelefono(rs.getString("telefono"));
            empleado.setFechaNac(rs.getString("fechaNac"));
            empleado.setCargo(rs.getString("cargo"));

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } // con.prepareStatement(sql);
        return empleado;
    }
    // public ResultSet mostrara(int i) {
    // Empleados empleado = new Empleados();

    // try {
    // // PreparedStatement ps = con.prepareStatement(sql);
    // ps.setInt(1, i);
    // ResultSet rs = ps.executeQuery();
    // if (rs != null) {
    // empleado.setIdEmpleado(i);
    // empleado.setNombre(rs.getString("nombre"));
    // empleado.setApellido(rs.getString("apellido"));
    // empleado.setTelefono(rs.getString("teléfono"));
    // empleado.setFechaNac(rs.getString("fechanac"));
    // empleado.setCargo(rs.getString("cargo"));
    // }
    // } catch (SQLException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }

    // }
    public Empleados siguiente(int i) {
        Empleados empleado = new Empleados();
        String sql = "Select * from empleados ";

        try {
            Statement ps = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery(sql);

            // System.out.println("totalidad "+ totalidad());
            // System.out.println(rs.getInt("idempleados"));

            // System.out.println(" ha llegado");
            if (rs.next()) {

                rs.absolute(i);
                rs.next();
                empleado.setIdEmpleado(rs.getInt("idempleados"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellido(rs.getString("apellido"));
                empleado.setTelefono(rs.getString("telefono"));
                empleado.setFechaNac(rs.getString("fechaNac"));
                empleado.setCargo(rs.getString("cargo"));
            }
        } catch (

        SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return empleado;

    }

    public Empleados anterior(int i) {
        Empleados empleado = new Empleados();
        String sql = "Select * from empleados ";

        try {
            Statement ps = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery(sql);

            i--;
            rs.absolute(i);
            rs.previous();
            empleado.setIdEmpleado(rs.getInt("idempleados"));
            empleado.setNombre(rs.getString("nombre"));
            empleado.setApellido(rs.getString("apellido"));
            empleado.setTelefono(rs.getString("telefono"));
            empleado.setFechaNac(rs.getString("fechaNac"));
            empleado.setCargo(rs.getString("cargo"));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return empleado;

    }

    public int totalidad() {
        String sql = "SELECT * FROM empleados ORDER BY idempleados DESC LIMIT 1";
        int i = 0;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                i = rs.getInt("idempleados");

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("error en metodo totalidad");
        }
        return i;
    }

}
