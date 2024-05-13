package gym;

import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class EscReservaHorario implements Initializable {

    LocalDate ld = new LocalDate();
    static DateTimeFormatter fromater= DateTimeFormatter.ofPattern("dd-MM-aaaa");
     DayOfWeek diaa = fecha.getDayOfWeek();   

    @FXML
    private TableColumn<?, ?> ColuViernes;

    @FXML
    private DatePicker DatePickerB;
    @FXML
    private TableView<?> TablaHorarios;

    @FXML
    private TableColumn<?, ?> coluDomingo;

    @FXML
    private TableColumn<?, ?> coluJuev;

    @FXML
    private TableColumn<?, ?> coluLunes;

    @FXML
    private TableColumn<?, ?> coluMartes;

    @FXML
    private TableColumn<?, ?> coluMierc;

    @FXML
    private TableColumn<?, ?> coluSabado;

    @FXML
    private ImageView imagenLogo;
    @FXML
    private Label label;

    @FXML
    void DatePickerEvent(ActionEvent event) {

        label.setText(DatePickerB.getValue().toString());
    }

    @FXML
    void Selecciona(MouseEvent event) {

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub

    }

}
