module hotel {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;
    requires mysql.connector.j;
    opens hotel to javafx.fxml;
    exports hotel;
}
