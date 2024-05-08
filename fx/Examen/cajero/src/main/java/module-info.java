module com.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens cajero to javafx.fxml;
    exports cajero;
}
