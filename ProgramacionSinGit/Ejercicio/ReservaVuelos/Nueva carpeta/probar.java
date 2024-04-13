import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class probar {
    // static String url = "jdbc:mysql://localhost/reservas";
    // static String user = "root";
    // static String password = "";
    try{
        Connection con = null;
        con = DriverManager.getConnection("jdbc:mysql://localhost/reservas", "root", "");
    }catch(SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    public static void main(String[] args) {
        
        String sql = "Select * from vuelos";
        PreparedStatement ps= con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
       String id= rs.getString("id_vuelo");
       
    }

}