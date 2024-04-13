import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class prueba {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        String url = "jdbc:mysql://localhost:3306/reservas";
        String user = "root";
        String password = "";
        try {
           // Class.forName("com.mysql.jdbc.Driver");
           // Class.forName("com.ibm.db2.jcc.DB2Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();
          
            ResultSet rs = st.executeQuery("Select * from vuelos");
      
            
            while (rs.next()) {
                String codi = rs.getString("id_vuelo");
                //String apellido = rs.getString("COGNOM");
                // String apellido= rs.getString("COGNOM");
                // String especialidad= rs.getString("ESPECIALITAT");

                // String nombre = rs.getString("Nom");
                // int codi= rs.getInt("CodiActor");
                // System.out.println(nombre);
                System.out.println( codi);
            }
          
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
