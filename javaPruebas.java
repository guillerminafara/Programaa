import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 * DecimalFormat forma= new DecimalFormat("#,###.00")
 */
public class javaPruebas {
    public static void main(String[] args) {
        // LocalDateTime ld = LocalDateTime.now();
        // //DayOfWeek diaa = hoy.getDayOfWeek();
        // int dia= ld.getDayOfMonth();
        // Month mes =ld.getMonth();

        // Locale espa = new Locale("es", "ES");
        // System.out.println(ld);
        // System.out.println(mes.getDisplayName(TextStyle.FULL, espa));
        // String mayus= mes.getDisplayName(TextStyle.FULL, espa);
        // mayus= mayus.toUpperCase();
        // String clave= mayus.substring(0,3);
        // System.out.println(clave);
        // System.out.println(dia);
        // clave+= dia;
        // System.out.println(clave);

        LocalDateTime ahora = LocalDateTime.now();
      String hora = ahora.getHour()+"";
      if(hora.length()<2){
          hora="0"+hora;
      }
       // LocalDateTime nueva =ahora.plus(12);
        //System.out.println(nueva);
        System.out.println(hora);
        System.out.println(ahora);
    }

}