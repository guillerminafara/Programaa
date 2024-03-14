import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class insert {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:33006/videoclub";
        String user = "root";
        String password = "paquito2024";
        String sql= "insert into ACTOR values(?,?)";
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, 3);
            ps.setString(2, "Jeffrey Epstein");
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void conexion() {
   

    }

    public void buscar() {

    }

    public void agregar() {

    }
}
