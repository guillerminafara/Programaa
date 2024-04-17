module agenda {
    requires javafx.controls;
    requires javafx.fxml;
    requires mysql.connector.j;

    opens agenda to javafx.fxml;
    exports agenda;

}
