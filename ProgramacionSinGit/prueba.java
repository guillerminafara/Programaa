import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * prueba
 */
public class prueba {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:33006/sanitat";
        String user = "root";
        String password = "paquito2024";
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();
            // ResultSet rs= st.executeQuery("select * from ACTOR");
            ResultSet rs = st.executeQuery("SELECT * FROM DOCTOR where COGNOM like '%Miller%'");
          
            while (rs.next()) {
                int codi = rs.getInt("DOCTOR_NO");
                String apellido = rs.getString("COGNOM");
                // String apellido= rs.getString("COGNOM");
                // String especialidad= rs.getString("ESPECIALITAT");

                // String nombre = rs.getString("Nom");
                // int codi= rs.getInt("CodiActor");
                // System.out.println(nombre);
                System.out.println(apellido + codi);
            }
          
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
        }

    }

}