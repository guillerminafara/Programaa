import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class preguntas {
    Connection con = null;

    preguntas() {
        con = Conexion.gConexion();
    }

    void leerPregunta(String num) {
        try {
            ResultSet rs = null;
            String sql = "Select * from PREGUNTA where idPregunta=?";
            String devolver = "";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, num);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(devolver = rs.getString("Enunciado"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    void leerRespuesta(){

    }

    void crearRespuesta(String respuesta) {
        try {
            String sql = "INSERT INTO RESPUESTA values(?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, 14);
            ps.setString(2, respuesta);
            System.out.println("Respuesta agregada correctamente");
        } catch (SQLException e) {

            e.printStackTrace();
        }

    }
}
