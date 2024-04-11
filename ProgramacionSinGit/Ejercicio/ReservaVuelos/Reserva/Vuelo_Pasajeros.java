package Reserva;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.x.protobuf.MysqlxNotice.Warning.Level;

public class Vuelo_Pasajeros {
    private String id_vuelo;

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    private int id_pasajero;
    private int id_reserva;
    Vuelos vuelo;
    Pasajeros pasajero;

    private int n_asiento;

    private Connection con = null;

    Vuelo_Pasajeros() {
        con = Conexion.gConexion();
    }

    public String getId_vuelo() {
        return id_vuelo;
    }

    public void setId_vuelo(String id_vuelo) {
        this.id_vuelo = id_vuelo;
    }

    public int getId_pasajero() {
        return id_pasajero;
    }

    public void setId_pasajero(int id_pasajero) {
        this.id_pasajero = id_pasajero;
    }

    public int getN_asiento() {
        return n_asiento;
    }

    public void setN_asiento(int n_asiento) {
        this.n_asiento = n_asiento;
    }

    @Override
    public String toString() {
        Pasajeros pasajero = new Pasajeros();
        pasajero = pasajero.buscarPasajerosPorId(id_pasajero);
        return " Codigo vuelo: " + id_vuelo + "\n Nombre: " + pasajero.getNombre_pasajero() + "\n Pasaporte: "
                + pasajero.getPasaporte() + "\n Número de asiento: " + n_asiento;
    }

    // true= asiento ocupado false= asiento disponible
    public boolean buscarAsientos(int numAsiento, String id_Vuelo) {
        String sql = "SELECT * FROM vuelos_pasajeros where n_asiento=? and id_Vuelo=?";
        boolean ocupado = false;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, numAsiento);
            ps.setString(2, id_Vuelo);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("asiento ocupado");
                ocupado = true;
            } else {
                System.out.println("asiento disponible");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ocupado;
    }

    public void reservarViaje(String id_vuelo, int id_Pasajero, int n_asiento) {
        try {
            Vuelo_Pasajeros reserva = new Vuelo_Pasajeros();
            String sql = "INSERT INTO vuelos_pasajeros (id_pasajero, id_vuelo, n_asiento)values(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id_Pasajero);
            ps.setString(2, id_vuelo);

            ps.setInt(3, n_asiento);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                System.out.println("Reserva creada con exito. Código de reserva: " + id);
                System.out.println(buscarReserva(id));
            }

        } catch (SQLException ex) {
            System.out.println("error en datos en la tabla" + ex);
        }
    }

    public Vuelo_Pasajeros reservarVuelo(String pasaporte) {
        Vuelo_Pasajeros reserva = new Vuelo_Pasajeros();
        pasajero = pasajero.buscarPasajeros(pasaporte);
        if (pasajero != null) {

            System.out.println("pasajero existe" + pasajero);
        }
        return reserva;
    }

    public Vuelo_Pasajeros buscarReserva(int id) {
        Vuelo_Pasajeros reserva = null;
        try {
            String sql = "Select * from vuelos_pasajeros where id_reserva=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                reserva = new Vuelo_Pasajeros();
                reserva.setId_pasajero(rs.getInt("id_pasajero"));
                reserva.setId_vuelo(rs.getString("id_vuelo"));

                reserva.setN_asiento(rs.getInt("n_asiento"));
            }
        } catch (SQLException ex) {
            System.out.println("error al ingresar a la tabla ");
        }
        return reserva;
    }

    public void modificarReserva(Vuelo_Pasajeros reserva, int num_asientoo) {
        try {
            String sql = "UPDATE vuelos_pasajeros set n_asiento=? where id_reserva=?";
            PreparedStatement ps = con.prepareStatement(sql);
           
            pasajero = new Pasajeros();
            pasajero = pasajero.buscarPasajerosPorId(reserva.getId_pasajero());
          //  System.out.println("pasajeros "+pasajero);
            if (!buscarAsientos(num_asientoo, pasajero.getPasaporte())) {
                
                ps.setInt(1, num_asientoo);
               // System.out.println("NUM ASIENTO"+ num_asientoo);
                ps.setInt(2, reserva.getId_reserva());
                System.out.println("reserva"+ reserva.getId_reserva());
                int exito = ps.executeUpdate();
               // System.out.println("EEEEXITO"+exito);
                if (exito == 1) {
                    System.out.println("Modificado correctamente");
                   // System.out.println(buscarReserva(reserva.getId_reserva()));
                } else {
                    System.out.println("no se puede modificar el vuelo");
                }
            } else {
                System.out.println("no se puede ");
            }
        } catch (SQLException ex) {
            System.out.println("error al ingresar a la tabla ");
        } // catch (NullPointerException e) {
          // System.out.println("Ingresa un valor. Está nulaso");
          // }

    }

    public void eliminarReserva(int id_reserva) {
        try {
            String sql = "DELETE from vuelos_pasajeros where id_reserva=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_reserva);

            // int exito = ps.executeUpdate();
            if (ps.executeUpdate() == 1) {
                System.out.println("Eliminado con éxito");
            }
        } catch (SQLException ex) {

            System.out.println("Error al eliminar la reserva");
        }
    }
}
