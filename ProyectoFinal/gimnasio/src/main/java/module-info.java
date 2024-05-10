module proyecto {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.graphics;

    opens proyecto to javafx.fxml;
    exports proyecto;
}
